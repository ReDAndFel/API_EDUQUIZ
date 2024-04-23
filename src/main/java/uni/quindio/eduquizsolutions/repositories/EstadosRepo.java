package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Estados;
import org.springframework.stereotype.Repository;
@Repository
public interface EstadosRepo extends JpaRepository<Estados, Integer> {

}