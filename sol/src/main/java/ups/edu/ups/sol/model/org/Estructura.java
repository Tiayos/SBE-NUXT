package ups.edu.ups.sol.model.org;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "ORG_ESTRUCTURA", schema = "ORG")
@Data
public class Estructura implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "EST_CODIGO")
    private Long estCodigo;

    // usando proyecciones

    public Estructura() {

    }
    public Estructura(Long estCodigo) {
        this.estCodigo = estCodigo;
    }


}


