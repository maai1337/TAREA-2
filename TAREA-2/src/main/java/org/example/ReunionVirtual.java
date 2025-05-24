package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {

    private String enlace;

    public ReunionVirtual(Date fecha, Empleado organizador, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, String enlace) {
        super(fecha, organizador, horaPrevista, duracionPrevista, tipo);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEnlace: " + enlace;
    }



}
