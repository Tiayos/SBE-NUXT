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
@Table(name = "SOL_TIPO_SOLICITUD", schema = "SOL")
public class SolTipoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIS_CODIGO")
    private Long tisCodigo;
    @Basic(optional = false)
    @Column(name = "TIS_DESCRIPCION")
    private String tisDescripcion;
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
    @Column(name = "TIS_CODIGO_PROCEDIMIENTO")
    private String tisCodigoProcedimiento;
    @Column(name = "TIS_TIPO_RECEPCION")
    private String tisTipoRecepcion;
    @Column(name = "TIS_TIENE_COMPROBANTE")
    private String tisTieneComprobante;
    @Column(name = "TIS_TIENE_ADJUNTO")
    private String tisTieneAdjunto;
    @Lob
    @Column(name = "TIS_DETALLE_ADJUNTOS")
    private String tisDetalleAdjuntos;
    @Column(name = "TIS_PLANTILLA")
    private String tisPlantilla;
    @Column(name = "TIS_FECHA_RECEPCION")
    private String tisFechaRecepcion;
    @Lob
    @Column(name = "TIS_RESTRICCIONES")
    private String tisRestricciones;
    @Lob
    @Column(name = "TIS_DETALLE_DERECHO")
    private String tisDetalleDerecho;
    @Column(name = "TIS_PLANTILLA_PDF")
    private String tisPlantillaPdf;
    @Column(name = "TIS_CLASIFICACION")
    private String tisClasificacion;
    @Basic(optional = false)
    @Column(name = "TIS_FECHA_INICIO_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tisFechaInicioVigencia;
    @Basic(optional = false)
    @Column(name = "TIS_FECHA_FIN_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tisFechaFinVigencia;
    @Column(name = "TIS_CODIGO_LEG")
    private Long tisCodigoLeg;

    public SolTipoSolicitud() {
    }

    public SolTipoSolicitud(Long tisCodigo) {
        this.tisCodigo = tisCodigo;
    }

    public SolTipoSolicitud(Long tisCodigo, String tisDescripcion, String audEliminado, String audAdicionado, Date audFechaAdicion, String tisCodigoProcedimiento, Date tisFechaInicioVigencia, Date tisFechaFinVigencia) {
        this.tisCodigo = tisCodigo;
        this.tisDescripcion = tisDescripcion;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.tisCodigoProcedimiento = tisCodigoProcedimiento;
        this.tisFechaInicioVigencia = tisFechaInicioVigencia;
        this.tisFechaFinVigencia = tisFechaFinVigencia;
    }

    public Long getTisCodigo() {
        return tisCodigo;
    }

    public void setTisCodigo(Long tisCodigo) {
        this.tisCodigo = tisCodigo;
    }

    public String getTisDescripcion() {
        return tisDescripcion;
    }

    public void setTisDescripcion(String tisDescripcion) {
        this.tisDescripcion = tisDescripcion;
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

    public String getTisCodigoProcedimiento() {
        return tisCodigoProcedimiento;
    }

    public void setTisCodigoProcedimiento(String tisCodigoProcedimiento) {
        this.tisCodigoProcedimiento = tisCodigoProcedimiento;
    }

    public String getTisTipoRecepcion() {
        return tisTipoRecepcion;
    }

    public void setTisTipoRecepcion(String tisTipoRecepcion) {
        this.tisTipoRecepcion = tisTipoRecepcion;
    }

    public String getTisTieneComprobante() {
        return tisTieneComprobante;
    }

    public void setTisTieneComprobante(String tisTieneComprobante) {
        this.tisTieneComprobante = tisTieneComprobante;
    }

    public String getTisTieneAdjunto() {
        return tisTieneAdjunto;
    }

    public void setTisTieneAdjunto(String tisTieneAdjunto) {
        this.tisTieneAdjunto = tisTieneAdjunto;
    }

    public String getTisDetalleAdjuntos() {
        return tisDetalleAdjuntos;
    }

    public void setTisDetalleAdjuntos(String tisDetalleAdjuntos) {
        this.tisDetalleAdjuntos = tisDetalleAdjuntos;
    }

    public String getTisPlantilla() {
        return tisPlantilla;
    }

    public void setTisPlantilla(String tisPlantilla) {
        this.tisPlantilla = tisPlantilla;
    }

    public String getTisFechaRecepcion() {
        return tisFechaRecepcion;
    }

    public void setTisFechaRecepcion(String tisFechaRecepcion) {
        this.tisFechaRecepcion = tisFechaRecepcion;
    }

    public String getTisRestricciones() {
        return tisRestricciones;
    }

    public void setTisRestricciones(String tisRestricciones) {
        this.tisRestricciones = tisRestricciones;
    }

    public String getTisDetalleDerecho() {
        return tisDetalleDerecho;
    }

    public void setTisDetalleDerecho(String tisDetalleDerecho) {
        this.tisDetalleDerecho = tisDetalleDerecho;
    }

    public String getTisPlantillaPdf() {
        return tisPlantillaPdf;
    }

    public void setTisPlantillaPdf(String tisPlantillaPdf) {
        this.tisPlantillaPdf = tisPlantillaPdf;
    }

    public String getTisClasificacion() {
        return tisClasificacion;
    }

    public void setTisClasificacion(String tisClasificacion) {
        this.tisClasificacion = tisClasificacion;
    }

    public Date getTisFechaInicioVigencia() {
        return tisFechaInicioVigencia;
    }

    public void setTisFechaInicioVigencia(Date tisFechaInicioVigencia) {
        this.tisFechaInicioVigencia = tisFechaInicioVigencia;
    }

    public Date getTisFechaFinVigencia() {
        return tisFechaFinVigencia;
    }

    public void setTisFechaFinVigencia(Date tisFechaFinVigencia) {
        this.tisFechaFinVigencia = tisFechaFinVigencia;
    }

    public Long getTisCodigoLeg() {
        return tisCodigoLeg;
    }

    public void setTisCodigoLeg(Long tisCodigoLeg) {
        this.tisCodigoLeg = tisCodigoLeg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tisCodigo != null ? tisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolTipoSolicitud)) {
            return false;
        }
        SolTipoSolicitud other = (SolTipoSolicitud) object;
        if ((this.tisCodigo == null && other.tisCodigo != null) || (this.tisCodigo != null && !this.tisCodigo.equals(other.tisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject5.SolTipoSolicitud[ tisCodigo=" + tisCodigo + " ]";
    }
    
}
