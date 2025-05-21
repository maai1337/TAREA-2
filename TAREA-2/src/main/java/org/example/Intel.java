package org.example;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Intel {
    private String fecha;
    private String hora_prevista;
    private String hora_inicio;
    private String hora_fin;
    private String duracion;
    private String tipo;
    private String donde;
    private List<Empleado> puntuales;
    private List<Empleado> atraso;

    public Intel() {
        puntuales = new ArrayList<>();
        atraso = new ArrayList<>();


    }
    public void setEmpleados(Reunion reunion) {
        Instant horaPrevista = reunion.getHoraPrevista();
        List<Asistencia> asistentes= reunion.obtenerAsistencias();
        for(Asistencia asistente: asistentes){
            Empleado individuo = asistente.getEmpleado();
            Instant horallego = asistente.getRetraso();
            if(horaPrevista.isBefore(horallego)){
                puntuales.add(individuo);
            }else {
                atraso.add(individuo);
            }
        }
    }
    this.fecha=reunion.getFecha().toString();
    }
