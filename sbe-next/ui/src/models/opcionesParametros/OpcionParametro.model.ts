import { sbeParametroFicha } from "./sbeParametroFicha.model";

export interface OpcionParametro {
    codigo: number,
    parametro_ficha: sbeParametroFicha
    descripcion: string,
    etiqueta_mostrar: string
}

