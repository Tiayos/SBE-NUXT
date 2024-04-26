package ups.edu.ups.sol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SOL_SOLICITUD_EVENTO", schema = "SOL")
@NamedStoredProcedureQuery(name = "obtenerPeriodo",
        procedureName = "org.p_find_periodo_vigente_por_estructura",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "cedula", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "periodo", type = Integer.class)
        })
public class SolSolicitudEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SOE_CODIGO")
    private Long soeCodigo;
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Basic(optional = false)
    @Column(name = "SOL_CODIGO")
    private long solCodigo;
    @Basic(optional = false)
    @Column(name = "SOE_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime soeFecha;
    @Basic(optional = false)
    @Column(name = "SOE_ESTADO")
    private String soeEstado;
    @Column(name = "SOE_OBSERVACION")
    private String soeObservacion;
    @Column(name = "CON_CODIGO")
    private Long conCodigo;
    @Column(name = "SOE_TIPO")
    private String soeTipo;
    @Basic(optional = false)
    @Column(name = "SOE_VIGENTE")
    private String soeVigente;
    @Lob
    @Column(name = "SOE_INFORME")
    private String soeInforme;
    @Column(name = "SOE_OBSERVACION_ADICIONAL")
    private String soeObservacionAdicional;

    @Basic(optional = false)
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "AUD_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime audFechaModificacion;


    public SolSolicitudEvento() {
    }

    public SolSolicitudEvento(Long soeCodigo) {
        this.soeCodigo = soeCodigo;
    }

    public SolSolicitudEvento(Long soeCodigo, long solCodigo, LocalDateTime soeFecha, String soeEstado, String audEliminado, String audAdicionado, String soeVigente) {
        this.soeCodigo = soeCodigo;
        this.solCodigo = solCodigo;
        this.soeFecha = soeFecha;
        this.soeEstado = soeEstado;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.soeVigente = soeVigente;
    }

    @PrePersist
    public void prePersist(){
        this.audEliminado = "N";
        this.audAdicionado = "SBE";
        this.audFechaAdicion = LocalDateTime.now();
        this.soeFecha = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.audModificado="SBE";
        this.audFechaModificacion = LocalDateTime.now();
    }

    public Long getSoeCodigo() {
        return soeCodigo;
    }

    public void setSoeCodigo(Long soeCodigo) {
        this.soeCodigo = soeCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public long getSolCodigo() {
        return solCodigo;
    }

    public void setSolCodigo(long solCodigo) {
        this.solCodigo = solCodigo;
    }

    public LocalDateTime getSoeFecha() {
        return soeFecha;
    }

    public void setSoeFecha(LocalDateTime soeFecha) {
        this.soeFecha = soeFecha;
    }

    public String getSoeEstado() {
        return soeEstado;
    }

    public void setSoeEstado(String soeEstado) {
        this.soeEstado = soeEstado;
    }

    public String getSoeObservacion() {
        return soeObservacion;
    }

    public void setSoeObservacion(String soeObservacion) {
        this.soeObservacion = soeObservacion;
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

    public LocalDateTime getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(LocalDateTime audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public String getAudModificado() {
        return audModificado;
    }

    public void setAudModificado(String audModificado) {
        this.audModificado = audModificado;
    }

    public LocalDateTime getAudFechaModificacion() {
        return audFechaModificacion;
    }

    public void setAudFechaModificacion(LocalDateTime audFechaModificacion) {
        this.audFechaModificacion = audFechaModificacion;
    }

    public Long getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getSoeTipo() {
        return soeTipo;
    }

    public void setSoeTipo(String soeTipo) {
        this.soeTipo = soeTipo;
    }

    public String getSoeVigente() {
        return soeVigente;
    }

    public void setSoeVigente(String soeVigente) {
        this.soeVigente = soeVigente;
    }

    public String getSoeInforme() {
        return soeInforme;
    }

    public void setSoeInforme(String soeInforme) {
        this.soeInforme = soeInforme;
    }

    public String getSoeObservacionAdicional() {
        return soeObservacionAdicional;
    }

    public void setSoeObservacionAdicional(String soeObservacionAdicional) {
        this.soeObservacionAdicional = soeObservacionAdicional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soeCodigo != null ? soeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolSolicitudEvento)) {
            return false;
        }
        SolSolicitudEvento other = (SolSolicitudEvento) object;
        if ((this.soeCodigo == null && other.soeCodigo != null) || (this.soeCodigo != null && !this.soeCodigo.equals(other.soeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject7.SolSolicitudEvento[ soeCodigo=" + soeCodigo + " ]";
    }
}
