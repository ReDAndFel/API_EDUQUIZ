package uni.quindio.eduquizsolutions.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uni.quindio.eduquizsolutions.entities.Examen;
import org.springframework.stereotype.Repository;
@Repository
public interface ExamenesRepo extends JpaRepository<Examen, Long > {

    @Query("SELECT e FROM Examen e "
            + "JOIN AsignacionesEstudiante ae ON ae.idexamenes = e "
            + "JOIN ae.idestudiante es "
            + "WHERE es.id = :idEstudiante")
    List<Examen> findExamByIdStudent(Long idEstudiante);

    
    @Query("SELECT e FROM Examen e "
            + "WHERE e.idcurso.id = :idCourse")
    List<Examen> findExamByIdCourse(Long idCourse);

}