package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitucionesDTO {
    private Long id;
    private String nombreninstitucion;
    private String descripcion;
    private String direccion;
    private Long telefono;
}
