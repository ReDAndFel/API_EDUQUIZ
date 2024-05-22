package uni.quindio.services.interfaces;

import java.util.List;

import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Respuesta;

public interface RespuestaInterface {

    public List<RespuestasDTO> listaRespuestasADTO(List<Respuesta> lista);
}
