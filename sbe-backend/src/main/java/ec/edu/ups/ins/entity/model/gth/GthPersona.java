package ec.edu.ups.ins.entity.model.gth;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GTH_PERSONA", schema = "GTH")
public class GthPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Basic(optional = false)
    @Column(name = "PER_APELLIDOS")
    private String perApellidos;
    @Basic(optional = false)
    @Column(name = "PER_NOMBRES")
    private String perNombres;
    @Basic(optional = false)
    @Column(name = "PER_GENERO")
    private String perGenero;    
    @Column(name = "PER_NRO_IDENTIFICACION")
    private String perNroIdentificacion;
    
    @Basic(optional = false)
    @Column(name = "PER_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "PER_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "PER_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaAdicion;
    @Column(name = "PER_MODIFICADO")
    private String audModificado;
    @Column(name = "PER_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFechaModificacion;
    
    public GthPersona() {
    }

    public GthPersona(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public GthPersona(Long perCodigo, String perApellidos, String perNombres, String perGenero, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.perCodigo = perCodigo;
        this.perApellidos = perApellidos;
        this.perNombres = perNombres;
        this.perGenero = perGenero;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public String getPerNroIdentificacion() {
        return perNroIdentificacion;
    }

    public void setPerNroIdentificacion(String perNroIdentificacion) {
        this.perNroIdentificacion = perNroIdentificacion;
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

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GthPersona)) {
            return false;
        }
        GthPersona other = (GthPersona) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject3.GthPersona[ perCodigo=" + perCodigo + " ]";
    }

}

