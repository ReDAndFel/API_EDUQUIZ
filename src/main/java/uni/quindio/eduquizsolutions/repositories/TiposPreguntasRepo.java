package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.TiposPreguntas;
import org.springframework.stereotype.Repository;
@Repository
public interface TiposPreguntasRepo extends JpaRepository<TiposPreguntas, Long> {

}