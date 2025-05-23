package org.example;
import java.time.Instant;

public class Invitacion {

    private Instant hora;
    private Invitable destinatario;

    public Invitacion (Instant hora, Invitable destinatario) {
        this.hora = hora;
        this.destinatario = destinatario;
    }

    public Instant getHora() {
        return hora;
    }

    public Invitable getDestinatario() {
        return destinatario;
    }

    public String toString() {
        return "=== Invitacion ===\n" +
                getDestinatario() +
                "\nHora de invitacion : " + getHora() + "\n";
    }

}

