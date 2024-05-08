package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Dia;
import org.springframework.stereotype.Repository;
@Repository
public interface DiaRepo extends JpaRepository<Dia, Long> {

}