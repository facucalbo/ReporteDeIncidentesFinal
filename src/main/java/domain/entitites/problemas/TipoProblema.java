package domain.entitites.problemas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TipoProblema {
    private String nombreTipoProblema;
    private List<Problema> problemas;

    public TipoProblema(){
        this.problemas = new ArrayList<>();
    }
}
