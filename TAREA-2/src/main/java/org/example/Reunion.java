package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private List<Nota> notas;
    private List<Asistencia> asistencia;
    private Empleado organizador;
    private tipoReunion tipo;
    private List<Invitacion> invitados;

    public Reunion(Date fecha, Empleado organizador,Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo){
        this.fecha = fecha;
        this.organizador = organizador;
        this.notas = new ArrayList<>();
        this.horaPrevista = horaPrevista;
        this.asistencia = new ArrayList<>();
        this.tipo = tipo;
        this.duracionPrevista = duracionPrevista;
        this.invitados = new ArrayList<>();
    }


    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public void eliminarNota(Nota nota) {
        this.notas.remove(nota);
    }

    public List<Nota> obtenerNotas() {
        return this.notas;
    }

    public List<Asistencia> obtenerAsistencias(){
        return this.asistencia;
    }

    public List<Empleado> obtenerAusencias(){
        return null;
    }

    public List<Empleado> obtenerRetrasos(){
        return null;
    }

    public int obtenerTotalAsistencias(){
        return asistencia.size();
    }

    public float obtenerPorcentajeAsistencias(){
        if (asistencia.size() > 0) {
            return (float) (obtenerTotalAsistencias() * 100) /invitados.size();
        }else{
            return 0;
        }


    }

    public float obtenerTiempoReal(){
        if(this.horaInicio != null && this.horaFin != null){
            Duration duracion = Duration.between(this.horaInicio, this.horaFin);
            return duracion.toSeconds()/60f;
        }
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

    public Empleado getOrganizador() {
        return organizador;
    }

    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencia.add(asistencia);
    }

    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    public List<Nota> getNotas() {
        return this.notas;
    }

    public void addInvitado(Invitacion invitacion){
        invitados.add(invitacion);
    }

    public List<Invitacion> getInvitados() {
        return this.invitados;
    }

}
