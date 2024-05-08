package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import uni.quindio.eduquizsolutions.entities.Curso;
import org.springframework.stereotype.Repository;
@Repository
public interface CursosRepo extends JpaRepository<Curso, Long> {

}