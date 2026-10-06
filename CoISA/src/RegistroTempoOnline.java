public class RegistroTempoOnline {
    private String nomeDaDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnlineUtilizado;

    public RegistroTempoOnline(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineUtilizado = 0;
        this.tempoOnlineEsperado = 120;
    }

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

    public String toString() {
        StringBuffer saida = new StringBuffer();

        saida.append(this.nomeDaDisciplina + " " + this.tempoOnlineUtilizado + "/" + this.tempoOnlineEsperado);

        return saida.toString();
    }
}
