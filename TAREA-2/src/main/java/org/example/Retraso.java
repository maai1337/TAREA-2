package org.example;
import java.time.Instant;

/**
 * Clase {@code Retraso}, la cuál se encargara de ver la hora en que llega un empleado
 * (especificamente cuando llega tarde a la reunión).
 * Cada instancia de esta clase, tendra un unico atributo, que sera la hora en la que el empleado llego.
 */
public class Retraso {
    private Instant hora;

    /**
     * Constructor de una instancia de {@code Retraso}.
     * @param hora a la cuál llegi el empleado.
     */
    public Retraso(Instant hora) {
        this.hora = hora;
    }

    /**
     * Método sobreescrito que devuelve una representación de los datos de una instancia de
     * {@code Retraso} en forma de una cadena de texto.
     * @return sting con la hora de llegada del empleado.
     */
    @Override
    public String toString() {
        return "Retraso: " + hora;
    }
}