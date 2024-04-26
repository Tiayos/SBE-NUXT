package ec.edu.ups.ins.service.Implementation;

import ec.edu.ups.ins.entity.dto.SbeOpcionParametroFichaDTO;
import ec.edu.ups.ins.repository.SbeOpcionParametroFichaDao;
import ec.edu.ups.ins.service.IOpcionParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OpcionParametroImpl implements IOpcionParametroService {

    @Autowired
    public SbeOpcionParametroFichaDao sbeOpcionParametroFichaDao;

    @Override
    @Transactional(readOnly = true)
    public List<SbeOpcionParametroFichaDTO> getOpcionesParametroByCodigo(Long codigoParametro) {
        return sbeOpcionParametroFichaDao.obtenerOpcionesParametroByCodigo(codigoParametro)
                .stream()
                .map(SbeOpcionParametroFichaDTO::toDTO)
                .toList();
    }

}
