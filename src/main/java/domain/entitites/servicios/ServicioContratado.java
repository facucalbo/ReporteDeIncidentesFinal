package domain.entitites.servicios;

import domain.entitites.persons.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ServicioContratado {
    private Cliente cliente;
    private Servicio servicio;
    private LocalDate fechaAlta;
}
