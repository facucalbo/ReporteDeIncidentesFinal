package domain;

import domain.entitites.persons.Cliente;
import domain.entitites.problemas.TipoProblema;
import domain.entitites.servicios.Servicio;
import domain.entitites.servicios.ServicioContratado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClienteLlama {

    Cliente cliente1;
    Servicio servicio1, servicio2;
    ServicioContratado servicioContratado1;
    TipoProblema tipoProblema1;

    @Before
    public void init(){
        cliente1 = new Cliente();
        servicio1 = new Servicio(); servicio2 = new Servicio();
        servicioContratado1 = new ServicioContratado();

        cliente1.setCuit("112233");
        servicio1.getTiposDeProblema().add(tipoProblema1);
        servicio1.setNombreServicio("Windows");

        servicio2.getTiposDeProblema().add(tipoProblema1);
        servicio2.setNombreServicio("SAP");

        servicioContratado1.setCliente(cliente1);
        servicioContratado1.setServicio(servicio1);
    }

    @Test
    public void clienteTieneServicioContratado(){

        Assert.assertEquals(servicioContratado1.getServicio().getNombreServicio(), servicio1.getNombreServicio());
    }

    @Test
    public void clienteNoTieneServicioContratado(){

        Assert.assertEquals(servicioContratado1.getServicio().getNombreServicio(), "Windows");
    }
}
