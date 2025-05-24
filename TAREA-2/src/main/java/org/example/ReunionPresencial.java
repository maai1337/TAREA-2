package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase {@code ReunionPresencial}, extendida de {@link Reunion}.
 * Esta subclase representa una reunión realizada de forma presencial.
 * Cada instancia, contiene un atributo que es la sala en que es llevada
 * a cabo la reunión.
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Constructor de una nueva instancia de {@code ReunionPresencial}, se usara el constructor
     * de la super clase para inicializar los atributos heredados.
     * @param fecha de la reunión.
     * @param organizador, instancia de {@link Empleado} que sera quien organize la reunión.
     * @param horaPrevista, la hora teoirca donce deberia empezar la reunión.
     * @param duracionPrevista, la duracion teorica de la reunión.
     * @param tipo, el tipo de reunión.
     * @param sala en que se realizara la reunión.
     */
    public ReunionPresencial(Date fecha, Empleado organizador, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, String sala) {
        super(fecha, organizador, horaPrevista, duracionPrevista, tipo);
        this.sala = sala;
    }

    /**
     * Metodo getter que devuelve la sala donde se realizara la reunión.
     * @return la sala de la reunión.
     */
    public String getSala() {
        return sala;
    }
    /**
     * Metodo sobreescrito que devuele una representación de los valores de {@code ReunionPresencial},
     * representados como una cadena de texto.
     * Este metodo usa este mismo metodo de la super clase, y le añade una cadena con el enlace de
     * la reunión.
     * @return una cadena de texto con los datos de esta instancia de {@code ReunionPresencial}.
     */
    @Override
    public String toString() {
        return super.toString() + "\nSala: " + sala;
    }


}