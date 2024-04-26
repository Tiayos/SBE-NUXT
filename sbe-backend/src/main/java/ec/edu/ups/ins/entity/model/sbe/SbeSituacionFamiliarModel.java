package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.*;
import ec.edu.ups.ins.entity.dto.SbeSituacionFamiliarDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_SITUACION_FAMILIAR", schema = "SBE")
public class SbeSituacionFamiliarModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SIF_CODIGO")
    private Long sifCodigo;
    @Basic(optional = false)
    @Column(name = "SIF_NOMBRE_FAMILIAR")
    private String sifNombreFamiliar;
    @Basic(optional = false)
    @Column(name = "SIF_FECHA_NACIMIENTO")
    private LocalDateTime sifFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "SIF_TIPO_SITUACION")
    private String sifTipoSituacion;

    @Column(name = "SIF_NUMERO_IDENTIFICACION")
    private String sifNumeroIdentificacion;
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
    @Column(name = "SFI_INGRESOS_MENSUALES")
    private BigDecimal sfiIngresosMensuales;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "ESC_CODIGO", referencedColumnName = "ESC_CODIGO")
    private SbeEstadoCivilModel sbeEstadoCivilModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "FIS_CODIGO", referencedColumnName = "FIS_CODIGO")
    private SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO")
    private SbeInstruccionModel sbeInstruccionModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO")
    private SbeParentescoModel sbeParentescoModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "TEM_CODIGO", referencedColumnName = "TEM_CODIGO")
    private SbeTipoEmpresaModel sbeTipoEmpresaModel;

    public SbeSituacionFamiliarModel() {
    }

    public SbeSituacionFamiliarModel(Long sifCodigo) {
        this.sifCodigo = sifCodigo;
    }

    public SbeSituacionFamiliarModel(Long sifCodigo, String sifNombreFamiliar,
                                     LocalDateTime sifFechaNacimiento, String sifTipoSituacion,
                                     String sifNumeroIdentificacion, BigDecimal sfiIngresosMensuales,
                                     SbeEstadoCivilModel sbeEstadoCivilModel, SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel,
                                     SbeInstruccionModel sbeInstruccionModel, SbeParentescoModel sbeParentescoModel,
                                     SbeTipoEmpresaModel sbeTipoEmpresaModel) {
        this.sifCodigo = sifCodigo;
        this.sifNombreFamiliar = sifNombreFamiliar;
        this.sifFechaNacimiento = sifFechaNacimiento;
        this.sifTipoSituacion = sifTipoSituacion;
        this.sifNumeroIdentificacion = sifNumeroIdentificacion;
        this.sfiIngresosMensuales = sfiIngresosMensuales;
        this.sbeEstadoCivilModel = sbeEstadoCivilModel;
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
        this.sbeInstruccionModel = sbeInstruccionModel;
        this.sbeParentescoModel = sbeParentescoModel;
        this.sbeTipoEmpresaModel = sbeTipoEmpresaModel;
    }

    public SbeSituacionFamiliarModel(SbeSituacionFamiliarDTO dto) {
        this.sifCodigo = dto.codigo();
        this.sifNombreFamiliar = dto.nombreFamiliar();
        this.sifFechaNacimiento = dto.fechaNacimiento();
        this.sifTipoSituacion = dto.tipoSituacion();
        this.sifNumeroIdentificacion = dto.numeroIdentificacion();
        this.sfiIngresosMensuales = dto.ingresosMensuales();
        this.sbeEstadoCivilModel = new SbeEstadoCivilModel(dto.sbeEstadoCivilDTO().codigo());
        this.sbeFichaSocioeconomicaModel = new SbeFichaSocioeconomicaModel(dto.sbeFichaSocioeconomicaDTO().fisCodigo());
        this.sbeInstruccionModel = new SbeInstruccionModel(dto.sbeInstruccionDTO().codigo());
        this.sbeParentescoModel = new SbeParentescoModel(dto.sbeParentescoDTO().codigo());
        this.sbeTipoEmpresaModel = new SbeTipoEmpresaModel(dto.sbeTipoEmpresaDTO().codigo());
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="sbermeob@ups.edu.ec";
        this.sifNombreFamiliar = sifNombreFamiliar.toUpperCase();
        this.sifTipoSituacion = sifTipoSituacion.toUpperCase();
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModificacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="sbermeob@ups.edu.ec";
        this.sifNombreFamiliar = sifNombreFamiliar.toUpperCase();
        this.sifTipoSituacion = sifTipoSituacion.toUpperCase();
    }

    public Long getSifCodigo() {
        return sifCodigo;
    }

    public void setSifCodigo(Long sifCodigo) {
        this.sifCodigo = sifCodigo;
    }

    public String getSifNombreFamiliar() {
        return sifNombreFamiliar;
    }

    public void setSifNombreFamiliar(String sifNombreFamiliar) {
        this.sifNombreFamiliar = sifNombreFamiliar;
    }

    public LocalDateTime getSifFechaNacimiento() {
        return sifFechaNacimiento;
    }

    public void setSifFechaNacimiento(LocalDateTime sifFechaNacimiento) {
        this.sifFechaNacimiento = sifFechaNacimiento;
    }

    public String getSifTipoSituacion() {
        return sifTipoSituacion;
    }

    public void setSifTipoSituacion(String sifTipoSituacion) {
        this.sifTipoSituacion = sifTipoSituacion;
    }

    public String getSifNumeroIdentificacion() {
        return sifNumeroIdentificacion;
    }

    public void setSifNumeroIdentificacion(String sifNumeroIdentificacion) {
        this.sifNumeroIdentificacion = sifNumeroIdentificacion;
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

    public BigDecimal getSfiIngresosMensuales() {
        return sfiIngresosMensuales;
    }

    public void setSfiIngresosMensuales(BigDecimal sfiIngresosMensuales) {
        this.sfiIngresosMensuales = sfiIngresosMensuales;
    }

    public SbeEstadoCivilModel getSbeEstadoCivilModel() {
        return sbeEstadoCivilModel;
    }

    public void setSbeEstadoCivilModel(SbeEstadoCivilModel sbeEstadoCivilModel) {
        this.sbeEstadoCivilModel = sbeEstadoCivilModel;
    }

    public SbeFichaSocioeconomicaModel getSbeFichaSocioeconomicaModel() {
        return sbeFichaSocioeconomicaModel;
    }

    public void setSbeFichaSocioeconomicaModel(SbeFichaSocioeconomicaModel sbeFichaSocioeconomicaModel) {
        this.sbeFichaSocioeconomicaModel = sbeFichaSocioeconomicaModel;
    }

    public SbeInstruccionModel getSbeInstruccionModel() {
        return sbeInstruccionModel;
    }

    public void setSbeInstruccionModel(SbeInstruccionModel sbeInstruccionModel) {
        this.sbeInstruccionModel = sbeInstruccionModel;
    }

    public SbeParentescoModel getSbeParentescoModel() {
        return sbeParentescoModel;
    }

    public void setSbeParentescoModel(SbeParentescoModel sbeParentescoModel) {
        this.sbeParentescoModel = sbeParentescoModel;
    }

    public SbeTipoEmpresaModel getSbeTipoEmpresaModel() {
        return sbeTipoEmpresaModel;
    }

    public void setSbeTipoEmpresaModel(SbeTipoEmpresaModel sbeTipoEmpresaModel) {
        this.sbeTipoEmpresaModel = sbeTipoEmpresaModel;
    }
}
