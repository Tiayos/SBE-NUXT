package ec.edu.ups.ins.repository;

import ec.edu.ups.ins.entity.model.ins.InsAlumno;
import ec.edu.ups.ins.projections.InsAlumnoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface InsAlumnoDao extends JpaRepository<InsAlumno, Long> {

    @Query(nativeQuery = true, value=" select \n" +
            "              i.alu_codigo as aluCodigo,\n" +
            "              cli.cllc_ruc as identificacion,\n" +
            "              cli.cllc_nmb as nombre,\n" +
            "              esv.esc_descripcion estadoCivil,\n" +
            "              i.alu_email as email,\n" +
            "              tis.tis_descripcion as tipoSangre,\n" +
            "              raz.raz_descripcion as etnia,\n" +
            "              i.alu_nacionalidad as nacionalidad,\n" +
            "              ied.ine_descripcion as institucionEducativa,\n" +
            "              tin.tie_descripcion tipoInstitucion,\n" +
            "              cli.cllc_calle as direccion,\n" +
            "              NVL(  \n" +
            "              (         \n" +
            "         SELECT             RAF1.RAF_QUINTIL\n" +
            "         FROM             \n" +
            "         SBE.SBE_FICHA_SOCIOECONOMICA FIS1,\n" +
            "         SBE.SBE_VALORACION_FICHA VAF1,\n" +
            "         SBE.SBE_RANGO_FICHA RAF1\n" +
            "         WHERE\n" +
            "             FIS1.FIS_CODIGO = VAF1.FIS_CODIGO\n" +
            "         AND RAF1.RAF_CODIGO = VAF1.RAF_CODIGO\n" +
            "         AND FIS1.ALU_CODIGO = i.ALU_CODIGO\n" +
            "         AND FIS1.FIS_VERSION = 1\n" +
            "         AND VAF1.PEL_CODIGO = ?2 --PARAMETRO DEL PERIODO         \n" +
            "         ), 0) as QUINTIL_V1,    \n" +
            "         NVL(         (         SELECT             RAF2.RAF_QUINTIL\n" +
            "         FROM             \n" +
            "         SBE.SBE_FICHA_SOCIOECONOMICA FIS2,\n" +
            "         SBE.SBE_VALORACION_FICHA VAF2,\n" +
            "         SBE.SBE_RANGO_FICHA RAF2\n" +
            "         WHERE            \n" +
            "             FIS2.FIS_CODIGO = VAF2.FIS_CODIGO\n" +
            "         AND RAF2.RAF_CODIGO = VAF2.RAF_CODIGO\n" +
            "         AND FIS2.ALU_CODIGO = i.ALU_CODIGO\n" +
            "         AND FIS2.FIS_VERSION = 2         \n" +
            "         AND VAF2.PEL_CODIGO <= ?2 --PARAMETRO DEL PERIODO         \n" +
            "         AND (    VAF2.PEL_CODIGO_FIN IS NULL   OR  VAF2.PEL_CODIGO_FIN >= ?2) --PARAMETRO DEL PERIODO         \n" +
            "         ), 0) as QUINTIL_V2\n" +
            "              \n" +
            "    from ins.ins_alumno i,\n" +
            "         sigac.cliente_local cli,\n" +
            "         ins.ins_estado_civil esv,\n" +
            "         ins.ins_tipo_sangre tis,\n" +
            "         ins.ins_raza raz,\n" +
            "           ins.ins_alu_ins_edu ine,\n" +
            "         ins.ins_institucion_educativa ied,\n" +
            "         ins.ins_tip_ins_edu  tin\n" +
            "    where \n" +
            "        CLI.CLLC_RUC = ?1\n" +
            "    and i.cllc_cdg = cli.cllc_cdg\n" +
            "    and i.esc_codigo = esv.esc_codigo\n" +
            "    and i.tis_codigo = tis.tis_codigo\n" +
            "    and i.raz_codigo = raz.raz_codigo\n" +
            "    and ine.alu_codigo = i.alu_codigo\n" +
            "    and ine.ine_codigo = ied.ine_codigo\n" +
            "    and ied.tie_codigo = tin.tie_codigo\n" +
            "    and ine.aie_vigente='S'\n")
    InsAlumnoProjection datosEstudiante(String cedula, Integer periodoLectivo);
    @Procedure(name = "obtenerPeriodo")
    Integer obtenerPerdiodoLectivoVigente(@Param("cedula") String cedula);

}
