public class Disciplina {
    private String nome;
    private double[] notas;
    private int horasDeEstudo;

    public Disciplina(String nomeDisciplina) {
        this.nome = nomeDisciplina;
        this.notas = new double[4];
        this.horasDeEstudo = 0;
    }

    public double calculaMedia() {
        double media = 0;

        for (double nota : notas) {
            media += nota;
        }

        return media / 4;
    }

    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7;
    }

    @Override
    public String toString() {
        /*
        Aqui se você seguisse a forma que eles cobraram as saídas, daria para fazer
        de uma forma mais tranquila.
        */
        StringBuffer saida = new StringBuffer();

        saida.append(this.nome + " " + this.horasDeEstudo + " " + calculaMedia() + " [");
        for (int i = 0; i < 4; i++) {
            saida.append(this.notas[i]);

            if (i < 3) {
                saida.append(", ");
            }
        }
        saida.append("]");

        return saida.toString();
    }
}
