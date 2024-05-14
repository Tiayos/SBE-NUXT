
import sbeParametrosCodigosEnum from "@/utils/sbeParametrosCodigos";
import { DatosDomicilioProjection } from "~/models/datosDomicilio/datosDomicilio.model";
import { OpcionParametro } from "~/models/opcionesParametros/OpcionParametro.model";

export const useDatosDomicilio = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { sbeCamposWrapper, sbeParametros, insAlumno } = storeToRefs(storeClient)
    
    //* Datos domicilio 2.1
    const { getPaises, getCiudades, getParroquias } = useDatosDomicilioService()
    const paisesList = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection] )
    const ciudadesList = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection])
    const parroquiasList = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection])

    const { getOpcionesParametros } = useValorParametrosService()
    const getTipoParroquiasList = ref<OpcionParametro[]>([{} as OpcionParametro])

    //* Datos domicilio 2.2
    const paisesListEstudio = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection] )
    const ciudadesListEstudio = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection])
    const parroquiasListEstudio = ref<DatosDomicilioProjection[]>([{} as DatosDomicilioProjection])

    const getTipoParroquiasListEstudio = ref<OpcionParametro[]>([{} as OpcionParametro])

    const selectSiNo = ref<number>(0)


    onMounted(async() => {
        paisesList.value = await getPaises();
        getTipoParroquiasList.value = await getOpcionesParametros(sbeParametrosCodigosEnum.tiposParroquias);
    
        paisesListEstudio.value = await getPaises();
        getTipoParroquiasListEstudio.value = await getOpcionesParametros(sbeParametrosCodigosEnum.tiposParroquiaEstudio);
    })

    watch(() => insAlumno.value.email, (newValue, oldValue) => {
        storeClient.llenarCampo(sbeCampoCodigos.CORREO_INSTITUCIONAL, insAlumno.value.email, 'TEXTO')
    })

    watch(() => sbeCamposWrapper.value, async (newValue, oldValue) => {
        if (newValue && sbeCamposWrapper.value.pais) {
            ciudadesList.value = await getCiudades(sbeCamposWrapper.value.pais);
        }
        if (newValue && sbeCamposWrapper.value.ciudad) {
            parroquiasList.value = await getParroquias(sbeCamposWrapper.value.ciudad);
        }
        if (newValue && sbeCamposWrapper.value.paisEstudio) {
            ciudadesListEstudio.value = await getCiudades(sbeCamposWrapper.value.paisEstudio);
        }
        if (newValue && sbeCamposWrapper.value.ciudadEstudio) {
            parroquiasListEstudio.value = await getParroquias(sbeCamposWrapper.value.ciudadEstudio);
        }
    }, { deep: true });

    watch(() => selectSiNo.value, (newValue, oldValue) => {
                    selectSiNo.value = parseInt(selectSiNo.value.toString())

    })

    return {
        insAlumno,
        paisesList,
        ciudadesList,
        parroquiasList,
        getTipoParroquiasList,
        paisesListEstudio,
        ciudadesListEstudio,
        parroquiasListEstudio,
        getTipoParroquiasListEstudio,
        
        sbeCamposWrapper,
        sbeParametros,
        selectSiNo,
        storeClient,
        getOpcionesParametros
    }

}

export default useDatosDomicilio;