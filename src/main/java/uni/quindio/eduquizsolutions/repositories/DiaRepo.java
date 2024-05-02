package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Dias;
import org.springframework.stereotype.Repository;
@Repository
public interface DiaRepo extends JpaRepository<Dias, Long> {

}