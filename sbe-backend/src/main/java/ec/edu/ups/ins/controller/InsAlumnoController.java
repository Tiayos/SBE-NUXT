package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.projections.InsAlumnoProjection;
import ec.edu.ups.ins.service.InsAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/insAlumno")
public class InsAlumnoController {

    @Autowired
    public InsAlumnoService insAlumnoService;

    @GetMapping("/estudiante")
    public InsAlumnoProjection datosEstudiante(@RequestParam String cedula){
        return insAlumnoService.getAlumnosByCedula(cedula);
    }

}
