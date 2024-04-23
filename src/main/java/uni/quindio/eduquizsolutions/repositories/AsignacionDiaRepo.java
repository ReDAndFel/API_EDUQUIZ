package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.AsignacionDias;
@Repository
public interface AsignacionDiaRepo extends JpaRepository<AsignacionDias, Integer> {

}