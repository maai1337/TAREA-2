package org.example;
import java.time.Instant;

/**
 * Clase {@code Invitacion}, el cuál representa una invitación a una reunión que sera solo para un empleado.
 * En cada instancia de esta clase se debera contar con dos atributos:
 * La hora de la reunión y el destinatario de la invitación.
 */
public class Invitacion {

    private Instant hora;
    private Invitable destinatario;

    /**
     * Constructor de una nueva instancia de {@code Invitacion}.
     * A este se le ddebera entregar una hora y un destinatario para crear la instancia.
     * @param hora que tendra la invitación.
     * @param destinatario de la invitación de la reunión.
     */
    public Invitacion (Instant hora, Invitable destinatario) {
        this.hora = hora;
        this.destinatario = destinatario;
    }

    /**
     * Metodo getter que devuelve la hora de la reunión.
     * @return la hora de la invitación invitación
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Metodo getter que devuelve el destinatario de la invitación.
     * @return el destinatario a invitar.
     */
    public Invitable getDestinatario() {
        return destinatario;
    }

    /**
     * Metodo sobreescrito, donde se representaran los datos de esta instancia de {@code Invitacion}.
     * @return una cadena que contiene el destinatario de la invitación y la hora de la invitación.
     */
    @Override
    public String toString() {
        return "=== Invitacion ===\n" +
                getDestinatario() +
                "Hora de invitacion : " + getHora() + "\n";
    }

}

