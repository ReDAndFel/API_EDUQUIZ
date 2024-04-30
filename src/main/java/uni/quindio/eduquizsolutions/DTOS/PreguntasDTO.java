package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreguntasDTO {
    private Long id;
    private String enunciado;
    private Long idTema;
    private Long idEstado;
    private Long idTipoPregunta;
}
