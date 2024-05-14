package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.entity.dto.*;
import ec.edu.ups.ins.service.IFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/fichaSocioeconomica")
public class FichaSocioeconomicaController {

    @Autowired
    public IFichaService iFichaService;

    @GetMapping
    public List<SbeFichaSocioeconomicaDTO> getFichas(){
        return iFichaService.getFichas();
    }

    @PostMapping
    public SbeFichaSocioeconomicaDTO saveSituacionFamiliar(@RequestBody SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO){
      return iFichaService.saveFichaSocioeconomica(sbeFichaSocioeconomicaDTO);
    }

    @PutMapping
    public void updateFichaSocioeconomica(@RequestBody SbeFichaSocioeconomicaDTO sbeFichaSocioeconomicaDTO,@RequestParam Long codigo){
        iFichaService.updateFicha(sbeFichaSocioeconomicaDTO,codigo);
    }

    @DeleteMapping
    public void deleteFichaSocioeconomica(@RequestParam Long codigo){
        iFichaService.deleteFicha(codigo);
    }

    @GetMapping("/estadoFicha")
    public String obtenerEstadoFicha(@RequestParam String cedula){
        return iFichaService.estadoFicha(cedula);
    }

    /**
     * Metodo que me ayudará a resolver si el estudiante tiene una ficha devolviendome el codigo de la ficha
     * o nulo en el caso que no tenga aun una ficha
     * */
    @GetMapping("/getCodigoFicha")
    public Long obtenerCodigoFicha(@RequestParam String cedula){
        Long response = iFichaService.obtenerCodigoFichaAmpliada(cedula);
        return response;
    }


}
