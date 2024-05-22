package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "UNIDADESESTUDIO")
public class UnidadesEstudio implements Serializable {
    @Id
    @Column(name = "IDUNIDAD", nullable = false)
    private Long id;

    @Column(name = "NOMBRE_UNIDAD", nullable = false, length = 40)
    private String nombreUnidad;

    @Column(name = "DESCRIPCION", nullable = false, length = 40)
    private String descripcion;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDMATERIA", nullable = false)
    private Materia idmateria;

}