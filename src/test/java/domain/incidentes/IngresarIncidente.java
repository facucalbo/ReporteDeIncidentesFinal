package domain.incidentes;

import domain.entitites.problemas.Especialidad;
import domain.entitites.persons.Tecnico;
import domain.entitites.incidente.Incidente;
import domain.entitites.incidente.PosibleEstadoIncidente;
import domain.entitites.notificacion.Notificacion;
import domain.entitites.problemas.Problema;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class IngresarIncidente {
//    Al ingresar el incidente, el sistema devuelve un listado de técnicos disponibles para resolver el problema.
//    El operador selecciona uno de los técnicos disponibles y el sistema le informa el tiempo estimado de resolución.
//    Luego, informa al cliente que el incidente ha sido ingresado y la fecha posible de resolución.
//    Al confirmarse el incidente, el sistema debe enviar una notificación al técnico informándole que tiene un nuevo incidente para resolver.

    public Notificacion notificacion;
    public Incidente incidente;
    public Tecnico tecnico1;
    public Problema problema1;
    public Especialidad espc1 = new Especialidad();
    public Especialidad espc2 = new Especialidad();
    public Especialidad espc3 = new Especialidad();


    @Before
    public void init(){
        incidente = new Incidente();
        incidente.setDescripcionIncidente("RED");

        tecnico1 = new Tecnico();
        tecnico1.setNumeroCompleto("123");
        tecnico1.setDisponible(true);
        tecnico1.agregarEspecialidad(espc1);
        tecnico1.agregarEspecialidad(espc2);

    }

    @Test
    public void tecnicoResuelveProblema(){
        problema1 = new Problema();
        problema1.agregarEspecialidadQueResuelve(espc1);
        problema1.setTiempoEstimadoResolucionEnHoras(3.5);

        tecnico1.resuelveProblema(problema1);

        Assert.assertEquals(true, tecnico1.resuelveProblema(problema1));
    }

    @Test
    public void tecnicoNoResuelveProblema(){
        problema1 = new Problema();
        problema1.agregarEspecialidadQueResuelve(espc3);
        problema1.setTiempoEstimadoResolucionEnHoras(3.5);

        tecnico1.resuelveProblema(problema1);

        Assert.assertEquals(false, tecnico1.resuelveProblema(problema1));
    }

    public void seConfirmaIncidente(){
        problema1 = new Problema();
        problema1.agregarEspecialidadQueResuelve(espc1);
        problema1.setTiempoEstimadoResolucionEnHoras(5.0);

        incidente.setProblemaIncidente(problema1);

        incidente.confirmarse(tecnico1, new PosibleEstadoIncidente("Confirmado"));

        //se puede ver que se agregan las horas a la fecha actual o fecha de alta
        System.out.println(incidente.getFechaHoraAlta().truncatedTo(ChronoUnit.MINUTES));
        System.out.println(incidente.getFechaHoraPosibleResolucion().truncatedTo(ChronoUnit.MINUTES));
    }

    @Test
    public void seCompruebaFechaHoraAlta(){
        seConfirmaIncidente();

        Assert.assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), incidente.getFechaHoraAlta());

    }

    @Test
    public void seCompruebaFechaHoraPosibleResolucion(){
        seConfirmaIncidente();

        System.out.println(incidente.fechaEstimadaResolucion().isAfter(LocalDateTime.now()));

        LocalDateTime resolucion = incidente.getFechaHoraAlta().plusHours(problema1.getTiempoEstimadoResolucionEnHoras().longValue());
        Assert.assertEquals(resolucion.truncatedTo(ChronoUnit.MINUTES), incidente.getFechaHoraPosibleResolucion().truncatedTo(ChronoUnit.MINUTES));
    }



}
