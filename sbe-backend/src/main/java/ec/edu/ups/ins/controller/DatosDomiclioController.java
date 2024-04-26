package ec.edu.ups.ins.controller;

import ec.edu.ups.ins.projections.DatosDomicilioProjection;
import ec.edu.ups.ins.service.IDatosDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/datosDomicilio")
public class DatosDomiclioController {
    @Autowired
    public IDatosDomicilioService datosDomicilioService;


    @GetMapping("/getPaises")
    public List<DatosDomicilioProjection> getPaises(){
        List<DatosDomicilioProjection> response = datosDomicilioService.getPaises();
        return response;
    }

    @GetMapping("/getCiudades")
    public List<DatosDomicilioProjection> getCiudades(@RequestParam Long codigoPais){
        List<DatosDomicilioProjection> response = datosDomicilioService.getCiudades(codigoPais);
        return response;
    }

    @GetMapping("/getParroquias")
    public List<DatosDomicilioProjection> getParroquias(@RequestParam Long codigoCiudad){
        List<DatosDomicilioProjection> response = datosDomicilioService.getParroquias(codigoCiudad);
        return response;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex) {
        String mensaje = ex.getParameterName() + " es requerido";
        return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
    }



}
