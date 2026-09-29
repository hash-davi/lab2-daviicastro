public class Descanso {
    private int horasDeDescanso;
    private int numerosDeSemana;
    private String status;

    public Descanso() {
        this.horasDeDescanso = 0;
        this.numerosDeSemana = 0;
        this.status = "cansado";
    }

    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numerosDeSemana = valor;
    }

    public String getStatusGeral() {
        if (this.numerosDeSemana == 0) {
            this.status = "cansado";
        } else {
            if (this.horasDeDescanso / this.numerosDeSemana >= 26) {
                this.status = "descansado";
            } else {
                this.status = "cansado";
            }
        }

        return this.status;
    }
}
