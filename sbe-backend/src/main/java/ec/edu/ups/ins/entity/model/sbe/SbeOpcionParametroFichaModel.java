/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ec.edu.ups.ins.entity.dto.SbeOpcionParametroFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_OPCION_PARAMETRO_FICHA", schema = "SBE")
public class SbeOpcionParametroFichaModel implements Serializable {

    @Id
    @Column(name = "OPF_CODIGO")
    private Long opfCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "PAF_CODIGO", referencedColumnName = "PAF_CODIGO")
    private SbeParametroFichaModel sbeParametroFichaModel;

    @Column(name = "OPF_DESCRIPCION")
    private String opfDescripcion;

    @Column(name = "OPF_ETIQUETA_MOSTRAR")
    private String opfEtiquetaMostrar;

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
    public SbeOpcionParametroFichaModel() {
    }

    public SbeOpcionParametroFichaModel(Long opfCodigo) {
        this.opfCodigo = opfCodigo;
    }

    public SbeOpcionParametroFichaModel(Long opfCodigo, SbeParametroFichaModel sbeParametroFichaModel,
                                        String opfDescripcion, String opfEtiquetaMostrar) {
        this.opfCodigo = opfCodigo;
        this.sbeParametroFichaModel = sbeParametroFichaModel;
        this.opfDescripcion = opfDescripcion;
        this.opfEtiquetaMostrar = opfEtiquetaMostrar;
    }

    public SbeOpcionParametroFichaModel(SbeOpcionParametroFichaDTO dto) {
        this.opfCodigo = dto.codigo();
        this.sbeParametroFichaModel = new SbeParametroFichaModel(dto.sbeParametroFichaDTO().codigo());
        this.opfDescripcion = dto.descripcion();
        this.opfEtiquetaMostrar = dto.opfEtiquetaMostrar();
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

    public Long getOpfCodigo() {
        return opfCodigo;
    }

    public void setOpfCodigo(Long opfCodigo) {
        this.opfCodigo = opfCodigo;
    }

    public SbeParametroFichaModel getSbeParametroFicha() {
        return sbeParametroFichaModel;
    }

    public void setSbeParametroFicha(SbeParametroFichaModel sbeParametroFichaModel) {
        this.sbeParametroFichaModel = sbeParametroFichaModel;
    }

    public String getOpfDescripcion() {
        return opfDescripcion;
    }

    public void setOpfDescripcion(String opfDescripcion) {
        this.opfDescripcion = opfDescripcion;
    }

    public String getOpfEtiquetaMostrar() {
        return opfEtiquetaMostrar;
    }

    public void setOpfEtiquetaMostrar(String opfEtiquetaMostrar) {
        this.opfEtiquetaMostrar = opfEtiquetaMostrar;
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
