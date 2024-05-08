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
@Table(name = "RESPUESTAS")
public class Respuesta {
    @Id
    @Column(name = "IDRESPUESTA", nullable = false)
    private Long id;

    @Column(name = "OPCIONRESPUESTA", nullable = false, length = 70)
    private String opcionrespuesta;

    @Column(name = "CORRECTA", nullable = false, length = 40)
    private String correcta;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDPREGUNTAS", nullable = false)
    private Pregunta idpreguntas;

}