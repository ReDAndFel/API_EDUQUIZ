package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "EXAMENES")
public class Examen {
    @Id
    @Column(name = "IDEXAMENEN", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 80)
    private String titulo;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "DURACIONEXAMEN", nullable = false)
    private Long duracionexamen;

    @Column(name = "CANTIDADPREGUNTAS", nullable = false)
    private Long cantidadpreguntas;

    @Column(name = "CALIFICACION", nullable = false)
    private Double calificacion;

    @Column(name = "HORAINICIO", nullable = false)
    private LocalDate horaInicio;

    @Column(name = "HORAFIN", nullable = false)
    private LocalDate horaFin;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCURSO", nullable = false)
    private Curso idcurso;

    @Column(name = "CANTIDADPREGUNTASPOREXAMEN", nullable = false)
    private Long cantidadpreguntasporexamen;

    @Column(name = "NOTAPARAAPROBAR", nullable = false)
    private Double notaParaAprobar;

    @Column(name = "ESTADO", nullable = false, length = 10)
    private String estado;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDTEMA")
    private Tema idtema;

}