package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeValoracionFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_VALORACION_FICHA", schema = "SBE")
@NamedStoredProcedureQuery(name = "procedureValoracionFicha",
        procedureName = "SBE.P_ACT_VALORACION_FICHA_5",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_fis_codigo", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_pel_codigo", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_usuario", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "periodo", type = Integer.class)
        })
public class SbeValoracionFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VAF_CODIGO")
    private Long vafCodigo;
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Basic(optional = false)
    @Column(name = "VAF_VALORACION")
    private Double vafValoracion;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO_FIN")
    private Long pelCodigoFin;
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
    @JoinColumn(name = "RAF_CODIGO", referencedColumnName = "RAF_CODIGO")
    private SbeRangoFichaModel sbeRangoFichaModel;

    public SbeValoracionFichaModel() {
    }

    public SbeValoracionFichaModel(Long vafCodigo) {
        this.vafCodigo = vafCodigo;
    }

    public SbeValoracionFichaModel(Long vafCodigo, Long fisCodigo,
                                   Long pelCodigo, Double vafValoracion,
                                   Long pelCodigoFin, SbeRangoFichaModel sbeRangoFichaModel) {
        this.vafCodigo = vafCodigo;
        this.fisCodigo = fisCodigo;
        this.pelCodigo = pelCodigo;
        this.vafValoracion = vafValoracion;
        this.pelCodigoFin = pelCodigoFin;
        this.sbeRangoFichaModel = sbeRangoFichaModel;
    }

    public SbeValoracionFichaModel(SbeValoracionFichaDTO dto) {
        this.vafCodigo = dto.codigo();
        this.fisCodigo = dto.fisCodigo();
        this.pelCodigo = dto.pelCodigo();
        this.vafValoracion = dto.valoracion();
        this.pelCodigoFin = dto.pelCodigoFin();
        this.sbeRangoFichaModel = new SbeRangoFichaModel(dto.sbeRangoFichaDTO().codigo());
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="sbermeob@ups.edu.ec";
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModificacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="sbermeob@ups.edu.ec";
    }

    public Long getVafCodigo() {
        return vafCodigo;
    }

    public void setVafCodigo(Long vafCodigo) {
        this.vafCodigo = vafCodigo;
    }

    public Long getFisCodigo() {
        return fisCodigo;
    }

    public void setFisCodigo(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public SbeRangoFichaModel getSbeRangoFicha() {
        return sbeRangoFichaModel;
    }

    public void setSbeRangoFicha(SbeRangoFichaModel sbeRangoFichaModel) {
        this.sbeRangoFichaModel = sbeRangoFichaModel;
    }

    public Double getVafValoracion() {
        return vafValoracion;
    }

    public void setVafValoracion(Double vafValoracion) {
        this.vafValoracion = vafValoracion;
    }

    public Long getPelCodigoFin() {
        return pelCodigoFin;
    }

    public void setPelCodigoFin(Long pelCodigoFin) {
        this.pelCodigoFin = pelCodigoFin;
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

    public SbeRangoFichaModel getSbeRangoFichaModel() {
        return sbeRangoFichaModel;
    }

    public void setSbeRangoFichaModel(SbeRangoFichaModel sbeRangoFichaModel) {
        this.sbeRangoFichaModel = sbeRangoFichaModel;
    }

}
