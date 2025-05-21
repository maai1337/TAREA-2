package org.example;

import java.time.Instant;

public class Nota {

    private String Contenido;
    private Instant minuto;
    public Nota(String contenido) {
        this.Contenido = contenido;
        this.minuto = Instant.now();
    }
    public String getContenido() {
        return Contenido;
    }
    public String getMinuto() {
        return minuto.toString();
    }
}
