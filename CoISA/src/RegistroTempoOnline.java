public class RegistroTempoOnline {
    private String nomeDaDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineUtilizado;

    public RegistroTempoOnline(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDaDisciplina, int tempoOnlineEsperado) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUtilizado = tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUtilizado >= this.tempoOnlineEsperado;
    }

    public String toString() {
        StringBuffer saida = new StringBuffer();

        saida.append("Nome da disciplina: " + this.nomeDaDisciplina + "\n")
                .append("Tempo online utilizado: " + this.tempoOnlineUtilizado + "\n")
                .append("Tempo online esperado: " + this.tempoOnlineEsperado);

        return saida.toString();
    }
}
