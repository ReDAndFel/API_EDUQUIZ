package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.AsignacionesEstudiantes;
@Repository
public interface AsignacionesEstudianteRepo extends JpaRepository<AsignacionesEstudiantes, Long> {

}