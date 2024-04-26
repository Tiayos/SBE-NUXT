package ec.edu.ups.ins.entity.model.org;

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

    @Basic(optional = false)
    @Column(name = "EST_CODIGO_REFERENCIAL", nullable = false)
    private Long estCodigoReferencial;
    @Basic( optional = false)
    @Column(name = "EST_NIVEL", nullable = false)
    private Integer estNivel;
    @Basic(optional = false)
    @Column( name = "EST_ACTIVADO", nullable = false, length = 1 )
    private String estActivado;

    // usando proyecciones

    public Estructura() {

    }
    public Estructura(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEstCodigoReferencial() {
        return estCodigoReferencial;
    }

    public void setEstCodigoReferencial(Long estCodigoReferencial) {
        this.estCodigoReferencial = estCodigoReferencial;
    }

    public Integer getEstNivel() {
        return estNivel;
    }

    public void setEstNivel(Integer estNivel) {
        this.estNivel = estNivel;
    }

    public String getEstActivado() {
        return estActivado;
    }

    public void setEstActivado(String estActivado) {
        this.estActivado = estActivado;
    }

}


