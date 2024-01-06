package br.com.vinicius.screenmatch.principal;

import java.io.IOException;

import br.com.vinicius.screenmatch.api.BuscadorDeFilmes;

public class principal {
    public static void main(String[] args) throws IOException {
        BuscadorDeFilmes buscador = new BuscadorDeFilmes();
        buscador.buscarFilmes();
    }
}