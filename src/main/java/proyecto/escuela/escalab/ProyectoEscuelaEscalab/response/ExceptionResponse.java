package proyecto.escuela.escalab.ProyectoEscuelaEscalab.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private LocalDateTime timesTamp;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(LocalDateTime timesTamp, String mensaje, String detalles) {
        this.timesTamp = timesTamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
}
