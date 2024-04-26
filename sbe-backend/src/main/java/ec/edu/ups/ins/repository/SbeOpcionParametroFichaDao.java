package ec.edu.ups.ins.repository;
import ec.edu.ups.ins.entity.model.sbe.SbeOpcionParametroFichaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SbeOpcionParametroFichaDao extends JpaRepository<SbeOpcionParametroFichaModel, Long> {
    @Query("SELECT par FROM SbeOpcionParametroFichaModel par WHERE par.sbeParametroFichaModel.pafCodigo = ?1")
    List<SbeOpcionParametroFichaModel> obtenerOpcionesParametroByCodigo(Long codigoParametro);

}
