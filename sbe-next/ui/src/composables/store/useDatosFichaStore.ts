import { insAlumnoProjection } from 'models/datosPersonales/alumno.model';
import { defineStore } from 'pinia';

export const useDatosFichaStore = defineStore('useDatosFichaStore', () => {
    const insAlumno = ref<insAlumnoProjection>({} as insAlumnoProjection)
    const cedula = ref<string>("");

    const sbeCamposWrapper = ref<SbeCamposWrapper>({
        barrio: '',
        direccion: '',
        tlfDomicilio: '',
        tlfCelular: '',
        whatsapp: '',
        correoPersonal: '',
        correoInstitucional: ''
    })

    const sbeParametros = ref<SbeParametros>({
        pais: undefined,
        ciudad: undefined,
        parroquia: undefined,
        tipoParroquia: undefined
    })

    return {
        insAlumno,
        cedula,
        sbeCamposWrapper,
        sbeParametros
    }

})