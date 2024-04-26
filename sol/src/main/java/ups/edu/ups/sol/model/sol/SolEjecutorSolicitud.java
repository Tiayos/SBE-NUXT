package ups.edu.ups.sol.model.sol;


import jakarta.persistence.*;
import ups.edu.ups.sol.model.SolSolicitud;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SOL_EJECUTOR_SOLICITUD", schema = "SOL")
public class SolEjecutorSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EJS_CODIGO")
    private Long ejsCodigo;
    @Basic(optional = false)
    @Column(name = "PER_CODIGO")
    private long perCodigo;
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
    @JoinColumn(name = "SOL_CODIGO", referencedColumnName = "SOL_CODIGO")
    @ManyToOne(optional = false)
    private SolSolicitud solSolicitud;

    public SolEjecutorSolicitud() {
    }

    public SolEjecutorSolicitud(Long ejsCodigo) {
        this.ejsCodigo = ejsCodigo;
    }

    public SolEjecutorSolicitud(Long ejsCodigo, long perCodigo, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.ejsCodigo = ejsCodigo;
        this.perCodigo = perCodigo;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getEjsCodigo() {
        return ejsCodigo;
    }

    public void setEjsCodigo(Long ejsCodigo) {
        this.ejsCodigo = ejsCodigo;
    }

    public long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(long perCodigo) {
        this.perCodigo = perCodigo;
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

    public SolSolicitud getSolSolicitud() {
        return solSolicitud;
    }

    public void setSolSolicitud(SolSolicitud solSolicitud) {
        this.solSolicitud = solSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejsCodigo != null ? ejsCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolEjecutorSolicitud)) {
            return false;
        }
        SolEjecutorSolicitud other = (SolEjecutorSolicitud) object;
        if ((this.ejsCodigo == null && other.ejsCodigo != null) || (this.ejsCodigo != null && !this.ejsCodigo.equals(other.ejsCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject1.SolEjecutorSolicitud[ ejsCodigo=" + ejsCodigo + " ]";
    }

}
