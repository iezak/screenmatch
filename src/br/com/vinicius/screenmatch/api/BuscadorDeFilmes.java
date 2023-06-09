package br.com.vinicius.screenmatch.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import br.com.vinicius.screenmatch.json.JsonConverter;
import br.com.vinicius.screenmatch.json.TituloList;
import br.com.vinicius.screenmatch.modelo.Titulo;
import br.com.vinicius.screenmatch.modelo.TituloOMDb;

public class BuscadorDeFilmes {
    private static final String KEY = "21ceb7aa";
    private static final String SAIR = "sair";

    private OMDbApi omdbApi;

    public BuscadorDeFilmes() {
        new ArrayList<>();
        new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        omdbApi = new OMDbApi(KEY);
    }

    public void buscarFilmes() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            JsonConverter jsonConverter = new JsonConverter();
            TituloList listaTitulos = new TituloList();
            String busca;

            do {
                System.out.println("Digite um filme para busca (ou 'sair' para encerrar)");
                busca = scanner.nextLine();

                if (busca.equalsIgnoreCase(SAIR)) {
                    break;
                }

                try {
                    String json = omdbApi.buscarFilme(busca);

                    System.out.println(json);

                    TituloOMDb tituloOMDb = jsonConverter.fromJson(json);

                    System.out.println(tituloOMDb);

                    Titulo titulo = new Titulo(tituloOMDb);
                    titulo.exibeFichaTecnica();

                    listaTitulos.adicionarTitulo(titulo);

                } catch (NumberFormatException e) {
                    System.out.println("Aconteceu um erro.");
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro de argumento na busca");
                    System.out.println(e.getMessage());
                }

            } while (!busca.equalsIgnoreCase(SAIR));

            listaTitulos.exibirFichaTecnica();
            listaTitulos.salvarJson("filme.json");
        }
    }
}
