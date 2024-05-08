package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.AsignacionesPregunta;

@Repository
public interface AsignacionesPreguntaRepo extends JpaRepository<AsignacionesPregunta, Long> {

}