package domain.entitites.rankeador.criterios;

import domain.entitites.incidente.Incidente;
import domain.entitites.persons.Tecnico;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MayorCantIncidentesNDias implements CriterioRankeadorTecnico{

    private Integer numeroDias;

    public Tecnico obtenerTecnico(List<Tecnico> tecnicos){

//        return tecnicos.stream().max(t -> t.incidentesResueltosEnNDias(numeroDias).size());
//        return tecnicos.stream().max(Comparator.comparing(Tecnico::incidentesResueltosEnNDias));
//        return Collections.max(tecnicos, Comparator.comparing(Tecnico::incidentesResueltosEnNDias));

        Tecnico tec = Collections.max(Comparator.comparing(Tecnico::incidentesResueltosEnNDias));
        return null;

    }
}
