package domain.entitites.rankeador;

import domain.entitites.persons.Tecnico;
import domain.entitites.rankeador.criterios.CriterioRankeadorTecnico;

import java.util.List;

public class RankeadorTecnico {
    private CriterioRankeadorTecnico criterio;

    public Tecnico obtenerTecnico(List<Tecnico> tecnicos){
        return this.criterio.obtenerTecnico(tecnicos);
    }
}
