package uni.quindio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.repositories.RespuestasRepo;
import uni.quindio.services.interfaces.PreguntaInterface;
import uni.quindio.services.interfaces.RespuestaInterface;

@Service
public class PreguntaService implements PreguntaInterface {

    private final RespuestasRepo respuestasRepo;

    private final RespuestaInterface respuestaInterface;

    public PreguntaService(RespuestasRepo respuestasRepo, RespuestaInterface respuestaInterface) {
        this.respuestaInterface = respuestaInterface;
        this.respuestasRepo = respuestasRepo;
    }

    @Override
    public List<PreguntasDTO> listaPreguntasADTO(List<Pregunta> lista) {
        List<PreguntasDTO> preguntasDTO = new ArrayList<>();

        for (Pregunta pregunta : lista) {
            PreguntasDTO preguntaDTO = new PreguntasDTO();
            preguntaDTO.setEnunciado(pregunta.getEnunciado());
            preguntaDTO.setIdEstado(pregunta.getIdestado().getId());
            preguntaDTO.setPeso(pregunta.getPeso());
            preguntaDTO.setIdTipoPregunta(pregunta.getIdtipopregunta().getId());
            preguntaDTO.setIdTema(pregunta.getIdtema().getId());
            // lista las respuestas en dto
            List<Respuesta> respuestas = respuestasRepo.findRespuestasByIdPregunta(pregunta.getId());
            List<RespuestasDTO> respuestasDTOs = respuestaInterface.listaRespuestasADTO(respuestas);
            preguntaDTO.setRespuestas(respuestasDTOs);
            preguntasDTO.add(preguntaDTO);
        }

        return preguntasDTO;
    }

}
