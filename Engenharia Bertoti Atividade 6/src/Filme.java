
public class Filme {

    private String titulo;
    private String autor;
    private String genero;

    public boolean comparar(Filme filme){
        if(this.titulo.equals(filme.titulo)&&
        this.autor.equals(filme.autor)&&
        this.genero.equals((filme.genero))) return true;
        return false;
    }
    public Filme(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }
    public  String getTitulo(String titulo){
    return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(String autor) {
        return autor;
    }
}





