package ups.edu.ups.sol.model.sbe;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_VALORACION_FICHA", schema = "SBE")
public class SbeValoracionFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VAF_CODIGO")
    private Long vafCodigo;
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Basic(optional = false)
    @Column(name = "RAF_CODIGO")
    private Long rafCodigo;
    @Basic(optional = false)
    @Column(name = "VAF_VALORACION")
    private Double vafValoracion;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO_FIN")
    private Long pelCodigoFin;

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


    public SbeValoracionFicha() {
    }

    public SbeValoracionFicha(Long vafCodigo) {
        this.vafCodigo = vafCodigo;
    }

    public SbeValoracionFicha(Long vafCodigo, Long fisCodigo, Long pelCodigo, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.vafCodigo = vafCodigo;
        this.fisCodigo = fisCodigo;
        this.pelCodigo = pelCodigo;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getVafCodigo() {
        return vafCodigo;
    }

    public void setVafCodigo(Long vafCodigo) {
        this.vafCodigo = vafCodigo;
    }

    public Long getFisCodigo() {
        return fisCodigo;
    }

    public void setFisCodigo(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public Long getRafCodigo() {
        return rafCodigo;
    }

    public void setRafCodigo(Long rafCodigo) {
        this.rafCodigo = rafCodigo;
    }

    public Double getVafValoracion() {
        return vafValoracion;
    }

    public void setVafValoracion(Double vafValoracion) {
        this.vafValoracion = vafValoracion;
    }

    public Long getPelCodigoFin() {
        return pelCodigoFin;
    }

    public void setPelCodigoFin(Long pelCodigoFin) {
        this.pelCodigoFin = pelCodigoFin;
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

}
