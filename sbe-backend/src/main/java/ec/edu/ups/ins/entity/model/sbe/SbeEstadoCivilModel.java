package ec.edu.ups.ins.entity.model.sbe;
import ec.edu.ups.ins.entity.dto.SbeEstadoCivilDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SBE_ESTADO_CIVIL", schema = "SBE")
public class SbeEstadoCivilModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ESC_CODIGO")
    private Long escCodigo;
    @Basic(optional = false)
    @Column(name = "ESC_NOMBRE")
    private String escNombre;
    @Basic(optional = false)
    @Column(name = "ESC_ABREVIATURA")
    private String escAbreviatura;
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
    @Column(name = "COD_ESTADO_LEG")
    private String codEstadoLeg;

    public SbeEstadoCivilModel() {
    }

    public SbeEstadoCivilModel(Long escCodigo) {
        this.escCodigo = escCodigo;
    }

    public SbeEstadoCivilModel(Long escCodigo, String escNombre, String escAbreviatura, String codEstadoLeg) {
        this.escCodigo = escCodigo;
        this.escNombre = escNombre;
        this.escAbreviatura = escAbreviatura;
        this.codEstadoLeg = codEstadoLeg;
    }

    public SbeEstadoCivilModel(SbeEstadoCivilDTO dto) {
        this.escCodigo = escCodigo;
        this.escNombre = escNombre;
        this.escAbreviatura = escAbreviatura;
        this.codEstadoLeg = codEstadoLeg;
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

    public Long getEscCodigo() {
        return escCodigo;
    }

    public void setEscCodigo(Long escCodigo) {
        this.escCodigo = escCodigo;
    }

    public String getEscNombre() {
        return escNombre;
    }

    public void setEscNombre(String escNombre) {
        this.escNombre = escNombre;
    }

    public String getEscAbreviatura() {
        return escAbreviatura;
    }

    public void setEscAbreviatura(String escAbreviatura) {
        this.escAbreviatura = escAbreviatura;
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

    public String getCodEstadoLeg() {
        return codEstadoLeg;
    }

    public void setCodEstadoLeg(String codEstadoLeg) {
        this.codEstadoLeg = codEstadoLeg;
    }

}
