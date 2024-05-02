package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "HORARIOS")
public class Horarios implements Serializable {
    @Id
    @Column(name = "IDHORARIO", nullable = false)
    private Long id;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalDate horaInicio;

    @Column(name = "HORA_FIN", nullable = false)
    private LocalDate horaFin;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDASIGNACIONDIA", nullable = false)
    private AsignacionDias idasignaciondia;

}