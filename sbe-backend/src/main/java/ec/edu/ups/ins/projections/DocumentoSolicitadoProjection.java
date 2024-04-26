package ec.edu.ups.ins.projections;

import java.time.LocalDate;

public interface DocumentoSolicitadoProjection {

    Long getFisCodigo();

    String getFisEstado();

    LocalDate getFisFechaFinCreacion();

    Long getPelCodigo();

    String getPelDescripcion();

    Long getEstCodigo();

    Long getAluCodigo();

    String getAluIdentificacion();

    String getAluNombreCompleto();

    //    AlumnoProjection getAlumno();
}
