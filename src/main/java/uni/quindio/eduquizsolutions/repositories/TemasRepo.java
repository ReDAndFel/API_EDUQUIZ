package uni.quindio.eduquizsolutions.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uni.quindio.eduquizsolutions.entities.Tema;
import org.springframework.stereotype.Repository;

@Repository
public interface TemasRepo extends JpaRepository<Tema, Long> {
    @Query("SELECT t FROM Tema t "
            + "JOIN t.idcontenido c "
            + "JOIN c.idunidad u "
            + "JOIN u.idmateria m "
            + "JOIN m.idcurso cu "
            + "WHERE cu.id = :idCurso")
    List<Tema> findTemasByCursoId(Long idCurso);

}