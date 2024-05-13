
export const useDatosEstudiante = () => {
    //*Store
    const storeClient = useDatosFichaStore();
    const { cedula,insAlumno } = storeToRefs(storeClient)

    const route = useRoute();

    onMounted(async() => {
        
        if (insAlumno.value.quintil_v1 == 0 && insAlumno.value.quintil_v2 != 0) {
            insAlumno.value.nivelBeca = insAlumno.value.quintil_v2

        } else if (insAlumno.value.quintil_v1 != 0 && insAlumno.value.quintil_v2 != 0) {
            insAlumno.value.nivelBeca = insAlumno.value.quintil_v2

        } else if (insAlumno.value.quintil_v1 != 0 && insAlumno.value.quintil_v2 == 0) {
            insAlumno.value.nivelBeca = insAlumno.value.quintil_v1
        }
    })

    return {
        insAlumno
    }

}
export default useDatosEstudiante;