package ec.edu.ups.ins.entity.model.sbe;
import ec.edu.ups.ins.entity.dto.SbeCampoFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_CAMPO_FICHA", schema = "SBE")
public class SbeCampoFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CAF_CODIGO")
    private Long cafCodigo;
    @Basic(optional = false)
    @Column(name = "CAF_DESCRIPCION")
    private String cafDescripcion;
    @Basic(optional = false)
    @Column(name = "CAF_TIPO")
    private String cafTipo;
    @Basic(optional = false)
    @Column(name = "CAF_ETIQUETA_MOSTRAR")
    private String cafEtiquetaMostrar;

    @Basic(optional = true)
    @Column(name = "CAF_ORDEN")
    private Integer cafOrden;

    @Column(name = "AUD_ELIMINADO")
    private String eliminado;
    @Column(name = "AUD_ADICIONADO")
    private String adicionado;
    @Column(name = "AUD_FECHA_ADICION")
    private LocalDateTime fechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String modificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
    @JoinColumn(name = "TPF_CODIGO", referencedColumnName = "TPF_CODIGO")
    @ManyToOne(optional = false)
    private SbeTipoParametroFichaModel sbeTipoParametroFichaModel;


    public SbeCampoFichaModel() {
    }

    public SbeCampoFichaModel(Long cafCodigo) {
        this.cafCodigo = cafCodigo;
    }

    public SbeCampoFichaModel(Long cafCodigo, String cafDescripcion, String cafTipo,
                              String cafEtiquetaMostrar, Integer cafOrden,
                              SbeTipoParametroFichaModel sbeTipoParametroFichaModel) {
        this.cafCodigo = cafCodigo;
        this.cafDescripcion = cafDescripcion;
        this.cafTipo = cafTipo;
        this.cafEtiquetaMostrar = cafEtiquetaMostrar;
        this.cafOrden = cafOrden;
        this.sbeTipoParametroFichaModel = sbeTipoParametroFichaModel;
    }

    public SbeCampoFichaModel(SbeCampoFichaDTO dto) {
        this.cafCodigo = dto.codigo();
        this.cafDescripcion = dto.descripcion();
        this.cafTipo = dto.tipo();
        this.cafEtiquetaMostrar = dto.etiqueta();
        this.cafOrden = dto.orden();
        this.sbeTipoParametroFichaModel = new SbeTipoParametroFichaModel(dto.sbeTipoParametroFichaDTO().codigo());
    }

    @PrePersist
    public void prePersist(){
        this.fechaAdicion = LocalDateTime.now();
        this.eliminado = "N";
        this.adicionado="SBE";
    }

    @PreUpdate
    public void preUpdate(){
        this.fechaModificacion = LocalDateTime.now();
        this.eliminado = "N";
        this.modificado="SBE";
    }

    public Long getCafCodigo() {
        return cafCodigo;
    }

    public void setCafCodigo(Long cafCodigo) {
        this.cafCodigo = cafCodigo;
    }

    public String getCafDescripcion() {
        return cafDescripcion;
    }

    public void setCafDescripcion(String cafDescripcion) {
        this.cafDescripcion = cafDescripcion;
    }

    public String getCafTipo() {
        return cafTipo;
    }

    public void setCafTipo(String cafTipo) {
        this.cafTipo = cafTipo;
    }

    public String getCafEtiquetaMostrar() {
        return cafEtiquetaMostrar;
    }

    public void setCafEtiquetaMostrar(String cafEtiquetaMostrar) {
        this.cafEtiquetaMostrar = cafEtiquetaMostrar;
    }

    public Integer getCafOrden() {
        return cafOrden;
    }

    public void setCafOrden(Integer cafOrden) {
        this.cafOrden = cafOrden;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public String getAdicionado() {
        return adicionado;
    }

    public void setAdicionado(String adicionado) {
        this.adicionado = adicionado;
    }

    public LocalDateTime getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(LocalDateTime fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public SbeTipoParametroFichaModel getSbeTipoParametroFichaModel() {
        return sbeTipoParametroFichaModel;
    }

    public void setSbeTipoParametroFichaModel(SbeTipoParametroFichaModel sbeTipoParametroFichaModel) {
        this.sbeTipoParametroFichaModel = sbeTipoParametroFichaModel;
    }
}
