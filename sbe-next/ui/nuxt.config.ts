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
            SBE_FICHA: '/sbe/ficha',
            SBE_ALUMNO: '/sbe/insAlumno',
            SBE_DOMICILIO: '/sbe/datosDomicilio',
            SBE_VALORES_CAMPO: '/sbe/valorCampo',
            SBE_VALORES_PARAMETRO: '/sbe/valorParametros',
            SBE_DATOS_ECONOMICOS: '/sbe/datosEconomicos',            
            SBE_INFORME:'/sbe/informes',
            SBE_PERIODO:'/sbe/periodoLectivo',
            SBE_LOGIN:'/sbe/login',            
            SBE_DOC_SOLICITADOS: '/sbe/documentosSolicitados',
            SBE_VALORACION: '/sbe/valoracionFicha',
            SOL_FICHA_HABILITADA: '/sol/solicitudEvento',
            SOL_FICHA_EMAIL: '/sol/email'

   
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
                target: 'http://localhost:8080/v1',
            },
            '/sol': {
                changeOrigin: true,
                // target: 'https://sbe-svc.ups.edu.ec/v1',
                target: 'http://localhost:8081/v1',

            },
        },
    }
})
