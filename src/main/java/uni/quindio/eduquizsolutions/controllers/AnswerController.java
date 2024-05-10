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
import uni.quindio.eduquizsolutions.entities.Estado;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.entities.Tema;
import uni.quindio.eduquizsolutions.entities.TiposPregunta;
import uni.quindio.eduquizsolutions.repositories.DocentesRepo;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
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
@RequestMapping("/respuestas")
@CrossOrigin(origins = "*")
public class AnswerController {

        @Autowired
        PreguntasRepo preguntasRepo;

        @Autowired
        RespuestasRepo respuestasRepo;

        @GetMapping("/{id}")
        public ResponseEntity<MessageDTO> getAnswerById(@PathVariable long id) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, respuestasRepo.findById(id).get()));
        }

        @PostMapping("/")
        public ResponseEntity<MessageDTO> createAnswer(@RequestBody RespuestasDTO respuestasDTO) {

                Pregunta pregunta = preguntasRepo.findById(respuestasDTO.getIdPregunta()).get();

                Respuesta respuesta = new Respuesta(
                                null,
                                respuestasDTO.getOpcionrespuesta(),
                                respuestasDTO.getCorrecta(),
                                pregunta);

                respuestasRepo.save(respuesta);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Respuesta creada correctamente"));
        }

        @PutMapping("/{id}")
        public ResponseEntity<MessageDTO> updateAnswer(@PathVariable long id,
                        @RequestBody RespuestasDTO respuestasDTO) {

                Pregunta pregunta = preguntasRepo.findById(respuestasDTO.getIdPregunta()).get();

                Respuesta respuesta = respuestasRepo.findById(id).get();

                respuesta.setCorrecta(respuestasDTO.getCorrecta());
                respuesta.setIdpreguntas(pregunta);
                respuesta.setOpcionrespuesta(respuestasDTO.getOpcionrespuesta());

                respuestasRepo.save(respuesta);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, "Respuesta actualizada correctamente"));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<MessageDTO> deleteAnswer(@PathVariable long id) {
                respuestasRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Respuesta eliminada correctamente"));
        }
}
