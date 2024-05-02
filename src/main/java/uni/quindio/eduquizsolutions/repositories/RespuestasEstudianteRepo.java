package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.RespuestasEstudiantes;
import org.springframework.stereotype.Repository;
@Repository
public interface RespuestasEstudianteRepo extends JpaRepository<RespuestasEstudiantes, Long> {

}