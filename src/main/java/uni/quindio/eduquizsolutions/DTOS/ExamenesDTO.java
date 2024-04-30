package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ExamenesDTO {
    private Long id;
    private String titulo;
    private LocalDate fechayhoracreacion;
    private Long duracionexamen;
    private Long cantidadpreguntas;
    private Double calificacion;
    private Long idHorario;
    private Long idCurso;
}
