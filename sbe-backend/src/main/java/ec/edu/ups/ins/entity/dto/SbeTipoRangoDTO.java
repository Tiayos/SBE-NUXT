package ec.edu.ups.ins.entity.dto;
import ec.edu.ups.ins.entity.model.sbe.SbeTipoRangoModel;
public record SbeTipoRangoDTO(
        Long codigo,
        String descripcion
        )
{

    public static SbeTipoRangoDTO toDTO(SbeTipoRangoModel model) {
        return new SbeTipoRangoDTO(
                model.getTirCodigo(),
                model.getTirDescripcion()
        );
    }
}
