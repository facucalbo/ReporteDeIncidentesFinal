package domain.entitites.incidente;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EstadoIncidente {
    private PosibleEstadoIncidente posibleEstadoIncidente;
    private LocalDateTime fechaHora;

    //puto
    public EstadoIncidente(LocalDateTime fechaHora, PosibleEstadoIncidente estado){
        this.fechaHora = fechaHora;
        this.posibleEstadoIncidente = estado;

    }
}


