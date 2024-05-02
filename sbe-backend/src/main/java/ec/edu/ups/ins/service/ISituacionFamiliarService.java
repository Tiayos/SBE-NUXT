package ec.edu.ups.ins.service;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.projections.DatosDomicilioProjection;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISituacionFamiliarService {

    List<SbeSituacionFamiliarDTO> getSituacionesFamiliares(Long fisCodigo);
    SbeSituacionFamiliarDTO saveSituacionFamiliar(SbeSituacionFamiliarDTO sbeSituacionFamiliarDTO);
    void eliminarSituacionFamiliar(Long codigoSituacionFamiliar);

    List<SbeEstadoCivilDTO> listarEstadoCivil();
    public List<SbeInstruccionDTO> listarNivelInstruccion();
    public List<SbeParentescoDTO> listarParentescos();
    public List<SbeTipoEmpresaDTO> listarTiposEmpresas();

}
