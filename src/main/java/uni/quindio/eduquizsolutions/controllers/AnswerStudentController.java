package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasEstudiantesDTO;
import uni.quindio.eduquizsolutions.entities.AsignacionesPregunta;
import uni.quindio.eduquizsolutions.entities.Estado;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.entities.RespuestasEstudiante;
import uni.quindio.eduquizsolutions.entities.Tema;
import uni.quindio.eduquizsolutions.entities.TiposPregunta;
import uni.quindio.eduquizsolutions.repositories.AsignacionesPreguntaRepo;
import uni.quindio.eduquizsolutions.repositories.DocentesRepo;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.RespuestasEstudianteRepo;
import uni.quindio.eduquizsolutions.repositories.RespuestasRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/respuestas-estudiante")
@CrossOrigin(origins = "*")
public class AnswerStudentController {

        @Autowired
        RespuestasEstudianteRepo respuestasEstudianteRepo;
        @Autowired
        AsignacionesPreguntaRepo asignacionPreguntaRepo;
        @Autowired
        RespuestasRepo respuestasRepo;


        @PostMapping("/")
        public ResponseEntity<MessageDTO> crearRespuestaEstudiante(@RequestBody RespuestasEstudiantesDTO respuestasEstudiantesDTO) {
                
                RespuestasEstudiante respuestasEstudiante = new RespuestasEstudiante();

                AsignacionesPregunta asignacionesPregunta = asignacionPreguntaRepo.findById(respuestasEstudiantesDTO.getIdAsignacionPregunta()).get();
                respuestasEstudiante.setIdasignacionpregunta(asignacionesPregunta);
                respuestasEstudiante.setRespuesta(respuestasEstudiantesDTO.getRespuesta());
                Respuesta respuesta = respuestasRepo.findById(respuestasEstudiantesDTO.getIdRespuesta()).get();
                respuestasEstudiante.setIdrespuesta(respuesta);
                respuestasEstudianteRepo.save(respuestasEstudiante);
                
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false,
                                                "Respuesta estudiante creada correctamente"));
        }
}