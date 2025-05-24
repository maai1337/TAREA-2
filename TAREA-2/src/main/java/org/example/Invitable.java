package org.example;

/**
 * Interfaz {@code Invitable}, la cuál permite invitar a un empleado o a un departamento por completo
 * a una reunión.
 */
public interface Invitable {
    /**
     * Metodo abstracto que permite invitar, ya sea a un empleado o a un departamento, a una reunión.
     * @param reunion, instancia de la clase {@link Reunion}, a la cuál se esta invitando a alguien.
     */
    public abstract void invitar(Reunion reunion);
}