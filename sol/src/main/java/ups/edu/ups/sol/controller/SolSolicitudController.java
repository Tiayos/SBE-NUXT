package ups.edu.ups.sol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ups.sol.model.SolSolicitudEvento;
import ups.edu.ups.sol.response.SolicitudEventoResponseRest;
import ups.edu.ups.sol.service.SolSolicitudEventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/solicitudEvento")
public class SolSolicitudController {

    @Autowired
    SolSolicitudEventoService solSolicitudEventoService;

    @GetMapping("/obtenerPeriodo")
    public Integer obtenerPeriodo(@RequestParam String cedula){
        return solSolicitudEventoService.obtenerPeriodoVigente(cedula);
    }

    @GetMapping("/obtenerSolCodigo")
    public Long obtenerSolCodigo(@RequestParam String cedula, @RequestParam Long fisCodigo){
        return solSolicitudEventoService.obtenerSolCodigo(cedula,fisCodigo);
    }

    @GetMapping("/fichaHabilitada")
    public Integer fichaHabilitada(@RequestParam String cedula){
        return solSolicitudEventoService.TieneFichaHabilitada(cedula);
    }

    @GetMapping("/verEventoSolicitud")
    public ResponseEntity<SolicitudEventoResponseRest> obtenerEventoSolicitudEst(@RequestParam Long codigoSolicitud){
        ResponseEntity<SolicitudEventoResponseRest> response = solSolicitudEventoService.verEventoSolicitud(codigoSolicitud);
        return response;
    }

    @PostMapping("/insertarEventoSolicitud")
    public ResponseEntity<SolicitudEventoResponseRest> guardarEventoSolicitudEst(@RequestBody SolSolicitudEvento solSolicitudEvento){
        ResponseEntity<SolicitudEventoResponseRest> response = solSolicitudEventoService.guardarNuevoEventoSolicitud(solSolicitudEvento);
        return response;
    }

    @PutMapping("/actualizarEventoSolicitud")
    public ResponseEntity<SolicitudEventoResponseRest> actualizarEventoSolicitudEst(@RequestBody SolSolicitudEvento solSolicitudEvento, @RequestParam Long id){
        ResponseEntity<SolicitudEventoResponseRest> response = solSolicitudEventoService.actualizarEventoSolicitud(solSolicitudEvento, id);
        return response;
    }

}
