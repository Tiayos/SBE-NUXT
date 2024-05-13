import { FichaSocioeconomica } from "~/models/datosEconomicos/fichaSocioeconomica.model"
import { sbeFichaSocioeconomica } from "~/models/opcionesParametros/sbeFichaSocioeconomica.model"

export const useFichaService = () => {
    const config = useRuntimeConfig()
    const apiUrl = `${config.public.SBE_FICHA}`
    const apiUrlSol = `${config.public.SOL_FICHA_EMAIL}`
    const apiUrlSolCode = `${config.public.SOL_FICHA_HABILITADA}`
//* crea una ficha al iniciar la aplicación
const crearNuevaFicha = async (sbeFichaAmpliada: sbeFichaSocioeconomica) => {
    try {
        return await $fetch<sbeFichaSocioeconomica>(
            apiUrl,
            {
                method: 'POST',
                body: sbeFichaAmpliada,
                headers: {
                    'Content-Type': 'application/json',
                },
            }
        )
    } catch (error) {
        logger.error('FichaSocioeconomica', error)
        throw error
    }
}

const obtenerSolCodigo = async (cedula: string, fisCodigo: number) => {
    try {
        const resp = await $fetch<number>(
            apiUrlSolCode + `/obtenerSolCodigo?cedula=${cedula}&fisCodigo=${fisCodigo}`,
        )
        return resp
    } catch (error) {
        logger.error('saveSituacionFamiliar', error)
        throw error
    }
}


    return {
        crearNuevaFicha,
        obtenerSolCodigo
    }
}