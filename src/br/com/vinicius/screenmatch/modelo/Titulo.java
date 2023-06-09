package br.com.vinicius.screenmatch.modelo;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLansamento;
    private boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;
    private int duracao;
    private double avaliacaoTotal;

    public Titulo(String nome, int anoDeLansamento) {
        this.setNome(nome);
        this.setAnoDeLansamento(anoDeLansamento);
    }

    public Titulo(TituloOMDb tituloOMDb) {
        this.nome = tituloOMDb.title();

        String year = tituloOMDb.year().substring(0, 4);
        this.anoDeLansamento = Integer.valueOf(year);

        String runtime = tituloOMDb.runtime().substring(0, Math.min(tituloOMDb.runtime().length(), 3)).trim();
        runtime = runtime.replaceAll("\\D+", ""); // Remove todos os caracteres não numéricos

        if (!runtime.isEmpty() && runtime.length() >= 2) {
            this.duracao = Integer.valueOf(runtime);
        } else {
            // Defina um valor padrão caso a duração não seja um número válido
            this.duracao = 0; // Ou qualquer outro valor desejado
        }
    }

    @Override
    public String toString() {
        return "Titulo [nome=" + nome + ", anoDeLansamento=" + anoDeLansamento + ", duracao=" + duracao + "]";
    }

    public void exibeFichaTecnica() {
        System.out.println("***********************");
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lansabento: " + anoDeLansamento);
        System.out.println("Duração em minutos:" + duracao);
        System.out.println("***********************");
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLansamento() {
        return anoDeLansamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public int getDuracao() {
        return duracao;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLansamento(int anoDeLansamento) {
        this.anoDeLansamento = anoDeLansamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    // public void avalia(double nota){
    // avaliacao += nota;
    // totalDeAvaliacoes++;
    // }

    // public double pegaMedia(){
    // return avaliacao / totalDeAvaliacoes;
    // }

    public void avalia(double nota) {
        avaliacaoTotal += nota;
        totalDeAvaliacoes++;
        avaliacao = avaliacaoTotal / totalDeAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo titulo2) {
        return this.getNome().compareTo(titulo2.getNome());
    }
}
