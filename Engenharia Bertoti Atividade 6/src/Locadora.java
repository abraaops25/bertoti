import java.util.List;
import java.util.LinkedList;

public class Locadora {

    private List<Filme> filmes = new LinkedList<Filme>();

    public void cadastrarFilme(Filme filme) {
       this.filmes.add(filme);
    }

      public  List<Filme> buscarFilmeTituloAutor(Filme fil){
        List<Filme> encontrados = new LinkedList<Filme>();
        for(Filme filme:filmes){
            if(filme.comparar(fil)) encontrados.add(filme);
      }
        return encontrados;
    }
    public List<Filme> getFilmes(){
        return filmes;
    }
}