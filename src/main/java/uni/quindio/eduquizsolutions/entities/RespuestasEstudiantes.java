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
@Table(name = "RESPUESTAS_ESTUDIANTES")
public class RespuestasEstudiantes implements Serializable {
    @Id
    @Column(name = "IDRESPUESTAESTUDIANTE", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTUDIANTE", nullable = false)
    private Estudiantes idestudiante;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDEXAMENES", nullable = false)
    private Examenes idexamenes;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDPREGUNTAS", nullable = false)
    private Preguntas idpreguntas;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDRESPUESTA", nullable = false)
    private Respuestas idrespuesta;

}