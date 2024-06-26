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
public class Bancopregunta implements Serializable{
    @Id
    @SequenceGenerator(name = "BANCOPREGUNTA_SEQ", sequenceName = "BANCOPREGUNTA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANCOPREGUNTA_SEQ")
    @Column(name = "IDBANCO", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PREGUNTAS_IDPREGUNTA", nullable = false)
    private Pregunta preguntasIdpregunta;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EXAMENES_IDEXAMENEN", nullable = false)
    private Examen examenesIdexamenen;

}