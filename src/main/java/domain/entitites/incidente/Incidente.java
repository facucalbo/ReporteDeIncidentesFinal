package domain.entitites.incidente;

import domain.entitites.persons.Tecnico;
import domain.entitites.notificacion.Notificacion;
import domain.entitites.problemas.Problema;
import domain.entitites.servicios.ServicioContratado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Setter
@Getter
public class Incidente {
    private String descripcionIncidente;
    private List<EstadoIncidente> estadosIncidente;
    private LocalDateTime fechaHoraAlta;
    private LocalDateTime fechaHoraCierre;
    private LocalDateTime fechaHoraPosibleResolucion;
    private Problema problemaIncidente;
    //falta chequear que el cliente pueda solicitar soporte de este servicio
    private ServicioContratado servicioCliente;
    private Tecnico tecnicoIncidente;

    public Incidente(PosibleEstadoIncidente estadoInicialIncidente){
        this.estadosIncidente = new ArrayList<>();

        this.estadosIncidente.add(new EstadoIncidente(LocalDateTime.now(),estadoInicialIncidente));
        cambiarEstado(new EstadoIncidente(LocalDateTime.now(),estadoInicialIncidente));

    }

    public Incidente(){
        this.estadosIncidente = new ArrayList<>();
    }

    //el parametro 'estadoconfirmado' esta incorrecto, buscar una solucion
    public void confirmarse(Tecnico tecnico, PosibleEstadoIncidente estadoConfirmado){
        Notificacion notificacionParaTecnico = new Notificacion();

        if(tecnico.estasDisponible() && tecnico.resuelveProblema(this.problemaIncidente)){
            notificacionParaTecnico.setNroDestinatario(tecnico.getNumeroCompleto());
            notificacionParaTecnico.setEmailDestinatario(tecnico.getEmailTecnico());
            notificacionParaTecnico.setMensaje(this.descripcionIncidente);

            this.tecnicoIncidente = tecnico;
            tecnico.agregarIncidenteQueParticipa(this);

            this.fechaHoraAlta = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

            fechaEstimadaResolucion();
            //falta notificar al cliente
            //cambiar el estado (agregar) hacer un metodo "cambiar de estado" en incidente para reusarlo
            cambiarEstado(estadoConfirmado);
            tecnico.setDisponible(false);
        }
    }

    //se calcula la hora estimada de cierre
    public LocalDateTime fechaEstimadaResolucion(){
        return this.fechaHoraPosibleResolucion =
                this.fechaHoraAlta.plusHours(
                        this.problemaIncidente.getTiempoEstimadoResolucionEnHoras().longValue()
                    ).toLocalTime().atDate(fechaHoraAlta.toLocalDate()).truncatedTo(ChronoUnit.MINUTES);
    }

    //solucionar donde va este metodo, momentaneamente esta en Incidente.
    public void finalizarIncidente(PosibleEstadoIncidente estadoFinalizado){
        tecnicoIncidente.setDisponible(true);
        fechaHoraCierre = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        cambiarEstado(estadoFinalizado);

        Notificacion notificarClienteFinalizoIncidente = new Notificacion();

        notificarClienteFinalizoIncidente.setNroRemitente(servicioCliente.getCliente().getNumeroCompleto());
        notificarClienteFinalizoIncidente.setEmailRemitente(servicioCliente.getCliente().getEmail());
        notificarClienteFinalizoIncidente.setMensaje("Se le informa que el incidente..." + descripcionIncidente);

    }

    public void cambiarEstado(PosibleEstadoIncidente estado){
        estadosIncidente.add(new EstadoIncidente(fechaHoraAlta, estado));

        //que diferencia hay entre uno y otro?
//        estadosIncidente.sort(Comparator.comparing(EstadoIncidente::getFechaHora));
        Collections.sort(estadosIncidente, Comparator.comparing(EstadoIncidente::getFechaHora));
    }

//    public List<Tecnico> listaDeTecnicos(){
//        //todo
//        return null;
//    }

}
