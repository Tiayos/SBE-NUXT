import { defineStore } from 'pinia';
import { SituacionFamiliar } from '~/models/datosEconomicos/situacionFamiliar.model';
import { insAlumnoProjection } from '~/models/datosPersonales/alumno.model';
import { OpcionParametro } from '~/models/opcionesParametros/OpcionParametro.model';
import { sbeCampoFicha } from '~/models/opcionesParametros/sbeCampoFicha';
import { sbeFichaSocioeconomica } from '~/models/opcionesParametros/sbeFichaSocioeconomica.model';
import { sbeValorCampoFicha } from '~/models/opcionesParametros/sbeValorCampoFicha.model';
import { sbeValorParametroFicha } from '~/models/opcionesParametros/sbeValorParametroFicha';

export const useDatosFichaStore = defineStore('useDatosFichaStore', () => {
    const { getOpcionesParametros } = useValorParametrosService()

    const insAlumno = ref<insAlumnoProjection>({} as insAlumnoProjection)
    const cedula = ref<string>("");
    const miembroGrupoFamiliar = ref<SituacionFamiliar>({} as SituacionFamiliar);

    const sbeValorCampoFichaList = ref<sbeValorCampoFicha[]>([]);
    const sbeValorParametroFichaList = ref<sbeValorParametroFicha[]>([]);

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
    
    numeroMiembros: undefined,
    totalIngresosMensuales: undefined,
    otrosIngresosEspecifique: '',
    valorTotalMensualOtrosIngresos:    undefined,

    opcionViveGrupoFamiliarPropiedad: undefined,
    opcionViveGrupoFamiliarVehiculos: undefined,
    numeroPropiedades: undefined,
    numeroVehiculos: undefined,

    costoTotalPropiedades: undefined,
    costoTotalVehiculos: undefined,
    total: undefined,

    valorPagoMensualArriendo: undefined,
    valorPagoMensualHipoteca: undefined,
    })

    const sbeParametros = ref<SbeParametros>({
        tipoParroquia: undefined,
        resideOtroLugar: undefined,
        tipoParroquiaEstudio: undefined,
        tipoTransporte: undefined,
        frecuenciaTransporte: undefined,
        otroIngresoMensual: undefined,
        tipoTenenciaVivienda: undefined
    })

    const llenarCampo = (codigo: number, valor: any, tipoCampo: string) => {
        let encontrado = false;
        for (const sbeValorCampoFicha1 of sbeValorCampoFichaList.value) {
            if (sbeValorCampoFicha1.campo_ficha.codigo === codigo) {
                encontrado = true;
                switch (tipoCampo) {
                    case 'TEXTO':
                        sbeValorCampoFicha1.vcf_texto = valor;
                        break;
                    case 'ENTERO':
                        sbeValorCampoFicha1.vcf_entero = valor;
                        break;
                    case 'DECIMAL':
                        sbeValorCampoFicha1.vcf_decimal = valor;
                        break;
                }
                console.log(sbeValorCampoFichaList);
                break;
            }
        }

        if (!encontrado) {
            const sbeValorCampoFicha = {} as sbeValorCampoFicha;
            sbeValorCampoFicha.codigo = 0;
            sbeValorCampoFicha.campo_ficha = { codigo: codigo } as sbeCampoFicha;
            sbeValorCampoFicha.fis_codigo = { fis_codigo: 0 } as sbeFichaSocioeconomica;
            sbeValorCampoFicha.pel_codigo_inicio = 0;
            switch (tipoCampo) {
                case 'TEXTO':
                    sbeValorCampoFicha.vcf_texto = valor;
                    break;
                case 'ENTERO':
                    sbeValorCampoFicha.vcf_entero = valor;
                    break;
                case 'DECIMAL':
                    sbeValorCampoFicha.vcf_decimal = valor;
                    break;
            }
            sbeValorCampoFichaList.value.push(sbeValorCampoFicha);
            console.log(sbeValorCampoFichaList);
        }
    };


    const llenarListaParametros = async (
        valorOpcion: number | undefined,
        codigoOpcionParametro: number
      ) => {
        if (valorOpcion !== undefined) {
          const opcionesParametros = await getOpcionesParametros(codigoOpcionParametro);
          await llenarParametros(valorOpcion!, opcionesParametros);
        }
      };

      const llenarParametros = (valor: number, sbeOpcionParametroFichas: OpcionParametro[]) => {
        let encontrado = false;
        for (const sbeValorParametroFicha1 of sbeValorParametroFichaList.value) {
            for (const sbeOpcionParametroFicha of sbeOpcionParametroFichas) {
                if (sbeValorParametroFicha1.opf_codigo.codigo == sbeOpcionParametroFicha.codigo) {
                    encontrado = true;
                    sbeValorParametroFicha1.opf_codigo.codigo = valor; // Actualizar el valor existente
                    console.log(sbeValorParametroFichaList.value, 'SI LO ENCONTRO Y SE ACTUALIZO');
                    break;
                }
            }
        }
    
        if (!encontrado) {
            // Si no se encuentra, agregar un nuevo elemento
            const sbeValorParametroFicha = {} as sbeValorParametroFicha;
            sbeValorParametroFicha.codigo = 0;
            sbeValorParametroFicha.fis_codigo = { fis_codigo: 0 } as sbeFichaSocioeconomica; // Asigna el valor adecuado
            sbeValorParametroFicha.pel_codigo_inicio = 0;
            sbeValorParametroFicha.opf_codigo = {codigo: valor}  as OpcionParametro; // Suponiendo que así se asigna el nuevo valor
    
            sbeValorParametroFichaList.value.push(sbeValorParametroFicha);
            console.log(sbeValorParametroFichaList.value, 'NO ENCONTRADO E HIZO PUSH');
        };
    }


    return {
        insAlumno,
        cedula,
        sbeCamposWrapper,
        sbeParametros,
        miembroGrupoFamiliar,
        llenarCampo,
        llenarListaParametros
    }

})