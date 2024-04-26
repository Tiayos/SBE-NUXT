package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeEstadosFichaModel;

public record SbeEstadosFichaDTO(
        Long codigo,
        @JsonProperty("fis_codigo") Long fisCodigo,
        @JsonProperty("sbe_codigo_estado") Long sbeCodigoEstado,
        @JsonProperty("codigo_periodo_lectivo") Long pelCodigo,
        @JsonProperty("vigencia_registro") String esfVigente

        )
{

    public static SbeEstadosFichaDTO toDTO(SbeEstadosFichaModel model) {
        return new SbeEstadosFichaDTO(
                model.getEsfCodigo(),
                model.getFisCodigo(),
                model.getEstCodigo(),
                model.getPelCodigo(),
                model.getEsfVigente()
        );
    }
}
