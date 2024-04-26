package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeParametroFichaModel;

public record SbeParametroFichaDTO(
        Long codigo,
        @JsonProperty("tipo_parametro_ficha") SbeTipoParametroFichaDTO sbeTipoParametroFichaDTO,
        String descripcion,
        String vigente,
        @JsonProperty("etiqueta_mostrar") String pafEtiquetaMostrar,
        Integer orden

        )
{
    public static SbeParametroFichaDTO toDTO(SbeParametroFichaModel model){
        return new SbeParametroFichaDTO(
                model.getPafCodigo(),
                SbeTipoParametroFichaDTO.toDTO(model.getSbeTipoParametroFicha()),
                model.getPafDescripcion(),
                model.getPafVigente(),
                model.getPafEtiquetaMostrar(),
                model.getPafOrden()
        );
    }
}
