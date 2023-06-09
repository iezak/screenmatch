package br.com.vinicius.screenmatch.api;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class OMDbApi {
    private String apiKey;

    public OMDbApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public String buscarFilme(String filme) {
        try {
            String filmeEncode = URLEncoder.encode(filme, StandardCharsets.UTF_8.name());
            String uri = String.format("http://www.omdbapi.com/?t=%s&apikey=%s", filmeEncode, apiKey);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            String json = client.sendAsync(request, BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();

            return json;
        } catch (Exception e) {
            System.out.println("Erro na busca do filme");
            e.printStackTrace();
            return null;
        }
    }
}
