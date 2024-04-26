/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ups.sol.model.ins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import ups.edu.ups.sol.model.sigac.ClienteLocal;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "INS_ALUMNO", catalog = "", schema = "INS")
public class InsAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ALU_CODIGO")
    private Long aluCodigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "CLLC_CDG", referencedColumnName = "CLLC_CDG")
    private ClienteLocal cllcCdg;
    @Basic(optional = false)
    @Column(name = "ARG_CODIGO_NAC")
    private long argCodigoNac;
    @Basic(optional = false)
    @Column(name = "ARG_CODIGO_DOM")
    private long argCodigoDom;
    @Basic(optional = false)
    @Column(name = "ALU_APELLIDOS")
    private String aluApellidos;
    @Basic(optional = false)
    @Column(name = "ALU_NOMBRES")
    private String aluNombres;
    @Basic(optional = false)
    @Column(name = "ALU_GENERO")
    private String aluGenero;
    @Column(name = "ALU_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aluFechaNacimiento;
    @Column(name = "ALU_DIRECCION_CALLE_SEC")
    private String aluDireccionCalleSec;
    @Column(name = "ALU_DIRECCION_DATO_ADI")
    private String aluDireccionDatoAdi;
    @Column(name = "ALU_CEDULA_MILITAR")
    private String aluCedulaMilitar;
    @Column(name = "ALU_TIPO_DOCUMENTO_MILITAR")
    private String aluTipoDocumentoMilitar;
    @Column(name = "ALU_NUMERO_AFILIACION_IESS")
    private String aluNumeroAfiliacionIess;
    @Basic(optional = false)
    @Column(name = "ALU_VIGENCIA")
    private String aluVigencia;
    @Column(name = "ALU_EMAIL")
    private String aluEmail;
    @Column(name = "ALU_EMAIL_STATUS")
    private Short aluEmailStatus;
    @Column(name = "ALU_NOTIFICACION_SMS")
    private String aluNotificacionSms;
    @Column(name = "ALU_BARRIO")
    private String aluBarrio;
    @Column(name = "ALU_NOMBRE_PERSONA_CONTACTO")
    private String aluNombrePersonaContacto;
    @Column(name = "ALU_TELEFONO_PERSONA_CONTACTO")
    private String aluTelefonoPersonaContacto;
    @Column(name = "ALU_NACIONALIDAD")
    private String aluNacionalidad;
    @Column(name = "ALU_PRESENTAR_CLAVE")
    private String aluPresentarClave;
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
    @Column(name = "ALU_TIPO_DOCUMENTO")
    private String aluTipoDocumento;
    @Column(name = "ALU_CLAVE")
    private String aluClave;
    @Column(name = "ALU_TELEFONO_PERSONA_WHATSAPP")
    private String aluTelefonoPersonaWhatsapp;
    @Column(name = "ALU_RED_SOCIAL_PERSONA")
    private String aluRedSocialPersona;
    @Basic(optional = false)
    @Column(name = "ALU_DATOS_ACTUALIZADOS")
    private String aluDatosActualizados;
    @Column(name = "ALU_FECHA_ACTUALIZACION_DATOS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aluFechaActualizacionDatos;
    @Column(name = "ALU_CIUDAD_NAC_OTRO")
    private String aluCiudadNacOtro;
    @Column(name = "ALU_PROVINCIA_NAC_OTRO")
    private String aluProvinciaNacOtro;
    @Column(name = "ALU_PARROQUIA_NAC_OTRO")
    private String aluParroquiaNacOtro;
    @Column(name = "ALU_CIUDAD_DOM_OTRO")
    private String aluCiudadDomOtro;
    @Column(name = "ALU_PROVINCIA_DOM_OTRO")
    private String aluProvinciaDomOtro;
    @Column(name = "ALU_PARROQUIA_DOM_OTRO")
    private String aluParroquiaDomOtro;

    public InsAlumno() {
    }

    public InsAlumno(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public InsAlumno(Long aluCodigo, ClienteLocal cllcCdg, long argCodigoNac, long argCodigoDom, String aluApellidos, String aluNombres, String aluGenero, String aluVigencia, String audEliminado, String audAdicionado, Date audFechaAdicion, String aluDatosActualizados) {
        this.aluCodigo = aluCodigo;
        this.cllcCdg = cllcCdg;
        this.argCodigoNac = argCodigoNac;
        this.argCodigoDom = argCodigoDom;
        this.aluApellidos = aluApellidos;
        this.aluNombres = aluNombres;
        this.aluGenero = aluGenero;
        this.aluVigencia = aluVigencia;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
        this.aluDatosActualizados = aluDatosActualizados;
    }

    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public ClienteLocal getCllcCdg() {
        return cllcCdg;
    }

    public void setCllcCdg(ClienteLocal cllcCdg) {
        this.cllcCdg = cllcCdg;
    }

    public long getArgCodigoNac() {
        return argCodigoNac;
    }

    public void setArgCodigoNac(long argCodigoNac) {
        this.argCodigoNac = argCodigoNac;
    }

    public long getArgCodigoDom() {
        return argCodigoDom;
    }

    public void setArgCodigoDom(long argCodigoDom) {
        this.argCodigoDom = argCodigoDom;
    }

    public String getAluApellidos() {
        return aluApellidos;
    }

    public void setAluApellidos(String aluApellidos) {
        this.aluApellidos = aluApellidos;
    }

    public String getAluNombres() {
        return aluNombres;
    }

    public void setAluNombres(String aluNombres) {
        this.aluNombres = aluNombres;
    }

    public String getAluGenero() {
        return aluGenero;
    }

    public void setAluGenero(String aluGenero) {
        this.aluGenero = aluGenero;
    }

    public Date getAluFechaNacimiento() {
        return aluFechaNacimiento;
    }

    public void setAluFechaNacimiento(Date aluFechaNacimiento) {
        this.aluFechaNacimiento = aluFechaNacimiento;
    }

    public String getAluDireccionCalleSec() {
        return aluDireccionCalleSec;
    }

    public void setAluDireccionCalleSec(String aluDireccionCalleSec) {
        this.aluDireccionCalleSec = aluDireccionCalleSec;
    }

    public String getAluDireccionDatoAdi() {
        return aluDireccionDatoAdi;
    }

    public void setAluDireccionDatoAdi(String aluDireccionDatoAdi) {
        this.aluDireccionDatoAdi = aluDireccionDatoAdi;
    }

    public String getAluCedulaMilitar() {
        return aluCedulaMilitar;
    }

    public void setAluCedulaMilitar(String aluCedulaMilitar) {
        this.aluCedulaMilitar = aluCedulaMilitar;
    }

    public String getAluTipoDocumentoMilitar() {
        return aluTipoDocumentoMilitar;
    }

    public void setAluTipoDocumentoMilitar(String aluTipoDocumentoMilitar) {
        this.aluTipoDocumentoMilitar = aluTipoDocumentoMilitar;
    }

    public String getAluNumeroAfiliacionIess() {
        return aluNumeroAfiliacionIess;
    }

    public void setAluNumeroAfiliacionIess(String aluNumeroAfiliacionIess) {
        this.aluNumeroAfiliacionIess = aluNumeroAfiliacionIess;
    }

    public String getAluVigencia() {
        return aluVigencia;
    }

    public void setAluVigencia(String aluVigencia) {
        this.aluVigencia = aluVigencia;
    }

    public String getAluEmail() {
        return aluEmail;
    }

    public void setAluEmail(String aluEmail) {
        this.aluEmail = aluEmail;
    }

    public Short getAluEmailStatus() {
        return aluEmailStatus;
    }

    public void setAluEmailStatus(Short aluEmailStatus) {
        this.aluEmailStatus = aluEmailStatus;
    }

    public String getAluNotificacionSms() {
        return aluNotificacionSms;
    }

    public void setAluNotificacionSms(String aluNotificacionSms) {
        this.aluNotificacionSms = aluNotificacionSms;
    }

    public String getAluBarrio() {
        return aluBarrio;
    }

    public void setAluBarrio(String aluBarrio) {
        this.aluBarrio = aluBarrio;
    }

    public String getAluNombrePersonaContacto() {
        return aluNombrePersonaContacto;
    }

    public void setAluNombrePersonaContacto(String aluNombrePersonaContacto) {
        this.aluNombrePersonaContacto = aluNombrePersonaContacto;
    }

    public String getAluTelefonoPersonaContacto() {
        return aluTelefonoPersonaContacto;
    }

    public void setAluTelefonoPersonaContacto(String aluTelefonoPersonaContacto) {
        this.aluTelefonoPersonaContacto = aluTelefonoPersonaContacto;
    }

    public String getAluNacionalidad() {
        return aluNacionalidad;
    }

    public void setAluNacionalidad(String aluNacionalidad) {
        this.aluNacionalidad = aluNacionalidad;
    }

    public String getAluPresentarClave() {
        return aluPresentarClave;
    }

    public void setAluPresentarClave(String aluPresentarClave) {
        this.aluPresentarClave = aluPresentarClave;
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

    public String getAluTipoDocumento() {
        return aluTipoDocumento;
    }

    public void setAluTipoDocumento(String aluTipoDocumento) {
        this.aluTipoDocumento = aluTipoDocumento;
    }

    public String getAluClave() {
        return aluClave;
    }

    public void setAluClave(String aluClave) {
        this.aluClave = aluClave;
    }

    public String getAluTelefonoPersonaWhatsapp() {
        return aluTelefonoPersonaWhatsapp;
    }

    public void setAluTelefonoPersonaWhatsapp(String aluTelefonoPersonaWhatsapp) {
        this.aluTelefonoPersonaWhatsapp = aluTelefonoPersonaWhatsapp;
    }

    public String getAluRedSocialPersona() {
        return aluRedSocialPersona;
    }

    public void setAluRedSocialPersona(String aluRedSocialPersona) {
        this.aluRedSocialPersona = aluRedSocialPersona;
    }

    public String getAluDatosActualizados() {
        return aluDatosActualizados;
    }

    public void setAluDatosActualizados(String aluDatosActualizados) {
        this.aluDatosActualizados = aluDatosActualizados;
    }

    public Date getAluFechaActualizacionDatos() {
        return aluFechaActualizacionDatos;
    }

    public void setAluFechaActualizacionDatos(Date aluFechaActualizacionDatos) {
        this.aluFechaActualizacionDatos = aluFechaActualizacionDatos;
    }

    public String getAluCiudadNacOtro() {
        return aluCiudadNacOtro;
    }

    public void setAluCiudadNacOtro(String aluCiudadNacOtro) {
        this.aluCiudadNacOtro = aluCiudadNacOtro;
    }

    public String getAluProvinciaNacOtro() {
        return aluProvinciaNacOtro;
    }

    public void setAluProvinciaNacOtro(String aluProvinciaNacOtro) {
        this.aluProvinciaNacOtro = aluProvinciaNacOtro;
    }

    public String getAluParroquiaNacOtro() {
        return aluParroquiaNacOtro;
    }

    public void setAluParroquiaNacOtro(String aluParroquiaNacOtro) {
        this.aluParroquiaNacOtro = aluParroquiaNacOtro;
    }

    public String getAluCiudadDomOtro() {
        return aluCiudadDomOtro;
    }

    public void setAluCiudadDomOtro(String aluCiudadDomOtro) {
        this.aluCiudadDomOtro = aluCiudadDomOtro;
    }

    public String getAluProvinciaDomOtro() {
        return aluProvinciaDomOtro;
    }

    public void setAluProvinciaDomOtro(String aluProvinciaDomOtro) {
        this.aluProvinciaDomOtro = aluProvinciaDomOtro;
    }

    public String getAluParroquiaDomOtro() {
        return aluParroquiaDomOtro;
    }

    public void setAluParroquiaDomOtro(String aluParroquiaDomOtro) {
        this.aluParroquiaDomOtro = aluParroquiaDomOtro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluCodigo != null ? aluCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsAlumno)) {
            return false;
        }
        InsAlumno other = (InsAlumno) object;
        if ((this.aluCodigo == null && other.aluCodigo != null) || (this.aluCodigo != null && !this.aluCodigo.equals(other.aluCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.mavenproject6.InsAlumno[ aluCodigo=" + aluCodigo + " ]";
    }
    
}
