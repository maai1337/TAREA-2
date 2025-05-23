package org.example;

import java.time.Instant;

public class Asistencia extends Retraso {
    private Empleado empleado;

    public Asistencia(Empleado empleado, Instant hora) {
        super(hora);
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getRetraso() {
        return super.getHora();
    }

    @Override
    public String toString() {
        return "Empleado: " + getEmpleado().getNombre()
                + " " + getEmpleado().getApellidos();
    }

    public String toString(Instant horaInicio){
        if (getRetraso().isAfter(horaInicio)){
            return "Empleado: " + getEmpleado().getNombre()
                    + " " + getEmpleado().getApellidos() + " | Hora de llegada (Atrasado): " + getRetraso();
        } else {
            return this.toString();
        }
    }

}
