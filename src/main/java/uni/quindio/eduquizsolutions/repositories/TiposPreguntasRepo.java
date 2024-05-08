package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.TiposPregunta;
import org.springframework.stereotype.Repository;
@Repository
public interface TiposPreguntasRepo extends JpaRepository<TiposPregunta, Long> {

}