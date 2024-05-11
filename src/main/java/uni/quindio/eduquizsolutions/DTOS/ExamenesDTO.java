package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class ExamenesDTO {
    private Long id;
    private String titulo;
    private LocalDate fecha;
    private Long duracion;
    private Long cantidadPreguntas;
    private Long cantidadPreguntasXEstudiante;
    private Double calificacion;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    private Double notaParaAprobar;
    private String estado;
    private Long idCurso;
    List<PreguntasDTO> preguntas;
}
