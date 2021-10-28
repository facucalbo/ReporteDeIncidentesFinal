package domain.incidentes;

import domain.entitites.incidente.Incidente;
import domain.entitites.incidente.PosibleEstadoIncidente;
import org.junit.Assert;
import org.junit.Test;

public class EstadosIncidente extends IngresarIncidente {

    PosibleEstadoIncidente estadoConfirmado;
    PosibleEstadoIncidente estadoPendiente;

    @Override
    public void init() {
        super.init();

        estadoPendiente = new PosibleEstadoIncidente("Pendiente");
        estadoConfirmado = new PosibleEstadoIncidente("Confirmado");

        incidente = new Incidente(estadoPendiente);

    }

    @Test
    public void estadoIncidenteEsPendiente(){

        Assert.assertEquals("Pendiente", incidente.getEstadosIncidente().get(0).
                getPosibleEstadoIncidente().getNombreEstado());

    }

    @Test
    public void estadoIncidenteEsConfirmado(){
        super.seConfirmaIncidente();

        Assert.assertEquals("Confirmado", incidente.getEstadosIncidente().get(1).
                getPosibleEstadoIncidente().getNombreEstado());
    }

    @Test
    public void tecnicoTieneEstadoNoDisponible(){
        super.seConfirmaIncidente();

        Assert.assertEquals(false, incidente.getTecnicoIncidente().estasDisponible());
    }
}
