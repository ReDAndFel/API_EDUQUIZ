package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Examen;
import org.springframework.stereotype.Repository;
@Repository
public interface ExamenesRepo extends JpaRepository<Examen, Long> {

}