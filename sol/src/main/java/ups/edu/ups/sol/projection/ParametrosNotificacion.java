package ups.edu.ups.sol.projection;

import java.time.LocalDate;
import java.util.Date;

public interface ParametrosNotificacion {

    Long getSolCodigo();

    Long getTipoSolicitudCodigo();

    String getTipoSolicitudDescripcion();

    String getSolicitudFecha();

    String getAluNombres();

    String getAluApellidos();

    String getAluEmail();

    String getMaiDireccion();

    String getNombreTrabajadorSocial();

    String getMaiDirectorTecnico();

    String getNombreDirectorTecnico();

    String getObservacionSolicitud();

}
