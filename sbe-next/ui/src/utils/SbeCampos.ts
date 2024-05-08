interface SbeCamposWrapper {
    pais?: number;
    ciudad?: number;
    parroquia?: number;
    barrio: string;
    direccion: string;
    tlfDomicilio: string;
    tlfCelular: string;
    whatsapp: string;
    correoPersonal: string;
    correoInstitucional: string;

    paisEstudio?: number;
    ciudadEstudio?: number;
    parroquiaEstudio?: number;
    barrioEstudio: string;
    direccionEstudiante: string;
    
    otraFrecuenciaEspecifique: string;
    
    numeroMiembros?: number;
    totalIngresosMensuales?: number;
    valorTotalMensualOtrosIngresos?:    number;

    opcionViveGrupoFamiliarPropiedad?: number
    opcionViveGrupoFamiliarVehiculos?: number
    numeroPropiedades?: number;
    numeroVehiculos?: number;

    costoTotalPropiedades?: number;
    costoTotalVehiculos?: number;
    total?: number;

    valorPagoMensualArriendo?: number;
    valorPagoMensualHipoteca?: number;

}