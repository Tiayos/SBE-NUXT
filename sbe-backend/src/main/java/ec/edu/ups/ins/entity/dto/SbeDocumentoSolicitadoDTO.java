package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeDocumentoSolicitadoFichaModel;
import java.time.LocalDateTime;

public record SbeDocumentoSolicitadoDTO(
        Long codigo,
        Integer orden,
        String descripcion,
        @JsonProperty("fecha_limite") LocalDateTime fechaLimiteEnvio,
        @JsonProperty("estado_documento") String estadoDocumento,
        @JsonProperty("nombre_archivo") String nombreArchivo,
        byte[] archivo,
        @JsonProperty("extencion_documento") String extencionDocumento,
        @JsonProperty("fis_codigo") Long fisCodigo
        )
{

    public static SbeDocumentoSolicitadoDTO toDTO(SbeDocumentoSolicitadoFichaModel model) {
        return new SbeDocumentoSolicitadoDTO(
                model.getDocCodigo(),
                model.getDocOrden(),
                model.getDocDescripcion(),
                model.getDocFechaLimiteEnvio(),
                model.getDocEstadoDocumento(),
                model.getDocNombreArchivo(),
                model.getDocArchivo(),
                model.getDocExtencionBlob(),
                model.getFisCodigo()
        );
    }
}
