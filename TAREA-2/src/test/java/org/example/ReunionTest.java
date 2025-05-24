package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    private Departamento departamento;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private ReunionPresencial reunion;

    @BeforeEach
    void setUp() {
        // Configuración inicial para cada test
        departamento = new Departamento("Desarrollo");
        organizador = new Empleado("1", "Zuñiga", "Gabriel", "gabriel@empresa.com", departamento);
        empleado1 = new Empleado("2", "Fuentes", "Ana", "ana@empresa.com", departamento);
        empleado2 = new Empleado("3", "Aros", "Gabriel", "gabriel@empresa.com", departamento);

        // Crea una reunión presencial para las pruebas
        reunion = new ReunionPresencial(
                new Date(2025),
                organizador,
                Instant.now(),
                Duration.ofHours(1),
                tipoReunion.TECNICA,
                "Sala 101"
        );
    }

    @DisplayName("Test para verificar invitación a reunión")
    @Test
    void testInvitacion() {

        empleado1.invitar(reunion);

        // Verificar que hay una invitación
        assertEquals(1, reunion.obtenerTotalInvitados());
    }

    @DisplayName("Test para verificar asistencia a reunión")
    @Test
    void testAsistencia() {

        empleado1.invitar(reunion);

        empleado1.asistir(reunion);

        // Verificar asistencia
        assertEquals(1, reunion.obtenerTotalAsistencias());
        assertEquals(0, reunion.getInvitados().size());  // Ya no hay invitaciones pendientes
    }

    @DisplayName("Test para verificar retraso en reunion")
    @Test
    void testRetraso() throws InterruptedException {

        empleado1.invitar(reunion);

        reunion.iniciar();

        Thread.sleep(100); // Simular un retraso

        empleado1.asistir(reunion);

        assertEquals(1, reunion.obtenerRetrasos().size(), "Deberia haber un retraso");
        assertEquals(empleado1, reunion.obtenerRetrasos().get(0), "El empleado con retraso deberia ser el mismo que asistio");

    }


    @DisplayName("Test para verificar inicio y fin de reunión")
    @Test
    void testInicioFinReunion() {

        reunion.iniciar();

        // Verificar que se registró la hora de inicio
        assertNotNull(reunion.getHoraInicio());

        // Finalizar reunión
        reunion.finalizar();

        // Verificar que se registró la hora de fin
        assertNotNull(reunion.getHoraFin());
    }

    @DisplayName("Test para verificar notas en reunión")
    @Test
    void testNotas() {

        Nota nota1 = new Nota("Primera nota");
        reunion.agregarNota(nota1);

        // Verificar que se agregó la nota
        assertEquals(1, reunion.getNotas().size());
        assertEquals("Primera nota", reunion.getNotas().get(0).getContenido());
    }
}