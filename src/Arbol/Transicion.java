package Arbol;

public class Transicion {
    private int estadoOrigen;
    private int estadoDestino;
    private int idLista;
    private boolean Aceptacion = false;
    public Transicion(int estadoOrigen, int estadoDestino, int idLista, boolean aceptacion) {
        this.estadoOrigen = estadoOrigen;
        this.estadoDestino = estadoDestino;
        this.idLista = idLista;
        this.Aceptacion = aceptacion;
    }

    public int getEstadoOrigen() {
        return estadoOrigen;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public int getIdLista() {
        return idLista;
    }
    public boolean isAceptacion() {
        return Aceptacion;
    }
    public void setAceptacion(boolean aceptacion) {
        Aceptacion = aceptacion;
    }


}

