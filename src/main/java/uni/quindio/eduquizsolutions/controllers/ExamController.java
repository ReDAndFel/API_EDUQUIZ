package uni.quindio.eduquizsolutions.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import uni.quindio.services.implementations.ExamenService;
import uni.quindio.services.interfaces.ExamenInterface;
import uni.quindio.services.interfaces.PreguntaInterface;
import org.springframework.web.bind.annotation.PutMapping;

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
    public ResponseEntity<MessageDTO> createExam(@RequestBody ExamenesDTO examenesDTO) throws Exception {
        try {
            Examen examen = new Examen();
            examen.setCalificacion(examenesDTO.getCalificacion());
            examen.setCantidadpreguntas(examenesDTO.getCantidadpreguntas());
            examen.setCantidadpreguntasporexamen(examenesDTO.getCantidadpreguntasporexamen());
            examen.setDuracionexamen(examenesDTO.getDuracionexamen());
            examen.setEstado("Guardando");
            examen.setFecha(examenesDTO.getFecha());
            examen.setTitulo(examenesDTO.getTitulo());
            examen.setHoraFin(examenesDTO.getHoraFin());
            examen.setHoraInicio(examenesDTO.getHoraInicio());
            Curso curso = cursosRepo.findById(examenesDTO.getIdCurso()).get();
            examen.setIdcurso(curso);
            Tema tema = temasRepo.findById(examenesDTO.getIdTema()).get();
            examen.setIdtema(tema);
            examen.setNotaParaAprobar(examenesDTO.getNotaParaAprobar());
            // carga la lista de las preguntas mandadas
            List<PreguntasDTO> preguntasDTO = examenesDTO.getPreguntas();
            System.out.println("ID new examen  = " + examen.getId());
            // guarda el examen en la base de datos con estado guardando
            examenesRepo.save(examen);
            crearBancosExamen(preguntasDTO, tema, examen);
            // Cambia a borrador y actualiza
            examen.setEstado("Borrador");
            examenesRepo.save(examen);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageDTO(HttpStatus.BAD_REQUEST, true, e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageDTO(HttpStatus.CREATED, false, "Examen creada correctamente"));
    }

    private void crearBancosExamen(List<PreguntasDTO> preguntasDTO, Tema tema, Examen examen) throws Exception {
        try {
            if (preguntasDTO != null) {
                // itera las preguntas
                for (PreguntasDTO preguntaDTO : preguntasDTO) {
                    // inicializa una pregunta
                    Pregunta pregunta = new Pregunta();
                    // Obtiene el id de la pregunta si tiene uno, sí no es null
                    Long preguntaId = preguntaDTO.getId();

                    // NOTA: idEstado: 2 es privado y 1 publico
                    // valida si la pregunta tiene un id, para crearla u obtenerla de la base de
                    // datos
                    if (preguntaId != null) {
                        // Obtiene la pregunta con le id
                        pregunta = preguntasRepo.findById(preguntaDTO.getId()).get();
                    } else {
                        // crea la pregunta
                        pregunta = new Pregunta();
                        pregunta.setEnunciado(preguntaDTO.getEnunciado());
                        Estado estadoPregunta = estadosRepo.findById(preguntaDTO.getIdEstado()).get();
                        pregunta.setIdestado(estadoPregunta);
                        pregunta.setPeso(preguntaDTO.getPeso());
                        TiposPregunta tiposPregunta = tiposPreguntasRepo.findById(preguntaDTO.getIdTipoPregunta())
                                .get();
                        pregunta.setIdtipopregunta(tiposPregunta);
                        pregunta.setIdtema(tema);
                        // recorre las respuestas para crearlas
                        List<RespuestasDTO> respuestasDTO = preguntaDTO.getRespuestas();
                        // guarda la pregunta en la base de datos
                        preguntasRepo.save(pregunta);

                        for (RespuestasDTO respuestaDTO : respuestasDTO) {
                            // crea las respuestas
                            Respuesta respuesta = new Respuesta();
                            respuesta.setCorrecta(respuestaDTO.getCorrecta());
                            respuesta.setIdpreguntas(pregunta);
                            respuesta.setOpcionrespuesta(respuestaDTO.getOpcionrespuesta());
                            // guarda las respuestas en la base de datos
                            respuestasRepo.save(respuesta);
                        }
                    }

                    // Crea el banco de preguntas
                    Bancopregunta bancopregunta = new Bancopregunta();
                    bancopregunta.setExamenesIdexamenen(examen);
                    bancopregunta.setPreguntasIdpregunta(pregunta);
                    // Guarda el banco de preguntas en la base de datos
                    bancopreguntasRepo.save(bancopregunta);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @DeleteMapping("/{idExam}")
    public ResponseEntity<MessageDTO> deleteExam(@PathVariable long idExam) throws Exception {

        Examen examen = examenesRepo.findById(idExam).get();
        try {
            examenesRepo.delete(examen);

        } catch (Exception e) {
            // Captura la excepción de OracleDB
            System.err.println("Error al ejecutar la operación en la base de datos:");
            System.err.println("Mensaje de error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageDTO(HttpStatus.BAD_REQUEST, true, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, "Examen eliminado correctamente"));

    }

    @PutMapping("/{idExam}")
    public ResponseEntity<MessageDTO> updateExam(@PathVariable long idExam, @RequestBody ExamenesDTO examenesDTO)
            throws Exception {
        Examen examen = examenesRepo.findById(idExam).get();

        try {

            examen.setCalificacion(examenesDTO.getCalificacion());
            examen.setCantidadpreguntas(examenesDTO.getCantidadpreguntas());
            examen.setCantidadpreguntasporexamen(examenesDTO.getCantidadpreguntasporexamen());
            examen.setDuracionexamen(examenesDTO.getDuracionexamen());
            examen.setEstado("Guardando");
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
            // carga la lista de las preguntas mandadas
            List<Bancopregunta> bancos = bancopreguntasRepo.findBankByIdExam(idExam);
            bancopreguntasRepo.deleteAll(bancos);
            List<PreguntasDTO> preguntasDTO = examenesDTO.getPreguntas();
            crearBancosExamen(preguntasDTO, tema, examen);
            // Cambia a borrador y actualiza
            examen.setEstado("Borrador");
            examenesRepo.save(examen);
        } catch (Exception e) {
            examen.setEstado("Borrador");
            examenesRepo.save(examen);

            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK, true, e.getMessage()));
        }

        // TODO: handle exception
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, "Examen actualizado exitosamente"));
    }

    @PutMapping("/publish/{idExam}")
    public ResponseEntity<MessageDTO> publishExam(@PathVariable long idExam)
            throws Exception {

        try {
            Examen examen = examenesRepo.findById(idExam).get();

            examen.setEstado("Publicado");
            examenesRepo.save(examen);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageDTO(HttpStatus.BAD_REQUEST, false, e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, "Examen publicado exitosamente"));
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

        List<Examen> examenes = examenesRepo.findExamByIdStudent(idStudent);
        List<ExamenesDTO> examenesDTOs = listaExamenesADTO(examenes);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, examenesDTOs));
    }

    @GetMapping("/curso/{idCourse}")
    public ResponseEntity<MessageDTO> getExamByIdCourse(@PathVariable long idCourse) {

        List<Examen> examenes = examenesRepo.findExamByIdCourse(idCourse);
        List<ExamenesDTO> examenesDTOs = listaExamenesADTO(examenes);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageDTO(HttpStatus.OK, false, examenesDTOs));
    }

    private List<ExamenesDTO> listaExamenesADTO(List<Examen> lista) {
        List<ExamenesDTO> examenesDTOs = new ArrayList<>();

        for (Examen examen : lista) {
            // Convierte cada examen en dto
            long examenId = examen.getId();
            ExamenesDTO examenDTO = new ExamenesDTO();
            examenDTO.setId(examenId);
            examenDTO.setCalificacion(examen.getCalificacion());
            examenDTO.setCantidadpreguntas(examen.getCantidadpreguntas());
            examenDTO.setCantidadpreguntasporexamen(examen.getCantidadpreguntasporexamen());
            examenDTO.setDuracionexamen(examen.getDuracionexamen());
            examenDTO.setEstado(examen.getEstado());
            examenDTO.setFecha(examen.getFecha());
            examenDTO.setTitulo(examen.getTitulo());
            examenDTO.setHoraFin(examen.getHoraFin());
            examenDTO.setHoraInicio(examen.getHoraInicio());
            examenDTO.setIdCurso(examen.getIdcurso().getId());
            examenDTO.setIdTema(examen.getIdtema().getId());
            examenDTO.setNotaParaAprobar(examen.getNotaParaAprobar());
            // optiene las preguntas en dto
            List<Pregunta> preguntas = preguntasRepo.findPreguntasByIdExamen(examenId);
            List<PreguntasDTO> preguntasDTO = new ArrayList<>();

            for (Pregunta pregunta : preguntas) {
                PreguntasDTO preguntaDTO = new PreguntasDTO();
                preguntaDTO.setId(pregunta.getId());
                preguntaDTO.setEnunciado(pregunta.getEnunciado());
                preguntaDTO.setIdEstado(pregunta.getIdestado().getId());
                preguntaDTO.setPeso(pregunta.getPeso());
                preguntaDTO.setIdTipoPregunta(pregunta.getIdtipopregunta().getId());
                preguntaDTO.setIdTema(pregunta.getIdtema().getId());
                // lista las respuestas en dto
                List<Respuesta> respuestas = respuestasRepo.findRespuestasByIdPregunta(pregunta.getId());
                List<RespuestasDTO> respuestasDTOs = new ArrayList<>();

                for (Respuesta respuesta : respuestas) {
                    RespuestasDTO respuestaDTO = new RespuestasDTO();
                    respuestaDTO.setCorrecta(respuesta.getCorrecta());
                    respuestaDTO.setId(respuesta.getId());
                    respuestaDTO.setIdPregunta(respuesta.getIdpreguntas().getId());
                    respuestaDTO.setOpcionrespuesta(respuesta.getOpcionrespuesta());
                    respuestasDTOs.add(respuestaDTO);
                }
                preguntaDTO.setRespuestas(respuestasDTOs);
                preguntasDTO.add(preguntaDTO);
            }
            examenDTO.setPreguntas(preguntasDTO);
            examenesDTOs.add(examenDTO);
        }
        return examenesDTOs;
    }

}
