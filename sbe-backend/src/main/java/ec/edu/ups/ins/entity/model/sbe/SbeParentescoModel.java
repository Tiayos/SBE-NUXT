package ec.edu.ups.ins.entity.model.sbe;
import ec.edu.ups.ins.entity.dto.SbeParentescoDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_PARENTESCO",schema = "SBE")
public class SbeParentescoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAR_CODIGO")
    private Long parCodigo;
    @Basic(optional = false)
    @Column(name = "PAR_NOMBRE")
    private String parNombre;
    @Column(name = "COD_PARENTESCO_LEG")
    private Long codParentescoLeg;
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


    public SbeParentescoModel() {
    }

    public SbeParentescoModel(Long parCodigo) {
        this.parCodigo = parCodigo;
    }

    public SbeParentescoModel(Long parCodigo, String parNombre, Long codParentescoLeg) {
        this.parCodigo = parCodigo;
        this.parNombre = parNombre;
        this.codParentescoLeg = codParentescoLeg;
    }

    public SbeParentescoModel(SbeParentescoDTO dto) {
        this.parCodigo = dto.codigo();
        this.parNombre = dto.nombre();
        this.codParentescoLeg = dto.codigoParentesco();
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

    public Long getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Long parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
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

    public Long getCodParentescoLeg() {
        return codParentescoLeg;
    }

    public void setCodParentescoLeg(Long codParentescoLeg) {
        this.codParentescoLeg = codParentescoLeg;
    }

    
}
