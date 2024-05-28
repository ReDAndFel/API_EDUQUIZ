package uni.quindio.eduquizsolutions.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Estado;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.entities.Tema;
import uni.quindio.eduquizsolutions.entities.TiposPregunta;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.RespuestasRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin(origins = "*")
public class QuestionController {

        @Autowired
        PreguntasRepo preguntasRepo;

        @Autowired
        RespuestasRepo respuestasRepo;

        @Autowired
        TemasRepo temasRepo;

        @Autowired
        EstadosRepo estadosRepo;

        @Autowired
        TiposPreguntasRepo tiposPreguntasRepo;

        @GetMapping("/")
        public ResponseEntity<MessageDTO> getAllQuestions() {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, preguntasRepo.findAll()));
        }

        @GetMapping("/examen/{idExamen}")
        public ResponseEntity<MessageDTO> getQuestionByExamId(@PathVariable long idExamen) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false,
                                                preguntasRepo.findPreguntasByIdExamen(idExamen)));
        }

        @GetMapping("/examen/{idExamen}/estudiante/{idEstudiante}")
        public ResponseEntity<MessageDTO> getQuestionByExamIdAndIdStudent(@PathVariable long idExamen,
                        @PathVariable long idEstudiante) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false,
                                                preguntasRepo.findPreguntasAsignadasByIdExamenAndIdEstudiante(idExamen,
                                                                idEstudiante)));
        }

        @GetMapping("/tema/{idTema}")
        public ResponseEntity<MessageDTO> getQuestionByIdTopic(@PathVariable long idTema) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false,
                                                preguntasRepo.findPreguntasByIdEstadoAndIdTema(idTema)));
        }

        @GetMapping("/{idQuestion}")
        public ResponseEntity<MessageDTO> getQuestionById(@PathVariable long idQuestion) {
                Pregunta pregunta = preguntasRepo.findById(idQuestion).get();
                PreguntasDTO preguntaDTO = new PreguntasDTO();
                preguntaDTO.setEnunciado(pregunta.getEnunciado());
                preguntaDTO.setId(pregunta.getId());
                preguntaDTO.setIdEstado(pregunta.getIdestado().getId());
                preguntaDTO.setIdTema(pregunta.getIdtema().getId());
                preguntaDTO.setPeso(pregunta.getPeso());
                preguntaDTO.setIdTipoPregunta(pregunta.getIdtipopregunta().getId());

                List<Respuesta> respuestas = respuestasRepo.findRespuestasByIdPregunta(pregunta.getId());

                List<RespuestasDTO> respuestasDTOs = new ArrayList<>();

                for (Respuesta respuesta : respuestas) {
                    RespuestasDTO respuestaDTO = new RespuestasDTO();
                    respuestaDTO.setCorrecta(respuesta.getCorrecta());
                    respuestaDTO.setId(respuesta.getId());
                    respuestaDTO.setIdPregunta(respuesta.getIdpreguntas().getId());
                    respuestaDTO.setOpcionrespuesta(respuesta.getOpcionrespuesta());
                    respuestasDTOs.add(respuestaDTO);
                }
                preguntaDTO.setRespuestas(respuestasDTOs);               

                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, preguntaDTO ));
        }

        @PostMapping("/")
        public ResponseEntity<MessageDTO> createQuestion(@RequestBody PreguntasDTO preguntasDTO) {
                TiposPregunta tiposPreguntas = tiposPreguntasRepo
                                .getReferenceById(preguntasDTO.getIdTipoPregunta());

                Estado estado = estadosRepo.getReferenceById(preguntasDTO.getIdEstado());

                Tema tema = temasRepo.getReferenceById(preguntasDTO.getIdTema());

                Pregunta pregunta = new Pregunta();

                preguntasRepo.save(pregunta);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Pregunta creada correctamente"));
        }

        @PutMapping("/{id}")
        public ResponseEntity<MessageDTO> updateQuestion(@PathVariable long id,
                        @RequestBody PreguntasDTO preguntasDTO) {

                Pregunta pregunta = preguntasRepo.findById(id).get();

                TiposPregunta tiposPreguntas = tiposPreguntasRepo
                                .getReferenceById(preguntasDTO.getIdTipoPregunta());

                Estado estado = estadosRepo.getReferenceById(preguntasDTO.getIdEstado());

                Tema tema = temasRepo.getReferenceById(preguntasDTO.getIdTema());

                pregunta.setEnunciado(preguntasDTO.getEnunciado());
                pregunta.setIdestado(estado);
                pregunta.setIdtema(tema);
                pregunta.setIdtipopregunta(tiposPreguntas);

                preguntasRepo.save(pregunta);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, "Pregunta actualizada correctamente"));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<MessageDTO> deleteQuestion(@PathVariable long id) {
                preguntasRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Pregunta eliminada correctamente"));
        }
}
