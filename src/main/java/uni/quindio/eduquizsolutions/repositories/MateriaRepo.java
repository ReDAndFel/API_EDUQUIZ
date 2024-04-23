package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Materias;
import org.springframework.stereotype.Repository;
@Repository
public interface MateriaRepo extends JpaRepository<Materias, Integer> {

}