package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.entity.dto.SbeOpcionParametroFichaDTO;
import ec.edu.ups.ins.service.IOpcionParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/valorParametros")
public class ValorParametroFichaController {

    @Autowired
    public IOpcionParametroService opcionParametroService;

    //* LISTA TODAS LAS OPCIONES VALOR CAMPO DEPENDIENDO DEL CODIGO DEL PARAMETRO
    @GetMapping("/getOpcionesParametro")
    public List<SbeOpcionParametroFichaDTO> getOpcionesParametro(@RequestParam Long codigoParametro){
        return opcionParametroService.getOpcionesParametroByCodigo(codigoParametro);
    }

}
