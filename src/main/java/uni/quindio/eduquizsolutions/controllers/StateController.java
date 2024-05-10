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
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;

@RestController
@RequestMapping("/estados")
@CrossOrigin(origins = "*")
public class StateController
 {

    @Autowired
    EstadosRepo estadosRepo;

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getStateById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,estadosRepo.findById(id).get()));
    }

    @GetMapping("/")
    public ResponseEntity<MessageDTO> getStates() {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,estadosRepo.findAll()));
    }
    
}
