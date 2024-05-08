import { sbeCampoFicha } from "./sbeCampoFicha";
import { sbeFichaSocioeconomica } from "./sbeFichaSocioeconomica.model";

export interface sbeValorCampoFicha {
    codigo: number,
    pel_codigo_inicio: number,
    vcf_texto: string,
    vcf_entero: number,
    vcf_decimal: number,
    vcf_fecha: Date,
    fecha_ingreso: Date,
    campo_ficha: sbeCampoFicha
    fis_codigo: sbeFichaSocioeconomica
}

