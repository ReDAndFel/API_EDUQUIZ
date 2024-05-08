package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Respuesta;
import org.springframework.stereotype.Repository;
@Repository
public interface RespuestasRepo extends JpaRepository<Respuesta, Long> {

}