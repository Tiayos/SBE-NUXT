package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeRangoFichaModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SbeRangoFichaDTO(
        Long codigo,
        String descripcion,
        @JsonProperty("limite_inferior") BigDecimal rafLimiteInferior,
        @JsonProperty("limite_superior") BigDecimal rafLimiteSuperior,
        BigDecimal puntos,
        String vigente,
        @JsonProperty("fecha_inicio_vigencia") LocalDateTime rafFechaInicioVigencia,
        String etiqueta,
        short quintil
        )
{

    public static SbeRangoFichaDTO toDTO(SbeRangoFichaModel model) {
        return new SbeRangoFichaDTO(
                model.getRafCodigo(),
                model.getRafDescripcion(),
                model.getRafLimiteInferior(),
                model.getRafLimiteSuperior(),
                model.getRafPuntos(),
                model.getRafVigente(),
                model.getRafFechaInicioVigencia(),
                model.getRafEtiqueta(),
                model.getRafQuintil()
        );
    }
}
