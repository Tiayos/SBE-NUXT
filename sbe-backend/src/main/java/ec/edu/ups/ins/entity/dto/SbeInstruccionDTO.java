package ec.edu.ups.ins.entity.dto;

import ec.edu.ups.ins.entity.model.sbe.SbeInstruccionModel;
public record SbeInstruccionDTO(
        Long codigo,
        String descripcion,
        Double puntos
        )
{

    public static SbeInstruccionDTO toDTO(SbeInstruccionModel model) {
        return new SbeInstruccionDTO(
                model.getInsCodigo(),
                model.getInsDescripcion(),
                model.getInsPuntos()
        );
    }
}
