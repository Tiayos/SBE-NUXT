import { useDatosEconomicosService } from '../services/useDatosEconomicosService';;
import { useVuelidate, ValidationRuleWithParams  } from '@vuelidate/core';
import { ErrorMessage } from 'vee-validate';
import { required, is_not } from "@vee-validate/rules";
import { SituacionFamiliar } from '~/models/datosEconomicos/situacionFamiliar.model';
import { Instruccion } from '~/models/datosEconomicos/instruccion.model';
import { Parentesco } from '~/models/datosEconomicos/parentesco.model';
import { TipoEmpresa } from '~/models/datosEconomicos/tipoEmpresa.model';
import { useToast } from "primevue/usetoast";

export const useDatosEconomicos = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { sbeCamposWrapper, sbeParametros, miembroGrupoFamiliar} = storeToRefs(storeClient)
    //* Datos economicos 3.2 
    const { getDatosEconomicosMiembrosFamiliares, getNivelInstruccion, getParentescos, 
        getTipoEmpresa,saveMiembroFamiliar, editMiembroFamiliar, deleteMiembroFamiliar } = useDatosEconomicosService()
    const datosEconomicosMiembrosFamiliarList = ref<SituacionFamiliar[]>([{} as SituacionFamiliar] )
    const nivelesInstruccionList = ref<Instruccion[]>([{} as Instruccion]);
    const parentescosList = ref<Parentesco[]>([{} as Parentesco]);
    const tipoEmpresaList = ref<TipoEmpresa[]>([{} as TipoEmpresa]);
    const tipoIdentificacion = ref();
    const toast = useToast();
    const selectOtrosIngresosList = ref<number[]>([]);

    enum persistAction {
        create,
        edit,
        view,
        saveCreate,
    }
    const viewAction = ref<persistAction>();

    //*Validate
    const validateSituacionFamiliar = {
        nombre_familiar:          { required },
        fecha_nacimiento:         { required },
        numero_identificacion:    { requiredIf: ()=>{
            if(tipoIdentificacion.value=='CEDULA'){
                return validarCedula(miembroGrupoFamiliar.value.numero_identificacion)
            }else{
                if(miembroGrupoFamiliar.value.numero_identificacion == ''){
                    return false
                }else{
                    return true
                }
            }
        }},
        ingresos_mensuales:       { required },
        sbe_instruccionDTO:       { requiredIf: ()=>{
            if(miembroGrupoFamiliar.value.sbe_instruccionDTO.codigo==undefined){
                return false
            }else{
                return true
            }
        } },
        sbe_parentescoDTO:        { requiredIf: ()=>{
            if(miembroGrupoFamiliar.value.sbe_parentescoDTO.codigo==undefined){
                return false
            }else{
                return true
            }
        } },
        sbe_tipo_empresa:         { requiredIf: ()=>{
            if(miembroGrupoFamiliar.value.sbe_tipo_empresa.codigo==undefined){
                return false
            }else{
                return true
            }
        } },
    }
    
    const v$ = useVuelidate(validateSituacionFamiliar, miembroGrupoFamiliar);

    onMounted(async() => {
        obtenerMiembrosSituacionFamiliar();
        nivelesInstruccionList.value = await getNivelInstruccion();
        parentescosList.value = await getParentescos();
        tipoEmpresaList.value = await getTipoEmpresa();
        // auxNumeroMiembrosCompletar();

    })

    const auxNumeroMiembrosCompletar = () => {
        sbeCamposWrapper.value.numeroMiembros =
          datosEconomicosMiembrosFamiliarList.value.length;
      
        storeClient.llenarCampo(
          sbeCampoCodigos.NUMERO_MIEMBROS_GRUPO_FAMILIAR,
          sbeCamposWrapper.value.numeroMiembros,
          "ENTERO"
        );
      };

    const obtenerMiembrosSituacionFamiliar = async() =>{
        let sumaIngresos = 0;
        datosEconomicosMiembrosFamiliarList.value = await getDatosEconomicosMiembrosFamiliares(137619);
        for (let i = 0; i < datosEconomicosMiembrosFamiliarList.value.length; i++) {
            const miembro = datosEconomicosMiembrosFamiliarList.value[i];
            sumaIngresos += miembro.ingresos_mensuales;
          }
          sbeCamposWrapper.value.totalIngresosMensuales = sumaIngresos;
    }

    return {
        datosEconomicosMiembrosFamiliarList,
        nivelesInstruccionList,
        parentescosList,
        tipoEmpresaList,
        miembroGrupoFamiliar,
        sbeCamposWrapper,
        sbeParametros,
        tipoIdentificacion,
        viewAction,
        persistAction,
        v$,
        selectOtrosIngresosList,
        saveMiembroFamiliar,
        toast,
        obtenerMiembrosSituacionFamiliar,
        editMiembroFamiliar,
        deleteMiembroFamiliar,
        auxNumeroMiembrosCompletar,
        storeClient
    }

}

export default useDatosEconomicos;



