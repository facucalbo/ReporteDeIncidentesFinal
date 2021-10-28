package domain.entitites.servicios;

import domain.entitites.problemas.TipoProblema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Servicio {
    private String nombreServicio;
    private List<TipoProblema> tiposDeProblema;

    public Servicio(){
        this.tiposDeProblema = new ArrayList<>();
    }
}
