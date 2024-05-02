package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Docentes;
@Repository
public interface DocentesRepo extends JpaRepository<Docentes, Long> {

}