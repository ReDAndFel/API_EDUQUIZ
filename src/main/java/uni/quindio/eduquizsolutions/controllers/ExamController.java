package uni.quindio.eduquizsolutions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.ExamenesDTO;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Bancopregunta;
import uni.quindio.eduquizsolutions.entities.Curso;
import uni.quindio.eduquizsolutions.entities.Estado;
import uni.quindio.eduquizsolutions.entities.Examen;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import uni.quindio.eduquizsolutions.entities.Tema;
import uni.quindio.eduquizsolutions.entities.TiposPregunta;
import uni.quindio.eduquizsolutions.repositories.BancopreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.CursosRepo;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.ExamenesRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.RespuestasRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;

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
    @Autowired
    EstadosRepo estadosRepo;
    @Autowired
    TiposPreguntasRepo tiposPreguntasRepo;
    @Autowired
    PreguntasRepo preguntasRepo;
    @Autowired
    RespuestasRepo respuestasRepo;
    @Autowired
    BancopreguntasRepo bancopreguntasRepo;

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
        examen.setIdcurso(curso);
        Tema tema = temasRepo.findById(examenesDTO.getIdTema()).get();
        examen.setIdtema(tema);
        examen.setNotaParaAprobar(examenesDTO.getNotaParaAprobar());
        // guarda el examen en la base de datos
        examenesRepo.save(examen);
        System.out.println("Se creo con exito el examen");
        // carga la lista de las preguntas mandadas
        List<PreguntasDTO> preguntasDTO = examenesDTO.getPreguntas();

        // itera las preguntas
        for (PreguntasDTO preguntaDTO : preguntasDTO) {
            // inicializa una pregunta
            Pregunta pregunta = new Pregunta();
            // Obtiene el id de la pregunta si tiene uno, sí no es null
            Long preguntaId = preguntaDTO.getId();

            // NOTA: idEstado: 2 es privado y 1 publico
            // valida si la pregunta tiene un id, para crearla u obtenerla de la base de datos
            if (preguntaId == null) {
                //crea la pregunta
                pregunta = new Pregunta();
                pregunta.setEnunciado(preguntaDTO.getEnunciado());
                Estado estadoPregunta = estadosRepo.findById(preguntaDTO.getIdEstado()).get();
                pregunta.setIdestado(estadoPregunta);
                pregunta.setPeso(preguntaDTO.getPeso());
                TiposPregunta tiposPregunta = tiposPreguntasRepo.findById(preguntaDTO.getIdTipoPregunta()).get();
                pregunta.setIdtipopregunta(tiposPregunta);
                pregunta.setIdtema(tema);
                //guarda la pregunta en la base de datos
                preguntasRepo.save(pregunta);
                System.out.println("Pregunta creada con exito con estado: " + preguntaDTO.getIdEstado());
                // recorre las respuestas para crearlas
                List<RespuestasDTO> respuestasDTO = preguntaDTO.getRespuestas();
                for (RespuestasDTO respuestaDTO : respuestasDTO) {
                    //crea las respuestas
                    Respuesta respuesta = new Respuesta();
                    respuesta.setCorrecta(respuestaDTO.getCorrecta());
                    respuesta.setIdpreguntas(pregunta);
                    respuesta.setOpcionrespuesta(respuestaDTO.getOpcionrespuesta());
                    //guarda las respuestas en la base de datos
                    respuestasRepo.save(respuesta);
                    System.out.println("Respuesta creada con exito");
                }
            } else {
                //Obtiene la pregunta con le id
                pregunta = preguntasRepo.findById(preguntaDTO.getId()).get();
            }
            //Crea el banco de preguntas
            Bancopregunta bancopregunta = new Bancopregunta();
            bancopregunta.setExamenesIdexamenen(examen);
            bancopregunta.setPreguntasIdpregunta(pregunta);
            //Guarda el banco de preguntas en la base de datos
            bancopreguntasRepo.save(bancopregunta);
            System.out.println("Se creo con exito el banco de preguntas");
        }
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

    @GetMapping("/curso/{idCourse}")
    public ResponseEntity<MessageDTO> getExamByIdCourse(@PathVariable long idCourse) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, examenesRepo.findExamByIdCourse(idCourse)));
    }
    
}
