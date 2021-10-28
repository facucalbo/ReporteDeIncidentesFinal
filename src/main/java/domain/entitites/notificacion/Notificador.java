package domain.entitites.notificacion;

import domain.entitites.notificacion.medios.MedioDeNotificacion;
import lombok.Setter;

@Setter
public class Notificador {
    private MedioDeNotificacion medioDeNotificacion;

    public void enviar(Notificacion notificacion){
        medioDeNotificacion.enviar(notificacion);
    }

}
