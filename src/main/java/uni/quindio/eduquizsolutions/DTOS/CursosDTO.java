package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursosDTO {
    private Long id;
    private String nombrecurso;
    private String descripcion;
    private Long idDocente;
    private Long idMateria;
}
