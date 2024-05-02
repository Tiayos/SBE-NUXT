import { TipoFichaSocioeconomica } from "./tipoFichaSocioeconomica";

export interface FichaSocioeconomica {
    fis_codigo: number;
    pel_codigo: number;
    alu_codigo: number;
    fecha:      Date;
    actualizar: string;
    estado:     string;
    version:    string;
    fecha_inicio_creacion:  Date;
    fecha_fin_creacion:     Date;
    est_codigo: number;
    sol_codigo: number;
    tipo_ficha: TipoFichaSocioeconomica;
}
