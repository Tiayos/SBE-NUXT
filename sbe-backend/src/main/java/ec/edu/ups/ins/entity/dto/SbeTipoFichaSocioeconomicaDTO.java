package ec.edu.ups.ins.entity.dto;

import ec.edu.ups.ins.entity.model.sbe.SbeTipoFichaSocioeconomicaModel;

public record SbeTipoFichaSocioeconomicaDTO(
        Long codigo,
        String descripcion

        )
{

    public static SbeTipoFichaSocioeconomicaDTO toDTO(SbeTipoFichaSocioeconomicaModel model) {
        return new SbeTipoFichaSocioeconomicaDTO(
                model.getTfsCodigo(),
                model.getTfsDescripcion()
        );
    }
}
