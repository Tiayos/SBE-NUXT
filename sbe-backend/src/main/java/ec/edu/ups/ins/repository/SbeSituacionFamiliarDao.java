package ec.edu.ups.ins.repository;
import ec.edu.ups.ins.entity.model.sbe.SbeSituacionFamiliarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SbeSituacionFamiliarDao extends JpaRepository<SbeSituacionFamiliarModel, Long> {

    @Query(value="select sif from SbeSituacionFamiliarModel sif where sif.sbeFichaSocioeconomicaModel.fisCodigo=?1 order by sif.sifCodigo desc")
    List<SbeSituacionFamiliarModel> obterSituacionesFamiliares(Long fisCodigo);

    @Query("SELECT MAX(c.sifCodigo) FROM SbeSituacionFamiliarModel c")
    Long obtenerUltimoIdSitFamiliar();
}
