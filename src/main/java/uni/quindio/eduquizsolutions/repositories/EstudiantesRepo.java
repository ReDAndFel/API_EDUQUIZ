package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Estudiante;
import org.springframework.stereotype.Repository;
@Repository
public interface EstudiantesRepo extends JpaRepository<Estudiante, Long> {

}