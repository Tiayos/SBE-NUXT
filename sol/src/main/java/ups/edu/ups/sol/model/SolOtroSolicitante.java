/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ups.sol.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SOL_OTRO_SOLICITANTE", schema = "SOL")
public class SolOtroSolicitante implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OTS_CODIGO")
    private Long otsCodigo;
    @Basic(optional = false)
    @Column(name = "OTS_NOMBRE_APELLIDO")
    private String otsNombreApellido;
    @Column(name = "OTS_IDENTIFICACION")
    private String otsIdentificacion;
    @Column(name = "OTS_TELEFONO")
    private String otsTelefono;
    @Basic(optional = false)
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "AUD_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaModificacion;
    @OneToMany(mappedBy = "otsCodigo")
    private List<SolSolicitudPersona> solSolicitudPersonaList;

    public SolOtroSolicitante() {
    }

    public SolOtroSolicitante(Long otsCodigo) {
        this.otsCodigo = otsCodigo;
    }

    public SolOtroSolicitante(Long otsCodigo, String otsNombreApellido, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.otsCodigo = otsCodigo;
        this.otsNombreApellido = otsNombreApellido;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getOtsCodigo() {
        return otsCodigo;
    }

    public void setOtsCodigo(Long otsCodigo) {
        this.otsCodigo = otsCodigo;
    }

    public String getOtsNombreApellido() {
        return otsNombreApellido;
    }

    public void setOtsNombreApellido(String otsNombreApellido) {
        this.otsNombreApellido = otsNombreApellido;
    }

    public String getOtsIdentificacion() {
        return otsIdentificacion;
    }

    public void setOtsIdentificacion(String otsIdentificacion) {
        this.otsIdentificacion = otsIdentificacion;
    }

    public String getOtsTelefono() {
        return otsTelefono;
    }

    public void setOtsTelefono(String otsTelefono) {
        this.otsTelefono = otsTelefono;
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

    public Date getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(Date audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public String getAudModificado() {
        return audModificado;
    }

    public void setAudModificado(String audModificado) {
        this.audModificado = audModificado;
    }

    public Date getAudFechaModificacion() {
        return audFechaModificacion;
    }

    public void setAudFechaModificacion(Date audFechaModificacion) {
        this.audFechaModificacion = audFechaModificacion;
    }

    public List<SolSolicitudPersona> getSolSolicitudPersonaList() {
        return solSolicitudPersonaList;
    }

    public void setSolSolicitudPersonaList(List<SolSolicitudPersona> solSolicitudPersonaList) {
        this.solSolicitudPersonaList = solSolicitudPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otsCodigo != null ? otsCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolOtroSolicitante)) {
            return false;
        }
        SolOtroSolicitante other = (SolOtroSolicitante) object;
        if ((this.otsCodigo == null && other.otsCodigo != null) || (this.otsCodigo != null && !this.otsCodigo.equals(other.otsCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject7.SolOtroSolicitante[ otsCodigo=" + otsCodigo + " ]";
    }
}
