import { sbeTipoParametroFicha } from "./tipoParametroFicha.model";

export interface sbeParametroFicha {
    codigo: number,
    tipo_parametro_ficha: sbeTipoParametroFicha,
    descripcion: string,
    vigente: string,
    etiqueta_mostrar: string,
    orden: number
}

