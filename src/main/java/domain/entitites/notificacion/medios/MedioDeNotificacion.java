package domain.entitites.notificacion.medios;

import domain.entitites.notificacion.Notificacion;

public interface MedioDeNotificacion {

    void enviar(Notificacion notificacion);
}
