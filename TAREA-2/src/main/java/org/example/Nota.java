package org.example;

/**
 * Clase {@code Nota}, la cuál permitira añadir notas a una instancia de {@link Reunion}.
 * Las instancias de esta clase, contaran con un atributo que sera un string con el contenido
 * que tendra la nota de la reunión.
 */
public class Nota {
    private String Contenido;

    /**
     * Contructor de una instancia de {@code Nota}, que recibe una cadena de texto con el contenido que tendra.
     *
     * @param contenido, una cadena que contiene una nota respecto de la reunión.
     */
    public Nota(String contenido) {
        this.Contenido = contenido;
    }

    /**
     * Metodo getter que devuelve el contenido de la nota.
     *
     * @return string de lo escrito en la nota respecto de la reunión.
     */
    public String getContenido() {
        return Contenido;
    }

    /**
     * Metodo sobreescrito que, permite visualizar la nota en una cadena de texto.
     * @return cadena de texto con lo que dice la nota de la reunión.
     */
    @Override
    public String toString() {
        return "Nota: " + Contenido;
    }
}
