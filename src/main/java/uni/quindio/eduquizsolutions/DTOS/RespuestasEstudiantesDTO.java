package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestasEstudiantesDTO {
    private Long idRespuestaEstudiante;
    private String respuesta;
    private Long idAsignacionPregunta;
    private Long idRespuesta;
}
