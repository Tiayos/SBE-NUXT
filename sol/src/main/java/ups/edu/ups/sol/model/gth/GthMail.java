package ups.edu.ups.sol.model.gth;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "GTH_MAIL", schema = "GTH")
public class GthMail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MAI_CODIGO")
    private Long maiCodigo;
    @Column(name = "MAI_DIRECCION")
    private String maiDireccion;
    @Column(name = "MAI_ESTADO")
    private Short maiEstado;
    @Column(name = "MAI_CLAVE")
    private String maiClave;
    @Basic(optional = false)
    @Column(name = "MAI_ELIMINADO")
    private String maiEliminado;
    @Basic(optional = false)
    @Column(name = "MAI_ADICIONADO")
    private String maiAdicionado;
    @Basic(optional = false)
    @Column(name = "MAI_FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maiFechaAdicion;
    @Column(name = "MAI_MODIFICADO")
    private String maiModificado;
    @Column(name = "MAI_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maiFechaModificacion;
    @Column(name = "PER_CODIGO")
    private Long perCodigo;

    @Column(name = "TIM_CODIGO")
    private Long timCodigo;

    public GthMail() {
    }

    public GthMail(Long maiCodigo) {
        this.maiCodigo = maiCodigo;
    }

    public GthMail(Long maiCodigo, String maiDireccion, Short maiEstado, String maiClave, String maiEliminado, String maiAdicionado,
                   Date maiFechaAdicion, String maiModificado, Date maiFechaModificacion,
                   Long perCodigo, Long timCodigo) {
        this.maiCodigo = maiCodigo;
        this.maiDireccion = maiDireccion;
        this.maiEstado = maiEstado;
        this.maiClave = maiClave;
        this.maiEliminado = maiEliminado;
        this.maiAdicionado = maiAdicionado;
        this.maiFechaAdicion = maiFechaAdicion;
        this.maiModificado = maiModificado;
        this.maiFechaModificacion = maiFechaModificacion;
        this.perCodigo = perCodigo;
        this.timCodigo = timCodigo;
    }

    public Long getTimCodigo() {
        return timCodigo;
    }

    public void setTimCodigo(Long timCodigo) {
        this.timCodigo = timCodigo;
    }

    public Long getMaiCodigo() {
        return maiCodigo;
    }

    public void setMaiCodigo(Long maiCodigo) {
        this.maiCodigo = maiCodigo;
    }

    public String getMaiDireccion() {
        return maiDireccion;
    }

    public void setMaiDireccion(String maiDireccion) {
        this.maiDireccion = maiDireccion;
    }

    public Short getMaiEstado() {
        return maiEstado;
    }

    public void setMaiEstado(Short maiEstado) {
        this.maiEstado = maiEstado;
    }

    public String getMaiClave() {
        return maiClave;
    }

    public void setMaiClave(String maiClave) {
        this.maiClave = maiClave;
    }

    public String getMaiEliminado() {
        return maiEliminado;
    }

    public void setMaiEliminado(String maiEliminado) {
        this.maiEliminado = maiEliminado;
    }

    public String getMaiAdicionado() {
        return maiAdicionado;
    }

    public void setMaiAdicionado(String maiAdicionado) {
        this.maiAdicionado = maiAdicionado;
    }

    public Date getMaiFechaAdicion() {
        return maiFechaAdicion;
    }

    public void setMaiFechaAdicion(Date maiFechaAdicion) {
        this.maiFechaAdicion = maiFechaAdicion;
    }

    public String getMaiModificado() {
        return maiModificado;
    }

    public void setMaiModificado(String maiModificado) {
        this.maiModificado = maiModificado;
    }

    public Date getMaiFechaModificacion() {
        return maiFechaModificacion;
    }

    public void setMaiFechaModificacion(Date maiFechaModificacion) {
        this.maiFechaModificacion = maiFechaModificacion;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }
}
