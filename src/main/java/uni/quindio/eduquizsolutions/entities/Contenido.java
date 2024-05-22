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
@Table(name = "CONTENIDOS")
public class Contenido implements Serializable {
    @Id
    @Column(name = "IDCONTENIDO", nullable = false)
    private Long id;

    @Column(name = "DESCRICONTENIDO", nullable = false, length = 60)
    private String descricontenido;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDUNIDAD", nullable = false)
    private UnidadesEstudio idunidad;

}