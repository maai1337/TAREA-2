package org.example;

import java.time.Instant;

public class Retraso {

    private Instant hora;

    public Retraso(Instant hora) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Retraso: " + hora;
    }
}
