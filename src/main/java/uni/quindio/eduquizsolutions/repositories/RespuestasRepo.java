package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uni.quindio.eduquizsolutions.entities.Respuesta;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasRepo extends JpaRepository<Respuesta, Long> {

    @Query("SELECT r FROM Respuesta r "
            + "JOIN r.idpreguntas p "
            + "WHERE p.id = :idPregunta")
    List<Respuesta> findRespuestasByIdPregunta(Long idPregunta);

}