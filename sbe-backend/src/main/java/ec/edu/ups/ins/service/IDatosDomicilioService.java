package ec.edu.ups.ins.service;

import ec.edu.ups.ins.projections.DatosDomicilioProjection;

import java.util.List;

public interface IDatosDomicilioService {

    List<DatosDomicilioProjection> getPaises();
    List<DatosDomicilioProjection> getCiudades(Long codigoPais);
    List<DatosDomicilioProjection> getParroquias(Long codigCiudad);

}
