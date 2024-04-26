package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeTipoRangoDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_TIPO_RANGO", schema = "SBE")
public class SbeTipoRangoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIR_CODIGO")
    private Long tirCodigo;
    @Basic(optional = false)
    @Column(name = "TIR_DESCRIPCION")
    private String tirDescripcion;

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


    public SbeTipoRangoModel() {
    }

    public SbeTipoRangoModel(Long tirCodigo) {
        this.tirCodigo = tirCodigo;
    }

    public SbeTipoRangoModel(Long tirCodigo, String tirDescripcion) {
        this.tirCodigo = tirCodigo;
        this.tirDescripcion = tirDescripcion;
    }

    public SbeTipoRangoModel(SbeTipoRangoDTO dto) {
        this.tirCodigo = dto.codigo();
        this.tirDescripcion = dto.descripcion();
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

    public Long getTirCodigo() {
        return tirCodigo;
    }

    public void setTirCodigo(Long tirCodigo) {
        this.tirCodigo = tirCodigo;
    }

    public String getTirDescripcion() {
        return tirDescripcion;
    }

    public void setTirDescripcion(String tirDescripcion) {
        this.tirDescripcion = tirDescripcion;
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

}
