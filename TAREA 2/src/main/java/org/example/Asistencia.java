package org.example;
import java.time.Instant;

/**
 * Clase {@code Asistencia} representara el registro de asistencia a una reunión de un empleado.
 * Esta clase es extendida de {@link Retraso}.
 * Se almacenara en esta clase un {@link Empleado} que asistio a la reunión y la {@code Instant} como
 * la hora a la que llego a la reunión.
 */
public class Asistencia extends Retraso {
    private Empleado empleado;
    private Instant hora;

    /**
     * Crea una instancia de {@code Asistencia}.
     *
     * @param empleado, el cuál asistio a la reunión.
     * @param hora, es la hora de llegada del empleado a la reunión, esta se utilizara en el constructor
     *             de la super clase {@link Retraso}.
     */
    public Asistencia(Empleado empleado, Instant hora) {
        super(hora);
        this.empleado = empleado;
    }

    /**
     * Metodo getter que devuelve al empleado relacionado a la presente instancia de asistencia.
     * @return el empleado que asistio a la reunión.
     */
    public Empleado getEmpleado() {
        return this.empleado;
    }

    /**
     * Metodo getter que devuelve la hora en la qie llego el empleado.
     * @return la hora de llegada a la reunión.
     */
    public Instant getRetraso() {
        return this.hora;
    }

    /**
     * Metodo sobreescrito de {@link Retraso}, que devuelve una cadena que representa los datos
     * de la instancia actual de {@code Asistencia}.
     *
     * @return una cadena donde se especifica el empleado que asistio y su hora de llegada.
     */
    @Override
    public String toString() {
        return "Empleado: " + getEmpleado() +"\nHora de llegada: " + getRetraso();
    }

}