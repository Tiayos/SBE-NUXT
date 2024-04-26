package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeParentescoModel;
public record SbeParentescoDTO(
        Long codigo,
        String nombre,
        @JsonProperty("codigo_parentesco") Long codigoParentesco


        )
{

    public static SbeParentescoDTO toDTO( SbeParentescoModel model) {
        return new SbeParentescoDTO(
                model.getParCodigo(),
                model.getParNombre(),
                model.getCodParentescoLeg()
        );
    }
}
