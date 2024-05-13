package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.entity.model.sbe.SbeFichaSocioeconomicaModel;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;
import ec.edu.ups.ins.repository.*;
import ec.edu.ups.ins.service.IFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class fichaSocioeconomicaImpl implements IFichaService {

    @Autowired
    private SbeFichaSocioeconomicaDao sbeFichaSocioeconomicaDao;

    @Override
    public List<SbeFichaSocioeconomicaDTO> getFichas() {
        return null;
    }

    @Override
    public SbeFichaSocioeconomicaDTO getFichaByCodigo(Long codigo) {
        return null;
    }

    @Override
    public SbeFichaSocioeconomicaDTO saveFichaSocioeconomica(SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO) {
        Long ultimoId = sbeFichaSocioeconomicaDao.obtenerUltimoIdFichaSocioeconomica()+1;
        Long pelCodigo = sbeFichaSocioeconomicaDao.obtenerPeriodoValidaSolicitud(sbeFichaSocioeconomicaDTO.aluCodigo());
        Long pelCodigoValidoInicio = sbeFichaSocioeconomicaDao.obtenerPeriodoValidaSolicitud(sbeFichaSocioeconomicaDTO.aluCodigo())+1;

        SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO1 = new SbeFichaSocioeconomicaDTO(
                ultimoId,
                pelCodigo,
                sbeFichaSocioeconomicaDTO.aluCodigo(),
                LocalDateTime.now(),
                "N",
                sbeFichaSocioeconomicaDTO.estado(),
                sbeFichaSocioeconomicaDTO.version(),
                LocalDateTime.now(),
                sbeFichaSocioeconomicaDTO.fisFechaFinCreacion(),
                sbeFichaSocioeconomicaDTO.estCodigo(),
                sbeFichaSocioeconomicaDTO.solCodigo(),
                sbeFichaSocioeconomicaDTO.sbeTipoFichaSocioeconomicaDTO(),
                pelCodigoValidoInicio

        );
        return SbeFichaSocioeconomicaDTO.toDTO(sbeFichaSocioeconomicaDao.save(new SbeFichaSocioeconomicaModel(sbeFichaSocioeconomicaDTO1)));
    }

    @Override
    public void updateFicha(SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO, Long codigo) {

    }

    @Override
    public void deleteFicha(Long codigoFicha) {

    }
}


