/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ups.sol.model.sbe;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_TIPO_FICHA_SOCIOECONOMICA", schema = "SBE")
public class SbeTipoFichaSocioeconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TFS_CODIGO")
    private Long tfsCodigo;
    @Basic(optional = false)
    @Column(name = "TFS_DESCRIPCION")
    private String tfsDescripcion;

    public SbeTipoFichaSocioeconomica() {
    }

    public SbeTipoFichaSocioeconomica(Long tfsCodigo) {
        this.tfsCodigo = tfsCodigo;
    }

    public SbeTipoFichaSocioeconomica(Long tfsCodigo, String tfsDescripcion) {
        this.tfsCodigo = tfsCodigo;
        this.tfsDescripcion = tfsDescripcion;
    }

    public Long getTfsCodigo() {
        return tfsCodigo;
    }

    public void setTfsCodigo(Long tfsCodigo) {
        this.tfsCodigo = tfsCodigo;
    }

    public String getTfsDescripcion() {
        return tfsDescripcion;
    }

    public void setTfsDescripcion(String tfsDescripcion) {
        this.tfsDescripcion = tfsDescripcion;
    }

}
