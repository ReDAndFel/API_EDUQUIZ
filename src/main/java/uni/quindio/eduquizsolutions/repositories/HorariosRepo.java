package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Horarios;
import org.springframework.stereotype.Repository;
@Repository
public interface HorariosRepo extends JpaRepository<Horarios, Integer> {

}