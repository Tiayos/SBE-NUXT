package ec.edu.ups.ins.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.ins.entity.model.sbe.SbeCampoFichaModel;
public record SbeCampoFichaDTO(
        Long codigo,
        String descripcion,
        String tipo,
        String etiqueta,
        Integer orden,
        @JsonProperty("tipo_parametro") SbeTipoParametroFichaDTO sbeTipoParametroFichaDTO

        )
{

    public static SbeCampoFichaDTO toDTO(SbeCampoFichaModel model) {
        return new SbeCampoFichaDTO(
                model.getCafCodigo(),
                model.getCafDescripcion(),
                model.getCafTipo(),
                model.getCafEtiquetaMostrar(),
                model.getCafOrden(),
                SbeTipoParametroFichaDTO.toDTO(model.getSbeTipoParametroFichaModel())
        );
    }
}
