package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
public class ExamenesDTO {
    private Long id;
    private String titulo;
    private LocalDate fecha;
    private Long duracionexamen;
    private Long cantidadpreguntas;
    private Long cantidadpreguntasporexamen;
    private Double calificacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Double notaParaAprobar;
    private String estado;
    private Long idCurso;
    private Long idTema;
    List<PreguntasDTO> preguntas;
}
