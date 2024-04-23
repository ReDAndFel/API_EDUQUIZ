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
@Table(name = "ESTUDIANTES")
public class Estudiantes implements Serializable {
    @Id
    @Column(name = "IDESTUDIANTE", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 40)
    private String apellido;

    @Column(name = "USUARIO", nullable = false, length = 40)
    private String usuario;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 40)
    private String password;

    @Column(name = "TELEFONO")
    private Long telefono;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCURSO", nullable = false)
    private Cursos idcurso;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDGRUPO", nullable = false)
    private Grupos idgrupo;

}