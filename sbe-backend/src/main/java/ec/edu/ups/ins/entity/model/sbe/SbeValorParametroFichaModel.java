/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeValorParametroFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_VALOR_PARAMETRO_FICHA", schema = "SBE")
public class SbeValorParametroFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "VPF_CODIGO")
    private Long vpfCodigo;
    @Column(name = "PEL_CODIGO_INICIO")
    private Long pelCodigoInicio;
    @Column(name = "VPF_FECHA_INGRESO")
    private LocalDateTime vpfFechaIngreso;
    @Column(name = "VPF_PUNTOS")
    private Double vpfPuntos;
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;

    @Column(name = "AUD_FECHA_ADICION")
    private LocalDateTime audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    private LocalDateTime audFechaModificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FIS_CODIGO", referencedColumnName = "FIS_CODIGO")
    private SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "OPF_CODIGO", referencedColumnName = "OPF_CODIGO")
    private SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel;

    public SbeValorParametroFichaModel() {
    }

    public SbeValorParametroFichaModel(Long vpfCodigo) {
        this.vpfCodigo = vpfCodigo;
    }

    public SbeValorParametroFichaModel(Long vpfCodigo, Long pelCodigoInicio,
                                       LocalDateTime vpfFechaIngreso, Double vpfPuntos,
                                       SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel,
                                       SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel) {
        this.vpfCodigo = vpfCodigo;
        this.pelCodigoInicio = pelCodigoInicio;
        this.vpfFechaIngreso = vpfFechaIngreso;
        this.vpfPuntos = vpfPuntos;
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
        this.sbeOpcionParametroFichaModel = sbeOpcionParametroFichaModel;
    }

    public SbeValorParametroFichaModel(SbeValorParametroFichaDTO dto) {
        this.vpfCodigo = dto.codigo();
        this.pelCodigoInicio = dto.pelCodigoInicio();
        this.vpfFechaIngreso = dto.fechaIngreso();
        this.vpfPuntos = dto.puntos();
        this.sbeFichaSocioeconomicaModel = new SbeFichaSocioeconomicaModel(dto.sbeFichaSocioeconomicaDTO().fisCodigo());
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

    public Long getVpfCodigo() {
        return vpfCodigo;
    }

    public void setVpfCodigo(Long vpfCodigo) {
        this.vpfCodigo = vpfCodigo;
    }

    public Long getPelCodigoInicio() {
        return pelCodigoInicio;
    }

    public void setPelCodigoInicio(Long pelCodigoInicio) {
        this.pelCodigoInicio = pelCodigoInicio;
    }

    public LocalDateTime getVpfFechaIngreso() {
        return vpfFechaIngreso;
    }

    public void setVpfFechaIngreso(LocalDateTime vpfFechaIngreso) {
        this.vpfFechaIngreso = vpfFechaIngreso;
    }

    public Double getVpfPuntos() {
        return vpfPuntos;
    }

    public void setVpfPuntos(Double vpfPuntos) {
        this.vpfPuntos = vpfPuntos;
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

    public SbeFichaSocioeconomicaModel getSbeFichaSocioeconomicaModel() {
        return sbeFichaSocioeconomicaModel;
    }

    public void setSbeFichaSocioeconomicaModel(SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel) {
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
    }

    public SbeOpcionParametroFichaModel getSbeOpcionParametroFichaModel() {
        return sbeOpcionParametroFichaModel;
    }

    public void setSbeOpcionParametroFichaModel(SbeOpcionParametroFichaModel sbeOpcionParametroFichaModel) {
        this.sbeOpcionParametroFichaModel = sbeOpcionParametroFichaModel;
    }
}
