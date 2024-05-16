package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uni.quindio.eduquizsolutions.entities.Pregunta;
import uni.quindio.eduquizsolutions.entities.RespuestasEstudiante;
import org.springframework.stereotype.Repository;
@Repository
public interface RespuestasEstudianteRepo extends JpaRepository<RespuestasEstudiante, Long> {
    

}