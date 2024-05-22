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
public class AsignacionesPregunta  implements Serializable{
    @Id
    @Column(name = "IDASIGNACIONPREGUNTA", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDASIGNACIONESTUDIANTE", nullable = false)
    private AsignacionesEstudiante idasignacionestudiante;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDBANCO", nullable = false)
    private Bancopregunta idbanco;

}