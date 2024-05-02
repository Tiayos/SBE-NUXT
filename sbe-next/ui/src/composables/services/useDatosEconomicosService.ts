import { EstadoCivil } from 'models/datosEconomicos/estadoCivil.model';
import { SituacionFamiliar } from '../../models/datosEconomicos/situacionFamiliar.model';
import { Parentesco } from 'models/datosEconomicos/parentesco.model';
import { Instruccion } from 'models/datosEconomicos/instruccion.model';
import { TipoEmpresa } from 'models/datosEconomicos/tipoEmpresa.model';

export const useDatosEconomicosService = () => {
    const config = useRuntimeConfig()
    const apiUrl = `${config.public.SBE_SITUACION_FAMILIAR}`

    const getDatosEconomicosMiembrosFamiliares = async (fisCodigo:number):Promise<SituacionFamiliar[]> => {
        try {
            const response = await $fetch<SituacionFamiliar[]>(`${apiUrl}?fisCodigo=${fisCodigo}`);
            return response;
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getEstadoCivil = async ():Promise<EstadoCivil[]> => {
        try {
            return await $fetch<EstadoCivil[]>(`${apiUrl}/getEstadoCivil`);
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getParentescos = async ():Promise<Parentesco[]> => {
        try {
            return await $fetch<Parentesco[]>(`${apiUrl}/getParentescos`);
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getNivelInstruccion = async ():Promise<Instruccion[]> => {
        try {
            return await $fetch<Instruccion[]>(`${apiUrl}/getNivelInstruccion`);
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getTipoEmpresa = async ():Promise<TipoEmpresa[]> => {
        try {
            return await $fetch<TipoEmpresa[]>(`${apiUrl}/getTiposEmpresas`);
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    return {
        getDatosEconomicosMiembrosFamiliares,
        getTipoEmpresa,
        getNivelInstruccion,
        getEstadoCivil,
        getParentescos

    }
}