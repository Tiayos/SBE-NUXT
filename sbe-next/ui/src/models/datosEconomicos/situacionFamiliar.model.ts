import { EstadoCivil } from "./estadoCivil.model";
import { FichaSocioeconomica } from "./fichaSocioeconomica.model";
import { Instruccion } from "./instruccion.model";
import { Parentesco } from "./parentesco.model";
import { TipoEmpresa } from "./tipoEmpresa.model";

export interface SituacionFamiliar {
    codigo:                   number
    nombre_familiar:          string;
    fecha_nacimiento:         Date;
    tipo_situacion:           string;
    numero_identificacion:    string;
    ingresos_mensuales:       number;
    estado_civil:             EstadoCivil;
    ficha_socioeconomica:     FichaSocioeconomica;
    sbe_instruccionDTO:      Instruccion;
    sbe_parentescoDTO:        Parentesco;
    sbe_tipo_empresa:         TipoEmpresa;
}
