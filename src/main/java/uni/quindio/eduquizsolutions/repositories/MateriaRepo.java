package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Materia;
import org.springframework.stereotype.Repository;
@Repository
public interface MateriaRepo extends JpaRepository<Materia, Long> {

}