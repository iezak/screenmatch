package br.com.vinicius.screenmatch.cauculo;

import br.com.vinicius.screenmatch.modelo.Titulo;

public class CauculadoraDeTempo {
    
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo titulo) {
        tempoTotal += titulo.getDuracao();
    }
}
