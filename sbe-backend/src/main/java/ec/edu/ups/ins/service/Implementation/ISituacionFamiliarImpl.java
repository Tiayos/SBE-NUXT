package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;
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
        return SbeSituacionFamiliarDTO.toDTO(sbeSituacionFamiliarDao.save(new SbeSituacionFamiliarModel(sbeSituacionFamiliarDTO)));
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


