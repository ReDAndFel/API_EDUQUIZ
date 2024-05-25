package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uni.quindio.eduquizsolutions.entities.Bancopregunta;

@Repository
public interface BancopreguntasRepo extends JpaRepository<Bancopregunta, Long> {

    @Query("SELECT b FROM Bancopregunta b "
            + "WHERE b.examenesIdexamenen.id = :idExam")
    List<Bancopregunta> findBankByIdExam(Long idExam);

    @Query("SELECT b FROM Bancopregunta b "
            + "WHERE b.examenesIdexamenen.id = :idExam and b.preguntasIdpregunta.id = :idQuestion")
    List<Bancopregunta> findBankByIdExamAndIdQuestion(Long idExam, long idQuestion);

}