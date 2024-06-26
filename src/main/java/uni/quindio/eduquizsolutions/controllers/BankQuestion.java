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
import uni.quindio.eduquizsolutions.repositories.BancopreguntasRepo;

@RestController
@RequestMapping("/bancos")
@CrossOrigin(origins = "*")
public class BankQuestion {

    @Autowired
    BancopreguntasRepo bancopreguntasRepo;

    @GetMapping("/examen/{idExam}")
    public ResponseEntity<MessageDTO> getBankByIdExam(@PathVariable long idExam) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, bancopreguntasRepo.findBankByIdExam(idExam)));
    }

    @GetMapping("/examen/{idExam}/pregunta/{idQuestion}")
    public ResponseEntity<MessageDTO> getBankByIdExamIdQuestion(@PathVariable long idExam,
            @PathVariable long idQuestion) {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false,
                bancopreguntasRepo.findBankByIdExamAndIdQuestion(idExam, idQuestion)));
    }
}
