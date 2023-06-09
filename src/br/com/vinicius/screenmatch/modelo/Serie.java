package br.com.vinicius.screenmatch.modelo;

public class Serie extends Titulo {

    public Serie(String nome, int anoDeLansamento) {
        super(nome, anoDeLansamento);
    }

    private int temporadas;
    private int episodiosPorTemporadas;
    private boolean ativa;
    private int minutosPorEpisodio;

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporadas() {
        return episodiosPorTemporadas;
    }

    public void setEpisodiosPorTemporadas(int episodiosPorTemporadas) {
        this.episodiosPorTemporadas = episodiosPorTemporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracao() {
        return temporadas * episodiosPorTemporadas * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getNome() + " (" + this.getAnoDeLansamento() + ")";
    }

}
