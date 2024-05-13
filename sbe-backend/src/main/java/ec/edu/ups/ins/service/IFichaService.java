package ec.edu.ups.ins.service;

import ec.edu.ups.ins.entity.dto.*;

import java.util.List;

public interface IFichaService {

    List<SbeFichaSocioeconomicaDTO> getFichas();
    SbeFichaSocioeconomicaDTO saveFichaSocioeconomica(SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO);
    SbeFichaSocioeconomicaDTO getFichaByCodigo(Long codigo);
    void updateFicha(SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO, Long codigo);
    void deleteFicha(Long codigoFicha);

}
