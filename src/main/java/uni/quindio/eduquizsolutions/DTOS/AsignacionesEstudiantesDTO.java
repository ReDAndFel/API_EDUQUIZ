package uni.quindio.eduquizsolutions.DTOS;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AsignacionesEstudiantesDTO {
    private Long id;
    private Long idEstudiante;
    private Long idExamenes;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaAsignacion;
    private Double nota;
}
