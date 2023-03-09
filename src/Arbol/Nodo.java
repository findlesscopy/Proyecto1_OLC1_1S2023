package Arbol;
public class Nodo{
    public String cadena;
    public Nodo izquierda;
    public Nodo derecha;
    public int id;

    public static int contador = 0;

    public Nodo(String cadena){
        this.cadena = cadena;
        this.izquierda = null;
        this.derecha = null;
        this.id = contador++;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}