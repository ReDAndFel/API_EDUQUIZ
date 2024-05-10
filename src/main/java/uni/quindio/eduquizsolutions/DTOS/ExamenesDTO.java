package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

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
    private Long idCurso;
}
