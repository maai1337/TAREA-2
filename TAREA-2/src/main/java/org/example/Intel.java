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
    private List<Nota> notas;

    public Intel(Reunion reunion,ReunionPresencial reunionPresencial,ReunionVirtual reunionVirtual) {
        puntuales = new ArrayList<>();
        atraso = new ArrayList<>();
        notas = new ArrayList<>();
        this.fecha=reunion.getFecha().toString();
        this.hora_prevista=reunion.getHoraPrevista().toString();
        this.hora_inicio=reunion.getHoraInicio().toString();
        this.hora_fin=reunion.getHoraFin().toString();
        this.tipo=reunion.getTipo();
        if(reunionPresencial!=null) {
            this.donde=reunionPresencial.getSala();
        }else{
            this.donde=reunionVirtual.getEnlace();
        }



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
    public void setNotas(Reunion reunion) {

    }

}
