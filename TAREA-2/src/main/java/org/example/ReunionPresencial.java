package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {

    private String sala;

    public ReunionPresencial(Date fecha, Empleado organizador, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, String sala) {
        super(fecha, organizador, horaPrevista, duracionPrevista, tipo);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }
}
