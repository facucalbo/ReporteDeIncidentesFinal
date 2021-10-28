package domain.entitites.notificacion;


import lombok.Setter;

@Setter
public class Notificacion {
    private String emailDestinatario;
    private String emailRemitente;
    private String mensaje;
    private String nroDestinatario;
    private String nroRemitente;
}
