package uni.quindio.eduquizsolutions.DTOS;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class AsignacionesEstudiantesDTO {
    private Long id;
    private Long idEstudiante;
    private Long idExamenes;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    private LocalDate fechaAsignacion;
    private Double nota;
}
