package utez.edu.mx.Herramientas;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
    
    public static void escribir(String nombreArchivo, String[] mensajes){
        try {
            FileWriter escritor = new FileWriter(nombreArchivo + ".txt");
            for (String mensaje : mensajes){
                escritor.write(mensaje + "\n");
            }
            escritor.close();
            System.out.println("Se ha creado el archivo " + nombreArchivo + " correctamente");
        } catch (IOException e){
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
    }
    public static void escribir(String nombreArchivo, String mensaje){
        try {
            FileWriter escritor = new FileWriter(nombreArchivo + ".txt");
            escritor.write(mensaje + "\n");
            escritor.close();
            System.out.println("Se ha creado el archivo " + nombreArchivo + " correctamente");
        } catch (IOException e){
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
    }
}
