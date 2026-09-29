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
            if (tem.equals(tema)) {
                return true;
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

        for (int i = 0; i < this.resumos.length; i++) {
            saida.append("Resumo " + (i + 1) + ": " + this.resumos[i] + "\n");
        }

        return saida.toString();
    }
}
