
export const useFicha = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { fichaSocioeconomica, cedula, insAlumno, estadoFichaAmpliada } = storeToRefs(storeClient)
    //*Service
    const { getDatosPersonales } = useAlumnoService()
    const { getFichaHabilitada } = useFichaHabilitadaService()

    const {crearNuevaFicha, obtenerSolCodigo, getEstadoFicha, getCodigoFicha, actualizarFicha, } = useFichaService();
    const route = useRoute();
    let load = ref<boolean>(false);
    const estudianteHabilitado = ref<boolean>(true);

    onMounted(async() => {
        cedula.value = route.params.cedula.toString();
        insAlumno.value = await getDatosPersonales(cedula.value);
        await crearFicha();
    }
)
    const crearFicha = async() =>{
        try {
            const respHabilitado = await getFichaHabilitada(cedula.value); //* Consulto si la ficha esta habilitada para este estudiante
            if(respHabilitado === 0){
                estudianteHabilitado.value = false; //* si no esta habilitado le muestra el mensaje de ficha no habilitada **
            }else{
                const estadoFicha = await getEstadoFicha(cedula.value) //* Si está habilitado consulto por el estado de su ficha
                if (estadoFicha.includes("C")) {
                    estadoFichaAmpliada.value = 'C';
                }else{
                    const codigoFichaAux = await getCodigoFicha(cedula.value!); // * si tiene habilitado la ficha consulto si tiene un codigo de ficha ya creado
                    console.log(codigoFichaAux,'codigoFichaAux');
                    if (!codigoFichaAux) {

                    fichaSocioeconomica.value.estado = 'I';
                    fichaSocioeconomica.value.alu_codigo = insAlumno.value.aluCodigo
                    fichaSocioeconomica.value.sol_codigo = codigoFichaAux;
                    fichaSocioeconomica.value.aud_adicionado = insAlumno.value.email
                    fichaSocioeconomica.value = await crearNuevaFicha(storeClient.fichaSocioeconomica)
                    await addSolCodigo(fichaSocioeconomica.value.fis_codigo);
                    }else {
                        fichaSocioeconomica.value.fis_codigo = codigoFichaAux;
                        // await addSolCodigo(fichaSocioeconomica.value.fis_codigo);
                      }
                }
        }
            
        } catch (error) {
        }
        //* FLOADING 
        setTimeout(() => {
            load.value = true;
        }, 1000);
    }

    const addSolCodigo = async (codigoFicha: number) => {
        fichaSocioeconomica.value.sol_codigo = await obtenerSolCodigo(
          cedula.value!,
          codigoFicha
        );
        fichaSocioeconomica.value.aud_modificado = insAlumno.value.email;
        await actualizarFicha(fichaSocioeconomica.value, fichaSocioeconomica.value.fis_codigo);
      };




    return {
        load,
        estudianteHabilitado,
        estadoFichaAmpliada
    }

}
export default useDatosEstudiante;