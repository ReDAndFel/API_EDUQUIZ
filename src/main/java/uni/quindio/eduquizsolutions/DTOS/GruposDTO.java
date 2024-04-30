package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class GruposDTO {
    private Long id;
    private String nombregrupo;
    private LocalDate anoacademico;
    private Long idDocenteTutor;
}
