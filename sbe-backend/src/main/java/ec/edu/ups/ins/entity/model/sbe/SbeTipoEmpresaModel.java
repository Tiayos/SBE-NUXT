/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeTipoEmpresaDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_TIPO_EMPRESA", schema = "SBE")
public class SbeTipoEmpresaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TEM_CODIGO")
    private Long temCodigo;
    @Basic(optional = false)
    @Column(name = "TEM_NOMBRE")
    private String temNombre;
    @Basic(optional = false)
    @Column(name = "TEM_ABREVIATURA")
    private String temAbreviatura;
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


    public SbeTipoEmpresaModel() {
    }

    public SbeTipoEmpresaModel(Long temCodigo) {
        this.temCodigo = temCodigo;
    }

    public SbeTipoEmpresaModel(Long temCodigo, String temNombre, String temAbreviatura) {
        this.temCodigo = temCodigo;
        this.temNombre = temNombre;
        this.temAbreviatura = temAbreviatura;
    }

    public SbeTipoEmpresaModel(SbeTipoEmpresaDTO dto) {
        this.temCodigo = dto.codigo();
        this.temNombre = dto.nombre();
        this.temAbreviatura = dto.abreviatura();
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

    public Long getTemCodigo() {
        return temCodigo;
    }

    public void setTemCodigo(Long temCodigo) {
        this.temCodigo = temCodigo;
    }

    public String getTemNombre() {
        return temNombre;
    }

    public void setTemNombre(String temNombre) {
        this.temNombre = temNombre;
    }

    public String getTemAbreviatura() {
        return temAbreviatura;
    }

    public void setTemAbreviatura(String temAbreviatura) {
        this.temAbreviatura = temAbreviatura;
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
