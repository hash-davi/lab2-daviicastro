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
        StringBuffer saida = new StringBuffer();

        saida.append("Nome da disciplina: " + this.nome + "\n")
                .append("Horas de estudo: " + this.horasDeEstudo + "\n")
                .append("Média na disciplina: " + calculaMedia() + "\n\n")
                .append("Notas na disciplina:\n");

        for (int i = 0; i < 4; i++) {
            saida.append((i + 1) + ": " + this.notas[i] + "\n");
        }

        return saida.toString();
    }
}
