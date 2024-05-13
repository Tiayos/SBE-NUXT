import { TipoFichaSocioeconomica } from "../datosEconomicos/tipoFichaSocioeconomica";

export interface sbeFichaSocioeconomica {
    fis_codigo: number,
    pel_codigo: number,
    alu_codigo: number,
    fecha: Date | null,
    actualizar: string,
    estado: string,
    version: number,
    fecha_inicio_creacion: Date | null,
    fecha_fin_creacion: Date | null ,
    est_codigo: number | null,
    sol_codigo: number | null ,
    tipo_ficha: TipoFichaSocioeconomica,
    pel_codigo_valido_inicio: number | null 
}