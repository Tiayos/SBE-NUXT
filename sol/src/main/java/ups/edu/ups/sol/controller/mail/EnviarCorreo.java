package ups.edu.ups.sol.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ups.sol.service.EnviarCorreoService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/email")
public class EnviarCorreo {

    @Autowired
    public EnviarCorreoService enviarCorreoService;

    @PostMapping("/enviarCorreo")
    public ResponseEntity<?> enviarCorreo(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.enviarCorreo(cedula, codigoSolicitud);
    }

    @PostMapping("/enviarCorreoTrabajadorSocial")
    public ResponseEntity<?> enviarCorreoTrabajadorSocial(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.enviarCorreoTrabajadorSocial(cedula, codigoSolicitud);
    }

    @PostMapping("/notificarDocumentosSubidosEstudiante")
    public ResponseEntity<?> notificarDocumentosSubidos(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarDocumentosSubidos(cedula, codigoSolicitud);
    }
    @PostMapping("/notificarDocumentosPendientes")
    public ResponseEntity<?> notificarAnexo8(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo8(cedula, codigoSolicitud);
    }

    @PostMapping("/notificarInformeCaso")
    public ResponseEntity<?> notificarAnexo14(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo14(cedula, codigoSolicitud);
    }

    @PostMapping("/notificarAprobacionRecalculo")
    public ResponseEntity<?> notificarAnexo16Recalculo(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo16Recalculo(cedula, codigoSolicitud);
    }

    @PostMapping("/notificarNoAprobacionRecalculo")
    public ResponseEntity<?> notificarAnexo16NoRecalculo(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo16NoRecalculo(cedula, codigoSolicitud);
    }
    @PostMapping("/notificarAprobacionRecalculoEjecutor")
    public ResponseEntity<?> notificarAnexo17Recalculo(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo17Recalculo(cedula, codigoSolicitud);
    }
    @PostMapping("/notificarNoAprobacionRecalculoEjecutor")
    public ResponseEntity<?> notificarAnexo17NoRecalculo(@RequestParam String cedula, @RequestParam Long codigoSolicitud) {
        return enviarCorreoService.notificarAnexo17NoRecalculo(cedula, codigoSolicitud);
    }

}
