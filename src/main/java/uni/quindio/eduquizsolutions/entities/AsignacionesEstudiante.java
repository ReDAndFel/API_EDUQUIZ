package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "ASIGNACIONES_ESTUDIANTES")
public class AsignacionesEstudiante implements Serializable {
    @Id
    @SequenceGenerator(name = "ASIGNACIONES_ESTUDIANTES_SEQ", sequenceName = "ASIGNACIONES_ESTUDIANTES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASIGNACIONES_ESTUDIANTES_SEQ")
    @Column(name = "IDASIGNACION", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTUDIANTE", nullable = false)
    private Estudiante idestudiante;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDEXAMENES", nullable = false)
    private Examen idexamenes;

    @Column(name = "NOTA", nullable = false)
    private Double nota;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalTime horaFin;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

}