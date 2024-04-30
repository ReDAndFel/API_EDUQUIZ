package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudiantesDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String password;
    private Long telefono;
    private Long idCurso;
    private Long idGrupo;
}
