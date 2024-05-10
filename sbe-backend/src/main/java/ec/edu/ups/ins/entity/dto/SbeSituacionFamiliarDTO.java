package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;
import jakarta.annotation.Nullable;

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
                model.getSbeEstadoCivilModel() != null ? SbeEstadoCivilDTO.toDTO(model.getSbeEstadoCivilModel()) : null,
                model.getSbeFichaSocioeconomicaModel() != null ? SbeFichaSocioeconomicaDTO.toDTO(model.getSbeFichaSocioeconomicaModel()) : null,
                model.getSbeInstruccionModel() != null ? SbeInstruccionDTO.toDTO(model.getSbeInstruccionModel()) : null,
                model.getSbeParentescoModel() != null ? SbeParentescoDTO.toDTO(model.getSbeParentescoModel()) : null,
                model.getSbeTipoEmpresaModel() != null ? SbeTipoEmpresaDTO.toDTO(model.getSbeTipoEmpresaModel()) : null
        );
    }
}
