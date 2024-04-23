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
@Table(name = "EXAMENES")
public class Examenes implements Serializable {
    @Id
    @Column(name = "IDEXAMENEN", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 80)
    private String titulo;

    @Column(name = "FECHAYHORACREACION", nullable = false)
    private LocalDate fechayhoracreacion;

    @Column(name = "DURACIONEXAMEN", nullable = false)
    private Long duracionexamen;

    @Column(name = "CANTIDADPREGUNTAS")
    private Long cantidadpreguntas;

    @Column(name = "CALIFICACION", nullable = false)
    private Double calificacion;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDHORARIO", nullable = false)
    private Horarios idhorario;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCURSO", nullable = false)
    private Cursos idcurso;

}