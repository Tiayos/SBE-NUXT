package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeInformeFichaAmpliadaModel;
public record SbeInformeFichaAmpliadaDTO(
        Long codigo,
        @JsonProperty("situacion_familiar") String situacionFamiliar,
        @JsonProperty("situacion_economica") String situacionEconomica,
        @JsonProperty("situacion_vivienda") String situacionVivienda,
        @JsonProperty("situacion_educacion") String situacionEducacion,
        @JsonProperty("salud_familia_estudiante") String infSaludFamiliaEstudiante,
        String evidencias,
        String conclusiones,
        String sugerencias,
        @JsonProperty("fis_codigo") Long fisCodigo
        )
{

    public static SbeInformeFichaAmpliadaDTO toDTO(SbeInformeFichaAmpliadaModel model) {
        return new SbeInformeFichaAmpliadaDTO(
                model.getInfCodigo(),
                model.getInfSituacionFamiliar(),
                model.getInfSituacionEconomica(),
                model.getInfSituacionVivienda(),
                model.getInfSituacionEducacion(),
                model.getInfSaludFamiliaEstudiante(),
                model.getInfEvidencias(),
                model.getInfConclusiones(),
                model.getInfSugerencias(),
                model.getFisCodigo()
        );
    }
}
