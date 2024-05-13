package ec.edu.ups.ins.repository;
import ec.edu.ups.ins.entity.model.sbe.SbeFichaSocioeconomicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SbeFichaSocioeconomicaDao extends JpaRepository<SbeFichaSocioeconomicaModel, Long> {

    @Query("SELECT MAX(fis.fisCodigo) FROM SbeFichaSocioeconomicaModel fis")
    Long obtenerUltimoIdFichaSocioeconomica();

    @Query(nativeQuery = true, value="SELECT sol.PEL_CODIGO_VALIDO\n" +
            "FROM\n" +
            "    sol.sol_solicitud sol,\n" +
            "    sol.sol_solicitud_evento soe,\n" +
            "    sol.sol_solicitud_persona sop,\n" +
            "    ins.ins_alumno alu\n" +
            "WHERE\n" +
            "    sol.sol_codigo = soe.sol_codigo\n" +
            "AND sol.sol_codigo = sop.sol_codigo\n" +
            "AND sop.alu_codigo = alu.alu_codigo\n" +
            "AND soe.soe_estado = ('L')\n" +
            "AND sol.tis_codigo = 108\n" +
            "AND soe.soe_vigente = 'S'\n" +
            "AND soe.aud_eliminado = 'N'\n" +
            "AND sol.aud_eliminado = 'N'\n" +
            "AND alu.ALU_CODIGO = ?1\n" +
            "ORDER BY sol.SOL_CODIGO DESC")
    Long obtenerPeriodoValidaSolicitud(Long aluCodigo);
}
