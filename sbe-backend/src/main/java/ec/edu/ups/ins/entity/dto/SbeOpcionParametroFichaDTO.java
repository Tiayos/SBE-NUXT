package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeOpcionParametroFichaModel;

public record SbeOpcionParametroFichaDTO(
        Long codigo,
        @JsonProperty("parametro_ficha") SbeParametroFichaDTO sbeParametroFichaDTO,
        String descripcion,
        @JsonProperty("etiqueta_mostrar") String opfEtiquetaMostrar

        )
{

    public static SbeOpcionParametroFichaDTO toDTO(SbeOpcionParametroFichaModel model) {
        return new SbeOpcionParametroFichaDTO(
                model.getOpfCodigo(),
                SbeParametroFichaDTO.toDTO(model.getSbeParametroFicha()),
                model.getOpfDescripcion(),
                model.getOpfEtiquetaMostrar()
        );
    }
}
