package ec.edu.ups.ins.entity.dto;

import ec.edu.ups.ins.entity.model.sbe.SbeTipoEmpresaModel;

public record SbeTipoEmpresaDTO(
        Long codigo,
        String nombre,
        String abreviatura

        )
{

    public static SbeTipoEmpresaDTO toDTO(SbeTipoEmpresaModel model) {
        return new SbeTipoEmpresaDTO(
                model.getTemCodigo(),
                model.getTemNombre(),
                model.getTemAbreviatura()
        );
    }
}
