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
@Table(name = "ASIGNACIONES_PREGUNTAS")
public class AsignacionesPreguntas implements Serializable {
    @Id
    @Column(name = "IDASIGNACION", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTUDIANTE", nullable = false)
    private Estudiantes idestudiante;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDPREGUNTAS", nullable = false)
    private Preguntas idpreguntas;

}