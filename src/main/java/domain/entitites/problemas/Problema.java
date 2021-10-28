package domain.entitites.problemas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Problema {
    private String descripcionProblema;
    private String nombreProblema;
    private List<Especialidad> especialidadesQueResuelven;
    private Double tiempoEstimadoResolucionEnHoras;

    public Problema(){
        this.especialidadesQueResuelven = new ArrayList<>();
    }

    public void agregarEspecialidadQueResuelve(Especialidad especialidad){
        this.especialidadesQueResuelven.add(especialidad);
    }
}
