package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.service.ISituacionFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/situacionFamiliar")
public class SituacionFamiliarController {

    @Autowired
    public ISituacionFamiliarService iSituacionFamiliarService;

    @GetMapping
    public List<SbeSituacionFamiliarDTO> getSituacionFamiliar(@RequestParam Long fisCodigo){
        return iSituacionFamiliarService.getSituacionesFamiliares(fisCodigo);
    }

    @PostMapping
    public SbeSituacionFamiliarDTO saveSituacionFamiliar(@RequestBody SbeSituacionFamiliarDTO sbeSituacionFamiliarDTO){
        return iSituacionFamiliarService.saveSituacionFamiliar(sbeSituacionFamiliarDTO);
    }

    @DeleteMapping
    public void deleteSituacionFamiliar(@RequestParam Long codigo){
        iSituacionFamiliarService.eliminarSituacionFamiliar(codigo);
    }
    @GetMapping("/getEstadoCivil")
    public List<SbeEstadoCivilDTO> estadosCiviles(){
        return iSituacionFamiliarService.listarEstadoCivil();
    }

    @GetMapping("/getNivelInstruccion")
    public List<SbeInstruccionDTO> nivelesInstruccion(){
        return iSituacionFamiliarService.listarNivelInstruccion();
    }

    @GetMapping("/getParentescos")
    public List<SbeParentescoDTO> parentescos(){
        return iSituacionFamiliarService.listarParentescos();
    }

    @GetMapping("/getTiposEmpresas")
    public List<SbeTipoEmpresaDTO> tiposEmpresas(){
        return iSituacionFamiliarService.listarTiposEmpresas();
    }

}
