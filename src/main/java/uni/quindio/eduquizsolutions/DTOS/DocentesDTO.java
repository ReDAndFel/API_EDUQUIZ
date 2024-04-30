package uni.quindio.eduquizsolutions.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocentesDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correoElectronico;
    private String password;
    private Long telefono;
    private String direccion;
    private Long idInstitucion;
}
