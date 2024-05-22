package uni.quindio.services.interfaces;

import java.util.List;

import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;

import uni.quindio.eduquizsolutions.entities.Pregunta;

public interface PreguntaInterface {

    public List<PreguntasDTO> listaPreguntasADTO(List<Pregunta> lista);

}
