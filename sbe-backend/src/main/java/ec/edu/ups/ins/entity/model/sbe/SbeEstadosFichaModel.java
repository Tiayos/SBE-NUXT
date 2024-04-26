package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeEstadosFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_ESTADOS_FICHA", schema = "SBE")
public class SbeEstadosFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ESF_CODIGO")
    private Long esfCodigo;
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;
    @Basic(optional = false)
    @Column(name = "EST_CODIGO")
    private Long estCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Basic(optional = false)
    @Column(name = "ESF_VIGENTE")
    private String esfVigente;
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

    public SbeEstadosFichaModel() {
    }

    public SbeEstadosFichaModel(Long esfCodigo) {
        this.esfCodigo = esfCodigo;
    }

    public SbeEstadosFichaModel(Long esfCodigo, Long fisCodigo, Long estCodigo, Long pelCodigo, String esfVigente) {
        this.esfCodigo = esfCodigo;
        this.fisCodigo = fisCodigo;
        this.estCodigo = estCodigo;
        this.pelCodigo = pelCodigo;
        this.esfVigente = esfVigente;
    }

    public SbeEstadosFichaModel(SbeEstadosFichaDTO dto) {
        this.esfCodigo = dto.codigo();
        this.fisCodigo = dto.fisCodigo();
        this.estCodigo = dto.sbeCodigoEstado();
        this.pelCodigo = dto.pelCodigo();
        this.esfVigente = dto.esfVigente();
    }

    @PrePersist
    public void prePersist(){
        this.audAdicionado="SBE";
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
    }

    @PreUpdate
    public void preUpdate(){
        this.audModificado="SBE";
        this.audFechaModificacion = LocalDateTime.now();
    }

    public Long getEsfCodigo() {
        return esfCodigo;
    }

    public void setEsfCodigo(Long esfCodigo) {
        this.esfCodigo = esfCodigo;
    }

    public Long getFisCodigo() {
        return fisCodigo;
    }

    public void setFisCodigo(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public String getEsfVigente() {
        return esfVigente;
    }

    public void setEsfVigente(String esfVigente) {
        this.esfVigente = esfVigente;
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

    public String getAudModificado() {
        return audModificado;
    }

    public void setAudModificado(String audModificado) {
        this.audModificado = audModificado;
    }

    public LocalDateTime getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(LocalDateTime audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public LocalDateTime getAudFechaModificacion() {
        return audFechaModificacion;
    }

    public void setAudFechaModificacion(LocalDateTime audFechaModificacion) {
        this.audFechaModificacion = audFechaModificacion;
    }

}
