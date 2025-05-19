package org.example;
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {

    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void invitar(Reunion reunion){
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }


}
