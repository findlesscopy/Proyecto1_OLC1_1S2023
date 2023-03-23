package Arbol;

import java.util.ArrayList;
public class Conjuntos {
    private String nombre;
    private ArrayList<String> conjunto;
    private boolean rango = false;

    public Conjuntos(String nombre, ArrayList<String> conjunto, boolean rango) {
        this.nombre = nombre;
        this.conjunto = new ArrayList<>(conjunto);
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getConjunto() {
        return conjunto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setConjunto(ArrayList<String> conjunto) {
        this.conjunto = conjunto;
    }

    public boolean isRango() {
        return rango;
    }

    public void setRango(boolean rango) {
        this.rango = rango;
    }
}
