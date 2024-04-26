import { defineRule, configure, Form, Field, ErrorMessage, useField, useForm } from 'vee-validate';

import * as data from '@vee-validate/rules'
import * as yup from 'yup';
import { localize } from '@vee-validate/i18n';

export default defineNuxtPlugin(({ vueApp: app }) => {
    
    const rules = data as { [key: string]: any }
    Object.keys(data)
        .filter(k => k !== 'default')
        .forEach(rule => {
            defineRule(rule, rules[rule])
            // logger.info(`Defining rule: ${rule}`)
        })

    defineRule('correoPersonal', (value: string) => {
        if (!/^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(value)) {
            return 'El correo no es válido';
        }
        return true;
    });

    defineRule('telefonosCelular', (value: string) => {
        if (value != null) {
            if (value.length > 10) {
                return 'Ingrese máximo 10 números';
            }
        }

        return true;
    });

    defineRule('telefonoDomicilio', (value: string) => {
        if (value != null) {
            if (value.length > 7) {
                return 'Ingrese máximo 7 números';
            }
        }

        return true;
    });

    defineRule('numeroMiembros', (value: number) => {
        if (value <= 0 && value > 30) {
            return 'ingrese un numero entre 0 y 30'
        }
        return true;
    });

    defineRule('validarCedula', (value: string,  [otraVariable]: any[] ) => {
        if(value&&otraVariable._value=='CEDULA'){
            let cad = value;
            let total = 0;
            let longitud = cad.length;
            let longcheck = longitud - 1;
            if (value.length == 10) {
                for (let i = 0; i < longcheck; i++) {
                    if (i % 2 === 0) {
                        let aux = +cad.charAt(i) * 2;
                        if (aux > 9) aux -= 9;
                        total += aux;
                    } else {
                        total += parseInt(cad.charAt(i)); // parseInt o concatenará en lugar de sumar
                    }
                }
        
                total = total % 10 ? 10 - total % 10 : 0;
        
                if (+cad.charAt(longitud - 1) == total) {
                    return true
                } else {
                    return false
                }
            } else {
                return false
            }
        }else if(value&&otraVariable._value=='PASAPORTE'){
            if(value.length>10){
                return 'Ingrese máximo 10 dígitos';
            }
        }
                return true;
            }
            );




    configure({
        generateMessage: localize("es", {
            messages: {
                required: "Este campo es requerido",
                email: "El correo no es válido",
                min: "Ingrese al menos 0:{min} caracteres",
                max: "Ingrese máximo 0:{max} caracteres",
                validarCedula: "la cédula no es válida"
            }
        })
    })

    app.component('Form', Form)
    app.component('Field', Field)
    app.component('ErrorMessage', ErrorMessage)

    localize("es")

})

