package uni.quindio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.quindio.eduquizsolutions.DTOS.ExamenesDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.entities.Examen;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.services.interfaces.ExamenInterface;
import uni.quindio.services.interfaces.PreguntaInterface;

@Service
public class ExamenService implements ExamenInterface {

    private final PreguntasRepo preguntasRepo;

    private final PreguntaInterface preguntaInterface;

    public ExamenService(PreguntasRepo preguntasRepo, PreguntaInterface preguntaInterface) {
        this.preguntaInterface = preguntaInterface;
        this.preguntasRepo = preguntasRepo;
    }

    @Override
    public List<ExamenesDTO> listaExamenesADTO(List<Examen> lista) {
        List<ExamenesDTO> examenesDTOs = new ArrayList<>();

        for (Examen examen : lista) {
            // Convierte cada examen en dto
            long examenId = examen.getId();
            ExamenesDTO examenDTO = new ExamenesDTO();
            examenDTO.setId(examenId);
            examenDTO.setCalificacion(examen.getCalificacion());
            examenDTO.setCantidadpreguntas(examen.getCantidadpreguntas());
            examenDTO.setCantidadpreguntasporexamen(examen.getCantidadpreguntasporexamen());
            examenDTO.setDuracionexamen(examen.getDuracionexamen());
            examenDTO.setEstado(examen.getEstado());
            examenDTO.setFecha(examen.getFecha());
            examenDTO.setTitulo(examen.getTitulo());
            examenDTO.setHoraFin(examen.getHoraFin());
            examenDTO.setHoraInicio(examen.getHoraInicio());
            examenDTO.setIdCurso(examen.getIdcurso().getId());
            examenDTO.setIdTema(examen.getIdtema().getId());
            examenDTO.setNotaParaAprobar(examen.getNotaParaAprobar());
            // optiene las preguntas en dto
            List<Pregunta> preguntas = preguntasRepo.findPreguntasByIdExamen(examenId);
            List<PreguntasDTO> preguntasDTO = preguntaInterface.listaPreguntasADTO(preguntas);
            examenDTO.setPreguntas(preguntasDTO);
            examenesDTOs.add(examenDTO);
        }
        return examenesDTOs;
    }

}
