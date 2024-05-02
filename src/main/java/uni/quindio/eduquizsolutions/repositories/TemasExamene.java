package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.TemasExamenes;
import org.springframework.stereotype.Repository;
@Repository
public interface TemasExamene  extends JpaRepository<TemasExamenes,Long>{

}