package uni.quindio.eduquizsolutions.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.ExamenesDTO;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Curso;
import uni.quindio.eduquizsolutions.entities.Examen;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.entities.Tema;
import uni.quindio.eduquizsolutions.repositories.CursosRepo;
import uni.quindio.eduquizsolutions.repositories.ExamenesRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/examenes")
@CrossOrigin(origins = "*")
public class ExamController {

    @Autowired
    ExamenesRepo examenesRepo;
    @Autowired
    CursosRepo cursosRepo;
    @Autowired
    TemasRepo temasRepo;

    @PostMapping("/")
    public ResponseEntity<MessageDTO> createAnswer(@RequestBody ExamenesDTO examenesDTO) throws Exception {

        Examen examen = new Examen();
        examen.setCalificacion(examenesDTO.getCalificacion());
        examen.setCantidadpreguntas(examenesDTO.getCantidadPreguntas());
        examen.setCantidadpreguntasporexamen(examenesDTO.getCantidadPreguntasXEstudiante());
        examen.setDuracionexamen(examenesDTO.getDuracionExamen());
        examen.setEstado(examenesDTO.getEstado());
        examen.setFecha(examenesDTO.getFecha());
        examen.setTitulo(examenesDTO.getTitulo());
        examen.setHoraFin(examenesDTO.getHoraFin());
        examen.setHoraInicio(examenesDTO.getHoraInicio());

        Curso curso = cursosRepo.findById(examenesDTO.getIdCurso()).get();
        if (curso == null) {
            throw new Exception("No se encontró un curso con el id mandado");
        }
        examen.setIdcurso(curso);
        Tema tema = temasRepo.findById(examenesDTO.getIdTema()).get();
        if (tema == null) {
            throw new Exception("No se encontró un tema con el id mandado");
        }
        examen.setIdtema(tema);
        examen.setNotaParaAprobar(examenesDTO.getNotaParaAprobar());
        examenesRepo.save(examen);
        System.out.println(examen.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO(HttpStatus.CREATED, false, "Examen creada correctamente"));
    }

    @GetMapping("/")
    public ResponseEntity<MessageDTO> getAllExams() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, false, examenesRepo.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getExamById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, examenesRepo.findById(id).get()));
    }

    @GetMapping("/estudiante/{idStudent}")
    public ResponseEntity<MessageDTO> getExamByIdStudent(@PathVariable long idStudent) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, examenesRepo.findExamByIdStudent(idStudent)));
    }
}
