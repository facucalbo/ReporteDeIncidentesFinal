package domain.incidentes;

import domain.entitites.incidente.EstadoIncidente;
import domain.entitites.incidente.Incidente;
import domain.entitites.incidente.PosibleEstadoIncidente;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FinalizarIncidente extends IngresarIncidente{

    PosibleEstadoIncidente estadoFinalizado;

    @Override
    public void init() {
        super.init();
        estadoFinalizado = new PosibleEstadoIncidente("Finalizado");

        incidente = new Incidente(estadoFinalizado);
    }

    public void finalizarIncidente(){
        super.seConfirmaIncidente();
        incidente.finalizarIncidente(estadoFinalizado);
    }

    @Test
    public void cambiaEstadoIncidenteAFinalizado(){
        finalizarIncidente();

        Assert.assertEquals("Finalizado", incidente.getEstadosIncidente().get(2).getPosibleEstadoIncidente().getNombreEstado());
    }

    @Test
    public void tecnicoTieneEstadoDisponible(){
        finalizarIncidente();

        incidente.finalizarIncidente(estadoFinalizado);

        Assert.assertEquals(true, incidente.getTecnicoIncidente().estasDisponible());

    }

    @Test
    public void seCompruebaFechaHoraDeCierreDelIncidente(){
        finalizarIncidente();

        Assert.assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), incidente.getFechaHoraCierre());
    }



}
