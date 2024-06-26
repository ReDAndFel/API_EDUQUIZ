package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.repositories.EstudiantesRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    EstudiantesRepo estudiantesRepo;

    @GetMapping("/")
    public ResponseEntity<MessageDTO> getAllEstudents() {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,estudiantesRepo.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getStudentById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,estudiantesRepo.findById(id)));
    }

    @GetMapping("/curso/{idCourse}")
    public ResponseEntity<MessageDTO> getStudentByCourseId(@PathVariable long idCourse) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,estudiantesRepo.findByCouseId(idCourse)));
    }

}
