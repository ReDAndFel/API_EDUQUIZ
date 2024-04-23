package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Grupos;
import org.springframework.stereotype.Repository;
@Repository
public interface GruposRepo extends JpaRepository<Grupos, Integer> {
   
}