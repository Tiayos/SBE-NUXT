package ec.edu.ups.ins.service;
import ec.edu.ups.ins.entity.model.ins.InsAlumno;
import ec.edu.ups.ins.projections.InsAlumnoProjection;

import java.util.List;

public interface InsAlumnoService {

    List<InsAlumno> getAlumnosByEmail(String email);

    InsAlumnoProjection getAlumnosByCedula(String cedula);

}
