package org.example;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    protected ArrayList<int> invitados;// usar un array que contenga los invitados almacenando sus id
    protected ArrayList<int> asistentes;// lo mismo que la anterior pero cuadndo llegen se borren de invitados y
                                        // pasena  asistentes
    protected  ArrayList<int> atrasado;//los atrasados

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

        invitados = new ArrayList();
        asistentes = new ArrayList();
        atrasado = new ArrayList();


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

    public void setInvitados(int id){
        invitados.add(id);
    }
    public void setAsistentes(int){
        
    }


}