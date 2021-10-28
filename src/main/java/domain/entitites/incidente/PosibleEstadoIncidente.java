package domain.entitites.incidente;

import lombok.Getter;
import lombok.Setter;

public class PosibleEstadoIncidente {

    @Setter
    @Getter
    //no tengo idea porque le habia puesto static
    public String nombreEstado;

    public PosibleEstadoIncidente(String nombreEstado){
        this.nombreEstado = nombreEstado;
    }
}
