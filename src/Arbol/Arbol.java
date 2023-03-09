package Arbol;

import java.util.ArrayList;

public class Arbol{
    public Nodo raiz;

    public Arbol(){
        this.raiz = null;
    }

    public void insertar(String cadena){
        this.raiz = add(cadena, this.raiz);
    }

    private Nodo add(String cadena, Nodo nodo){
        if(nodo == null){
            return new Nodo(cadena);
        }else{
            if(cadena.compareTo(nodo.getCadena()) < 0){
                nodo.setIzquierda(add(cadena, nodo.getIzquierda()));
            }else{
                nodo.setDerecha(add(cadena, nodo.getDerecha()));
            }
        }
        return nodo;
    }

    public void preorden(){
        pre_orden(this.raiz);
    }

    private void pre_orden(Nodo nodo){
        if(nodo != null){
            System.out.println("Cadena: " + nodo.getCadena());
            System.out.println("Cadena: " + nodo.getCadena());
            pre_orden(nodo.getIzquierda());
            pre_orden(nodo.getDerecha());
        }
    }

    public void Graficar(){
        String dot = "";
        dot += "digraph G{\nlabel=\" Arbol Binario \";\nnode [shape = circle, style=filled, fillcolor=seashell2];\n"
                + this.getCodigoInterno(this.raiz) + "\n}";
        System.out.println(dot);
    }

    private String getCodigoInterno(Nodo nodo){
        String codigo = "";
        if(nodo.izquierda == null && nodo.derecha == null) {
            codigo = "nodo" + nodo.id + " [ label =\"" + nodo.cadena + "\"];\n";
        } else {
            codigo += "nodo" + nodo.id + " [ label =\"" + nodo.cadena + "\"];\n";
        }
        if(nodo.izquierda != null) {
            codigo += getCodigoInterno(nodo.izquierda) + "nodo" + nodo.id + ":C0->nodo" + nodo.izquierda.id + "\n";
        }
        if(nodo.derecha != null) {
            codigo += getCodigoInterno(nodo.derecha) + "nodo" + nodo.id + ":C1->nodo" + nodo.derecha.id + "\n";
        }
        return codigo;
    }
}