import java.util.Arrays;

/*
 * Representação de uma disciplina no sistema
 * com os atributos nome, notas, pesos e horasDeEstudo.
 * As disciplinas devem ser identificadas pelo seu nome.
 *
 * @author Davi Isidio Castro
 */
public class Disciplina {
    private String nome;
    private double[] notas;
    private int[] pesos;
    private int horasDeEstudo;

    public Disciplina(String nomeDisciplina) {
        this.nome = nomeDisciplina;
        this.notas = new double[4];
        this.pesos = new int[]{1, 1, 1, 1};
        this.horasDeEstudo = 0;
    }

    public Disciplina(String nomeDisciplina, int qtdDeNotas) {
        this.nome = nomeDisciplina;
        this.notas = new double[qtdDeNotas];
        this.pesos = new int[qtdDeNotas];
        for (int i = 0; i < qtdDeNotas; i++) {
            this.pesos[i] = 1;
        }
        this.horasDeEstudo = 0;
    }

    public Disciplina(String nomeDisciplina, int qtdDeNotas, int[] pesosDasNotas) {
        this.nome = nomeDisciplina;
        this.notas = new double[qtdDeNotas];
        this.pesos = pesosDasNotas;
        this.horasDeEstudo = 0;
    }

    /*
     * Calcula a média ponderada ou aritmética do aluno na disciplina
     * e retorna o resultado.
     *
     * @return média ponderada ou aritmética do aluno na disciplina em double.
     */
    public double calculaMedia() {
        double media = 0;

        for (int i = 0; i < this.notas.length; i++) {
            media += this.notas[i] * this.pesos[i];
        }

        int total = 0;
        for (int peso : this.pesos) {
            total += peso;
        }

        return media / total;
    }

    /*
     * Adiciona mais horas ao total de horas de estudo.
     *
     * @param horas a serem adicionadas
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    /*
     * Substitui um valor de nota por outro.
     *
     * @param número da nota
     * @param novo valor a ser colocado na nota correspondente
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /*
     * Retorna o status de aprovação do aluno na disciplina.
     *
     * @return representação do status de aprovação em boolean.
     */
    public boolean aprovado() {
        return calculaMedia() >= 7;
    }

    /*
     * Retorna a representação textual da disciplina no sistema.
     * O texto segue o formato:
     * "<Nome da disciplina> <Horas de estudo> <Média> <Array de Notas>"
     *
     * @return representação em String de uma disciplina.
     */
    @Override
    public String toString() {
        /*
        Aqui se você seguisse a forma que eles cobraram as saídas, daria para fazer
        de uma forma mais tranquila. - Caio.
        */
        StringBuffer saida = new StringBuffer();

        saida.append(this.nome + " " + this.horasDeEstudo + " " + calculaMedia() + " " + Arrays.toString(this.notas));

        return saida.toString();
    }
}
