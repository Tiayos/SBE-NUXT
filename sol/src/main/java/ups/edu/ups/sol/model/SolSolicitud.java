package ups.edu.ups.sol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SOL_SOLICITUD", schema = "SOL")
public class SolSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SOL_CODIGO")
    private Long solCodigo;
    @Basic(optional = false)
    @Column(name = "EST_CODIGO")
    private long estCodigo;
    @Column(name = "SOL_ASUNTO")
    private String solAsunto;
    @Basic(optional = false)
    @Lob
    @Column(name = "SOL_CONTENIDO")
    private String solContenido;
    @Basic(optional = false)
    @Column(name = "SOL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solFecha;
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
    @Column(name = "SOL_FECHA_ENTREGA_ADJUNTOS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solFechaEntregaAdjuntos;
    @Column(name = "SOL_NUMERO_SOLICITUD")
    private String solNumeroSolicitud;
    @Column(name = "SOL_FECHA_PRESENTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solFechaPresentacion;
    @Column(name = "SOL_NUMERO_LEG")
    private Long solNumeroLeg;
    @Column(name = "TIS_CODIGO_LEG")
    private Long tisCodigoLeg;
    @Column(name = "PEL_CODIGO_CREACION")
    private Long pelCodigoCreacion;
    @Column(name = "PEL_CODIGO_VALIDO")
    private Long pelCodigoValido;
    @Basic(optional = false)
    @Column(name = "SOL_CONSEJO")
    private String solConsejo;
    @JoinColumn(name = "TIS_CODIGO", referencedColumnName = "TIS_CODIGO")
    @ManyToOne(optional = false)
    private SolTipoSolicitud tisCodigo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "solCodigo")
    private List<SolSolicitudEvento> solSolicitudEventos;


    public SolSolicitud() {
    }

    public SolSolicitud(Long solCodigo) {
        this.solCodigo = solCodigo;
    }

    public SolSolicitud(Long solCodigo, long estCodigo, String solContenido, Date solFecha, String audEliminado, String audAdicionado, Date audFechaAdicion, String solConsejo) {
        this.solCodigo = solCodigo;
        this.estCodigo = estCodigo;
        this.solContenido = solContenido;
        this.solFecha = solFecha;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.solConsejo = solConsejo;
    }

    public Long getSolCodigo() {
        return solCodigo;
    }

    public void setSolCodigo(Long solCodigo) {
        this.solCodigo = solCodigo;
    }

    public long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public String getSolAsunto() {
        return solAsunto;
    }

    public void setSolAsunto(String solAsunto) {
        this.solAsunto = solAsunto;
    }

    public String getSolContenido() {
        return solContenido;
    }

    public void setSolContenido(String solContenido) {
        this.solContenido = solContenido;
    }

    public Date getSolFecha() {
        return solFecha;
    }

    public void setSolFecha(Date solFecha) {
        this.solFecha = solFecha;
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

    public Date getSolFechaEntregaAdjuntos() {
        return solFechaEntregaAdjuntos;
    }

    public void setSolFechaEntregaAdjuntos(Date solFechaEntregaAdjuntos) {
        this.solFechaEntregaAdjuntos = solFechaEntregaAdjuntos;
    }

    public String getSolNumeroSolicitud() {
        return solNumeroSolicitud;
    }

    public void setSolNumeroSolicitud(String solNumeroSolicitud) {
        this.solNumeroSolicitud = solNumeroSolicitud;
    }

    public Date getSolFechaPresentacion() {
        return solFechaPresentacion;
    }

    public void setSolFechaPresentacion(Date solFechaPresentacion) {
        this.solFechaPresentacion = solFechaPresentacion;
    }

    public Long getSolNumeroLeg() {
        return solNumeroLeg;
    }

    public void setSolNumeroLeg(Long solNumeroLeg) {
        this.solNumeroLeg = solNumeroLeg;
    }

    public Long getTisCodigoLeg() {
        return tisCodigoLeg;
    }

    public void setTisCodigoLeg(Long tisCodigoLeg) {
        this.tisCodigoLeg = tisCodigoLeg;
    }

    public Long getPelCodigoCreacion() {
        return pelCodigoCreacion;
    }

    public void setPelCodigoCreacion(Long pelCodigoCreacion) {
        this.pelCodigoCreacion = pelCodigoCreacion;
    }

    public Long getPelCodigoValido() {
        return pelCodigoValido;
    }

    public void setPelCodigoValido(Long pelCodigoValido) {
        this.pelCodigoValido = pelCodigoValido;
    }

    public String getSolConsejo() {
        return solConsejo;
    }

    public void setSolConsejo(String solConsejo) {
        this.solConsejo = solConsejo;
    }

    public SolTipoSolicitud getTisCodigo() {
        return tisCodigo;
    }

    public void setTisCodigo(SolTipoSolicitud tisCodigo) {
        this.tisCodigo = tisCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solCodigo != null ? solCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolSolicitud)) {
            return false;
        }
        SolSolicitud other = (SolSolicitud) object;
        if ((this.solCodigo == null && other.solCodigo != null) || (this.solCodigo != null && !this.solCodigo.equals(other.solCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject7.SolSolicitud[ solCodigo=" + solCodigo + " ]";
    }
}
