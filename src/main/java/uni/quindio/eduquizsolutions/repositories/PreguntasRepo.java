package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uni.quindio.eduquizsolutions.entities.Pregunta;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntasRepo extends JpaRepository<Pregunta, Long> {

    @Query("SELECT p FROM Pregunta p "
            + "JOIN Bancopregunta bp ON bp.preguntasIdpregunta = p "
            + "JOIN bp.examenesIdexamenen e "
            + "WHERE e.id = :idExamen")
    List<Pregunta> findPreguntasByIdExamen(Long idExamen);

    @Query("SELECT p, ap FROM Pregunta p "
    + "JOIN Bancopregunta bp ON bp.preguntasIdpregunta = p "
    + "JOIN AsignacionesPregunta ap ON ap.idbanco = bp "
    + "JOIN AsignacionesEstudiante ae ON ae = ap.idasignacionestudiante "
    + "JOIN ae.idexamenes e "
    + "JOIN ae.idestudiante es "
    + "WHERE e.id = :idExamen AND es.id = :idEstudiante")
    List<Object[]> findPreguntasAsignadasByIdExamenAndIdEstudiante(Long idExamen, Long idEstudiante);

}