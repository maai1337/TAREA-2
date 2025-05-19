package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Main meramente orientativo
 */
public class Main {
    public static void main(String[] args) {

        Departamento departamento = new Departamento("DEPARTAMENTO");

        Empleado empleado1 = new Empleado("1", "García", "Pedro", "pedro@empresa.com", departamento);
        Empleado empleado2 = new Empleado("2", "Martínez", "Ana", "ana@empresa.com", departamento);
        Empleado empleado3 = new Empleado("3", "López", "Carlos", "carlos@empresa.com", departamento);


        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);
        departamento.agregarEmpleado(empleado3);



        Reunion reunion = new ReunionPresencial(new Date(2025), empleado1, Instant.now(), Duration.ofHours(2), tipoReunion.TECNICA, "Sala 101");
        empleado3.invitar(reunion);
        departamento.invitar(reunion);

        for (Invitacion invitacion : reunion.getInvitados()) {
            System.out.println(invitacion.getDestinatario());
            System.out.println(invitacion.getHora());
        }



    }
}