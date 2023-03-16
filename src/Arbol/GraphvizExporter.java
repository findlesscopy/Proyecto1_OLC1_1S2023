package Arbol;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GraphvizExporter{
    public static void convertir(String codigoDot, String rutaArchivoPng) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/arbol"+rutaArchivoPng+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/Pruebas/arbol"+rutaArchivoPng+".jpg", "src/Pruebas/arbol"+rutaArchivoPng+".dot");
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
}