package org.example;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

/**
 * Clase encargade de crear el informe de la reunión.
 */
public class Informe {
    Informe(String intel1){
        String intel =intel1;
    }

    /**
     * Constructor de informe.
     * @param intel la cadena de texto que se desea escribir en el archivo.
     */
    public static void impre( String intel) {

        String inte=intel;
        byte data[] = inte.getBytes();
        Path p = Paths.get("./informe.txt");

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    /**
     * Metodo getter que devuelve path.
     * @return path en forma de string.
     */
    public String gettpath(){
        String path = "./informe.txt";
        return path;
    }
}