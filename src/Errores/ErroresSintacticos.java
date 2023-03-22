package Errores;

public class ErroresSintacticos {
    private boolean tipo;
    private String lexema;
    private int fila;
    private int columna;

    public ErroresSintacticos(boolean tipo, String lexema, int fila, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public boolean tipo() {
        return tipo;
    }

    public ErroresSintacticos setTipo(boolean tipo) {
        this.tipo = tipo;
        return this;
    }

    public String lexema() {
        return lexema;
    }

    public ErroresSintacticos setLexema(String lexema) {
        this.lexema = lexema;
        return this;
    }

    public int fila() {
        return fila;
    }

    public ErroresSintacticos setFila(int fila) {
        this.fila = fila;
        return this;
    }

    public int columna() {
        return columna;
    }

    public ErroresSintacticos setColumna(int columna) {
        this.columna = columna;
        return this;
    }
}
