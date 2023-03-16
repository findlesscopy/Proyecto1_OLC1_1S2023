package Arbol;

import java.util.ArrayList;

public class Nodo {
    private String value;
    private Nodo derecha;
    private Nodo izquierda;
    private int id;
    private boolean Anulable = false;
    private boolean isLeaf = false;
    public ArrayList<Integer> primeros;
    public ArrayList<Integer> ultimos;
    public Nodo (String value){
        this.value = value;
        this.primeros = new ArrayList<>();
        this.ultimos = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        this.isLeaf = leaf;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isAnulable() {
        return Anulable;
    }
    public void setAnulable(boolean anulable) {
        Anulable = anulable;
    }
    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }
    public void setPrimeros(ArrayList<Integer> primeros){
        this.primeros = primeros;
    }
    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }
    public void setUltimos(ArrayList<Integer> ultimos){
        this.ultimos = ultimos;
    }
}

