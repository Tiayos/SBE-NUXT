package ups.edu.ups.sol.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ups.edu.ups.sol.model.sbe.SbeDocumentoSolicitadoFicha;

import java.util.List;

public interface DocumentosSolicitadosDao extends JpaRepository<SbeDocumentoSolicitadoFicha, Long> {

   // @Query("SELECT dsf FROM SbeDocumentoSolicitadoFicha dsf where dsf.fisCodigo = ?1 AND FUNCTION('TRUNC', CURRENT_DATE) BETWEEN FUNCTION('TRUNC', CURRENT_DATE) AND FUNCTION('TRUNC', dsf.docFechaLimiteEnvio)")
    @Query(nativeQuery = true, value = "SELECT * \n" +
            "FROM SBE.sbe_documento_solicitado_ficha dsf \n" +
            "WHERE dsf.fis_codigo =?1 \n" +
            "  AND TRUNC(SYSDATE) BETWEEN  TRUNC(SYSDATE) AND TRUNC(dsf.doc_fecha_limite_envio)")
    List<SbeDocumentoSolicitadoFicha> obtenerDocumentosSolicitados(Long fisCodigo);

    @Query(nativeQuery = true, value= "SELECT \n" +
            "    fis.fis_codigo\n" +
            "FROM\n" +
            "    sigac.CLIENTE_LOCAL cli,\n" +
            "    ins.INS_ALUMNO alu,\n" +
            "    SBE.SBE_FICHA_SOCIOECONOMICA fis\n" +
            "WHERE\n" +
            "    cli.CLLC_RUC = ?1\n" +
            "AND cli.CLLC_CDG = alu.CLLC_CDG\n" +
            "AND alu.ALU_CODIGO = fis.ALU_CODIGO\n" +
            "AND fis.TFS_CODIGO = 5\n" +
            "AND fis.AUD_ELIMINADO = 'N'")
    Long obtenerCodigoFichaAmpliada(String cedula);
}
