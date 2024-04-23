package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Bancopreguntas;

@Repository
public interface BancopreguntasRepo extends JpaRepository<Bancopreguntas, Integer> {

}