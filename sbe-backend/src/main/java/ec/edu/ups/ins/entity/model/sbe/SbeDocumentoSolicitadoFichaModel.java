package ec.edu.ups.ins.entity.model.sbe;

import ec.edu.ups.ins.entity.dto.SbeDocumentoSolicitadoDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "SBE_DOCUMENTO_SOLICITADO_FICHA", schema = "SBE")
public class SbeDocumentoSolicitadoFichaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DOC_CODIGO")
    private Long docCodigo;
    @Basic(optional = false)
    @Column(name = "DOC_ORDEN")
    private Integer docOrden;
    @Basic(optional = false)
    @Column(name = "DOC_DESCRIPCION")
    private String docDescripcion;
    @Basic(optional = false)
    @Column(name = "DOC_FECHA_LIMITE_ENVIO")
    private LocalDateTime docFechaLimiteEnvio;
    @Basic(optional = false)
    @Column(name = "DOC_ESTADO_DOCUMENTO")
    private String docEstadoDocumento;

    @Column(name = "DOC_NOMBRE_ARCHIVO")
    private String docNombreArchivo;
    @Column(name = "DOC_ARCHIVO", columnDefinition="BLOB")
    private byte[] docArchivo;
    @Column(name = "DOC_EXTENSION_BLOB")
    private String docExtencionBlob;
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

    public SbeDocumentoSolicitadoFichaModel() {
    }

    public SbeDocumentoSolicitadoFichaModel(Long docCodigo) {
        this.docCodigo = docCodigo;
    }

    public SbeDocumentoSolicitadoFichaModel(Long docCodigo, Integer docOrden, String docDescripcion,
                                            LocalDateTime docFechaLimiteEnvio, String docEstadoDocumento,
                                            String docNombreArchivo, byte[] docArchivo, String docExtencionBlob,
                                            Long fisCodigo) {
        this.docCodigo = docCodigo;
        this.docOrden = docOrden;
        this.docDescripcion = docDescripcion;
        this.docFechaLimiteEnvio = docFechaLimiteEnvio;
        this.docEstadoDocumento = docEstadoDocumento;
        this.docNombreArchivo = docNombreArchivo;
        this.docArchivo = docArchivo;
        this.docExtencionBlob = docExtencionBlob;
        this.fisCodigo = fisCodigo;
    }

    public SbeDocumentoSolicitadoFichaModel(SbeDocumentoSolicitadoDTO dto) {
        this.docCodigo = dto.codigo();
        this.docOrden = dto.orden();
        this.docDescripcion = dto.descripcion();
        this.docFechaLimiteEnvio = dto.fechaLimiteEnvio();
        this.docEstadoDocumento = dto.estadoDocumento();
        this.docNombreArchivo = dto.nombreArchivo();
        this.docArchivo = dto.archivo();
        this.docExtencionBlob = dto.extencionDocumento();
        this.fisCodigo = dto.fisCodigo();
    }

    @PrePersist
    public void prePersist(){
        this.audFechaAdicion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audAdicionado="SBE";
        this.docEstadoDocumento = docEstadoDocumento.toUpperCase();
    }

    @PreUpdate
    public void preUpdate(){
        this.audFechaModificacion = LocalDateTime.now();
        this.audEliminado = "N";
        this.audModificado="SBE";
        this.docEstadoDocumento = docEstadoDocumento.toUpperCase();
    }

    public Long getDocCodigo() {
        return docCodigo;
    }

    public void setDocCodigo(Long docCodigo) {
        this.docCodigo = docCodigo;
    }

    public String getDocDescripcion() {
        return docDescripcion;
    }

    public void setDocDescripcion(String docDescripcion) {
        this.docDescripcion = docDescripcion;
    }

    public String getDocEstadoDocumento() {
        return docEstadoDocumento;
    }

    public void setDocEstadoDocumento(String docEstadoDocumento) {
        this.docEstadoDocumento = docEstadoDocumento;
    }

    public LocalDateTime getDocFechaLimiteEnvio() {
        return docFechaLimiteEnvio;
    }

    public void setDocFechaLimiteEnvio(LocalDateTime docFechaLimiteEnvio) {
        this.docFechaLimiteEnvio = docFechaLimiteEnvio;
    }

    public String getDocNombreArchivo() {
        return docNombreArchivo;
    }

    public void setDocNombreArchivo(String docNombreArchivo) {
        this.docNombreArchivo = docNombreArchivo;
    }

    public byte[] getDocArchivo() {
        return docArchivo;
    }

    public void setDocArchivo(byte[] docArchivo) {
        this.docArchivo = docArchivo;
    }

    public String getDocExtencionBlob() {
        return docExtencionBlob;
    }

    public void setDocExtencionBlob(String docExtencionBlob) {
        this.docExtencionBlob = docExtencionBlob;
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

    public Integer getDocOrden() {
        return docOrden;
    }

    public void setDocOrden(Integer docOrden) {
        this.docOrden = docOrden;
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

    public LocalDateTime getAudFechaAdicion() {
        return audFechaAdicion;
    }

    public void setAudFechaAdicion(LocalDateTime audFechaAdicion) {
        this.audFechaAdicion = audFechaAdicion;
    }

    public LocalDateTime getAudFechaModificacion() {
        return audFechaModificacion;
    }

    public void setAudFechaModificacion(LocalDateTime audFechaModificacion) {
        this.audFechaModificacion = audFechaModificacion;
    }

}
