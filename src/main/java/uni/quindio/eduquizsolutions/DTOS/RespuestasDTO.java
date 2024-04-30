package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestasDTO {
    private Long id;
    private String opcionrespuesta;
    private String correcta;
    private Long idPregunta;
}
