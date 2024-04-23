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
@Table(name = "TEMAS")
public class Temas implements Serializable{
    @Id
    @Column(name = "IDTEMA", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDCONTENIDO", nullable = false)
    private Contenidos idcontenido;

}