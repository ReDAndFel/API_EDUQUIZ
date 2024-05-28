package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import uni.quindio.eduquizsolutions.entities.AsignacionesEstudiante;

@Repository
public interface AsignacionesEstudianteRepo extends JpaRepository<AsignacionesEstudiante, Long> {

        @Query("SELECT ae FROM AsignacionesEstudiante ae "
                        + "JOIN ae.idestudiante e "
                        + "WHERE e.id = :idEstudiante")
        List<AsignacionesEstudiante> findByIdEstudiante(Long idEstudiante);

        @Query("SELECT ae FROM AsignacionesEstudiante ae "
                        + "JOIN ae.idexamenes ex "
                        + "WHERE ex.id = :idExamen")
        List<AsignacionesEstudiante> findByIdExamen(Long idExamen);

        @Query("SELECT ae FROM AsignacionesEstudiante ae "
                        + "WHERE ae.idestudiante.id = :idEstudiante AND ae.idexamenes.id = :idExamen")
        AsignacionesEstudiante findByIdEstudianteAndIdExamen(Long idEstudiante, Long idExamen);
}