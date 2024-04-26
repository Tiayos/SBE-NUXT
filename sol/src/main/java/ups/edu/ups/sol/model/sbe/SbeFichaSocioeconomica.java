package ups.edu.ups.sol.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_FICHA_SOCIOECONOMICA" , schema = "SBE")
public class SbeFichaSocioeconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;
    @Column(name = "PEL_CODIGO")
    private long pelCodigo;
    @Basic(optional = false)
    @Column(name = "ALU_CODIGO")
    private long aluCodigo;
    @Basic(optional = false)
    @Column(name = "FIS_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
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
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fisFechaInicioCreacion;
    @Column(name = "FIS_FECHA_FIN_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fisFechaFinCreacion;
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
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime audFechaModifacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "TFS_CODIGO", referencedColumnName = "TFS_CODIGO")
    private SbeTipoFichaSocioeconomica sbeTipoFichaSocioeconomica;

    @Column(name = "SOL_CODIGO")
    private Long solCodigo;

    public SbeFichaSocioeconomica() {
    }

    public SbeFichaSocioeconomica(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }

    public SbeFichaSocioeconomica(Long fisCodigo, long pelCodigo,
                                  long aluCodigo, LocalDateTime fisFecha,
                                  String fisActualizar, String fisEstado,
                                  short fisVersion, LocalDateTime fisFechaInicioCreacion,
                                  Date fisFechaFinCreacion, Long estCodigo, String audEliminado,
                                  String audAdicionado, LocalDateTime audFechaAdicion,
                                  String audModificado, LocalDateTime audFechaModifacion,
                                  SbeTipoFichaSocioeconomica sbeTipoFichaSocioeconomica, Long solCodigo) {
        this.fisCodigo = fisCodigo;
        this.pelCodigo = pelCodigo;
        this.aluCodigo = aluCodigo;
        this.fisFecha = fisFecha;
        this.fisActualizar = fisActualizar;
        this.fisEstado = fisEstado;
        this.fisVersion = fisVersion;
        this.fisFechaInicioCreacion = fisFechaInicioCreacion;
        this.fisFechaFinCreacion = fisFechaFinCreacion;
        this.estCodigo = estCodigo;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.audModificado = audModificado;
        this.audFechaModifacion = audFechaModifacion;
        this.sbeTipoFichaSocioeconomica = sbeTipoFichaSocioeconomica;
        this.solCodigo = solCodigo;
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="sbermeob@ups.edu.ec";
        this.fisFecha=  LocalDateTime.now();
        this.fisFechaInicioCreacion =  LocalDateTime.now();
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

    public Date getFisFechaFinCreacion() {
        return fisFechaFinCreacion;
    }

    public void setFisFechaFinCreacion(Date fisFechaFinCreacion) {
        this.fisFechaFinCreacion = fisFechaFinCreacion;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }


    public SbeTipoFichaSocioeconomica getSbeTipoFichaSocioeconomica() {
        return sbeTipoFichaSocioeconomica;
    }

    public void setSbeTipoFichaSocioeconomica(SbeTipoFichaSocioeconomica sbeTipoFichaSocioeconomica) {
        this.sbeTipoFichaSocioeconomica = sbeTipoFichaSocioeconomica;
    }

    public long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(long pelCodigo) {
        this.pelCodigo = pelCodigo;
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

    public Long getSolCodigo() {
        return solCodigo;
    }

    public void setSolCodigo(Long solCodigo) {
        this.solCodigo = solCodigo;
    }
}
