package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertSame;

    /** Tests unitario para la invitacion */
    class InvitacionTest {

        Empleado emp1;
        Invitacion inv;

        @BeforeEach
        void setUp(){
            Departamento dep = new Departamento("Programacion");
            emp1 = new Empleado("1", "Zuñiga", "2", "jperez@correo.com", dep);
            ReunionVirtual r = new ReunionVirtual(new Date(2025), emp1, Instant.now(), Duration.ofHours(2), tipoReunion.TECNICA, "https:/reunion.com");
            emp1.invitar(r);
            inv = r.getInvitados().get(0);
        }

        @DisplayName("Test de Invitacion correcta")
        @Test
        void getEmpleado() {
            assertSame(inv.getDestinatario(), emp1);
        }

    }
