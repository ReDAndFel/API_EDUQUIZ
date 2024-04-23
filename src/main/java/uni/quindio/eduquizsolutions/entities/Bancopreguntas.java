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
@Table(name = "BANCOPREGUNTAS")
public class Bancopreguntas implements Serializable{
    @Id
    @Column(name = "IDBANCO", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_IDPREGUNTA", nullable = false)
    private Preguntas preguntasIdpregunta;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_IDEXAMENEN", nullable = false)
    private Examenes examenesIdexamenen;

}