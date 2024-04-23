package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.AsignacionesPreguntas;

@Repository
public interface AsignacionesPreguntaRepo extends JpaRepository<AsignacionesPreguntas, Integer> {

}