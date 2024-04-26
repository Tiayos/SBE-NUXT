package ups.edu.ups.sol.model.gth;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "GTH_PERSONA", schema = "GTH")
public class GthPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Basic(optional = false)
    @Column(name = "PER_NRO_IDENTIFICACION")
    private String perNroIdentificacion;
    @Basic(optional = false)
    @Column(name = "PER_APELLIDOS")
    private String perApellidos;
    @Basic(optional = false)
    @Column(name = "PER_NOMBRES")
    private String perNombres;
    @Basic(optional = false)
    @Column(name = "PER_GENERO")
    private String perGenero;
    @Basic(optional = false)
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "PER_CALLE_PRINCIPAL")
    private String perCallePrincipal;
    @Basic(optional = false)
    @Column(name = "PER_NRO_CASA")
    private String perNroCasa;
    @Column(name = "PER_CALLE_SECUNDARIA")
    private String perCalleSecundaria;
    @Column(name = "PER_REFERENCIA")
    private String perReferencia;
    @Column(name = "PER_NRO_PASAPORTE")
    private String perNroPasaporte;
    @Column(name = "PER_PAS_FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perPasFechaEmision;
    @Column(name = "PER_PAS_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perPasFechaVencimiento;
    @Column(name = "PER_CASILLA")
    private String perCasilla;
    @Column(name = "PER_NRO_SEGURO_SOCIAL")
    private String perNroSeguroSocial;
    @Column(name = "PER_FECHA_AFILIACION_SEGURO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaAfiliacionSeguro;
    @Basic(optional = false)
    @Column(name = "PER_ELIMINADO")
    private String perEliminado;
    @Basic(optional = false)
    @Column(name = "PER_ADICIONADO")
    private String perAdicionado;
    @Basic(optional = false)
    @Column(name = "PER_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaAdicion;
    @Column(name = "PER_MODIFICADO")
    private String perModificado;
    @Column(name = "PER_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaModificacion;
    @Column(name = "PER_EXTENSION")
    private String perExtension;
    @Column(name = "RAZ_CODIGO")
    private Long razCodigo;
    @Column(name = "IGE_CODIGO")
    private Long igeCodigo;
    @Column(name = "PER_BLOG")
    private String perBlog;
    @Column(name = "PER_GOOGLE_SCHOLAR")
    private String perGoogleScholar;
    @Column(name = "PER_ORCID")
    private String perOrcid;
    @Column(name = "PER_RESEARCH_GATE")
    private String perResearchGate;
    @Column(name = "PER_NOMBRES_FIRMA")
    private String perNombresFirma;
    @Column(name = "PER_APELLIDOS_FIRMA")
    private String perApellidosFirma;
    @Column(name = "PER_SCOPUS_ID")
    private String perScopusId;
    @Column(name = "PER_MOSTRAR_EXT")
    private String perMostrarExt;
    @Column(name = "PER_SIGLAS_TITULO_GRADO")
    private String perSiglasTituloGrado;
    @Column(name = "PER_SIGLAS_TITULO_POSGRADO")
    private String perSiglasTituloPosgrado;
    @Column(name = "PER_ROL_FIRMA_MAIL")
    private String perRolFirmaMail;

    public GthPersona() {
    }

    public GthPersona(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public GthPersona(Long perCodigo, String perNroIdentificacion, String perApellidos, String perNombres, String perGenero, Date perFechaNacimiento, String perCallePrincipal, String perNroCasa, String perEliminado, String perAdicionado, Date perFechaAdicion) {
        this.perCodigo = perCodigo;
        this.perNroIdentificacion = perNroIdentificacion;
        this.perApellidos = perApellidos;
        this.perNombres = perNombres;
        this.perGenero = perGenero;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perCallePrincipal = perCallePrincipal;
        this.perNroCasa = perNroCasa;
        this.perEliminado = perEliminado;
        this.perAdicionado = perAdicionado;
        this.perFechaAdicion = perFechaAdicion;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerNroIdentificacion() {
        return perNroIdentificacion;
    }

    public void setPerNroIdentificacion(String perNroIdentificacion) {
        this.perNroIdentificacion = perNroIdentificacion;
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

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerCallePrincipal() {
        return perCallePrincipal;
    }

    public void setPerCallePrincipal(String perCallePrincipal) {
        this.perCallePrincipal = perCallePrincipal;
    }

    public String getPerNroCasa() {
        return perNroCasa;
    }

    public void setPerNroCasa(String perNroCasa) {
        this.perNroCasa = perNroCasa;
    }

    public String getPerCalleSecundaria() {
        return perCalleSecundaria;
    }

    public void setPerCalleSecundaria(String perCalleSecundaria) {
        this.perCalleSecundaria = perCalleSecundaria;
    }

    public String getPerReferencia() {
        return perReferencia;
    }

    public void setPerReferencia(String perReferencia) {
        this.perReferencia = perReferencia;
    }

    public String getPerNroPasaporte() {
        return perNroPasaporte;
    }

    public void setPerNroPasaporte(String perNroPasaporte) {
        this.perNroPasaporte = perNroPasaporte;
    }

    public Date getPerPasFechaEmision() {
        return perPasFechaEmision;
    }

    public void setPerPasFechaEmision(Date perPasFechaEmision) {
        this.perPasFechaEmision = perPasFechaEmision;
    }

    public Date getPerPasFechaVencimiento() {
        return perPasFechaVencimiento;
    }

    public void setPerPasFechaVencimiento(Date perPasFechaVencimiento) {
        this.perPasFechaVencimiento = perPasFechaVencimiento;
    }

    public String getPerCasilla() {
        return perCasilla;
    }

    public void setPerCasilla(String perCasilla) {
        this.perCasilla = perCasilla;
    }

    public String getPerNroSeguroSocial() {
        return perNroSeguroSocial;
    }

    public void setPerNroSeguroSocial(String perNroSeguroSocial) {
        this.perNroSeguroSocial = perNroSeguroSocial;
    }

    public Date getPerFechaAfiliacionSeguro() {
        return perFechaAfiliacionSeguro;
    }

    public void setPerFechaAfiliacionSeguro(Date perFechaAfiliacionSeguro) {
        this.perFechaAfiliacionSeguro = perFechaAfiliacionSeguro;
    }

    public String getPerEliminado() {
        return perEliminado;
    }

    public void setPerEliminado(String perEliminado) {
        this.perEliminado = perEliminado;
    }

    public String getPerAdicionado() {
        return perAdicionado;
    }

    public void setPerAdicionado(String perAdicionado) {
        this.perAdicionado = perAdicionado;
    }

    public Date getPerFechaAdicion() {
        return perFechaAdicion;
    }

    public void setPerFechaAdicion(Date perFechaAdicion) {
        this.perFechaAdicion = perFechaAdicion;
    }

    public String getPerModificado() {
        return perModificado;
    }

    public void setPerModificado(String perModificado) {
        this.perModificado = perModificado;
    }

    public Date getPerFechaModificacion() {
        return perFechaModificacion;
    }

    public void setPerFechaModificacion(Date perFechaModificacion) {
        this.perFechaModificacion = perFechaModificacion;
    }

    public String getPerExtension() {
        return perExtension;
    }

    public void setPerExtension(String perExtension) {
        this.perExtension = perExtension;
    }

    public Long getRazCodigo() {
        return razCodigo;
    }

    public void setRazCodigo(Long razCodigo) {
        this.razCodigo = razCodigo;
    }

    public Long getIgeCodigo() {
        return igeCodigo;
    }

    public void setIgeCodigo(Long igeCodigo) {
        this.igeCodigo = igeCodigo;
    }

    public String getPerBlog() {
        return perBlog;
    }

    public void setPerBlog(String perBlog) {
        this.perBlog = perBlog;
    }

    public String getPerGoogleScholar() {
        return perGoogleScholar;
    }

    public void setPerGoogleScholar(String perGoogleScholar) {
        this.perGoogleScholar = perGoogleScholar;
    }

    public String getPerOrcid() {
        return perOrcid;
    }

    public void setPerOrcid(String perOrcid) {
        this.perOrcid = perOrcid;
    }

    public String getPerResearchGate() {
        return perResearchGate;
    }

    public void setPerResearchGate(String perResearchGate) {
        this.perResearchGate = perResearchGate;
    }

    public String getPerNombresFirma() {
        return perNombresFirma;
    }

    public void setPerNombresFirma(String perNombresFirma) {
        this.perNombresFirma = perNombresFirma;
    }

    public String getPerApellidosFirma() {
        return perApellidosFirma;
    }

    public void setPerApellidosFirma(String perApellidosFirma) {
        this.perApellidosFirma = perApellidosFirma;
    }

    public String getPerScopusId() {
        return perScopusId;
    }

    public void setPerScopusId(String perScopusId) {
        this.perScopusId = perScopusId;
    }

    public String getPerMostrarExt() {
        return perMostrarExt;
    }

    public void setPerMostrarExt(String perMostrarExt) {
        this.perMostrarExt = perMostrarExt;
    }

    public String getPerSiglasTituloGrado() {
        return perSiglasTituloGrado;
    }

    public void setPerSiglasTituloGrado(String perSiglasTituloGrado) {
        this.perSiglasTituloGrado = perSiglasTituloGrado;
    }

    public String getPerSiglasTituloPosgrado() {
        return perSiglasTituloPosgrado;
    }

    public void setPerSiglasTituloPosgrado(String perSiglasTituloPosgrado) {
        this.perSiglasTituloPosgrado = perSiglasTituloPosgrado;
    }

    public String getPerRolFirmaMail() {
        return perRolFirmaMail;
    }

    public void setPerRolFirmaMail(String perRolFirmaMail) {
        this.perRolFirmaMail = perRolFirmaMail;
    }



}
