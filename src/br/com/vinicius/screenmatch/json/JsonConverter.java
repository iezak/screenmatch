package br.com.vinicius.screenmatch.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.vinicius.screenmatch.modelo.TituloOMDb;

public class JsonConverter {
    private Gson gson;

    public JsonConverter() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public TituloOMDb fromJson(String json) {
        return gson.fromJson(json, TituloOMDb.class);
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }
}
