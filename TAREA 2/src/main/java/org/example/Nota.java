package org.example;

public class Nota {

    private String Contenido;

    public Nota(String contenido) {
        this.Contenido = contenido;
    }
    public String getContenido() {
        return Contenido;
    }

    @Override
    public String toString() {
        return "Nota:\n" + Contenido;
    }

}