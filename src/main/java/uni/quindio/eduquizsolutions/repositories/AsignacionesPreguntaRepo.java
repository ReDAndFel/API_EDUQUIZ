package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.AsignacionesPregunta;

@Repository
public interface AsignacionesPreguntaRepo extends JpaRepository<AsignacionesPregunta, Long> {

     @Query("SELECT ap FROM AsignacionesPregunta ap "
            + "WHERE ap.idasignacionestudiante.id = :idAsignacionEstudiante")
    List<AsignacionesPregunta> findAsignacionesPreguntasIdAsignEstudiante( Long idAsignacionEstudiante);

}