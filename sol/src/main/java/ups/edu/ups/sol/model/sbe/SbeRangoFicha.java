package ups.edu.ups.sol.model.sbe;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_RANGO_FICHA", schema = "SBE")
public class SbeRangoFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RAF_CODIGO")
    private Long rafCodigo;
    @Basic(optional = false)
    @Column(name = "TIR_CODIGO")
    private Long tirCodigo;
    @Basic(optional = false)
    @Column(name = "RAF_DESCRIPCION")
    private String rafDescripcion;
    @Basic(optional = false)
    @Column(name = "RAF_PUNTOS")
    private Long rafPuntos;
    @Column(name = "RAF_VIGENTE")
    private String rafVigente;

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


    public SbeRangoFicha() {
    }

    public SbeRangoFicha(Long rafCodigo) {
        this.rafCodigo = rafCodigo;
    }

    public SbeRangoFicha(Long rafCodigo, String audEliminado, String audAdicionado, Date audFechaAdicion) {
        this.rafCodigo = rafCodigo;
        this.audEliminado = audEliminado;
        this.audAdicionado = audAdicionado;
        this.audFechaAdicion = audFechaAdicion;
    }

    public Long getRafCodigo() {
        return rafCodigo;
    }

    public void setRafCodigo(Long rafCodigo) {
        this.rafCodigo = rafCodigo;
    }

    public Long getTirCodigo() {
        return tirCodigo;
    }

    public void setTirCodigo(Long tirCodigo) {
        this.tirCodigo = tirCodigo;
    }

    public String getRafDescripcion() {
        return rafDescripcion;
    }

    public void setRafDescripcion(String rafDescripcion) {
        this.rafDescripcion = rafDescripcion;
    }

    public Long getRafPuntos() {
        return rafPuntos;
    }

    public void setRafPuntos(Long rafPuntos) {
        this.rafPuntos = rafPuntos;
    }

    public String getRafVigente() {
        return rafVigente;
    }

    public void setRafVigente(String rafVigente) {
        this.rafVigente = rafVigente;
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
