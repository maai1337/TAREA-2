package org.example;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class Informe {
    Informe(String intel1){
        String intel =intel1;
    }
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
    public String gettpath(){
        String path = "./informe.txt";
        return path;
    }
}