package br.com.vinicius.screenmatch.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.screenmatch.modelo.Titulo;

public class TituloList {
    private List<Titulo> list;

    public TituloList() {
        list = new ArrayList<>();
    }

    public void adicionarTitulo(Titulo titulo) {
        list.add(titulo);
    }

    public void exibirFichaTecnica() {
        for (Titulo titulo : list) {
            titulo.exibeFichaTecnica();
        }
    }

    public void salvarJson(String nomeArquivo) {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
            JsonConverter jsonConverter = new JsonConverter();
            String json = jsonConverter.toJson(list);
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo JSON.");
            System.out.println(e.getMessage());
        }
    }

}
