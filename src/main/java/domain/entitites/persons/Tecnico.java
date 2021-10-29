package domain.entitites.persons;

import domain.entitites.incidente.Incidente;
import domain.entitites.problemas.Especialidad;
import domain.entitites.notificacion.Notificacion;
import domain.entitites.problemas.Problema;
import domain.entitites.rankeador.criterios.MayorCantIncidentesEspecialidadDias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Integer incidentesResueltosEnNDias(Integer numeroDias){
        return this.incidentesQueParticipo.stream()
                .filter(i -> i.getFechaHoraCierre().isAfter(LocalDateTime.now().minusDays(numeroDias)))
                .collect(Collectors.toList()).size();
    }

    public Integer incidentesResueltosEnNDiasPorEspecialidad(Integer numeroDias, Especialidad especialidad){
        return this.incidentesQueParticipo.stream()
                .filter(i -> i.getFechaHoraCierre().isAfter(LocalDateTime.now().minusDays(numeroDias)))
                .collect(Collectors.toList()).size();
    }

    //el tecnico podria finalizar el incidente, el el incidente se finaliza desde la instancia de incidente.
//    public class finalizarIncidente(){}

}