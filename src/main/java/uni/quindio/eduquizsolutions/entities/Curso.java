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
@Table(name = "CURSOS")
public class Curso implements Serializable{
    @Id
    @Column(name = "IDCURSO", nullable = false)
    private Long id;

    @Column(name = "NOMBRECURSO", length = 60)
    private String nombrecurso;

    @Column(name = "DESCRIPCION", length = 60)
    private String descripcion;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDDOCENTE", nullable = false)
    private Docente iddocente;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDMATERIA", nullable = false)
    private Materia idmateria;

}