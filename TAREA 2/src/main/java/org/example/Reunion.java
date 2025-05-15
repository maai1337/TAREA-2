package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;


abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;


    public List<Empleado> obtenerAsistencias(){
        return null;
    }

    public List<Empleado> obtenerAusencias(){
        return null;
    }

    public List<Empleado> obtenerRetrasos(){
        return null;
    }

    public int obtenerTotalAsistencias(){
        return 0;
    }

    public float obtenerPorcentajeAsistencias(){
        return 0;
    }

    public float obtenerTiempoReal(){
        return 0;
    }

    public void iniciar(){
        this.horaInicio = Instant.now();
    }

    public void finalizar(){
        this.horaFin = Instant.now();
    }

    public Instant getHoraInicio(){
        return this.horaInicio;
    }

    public Instant getHoraFin(){
        return this.horaFin;
    }

    public Duration getDuracionPrevista(){
        return this.duracionPrevista;
    }

    public Instant getHoraPrevista(){
        return this.horaPrevista;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista = horaPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista = duracionPrevista;
    }

    public void setHoraInicio(Instant horaInicio){
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Instant horaFin){
        this.horaFin = horaFin;
    }

}
