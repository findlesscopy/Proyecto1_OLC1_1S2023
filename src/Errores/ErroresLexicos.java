package Errores;

public class ErroresLexicos {
    private String lexema;
    private int fila;
    private int columna;

    public ErroresLexicos(String lexema, int fila, int columna) {
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public String lexema() {
        return lexema;
    }

    public ErroresLexicos setLexema(String lexema) {
        this.lexema = lexema;
        return this;
    }

    public int fila() {
        return fila;
    }

    public ErroresLexicos setFila(int fila) {
        this.fila = fila;
        return this;
    }

    public int columna() {
        return columna;
    }

    public ErroresLexicos setColumna(int columna) {
        this.columna = columna;
        return this;
    }
}
