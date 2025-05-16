package org.example;
import java.time.*;
import java.util.Date;
import java.util.List;


abstract public class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;


    public Reunion(int hora, int minuto, int minutos_reunion) {
        this.fecha = LocalDate.now();
        this.duracionPrevista = Duration.ofMinutes(minutos_reunion);

        /**
         * debo ver como colocar la hora a hora chile como instant trbaja con utc
         * o dejarlo asi nada mas
         * */

        ZoneId horaCompu = ZoneId.systemDefault();
        LocalDateTime fechahora =LocalDateTime.of(this.fecha, LocalTime.of(hora,minuto));
        Instant horaPrevista = ZonedDateTime.of(LocalDateTime.now(), horaCompu).toInstant(hora,minuto);
        ZonedDateTime zonedDateTime = horaPrevista.atZone(zonaCompu);
        this.horaPrevista = zonedDateTime.toInstant();
        // ver como arreglar esto

    }

    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFin = Instant.now();
    }

    public Instant getHoraPrevista() {
        return horaPrevista;

    }

    public float calcularTiempoReal(){
        if (this.horaInicio != null && this.horaFin != null) {
            Duration duracion = Duration.between(this.horaInicio, this.horaFin);
            return duracion.toSeconds() / 60f;
        }else {
            return 0;
        }
    }


}