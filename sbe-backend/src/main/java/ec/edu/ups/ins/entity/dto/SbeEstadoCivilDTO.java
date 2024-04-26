package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeEstadoCivilModel;

public record SbeEstadoCivilDTO(
        Long codigo,
        String nombre,
        String abreviatura,
        @JsonProperty("codigo_estado") String codigoEstado


)
{
    public static SbeEstadoCivilDTO toDTO(SbeEstadoCivilModel model) {
        return new SbeEstadoCivilDTO(
                model.getEscCodigo(),
                model.getEscNombre(),
                model.getEscAbreviatura(),
                model.getCodEstadoLeg()
        );
    }
}
