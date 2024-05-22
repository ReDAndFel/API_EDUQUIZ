package uni.quindio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.services.interfaces.RespuestaInterface;

@Service
public class RespuestaService implements RespuestaInterface {

    public RespuestaService() {
        
    }

    @Override
    public List<RespuestasDTO> listaRespuestasADTO(List<Respuesta> lista) {
        List<RespuestasDTO> respuestasDTOs = new ArrayList<>();

        for (Respuesta respuesta : lista) {
            RespuestasDTO respuestaDTO = new RespuestasDTO();
            respuestaDTO.setCorrecta(respuesta.getCorrecta());
            respuestaDTO.setId(respuesta.getId());
            respuestaDTO.setIdPregunta(respuesta.getIdpreguntas().getId());
            respuestaDTO.setOpcionrespuesta(respuesta.getOpcionrespuesta());
            respuestasDTOs.add(respuestaDTO);
        }

        return respuestasDTOs;
    }

}
