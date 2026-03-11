
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    void test(){

        Locadora bib = new Locadora();
        bib.cadastrarFilme(new Filme("Casa das Coelhinhas","Playboy","Reality Show"));
        assertEquals(1,bib.getFilmes().size());
        List<Filme>encontrados = bib.buscarFilmeTituloAutor(new Filme("Casa das Coelhinhas","Playboy","Reality Show"));
        assertEquals(1,encontrados.size());
    }
}
