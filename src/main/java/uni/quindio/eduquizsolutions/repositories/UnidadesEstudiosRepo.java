package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.UnidadesEstudio;
import org.springframework.stereotype.Repository;
@Repository
public interface UnidadesEstudiosRepo extends JpaRepository<UnidadesEstudio, Long> {

}