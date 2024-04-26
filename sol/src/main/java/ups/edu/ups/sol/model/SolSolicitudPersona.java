/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ups.sol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import ups.edu.ups.sol.model.ins.InsAlumno;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SOL_SOLICITUD_PERSONA", schema = "SOL")
public class SolSolicitudPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SOP_CODIGO")
    private Long sopCodigo;
    @Basic(optional = false)
    @Column(name = "SOL_CODIGO")
    private long solCodigo;
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Column(name = "ALU_CODIGO")
    private Long aluCodigo;
    @Basic(optional = false)
    @Column(name = "SOP_PRINCIPAL")
    private String sopPrincipal;
    @Column(name = "CLLC_CDG_MIG")
    private Long cllcCdgMig;
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
    @JoinColumn(name = "OTS_CODIGO", referencedColumnName = "OTS_CODIGO")
    @ManyToOne
    private SolOtroSolicitante otsCodigo;
    @JoinColumn(name = "TPS_CODIGO", referencedColumnName = "TPS_CODIGO")
    @ManyToOne(optional = false)
    private SolTipoPersonaSolicitante tpsCodigo;

    public SolSolicitudPersona() {
    }

    public SolSolicitudPersona(Long sopCodigo) {
        this.sopCodigo = sopCodigo;
    }

    public SolSolicitudPersona(Long sopCodigo, long solCodigo, String sopPrincipal, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.sopCodigo = sopCodigo;
        this.solCodigo = solCodigo;
        this.sopPrincipal = sopPrincipal;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getSopCodigo() {
        return sopCodigo;
    }

    public void setSopCodigo(Long sopCodigo) {
        this.sopCodigo = sopCodigo;
    }

    public long getSolCodigo() {
        return solCodigo;
    }

    public void setSolCodigo(long solCodigo) {
        this.solCodigo = solCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public String getSopPrincipal() {
        return sopPrincipal;
    }

    public void setSopPrincipal(String sopPrincipal) {
        this.sopPrincipal = sopPrincipal;
    }

    public Long getCllcCdgMig() {
        return cllcCdgMig;
    }

    public void setCllcCdgMig(Long cllcCdgMig) {
        this.cllcCdgMig = cllcCdgMig;
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

    public SolOtroSolicitante getOtsCodigo() {
        return otsCodigo;
    }

    public void setOtsCodigo(SolOtroSolicitante otsCodigo) {
        this.otsCodigo = otsCodigo;
    }

    public SolTipoPersonaSolicitante getTpsCodigo() {
        return tpsCodigo;
    }

    public void setTpsCodigo(SolTipoPersonaSolicitante tpsCodigo) {
        this.tpsCodigo = tpsCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sopCodigo != null ? sopCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolSolicitudPersona)) {
            return false;
        }
        SolSolicitudPersona other = (SolSolicitudPersona) object;
        if ((this.sopCodigo == null && other.sopCodigo != null) || (this.sopCodigo != null && !this.sopCodigo.equals(other.sopCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject7.SolSolicitudPersona[ sopCodigo=" + sopCodigo + " ]";
    }

}
