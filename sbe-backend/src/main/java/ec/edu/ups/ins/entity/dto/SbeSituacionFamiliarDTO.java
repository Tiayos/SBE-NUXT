package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SbeSituacionFamiliarDTO(
        Long codigo,
        @JsonProperty("nombre_familiar") String nombreFamiliar,
        @JsonProperty("fecha_nacimiento") LocalDateTime fechaNacimiento,
        @JsonProperty("tipo_situacion") String tipoSituacion,
        @JsonProperty("numero_identificacion") String numeroIdentificacion,
        @JsonProperty("ingresos_mensuales") BigDecimal ingresosMensuales,
        @JsonProperty("estado_civil") SbeEstadoCivilDTO sbeEstadoCivilDTO,
        @JsonProperty("ficha_socioeconomica") SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO,
        @JsonProperty("sbe_instruccionDTO") SbeInstruccionDTO sbeInstruccionDTO,
        @JsonProperty("sbe_parentescoDTO") SbeParentescoDTO sbeParentescoDTO,
        @JsonProperty("sbe_tipo_empresa") SbeTipoEmpresaDTO sbeTipoEmpresaDTO

        )
{

    public static SbeSituacionFamiliarDTO toDTO(SbeSituacionFamiliarModel model) {
        return new SbeSituacionFamiliarDTO(
                model.getSifCodigo(),
                model.getSifNombreFamiliar(),
                model.getSifFechaNacimiento(),
                model.getSifTipoSituacion(),
                model.getSifNumeroIdentificacion(),
                model.getSfiIngresosMensuales(),
                SbeEstadoCivilDTO.toDTO(model.getSbeEstadoCivilModel()),
                SbeFichaSocioeconomicaDTO.toDTO(model.getSbeFichaSocioeconomicaModel()),
                SbeInstruccionDTO.toDTO(model.getSbeInstruccionModel()),
                SbeParentescoDTO.toDTO(model.getSbeParentescoModel()),
                SbeTipoEmpresaDTO.toDTO(model.getSbeTipoEmpresaModel())
        );
    }
}
