package uni.quindio.eduquizsolutions.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.AsignacionesEstudiantesDTO;
import uni.quindio.eduquizsolutions.DTOS.AsignacionesPreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.entities.AsignacionesEstudiante;
import uni.quindio.eduquizsolutions.entities.AsignacionesPregunta;
import uni.quindio.eduquizsolutions.entities.Estudiante;
import uni.quindio.eduquizsolutions.entities.Examen;
import uni.quindio.eduquizsolutions.repositories.AsignacionesEstudianteRepo;
import uni.quindio.eduquizsolutions.repositories.AsignacionesPreguntaRepo;
import uni.quindio.eduquizsolutions.repositories.EstudiantesRepo;
import uni.quindio.eduquizsolutions.repositories.ExamenesRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/asignacion-preguntas")
@CrossOrigin(origins = "*")
public class AsignQuestion {

    @Autowired
    AsignacionesPreguntaRepo asignacionesPreguntaRepo;
   

    @GetMapping("/asignacion-estudiante/{idAsignacionEstudiante}")
    public ResponseEntity<MessageDTO> findAsignacionesPreguntasIdAsignEstudiante(@PathVariable long idAsignacionEstudiante) {

        List<AsignacionesPregunta> asignaciones = asignacionesPreguntaRepo.findAsignacionesPreguntasIdAsignEstudiante(idAsignacionEstudiante);
        List <AsignacionesPreguntasDTO> listDTO = new ArrayList<>();

        for (AsignacionesPregunta asignacion : asignaciones) {
            AsignacionesPreguntasDTO asignacionDTO = new AsignacionesPreguntasDTO();
            asignacionDTO.setId(asignacion.getId());
            asignacionDTO.setIdAsignacionEstudiante(asignacion.getIdasignacionestudiante().getId());
            asignacionDTO.setIdBanco(asignacion.getIdbanco().getId());    
            asignacionDTO.setIdPreguntaBanco(asignacion.getIdbanco().getPreguntasIdpregunta().getId()); 
            
            listDTO.add(asignacionDTO);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, listDTO));
    }

}
