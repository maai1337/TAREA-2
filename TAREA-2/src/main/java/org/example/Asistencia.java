package org.example;

import java.time.Instant;

public class Asistencia extends Retraso {
    private Empleado empleado;
    private Instant hora;

    public Asistencia(Empleado empleado, Instant hora) {
        super(hora);
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public Instant getRetraso() {
        return this.hora;
    }

}
