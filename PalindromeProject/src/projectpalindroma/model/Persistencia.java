package projectpalindroma.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Persistencia {

    public static String leer(BufferedReader entrada, String lectura, String resultado) throws IOException {

        if ((lectura = entrada.readLine()) == null) {
            return resultado;
        } else {
            
            resultado += lectura;
            return leer(entrada, lectura, resultado + " \n");

        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido, boolean validar) throws IOException {
        File archivo = new File(nombreArchivo);
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter(archivo, validar));
            salida.write(contenido);

            System.out.println("Se ha escrito al archivo");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            salida.close();
        }

    }
}