package Proyecto1;
import Analizadores.Lexer;
import Analizadores.parser;
import java.io.File;
import java.util.Scanner;
public class Proyecto1 {
    public static void main(String[] args) throws Exception{
        StringBuilder data = new StringBuilder();
        File doc = new File("src/Analizadores/archivo.olc");
        Scanner obj = new Scanner(doc);
        while(obj.hasNextLine()) {
            data.append(obj.nextLine());

        }
        interpretar(data.toString());
        //interpretar("{\n//Comentario de una linea \n CONJ: letra -> a~z;\n //expresiones regulares ExpReg1 -> .{letra}*|\"_\"{letra}; \n %% %% ExpReg1 : \"primerlexema\"; \n }");
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