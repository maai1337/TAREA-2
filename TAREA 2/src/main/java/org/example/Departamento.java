package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> listEmpleados;

    public Departamento(String nombre){
        this.nombre = nombre;
        listEmpleados = new ArrayList<Empleado>();
    }
    public void setEmpleado(Empleado ejem){
        if(ejem.getDepartamento == nombre) {
            listEmpleados.add(ejem);
        }
    }
    //nota: no se si es necesario un getter

    public int obtenerCantidadEmpleados(){
        int n = listEmpleados.size()
        return n;
    }

    public void invitar(){}


}
