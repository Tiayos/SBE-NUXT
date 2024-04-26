package ups.edu.ups.sol.service;

import org.springframework.http.ResponseEntity;
import ups.edu.ups.sol.model.SolSolicitudEvento;
import ups.edu.ups.sol.response.SolicitudEventoResponseRest;

public interface SolSolicitudEventoService {
    public Integer obtenerPeriodoVigente(String cedula);

    public Integer  TieneFichaHabilitada(String cedula);

    public Long obtenerSolCodigo(String cedula, Long fisCodigo);

    ResponseEntity<SolicitudEventoResponseRest> verEventoSolicitud(Long codigoSolicitud);

    ResponseEntity<SolicitudEventoResponseRest> guardarNuevoEventoSolicitud(SolSolicitudEvento solSolicitudEvento);

    ResponseEntity<SolicitudEventoResponseRest> actualizarEventoSolicitud(SolSolicitudEvento solSolicitudEvento, Long codigo);

}
