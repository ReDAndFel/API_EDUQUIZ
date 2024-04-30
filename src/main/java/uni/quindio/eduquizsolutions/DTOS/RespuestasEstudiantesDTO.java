package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestasEstudiantesDTO {
    private Long id;
    private Long idEstudiante;
    private Long idExamenes;
    private Long idPreguntas;
    private Long idRespuesta;
}
