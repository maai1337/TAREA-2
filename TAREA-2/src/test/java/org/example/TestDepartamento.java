package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class DepartamentoTest {

    /** Test para comprobar que al invitar al departamento se invite a todos los empleados del departamento */
    @DisplayName("Test de Invitacion a departamento")
    @Test
    void TestInvitacion() {
        Departamento d1 = new Departamento("Programacion");
        Empleado organizador = new Empleado("1","Aros","Benjamin","dvalenzuela@correo.com", d1);
        Empleado empleado1 = new Empleado("2", "Zuñiga", "Gabriel", "jperez@correo.com", d1);


        ReunionVirtual r = new ReunionVirtual(new Date(2025), empleado1, Instant.now(), Duration.ofHours(2), tipoReunion.TECNICA, "https:/reunion.com");
        d1.invitar(r);

        ArrayList<Invitacion> invitados = r.getInvitados();

        // Verifica que cada empleado del departamento esté invitado
        for (Empleado empleado : d1.getEmpleados()) {
            boolean estaInvitado = false;
            for (Invitacion invitacion : invitados) {
                if (invitacion.getDestinatario() == empleado) {
                    estaInvitado = true;
                }
            }
            assertTrue(estaInvitado, "El empleado " + empleado.getNombre() + " debe estar invitado");
        }

    }
}