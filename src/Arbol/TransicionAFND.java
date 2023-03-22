package Arbol;

public class TransicionAFND {
    private int estadoOrigen;
    private int estadoDestino;
    private String lexema;
    private boolean Aceptacion = false;
    public TransicionAFND(int estadoOrigen, int estadoDestino, String lexema, boolean aceptacion) {
        this.estadoOrigen = estadoOrigen;
        this.estadoDestino = estadoDestino;
        this.lexema = lexema;
        this.Aceptacion = aceptacion;
    }

    public int getEstadoOrigen() {
        return estadoOrigen;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public String getLexema() {
        return lexema;
    }
    public boolean isAceptacion() {
        return Aceptacion;
    }
    public void setAceptacion(boolean aceptacion) {
        Aceptacion = aceptacion;
    }
}
