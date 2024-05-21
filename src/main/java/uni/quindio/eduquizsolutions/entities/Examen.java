package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "EXAMENES")
public class Examen implements Serializable{
    @Id
    @SequenceGenerator(name = "EXAMENES_SEQ", sequenceName = "EXAMENES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAMENES_SEQ")
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
    private LocalTime horaInicio;

    @Column(name = "HORAFIN", nullable = false)
    private LocalTime horaFin;

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