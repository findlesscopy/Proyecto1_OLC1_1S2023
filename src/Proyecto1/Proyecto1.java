package Proyecto1;
import Analizadores.Lexer;
import Analizadores.parser;
import Arbol.*;
import java.io.File;
import java.util.Scanner;
import Arbol.*;
public class Proyecto1 {
    public static void main(String[] args) throws Exception{
        File doc = new File("src/Analizadores/archivo.olc");
        Scanner sc = new Scanner(doc);
        String data = "";
        while (sc.hasNextLine()) {
            data += sc.nextLine() + "\n";
        }
        interpretar(data);
        /*
        if(actual.getValue().equals(".")){
            for(int i = 0; i < actual.getIzquierda().getUltimos().size(); i++){
                tabla_siguientes.put(actual.getIzquierda().getUltimos().get(i),actual.getDerecha().getPrimeros());
            }
        }
        if(actual.getValue().equals("*") || actual.getValue().equals("+")){
            for(int i = 0; i< actual.getUltimos().size(); i++){
                tabla_siguientes.put(actual.getUltimos().get(i),actual.getPrimeros());
            }
        }
        * */
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