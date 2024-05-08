import { sbeTipoParametroFicha } from "./tipoParametroFicha.model";

export interface sbeCampoFicha {
    codigo: number,
    descripcion: string,
    tipo: string,
    etiqueta: string,
    orden: number,
    tipo_parametro: sbeTipoParametroFicha
}

