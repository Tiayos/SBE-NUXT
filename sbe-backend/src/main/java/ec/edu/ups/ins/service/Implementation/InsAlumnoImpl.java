package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.model.ins.InsAlumno;
import ec.edu.ups.ins.projections.InsAlumnoProjection;
import ec.edu.ups.ins.repository.InsAlumnoDao;
import ec.edu.ups.ins.service.InsAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InsAlumnoImpl implements InsAlumnoService {

    @Autowired
    private InsAlumnoDao insAlumnoDao;

    @Override
    public List<InsAlumno> getAlumnosByEmail(String email) {
        return null;
    }

    @Override
    public InsAlumnoProjection getAlumnosByCedula(String cedula) {
        Integer periodoLectivo = insAlumnoDao.obtenerPerdiodoLectivoVigente(cedula);
        try {
            InsAlumnoProjection insAlumnoProjection =  insAlumnoDao.datosEstudiante(cedula, periodoLectivo);
            return insAlumnoProjection;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}


