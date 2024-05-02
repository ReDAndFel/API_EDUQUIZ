package uni.quindio.eduquizsolutions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.quindio.eduquizsolutions.DTOS.HorariosDTO;
import uni.quindio.eduquizsolutions.DTOS.MessageDTO;
import uni.quindio.eduquizsolutions.DTOS.PreguntasDTO;
import uni.quindio.eduquizsolutions.DTOS.RespuestasDTO;
import uni.quindio.eduquizsolutions.entities.Dias;
import uni.quindio.eduquizsolutions.entities.Estados;
import uni.quindio.eduquizsolutions.entities.Horarios;
import uni.quindio.eduquizsolutions.entities.Preguntas;
import uni.quindio.eduquizsolutions.entities.Respuestas;
import uni.quindio.eduquizsolutions.entities.Temas;
import uni.quindio.eduquizsolutions.entities.TiposPreguntas;
import uni.quindio.eduquizsolutions.repositories.DiaRepo;
import uni.quindio.eduquizsolutions.repositories.DocentesRepo;
import uni.quindio.eduquizsolutions.repositories.EstadosRepo;
import uni.quindio.eduquizsolutions.repositories.HorariosRepo;
import uni.quindio.eduquizsolutions.repositories.PreguntasRepo;
import uni.quindio.eduquizsolutions.repositories.RespuestasRepo;
import uni.quindio.eduquizsolutions.repositories.TemasRepo;
import uni.quindio.eduquizsolutions.repositories.TiposPreguntasRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class HorarioController {

        @Autowired
        HorariosRepo horariosRepo;

        @Autowired
        DiaRepo diaRepo;

        @GetMapping("/horario/{id}")
        public ResponseEntity<MessageDTO> getScheduleById(@PathVariable long id) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, horariosRepo.findById(id).get()));
        }

        @PostMapping("/horario")
        public ResponseEntity<MessageDTO> createSchedule(@RequestBody HorariosDTO horariosDTO) {

                Horarios horario = new Horarios(
                        null,
                        horariosDTO.getHoraInicio(),
                        horariosDTO.getHoraFin(),
                        
                );

                horariosRepo.save(horario);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Horario creado correctamente"));
        }

        @PutMapping("/horario/{id}")
        public ResponseEntity<MessageDTO> updateAnswer(@PathVariable long id,
                        @RequestBody HorariosDTO horariosDTO) {

                Horarios horario = horariosRepo.findById(id).get();

                horario.setHoraFin(horariosDTO.getHoraFin());
                horario.setHoraInicio(horariosDTO.getHoraInicio());
                horario.setIdasignaciondia(null);

                horariosRepo.save(horario);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(new MessageDTO(HttpStatus.OK, false, "Horario actualizada correctamente"));
        }

        @DeleteMapping("/horario/{}")
        public ResponseEntity<MessageDTO> deleteAnswer(@PathVariable long id) {
                horariosRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new MessageDTO(HttpStatus.CREATED, false, "Horario eliminada correctamente"));
        }
}
