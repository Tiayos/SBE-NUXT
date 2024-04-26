package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbePuntosParametroFichaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SBE_PUNTOS_PARAMETRO_FICHA", schema = "SBE")
public class SbePuntosParametroFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PPF_CODIGO")
    private Long ppfCodigo;
    @Basic(optional = false)
    @Column(name = "PPF_PUNTOS")
    private BigDecimal ppfPuntos;
    @Basic(optional = false)
    @Column(name = "PPF_FECHA_INICIO_VIGENCIA")
    private LocalDateTime ppfFechaInicioVigencia;
    @Column(name = "PPF_FECHA_FIN_VIGENCIA")
    private LocalDateTime ppfFechaFinVigencia;
    @Basic(optional = false)
    @Column(name = "PPF_VIGENTE")
    private String ppfVigente;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "OPF_CODIGO", referencedColumnName = "OPF_CODIGO")
    private SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel;

    public SbePuntosParametroFichaModel() {
    }

    public SbePuntosParametroFichaModel(Long ppfCodigo) {
        this.ppfCodigo = ppfCodigo;
    }

    public SbePuntosParametroFichaModel(Long ppfCodigo, BigDecimal ppfPuntos, LocalDateTime ppfFechaInicioVigencia,
                                        LocalDateTime ppfFechaFinVigencia, String ppfVigente,
                                        SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel) {
        this.ppfCodigo = ppfCodigo;
        this.ppfPuntos = ppfPuntos;
        this.ppfFechaInicioVigencia = ppfFechaInicioVigencia;
        this.ppfFechaFinVigencia = ppfFechaFinVigencia;
        this.ppfVigente = ppfVigente;
        this.sbeOpcionParametroFichaModel = sbeOpcionParametroFichaModel;
    }

    public SbePuntosParametroFichaModel(SbePuntosParametroFichaDTO dto) {
        this.ppfCodigo = dto.codigo();
        this.ppfPuntos = dto.puntos();
        this.ppfFechaInicioVigencia = dto.fechaInicioVigencia();
        this.ppfFechaFinVigencia = dto.fechaFinVigencia();
        this.ppfVigente = dto.vigente();
        this.sbeOpcionParametroFichaModel = new SbeOpcionParametroFichaModel(dto.sbeOpcionParametroFichaDTO().codigo());
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

    public Long getPpfCodigo() {
        return ppfCodigo;
    }

    public void setPpfCodigo(Long ppfCodigo) {
        this.ppfCodigo = ppfCodigo;
    }

    public BigDecimal getPpfPuntos() {
        return ppfPuntos;
    }

    public void setPpfPuntos(BigDecimal ppfPuntos) {
        this.ppfPuntos = ppfPuntos;
    }

    public String getPpfVigente() {
        return ppfVigente;
    }

    public void setPpfVigente(String ppfVigente) {
        this.ppfVigente = ppfVigente;
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

    public LocalDateTime getPpfFechaInicioVigencia() {
        return ppfFechaInicioVigencia;
    }

    public void setPpfFechaInicioVigencia(LocalDateTime ppfFechaInicioVigencia) {
        this.ppfFechaInicioVigencia = ppfFechaInicioVigencia;
    }

    public LocalDateTime getPpfFechaFinVigencia() {
        return ppfFechaFinVigencia;
    }

    public void setPpfFechaFinVigencia(LocalDateTime ppfFechaFinVigencia) {
        this.ppfFechaFinVigencia = ppfFechaFinVigencia;
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

    public SbeOpcionParametroFichaModel getSbeOpcionParametroFichaModel() {
        return sbeOpcionParametroFichaModel;
    }

    public void setSbeOpcionParametroFichaModel(SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel) {
        this.sbeOpcionParametroFichaModel = sbeOpcionParametroFichaModel;
    }
}
