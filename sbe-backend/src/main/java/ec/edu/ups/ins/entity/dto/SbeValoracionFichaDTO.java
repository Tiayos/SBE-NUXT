package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeValoracionFichaModel;

public record SbeValoracionFichaDTO(
        Long codigo,
        @JsonProperty("fis_codigo") Long fisCodigo,
        @JsonProperty("pel_codigo") Long pelCodigo,
        Double valoracion,
        @JsonProperty("pel_codigo_fin") Long pelCodigoFin,
        @JsonProperty("pel_codigo_fin") SbeRangoFichaDTO sbeRangoFichaDTO
        )
{

    public static SbeValoracionFichaDTO toDTO(SbeValoracionFichaModel model) {
        return new SbeValoracionFichaDTO(
                model.getVafCodigo(),
                model.getFisCodigo(),
                model.getPelCodigo(),
                model.getVafValoracion(),
                model.getPelCodigoFin(),
                SbeRangoFichaDTO.toDTO(model.getSbeRangoFichaModel())
        );
    }
}
