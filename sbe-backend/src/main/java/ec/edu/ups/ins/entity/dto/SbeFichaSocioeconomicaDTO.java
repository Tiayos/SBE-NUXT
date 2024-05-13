package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeFichaSocioeconomicaModel;

import java.time.LocalDateTime;

public record SbeFichaSocioeconomicaDTO(
        @JsonProperty("fis_codigo") Long fisCodigo,
        @JsonProperty("pel_codigo") Long pelCodigo,
        @JsonProperty("alu_codigo") Long aluCodigo,
        LocalDateTime fecha,
        String actualizar,
        String estado,
        short version,
        @JsonProperty("fecha_inicio_creacion") LocalDateTime fisFechaInicioCreacion,
        @JsonProperty("fecha_fin_creacion") LocalDateTime fisFechaFinCreacion,
        @JsonProperty("est_codigo") Long estCodigo,
        @JsonProperty("sol_codigo") Long solCodigo,
        @JsonProperty("tipo_ficha") SbeTipoFichaSocioeconomicaDTO sbeTipoFichaSocioeconomicaDTO,
        @JsonProperty("pel_codigo_valido_inicio") long pelCodigoValidoInicio



        )
{

    public static SbeFichaSocioeconomicaDTO toDTO(SbeFichaSocioeconomicaModel model) {
        return new SbeFichaSocioeconomicaDTO(
                model.getFisCodigo(),
                model.getPel_codigo(),
                model.getAluCodigo(),
                model.getFisFecha(),
                model.getFisActualizar(),
                model.getFisEstado(),
                model.getFisVersion(),
                model.getFisFechaInicioCreacion(),
                model.getFisFechaFinCreacion(),
                model.getEstCodigo(),
                model.getSolCodigo(),
//                model.getSbeEstadoCivilModel() != null ? SbeEstadoCivilDTO.toDTO(model.getSbeEstadoCivilModel()) : null,
                model.getSbeTipoFichaSocioeconomicaModel() != null ? SbeTipoFichaSocioeconomicaDTO.toDTO(model.getSbeTipoFichaSocioeconomicaModel()): null,
                model.getPelCodigoValidoInicio()
//                SbeTipoFichaSocioeconomicaDTO.toDTO(model.getSbeTipoFichaSocioeconomica())
        );
    }
}
