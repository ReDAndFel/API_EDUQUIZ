package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Contenidos;

@Repository
public interface ContenidosRepo extends JpaRepository<Contenidos, Long> {

}