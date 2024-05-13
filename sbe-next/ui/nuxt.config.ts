// https://nuxt.com/docs/api/configuration/nuxt-config

export default defineNuxtConfig({
    components: true,
    srcDir: 'src/',
    //ssr: false,
    app: {
        head: {
            title: 'SBE',
            htmlAttrs: {
                lang: 'es'
            },
            meta: [
                { charset: 'utf-8' },
                { name: 'viewport', content: 'width=device-width, initial-scale=1' },
            ]
        }
    },
    modules: [
        '@pinia/nuxt',
        '@ups-dev/freya-nuxt',
    ],
    
    pinia: {
        autoImports: ['defineStore', 'storeToRefs'],
    },
    runtimeConfig: {
        public: {
            assets:{
                images: '/images'
            },
            
            // SBE_FICHA: '',
            // SBE_ALUMNO: '',
            // SBE_DOMICILIO: '',
            // SBE_VALORES_CAMPO: '',
            // SBE_VALORES_PARAMETRO: '',
            // SBE_DATOS_ECONOMICOS: '',            
            // SBE_INFORME: '',
            // SBE_PERIODO: '',
            // SBE_LOGIN: '',            
            // SBE_DOC_SOLICITADOS: '',
            // SBE_VALORACION: '',
            // SOL_FICHA_HABILITADA: '',
            // SOL_FICHA_EMAIL: ''
            
            //* CUANDO SUBIMOS AL SERVIDOR
            // SBE_FICHA: 'https://sbe-svc.ups.edu.ec/v1/ficha',
            // SBE_ALUMNO: 'https://sbe-svc.ups.edu.ec/v1/insAlumno',
            // SBE_DOMICILIO: 'https://sbe-svc.ups.edu.ec/v1/datosDomicilio',
            // SBE_VALORES_CAMPO: 'https://sbe-svc.ups.edu.ec/v1/valorCampo',
            // SBE_VALORES_PARAMETRO: 'https://sbe-svc.ups.edu.ec/v1/valorParametros',
            // SBE_DATOS_ECONOMICOS: 'https://sbe-svc.ups.edu.ec/v1/datosEconomicos',            
            // SBE_INFORME:'https://sbe-svc.ups.edu.ec/v1/informes',
            // SBE_PERIODO:'https://sbe-svc.ups.edu.ec/v1/periodoLectivo',
            // SBE_LOGIN:'https://sbe-svc.ups.edu.ec/v1/login',            
            // SBE_DOC_SOLICITADOS: 'https://sbe-svc.ups.edu.ec/v1/documentosSolicitados',
            // SBE_VALORACION: 'https://sbe-svc.ups.edu.ec/v1/valoracionFicha',
            // SOL_FICHA_HABILITADA: 'https://sol-svc.ups.edu.ec/v1/solicitudEvento',
            // SOL_FICHA_EMAIL: 'https://sol-svc.ups.edu.ec/v1/email'
    
            //* LOCALMENTE
            SBE_FICHA: '/sbe/api/v1/fichaSocioeconomica',
            SBE_ALUMNO: '/sbe/api/v1/insAlumno',
            SBE_DOMICILIO: '/sbe/api/v1/datosDomicilio',
            SBE_VALORES_CAMPO: '/sbe/api/v1/valorCampo',
            SBE_VALORES_PARAMETRO: '/sbe/api/v1/valorParametros',
            SBE_SITUACION_FAMILIAR: '/sbe/api/v1/situacionFamiliar',            
            SBE_INFORME:'/sbe/api/v1/informes',
            SBE_PERIODO:'/sbe/api/v1/periodoLectivo',
            SBE_LOGIN:'/sbe/api/v1/login',            
            SBE_DOC_SOLICITADOS: '/sbe/api/v1/documentosSolicitados',
            SBE_VALORACION: '/sbe/api/v1/valoracionFicha',
            SOL_FICHA_HABILITADA: '/sol/solicitudEvento',
            SOL_FICHA_EMAIL: '/sol/api/v1/email'

   
        }
    },

    css: [
        'primevue/resources/primevue.css',
        'primeicons/primeicons.css',
        '@/assets/css/estilos.css'
        
    ],
    build: {
        transpile: [ 
            'yup', 
            'lodash', 
            'primevue', 
            '@vee-validate/rules',
         ]
    },

    //* LOCALMENTE
    nitro: {
        devProxy: {
            '/sbe': {
                changeOrigin: true,
                // target: 'https://sbe-svc.ups.edu.ec/v1',
                target: 'http://localhost:8080/sbe',
            },
            '/sol': {
                changeOrigin: true,
                // target: 'https://sbe-svc.ups.edu.ec/v1',
                target: 'http://localhost:8081/v1',

            },
        },
    }
})
