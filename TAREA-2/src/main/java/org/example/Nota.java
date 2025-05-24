package org.example;

import java.time.Instant;

public class Nota {

    private String Contenido;
    private Instant hora;
    public Nota(String contenido) {
        this.Contenido = contenido;
        this.hora = Instant.now();
    }
    public String getContenido() {
        return Contenido;
    }

    @Override
    public String toString() {
        return  Contenido + "  " + hora +"\n";
    }

}
