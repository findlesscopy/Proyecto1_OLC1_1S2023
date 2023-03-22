package Arbol;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GraphvizExporter{
    public static void convArbol(String codigoDot, String rutaArchivoPng) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/arbol_"+rutaArchivoPng+".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/Arboles_202001800/arbol_"+rutaArchivoPng+".jpg", "src/Pruebas/arbol_"+rutaArchivoPng+".dot");
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

    public static void ConvSiguientes(String codigoDot, String rutaArchivoPng) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/siguientes_" + rutaArchivoPng + ".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/Siguientes_202001800/siguientes_" + rutaArchivoPng + ".jpg", "src/Pruebas/siguientes_" + rutaArchivoPng + ".dot");
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
    public static void convTransiciones(String codigoDot, String rutaArchivoPng){
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/transiciones_" + rutaArchivoPng + ".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/Transiciones_202001800/transiciones_" + rutaArchivoPng + ".jpg", "src/Pruebas/transiciones_" + rutaArchivoPng + ".dot");
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
    public static void convAFD(String codigoDot, String rutaArchivoPng){
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("src/Pruebas/AFD_" + rutaArchivoPng + ".dot");
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(codigoDot);
            pw.println(codigoDot);
            pw.close();
            try {

                ProcessBuilder proceso;
                proceso = new ProcessBuilder("dot", "-Tjpg", "-o", "src/AFD_202001800/AFD_" + rutaArchivoPng + ".jpg", "src/Pruebas/AFD_" + rutaArchivoPng + ".dot");
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
}
