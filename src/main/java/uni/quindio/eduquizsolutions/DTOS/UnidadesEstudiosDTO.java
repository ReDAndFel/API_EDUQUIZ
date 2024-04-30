package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadesEstudiosDTO {
    private Long id;
    private String nombreUnidad;
    private String descripcion;
    private Long idMateria;
}
