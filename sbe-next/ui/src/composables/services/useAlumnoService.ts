import { insAlumnoProjection } from "models/datosPersonales/alumno.model"

export const useAlumnoService = () => {
    const config = useRuntimeConfig()
    const apiUrl = `${config.public.SBE_ALUMNO}`

    const getDatosPersonales = async(cedula:string) => {
        try {
            return await $fetch<insAlumnoProjection>(`${apiUrl}/estudiante?cedula=${cedula}`)
        } catch (error) {
            logger.error('BadRequest', error)
            throw error
        }
    }

    return {
        getDatosPersonales,
    }
}