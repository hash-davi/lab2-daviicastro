public class RegistroResumos {
    private int numeroDeResumos;
    private Resumo[] resumos;
    private int iResumo;

    public RegistroResumos(int limiteDeResumos) {
        this.resumos = new Resumo[limiteDeResumos];
        this.numeroDeResumos = 0;
        this.iResumo = 0;
    }

    public void adicionaResumo(String tema, String conteudo) {
        /*
        Você poderia implementar uma classe Resumo, criando um objeto que vai
        comportar o tema e o conteúdo. Dessa forma, a chamada de tema e conteúdo
        ficaria mais tranquila nos outros metódos...
        */
        if (!temResumo(tema)) {
            this.resumos[this.iResumo] = new Resumo(tema, conteudo);

            this.iResumo = (this.iResumo + 1) % this.resumos.length;
            if (this.numeroDeResumos < this.resumos.length) {
                this.numeroDeResumos++;
            }
        }
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < this.numeroDeResumos; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    public int contaResumos() {
        return this.numeroDeResumos;
    }

    public String[] pegaResumos() {
        String[] resumos = new String[this.numeroDeResumos];

        for (int i = 0; i < this.numeroDeResumos; i++) {
            resumos[i] = this.resumos[i].getTema() + ": " + this.resumos[i].getConteudo();
        }

        return resumos;
    }

    public String imprimeResumos() {
        StringBuffer saida = new StringBuffer();

        saida.append("- " + this.numeroDeResumos + " resumo(s) cadastrado(s) no sistema\n");

        for (int i = 0; i < this.numeroDeResumos; i++) {
            saida.append("- " + this.resumos[i].getTema());

            if (i < this.numeroDeResumos - 1) {
                saida.append("\n");
            }
        }

        return saida.toString();
    }
}
