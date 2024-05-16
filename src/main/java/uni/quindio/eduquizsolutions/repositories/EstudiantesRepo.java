package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uni.quindio.eduquizsolutions.entities.Estudiante;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepo extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e "
            + "JOIN EstudianteCurso ec ON ec.idestudiante = e "
            + "JOIN ec.idcurso c "
            + "WHERE c.id = :idCurso")
    List<Estudiante> findByCouseId(Long idCurso);

}