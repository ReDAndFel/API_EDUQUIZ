package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Horario;
import org.springframework.stereotype.Repository;
@Repository
public interface HorariosRepo extends JpaRepository<Horario, Long> {

}