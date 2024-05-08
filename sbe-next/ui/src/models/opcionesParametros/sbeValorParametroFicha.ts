import { OpcionParametro } from "./OpcionParametro.model";
import { sbeFichaSocioeconomica } from "./sbeFichaSocioeconomica.model";

export interface sbeValorParametroFicha {
    codigo: number,
    pel_codigo_inicio: number,
    fecha_ingreso: Date,
    puntos: number,
    fis_codigo: sbeFichaSocioeconomica,
    opf_codigo: OpcionParametro
}

