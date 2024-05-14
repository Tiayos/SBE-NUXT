package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.entity.model.sbe.SbeFichaSocioeconomicaModel;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;
import ec.edu.ups.ins.repository.*;
import ec.edu.ups.ins.service.IFichaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
                pelCodigoValidoInicio,
                sbeFichaSocioeconomicaDTO.audAdicionado(),
                sbeFichaSocioeconomicaDTO.audModificado()

        );
        return SbeFichaSocioeconomicaDTO.toDTO(sbeFichaSocioeconomicaDao.save(new SbeFichaSocioeconomicaModel(sbeFichaSocioeconomicaDTO1)));
    }

    @Override
    public void updateFicha(SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO, Long codigo) {
        LocalDateTime datetime = LocalDateTime.now();
        Date date = new Date();
        try {
            sbeFichaSocioeconomicaDao.findById(codigo)
                    .map(
                            ficha -> {
                                ficha.setFisEstado(sbeFichaSocioeconomicaDTO.estado());
                                ficha.setAudModificado(sbeFichaSocioeconomicaDTO.audModificado());
                                ficha.setFisFecha(datetime);
                                ficha.setAudFechaModifacion(datetime);
                                ficha.setFisFechaFinCreacion(datetime);
                                ficha.setSolCodigo(sbeFichaSocioeconomicaDTO.solCodigo());
                                return SbeFichaSocioeconomicaDTO.toDTO(sbeFichaSocioeconomicaDao.save(ficha));
                            }) .orElseThrow(
                            () -> new NotFoundException("No se encontró la ficha con número: ".concat(codigo.toString()))
                    );
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteFicha(Long codigoFicha) {

    }

    @Override
    public String estadoFicha(String cedula) {
        var d = sbeFichaSocioeconomicaDao.obtenerDatosFichaAmpliada(cedula) == null ? null : sbeFichaSocioeconomicaDao.obtenerDatosFichaAmpliada(cedula).getFisEstado();
        System.out.println(d);
        return d;
    }

    @Override
    public Long obtenerCodigoFichaAmpliada(String cedula) {
        Long codigoFicha = sbeFichaSocioeconomicaDao.obtenerDatosFichaAmpliada(cedula) == null ? null : sbeFichaSocioeconomicaDao.obtenerDatosFichaAmpliada(cedula).getFisCodigo();
        if(codigoFicha!=null){
            return codigoFicha; // si el estudiante tiene una ficha devuelvo el codigo de esa ficha
        }else{
            return null; // si el servicio me devuelve null es por que el estudiante aun no tiene una ficha
        }
    }
}


