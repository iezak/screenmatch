package br.com.vinicius.screenmatch.cauculo;

public class Recomendacao {

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Esta entre os favoritos do momento.");
        } else if(classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado.");
        } else {
            System.out.println("Coloque na sua lista para assistir depois.");}
    }
}
