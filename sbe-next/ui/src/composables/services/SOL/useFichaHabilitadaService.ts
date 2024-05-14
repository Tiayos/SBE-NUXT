export const useFichaHabilitadaService = () => {

    const config = useRuntimeConfig()
    const apiUrl = `${config.public.SOL_FICHA_HABILITADA}`

    //* METODO QUE ME AYUDA A RESOLVER SI EL ESTUDIANTE ESTÁ HABILITADO PARA LLENAR LA FICHA 0=INHABILITADO 1=HABILITADO
    const getFichaHabilitada = async (cedula: string):Promise<number> => {
        try {
            return await $fetch<number>(`${apiUrl}/fichaHabilitada?cedula=${cedula}`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }

    }

    return {
        getFichaHabilitada
    }
}