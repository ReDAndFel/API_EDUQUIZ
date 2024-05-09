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
import uni.quindio.eduquizsolutions.repositories.CursosRepo;



@RestController
@RequestMapping("/cursos")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CursosRepo cursoRepo;

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getCourseById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,cursoRepo.findById(id).get()));
    }

    @GetMapping("/institution/{idInstitution}")
    public ResponseEntity<MessageDTO> getDayById(@PathVariable long idInstitution) {
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,cursoRepo.findCoursesByInstitutionId(idInstitution)));
    }
    
}
