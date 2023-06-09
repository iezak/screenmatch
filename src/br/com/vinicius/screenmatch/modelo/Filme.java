package br.com.vinicius.screenmatch.modelo;

import br.com.vinicius.screenmatch.cauculo.Classificavel;

public class Filme extends Titulo implements Classificavel{

    public Filme(String nome, int anoDeLansamento) {
		super(nome, anoDeLansamento);
	}

	private String diretor;
    
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) getAvaliacao()/2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLansamento() + ")";
    }
}
