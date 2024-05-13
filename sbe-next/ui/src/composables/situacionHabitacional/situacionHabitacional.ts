
export const useSituacionHabitacional = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { sbeCamposWrapper, sbeParametros } = storeToRefs(storeClient)

   
    return {
        sbeCamposWrapper,
        sbeParametros,
        storeClient
    }

}
export default useDatosEstudiante;