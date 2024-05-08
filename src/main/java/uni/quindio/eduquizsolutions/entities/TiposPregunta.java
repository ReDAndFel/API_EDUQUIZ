package uni.quindio.eduquizsolutions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TIPOSPREGUNTAS")
public class TiposPregunta {
    @Id
    @Column(name = "IDTIPOPREGUNTA", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false, length = 60)
    private String descripcion;

}