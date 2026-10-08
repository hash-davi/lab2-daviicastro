/*
 * Representação do registro de tempo online no sistema.
 *
 * @author Davi Isidio Castro
 */
public class RegistroTempoOnline {
    private String nomeDaDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineUtilizado;

    /*
     * Cria um objeto desta classe com o atributo
     * tempoOnlineEsperado inicializado com 120 por
     * padrão.
     *
     * @param nome da disciplina
     */
    public RegistroTempoOnline(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineUtilizado = 0;
        this.tempoOnlineEsperado = 120;
    }

    /*
     * Cria um objeto desta classe inicializando o atributo
     * tempoOnlineEsperado com o valor passado como parâmetro.
     *
     * @param nome da disciplina
     * @param tempo online esperado
     */
    public RegistroTempoOnline(String nomeDaDisciplina, int tempoOnlineEsperado) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineUtilizado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUtilizado += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUtilizado >= this.tempoOnlineEsperado;
    }

    @Override
    public String toString() {
        StringBuffer saida = new StringBuffer();

        saida.append(this.nomeDaDisciplina + " " + this.tempoOnlineUtilizado + "/" + this.tempoOnlineEsperado);

        return saida.toString();
    }
}
