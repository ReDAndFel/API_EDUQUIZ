package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.repositories.DiaRepo;
import uni.quindio.eduquizsolutions.repositories.EstudiantesRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class DiasController {

    @Autowired
    DiaRepo diaRepo;

    @GetMapping("/dias")
    public ResponseEntity<MessageDTO> getAllDays() {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,diaRepo.findAll()));
    }

    @GetMapping("/dias/{id}")
    public ResponseEntity<MessageDTO> getDayById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,diaRepo.findById(id).get()));
    }

}
