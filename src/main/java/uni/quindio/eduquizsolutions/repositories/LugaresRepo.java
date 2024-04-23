package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Lugares;
import org.springframework.stereotype.Repository;
@Repository
public interface LugaresRepo extends JpaRepository<Lugares, Integer> {

}