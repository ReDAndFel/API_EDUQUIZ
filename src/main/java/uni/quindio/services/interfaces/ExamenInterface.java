package uni.quindio.services.interfaces;

import java.util.List;
import uni.quindio.eduquizsolutions.DTOS.ExamenesDTO;
import uni.quindio.eduquizsolutions.entities.Examen;

public interface ExamenInterface {

    public List<ExamenesDTO> listaExamenesADTO(List<Examen> lista);

}
