package domain.entitites.persons;

import domain.entitites.servicios.ServicioContratado;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cliente {
    private String cuit;
    private String email;
    private String razonSocial;
    private String numeroCompleto;
    //Este array se usa para buscar los servicios que tiene contratado el cliente
    private List<ServicioContratado> serviciosContratados;

    public Cliente(){
        this.serviciosContratados = new ArrayList<>();
    }
}
