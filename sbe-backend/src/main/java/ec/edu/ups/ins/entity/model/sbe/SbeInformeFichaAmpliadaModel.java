package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeInformeFichaAmpliadaDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_INFORME_FICHA_AMPLIADA", schema = "SBE")
public class SbeInformeFichaAmpliadaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INF_CODIGO")
    private Long infCodigo;
    @Basic(optional = false)
    @Column(name = "INF_SITUACION_FAMILIAR", length = 300)
    private String infSituacionFamiliar;
    @Basic(optional = false)
    @Column(name = "INF_SITUACION_ECONOMICA", length = 300)
    private String infSituacionEconomica;
    @Basic(optional = false)
    @Column(name = "INF_SITUACION_VIVIENDA", length = 300)
    private String infSituacionVivienda;
    @Basic(optional = false)
    @Column(name = "INF_SITUACION_EDUCACION", length = 300)
    private String infSituacionEducacion;
    @Basic(optional = false)
    @Column(name = "INF_SALUD_FAMILIA_ESTUDIANTE", length = 300)
    private String infSaludFamiliaEstudiante;
    @Basic(optional = false)
    @Column(name = "INF_EVIDENCIAS", length = 300)
    private String infEvidencias;
    @Basic(optional = false)
    @Column(name = "INF_CONCLUSIONES", length = 300)
    private String infConclusiones;
    @Basic(optional = false)
    @Column(name = "INF_SUGERENCIAS", length = 300)
    private String infSugerencias;
    @Basic(optional = false)
    @Column(name = "FIS_CODIGO")
    private Long fisCodigo;

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

    public SbeInformeFichaAmpliadaModel() {
    }

    public SbeInformeFichaAmpliadaModel(Long infCodigo) {
        this.infCodigo = infCodigo;
    }

    public SbeInformeFichaAmpliadaModel(Long infCodigo, String infSituacionFamiliar, String infSituacionEconomica,
                                        String infSituacionVivienda, String infSituacionEducacion,
                                        String infSaludFamiliaEstudiante, String infEvidencias,
                                        String infConclusiones, String infSugerencias, Long fisCodigo) {
        this.infCodigo = infCodigo;
        this.infSituacionFamiliar = infSituacionFamiliar;
        this.infSituacionEconomica = infSituacionEconomica;
        this.infSituacionVivienda = infSituacionVivienda;
        this.infSituacionEducacion = infSituacionEducacion;
        this.infSaludFamiliaEstudiante = infSaludFamiliaEstudiante;
        this.infEvidencias = infEvidencias;
        this.infConclusiones = infConclusiones;
        this.infSugerencias = infSugerencias;
        this.fisCodigo = fisCodigo;
    }

    public SbeInformeFichaAmpliadaModel(SbeInformeFichaAmpliadaDTO dto) {
        this.infCodigo = dto.codigo();
        this.infSituacionFamiliar = dto.situacionFamiliar();
        this.infSituacionEconomica = dto.situacionEconomica();
        this.infSituacionVivienda = dto.situacionVivienda();
        this.infSituacionEducacion = dto.situacionEducacion();
        this.infSaludFamiliaEstudiante = dto.infSaludFamiliaEstudiante();
        this.infEvidencias = dto.evidencias();
        this.infConclusiones = dto.conclusiones();
        this.infSugerencias = dto.sugerencias();
        this.fisCodigo = dto.fisCodigo();
    }


    @PrePersist
    public void prePersist(){
        this.audAdicionado="SBE";
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.infSituacionFamiliar = infSituacionFamiliar.toUpperCase();
        this.infSituacionEconomica = infSituacionEconomica.toUpperCase();
        this.infSituacionVivienda = infSituacionVivienda.toUpperCase();
        this.infSituacionEducacion = infSituacionEducacion.toUpperCase();
        this.infSaludFamiliaEstudiante = infSaludFamiliaEstudiante.toUpperCase();
        this.infEvidencias = infEvidencias.toUpperCase();
        this.infConclusiones = infConclusiones.toUpperCase();
        this.infSugerencias = infSugerencias.toUpperCase();
    }

    @PreUpdate
    public void preUpdate(){
        this.audModificado="SBE";
        this.audFechaModificacion = LocalDateTime.now();
        this.infSituacionFamiliar = infSituacionFamiliar.toUpperCase();
        this.infSituacionEconomica = infSituacionEconomica.toUpperCase();
        this.infSituacionVivienda = infSituacionVivienda.toUpperCase();
        this.infSituacionEducacion = infSituacionEducacion.toUpperCase();
        this.infSaludFamiliaEstudiante = infSaludFamiliaEstudiante.toUpperCase();
        this.infEvidencias = infEvidencias.toUpperCase();
        this.infConclusiones = infConclusiones.toUpperCase();
        this.infSugerencias = infSugerencias.toUpperCase();
    }

    public Long getInfCodigo() {
        return infCodigo;
    }

    public void setInfCodigo(Long infCodigo) {
        this.infCodigo = infCodigo;
    }

    public String getInfSituacionFamiliar() {
        return infSituacionFamiliar;
    }

    public void setInfSituacionFamiliar(String infSituacionFamiliar) {
        this.infSituacionFamiliar = infSituacionFamiliar;
    }

    public String getInfSituacionEconomica() {
        return infSituacionEconomica;
    }

    public void setInfSituacionEconomica(String infSituacionEconomica) {
        this.infSituacionEconomica = infSituacionEconomica;
    }

    public String getInfSituacionVivienda() {
        return infSituacionVivienda;
    }

    public void setInfSituacionVivienda(String infSituacionVivienda) {
        this.infSituacionVivienda = infSituacionVivienda;
    }

    public String getInfSituacionEducacion() {
        return infSituacionEducacion;
    }

    public void setInfSituacionEducacion(String infSituacionEducacion) {
        this.infSituacionEducacion = infSituacionEducacion;
    }

    public String getInfSaludFamiliaEstudiante() {
        return infSaludFamiliaEstudiante;
    }

    public void setInfSaludFamiliaEstudiante(String infSaludFamiliaEstudiante) {
        this.infSaludFamiliaEstudiante = infSaludFamiliaEstudiante;
    }

    public String getInfEvidencias() {
        return infEvidencias;
    }

    public void setInfEvidencias(String infEvidencias) {
        this.infEvidencias = infEvidencias;
    }

    public String getInfConclusiones() {
        return infConclusiones;
    }

    public void setInfConclusiones(String infConclusiones) {
        this.infConclusiones = infConclusiones;
    }

    public String getInfSugerencias() {
        return infSugerencias;
    }

    public void setInfSugerencias(String infSugerencias) {
        this.infSugerencias = infSugerencias;
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

    public Long getFisCodigo() {
        return fisCodigo;
    }

    public void setFisCodigo(Long fisCodigo) {
        this.fisCodigo = fisCodigo;
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
