package ups.edu.ups.sol.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ups.edu.ups.sol.projection.FichaAmpliadaProjection;
import ups.edu.ups.sol.projection.ParametrosNotificacion;
import ups.edu.ups.sol.model.SolSolicitudEvento;

import java.util.List;

public interface SolSolicitudEventoDao extends JpaRepository<SolSolicitudEvento, Long> {

    // METODO PARA OBTENER EL PERIODO VIGENTE SEGUN LA CÉDULA
    @Procedure(name = "obtenerPeriodo")
    Integer obtenerPeriodoLectivoVigente(@Param("cedula") String cedula);

    @Query("select max(soe.soeCodigo) from SolSolicitudEvento soe")
    Long obtenerUltimoIdSolicitudEvento();

    @Query(nativeQuery = true, value = "" +
            "SELECT\n" +
            "    TO_CHAR(TRUNC(fis.fis_fecha_fin_creacion), 'YYYY-MM-DD')\n" +
            "FROM\n" +
            "    sigac.CLIENTE_LOCAL cli,\n" +
            "    ins.INS_ALUMNO alu,\n" +
            "    SBE.SBE_FICHA_SOCIOECONOMICA fis\n" +
            "WHERE\n" +
            "    cli.CLLC_RUC = ?1\n" +
            "    AND cli.CLLC_CDG = alu.CLLC_CDG\n" +
            "    AND alu.ALU_CODIGO = fis.ALU_CODIGO\n" +
            "    AND fis.TFS_CODIGO = 5\n" +
            "    AND fis.AUD_ELIMINADO = 'N'")
    String obtenerFinFechaSolicitud(String cedula);

    //-- Consulta para obtener la Solicitud para las notificaciones
    @Query(nativeQuery = true, value = "SELECT \n" +
            "    sol.SOL_CODIGO                                               solCodigo,\n" +
            "    sol.TIS_CODIGO                                               tipoSolicitudCodigo,\n" +
            "    tis.TIS_DESCRIPCION                                          tipoSolicitudDescripcion,\n" +
            "    TO_CHAR(TRUNC(sol.SOL_FECHA), 'DD-MM-YYYY')                  solicitudFecha,\n" +
            "    alu.ALU_NOMBRES                                              aluNombres,\n" +
            "    alu.ALU_APELLIDOS                                            aluApellidos,\n" +
            "    alu.ALU_EMAIL                                                aluEmail,\n" +
            "    mai.MAI_DIRECCION                                            maiDireccion,\n" +
            "    (per.PER_NOMBRES || ' '|| per.PER_APELLIDOS)                 nombreTrabajadorSocial,\n" +
            "    maiAsignado.MAI_DIRECCION                                    maiDirectorTecnico,\n" +
            "    (perAsignado.PER_NOMBRES || ' '|| perAsignado.PER_APELLIDOS) nombreDirectorTecnico,\n" +
            "    soe.SOE_OBSERVACION                                          observacionSolicitud\n" +
            "FROM\n" +
            "    sol.SOL_SOLICITUD sol,\n" +
            "    sol.SOL_SOLICITUD_EVENTO soe,\n" +
            "    sol.SOL_SOLICITUD_PERSONA sop,\n" +
            "    ins.INS_ALUMNO alu,\n" +
            "    sigac.CLIENTE_LOCAL cli,\n" +
            "    sol.SOL_EJECUTOR_SOLICITUD eje,\n" +
            "    gth.GTH_PERSONA per,\n" +
            "    gth.GTH_MAIL mai,\n" +
            "    gth.GTH_PERSONA perAsignado,\n" +
            "    gth.GTH_MAIL maiAsignado,\n" +
            "    sol.SOL_TIPO_SOLICITUD tis\n" +
            "WHERE\n" +
            "    sol.SOL_CODIGO = soe.SOL_CODIGO\n" +
            "AND sol.SOL_CODIGO = sop.SOL_CODIGO\n" +
            "AND sop.ALU_CODIGO = alu.ALU_CODIGO\n" +
            "AND soe.SOE_ESTADO IN ('L', 'K')\n" +
            "AND sol.TIS_CODIGO = 108\n" +
            "AND soe.SOE_VIGENTE = 'S'\n" +
            "AND soe.AUD_ELIMINADO = 'N'\n" +
            "AND sol.AUD_ELIMINADO = 'N'\n" +
            "AND sol.PEL_CODIGO_CREACION = :pelCodigo \n" +
            "AND alu.CLLC_CDG = cli.CLLC_CDG\n" +
            "AND cli.CLLC_RUC = :cedulaEstudiante \n" +
            "AND eje.SOL_CODIGO = sol.SOL_CODIGO\n" +
            "AND eje.PER_CODIGO = mai.PER_CODIGO\n" +
            "AND mai.PER_CODIGO = per.PER_CODIGO\n" +
            "AND mai.TIM_CODIGO = 1          --1:INSTITUCIONAL\n" +
            "AND soe.PER_CODIGO = maiAsignado.PER_CODIGO\n" +
            "AND maiAsignado.PER_CODIGO = perAsignado.PER_CODIGO\n" +
            "AND maiAsignado.TIM_CODIGO = 1 \n" +
            "AND tis.TIS_CODIGO = sol.TIS_CODIGO\n" +
            "AND sol.SOL_CODIGO = :solCodigo ")
    ParametrosNotificacion obtenerSolTisCodigo(Integer pelCodigo, String cedulaEstudiante, Long solCodigo);

    @Query( "SELECT count(sol) " +
            "FROM SolSolicitud sol, " +
            "SolSolicitudEvento soe, " +
            "SolSolicitudPersona sop, " +
            "InsAlumno alu," +
            "ClienteLocal cli " +
            "WHERE sol.solCodigo = soe.solCodigo " +
            "AND sol.solCodigo = sop.solCodigo " +
            "AND sop.aluCodigo = alu.aluCodigo " +
            "AND soe.soeEstado = 'L' " +
            "AND sol.tisCodigo.tisCodigo = 108 " +
            "AND soe.soeVigente = 'S' " +
            "AND soe.audEliminado = 'N' " +
            "AND sol.audEliminado = 'N' " +
            "AND sol.pelCodigoCreacion =?1 " +
            "AND alu.cllcCdg.cllcCdg = cli.cllcCdg " +
            "AND cli.cllcRuc =?2")
    Integer obtenerRegistro(Integer pelCodigo, String cedula);

    //* Método para verificar si el estudiante tiene una ficha
    @Query("select fis.fisCodigo    as fisCodigo, " +
            "pel.pelCodigo          as pelCodigo, " +
            "pel.pelDescripcion     as pelDescripcion, " +
            "raf.rafDescripcion     as nivelBeca, " +
            "raf.rafPuntos          as puntosFicha " +
            "FROM SbeFichaSocioeconomica fis, ClienteLocal cli, InsAlumno alu, OrgPeriodoLectivo pel, SbeValoracionFicha vaf, SbeRangoFicha raf " +
            "WHERE cli.cllcRuc = ?1  " +
            "AND cli.cllcCdg = alu.cllcCdg " +
            "AND alu.aluCodigo = fis.aluCodigo " +
            "AND fis.sbeTipoFichaSocioeconomica.tfsCodigo = 5 " +
            "AND fis.audEliminado = 'N' " +
            "AND fis.pelCodigo = pel.pelCodigo " +
            "AND pel.audEliminado = 'N' " +
            "AND fis.fisCodigo = vaf.fisCodigo " +
            "AND vaf.audEliminado = 'N' " +
            "AND vaf.rafCodigo = raf.rafCodigo " +
            "AND raf.audEliminado = 'N' ")
    FichaAmpliadaProjection obtenerDatosFichaAmpliada(String cedulaEstudiante);


    @Query("select soe " +
            "FROM SolSolicitudEvento soe, " +
            "SolSolicitud sol " +
            "WHERE soe.soeEstado IN ('L','K') " +
            "AND soe.soeVigente = 'S' " +
            "AND soe.audEliminado = 'N' " +
            "AND soe.solCodigo = sol.solCodigo " +
            "AND sol.audEliminado = 'N' " +
            "AND sol.solCodigo = ?1")
    SolSolicitudEvento obtenerSolEventoPorSolicitud(Long codigoSolicitud);

    @Query("SELECT sol.solCodigo FROM SolSolicitud sol, " +
            "SolSolicitudEvento soe, " +
            "SolSolicitudPersona sop, " +
            "InsAlumno alu, " +
            "ClienteLocal cli, " +
            "SolEjecutorSolicitud eje, " +
            "SolTipoSolicitud tis, " +
            "SbeFichaSocioeconomica fis " +
            "   Where sol.solCodigo = soe.solCodigo " +
            "AND sol.solCodigo  = sop.solCodigo " +
            "AND sop.aluCodigo = alu.aluCodigo " +
            "AND sol.tisCodigo.tisCodigo = 108 " +
            "AND soe.soeVigente = 'S' " +
            "AND soe.audEliminado = 'N' " +
            "AND sol.audEliminado = 'N' " +
            "AND soe.soeEstado = 'L' " +
            "AND sol.pelCodigoCreacion = ?1 " +
            "AND alu.cllcCdg.cllcCdg = cli.cllcCdg " +
            "AND eje.solSolicitud.solCodigo =sol.solCodigo " +
            "AND tis.tisCodigo = sol.tisCodigo.tisCodigo " +
            "AND alu.aluCodigo = fis.aluCodigo " +
            "AND fis.fisCodigo = ?2 order by sol.solCodigo ASC")
    List<Long> obtenerSolCodigo(Integer pelCodigo, Long fisCodigo);


}
