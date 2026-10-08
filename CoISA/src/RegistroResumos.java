import java.util.Arrays;

/*
 * Representação do registro de resumos no sistema.
 * Guarda os resumos em um array de objetos da classe Resumo
 * e mantém o número de resumos armazenados.
 *
 * @author Davi Isidio Castro
 */
public class RegistroResumos {
    private int numeroDeResumos;
    private Resumo[] resumos;
    private int iResumo;

    public RegistroResumos(int limiteDeResumos) {
        this.resumos = new Resumo[limiteDeResumos];
        this.numeroDeResumos = 0;
        this.iResumo = 0;
    }

    /*
     * Adiciona um novo resumo ao array de resumos caso não
     * haja outro resumo de mesmo tema no array.
     * Se todos os espaços do array forem preenchidos, o próximo
     * resumo será colocado no lugar do primeiro e assim por
     * diante.
     *
     * @param tema do resumo
     * @param conteudo do resumo
     */
    public void adicionaResumo(String tema, String conteudo) {
        /*
        Você poderia implementar uma classe Resumo, criando um objeto que vai
        comportar o tema e o conteúdo. Dessa forma, a chamada de tema e conteúdo
        ficaria mais tranquila nos outros metódos... - Caio.
        */
        if (!temResumo(tema)) {
            this.resumos[this.iResumo] = new Resumo(tema, conteudo);

            this.iResumo = (this.iResumo + 1) % this.resumos.length;
            if (this.numeroDeResumos < this.resumos.length) {
                this.numeroDeResumos++;
            }
        }
    }

    /*
     * Checa se já existe um resumo com o tema passado como
     * parâmetro.
     *
     * @param tema a ser verificado
     *
     * @return valor em boolean que informa se o tema já existe ou
     * não no array
     */
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

    /*
     * Retorna um array com as representações textuais dos resumos.
     *
     * @return array de Strings que representam os resumos armazenados
     */
    public String[] pegaResumos() {
        String[] resumos = new String[this.numeroDeResumos];

        for (int i = 0; i < this.numeroDeResumos; i++) {
            resumos[i] = this.resumos[i].toString();
        }

        return resumos;
    }

    /*
     * Retorna a representação textual de um objeto desta classe.
     * O texto segue o formato:
     * """
     * - <Numero de resumos> resumo(s) cadastrados no sistema
     * - <Tema1>
     * - <Tema2>
     * ...
     * """
     *
     * @return String que representa um objeto da classe.
     */
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

    /*
     * Busca a String chaveDeBusca no array de resumos e retorna
     * um array de Strings com os temas dos resumos encontrados.
     *
     * @return array de Strings com os temas dos resumos encontrados
     */
    public String[] busca(String chaveDeBusca) {
        String[] baseResult = new String[this.numeroDeResumos];
        int iResultado = 0;

        for (int i = 0; i < this.numeroDeResumos; i++) {
            if (this.resumos[i].getConteudo().contains(chaveDeBusca)) {
                baseResult[iResultado++] = this.resumos[i].getTema();
            }
        }

        String[] resultados = new String[iResultado];
        for (int i = 0; i < iResultado; i++) {
            resultados[i] = baseResult[i];
        }

        Arrays.sort(resultados);

        return resultados;
    }
}
