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
@Table(name = "INSTITUCIONES")
public class Institucion {
    @Id
    @Column(name = "IDINSTITUCION", nullable = false)
    private Long id;

    @Column(name = "NOMBRENINSTITUCION", nullable = false, length = 40)
    private String nombreninstitucion;

    @Column(name = "DESCRIPCION", length = 40)
    private String descripcion;

    @Column(name = "DIRECCION", length = 40)
    private String direccion;

    @Column(name = "TELEFONO")
    private Long telefono;

}