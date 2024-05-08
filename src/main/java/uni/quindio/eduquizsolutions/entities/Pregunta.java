package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PREGUNTAS")
public class Pregunta {
    @Id
    @Column(name = "IDPREGUNTA", nullable = false)
    private Long id;

    @Column(name = "ENUNCIADO", nullable = false, length = 100)
    private String enunciado;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTEMA", nullable = false)
    private Tema idtema;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTIPOPREGUNTA", nullable = false)
    private TiposPregunta idtipopregunta;

}