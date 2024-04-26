import { OpcionParametro } from "models/opcionesParametros/OpcionParametro.model"

export const useValorParametrosService = () => {

    const config = useRuntimeConfig()
    const apiUrl =  `${config.public.SBE_VALORES_PARAMETRO}`

    const getOpcionesParametros = async(pafCodigo: number):Promise<OpcionParametro[]> => {
        try {
            return await $fetch<OpcionParametro[]>(`${apiUrl}/getOpcionesParametro?codigoParametro=${pafCodigo}`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    return {
        getOpcionesParametros,
    }
}