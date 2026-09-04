let i = 0;

function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}

const btnAdd = document.getElementById('submitBtn');
const nomePizza = document.getElementById('nomePizza');
const inputID = document.getElementById('inputID');
const pizzaList = document.getElementById('pizza-list');
const precoPizza = document.getElementById('precoPizza');
const categoriaPizza = document.getElementById('categoriaPizza');

function Adicionar() {
    axios.post('http://localhost:8080/pizzas', {
        id: uuidv4(),
        name: nomePizza.value,
        price: parseFloat(precoPizza.value),
        category: categoriaPizza.value
    }).then(response => {
        console.log("Pizza adicionada", response.data);
        window.location.reload();
    }).catch(e => {
        console.error("Erro ao adicionar pizza:", e);
    });
}
btnAdd.addEventListener('click', Adicionar);

function carregarPizzas() {
    fetch("http://localhost:8080/pizzas")
        .then(response => {
            if (!response.ok) throw new Error(`Erro HTTP: ${response.status}`);
            return response.json();
        })
        .then(data => {
            pizzaList.innerHTML = "";

            data.forEach(pizza => {
                const listItem = document.createElement("li");
                const deleteButton = document.createElement('button');
                const upItem = document.createElement("input");
                const upButton = document.createElement("button");

                const preco = pizza.price != null ? pizza.price.toFixed(2) : "0.00";
                listItem.innerHTML = `${pizza.name} — R$ ${preco} (${pizza.category ?? "sem categoria"})`;

                upButton.innerHTML = "Editar nome";
                deleteButton.innerHTML = "Excluir";
                upButton.setAttribute('id', i);
                upButton.setAttribute('class', 'btn btn-primary');
                deleteButton.setAttribute('class', 'btn btn-danger');
                i++;

                pizzaList.appendChild(listItem);
                pizzaList.appendChild(upItem);
                pizzaList.appendChild(upButton);
                pizzaList.appendChild(deleteButton);

                upButton.addEventListener('click', () => {
                    const upItemValor = upItem.value;
                    axios.put("http://localhost:8080/pizzas/" + pizza.id, {
                        id: pizza.id,
                        name: upItemValor,
                        price: pizza.price,
                        category: pizza.category
                    })
                        .then(response => {
                            console.log("Pizza atualizada com sucesso:", response.data);
                            listItem.innerText = upItemValor;
                        })
                        .catch(error => {
                            console.error("Erro ao atualizar a pizza:", error);
                        });
                });

                deleteButton.addEventListener('click', () => {
                    axios.delete("http://localhost:8080/pizzas/" + pizza.id)
                        .then(response => {
                            console.log('Deletado', response.data);
                            listItem.remove();
                            upItem.remove();
                            upButton.remove();
                            deleteButton.remove();
                        })
                        .catch(error => {
                            console.error("Erro ao deletar", error);
                        });
                });
            });
        })
        .catch(error => console.error("Erro ao buscar pizzas:", error));
}

document.addEventListener("DOMContentLoaded", carregarPizzas);