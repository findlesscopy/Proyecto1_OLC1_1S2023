# **PROYECTO 1**
### Universidad de San Carlos de Guatemala
### Facultad de Ingeniería
### Escuela de Ciencias y Sistemas
### Organización de Lenguajes y Compiladores 1
### Sección C
<br></br>

## **Manual Técnico**
<br></br>

| Nombre | Carnet | 
| --- | --- |
| José Manuel Ibarra Pirir | 202001800 |
----
# **Introducción**
El manual técnico del proyecto proporciona información detallada sobre la estructura, el funcionamiento y el uso del sistema. Este proyecto se centra en la lectura de archivos, el procesamiento de la información utilizando analizadores léxicos y sintácticos, y la generación de gráficos y tablas para el análisis de los datos.

Este manual técnico está diseñado para proporcionar a los usuarios una comprensión completa del sistema y su funcionamiento. Incluye información detallada sobre los requerimientos del sistema, la instalación y configuración, el uso del sistema y la solución de problemas.

El manual técnico está dirigido a desarrolladores de software, analistas de datos y cualquier persona interesada en comprender cómo funciona el sistema. Se espera que los usuarios tengan un conocimiento básico de programación y una comprensión general de los conceptos de análisis léxico y sintáctico.

El manual técnico se divide en varias secciones, comenzando con una descripción general del sistema y su arquitectura. Se proporcionan instrucciones detalladas para la instalación y configuración del sistema, seguido de información sobre el uso del sistema y la solución de problemas.

Es importante tener en cuenta que este manual técnico es una herramienta valiosa para el uso efectivo del sistema. Los usuarios deben leer cuidadosamente la información proporcionada para asegurar una comprensión completa y efectiva del sistema.
## Descripción general
El manual técnico proporciona una guía detallada para el uso del proyecto "[nombre del proyecto]". Este proyecto tiene como objetivo procesar archivos, utilizando analizadores léxicos y sintácticos, y generar gráficos y tablas para el análisis de datos.

El manual técnico se divide en varias secciones, cada una de las cuales proporciona información detallada sobre diferentes aspectos del sistema. Comienza con una introducción general que describe el propósito y la audiencia del manual técnico.

La sección de arquitectura del sistema proporciona una descripción general de los componentes principales del sistema y su interacción. Esta sección es esencial para comprender cómo funciona el sistema y cómo se comunican sus diferentes partes.

Los requerimientos del sistema se describen detalladamente en la sección correspondiente. Estos requerimientos incluyen software y hardware necesarios para ejecutar el proyecto, como sistemas operativos, versiones de software y especificaciones de hardware.

La sección de instalación y configuración proporciona instrucciones paso a paso para instalar y configurar el sistema. Esto incluye la configuración de dependencias y la configuración del entorno de desarrollo integrado (IDE) si fuera necesario.

La sección de uso del sistema proporciona una descripción detallada de cómo utilizar el sistema. Esto incluye cómo cargar y procesar archivos, cómo ejecutar los analizadores léxicos y sintácticos, y cómo generar y visualizar los gráficos y tablas.

La sección de desarrollo del sistema proporciona información técnica detallada sobre cómo se construyó el sistema. Esto incluye la estructura del código fuente, los algoritmos utilizados y las decisiones de diseño clave.
## Objetivos y Alcance
### Objetivos
- Desarrollar un software que permita generar análisis mediante el método del árbol.
- Reforzar los conceptos del método de árbol de expresiones regulares en Autómatas Finitos Deterministas (AFD) y el método de Thompson de expresiones regulares en Autómatas Finitos No Deterministas (AFND).
- Identificar y programar el proceso de reconocimiento de lexemas mediante el uso de Autómatas Finitos Deterministas.
### Alcances
- El software será capaz de procesar archivos de texto para realizar análisis léxico y sintáctico.
- El software utilizará el método del árbol para generar análisis de los archivos procesados.
- Se implementará el método de árbol de expresiones regulares en AFD y el método de Thompson de expresiones regulares en AFND para reforzar los conceptos.
- Se programará el proceso de reconocimiento de lexemas mediante el uso de AFD.
- Se proporcionará documentación detallada sobre el funcionamiento del software y su uso.
- El software será desarrollado en el lenguaje de programación Java.

## Términos clave
- Compilador: Un programa que traduce el código fuente escrito en un lenguaje de programación a un lenguaje de máquina que la computadora puede entender y ejecutar.

- Análisis léxico: La primera fase de un compilador que se encarga de escanear el código fuente para identificar los lexemas o tokens que componen el programa.

- Análisis sintáctico: La segunda fase de un compilador que se encarga de analizar la estructura del código fuente según las reglas de la gramática del lenguaje de programación para detectar cualquier error sintáctico.

- Autómata Finito Determinista (AFD): Un modelo matemático utilizado para reconocer patrones en cadenas de texto. Se trata de un grafo dirigido que representa un conjunto de estados, transiciones entre estados y un conjunto de estados finales.

- Autómata Finito No Determinista (AFND): Un modelo matemático similar al AFD, pero que permite transiciones no deterministas, lo que significa que en un estado se pueden seguir múltiples caminos.

- Método del árbol: Un método utilizado para analizar la estructura sintáctica de un programa mediante la construcción de un árbol que representa la jerarquía de las expresiones en el código fuente.

- Expresión regular: Una secuencia de caracteres que define un patrón de búsqueda. Las expresiones regulares se utilizan para identificar patrones en el texto y son fundamentales en el análisis léxico.

- Lexema: La unidad más pequeña de un lenguaje de programación. Se refiere a una secuencia de caracteres que tiene un significado en el contexto del lenguaje.

- Token: Una categoría gramatical a la que pertenece un lexema. Los tokens son utilizados por el compilador para entender el significado de las expresiones en el código fuente.

- Gramática: Un conjunto de reglas que definen la estructura sintáctica de un lenguaje de programación. La gramática es fundamental en el análisis sintáctico de un compilador.
# **Arquitectura del Sistema**
1. Capa de Interfaz de Usuario: Esta capa se encarga de interactuar con el usuario del sistema, mostrando la información y resultados del análisis. Puede estar diseñada como una interfaz gráfica de usuario o una línea de comandos.

2. Capa de Análisis Léxico: Esta capa se encarga de escanear el código fuente y generar una secuencia de tokens que representan las unidades léxicas del programa. Se implementará utilizando Autómatas Finitos Deterministas (AFD) para el reconocimiento de lexemas.

3. Capa de Análisis Sintáctico: Esta capa se encarga de analizar la estructura del código fuente según las reglas de la gramática del lenguaje de programación para detectar cualquier error sintáctico. Utilizará el método del árbol para analizar la jerarquía de las expresiones en el código fuente.

4. Capa de Generación de Análisis: Esta capa se encarga de generar los resultados del análisis, como la tabla de transiciones, la tabla de siguientes, el AFD y el AFND. También se utilizará esta capa para evaluar cadenas de texto en el lenguaje de programación y generar los grafos del árbol de expresiones regulares.

5. Capa de Persistencia de Datos: Esta capa se encarga de guardar los resultados del análisis y la información generada durante la ejecución del programa en una base de datos o en archivos de texto.

6. Capa de Controladores: Esta capa se encarga de coordinar las acciones de las otras capas del sistema y controlar el flujo de datos entre ellas.

7. Capa de Librerías y Herramientas: Esta capa contiene las librerías y herramientas necesarias para la ejecución del programa, como la librería de como JFlex y CUP para el análisis léxico y sintáctico, respectivamente.

# **Requerimentos del Sistemae**
1. Sistema Operativo: Windows 10 o superior.

2. Java Development Kit (JDK): Versión 14 o superior.

3. JFlex: La última versión disponible para el sistema operativo utilizado.

4. CUP: La última versión disponible para el sistema operativo utilizado.

5. Graphviz: La última versión disponible para el sistema operativo utilizado.

6. Espacio en Disco: Se debe disponer de suficiente espacio en disco para instalar las herramientas necesarias y almacenar los archivos de código fuente y los resultados del análisis.

7. Memoria RAM: Se recomienda contar con al menos 8 GB de memoria RAM para la ejecución del sistema de manera óptima.

8. Procesador: Se recomienda contar con un procesador con al menos dos núcleos y una velocidad de reloj de 2 GHz o superior para una ejecución óptima.

9. Resolución de pantalla: Se recomienda una resolución de pantalla de al menos 1280x720 píxeles para una visualización adecuada de la interfaz gráfica de usuario y los gráficos generados.

# **Desarrollo del Sistema**
## Analizador Léxico
### Expresiones Regulares utilizadas
```
ESCAPADOS = "\\n" | "\\\"" | "\\\'"
NO_ESCAPADOS = [^\'\"]
ESPACIOS = [ \t\r\n]+
ENTRADA = [^\!]| ("!"[^\>])
COMENTARIO_MULTILINEA = "<!" {ENTRADA}+ "!>"
COMENTARIO_LINEA = "//" .*
L_MINUSCULA = [a-z]
L_MAYUSCULA = [A-Z]
DIGITO = [0-9]
ESPECIAL = [ -/:-@\[-`{-}]
ID = [a-zA-Z_][a-zA-Z0-9_]+
CARACTER = (\" {NO_ESCAPADOS} \") | {ESCAPADOS}
CADENA = \" ([^\"] | "\\\"")+  \"
FLECHA = "-" {ESPACIOS}* ">"
```
### Palabras Reservadas
```
CONJ = "CONJ"
```
### Tokens de estructura y operadores
```
LL_ABRE = "{"
LL_CIERRA = "}"
D_PUNTOS = ":"
P_COMA = ";"
COMA = ","
VIRGULILLA = "~"
PORCENTAJE = "%"
COMILLAS = \"
OR = "|"
CONCAT = "."
POSITIVA = "+"
KLEENE = "*"
OPCIONAL = "?"
```
## Analizador Sintáctico
Ver archivo [gramatica.md](./gramatica.md)

## Nodo utilizado en el árbol de expresiones regulares
```
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
}
```
## Nodo utilizado para las transiciones del AFD 
```
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
}
```
## Nodo utilizado para las transiciones del AFND
```
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
}
```
## Nodo utilizado para guardar las pruebas 
```
public class Prueba {
    private String nombre;
    private String cadena;

    public Prueba(String nombre, String cadena) {
        this.nombre = nombre;
        this.cadena = cadena;
    }
}
```
## Nodo utilizado para guardar los conjuntos de simbolos 
```
public class Conjuntos {
    private String nombre;
    private ArrayList<String> conjunto;
    private boolean rango = false;

    public Conjuntos(String nombre, ArrayList<String> conjunto, boolean rango) {
        this.nombre = nombre;
        this.conjunto = new ArrayList<>(conjunto);
        this.rango = rango;
    }
}
```
## Ejemplo de función utilizada para convertir el codigo dot a un archivo png
```
public static void convAFND(String codigoDot, String rutaArchivoPng){
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/AFND_" + rutaArchivoPng + ".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/AFND_202001800/AFND_" + rutaArchivoPng + ".jpg", "src/Pruebas/AFND_" + rutaArchivoPng + ".dot");
                proceso.start();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al generar la imagen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
```
## Función del método del arbol de expresiones regulares
```
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
```
## Función de tabla de siguientes
```
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
```
## Función de tabla de transiciones
```
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
```
## Función de la formación de AFD
```
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
                    //System.out.println("Estado origen: " + estadoOrigen + ", Lexema: " + (aux) + " ,Estado destino: " + (idLista+1));
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
```
## Función de la formación de AFND
```
public ArrayList<TransicionAFND> generarTransicionesAFND(Nodo raiz) {
        ArrayList<TransicionAFND> transiciones = new ArrayList<>();
        generarTransicionesRecursivoAFND(raiz, 1, transiciones);
        //transiciones.add(new TransicionAFND(0, 1, "ε", true));
        return transiciones;
    }
    public void generarTransicionesRecursivoAFND(Nodo nodo, int estadoInicial, ArrayList<TransicionAFND> transiciones) {
        int estadoDestino = estadoInicial + 1;
        if (nodo == null) {
            return;
        }
        if (nodo.isLeaf()) {
            transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getValue(), false));
            return;
        }
        switch (nodo.getValue()) {
            case "?" -> {
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                if (nodo.getDerecha().getValue().equals("|") || nodo.getDerecha().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getDerecha(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getDerecha().getValue(), false));
                    estadoInicial++;
                }
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                transiciones.add(new TransicionAFND(estadoDestino-1, estadoDestino, "ε", false));
            }
            case "*" -> {
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                estadoInicial++;
                if (nodo.getDerecha().getValue().equals("|") || nodo.getDerecha().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getDerecha(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getDerecha().getValue(), false));
                    estadoInicial++;
                }
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                transiciones.add(new TransicionAFND(estadoInicial, estadoInicial-1, "ε", false));
                estadoInicial++;
                transiciones.add(new TransicionAFND(estadoInicial-3, estadoInicial, "ε", false));
            }
            case "+" -> {
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                estadoInicial++;
                if (nodo.getDerecha().getValue().equals("|") || nodo.getDerecha().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getDerecha(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getDerecha().getValue(), false));
                    estadoInicial++;
                }
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                transiciones.add(new TransicionAFND(estadoInicial, estadoInicial-1, "ε", false));
            }
            case "|" -> {
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, "ε", false));
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino+2, "ε", false));
                estadoInicial++;
                if (nodo.getDerecha().getValue().equals("+") || nodo.getDerecha().getValue().equals("?") || nodo.getDerecha().getValue().equals("*") || nodo.getDerecha().getValue().equals("|") || nodo.getDerecha().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getDerecha(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getDerecha().getValue(), false));
                    estadoInicial++;
                }
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino+3,"ε", false));
                estadoInicial++;
                if (nodo.getIzquierda().getValue().equals("+") || nodo.getIzquierda().getValue().equals("?") || nodo.getIzquierda().getValue().equals("*") || nodo.getIzquierda().getValue().equals("|") || nodo.getIzquierda().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getIzquierda(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getIzquierda().getValue(), false));
                    estadoInicial++;
                }
                transiciones.add(new TransicionAFND(estadoInicial, estadoDestino,"ε", false));

            }
            case "." -> {
                if (nodo.getIzquierda().getValue().equals("+") || nodo.getIzquierda().getValue().equals("?") || nodo.getIzquierda().getValue().equals("*") || nodo.getIzquierda().getValue().equals("|") || nodo.getIzquierda().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getIzquierda(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getIzquierda().getValue(), false));
                    estadoInicial++;
                }
                if (nodo.getDerecha().getValue().equals("+") || nodo.getDerecha().getValue().equals("?") || nodo.getDerecha().getValue().equals("*") || nodo.getDerecha().getValue().equals("|") || nodo.getDerecha().getValue().equals(".")){
                    generarTransicionesRecursivoAFND(nodo.getDerecha(), estadoInicial, transiciones);
                }else{
                    transiciones.add(new TransicionAFND(estadoInicial, estadoDestino, nodo.getDerecha().getValue(), false));
                }
            }


            default -> {
            }

        }
    }
```