package clases;

public class Celula {

    private boolean estado;

    public Celula() {
        this.estado = false;
    }

    public Celula(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void nace() {
        this.estado = true;
    }

    public void muere() {
        this.estado = false;
    }

    public void vive() {
        this.estado = true;
    }

    public boolean cambiarEstado() {
        this.estado = !this.estado;
        return this.estado;
    }

}
