package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase {@code ReunionVirtual}, extendida de {@link Reunion}.
 * Esta subclase representa una reunión realizada de forma online.
 * Cada instancia contiene un atributo que es el enlace de la reunión.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de una nueva instancia de {@code ReunionVirtual}, se usará el constructor
     * de la super clase para inicializar los atributos heredados.
     *
     * @param fecha             de la reunión.
     * @param organizador,      instancia de {@link Empleado} que será quien organize la reunión.
     * @param horaPrevista,     la hora teoirca donce deberia empezar la reunión.
     * @param duracionPrevista, la duracion teorica de la reunión.
     * @param tipo,             el tipo de reunión.
     * @param enlace            de la reunión.
     */
    public ReunionVirtual(Date fecha, Empleado organizador, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, String enlace) {
        super(fecha, organizador, horaPrevista, duracionPrevista, tipo);
        this.enlace = enlace;
    }

    /**
     * Metodo getter que devuelve el enlace de la reuinón.
     *
     * @return el enlace de la reunión virtual.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Metodo sobreescrito que devuele una representación de los valores de {@code ReunionVirtual},
     * representados como una cadena de texto.
     * Este metodo usa este mismo metodo de la super clase, y le añade una cadena con el enlace de
     * la reunión.
     *
     * @return una cadena de texto con los datos de esta instancia de {@code ReunionVirtual}.
     */
    @Override
    public String toString() {
        return super.toString() + "\nEnlace: " + enlace;
    }
}
