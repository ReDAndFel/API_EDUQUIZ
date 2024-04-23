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
@Table(name = "GRUPOS")
public class Grupos implements Serializable {
    @Id
    @Column(name = "IDGRUPO", nullable = false)
    private Long id;

    @Column(name = "NOMBREGRUPO", nullable = false, length = 40)
    private String nombregrupo;

    @Column(name = "ANOACADEMICO", nullable = false)
    private LocalDate anoacademico;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDDOCENTE_TUTOR", nullable = false)
    private Docentes iddocenteTutor;

}