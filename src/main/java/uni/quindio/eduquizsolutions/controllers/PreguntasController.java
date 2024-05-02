package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.entities.Estados;
import uni.quindio.eduquizsolutions.entities.Preguntas;
import uni.quindio.eduquizsolutions.entities.Temas;
import uni.quindio.eduquizsolutions.entities.TiposPreguntas;
import uni.quindio.eduquizsolutions.repositories.DocentesRepo;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class PreguntasController {

    @Autowired
    PreguntasRepo preguntasRepo;

    @Autowired
    TemasRepo temasRepo;

    @Autowired
    EstadosRepo estadosRepo;

    @Autowired
    TiposPreguntasRepo tiposPreguntasRepo;

    @GetMapping("/preguntas")
    public ResponseEntity<MessageDTO> getAllAnswers() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, preguntasRepo.findAll()));
    }

    @PostMapping("/preguntas")
    public ResponseEntity<MessageDTO> createQuestion(@RequestBody PreguntasDTO preguntasDTO) {
        TiposPreguntas tiposPreguntas = tiposPreguntasRepo
                .getReferenceById(preguntasDTO.getIdTipoPregunta());

        Estados estado = estadosRepo.getReferenceById(preguntasDTO.getIdEstado());

        Temas tema = temasRepo.getReferenceById(preguntasDTO.getIdTema());

        Preguntas pregunta = new Preguntas(
                preguntasDTO.getId(),
                preguntasDTO.getEnunciado(),
                tema,
                estado,
                tiposPreguntas);

        preguntasRepo.save(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO(HttpStatus.CREATED, false, "Pregunta creada correctamente"));
    }

    @PutMapping("/preguntas")
    public ResponseEntity<MessageDTO> updateQuestion(@PathVariable long id, @RequestBody PreguntasDTO preguntasDTO) {

        Preguntas pregunta = preguntasRepo.findById(id).get();

        TiposPreguntas tiposPreguntas = tiposPreguntasRepo
                .getReferenceById(preguntasDTO.getIdTipoPregunta());

        Estados estado = estadosRepo.getReferenceById(preguntasDTO.getIdEstado());

        Temas tema = temasRepo.getReferenceById(preguntasDTO.getIdTema());

        pregunta.setEnunciado(preguntasDTO.getEnunciado());
        pregunta.setIdestado(estado);
        pregunta.setIdtema(tema);
        pregunta.setIdtipopregunta(tiposPreguntas);

        preguntasRepo.save(pregunta);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, "Pregunta actualizada correctamente"));
    }

    @DeleteMapping("/preguntas")
    public ResponseEntity<MessageDTO> deleteQuestion(@PathVariable long id) {
        preguntasRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO(HttpStatus.CREATED, false, "Pregunta eliminada correctamente"));
    }
}
