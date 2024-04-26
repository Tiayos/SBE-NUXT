package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeValorCampoFichaModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SbeValorCampoFichaDTO(
        Long codigo,
        @JsonProperty("pel_codigo_inicio") Long pelCodigoInicio,
        @JsonProperty("vcf_texto") String vcfTexto,
        @JsonProperty("vcf_entero") Long vcfEntero,
        @JsonProperty("vcf_decimal") BigDecimal vcfDecimal,
        @JsonProperty("vcf_fecha") LocalDateTime vcfFecha,
        @JsonProperty("fecha_ingreso") LocalDateTime fechaIngreso,
        @JsonProperty("campo_ficha") SbeCampoFichaDTO sbeCampoFichaDTO,
        @JsonProperty("fis_codigo") SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO

        )
{

    public static SbeValorCampoFichaDTO toDTO(SbeValorCampoFichaModel model) {
        return new SbeValorCampoFichaDTO(
                model.getVcfCodigo(),
                model.getPelCodigoInicio(),
                model.getVcfTexto(),
                model.getVcfEntero(),
                model.getVcfDecimal(),
                model.getVcfFecha(),
                model.getVcfFechaIngreso(),
                SbeCampoFichaDTO.toDTO(model.getSbeCampoFichaModel()),
                SbeFichaSocioeconomicaDTO.toDTO(model.getSbeFichaSocioeconomicaModel())
        );
    }
}
