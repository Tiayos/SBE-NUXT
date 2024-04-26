/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ups.sol.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SOL_TIPO_PERSONA_SOLICITANTE", schema = "SOL")
public class SolTipoPersonaSolicitante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TPS_CODIGO")
    private Long tpsCodigo;
    @Basic(optional = false)
    @Column(name = "TPS_DESCRIPCION")
    private String tpsDescripcion;
    @Basic(optional = false)
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "AUD_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaModificacion;

    public SolTipoPersonaSolicitante() {
    }

    public SolTipoPersonaSolicitante(Long tpsCodigo) {
        this.tpsCodigo = tpsCodigo;
    }

    public SolTipoPersonaSolicitante(Long tpsCodigo, String tpsDescripcion, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.tpsCodigo = tpsCodigo;
        this.tpsDescripcion = tpsDescripcion;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getTpsCodigo() {
        return tpsCodigo;
    }

    public void setTpsCodigo(Long tpsCodigo) {
        this.tpsCodigo = tpsCodigo;
    }

    public String getTpsDescripcion() {
        return tpsDescripcion;
    }

    public void setTpsDescripcion(String tpsDescripcion) {
        this.tpsDescripcion = tpsDescripcion;
    }

    public String getAudEliminado() {
        return audEliminado;
    }

    public void setAudEliminado(String audEliminado) {
        this.audEliminado = audEliminado;
    }

    public String getAudAdicionado() {
        return audAdicionado;
    }

    public void setAudAdicionado(String audAdicionado) {
        this.audAdicionado = audAdicionado;
    }

    public Date getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(Date audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public String getAudModificado() {
        return audModificado;
    }

    public void setAudModificado(String audModificado) {
        this.audModificado = audModificado;
    }

    public Date getAudFechaModificacion() {
        return audFechaModificacion;
    }

    public void setAudFechaModificacion(Date audFechaModificacion) {
        this.audFechaModificacion = audFechaModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpsCodigo != null ? tpsCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolTipoPersonaSolicitante)) {
            return false;
        }
        SolTipoPersonaSolicitante other = (SolTipoPersonaSolicitante) object;
        if ((this.tpsCodigo == null && other.tpsCodigo != null) || (this.tpsCodigo != null && !this.tpsCodigo.equals(other.tpsCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject5.SolTipoPersonaSolicitante[ tpsCodigo=" + tpsCodigo + " ]";
    }
    
}
