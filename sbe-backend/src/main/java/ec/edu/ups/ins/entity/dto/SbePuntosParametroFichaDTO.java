package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbePuntosParametroFichaModel;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SbePuntosParametroFichaDTO(
        Long codigo,
        BigDecimal puntos,
        @JsonProperty("fecha_inicio_vigencia") LocalDateTime fechaInicioVigencia,
        @JsonProperty("fecha_fin_vigencia") LocalDateTime fechaFinVigencia,
        String vigente,
        @JsonProperty("opcion_parametro_ficha") SbeOpcionParametroFichaDTO sbeOpcionParametroFichaDTO
        )
{

    public static SbePuntosParametroFichaDTO toDTO(SbePuntosParametroFichaModel model) {
        return new SbePuntosParametroFichaDTO(
                model.getPpfCodigo(),
                model.getPpfPuntos(),
                model.getPpfFechaInicioVigencia(),
                model.getPpfFechaFinVigencia(),
                model.getPpfVigente(),
                SbeOpcionParametroFichaDTO.toDTO(model.getSbeOpcionParametroFichaModel())
        );
    }
}
