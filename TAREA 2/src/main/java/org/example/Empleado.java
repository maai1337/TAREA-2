package org.example;

import java.time.Instant;

/**
 * Clase {@code Empleado} que representa a un empleado de una empresa.
 * Esta clase implementa la interfaz {@link Invitable}.
 * Cada instancia contendra como atributos distintos strings que almacenaran el id, el nombre,
 * el apellido y el correo del empleado, ademas de a que departamento pertenece.
 */
public class Empleado implements Invitable {

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    private Departamento departamento;

    /**
     * Constructor que crea una nueva instancia de Empleado.
     * @param id con el cuál se identificara al empleado.
     * @param apellidos del empleado.
     * @param nombre del empleado.
     * @param correo del empleado.
     * @param departamento al cuál pertenecera este empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    /**
     * Metodo getter que devuelve el id de esta instancia de empleado.
     * @return el id del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo setter que agregara un string que sera el id del empleado.
     * @param id que sera el nuevo id del empleado.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo getter que devolvera el apellido de esta instancia de empleado.
     * @return el apellido de este empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo setter que agrega o cambia el apellido de la actual instancia de empleado.
     * @param apellidos que sera el nuevo apellido del empleado
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo getter que devuelve el nombre de esta instancia de empleado.
     * @return el nombre de este empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setter que agrega o cambia el nombre de la actual instancia de empleado.
     * @param nombre que sera el nuevo nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getter que devuelve el correo de esta instancia de empleado.
     * @return el correo de empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo setter que agrega o cambia el correo de la actual instancia de empleado.
     * @param correo que sera el nuevo correo del empleado.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo getter que devuelve el departamento al que pertenece la instancia actual de empleado.
     * @return el departamento a que pertenece el empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Metodo setter que agrega o cambia el departamento de la actual instancia de empleado.
     * @param departamento que sera el nuevo departamento del empleado.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Metodo sobreescrito de {@link Invitable}, en este se invitara al empleado a una reunión.
     * @param reunion instancia de la clase {@link Reunion}, a la cuál se invitara al empleado.
     *
     * En este metodo se crea una instancia de {@link Invitacion}, el cuál utilizara el tiempo actual
     * y a la actual instancia de empleado para su constructor.
     * Luego se agrega la instancia de {@link Invitacion} a una lista de invitados de la instancia de
     * {@link Reunion}.
     */
    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(Instant.now(), this);
        reunion.addInvitado(inv);
    }

    /**
     * Metodo sobreescrito donde se representa la actual instancia de clase la clase empleado.
     * @return una cadena que contiene el nombre, apellido, id y correo del empleado.
     */
    @Override
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos +
                "\nID: " + id +
                "\nCorreo: " + correo + "\n";
    }
}