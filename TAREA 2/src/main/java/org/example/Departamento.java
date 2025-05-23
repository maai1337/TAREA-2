package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * CLase {@code Departamento} que representara un departamento especifico de la empresa, a la cuál,
 * ciertos empleados perteneceran.
 * Esta clase implementa la interfaz {@link Invitable}.
 * Cada instancia de la clase contara con dos atributos: el nombre del departamento y un ArrayList con
 * los empleados que pertenecen a este departamento.
 */
public class Departamento implements Invitable {
    private String nombre;
    private ArrayList<Empleado> empleados;

    /**
     * Constructor que crea una instancia de {@code Departamento}.
     * En este se inicializara el Arraylist que guardara los empleados que hay en este departamentp.
     * @param nombre que tendra el departamento.
     */
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     *Metodo que agrega un empleado al ArrayList de empleados del departamento.
     * @param empleado que se agregara al departamento.
     */
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    /**
     * Metodo que devuelve el número de empleados que hay en esta instancia de departamento.
     * @return un valor entero que representa el número de empleados del departamento.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Metodo getter que devuelve el nombre del departamento.
     * @return el nombre de la instancia actual de departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo sobreescrito de {@link Invitable}. En este se invitara a los empleados del departamento a
     * una reunión.
     * @param reunion, instancia de la clase {@link Reunion}, a la cuál los empleados del departamento
     *                 serán invitados.
     * Con un ciclo for, se recorrera el ArrayList empleados, invitando a cada empleado de la lista
     */
    @Override
    public void invitar(Reunion reunion){
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }

    /**
     * Metodo getter que devuelve la lista de empleados del departamento.
     * @return un ArrayLits que contiene instancias de {@code Empleados} pertenecientes a
     * la actual instancia del departamento.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Metodo sobreescrito que devuelve una representación de los datos de departamento.
     * Con un ciclo for, va añadiendo a una cadena Stirng a cada una de las instancias de
     * {@code Empleados} presentes en la lista de empleados.
     * @return una cadena que contiene el nombre del departamento y de cada uno de los empleados
     * pertenecientes a este.
     */
    @Override
    public String toString() {
        String str = "=== DEPARTAMENTO " + nombre + " ===\n";
        for (Empleado empleado : empleados) {
            str += empleado.toString() + "\n";
        }
        return str;
    }


}
