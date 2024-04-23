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
@Table(name = "PREGUNTAS")
public class Preguntas implements Serializable {
    @Id
    @Column(name = "IDPREGUNTA", nullable = false)
    private Long id;

    @Column(name = "ENUNCIADO", nullable = false, length = 100)
    private String enunciado;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTEMA", nullable = false)
    private Temas idtema;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estados idestado;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTIPOPREGUNTA", nullable = false)
    private TiposPreguntas idtipopregunta;

}