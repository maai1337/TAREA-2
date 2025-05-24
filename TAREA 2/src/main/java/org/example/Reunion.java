package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase abstracta {@code Reunion}, la cuál representara una reunión.
 * Esta contara con distintos atributos, tales como la fecha, la hora prevista de la reunión, la duración
 * prevista, el horario de inicio y final de la reunión. Ademas de contar con tres listas, una para almacenar
 * las notas de la reunión, otra para almacenar a los empleados que asistieron y por último otra con las
 * invitaciones que se entregaron a los empleados. Por último, cada reunión cuenta con una instancia de
 * {@link Empleado} que sera el organizador de la reunión, y esta podra ser de distintos tipos de reuniones.
 */
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

    /**
     * Constructor de {@code Reunion}, que da valor e inicializa los atrivutos de la clase.
     * @param fecha de la reunión a realizar.
     * @param organizador, instancia de {@link Empleado} que es quien organiza la reunión actual.
     * @param horaPrevista, la hora a la que deberia empezar la reunión.
     * @param duracionPrevista, el tiempo que deberia durar la reunión en teoria.
     * @param tipo, el tipo de reunión, los cuales estan listados en un ENUM {@link tipoReunion} con tres
     *              posibles tipos de reunión.
     * De igual forma se inicializan las listas previamentes mencionadas.
     */
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

    /**
     * Metodo que agrega una nota sobre la reunión.
     * @param nota, instancia de {@link Nota}, que contiene un string con una nota de la reunión,
     *              esta se agregara en la lista notas.
     */
    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    /**
     * Metodo que elimina una nota de la lista notas,
     * @param nota que sera eliminada de la lista.
     */
    public void eliminarNota(Nota nota) {
        this.notas.remove(nota);
    }

    /**
     * Metodo que devuelve la lista con las notas de la reunión.
     * @return la lista notas.
     */
    public ArrayList<Nota> obtenerNotas() {
        return this.notas;
    }

    /**
     *Metodo que devuelve la lista que contiene quienes fueron a la reunión.
     * @return la lista de asistencia de empleados.
     */
    public ArrayList<Asistencia> obtenerAsistencias(){
        return this.asistencia;
    }

    /**
     * Metodo para obtener la ausencias, de aquellos empleados que fueron invitados pero no asistieron
     * a la reunión.
     * @return una lista con los empleados que faltaron a la reunión
     */
    public ArrayList<Invitacion> obtenerAusencias(){
        return invitados;
    }

    /**
     * Metodo que permite saber que empleados llegaron atrasados a la reunión.
     * @return una lista con los empleados que llegaron atrasados.
     */
    public ArrayList<Empleado> obtenerRetrasos(){
        ArrayList<Empleado> retrasos = new ArrayList<>();
        for (Asistencia asistencia : this.asistencia) {
            if (asistencia.getRetraso().isAfter(horaInicio)) {
                retrasos.add(asistencia.getEmpleado());
            }
        }
        return retrasos;
    }

    /**
     * Metodo que devuelve la cantidad de asistencia a la reunión.
     * @return un valor entero que representara la asistencia a la reunión.
     */
    public int obtenerTotalAsistencias(){
        return asistencia.size();
    }

    /**
     * Metodo que devuelve el porcentaje de asistencia de la reunión.
     * @return
     */
    public float obtenerPorcentajeAsistencias(){
        return ((float) obtenerTotalAsistencias() / (float) totalInvitados) * 100;
    }

    /**
     * Metodo que permite obtener el tiempo real de la reunión.
     * @return el tiempo real de la reunión.
     */
    public float obtenerTiempoReal(){
        if(this.horaInicio != null && this.horaFin != null){
            Duration duracion = Duration.between(this.horaInicio, this.horaFin);
            return duracion.toSeconds()/60f;
        }else {
            return 0;
        }
    }

    /**
     * Metodo que permitira dar inicio a una reunión.
     * Se guardara la hora en que se ocupe este metodo en la variable horaInicio.
     */
    public void iniciar(){
        this.horaInicio = Instant.now();
    }

    /**
     * Metodo que permitira dar fin a una reunión.
     * Se guardara la hora en que se ocupe este metodo en la variable horaFin.
     */
    public void finalizar(){
        this.horaFin = Instant.now();
    }

    /**
     * Metodo getter que devuelve la hora en que inicio la reunión.
     * @return la hora en que la reunión dio inicio.
     */
    public Instant getHoraInicio(){
        return this.horaInicio;
    }

    /**
     * Metodo getter que devuelve la hora en que finalizo la reunión.
     * @return la hora en que la reunión dio fin.
     */
    public Instant getHoraFin(){
        return this.horaFin;
    }

    /**
     * Metodo getter que devuelve la duracion prevista de la reunión.
     * @return la duración teorica de la reunión.
     */
    public Duration getDuracionPrevista(){
        return this.duracionPrevista;
    }

    /**
     * Metodo getter que devuelve la hora prevista  de inicio de la reunión.
     * @return la hora en la cuál teoricamente la reunión iniciara.
     */
    public Instant getHoraPrevista(){
        return this.horaPrevista;
    }

    /**
     * Metodo getter que devuelve la fecha de la reunión.
     * @return la fecha de la actual reunión.
     */
    public Date getFecha(){
        return this.fecha;
    }

    /**
     * Metodo setter el cuál permite modificar la fecha de la reunión.
     * @param fecha la cuál sera la reunión.
     */
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    /**
     * Metodo setter que permite modificar la hora prevista de la reunión.
     * @param horaPrevista, que sera la hora en que en teoria empezaría la reunión.
     */
    public void setHoraPrevista(Instant horaPrevista){
        this.horaPrevista = horaPrevista;
    }

    /**
     * Metodo setter que permite modificar la duración prevista de la reunión.
     * @param duracionPrevista, nueva duración teorica de la reunión.
     */
    public void setDuracionPrevista(Duration duracionPrevista){
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Metodo setter que permite cambiar la hora de inicio de la reunión.
     * @param horaInicio sera la nueva hora de inicio de la reunión.
     */
    public void setHoraInicio(Instant horaInicio){
        this.horaInicio = horaInicio;
    }

    /**
     * Metodo setter que permide cambiar la hora de fin de la reunión.
     * @param horaFin sera la nueva hora de finalización de la reunión.
     */
    public void setHoraFin(Instant horaFin){
        this.horaFin = horaFin;
    }

    /**
     * Metodo getter que devuelve la instancia de {@link Empleado} que es el organizador
     * de la reunión.
     * @return el organizador de la reunión.
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    /**
     * Metodo que permite agregar a la lista asistencia la asistencia de un empleado.
     * @param asistencia de un empleado, con su hora de llegada a la reunión.
     */
    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencia.add(asistencia);
    }

    /**
     * Metodo que permite agregar una nota de la reunión a la lista de notas.
     * @param nota que se agregara a la lista.
     */
    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    /**
     * Metodo getter que devuelve la lista de notas de la reunión.
     * @return la lista de notas.
     */
    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    /**
     * Metodo que permite agregar una invitación a la lista de invitados.
     * @param invitacion que recive un empleado para ser invitado a la reunión.
     * @return retornara nada si el destinatario ya tiene una invitación.
     */
    public void addInvitado(Invitacion invitacion){
        for (Invitacion inv : this.invitados) {
            if (inv.getDestinatario() == invitacion.getDestinatario()) {
                return; // Ya existe una invitación para este destinatario
            }
        }
        invitados.add(invitacion);
        totalInvitados++;
    }

    /**
     * Metodo que permite obtener el total de invitados de la reunión.
     * @return el total de invitados de la reunión.
     */
    public int obtenerTotalInvitados(){
        return this.totalInvitados;
    }

    /**
     * Metodo que permite quitar un invitado de la lista de invitados.
     * @param invitacion que sera eliminada.
     */
    public void quitarInvitado(Invitacion invitacion){
        invitados.remove(invitacion);
    }

    /**
     * Metodo getter que devuelve la lista de invitados de la reunión.
     * @return la lista de invitados.
     */
    public ArrayList<Invitacion> getInvitados() {
        return this.invitados;
    }

    /**
     * Metodo sobreescrcito que devuelve una representación de los datos de {@code Reunion}, mostrando
     * su contenidos en cadenas/strings.
     * En una variable String se van guardando cadenas con la feche, organizador, tipo, hora prevista,
     * y duración prevista de la reunión. Ademas, por medio de if que comprueban si "horaInicio" o "horaFin"
     * no son {@code null}, se agregan la hota de inicio y fin de la reunión. Por último se agregan a la cadena
     * el número de invitados, de asistencias y de notas (esto en formato string).
     * @return una cadena con todos los datos anteriormente mencionados.
     */
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
