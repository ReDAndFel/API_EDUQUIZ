package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.repositories.DocentesRepo;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("*")
public class DocentesController {

    @Autowired
    DocentesRepo docentesRepo;

    @GetMapping("/docentes")
    public ResponseEntity<MessageDTO> getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,docentesRepo.findAll()));
    }

}
