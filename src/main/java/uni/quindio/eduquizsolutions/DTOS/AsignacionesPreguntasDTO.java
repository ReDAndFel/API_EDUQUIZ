package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsignacionesPreguntasDTO {
    private Long id;
    private Long idAsignacionEstudiante;
    private Long idBanco;
    private Long idPreguntaBanco;
}
