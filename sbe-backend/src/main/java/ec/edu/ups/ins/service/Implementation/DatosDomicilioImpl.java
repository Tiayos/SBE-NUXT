package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.projections.DatosDomicilioProjection;
import ec.edu.ups.ins.repository.OrgEstructuraDao;
import ec.edu.ups.ins.service.IDatosDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DatosDomicilioImpl implements IDatosDomicilioService {

    @Autowired
    private OrgEstructuraDao orgEstructuraDao;

    @Override
    public List<DatosDomicilioProjection> getPaises() {
        try{
            List<DatosDomicilioProjection> datosDomicilioProjections = orgEstructuraDao.getPaises();
            return datosDomicilioProjections;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DatosDomicilioProjection> getCiudades(Long codigoPais) {
        try{
            List<DatosDomicilioProjection> datosDomicilioProjections = orgEstructuraDao.getCiudades(codigoPais);
            return datosDomicilioProjections;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DatosDomicilioProjection> getParroquias(Long codigCiudad) {
        try{
            List<DatosDomicilioProjection> datosDomicilioProjections = orgEstructuraDao.getParroquias(codigCiudad);
            return datosDomicilioProjections;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}


