package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeParametroFichaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_PARAMETRO_FICHA", schema = "SBE")
public class SbeParametroFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PAF_CODIGO")
    private Long pafCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "TPF_CODIGO", referencedColumnName = "TPF_CODIGO")
    private SbeTipoParametroFichaModel sbeTipoParametroFichaModel;

    @Column(name = "PAF_DESCRIPCION")
    private String pafDescripcion;
    @Column(name = "PAF_VIGENTE")
    private String pafVigente;
    @Column(name = "PAF_ETIQUETA_MOSTRAR")
    private String pafEtiquetaMostrar;

    @Column(name = "PAF_ORDEN")
    private Integer pafOrden;
    @Basic(optional = false)
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "AUD_FECHA_ADICION")
    private LocalDateTime audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    private LocalDateTime audFechaModificacion;

    public SbeParametroFichaModel() {
    }

    public SbeParametroFichaModel(Long pafCodigo) {
        this.pafCodigo = pafCodigo;
    }

    public SbeParametroFichaModel(Long pafCodigo, SbeTipoParametroFichaModel sbeTipoParametroFichaModel,
                                  String pafDescripcion, String pafVigente, String pafEtiquetaMostrar,
                                  Integer pafOrden) {
        this.pafCodigo = pafCodigo;
        this.sbeTipoParametroFichaModel = sbeTipoParametroFichaModel;
        this.pafDescripcion = pafDescripcion;
        this.pafVigente = pafVigente;
        this.pafEtiquetaMostrar = pafEtiquetaMostrar;
        this.pafOrden = pafOrden;
    }

    public SbeParametroFichaModel(SbeParametroFichaDTO dto) {
        this.pafCodigo = dto.codigo();
        this.sbeTipoParametroFichaModel = new SbeTipoParametroFichaModel(dto.sbeTipoParametroFichaDTO().codigo());
        this.pafDescripcion = dto.descripcion();
        this.pafVigente = dto.vigente();
        this.pafEtiquetaMostrar = dto.pafEtiquetaMostrar();
        this.pafOrden = dto.orden();
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="SBE";
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModificacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="SBE";
    }

    public Long getPafCodigo() {
        return pafCodigo;
    }

    public void setPafCodigo(Long pafCodigo) {
        this.pafCodigo = pafCodigo;
    }

    public SbeTipoParametroFichaModel getSbeTipoParametroFicha() {
        return sbeTipoParametroFichaModel;
    }

    public void setSbeTipoParametroFicha(SbeTipoParametroFichaModel sbeTipoParametroFichaModel) {
        this.sbeTipoParametroFichaModel = sbeTipoParametroFichaModel;
    }

    public String getPafDescripcion() {
        return pafDescripcion;
    }

    public void setPafDescripcion(String pafDescripcion) {
        this.pafDescripcion = pafDescripcion;
    }

    public String getPafVigente() {
        return pafVigente;
    }

    public void setPafVigente(String pafVigente) {
        this.pafVigente = pafVigente;
    }

    public String getPafEtiquetaMostrar() {
        return pafEtiquetaMostrar;
    }

    public void setPafEtiquetaMostrar(String pafEtiquetaMostrar) {
        this.pafEtiquetaMostrar = pafEtiquetaMostrar;
    }

    public Integer getPafOrden() {
        return pafOrden;
    }

    public void setPafOrden(Integer pafOrden) {
        this.pafOrden = pafOrden;
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

    public SbeTipoParametroFichaModel getSbeTipoParametroFichaModel() {
        return sbeTipoParametroFichaModel;
    }

    public void setSbeTipoParametroFichaModel(SbeTipoParametroFichaModel sbeTipoParametroFichaModel) {
        this.sbeTipoParametroFichaModel = sbeTipoParametroFichaModel;
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
}
