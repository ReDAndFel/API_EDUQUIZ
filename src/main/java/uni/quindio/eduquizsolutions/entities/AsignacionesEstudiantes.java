package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ASIGNACIONES_ESTUDIANTES")
public class AsignacionesEstudiantes implements Serializable {
    @Id
    @Column(name = "IDASIGNACION", nullable = false)
    private Long id;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTUDIANTE", nullable = false)
    private Estudiantes idestudiante;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDEXAMENES", nullable = false)
    private Examenes idexamenes;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalDate horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalDate horaFin;

    @Column(name = "FECHA_ASIGNACION", nullable = false)
    private LocalDate fechaAsignacion;

    @Column(name = "NOTA", nullable = false)
    private Double nota;

}