package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Salones;
import org.springframework.stereotype.Repository;
@Repository
public interface SalonesRepo extends JpaRepository<Salones, Integer> {

}