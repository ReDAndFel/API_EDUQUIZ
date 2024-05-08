package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Docente;
@Repository
public interface DocentesRepo extends JpaRepository<Docente, Long> {

}