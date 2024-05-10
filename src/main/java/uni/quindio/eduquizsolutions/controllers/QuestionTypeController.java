package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;



@RestController
@RequestMapping("/tipo-preguntas")
@CrossOrigin(origins = "*")
public class QuestionTypeController {

    @Autowired
    TiposPreguntasRepo tiposPreguntasRepo;

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getTypeQuestionById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,tiposPreguntasRepo.findById(id).get()));
    }

    @GetMapping("/")
    public ResponseEntity<MessageDTO> getTypeQuestions() {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,tiposPreguntasRepo.findAll()));
    }
    
}
