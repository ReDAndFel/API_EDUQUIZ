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
@Table(name = "SALONES")
public class Salones implements Serializable {
    @Id
    @Column(name = "IDSALON", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", length = 40)
    private String descripcion;

}