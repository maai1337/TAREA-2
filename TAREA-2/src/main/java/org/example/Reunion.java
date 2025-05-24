package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.Writer;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private ArrayList<Nota> notas;
    private ArrayList<Asistencia> asistencia;
    private Empleado organizador;
    private tipoReunion tipo;
    private ArrayList<Invitacion> invitados;

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

    public ArrayList<Nota> obtenerNotas() {
        return this.notas;
    }

    public ArrayList<Asistencia> obtenerAsistencias(){
        return this.asistencia;
    }

    public ArrayList<Empleado> obtenerAusencias(){
        return null;
    }

    public ArrayList<Empleado> obtenerRetrasos(){
        return null;
    }

    public int obtenerTotalAsistencias(){
        return asistencia.size();
    }

    public float obtenerPorcentajeAsistencias(){
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

    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    public void addInvitado(Invitacion invitacion){
        invitados.add(invitacion);
    }

    public ArrayList<Invitacion> getInvitados() {
        return this.invitados;
    }

    public float obtenerTiempoReal(){
        if(this.horaInicio != null && this.horaFin != null){
            Duration duracion = Duration.between(this.horaInicio, this.horaFin);
            return duracion.toSeconds()/60f;
        }else {
            return 0;
        }
    }


    @Override
    public String toString() {
        String resultado = "=== DETALLES DE LA REUNIÓN ===\n";
        resultado += "Fecha: " + fecha + "\n";
        resultado += "Organizador: " + organizador.getNombre() + " " + organizador.getApellidos() + "\n";
        resultado += "Tipo: " + tipo + "\n";
        resultado += "Hora prevista: " + horaPrevista + "\n";
        resultado += "Duración prevista: " + duracionPrevista.toMinutes() + " minutos\n";
        if (horaInicio != null) {
            resultado += "Hora de inicio: " + horaInicio + "\n";
        }

        if (horaFin != null) {
            resultado += "Hora de finalización: " + horaFin + "\n";
        }
        resultado += "Duracion real: " + obtenerTiempoReal() + " minutos\n";
        resultado += "Número de invitados: " + invitados.size() + "\n";
        resultado += "Número de asistentes: " + asistencia.size() + "\n";
        resultado += "Lista de asistentes:" + "\n";
        for (Asistencia asistente : asistencia) {
            resultado += asistente.toString(horaInicio) + "\n";
        }
        resultado += "Número de notas: " + notas.size()+"\n";
        resultado += "Notas de la reunión:\n";
        for (Nota nota : notas) {
            resultado += nota.toString() + "\n";
        }
        return resultado;
    }


}
