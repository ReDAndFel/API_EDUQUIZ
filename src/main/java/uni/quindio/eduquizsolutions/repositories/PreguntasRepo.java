package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Preguntas;
import org.springframework.stereotype.Repository;
@Repository
public interface PreguntasRepo extends JpaRepository<Preguntas, Integer> {

}