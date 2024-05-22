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
public class RespuestasEstudiante implements Serializable{
    @Id
    @Column(name = "IDRESPUESTAESTUDIANTE", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDRESPUESTA", nullable = false)
    private Respuesta idrespuesta;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDASIGNACIONPREGUNTA", nullable = false)
    private AsignacionesPregunta idasignacionpregunta;

    @Column(name = "RESPUESTA", nullable = false, length = 100)
    private String respuesta;

}