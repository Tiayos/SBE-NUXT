package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeFichaSocioeconomicaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_FICHA_SOCIOECONOMICA" , schema = "SBE")
public class SbeFichaSocioeconomicaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;

    @Column(name = "PEL_CODIGO")
    private long pel_codigo;
    @Basic(optional = false)
    @Column(name = "ALU_CODIGO")
    private long aluCodigo;
    @Basic(optional = false)
    @Column(name = "FIS_FECHA")
    private LocalDateTime fisFecha;
    @Basic(optional = false)
    @Column(name = "FIS_ACTUALIZAR")
    private String fisActualizar;
    @Basic(optional = false)
    @Column(name = "FIS_ESTADO")
    private String fisEstado;
    @Basic(optional = false)
    @Column(name = "FIS_VERSION")
    private short fisVersion;
    @Column(name = "FIS_FECHA_INICIO_CREACION")
    private LocalDateTime fisFechaInicioCreacion;
    @Column(name = "FIS_FECHA_FIN_CREACION")
    private LocalDateTime fisFechaFinCreacion;
    @Column(name = "EST_CODIGO")
    private Long estCodigo;

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
    private LocalDateTime audFechaModifacion;
    @Column(name = "SOL_CODIGO")
    private Long solCodigo;

    @Column(name = "PEL_CODIGO_VALIDO_INICIO")
    private long pelCodigoValidoInicio;

    @Basic(optional = false)
    @Column(name = "FIS_FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fisFechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "TFS_CODIGO", referencedColumnName = "TFS_CODIGO")
    private SbeTipoFichaSocioeconomicaModel sbeTipoFichaSocioeconomicaModel;


    public SbeFichaSocioeconomicaModel() {
    }

    public SbeFichaSocioeconomicaModel(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }


    public SbeFichaSocioeconomicaModel(Long fisCodigo, long pel_codigo, long aluCodigo,
                                       LocalDateTime fisFecha, LocalDateTime fisFechaActualizacion,
                                       long pelCodigoValidoInicio, String fisActualizar, String fisEstado,
                                       short fisVersion, LocalDateTime fisFechaInicioCreacion,
                                       LocalDateTime fisFechaFinCreacion, Long estCodigo,
                                       SbeTipoFichaSocioeconomicaModel sbeTipoFichaSocioeconomicaModel, Long solCodigo) {
        this.fisCodigo = fisCodigo;
        this.pel_codigo = pel_codigo;
        this.aluCodigo = aluCodigo;
        this.fisFecha = fisFecha;
        this.pelCodigoValidoInicio = pelCodigoValidoInicio;
        this.fisFechaActualizacion = fisFechaActualizacion;
        this.fisActualizar = fisActualizar;
        this.fisEstado = fisEstado;
        this.fisVersion = fisVersion;
        this.fisFechaInicioCreacion = fisFechaInicioCreacion;
        this.fisFechaFinCreacion = fisFechaFinCreacion;
        this.estCodigo = estCodigo;
        this.sbeTipoFichaSocioeconomicaModel = sbeTipoFichaSocioeconomicaModel;
        this.solCodigo = solCodigo;
    }

    public SbeFichaSocioeconomicaModel(SbeFichaSocioeconomicaDTO dto) {
        this.fisCodigo = dto.fisCodigo();
        this.pel_codigo = dto.pelCodigo();
        this.aluCodigo = dto.aluCodigo();
        this.fisFecha = dto.fecha();
        this.fisActualizar = dto.actualizar();
        this.fisEstado = dto.estado();
        this.fisVersion = dto.version();
        this.fisFechaInicioCreacion = dto.fisFechaInicioCreacion();
        this.fisFechaFinCreacion = dto.fisFechaFinCreacion();
        this.estCodigo = dto.estCodigo();
        this.solCodigo = dto.solCodigo();
        this.sbeTipoFichaSocioeconomicaModel = new SbeTipoFichaSocioeconomicaModel(dto.sbeTipoFichaSocioeconomicaDTO());
        this.pelCodigoValidoInicio = dto.pelCodigoValidoInicio();
    }

    public Long getSolCodigo() {
        return solCodigo;
    }

    public void setSolCodigo(Long solCodigo) {
        this.solCodigo = solCodigo;
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="sbermeob@ups.edu.ec";
        this.fisFecha=  LocalDateTime.now();
        this.fisFechaInicioCreacion =  LocalDateTime.now();
        this.fisFechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModifacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="sbermeob@ups.edu.ec";
    }

    public Long getFisCodigo() {
        return fisCodigo;
    }

    public void setFisCodigo(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }

    public long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public String getFisActualizar() {
        return fisActualizar;
    }

    public void setFisActualizar(String fisActualizar) {
        this.fisActualizar = fisActualizar;
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

    public String getFisEstado() {
        return fisEstado;
    }

    public void setFisEstado(String fisEstado) {
        this.fisEstado = fisEstado;
    }

    public short getFisVersion() {
        return fisVersion;
    }

    public void setFisVersion(short fisVersion) {
        this.fisVersion = fisVersion;
    }

    public LocalDateTime getFisFecha() {
        return fisFecha;
    }

    public void setFisFecha(LocalDateTime fisFecha) {
        this.fisFecha = fisFecha;
    }

    public LocalDateTime getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(LocalDateTime audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public LocalDateTime getFisFechaInicioCreacion() {
        return fisFechaInicioCreacion;
    }

    public void setFisFechaInicioCreacion(LocalDateTime fisFechaInicioCreacion) {
        this.fisFechaInicioCreacion = fisFechaInicioCreacion;
    }

    public LocalDateTime getFisFechaFinCreacion() {
        return fisFechaFinCreacion;
    }

    public void setFisFechaFinCreacion(LocalDateTime fisFechaFinCreacion) {
        this.fisFechaFinCreacion = fisFechaFinCreacion;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public long getPelCodigoValidoInicio() {
        return pelCodigoValidoInicio;
    }

    public void setPelCodigoValidoInicio(long pelCodigoValidoInicio) {
        this.pelCodigoValidoInicio = pelCodigoValidoInicio;
    }

    public LocalDateTime getFisFechaActualizacion() {
        return fisFechaActualizacion;
    }

    public void setFisFechaActualizacion(LocalDateTime fisFechaActualizacion) {
        this.fisFechaActualizacion = fisFechaActualizacion;
    }

    public SbeTipoFichaSocioeconomicaModel getSbeTipoFichaSocioeconomica() {
        return sbeTipoFichaSocioeconomicaModel;
    }

    public void setSbeTipoFichaSocioeconomica(SbeTipoFichaSocioeconomicaModel sbeTipoFichaSocioeconomicaModel) {
        this.sbeTipoFichaSocioeconomicaModel = sbeTipoFichaSocioeconomicaModel;
    }

    public long getPel_codigo() {
        return pel_codigo;
    }

    public void setPel_codigo(long pel_codigo) {
        this.pel_codigo = pel_codigo;
    }

    public String getAudModificado() {
        return audModificado;
    }

    public void setAudModificado(String audModificado) {
        this.audModificado = audModificado;
    }

    public LocalDateTime getAudFechaModifacion() {
        return audFechaModifacion;
    }

    public void setAudFechaModifacion(LocalDateTime audFechaModifacion) {
        this.audFechaModifacion = audFechaModifacion;
    }

    public SbeTipoFichaSocioeconomicaModel getSbeTipoFichaSocioeconomicaModel() {
        return sbeTipoFichaSocioeconomicaModel;
    }

    public void setSbeTipoFichaSocioeconomicaModel(SbeTipoFichaSocioeconomicaModel sbeTipoFichaSocioeconomicaModel) {
        this.sbeTipoFichaSocioeconomicaModel = sbeTipoFichaSocioeconomicaModel;
    }
}
