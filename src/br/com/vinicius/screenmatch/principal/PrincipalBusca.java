package br.com.vinicius.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import br.com.vinicius.screenmatch.api.OMDbApi;
import br.com.vinicius.screenmatch.modelo.Titulo;
import br.com.vinicius.screenmatch.modelo.TituloOMDb;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException {
        List<Titulo> list = new ArrayList<>();
        String key = "21ceb7aa";
        String busca = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            try (Scanner scanner = new Scanner(System.in)) {
                try {

                    System.out.println("Digite um filme para busca");
                    busca = scanner.nextLine();

                    OMDbApi omdbApi = new OMDbApi(key);
                    String json = omdbApi.buscarFilme(busca);

                    if (busca.equalsIgnoreCase("sair")) {
                        break;

                    }

                    System.out.println(json);

                    TituloOMDb tituloOMDb = gson.fromJson(json, TituloOMDb.class);

                    System.out.println(tituloOMDb);

                    Titulo titulo = new Titulo(tituloOMDb);
                    titulo.exibeFichaTecnica();

                    list.add(titulo);

                } catch (NumberFormatException e) {
                    System.out.println("Aconteceu um erro.");
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro de argumento na busca");
                    System.out.println(e.getMessage());
                }
            } catch (JsonSyntaxException e) {
                
                e.printStackTrace();
            }

        }
        for (Titulo titulo : list) {
            titulo.exibeFichaTecnica();
        }
        
        FileWriter fileWriter = new FileWriter("filme.json");
        fileWriter.write(gson.toJson(list));
        fileWriter.flush();
        fileWriter.close();
    }

}
