package domain.entitites.rankeador.criterios;

import domain.entitites.persons.Tecnico;
import domain.entitites.problemas.Especialidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MayorCantIncidentesEspecialidadDias {

    private Especialidad especialidad;
    private Integer numeroDias;

    public Tecnico obtenerTecnico(List<Tecnico> tecnicos){
        return tecnicos.stream().
                filter(tecnico -> tecnico.getIncidentesQueParticipo().
                        stream().
                        filter(
                                incidente -> incidente.getFechaHoraAlta().isAfter(LocalDateTime.now().minusDays(numeroDias))
                        ).count()).max();

        return null;
//        tecnicos.get(1).getIncidentesQueParticipo().get(1).getFechaHoraCierre();
//
//        incidente.getFechaHoraCierre().isAfter(
//                LocalDateTime.now().minusDays(numeroDias)


//        incidente -> incidente.getFechaHoraAlta().isAfter(LocalDateTime.now().minusDays(numeroDias))

    }
}
