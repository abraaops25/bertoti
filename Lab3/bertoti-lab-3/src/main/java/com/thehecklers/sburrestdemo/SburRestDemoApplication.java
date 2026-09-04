package com.thehecklers.sburrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}
}

@Entity
class Pizza {
	@Id
	private String id;
	private String name;
	private BigDecimal price;
	private String category;

	protected Pizza() {
		// construtor vazio exigido pelo JPA
	}

	public Pizza(String id, String name, BigDecimal price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Pizza(String name, BigDecimal price, String category) {
		this(UUID.randomUUID().toString(), name, price, category);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

interface PizzaRepository extends JpaRepository<Pizza, String> {
}

@CrossOrigin(origins = {"http://localhost:8080", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/pizzas")
class RestApiDemoController {

	private final PizzaRepository pizzaRepository;

	public RestApiDemoController(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;

		if (pizzaRepository.count() == 0) {
			pizzaRepository.saveAll(java.util.List.of(
					new Pizza("Pizza Gorgonzola", new BigDecimal("42.90"), "Tradicional"),
					new Pizza("Pizza Quatro Queijos", new BigDecimal("45.90"), "Tradicional"),
					new Pizza("Pizza de Jalapeño", new BigDecimal("48.90"), "Especial"),
					new Pizza("Pizza de Calabresa", new BigDecimal("39.90"), "Tradicional")
			));
		}
	}

	@GetMapping
	Iterable<Pizza> getPizzas() {
		return pizzaRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Pizza> getPizzaById(@PathVariable String id) {
		return pizzaRepository.findById(id);
	}

	@PostMapping
	Pizza postPizza(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}

	@PutMapping("/{id}")
	ResponseEntity<Pizza> putPizza(@PathVariable String id, @RequestBody Pizza pizza) {
		boolean existe = pizzaRepository.existsById(id);
		Pizza pizzaAtualizada = new Pizza(id, pizza.getName(), pizza.getPrice(), pizza.getCategory());
		pizzaRepository.save(pizzaAtualizada);

		return existe
				? new ResponseEntity<>(pizzaAtualizada, HttpStatus.OK)
				: new ResponseEntity<>(pizzaAtualizada, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	void deletePizza(@PathVariable String id) {
		pizzaRepository.deleteById(id);
	}
}
