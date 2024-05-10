package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.entity.model.sbe.*;
import ec.edu.ups.ins.repository.*;
import ec.edu.ups.ins.service.ISituacionFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ISituacionFamiliarImpl implements ISituacionFamiliarService {

    @Autowired
    private SbeSituacionFamiliarDao sbeSituacionFamiliarDao;
    @Autowired
    private SbeEstadoCivilDao sbeEstadoCivilDao;
    @Autowired
    private SbeInstruccionDao sbeInstruccionDao;
    @Autowired
    private SbeParentescoDao sbeParentescoDao;
    @Autowired
    private SbeTipoEmpresaDao sbeTipoEmpresaDao;

    @Override
    public List<SbeSituacionFamiliarDTO> getSituacionesFamiliares(Long fisCodigo) {
        return sbeSituacionFamiliarDao.obterSituacionesFamiliares(fisCodigo)
                .stream()
                .map(SbeSituacionFamiliarDTO::toDTO)
                .toList();
    }

    @Override
    public SbeSituacionFamiliarDTO saveSituacionFamiliar(SbeSituacionFamiliarDTO sbeSituacionFamiliarDTO) {
        Long ultimoId = sbeSituacionFamiliarDao.obtenerUltimoIdSitFamiliar()+1;
        SbeSituacionFamiliarDTO sbeSituacionFamiliarDTO1 = new SbeSituacionFamiliarDTO(
                ultimoId,
                sbeSituacionFamiliarDTO.nombreFamiliar(),
                sbeSituacionFamiliarDTO.fechaNacimiento(),
                sbeSituacionFamiliarDTO.tipoSituacion(),
                sbeSituacionFamiliarDTO.numeroIdentificacion(),
                sbeSituacionFamiliarDTO.ingresosMensuales(),
                sbeSituacionFamiliarDTO.sbeEstadoCivilDTO(),
                sbeSituacionFamiliarDTO.sbeFichaSocioeconomicaDTO(),
                sbeSituacionFamiliarDTO.sbeInstruccionDTO(),
                sbeSituacionFamiliarDTO.sbeParentescoDTO(),
                sbeSituacionFamiliarDTO.sbeTipoEmpresaDTO()
        );

        return SbeSituacionFamiliarDTO.toDTO(sbeSituacionFamiliarDao.save(new SbeSituacionFamiliarModel(sbeSituacionFamiliarDTO1)));
    }

    @Override
    public void updateMiembroFamiliar(SbeSituacionFamiliarDTO sbeSituacionFamiliarDTO, Long codigo) {
        sbeSituacionFamiliarDao.findById(codigo)
                .map(
                        miembroFamiliarMap -> {
                            miembroFamiliarMap.setSifNombreFamiliar(sbeSituacionFamiliarDTO.nombreFamiliar());
                            miembroFamiliarMap.setSifFechaNacimiento(sbeSituacionFamiliarDTO.fechaNacimiento());
                            miembroFamiliarMap.setSifTipoSituacion(sbeSituacionFamiliarDTO.tipoSituacion());
                            miembroFamiliarMap.setSifNumeroIdentificacion(sbeSituacionFamiliarDTO.numeroIdentificacion());
                            miembroFamiliarMap.setSfiIngresosMensuales(sbeSituacionFamiliarDTO.ingresosMensuales());
                            miembroFamiliarMap.setSbeEstadoCivilModel(new SbeEstadoCivilModel(sbeSituacionFamiliarDTO.sbeEstadoCivilDTO().codigo()));
                            miembroFamiliarMap.setSbeFichaSocioeconomicaModel(new SbeFichaSocioeconomicaModel(sbeSituacionFamiliarDTO.sbeFichaSocioeconomicaDTO().fisCodigo()));
                            miembroFamiliarMap.setSbeInstruccionModel(new SbeInstruccionModel(sbeSituacionFamiliarDTO.sbeInstruccionDTO().codigo()));
                            miembroFamiliarMap.setSbeParentescoModel(new SbeParentescoModel(sbeSituacionFamiliarDTO.sbeParentescoDTO().codigo()));
                            miembroFamiliarMap.setSbeTipoEmpresaModel(new SbeTipoEmpresaModel(sbeSituacionFamiliarDTO.sbeTipoEmpresaDTO().codigo()));
                            return SbeSituacionFamiliarDTO.toDTO(sbeSituacionFamiliarDao.save(miembroFamiliarMap));
                        }) .orElseThrow(
                        () -> new RuntimeException("No se encontró el miembro familiar con número: ".concat(codigo.toString()))
                );
    }

    @Override
    public void eliminarSituacionFamiliar(Long codigoSituacionFamiliar) {
        sbeSituacionFamiliarDao.deleteById(codigoSituacionFamiliar);
    }

    @Override
    public List<SbeEstadoCivilDTO> listarEstadoCivil() {
        return sbeEstadoCivilDao.findAll()
                .stream()
                .map(SbeEstadoCivilDTO::toDTO)
                .toList();
    }
    @Override
    public List<SbeInstruccionDTO> listarNivelInstruccion() {
        return sbeInstruccionDao.findAll()
                .stream()
                .map(SbeInstruccionDTO::toDTO)
                .toList();
    }

    @Override
    public List<SbeParentescoDTO> listarParentescos() {
        return sbeParentescoDao.findAll()
                .stream()
                .map(SbeParentescoDTO::toDTO)
                .toList();
    }
    @Override
    public List<SbeTipoEmpresaDTO> listarTiposEmpresas() {
        return sbeTipoEmpresaDao.findAll()
                .stream()
                .map(SbeTipoEmpresaDTO::toDTO)
                .toList();
    }
}


