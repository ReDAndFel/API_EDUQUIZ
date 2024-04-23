package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Estudiantes;
import org.springframework.stereotype.Repository;
@Repository
public interface EstudiantesRepo extends JpaRepository<Estudiantes, Integer> {

}