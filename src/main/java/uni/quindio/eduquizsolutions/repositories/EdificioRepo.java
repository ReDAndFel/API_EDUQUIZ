package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Edificios;
import org.springframework.stereotype.Repository;
@Repository
public interface EdificioRepo extends JpaRepository<Edificios, Long> {

}