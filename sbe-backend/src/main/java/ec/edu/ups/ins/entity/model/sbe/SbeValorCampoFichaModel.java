package ec.edu.ups.ins.entity.model.sbe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeValorCampoFichaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_VALOR_CAMPO_FICHA", schema = "SBE")
public class SbeValorCampoFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VCF_CODIGO")
    private Long vcfCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO_INICIO")
    private Long pelCodigoInicio;
    @Column(name = "VCF_TEXTO")
    private String vcfTexto;
    @Column(name = "VCF_ENTERO")
    private Long vcfEntero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VCF_DECIMAL")
    private BigDecimal vcfDecimal;
    @Column(name = "VCF_FECHA")
    private LocalDateTime vcfFecha;
    @Basic(optional = false)
    @Column(name = "VCF_FECHA_INGRESO")
    private LocalDateTime vcfFechaIngreso;
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

    //@JoinColumn(name = "CAF_CODIGO", referencedColumnName = "CAF_CODIGO")
    //@JsonIgnore
    //@ManyToOne(optional = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "CAF_CODIGO", referencedColumnName = "CAF_CODIGO")
    private SbeCampoFichaModel sbeCampoFichaModel;
    //@JoinColumn(name = "FIS_CODIGO", referencedColumnName = "FIS_CODIGO")
    //@JsonIgnore
    //@ManyToOne(optional = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FIS_CODIGO", referencedColumnName = "FIS_CODIGO")
    private SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel;

    public SbeValorCampoFichaModel() {
    }
    public SbeValorCampoFichaModel(Long vcfCodigo) {
        this.vcfCodigo = vcfCodigo;
    }
    //Update
    public SbeValorCampoFichaModel(Long vcfCodigo, Long pelCodigoInicio, String vcfTexto,
                                   Long vcfEntero, BigDecimal vcfDecimal,
                                   LocalDateTime vcfFecha, LocalDateTime vcfFechaIngreso,
                                   SbeCampoFichaModel sbeCampoFichaModel,
                                   SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel) {
        this.vcfCodigo = vcfCodigo;
        this.pelCodigoInicio = pelCodigoInicio;
        this.vcfTexto = vcfTexto;
        this.vcfEntero = vcfEntero;
        this.vcfDecimal = vcfDecimal;
        this.vcfFecha = vcfFecha;
        this.vcfFechaIngreso = vcfFechaIngreso;
        this.sbeCampoFichaModel = sbeCampoFichaModel;
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
    }

    public SbeValorCampoFichaModel(SbeValorCampoFichaDTO dto) {
        this.vcfCodigo = dto.codigo();
        this.pelCodigoInicio = dto.pelCodigoInicio();
        this.vcfTexto = dto.vcfTexto();
        this.vcfEntero = dto.vcfEntero();
        this.vcfDecimal = dto.vcfDecimal();
        this.vcfFecha = dto.vcfFecha();
        this.vcfFechaIngreso = dto.fechaIngreso();
        this.sbeCampoFichaModel = new SbeCampoFichaModel(dto.sbeCampoFichaDTO().codigo());
        this.sbeFichaSocioeconomicaModel = new SbeFichaSocioeconomicaModel(dto.sbeFichaSocioeconomicaDTO().fisCodigo());
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

    public Long getVcfCodigo() {
        return vcfCodigo;
    }

    public void setVcfCodigo(Long vcfCodigo) {
        this.vcfCodigo = vcfCodigo;
    }

    public long getPelCodigoInicio() {
        return pelCodigoInicio;
    }

    public void setPelCodigoInicio(long pelCodigoInicio) {
        this.pelCodigoInicio = pelCodigoInicio;
    }

    public String getVcfTexto() {
        return vcfTexto;
    }

    public void setVcfTexto(String vcfTexto) {
        this.vcfTexto = vcfTexto;
    }

    public Long getVcfEntero() {
        return vcfEntero;
    }

    public void setVcfEntero(Long vcfEntero) {
        this.vcfEntero = vcfEntero;
    }

    public BigDecimal getVcfDecimal() {
        return vcfDecimal;
    }

    public void setVcfDecimal(BigDecimal vcfDecimal) {
        this.vcfDecimal = vcfDecimal;
    }

    public void setPelCodigoInicio(Long pelCodigoInicio) {
        this.pelCodigoInicio = pelCodigoInicio;
    }

    public LocalDateTime getVcfFecha() {
        return vcfFecha;
    }

    public void setVcfFecha(LocalDateTime vcfFecha) {
        this.vcfFecha = vcfFecha;
    }

    public LocalDateTime getVcfFechaIngreso() {
        return vcfFechaIngreso;
    }

    public void setVcfFechaIngreso(LocalDateTime vcfFechaIngreso) {
        this.vcfFechaIngreso = vcfFechaIngreso;
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

    public SbeCampoFichaModel getSbeCampoFichaModel() {
        return sbeCampoFichaModel;
    }

    public void setSbeCampoFichaModel(SbeCampoFichaModel sbeCampoFichaModel) {
        this.sbeCampoFichaModel = sbeCampoFichaModel;
    }

    public SbeFichaSocioeconomicaModel getSbeFichaSocioeconomicaModel() {
        return sbeFichaSocioeconomicaModel;
    }

    public void setSbeFichaSocioeconomicaModel(SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel) {
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
    }
}
