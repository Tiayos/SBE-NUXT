package ec.edu.ups.ins.projections;

import java.time.LocalDate;

public interface FichaAmpliadaProjection {

    Long getFisCodigo();
    String getFisEstado();
    LocalDate getFisFechaFinCreacion();
    Long getPelCodigo();
    String getPelDescripcion();
    Long getEstCodigo();
    Long getAluCodigo();
    String getAluIdentificacion();
    String getAluNombreCompleto();
    Long getEstadoFichaCodigo(); //Estado de la Ficha 5:Tramitado
    Long getSolCodigo(); //Codigo de la solicitud

    //    AlumnoProjection getAlumno();
}
