package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class HorariosDTO {
    private Long id;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    private Long idAsignacionDia;
}
