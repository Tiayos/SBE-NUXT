/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_TIPO_PARAMETRO_FICHA", schema = "SBE")
public class SbeTipoParametroFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TPF_CODIGO")
    private Long tpfCodigo;
    @Basic(optional = false)
    @Column(name = "TPF_DESCRIPCION")
    private String tpfDescripcion;
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

    public SbeTipoParametroFichaModel() {
    }

    public SbeTipoParametroFichaModel(Long tpfCodigo) {
        this.tpfCodigo = tpfCodigo;
    }

    public SbeTipoParametroFichaModel(Long tpfCodigo, String tpfDescripcion,
                                      String audEliminado, String audAdicionado,
                                      LocalDateTime audFechaAdicion, String audModificado,
                                      LocalDateTime audFechaModificacion) {
        this.tpfCodigo = tpfCodigo;
        this.tpfDescripcion = tpfDescripcion;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.audModificado = audModificado;
        this.audFechaModificacion = audFechaModificacion;
    }

    public SbeTipoParametroFichaModel(ec.edu.ups.ins.entity.dto.SbeTipoParametroFichaDTO dto) {
        this.tpfCodigo = dto.codigo();
        this.tpfDescripcion = dto.descripcion();
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

    public Long getTpfCodigo() {
        return tpfCodigo;
    }

    public void setTpfCodigo(Long tpfCodigo) {
        this.tpfCodigo = tpfCodigo;
    }

    public String getTpfDescripcion() {
        return tpfDescripcion;
    }

    public void setTpfDescripcion(String tpfDescripcion) {
        this.tpfDescripcion = tpfDescripcion;
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
