package uni.quindio.eduquizsolutions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.quindio.eduquizsolutions.entities.Instituciones;
import org.springframework.stereotype.Repository;
@Repository
public interface InstitucionesRepo extends JpaRepository<Instituciones, Integer> {

}