package domain.entitites.persons;

import domain.entitites.incidente.Incidente;
import domain.entitites.problemas.Especialidad;
import domain.entitites.notificacion.Notificacion;
import domain.entitites.problemas.Problema;
import domain.entitites.rankeador.criterios.MayorCantIncidentesEspecialidadDias;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tecnico {
    private String nombreTecnico;
    private String apellidoTecnico;
    private String emailTecnico;
    private String numeroCompleto;
    private boolean disponible;
    private List<Especialidad> especialidades;
    private List<Incidente> incidentesQueParticipo;

    public Tecnico(){
        this.especialidades = new ArrayList<>();
        this.incidentesQueParticipo = new ArrayList<>();
    }

    public boolean estasDisponible(){
        return this.disponible;
    }

    public boolean resuelveProblema(Problema problema){
        return especialidades
                .stream()
                .anyMatch(e -> problema.getEspecialidadesQueResuelven().contains(e));
    }

    public void recibirNotificacion(Notificacion notificacion){
        //todo
    }

    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }

    public void agregarIncidenteQueParticipa(Incidente incidente){
        this.incidentesQueParticipo.add(incidente);
    }

    //el tecnico podria finalizar el incidente, el el incidente se finaliza desde la instancia de incidente.
//    public class finalizarIncidente(){}

}