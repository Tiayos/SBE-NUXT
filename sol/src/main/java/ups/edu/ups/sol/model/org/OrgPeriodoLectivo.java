package ups.edu.ups.sol.model.org;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "ORG_PERIODO_LECTIVO", schema = "ORG")
public class OrgPeriodoLectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_DESCRIPCION")
    private String pelDescripcion;
    @Basic(optional = false)
    @Column(name = "PEL_ABIERTO")
    private String pelAbierto;
    @Basic(optional = false)
    @Column(name = "PEL_VIGENTE")
    private String pelVigente;
    @Column(name = "PEL_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pelFechaInicio;
    @Column(name = "PEL_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pelFechaFin;
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
    @Basic(optional = false)
    @Column(name = "PEL_TIPO")
    private String pelTipo;
    @Basic(optional = false)
    @Column(name = "PEL_CODIFICACION")
    private String pelCodificacion;
    @Column(name = "PEL_CODIGO_LEG")
    private Long pelCodigoLeg;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO_REFERENCIA")
    private long pelCodigoReferencia;
    @Column(name = "PEL_DESCRIPCION_VISUAL")
    private String pelDescripcionVisual;
    @Basic(optional = false)
    @Column(name = "PEL_SUB_PERIODO")
    private String pelSubPeriodo;

    public OrgPeriodoLectivo() {
    }

    public OrgPeriodoLectivo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public OrgPeriodoLectivo(Long pelCodigo, String pelDescripcion, String pelAbierto, String pelVigente, String audEliminado, String audAdicionado, Date audFechaAdicion, String pelTipo, String pelCodificacion, long pelCodigoReferencia, String pelSubPeriodo) {
        this.pelCodigo = pelCodigo;
        this.pelDescripcion = pelDescripcion;
        this.pelAbierto = pelAbierto;
        this.pelVigente = pelVigente;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.pelTipo = pelTipo;
        this.pelCodificacion = pelCodificacion;
        this.pelCodigoReferencia = pelCodigoReferencia;
        this.pelSubPeriodo = pelSubPeriodo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public String getPelDescripcion() {
        return pelDescripcion;
    }

    public void setPelDescripcion(String pelDescripcion) {
        this.pelDescripcion = pelDescripcion;
    }

    public String getPelAbierto() {
        return pelAbierto;
    }

    public void setPelAbierto(String pelAbierto) {
        this.pelAbierto = pelAbierto;
    }

    public String getPelVigente() {
        return pelVigente;
    }

    public void setPelVigente(String pelVigente) {
        this.pelVigente = pelVigente;
    }

    public Date getPelFechaInicio() {
        return pelFechaInicio;
    }

    public void setPelFechaInicio(Date pelFechaInicio) {
        this.pelFechaInicio = pelFechaInicio;
    }

    public Date getPelFechaFin() {
        return pelFechaFin;
    }

    public void setPelFechaFin(Date pelFechaFin) {
        this.pelFechaFin = pelFechaFin;
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

    public String getPelTipo() {
        return pelTipo;
    }

    public void setPelTipo(String pelTipo) {
        this.pelTipo = pelTipo;
    }

    public String getPelCodificacion() {
        return pelCodificacion;
    }

    public void setPelCodificacion(String pelCodificacion) {
        this.pelCodificacion = pelCodificacion;
    }

    public Long getPelCodigoLeg() {
        return pelCodigoLeg;
    }

    public void setPelCodigoLeg(Long pelCodigoLeg) {
        this.pelCodigoLeg = pelCodigoLeg;
    }

    public long getPelCodigoReferencia() {
        return pelCodigoReferencia;
    }

    public void setPelCodigoReferencia(long pelCodigoReferencia) {
        this.pelCodigoReferencia = pelCodigoReferencia;
    }

    public String getPelDescripcionVisual() {
        return pelDescripcionVisual;
    }

    public void setPelDescripcionVisual(String pelDescripcionVisual) {
        this.pelDescripcionVisual = pelDescripcionVisual;
    }

    public String getPelSubPeriodo() {
        return pelSubPeriodo;
    }

    public void setPelSubPeriodo(String pelSubPeriodo) {
        this.pelSubPeriodo = pelSubPeriodo;
    }


}
