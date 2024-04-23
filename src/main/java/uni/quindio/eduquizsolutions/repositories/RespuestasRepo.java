package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Respuestas;
import org.springframework.stereotype.Repository;
@Repository
public interface RespuestasRepo extends JpaRepository<Respuestas, Integer> {

}