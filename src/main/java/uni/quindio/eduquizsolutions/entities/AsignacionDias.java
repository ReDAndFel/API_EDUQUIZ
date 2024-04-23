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
@Table(name = "ASIGNACION_DIAS")
public class AsignacionDias implements Serializable {
    @Id
    @Column(name = "IDASIGNACIONDIA", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDDIA", nullable = false)
    private Dias iddia;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCURSO", nullable = false)
    private Cursos idcurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDLUGAR", nullable = false)
    private Lugares idlugar;

}