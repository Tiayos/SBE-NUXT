package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.projections.InsAlumnoProjection;
import ec.edu.ups.ins.service.InsAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/insAlumno")
public class InsAlumnoController {

    @Autowired
    public InsAlumnoService insAlumnoService;

    @GetMapping("/estudiante")
    public InsAlumnoProjection datosEstudiante(@RequestParam String cedula){
        return insAlumnoService.getAlumnosByCedula(cedula);
    }

//    //*Metodo para obtener el aluCodigo segun la cedula del estudiante
//        @GetMapping("/obtenerAluCodigo")
//    public ResponseEntity<Integer> obtenerAluCodigo(@RequestParam String cedula){
//        ResponseEntity<Integer> response = insAlumnoService.obtenerAluCodigoSegunCedula(cedula);
//        return response;
//    }
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex) {
//        String mensaje = ex.getParameterName() + " es requerido";
//        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
//    }

}
