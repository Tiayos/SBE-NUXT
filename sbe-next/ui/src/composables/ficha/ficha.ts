
export const useFicha = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { fichaSocioeconomica, cedula, insAlumno } = storeToRefs(storeClient)
    //*Service
    const { getDatosPersonales } = useAlumnoService()
    const {crearNuevaFicha, obtenerSolCodigo} = useFichaService();
    const route = useRoute();
    let load = ref<boolean>(false);


    onMounted(async() => {
        cedula.value = route.params.cedula.toString();
        insAlumno.value = await getDatosPersonales(cedula.value);
        await crearFicha();
    }
)
    const crearFicha = async() =>{
        try {
            fichaSocioeconomica.value.estado = 'I';
            fichaSocioeconomica.value.alu_codigo = insAlumno.value.aluCodigo
            fichaSocioeconomica.value = await crearNuevaFicha(storeClient.fichaSocioeconomica)
        } catch (error) {
        }
        setTimeout(() => {
            load.value = true;
        }, 2000);
    }

    const addSolCodigo = async (codigoFicha: number) => {
        fichaSocioeconomica.value.sol_codigo = await obtenerSolCodigo(
          cedula.value!,
          codigoFicha
        );
        // fichaAmpliadaObject.value.audModificado = storeClient.emailAlumno;
        // await actualizarFicha(fichaAmpliadaObject.value, codigoFicha);
      };




    return {
        load
    }

}
export default useDatosEstudiante;