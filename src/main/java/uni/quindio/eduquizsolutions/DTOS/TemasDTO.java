package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemasDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long idContenido;
}
