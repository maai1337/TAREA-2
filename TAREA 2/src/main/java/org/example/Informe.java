package org.example;
import java.io.IOException;
import java.nio.file.*;

public class Informe {

    private String texto;
    //la idea es que en el string texto añadir (dentro del cpntructor) todo lo necesario para crear el informe



    public Informe(date fecha, Instant horaInicio, Instant horaFin){

    }
    Path ruta = Paths.get("./Acta_reunion.txt");

        try {
        Files.write(ruta, texto.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println(texto);
    } catch (IOException e) {
        System.out.println("Error al escribir el archivo: " + e);
    }
