package ups.edu.ups.sol.service;


import org.springframework.http.ResponseEntity;

public interface EnviarCorreoService {

     public ResponseEntity<?> enviarCorreoTrabajadorSocial(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> enviarCorreo(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarDocumentosSubidos(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo8(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo14(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo16Recalculo(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo16NoRecalculo(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo17Recalculo(String cedula, Long codigoSolicitud);

     public ResponseEntity<?> notificarAnexo17NoRecalculo(String cedula, Long codigoSolicitud);

}
