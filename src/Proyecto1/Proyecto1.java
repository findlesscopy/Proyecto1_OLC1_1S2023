package Proyecto1;
import Analizadores.Lexer;
import Analizadores.parser;
import java.io.File;
import java.util.Scanner;
import Arbol.Arbol;
public class Proyecto1 {
    public static void main(String[] args) throws Exception{
        /*File doc = new File("src/Analizadores/archivo.olc");
        Scanner sc = new Scanner(doc);
        String data = "";
        while (sc.hasNextLine()) {
            data += sc.nextLine() + "\n";

        }
        interpretar(data);*/
        //interpretar("{\n//Comentario de una linea \n CONJ: letra -> a~z;\n //expresiones regulares ExpReg1 -> .{letra}*|\"_\"{letra}; \n %% %% ExpReg1 : \"primerlexema\"; \n }");
        Arbol arbol = new Arbol();
        arbol.insertar("hola");
        arbol.insertar("mundo");
        arbol.insertar("como");
        arbol.insertar("estas");
        arbol.insertar("hola");
        arbol.insertar("mundo");
        arbol.insertar("como");
        arbol.insertar("estas");
        arbol.Graficar();
    }

    private static void interpretar(String entrada) {
        try {
            Lexer scanner = new Lexer(new java.io.StringReader(entrada));
            parser parser = new parser(scanner);
            parser.parse();
            System.out.println("Analisis finalizado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}