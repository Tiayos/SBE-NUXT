import { DatosDomicilioProjection } from '../../models/datosDomicilio/datosDomicilio.model';

export const useDatosDomicilioService = () => {
    const config = useRuntimeConfig()
    const apiUrl =  `${config.public.SBE_DOMICILIO}`

    const getPaises = async ():Promise<DatosDomicilioProjection[]> => {
        try {
            return await $fetch<DatosDomicilioProjection[]>(`${apiUrl}/getPaises`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getCiudades = async (codigoPais: number):Promise<DatosDomicilioProjection[]> => {
        try {
            return await $fetch<DatosDomicilioProjection[]>(`${apiUrl}/getCiudades?codigoPais=${codigoPais}`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    const getParroquias = async (codigoCiudad: number):Promise<DatosDomicilioProjection[]> => {
        try {
            return await $fetch<DatosDomicilioProjection[]>(`${apiUrl}/getParroquias?codigoCiudad=${codigoCiudad}`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }

    }

    return {
        getPaises,
        getCiudades,
        getParroquias
    }
}