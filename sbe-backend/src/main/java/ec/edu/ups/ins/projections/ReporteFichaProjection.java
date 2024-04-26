package ec.edu.ups.ins.projections;

import java.util.Date;

public interface ReporteFichaProjection {

    Long getFIS_CODIGO();

    Date getAUD_FECHA_ADICION();

    String getCLLC_RUC();

    String getALU_APELLIDOS();

    String getALU_NOMBRES();
    String getALU_EMAIL();
    String getNACIONALIDAD();
    String getTIPO_SANGRE();
    String getRAZ_DESCRIPCION();
    String getESTADO_CIVIL();
    Long getTIPO_PARROQUIA_COD();
    String getTIPO_PARROQUIA_DES();
    Long getRESIDE_OTRO_LUGAR_COD();
    String getRESIDE_OTRO_LUGAR_DES();
    Long getTIPO_PARROQUIA_ESTUDIO_COD();
    String getTIPO_PARROQUIA_ESTUDIO_DES();
    Long getTRANSPORTE_QUE_USA_COD();
    String getTRANSPORTE_QUE_USA_DES();
    Long getFRECUENCIA_TRANSPORTE_COD();
    String getFRECUENCIA_TRANSPORTE_DES();
    Long getTIENE_OTROS_INGRESO_COD();
    String getTIENE_OTROS_INGRESO_DES();
    Long getINGRESOS_NO_REGISTRADOS_COD();
    String getINGRESOS_NO_REGISTRADOS_DES();
    Long getTENENCIA_VIVIENDA_COD();
    String getTENENCIA_VIVIENDA_DES();
    String getNIVEL_BECA();
    String getPAIS_DES();
    String getCIUDAD_DES();
    String getPARROQUIA_DES();
    String getBARRIO_DES();
    String getDIRECCION_DES();
    String getTELEFONO_DES();
    String getCELULAR_DES();
    String getWHATSAPP_DES();
    String getCORREO_PERSONAL_DES();
    String getCORREO_INSTITUCIONAL_DES();
    String getPAIS_ESTUDIO_DES();
    String getCIUDAD_ESTUDIO_DES();
    String getPARROQUIA_ESTUDIO();
    String getBARRIO_ESTUDIO();
    String getDIRECCION_ESTUDIO_DES();
    Long getNUM_MIEMBROS_GRUPO_FAM_DES();
    String getVAL_MENSUAL_OTROS_INGRESOS_DES();
    Long getNUMERO_INMUEBLES_DES();
    Long getNUMERO_VEHICULOS_DES();
    Long getCOSTO_TOTAL_INMUEBLES_DES();
    Long getCOSTO_TOTAL_VEHICULOS_DES();
    Long getCOSTO_TOTAL_DES();
    Long getVALOR_MENSUAL_ARRIENDO_DES();
    Long getVALOR_MENSUAL_HIPOTECA_DES();
    Long getOTRO_TIPO_TRANSPORTE_DES();
    Long getOTRO_TIPO_INGRESO_DES();
    Long getVIVE_CON_GRUPO_FAM_PROPIEDADES_DES();
    Long getVIVE_CON_GRUPO_FAM_VEHICULOS_DES();
    Long getVALOR_TOTAL_OTROS_INGRESOS_DES();
    Long getTOTAL_INGRESOS_MIEMBRO_FAM_DES();

    String getCOLEGIO();
    String getTIPO_COLEGIO();


}
