package ec.edu.ups.ins.entity.model.sbe;
import ec.edu.ups.ins.entity.dto.SbeInstruccionDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "SBE_INSTRUCCION", schema = "SBE")
public class SbeInstruccionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INS_CODIGO")
    private Long insCodigo;
    @Basic(optional = false)
    @Column(name = "INS_DESCRIPCION")
    private String insDescripcion;
    @Basic(optional = false)
    @Column(name = "INS_PUNTOS")
    private Double insPuntos;
    @Basic(optional = false)
    @Column(name = "AUD_ELIMINADO")
    private String audEliminado;
    @Basic(optional = false)
    @Column(name = "AUD_ADICIONADO")
    private String audAdicionado;
    @Basic(optional = false)
    @Column(name = "AUD_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime audFechaAdicion;
    @Column(name = "AUD_MODIFICADO")
    private String audModificado;
    @Column(name = "AUD_FECHA_MODIFICACION")
    private LocalDateTime audFechaModificacion;


    public SbeInstruccionModel() {
    }

    public SbeInstruccionModel(Long insCodigo) {
        this.insCodigo = insCodigo;
    }

    public SbeInstruccionModel(Long insCodigo, String insDescripcion, Double insPuntos) {
        this.insCodigo = insCodigo;
        this.insDescripcion = insDescripcion;
        this.insPuntos = insPuntos;
    }

    public SbeInstruccionModel(SbeInstruccionDTO dto) {
        this.insCodigo = dto.codigo();
        this.insDescripcion = dto.descripcion();
        this.insPuntos = dto.puntos();
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

    public Double getInsPuntos() {
        return insPuntos;
    }

    public void setInsPuntos(Double insPuntos) {
        this.insPuntos = insPuntos;
    }

    public Long getInsCodigo() {
        return insCodigo;
    }

    public void setInsCodigo(Long insCodigo) {
        this.insCodigo = insCodigo;
    }

    public String getInsDescripcion() {
        return insDescripcion;
    }

    public void setInsDescripcion(String insDescripcion) {
        this.insDescripcion = insDescripcion;
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
