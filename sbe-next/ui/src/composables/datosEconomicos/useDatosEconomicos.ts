import { useDatosEconomicosService } from '../services/useDatosEconomicosService';;
import { useVuelidate, ValidationRuleWithParams  } from '@vuelidate/core';
import { ErrorMessage } from 'vee-validate';
import { required, is_not } from "@vee-validate/rules";
import { SituacionFamiliar } from '~/models/datosEconomicos/situacionFamiliar.model';
import { Instruccion } from '~/models/datosEconomicos/instruccion.model';
import { Parentesco } from '~/models/datosEconomicos/parentesco.model';
import { TipoEmpresa } from '~/models/datosEconomicos/tipoEmpresa.model';
import { EstadoCivil } from '~/models/datosEconomicos/estadoCivil.model';
import { FichaSocioeconomica } from '~/models/datosEconomicos/fichaSocioeconomica.model';

export const useDatosEconomicos = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { sbeCamposWrapper, sbeParametros} = storeToRefs(storeClient)
    //* Datos economicos 3.2 
    const { getDatosEconomicosMiembrosFamiliares, getNivelInstruccion, getParentescos, getTipoEmpresa } = useDatosEconomicosService()
    const datosEconomicosMiembrosFamiliarList = ref<SituacionFamiliar[]>([{} as SituacionFamiliar] )
    const nivelesInstruccionList = ref<Instruccion[]>([{} as Instruccion]);
    const parentescosList = ref<Parentesco[]>([{} as Parentesco]);
    const tipoEmpresaList = ref<TipoEmpresa[]>([{} as TipoEmpresa]);
    const miembroGrupoFamiliar = ref<SituacionFamiliar>({
        nombre_familiar:          "",
        fecha_nacimiento:         new Date,
        tipo_situacion:           "",
        numero_identificacion:    "",
        ingresos_mensuales:       0,
        estado_civil:             {codigo: 0} as EstadoCivil,
        ficha_socioeconomica:     {} as FichaSocioeconomica,
        sbe_instruccionDTO:       {codigo: 0} as Instruccion,
        sbe_parentescoDTO:        {codigo: 0} as Parentesco,
        sbe_tipo_empresa:         {codigo: 0} as TipoEmpresa
    });

    //*Validate
    const validateSituacionFamiliar = {
        nombre_familiar:          { required },
        fecha_nacimiento:         { required },
        numero_identificacion:    { required },
        ingresos_mensuales:       { required },
        sbe_instruccionDTO:       { required },
        sbe_parentescoDTO:        { required },
        sbe_tipo_empresa:         { required },
    }
    
    
    const v$ = useVuelidate(validateSituacionFamiliar, miembroGrupoFamiliar);

    onMounted(async() => {
        datosEconomicosMiembrosFamiliarList.value = await getDatosEconomicosMiembrosFamiliares(137451);
        nivelesInstruccionList.value = await getNivelInstruccion();
        parentescosList.value = await getParentescos();
        tipoEmpresaList.value = await getTipoEmpresa();
        console.log(tipoEmpresaList.value);
    })


    return {
        datosEconomicosMiembrosFamiliarList,
        nivelesInstruccionList,
        parentescosList,
        tipoEmpresaList,
        miembroGrupoFamiliar,
        sbeCamposWrapper,
        sbeParametros,

        v$
    }

}

export default useDatosEconomicos;



