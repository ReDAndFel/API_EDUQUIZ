package uni.quindio.eduquizsolutions.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Tema;
import org.springframework.stereotype.Repository;

@Repository
public interface TemasRepo extends JpaRepository<Tema, Long> {
    
}