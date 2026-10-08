/*
 * Representação de um resumo no sistema.
 * Compõe a classe RegistroResumos.
 *
 * @author Davi Isidio Castro
 */
public class Resumo {
    private String tema;
    private String conteudo;

    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String getTema() {
        return this.tema;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    @Override
    public String toString() {
        return this.tema + ": " + this.conteudo;
    }
}
