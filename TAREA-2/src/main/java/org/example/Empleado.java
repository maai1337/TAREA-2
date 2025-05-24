package org.example;

import java.time.Instant;

public class Empleado implements Invitable {

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    private Departamento departamento;

    // Constructor
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public void invitar(Reunion reunion) {
        Invitacion inv = new Invitacion(Instant.now(), this);
        reunion.addInvitado(inv);
    }

    public void asistir(Reunion reunion) {

        // Revisa q el empleado esté invitado
        for (Invitacion invitacion : reunion.getInvitados()) {
            if (invitacion.getDestinatario() == this) {
                Asistencia asistencia = new Asistencia(this, Instant.now());
                reunion.agregarAsistencia(asistencia);
                reunion.quitarInvitado(invitacion);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos +
                "\nID: " + id +
                "\nCorreo: " + correo + "\n";
    }
}