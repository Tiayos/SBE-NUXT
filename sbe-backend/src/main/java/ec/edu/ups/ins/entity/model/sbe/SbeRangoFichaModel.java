/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeRangoFichaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SBE_RANGO_FICHA", schema = "SBE")
public class SbeRangoFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RAF_CODIGO")
    private Long rafCodigo;
    @Basic(optional = false)
    @Column(name = "RAF_DESCRIPCION")
    private String rafDescripcion;
    @Basic(optional = false)
    @Column(name = "RAF_LIMITE_INFERIOR")
    private BigDecimal rafLimiteInferior;
    @Column(name = "RAF_LIMITE_SUPERIOR")
    private BigDecimal rafLimiteSuperior;
    @Basic(optional = false)
    @Column(name = "RAF_PUNTOS")
    private BigDecimal rafPuntos;
    @Column(name = "RAF_VIGENTE")
    private String rafVigente;
    @Column(name = "RAF_FECHA_INICIO_VIGENCIA")
    private LocalDateTime rafFechaInicioVigencia;
    @Basic(optional = false)
    @Column(name = "RAF_ETIQUETA")
    private String rafEtiqueta;
    @Column(name = "RAF_QUINTIL")
    private Short rafQuintil;
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

    public SbeRangoFichaModel() {
    }

    public SbeRangoFichaModel(Long rafCodigo) {
        this.rafCodigo = rafCodigo;
    }

    public SbeRangoFichaModel(Long rafCodigo, String rafDescripcion, BigDecimal rafLimiteInferior,
                              BigDecimal rafLimiteSuperior, BigDecimal rafPuntos,
                              String rafVigente, LocalDateTime rafFechaInicioVigencia,
                              String rafEtiqueta, Short rafQuintil) {
        this.rafCodigo = rafCodigo;
        this.rafDescripcion = rafDescripcion;
        this.rafLimiteInferior = rafLimiteInferior;
        this.rafLimiteSuperior = rafLimiteSuperior;
        this.rafPuntos = rafPuntos;
        this.rafVigente = rafVigente;
        this.rafFechaInicioVigencia = rafFechaInicioVigencia;
        this.rafEtiqueta = rafEtiqueta;
        this.rafQuintil = rafQuintil;
    }

    public SbeRangoFichaModel(SbeRangoFichaDTO dto) {
        this.rafCodigo = dto.codigo();
        this.rafDescripcion = dto.descripcion();
        this.rafLimiteInferior = dto.rafLimiteInferior();
        this.rafLimiteSuperior = dto.rafLimiteSuperior();
        this.rafPuntos = dto.puntos();
        this.rafVigente = dto.vigente();
        this.rafFechaInicioVigencia = dto.rafFechaInicioVigencia();
        this.rafEtiqueta = dto.etiqueta();
        this.rafQuintil = dto.quintil();
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

    public Long getRafCodigo() {
        return rafCodigo;
    }

    public void setRafCodigo(Long rafCodigo) {
        this.rafCodigo = rafCodigo;
    }

    public String getRafDescripcion() {
        return rafDescripcion;
    }

    public void setRafDescripcion(String rafDescripcion) {
        this.rafDescripcion = rafDescripcion;
    }

    public BigDecimal getRafLimiteInferior() {
        return rafLimiteInferior;
    }

    public void setRafLimiteInferior(BigDecimal rafLimiteInferior) {
        this.rafLimiteInferior = rafLimiteInferior;
    }

    public BigDecimal getRafLimiteSuperior() {
        return rafLimiteSuperior;
    }

    public void setRafLimiteSuperior(BigDecimal rafLimiteSuperior) {
        this.rafLimiteSuperior = rafLimiteSuperior;
    }

    public BigDecimal getRafPuntos() {
        return rafPuntos;
    }

    public void setRafPuntos(BigDecimal rafPuntos) {
        this.rafPuntos = rafPuntos;
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

    public String getRafVigente() {
        return rafVigente;
    }

    public void setRafVigente(String rafVigente) {
        this.rafVigente = rafVigente;
    }

    public LocalDateTime getRafFechaInicioVigencia() {
        return rafFechaInicioVigencia;
    }

    public void setRafFechaInicioVigencia(LocalDateTime rafFechaInicioVigencia) {
        this.rafFechaInicioVigencia = rafFechaInicioVigencia;
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

    public String getRafEtiqueta() {
        return rafEtiqueta;
    }

    public void setRafEtiqueta(String rafEtiqueta) {
        this.rafEtiqueta = rafEtiqueta;
    }

    public Short getRafQuintil() {
        return rafQuintil;
    }

    public void setRafQuintil(Short rafQuintil) {
        this.rafQuintil = rafQuintil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rafCodigo != null ? rafCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SbeRangoFichaModel)) {
            return false;
        }
        SbeRangoFichaModel other = (SbeRangoFichaModel) object;
        if ((this.rafCodigo == null && other.rafCodigo != null) || (this.rafCodigo != null && !this.rafCodigo.equals(other.rafCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.sbe_vpf.SbeRangoFichaModel[ rafCodigo=" + rafCodigo + " ]";
    }
    
}
