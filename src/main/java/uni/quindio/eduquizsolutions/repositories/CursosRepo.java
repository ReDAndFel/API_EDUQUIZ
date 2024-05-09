package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uni.quindio.eduquizsolutions.entities.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepo extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c "
            + "JOIN c.iddocente d "
            + "JOIN d.idinstitucion i "
            + "WHERE i.id = :idInstitucion")
    List<Curso> findCoursesByInstitutionId(@Param("idInstitucion") Long idInstitucion);

}