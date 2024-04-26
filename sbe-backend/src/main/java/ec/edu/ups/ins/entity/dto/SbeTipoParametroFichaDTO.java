package ec.edu.ups.ins.entity.dto;

import ec.edu.ups.ins.entity.model.sbe.SbeTipoParametroFichaModel;

public record SbeTipoParametroFichaDTO(
        Long codigo,
        String descripcion

        )
{

    public static SbeTipoParametroFichaDTO toDTO(SbeTipoParametroFichaModel model) {
        return new SbeTipoParametroFichaDTO(
                model.getTpfCodigo(),
                model.getTpfDescripcion()
        );
    }
}
