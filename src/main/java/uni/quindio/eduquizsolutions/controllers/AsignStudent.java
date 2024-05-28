package uni.quindio.eduquizsolutions.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.AsignacionesEstudiantesDTO;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.entities.AsignacionesEstudiante;
import uni.quindio.eduquizsolutions.entities.Estudiante;
import uni.quindio.eduquizsolutions.entities.Examen;
import uni.quindio.eduquizsolutions.repositories.AsignacionesEstudianteRepo;
import uni.quindio.eduquizsolutions.repositories.EstudiantesRepo;
import uni.quindio.eduquizsolutions.repositories.ExamenesRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/asignacion-estudiantes")
@CrossOrigin(origins = "*")
public class AsignStudent {

    @Autowired
    AsignacionesEstudianteRepo asignacionesEstudianteRepo;
    @Autowired
    ExamenesRepo examenesRepo;
    @Autowired
    EstudiantesRepo estudiantesRepo;

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getAsignEstudianteById(@PathVariable long id) {

        AsignacionesEstudiante asignacionesEstudiante = asignacionesEstudianteRepo.findById(id).get();

        AsignacionesEstudiantesDTO asignacionesEstudiantesDTO = convertAsignacionesEstudianteDTO(
                asignacionesEstudiante);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, asignacionesEstudiantesDTO));
    }

    @GetMapping("/estudiante/{idStudent}")
    private ResponseEntity<MessageDTO> getAsignEstudianteByIdStudent(@PathVariable long idStudent) {

        List<AsignacionesEstudiante> asignacionesEstudiante = asignacionesEstudianteRepo.findByIdEstudiante(idStudent);
        List<AsignacionesEstudiantesDTO> listAsignacionesDTO = new ArrayList<>();
        for (AsignacionesEstudiante asignacion : asignacionesEstudiante) {
            AsignacionesEstudiantesDTO asignacionDTO = convertAsignacionesEstudianteDTO(asignacion);
            listAsignacionesDTO.add(asignacionDTO);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, listAsignacionesDTO));
    }

    @GetMapping("/examen/{idExamen}")
    public ResponseEntity<MessageDTO> getAsignEstudianteByIdExam(@PathVariable long idExam) {
        List<AsignacionesEstudiante> asignacionesEstudiante = asignacionesEstudianteRepo.findByIdExamen(idExam);
        List<AsignacionesEstudiantesDTO> listAsignacionesDTO = new ArrayList<>();
        for (AsignacionesEstudiante asignacion : asignacionesEstudiante) {
            AsignacionesEstudiantesDTO asignacionDTO = convertAsignacionesEstudianteDTO(asignacion);
            listAsignacionesDTO.add(asignacionDTO);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, listAsignacionesDTO));
    }

    @GetMapping("/estudiante/{idStudent}/examen/{idExam}")
    public ResponseEntity<MessageDTO> getAsignEstudianteByIdStudentAndIdExam(@PathVariable long idStudent,
            @PathVariable long idExam) {
        AsignacionesEstudiante asignacionesEstudiante = asignacionesEstudianteRepo.findByIdEstudianteAndIdExamen(
                idStudent,
                idExam);
        AsignacionesEstudiantesDTO asignacionDTO = convertAsignacionesEstudianteDTO(asignacionesEstudiante);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, asignacionDTO));
    }

    @PostMapping("/")
    public ResponseEntity<MessageDTO> crearAsignacionEstudiante(
            @RequestBody AsignacionesEstudiantesDTO asignacionesEstudiantesDTO) {

        try {
            AsignacionesEstudiante asignacion = new AsignacionesEstudiante();
            asignacion.setFecha(asignacionesEstudiantesDTO.getFechaAsignacion());
            asignacion.setHoraFin(asignacionesEstudiantesDTO.getHoraFin());
            asignacion.setHoraInicio(asignacionesEstudiantesDTO.getHoraInicio());
            Estudiante estudiante = estudiantesRepo.findById(asignacionesEstudiantesDTO.getId()).get();
            asignacion.setIdestudiante(estudiante);
            Examen examen = examenesRepo.findById(asignacionesEstudiantesDTO.getIdExamenes()).get();
            asignacion.setIdexamenes(examen);
            asignacion.setNota(asignacionesEstudiantesDTO.getNota());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageDTO(HttpStatus.INTERNAL_SERVER_ERROR, true, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO(HttpStatus.CREATED, false, "Asignacion de estudiantes creada con exito"));
    }

    private AsignacionesEstudiantesDTO convertAsignacionesEstudianteDTO(AsignacionesEstudiante asignacionesEstudiante) {

        AsignacionesEstudiantesDTO asignacionesEstudiantesDTO = new AsignacionesEstudiantesDTO();

        asignacionesEstudiantesDTO.setFechaAsignacion(asignacionesEstudiante.getFecha());
        asignacionesEstudiantesDTO.setHoraFin(asignacionesEstudiante.getHoraFin());
        asignacionesEstudiantesDTO.setHoraInicio(asignacionesEstudiante.getHoraInicio());
        asignacionesEstudiantesDTO.setId(asignacionesEstudiante.getId());
        asignacionesEstudiantesDTO.setIdEstudiante(asignacionesEstudiante.getIdestudiante().getId());
        asignacionesEstudiantesDTO.setIdExamenes(asignacionesEstudiante.getIdexamenes().getId());
        asignacionesEstudiantesDTO.setNota(asignacionesEstudiante.getNota());
        return asignacionesEstudiantesDTO;
    }

}
