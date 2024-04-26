/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;
import ec.edu.ups.ins.entity.dto.SbeTipoFichaSocioeconomicaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_TIPO_FICHA_SOCIOECONOMICA", schema = "SBE")
public class SbeTipoFichaSocioeconomicaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TFS_CODIGO")
    private Long tfsCodigo;
    @Basic(optional = false)
    @Column(name = "TFS_DESCRIPCION")
    private String tfsDescripcion;
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

    public SbeTipoFichaSocioeconomicaModel() {
    }

    public SbeTipoFichaSocioeconomicaModel(Long tfsCodigo) {
        this.tfsCodigo = tfsCodigo;
    }

    public SbeTipoFichaSocioeconomicaModel(Long tfsCodigo, String tfsDescripcion) {
        this.tfsCodigo = tfsCodigo;
        this.tfsDescripcion = tfsDescripcion;
    }

    public SbeTipoFichaSocioeconomicaModel(SbeTipoFichaSocioeconomicaDTO dto) {
        this.tfsCodigo = dto.codigo();
        this.tfsDescripcion = dto.descripcion();
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="sbermeob@ups.edu.ec";
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModifacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="sbermeob@ups.edu.ec";
    }

    public Long getTfsCodigo() {
        return tfsCodigo;
    }

    public void setTfsCodigo(Long tfsCodigo) {
        this.tfsCodigo = tfsCodigo;
    }

    public String getTfsDescripcion() {
        return tfsDescripcion;
    }

    public void setTfsDescripcion(String tfsDescripcion) {
        this.tfsDescripcion = tfsDescripcion;
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

    public LocalDateTime getAudFechaModifacion() {
        return audFechaModifacion;
    }

    public void setAudFechaModifacion(LocalDateTime audFechaModifacion) {
        this.audFechaModifacion = audFechaModifacion;
    }

}
