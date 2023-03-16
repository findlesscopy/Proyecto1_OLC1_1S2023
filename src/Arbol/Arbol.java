package Arbol;
import java.util.*;

import static Arbol.GraphvizExporter.convertir;
import static java.util.Collections.replaceAll;

public class Arbol {
    private Nodo arbol_expresion;
    public int contador = 0;
    public int num_nodo = 1;
    public HashMap<Integer, ArrayList<Integer>> tabla_siguientes = new HashMap<>();
    public HashMap<Integer, String> tabla_lexemas = new HashMap<>();
    public HashMap<Integer, ArrayList<Integer>> tablaTransiciones = new HashMap<>();
    //public ArrayList<NodoLista> tablaTransicionesLista = new ArrayList<>();
    public TreeMap<ArrayList<Integer>, ArrayList<Integer>> tablaTransicionesLista = new TreeMap<>(new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return Integer.compare(o1.get(0), o2.get(0));
        }
    });
    public Arbol(Nodo arbol_expresion) {
        Nodo raiz = new Nodo(".");
        Nodo aceptacion = new Nodo("#");
        aceptacion.setLeaf(true);
        raiz.setDerecha(aceptacion);
        raiz.setIzquierda(arbol_expresion);
        this.arbol_expresion = raiz;
        asignar_numeros(this.arbol_expresion);
        metodoArbol(this.arbol_expresion);
        tabla_siguientes(this.arbol_expresion);
        ArrayList<Integer> listaVacia = new ArrayList<Integer>();
        this.tabla_siguientes.put(contador+1,listaVacia);
        tabla_lexemas(this.arbol_expresion);
        crearTablaTransiciones(this.tabla_siguientes,this.arbol_expresion);
        //generarTablaTransiciones(asignarTransiciones());
        num_nodo = 0;
        System.out.println(tabla_siguientes);
        System.out.println(graficarArbol(this.arbol_expresion, num_nodo));
        graficarTablaSiguientes(this.arbol_expresion);
        generarTablaTransiciones(asignarTransiciones());
        System.out.println(generarDot(asignarTransiciones(),this.tabla_lexemas));
        //System.out.println(tabla_lexemas);
        //System.out.println(tablaTransiciones);
        //System.out.println(tablaTransicionesLista);




    }
    public void asignar_numeros(Nodo actual){
        if(actual == null){
            return;
        }
        if(actual.isLeaf()){
            actual.setId(num_nodo);
            num_nodo++;
            return;
        }
        asignar_numeros(actual.getIzquierda());
        asignar_numeros(actual.getDerecha());
    }
    public void metodoArbol(Nodo actual) {
        if (actual == null) {
            return;
        }
        if(actual.isLeaf()){
            actual.getPrimeros().add(actual.getId());
            actual.getUltimos().add(actual.getId());
            return;
        }
        metodoArbol(actual.getIzquierda());
        metodoArbol(actual.getDerecha());
        switch (actual.getValue()) {
            case "*", "?" -> {
                actual.setAnulable(true);
                actual.getPrimeros().addAll(actual.getDerecha().getPrimeros());
                actual.getUltimos().addAll(actual.getDerecha().getUltimos());
                return;
            }
            case "+" -> {
                actual.setAnulable(actual.getDerecha().isAnulable());
                actual.getPrimeros().addAll(actual.getDerecha().getPrimeros());
                actual.getUltimos().addAll(actual.getDerecha().getUltimos());
                return;
            }
            case "|" -> {
                actual.setAnulable(actual.getDerecha().isAnulable() || actual.getIzquierda().isAnulable());
                actual.getPrimeros().addAll(actual.getDerecha().getPrimeros());
                actual.getPrimeros().addAll(actual.getIzquierda().getPrimeros());
                actual.getUltimos().addAll(actual.getDerecha().getUltimos());
                actual.getUltimos().addAll(actual.getIzquierda().getUltimos());
                return;
            }
            case "." -> {
                actual.setAnulable(actual.getDerecha().isAnulable() && actual.getIzquierda().isAnulable());
                if (actual.getIzquierda().isAnulable()) {
                    actual.getPrimeros().addAll(actual.getDerecha().getPrimeros());
                    actual.getPrimeros().addAll(actual.getIzquierda().getPrimeros());
                } else {
                    actual.getPrimeros().addAll(actual.getIzquierda().getPrimeros());
                }
                if(actual.getDerecha().isAnulable()) {
                    actual.getUltimos().addAll(actual.getDerecha().getUltimos());
                    actual.getUltimos().addAll(actual.getIzquierda().getUltimos());
                } else {
                    actual.getUltimos().addAll(actual.getDerecha().getUltimos());
                }
                return;
            }
        }

    }
    public void tabla_siguientes(Nodo actual){
        if(actual == null){
            return;
        }
        if(actual.isLeaf()){
            return;
        }
        Collections.sort(actual.getPrimeros());
        Collections.sort(actual.getUltimos());
        tabla_siguientes(actual.getIzquierda());
        tabla_siguientes(actual.getDerecha());
        switch(actual.getValue()){
            case "." -> {
                for (int i = 0; i < actual.getIzquierda().getUltimos().size(); i++) {
                    for (int j = 0; j < actual.getDerecha().getPrimeros().size(); j++) {
                        if(estaHashMap(actual.getIzquierda().getUltimos().get(i), actual.getDerecha().getPrimeros().get(j))){
                            contador++;
                        }
                    }
                }
            }
            case "*","+" -> {
                for (int i = 0; i < actual.getUltimos().size(); i++) {
                    for (int j = 0; j < actual.getPrimeros().size(); j++) {
                        if(estaHashMap(actual.getUltimos().get(i), actual.getPrimeros().get(j))){
                            contador++;
                        }
                    }
                }
            }
        }

    }
    public boolean estaHashMap(int clave, int valorNuevo){
        if (tabla_siguientes.containsKey(clave)) {
            // La clave ya existe en el HashMap
            ArrayList<Integer> listaValores = tabla_siguientes.get(clave);
            listaValores.add(valorNuevo);
            return false;
        } else {
            // La clave no existe en el HashMap, crear una nueva lista de valores
            ArrayList<Integer> listaValores = new ArrayList<Integer>();
            listaValores.add(valorNuevo);
            tabla_siguientes.put(clave, listaValores);
            return true;
        }
    }
    public void graficarTablaSiguientes(Nodo nodo){
        if(nodo == null){
            return;
        }
        String dot = "digraph G{\n";
        dot += "node [shape=plaintext]\n";
        dot += "tabla [label=<\n";
        dot += "<table border='1' cellborder='1' cellspacing='0'>\n";
        dot += "<tr><td>No.</td><td>Lexema</td><td>Siguientes</td></tr>\n";
        for (Map.Entry<Integer, ArrayList<Integer>> entry : tabla_siguientes.entrySet()) {
            dot += "<tr><td>"+entry.getKey()+"</td><td>"+getNombreLexema(entry.getKey())+"</td><td>"+entry.getValue()+"</td></tr>\n";
        }
        dot += "</table>\n";
        dot += ">];\n";
        dot += "}";
        System.out.println(dot);
    }
    public String getNombreLexema(int id){
        for (Map.Entry<Integer, String> entry : tabla_lexemas.entrySet()) {
            if(entry.getKey() == id){
                return entry.getValue();
            }
        }
        return "";
    }
    public void tabla_lexemas(Nodo nodo){
        if(nodo == null){
            return;
        }
        if(nodo.isLeaf()){
            tabla_lexemas.put(nodo.getId(), nodo.getValue());
        }
        tabla_lexemas(nodo.getIzquierda());
        tabla_lexemas(nodo.getDerecha());
    }
    public String graficarArbol(Nodo nodo, int padre){
        String dot = "";
        num_nodo += 1;

        int actual = num_nodo;

        if(nodo == null){
            num_nodo -= 1;
            return  dot;
        }
        String nodoTerm = nodo.getValue();
        nodoTerm = nodoTerm.replace("\"", "");
        Collections.sort(nodo.getPrimeros());
        Collections.sort(nodo.getUltimos());
        if(nodo.isLeaf()){

            dot += "nodo" + actual + "[label=\"" +"Lexema: " +nodoTerm +" \nID " +nodo.getId()+ "\nAnulable? " +nodo.isAnulable()+ "\nPrimeros " +nodo.getPrimeros()+"\nUltimos " +nodo.getUltimos()+"\"];\n";
        }else{
            dot += "nodo" + actual + "[label=\"" +"Lexema: " + nodoTerm +" \nAnulable? " +nodo.isAnulable()+ "\nPrimeros " +nodo.getPrimeros()+"\nUltimos " +nodo.getUltimos()+ "\"];\n";
        }

        if(padre != 0){
            dot += "nodo" + padre + "->" + "nodo" + actual + ";\n";
        }
        dot += graficarArbol(nodo.getIzquierda(), actual);
        dot += graficarArbol(nodo.getDerecha(), actual);

        return dot;
    }

    public HashMap<Integer, ArrayList<Integer>> crearTablaTransiciones(HashMap<Integer, ArrayList<Integer>> tablaSiguientes, Nodo nodo) {
        HashMap<ArrayList<Integer>, Integer> mapEstados = new HashMap<>(); // Mapea las listas de estados con su primer índice
        int contador = 0;
        tablaTransiciones.put(contador, nodo.getIzquierda().getPrimeros());
        for (Map.Entry<Integer, ArrayList<Integer>> entrada : tablaSiguientes.entrySet()) {
            int estadoActual = entrada.getKey()+1;
            ArrayList<Integer> estadosSiguientes = entrada.getValue();
            // Verifica si la lista de estados ya se ha agregado antes
            ArrayList<Integer> listaReferencia = null;
            for (Map.Entry<ArrayList<Integer>, Integer> mapEntry : mapEstados.entrySet()) {
                ArrayList<Integer> lista = mapEntry.getKey();
                if(verificarEstados(lista, estadosSiguientes)){
                    //System.out.println("Son iguales");
                    contador++;
                    listaReferencia = lista;
                    break;
                }
            }
            // Si la lista de estados ya se ha agregado, se referencia al mismo objeto
            if (listaReferencia != null) {

            } else {
                ArrayList<Integer> transiciones = new ArrayList<>();
                for (Integer estadoSiguiente : estadosSiguientes) {
                    transiciones.add(estadoSiguiente);
                }
                tablaTransiciones.put(estadoActual-contador-1, transiciones);
                mapEstados.put(estadosSiguientes, estadoActual); // Agrega la lista de estados y su primer índice
            }
        }
        return tablaTransiciones;
    }

    public boolean verificarEstados(ArrayList<Integer> lista, ArrayList<Integer> estadosSiguientes){
        if(lista.size() != estadosSiguientes.size()){
            return false; // Si no son del mismo tamaño, no son iguales
        }
        for (int i = 0; i < lista.size(); i++) {
            if(!lista.get(i).equals(estadosSiguientes.get(i))) {
                return false; // Si no son iguales, se sale del ciclo
            }
        }
        return true; // Si son iguales, se regresa true
    }

    public void generarTablaTransiciones(List<Transicion> transiciones) {
        // Crear HashMap para almacenar las transiciones
        Map<Integer, Map<Integer, Integer>> tablaTransiciones = new HashMap<>();

        // Agregar las transiciones correspondientes al HashMap
        for (Transicion transicion : transiciones) {
            int estadoOrigen = transicion.getEstadoOrigen();
            int lexema = transicion.getIdLista();
            int estadoDestino = transicion.getEstadoDestino();
            boolean aceptacion = transicion.isAceptacion();
            System.out.println("Estado origen: " + estadoOrigen + ", Lexema: " + lexema+", Estado destino: " + (estadoDestino+1) + " ,Aceptacion?:" +aceptacion);
            // Agregar la transición al HashMap
            tablaTransiciones.computeIfAbsent(estadoOrigen, k -> new HashMap<>())
                    .put(lexema, estadoDestino + 1);
        }

        // Generar la tabla de transiciones en el formato requerido
        String dot = "";
        dot += "digraph G {\n";
        dot += "  node [shape=plaintext]\n";

        dot += "title =\"Tabla de transiciones\"\n";
        dot += "  table [label=<\n";
        dot += "    <table border='1' cellspacing='0'>\n";

        // Encabezado de la tabla
        dot += "      <tr>\n";
        dot += "        <td>Estado</td>\n";
        for (int lexema : tabla_lexemas.keySet()) {
            dot += "        <td>" + tabla_lexemas.get(lexema) + "</td>\n";
        }
        dot += "      </tr>\n";

        // Cuerpo de la tabla
        for (int estado : tablaTransiciones.keySet()) {
            dot += "      <tr>\n";
            dot += "        <td>S" + estado + "</td>\n";

            for (int lexema : tabla_lexemas.keySet()) {
                int siguienteEstado = tablaTransiciones.getOrDefault(estado, Collections.emptyMap())
                        .getOrDefault(lexema, -1);
                String siguienteEstadoStr = siguienteEstado == -1 ? "-" : "S" + siguienteEstado;
                dot += "        <td>" + siguienteEstadoStr + "</td>\n";
            }
            dot += "      </tr>\n";
        }



        dot += "    </table>\n";
        dot += "  >]\n";
        dot += "}";
        System.out.println(dot);
    }

    public List<Transicion> asignarTransiciones() {
        Map<ArrayList<Integer>, Integer> mapaListas = new HashMap<>();
        int contadorListas = 0;
        ArrayList<Transicion> transiciones = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entrada : tablaTransiciones.entrySet()) {
            int estadoOrigen = entrada.getKey();
            ArrayList<Integer> listaAux = entrada.getValue();

            for (Integer aux : listaAux) {
                ArrayList<Integer> lista = tabla_siguientes.get(aux);

                if (lista != null) {
                    int idLista;
                    if (mapaListas.containsKey(lista)) {
                        idLista = mapaListas.get(lista);
                    } else {
                        mapaListas.put(lista, contadorListas);
                        idLista = contadorListas;
                        contadorListas++;
                    }
                    //System.out.println("Empieza otro");
                    System.out.println("Estado origen: " + estadoOrigen + ", Lexema: " + (aux) + " ,Estado destino: " + (idLista+1));
                    if(aux == tabla_lexemas.size()){
                        transiciones.add(new Transicion(estadoOrigen,idLista,aux,true));
                    }else{
                        transiciones.add(new Transicion(estadoOrigen,idLista,aux,false));
                    }

                }
            }
        }
        return transiciones;
    }

    public static String generarDot(List<Transicion> transiciones, Map<Integer, String> tabla_lexemas) {
        String dot = "";
        dot += "digraph AFD {\n";
        dot += "  rankdir=LR;\n";
        dot += "  node [shape = doublecircle]; ";
        List<Integer> estadosAceptacion = new ArrayList<>();
        for (Transicion t : transiciones) {
            if (t.isAceptacion()) {
                estadosAceptacion.add(t.getEstadoDestino());
            }
        }
        for (int estadoAceptacion : estadosAceptacion) {
            dot += estadoAceptacion + " ";
        }
        dot += ";\n";
        dot += "  node [shape = circle];\n";
        for (Transicion t : transiciones) {
            String lexema = tabla_lexemas.get(t.getIdLista());
            if(lexema.equals("\" \"")){
                lexema = lexema.replaceAll("\"", "\\\\\"");
            }
            if(lexema.equals("\n")){
                lexema = lexema.replaceAll("\n", "salto de linea");
            }
            if(lexema.equals("#")){

            }else {
                dot += "  " + t.getEstadoOrigen() + " -> " + (t.getEstadoDestino()+1) + " [ label = \""+lexema +"\" ];\n";

            }
            //dot += "  " + t.getEstadoOrigen() + " -> " + (t.getEstadoDestino()+1) + " [ label = \""+lexema +"\" ];\n";
        }
        dot += "}\n";
        return dot;
    }
}
