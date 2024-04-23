package uni.quindio.eduquizsolutions.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ESTADOS")
public class Estados implements Serializable{
    @Id
    @Column(name = "IDESTADO", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", length = 40)
    private String descripcion;

}