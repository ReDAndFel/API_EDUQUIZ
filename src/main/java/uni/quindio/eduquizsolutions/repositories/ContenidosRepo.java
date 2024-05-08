package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Contenido;

@Repository
public interface ContenidosRepo extends JpaRepository<Contenido, Long> {

}