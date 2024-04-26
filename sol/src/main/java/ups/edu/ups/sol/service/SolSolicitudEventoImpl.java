package ups.edu.ups.sol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ups.edu.ups.sol.dao.SolSolicitudEventoDao;
import ups.edu.ups.sol.model.SolSolicitudEvento;
import ups.edu.ups.sol.response.SolicitudEventoResponseRest;

import java.util.List;
import java.util.Optional;

@Service
public class SolSolicitudEventoImpl implements SolSolicitudEventoService{

    @Autowired
    SolSolicitudEventoDao solSolicitudEventoDao;

    //*Servicio para saber el periodo lectivo vigente
    @Override
    @Transactional(readOnly = true)
    public Integer obtenerPeriodoVigente(String cedula) {
        Integer resp = solSolicitudEventoDao.obtenerPeriodoLectivoVigente(cedula);
        return resp;
    }

    //*Servicio para saber si el alumno esta habilitado para llenar una ficha
    @Override
    @Transactional(readOnly = true)
    public Integer TieneFichaHabilitada( String cedula) {
        Integer pelCodigo = solSolicitudEventoDao.obtenerPeriodoLectivoVigente(cedula);
        Integer resp = solSolicitudEventoDao.obtenerRegistro(pelCodigo, cedula);
        if(resp!=null){
            return resp;
        }else {
            return 0;
        }
    }

    @Override
    public Long obtenerSolCodigo(String cedula, Long fisCodigo) {
        Integer pelCodigo = solSolicitudEventoDao.obtenerPeriodoLectivoVigente(cedula);
        List<Long> solCodigos =  solSolicitudEventoDao.obtenerSolCodigo(pelCodigo, fisCodigo);

        return solCodigos.get(0);
    }

    @Override
    public ResponseEntity<SolicitudEventoResponseRest> verEventoSolicitud(Long codigoSolicitud) {
        SolicitudEventoResponseRest response = new SolicitudEventoResponseRest();
        try {
            SolSolicitudEvento solEvento = solSolicitudEventoDao.obtenerSolEventoPorSolicitud(codigoSolicitud);
            response.getSolicitudEventoResponse().setSolSolicitudEvento(solEvento);
            response.agregarMetadata("ok","200", "se obtuvo una Solicitud Evento");

        } catch (Exception e) {
            response.agregarMetadata("respuesta no ok", "-1", "Error al obtener la Solicitud Evento");
            e.getStackTrace();
        }
        return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.OK); // devuelve 200
    }

    @Override
    @Transactional
    public ResponseEntity<SolicitudEventoResponseRest> guardarNuevoEventoSolicitud(SolSolicitudEvento solSolicitudEvento) {
        SolicitudEventoResponseRest response = new SolicitudEventoResponseRest();
        Long id = solSolicitudEventoDao.obtenerUltimoIdSolicitudEvento() + 1;
        solSolicitudEvento.setSoeCodigo(id);
        solSolicitudEvento.setSoeEstado("K"); //Tramitado cerrado
        solSolicitudEvento.setSoeTipo("P");
        solSolicitudEvento.setSoeVigente("S");

        try {
            SolSolicitudEvento solicitudEvento = solSolicitudEventoDao.save(solSolicitudEvento);
            if( solicitudEvento != null ){
                response.getSolicitudEventoResponse().setSolSolicitudEvento(solicitudEvento);
            }else {
                response.agregarMetadata("respuesta no Ok", "-1", "Ficha no guardada");
                return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            response.agregarMetadata("respuesta no Ok", "-1", "Error al insertar una ficha");
            return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.agregarMetadata("respuesta ok", "00", "Evento solicitud creado");
        return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.OK); // devuelve 200 }
    }

    @Override
    public ResponseEntity<SolicitudEventoResponseRest> actualizarEventoSolicitud(SolSolicitudEvento solSolicitudEvento, Long id) {
        SolicitudEventoResponseRest response = new SolicitudEventoResponseRest();
        try {
            Optional<SolSolicitudEvento> solicitudEvento = solSolicitudEventoDao.findById(id);
            if (solicitudEvento.isPresent()) {
                solicitudEvento.get().setSoeVigente(solSolicitudEvento.getSoeVigente());//Se deshabilita la vigencia

                SolSolicitudEvento solEvento = solSolicitudEventoDao.save(solicitudEvento.get());
                if (solEvento != null ) {
                    response.getSolicitudEventoResponse().setSolSolicitudEvento(solEvento);
                } else {
                    response.agregarMetadata("respuesta no ok", "-1", "No se actualizó correctamente");
                }
            } else {
                response.agregarMetadata("respuesta no Ok", "-1", "Miembro-situacion-familiar no encontrado");
                return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.agregarMetadata("respuesta no Ok", "-1", "error al actualizar Situacion familiar");
            return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.agregarMetadata("respuesta ok", "200", "Situacion Familiar actualizado");
        return new ResponseEntity<SolicitudEventoResponseRest>(response, HttpStatus.OK); // devuelve 200 }    }
    }

}
