package org.example;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Filme> filmes = new ArrayList<>();

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Filme> buscarFilmeTituloAutor(Filme filme) {
        List<Filme> encontrados = new ArrayList<>();
        for (Filme f : filmes) {
            if (f.getTitulo().equals(filme.getTitulo()) &&
                    f.getAutor().equals(filme.getAutor())) {
                encontrados.add(f);
            }
        }
        return encontrados;
    }
}