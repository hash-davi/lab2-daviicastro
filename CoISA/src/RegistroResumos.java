public class RegistroResumos {
    private int numeroDeResumos;
    private String[] resumos;
    private String[] temas;
    private int iResumo;

    public RegistroResumos(int limiteDeResumos) {
        this.resumos = new String[limiteDeResumos];
        this.temas = new String[limiteDeResumos];
        this.numeroDeResumos = 0;
        this.iResumo = 0;
    }

    public void adicionaResumo(String tema, String conteudo) {
        if (!temResumo(tema)) {
            this.resumos[this.iResumo] = conteudo;
            this.temas[this.iResumo] = tema;

            this.iResumo = (this.iResumo + 1) % this.resumos.length;
            this.numeroDeResumos++;
        }
    }

    public boolean temResumo(String tema) {
        for (String tem : this.temas) {
            if (tem != null) {
                if (tem.equals(tema)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int contaResumos() {
        if (this.numeroDeResumos > this.resumos.length) {
            return this.resumos.length;
        } else {
            return this.numeroDeResumos;
        }
    }

    public String[] pegaResumos() {
        return this.resumos;
    }

    public String imprimeResumos() {
        StringBuffer saida = new StringBuffer();

        saida.append("- " + contaResumos() + " resumo(s) cadastrado(s) no sistema\n");

        int ponto_de_parada = 0;
        if (this.numeroDeResumos > this.temas.length) {
            ponto_de_parada = this.temas.length;
        } else {
            ponto_de_parada = this.numeroDeResumos;
        }

        for (int i = 0; i < ponto_de_parada; i++) {
            saida.append("- " + this.temas[i] + "\n");
        }

        return saida.toString();
    }
}
