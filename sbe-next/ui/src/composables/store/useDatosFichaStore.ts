import { insAlumnoProjection } from 'models/datosPersonales/alumno.model';
import { defineStore } from 'pinia';

export const useDatosFichaStore = defineStore('useDatosFichaStore', () => {
    const insAlumno = ref<insAlumnoProjection>({} as insAlumnoProjection)
    const cedula = ref<string>("");

    const sbeCamposWrapper = ref<SbeCamposWrapper>({
        pais: undefined,
        ciudad: undefined,
        parroquia: undefined,
        barrio: '',
        direccion: '',
        tlfDomicilio: '',
        tlfCelular: '',
        whatsapp: '',
        correoPersonal: '',
        correoInstitucional: '',
        paisEstudio: undefined,
        ciudadEstudio: undefined,
        parroquiaEstudio: undefined,
        barrioEstudio: '',
        direccionEstudiante: '',
    })

    const sbeParametros = ref<SbeParametros>({
        tipoParroquia: undefined,
        resideOtroLugar: undefined,
        tipoParroquiaEstudio: undefined,
        frecuenciaTransporte: undefined
    })

    return {
        insAlumno,
        cedula,
        sbeCamposWrapper,
        sbeParametros
    }

})