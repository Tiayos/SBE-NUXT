package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeValorParametroFichaModel;

import java.time.LocalDateTime;

public record SbeValorParametroFichaDTO(
        Long codigo,
        @JsonProperty("pel_codigo_inicio") Long pelCodigoInicio,
        @JsonProperty("fecha_ingreso") LocalDateTime fechaIngreso,
        Double puntos,
        @JsonProperty("fis_codigo") SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO,
        @JsonProperty("opf_codigo") SbeOpcionParametroFichaDTO sbeOpcionParametroFichaDTO

        )
{

    public static SbeValorParametroFichaDTO toDTO(SbeValorParametroFichaModel model) {
        return new SbeValorParametroFichaDTO(
                model.getVpfCodigo(),
                model.getPelCodigoInicio(),
                model.getVpfFechaIngreso(),
                model.getVpfPuntos(),
                SbeFichaSocioeconomicaDTO.toDTO(model.getSbeFichaSocioeconomicaModel()),
                SbeOpcionParametroFichaDTO.toDTO(model.getSbeOpcionParametroFichaModel())
        );
    }
}
