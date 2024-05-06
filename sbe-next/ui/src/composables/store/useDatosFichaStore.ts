import { defineStore } from 'pinia';
import { SituacionFamiliar } from '~/models/datosEconomicos/situacionFamiliar.model';
import { insAlumnoProjection } from '~/models/datosPersonales/alumno.model';

export const useDatosFichaStore = defineStore('useDatosFichaStore', () => {
    const insAlumno = ref<insAlumnoProjection>({} as insAlumnoProjection)
    const cedula = ref<string>("");
    const miembroGrupoFamiliar = ref<SituacionFamiliar>({} as SituacionFamiliar);

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
        otraFrecuenciaEspecifique: '',
        numeroMiembros: undefined
    })

    const sbeParametros = ref<SbeParametros>({
        tipoParroquia: undefined,
        resideOtroLugar: undefined,
        tipoParroquiaEstudio: undefined,
        tipoTransporte: undefined
    })

    return {
        insAlumno,
        cedula,
        sbeCamposWrapper,
        sbeParametros,
        miembroGrupoFamiliar
    }

})