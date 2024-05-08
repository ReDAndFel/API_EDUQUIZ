package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DIAS")
public class Dia {
    @Id
    @Column(name = "IDDIA", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false, length = 40)
    private String descripcion;

}