<template>
	<FVerticalStack gap="4">
		<FBanner v-show="informeGuardado" :title="$t('seguimientoFichaAmpliada.informeCasos.label.mensajeGuardar')"
			status="success" dismissible />

		<FCard>
			<FCardSection title="DATOS DEL ESTUDIANTE">
				<FFormLayoutGroup>
					<FLabel id="nombre">
						<FText as="h6" variant="headingSm">{{ $t("ficha.estudiante.nombres") }}:</FText>
					</FLabel>
					<FLabel id="nombre">
						<FText as="p" variant="bodySm" class="margin">{{ getDatosEstudiante?.nombre }}
						</FText>
					</FLabel>
				</FFormLayoutGroup>

				<FFormLayoutGroup>
					<FLabel id="identificacion">
						<FText as="h6" variant="headingSm">{{ $t("ficha.estudiante.identificacion") }}:</FText>
					</FLabel>
					<FLabel id="identificacion">
						<FText as="p" variant="bodySm" class="margin">{{ getDatosEstudiante?.identificacion }}
						</FText>
					</FLabel>
				</FFormLayoutGroup>

				<FFormLayoutGroup>
					<FLabel id="nivelBeca">
						<FText as="h6" variant="headingSm">{{ $t("ficha.estudiante.becaAsignado") }}:</FText>
					</FLabel>
					<FLabel id="nivelBeca">
						<FText as="p" variant="bodySm" class="margin">{{ getDatosEstudiante?.nivelBeca }}
						</FText>
					</FLabel>
				</FFormLayoutGroup>
			</FCardSection>

			<FCardSection title="SECCIÓN DE LA FICHA | OBSERVACIONES">
				<FFormLayout>
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.situacionGrupoFamiliar')
						" :multiline="2" v-model="situacionFamiliar" showCharacterCount :max-length="250" required-indicator
						:error="situacionFamiliarError &&
							$t(
								'seguimientoFichaAmpliada.informeCasos.label.error.situacionFamiliarError'
							)
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.situacionEconomica')" :multiline="2"
						v-model="situacionEconomica" showCharacterCount :max-length="250" required-indicator :error="situacionEconomicaError &&
							$t(
								'seguimientoFichaAmpliada.informeCasos.label.error.situacionEconomicaError'
							)
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.situacionVivienda')"
						id="textFieldID2" :multiline="2" v-model="situacionVivienda" showCharacterCount :max-length="250"
						required-indicator :error="situacionViviendaError &&
							$t(
								'seguimientoFichaAmpliada.informeCasos.label.error.situacionViviendaError'
							)
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.situacionEducacion')" :multiline="2"
						v-model="situacionEducacion" showCharacterCount :max-length="250" required-indicator :error="situacionEducacionError &&
							$t(
								'seguimientoFichaAmpliada.informeCasos.label.error.situacionEducacionError'
							)
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.saludGrupoFamiliar')"
						id="textFieldID" :multiline="2" v-model="situacionSalud" showCharacterCount :max-length="250"
						required-indicator :error="situacionSaludError &&
							$t('seguimientoFichaAmpliada.informeCasos.label.error.situacionSaludError')
							" />
				</FFormLayout>
			</FCardSection>

			<FCardSection title="EVIDENCIAS, CONCLUSIONES, SUGERENCIAS">
				<FFormLayout>
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.evidencias')" :multiline="2"
						v-model="evidencia" showCharacterCount :max-length="250" required-indicator :error="evidenciaError &&
							$t('seguimientoFichaAmpliada.informeCasos.label.error.evidenciasError')
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.conclusiones')" :multiline="2"
						v-model="conclusion" showCharacterCount :max-length="250" required-indicator :error="conclusionError &&
							$t('seguimientoFichaAmpliada.informeCasos.label.error.conclusionesError')
							" />
					<FTextField :label="$t('seguimientoFichaAmpliada.informeCasos.label.sugerencias')" :multiline="2"
						v-model="sugerencia" showCharacterCount :max-length="250" required-indicator :error="sugerenciaError &&
							$t('seguimientoFichaAmpliada.informeCasos.label.error.sugerenciasError')
							" />
				</FFormLayout>
			</FCardSection>
		</FCard>

		<FPageActions :primary-action="!getInformeFicha?.infCodigo && !informeGuardado
				? { icon: PlusSolid, content: 'Guardar', onAction: () => onSubmited() }
				: undefined
			" :secondaryActions="[
		{
			icon: ArrowLeftSolid,
			content: 'Regresar',
			onAction: () => $router.back(),
		},
	]">
		</FPageActions>
	</FVerticalStack>
</template>

<script setup lang="ts">
	import { PlusSolid, ArrowLeftSolid } from "@ups-dev/freya-icons";
	import { useField, useForm } from "vee-validate";
	import { useDatosSegInformeFicha } from "~/composables/datosSeguimientoFicha/useDatosSegInformeFicha";
	import { SbeInformeFichaAmpliada } from "~/models/datosSeguimientoFicha/informeFichaAmpliada.model";

	//*variable global
	const storeClient = useDatosFichaStore();
	const {
		codigoFicha,
		getInformeFicha,
		getDatosEstudiante,
		idCedula,
		solCodigo,
	} = storeToRefs(storeClient);
	const informeGuardado = ref<boolean>(false);

	onMounted(() => {
		situacionFamiliar.value = getInformeFicha.value?.infSituacionFamiliar;
		situacionEconomica.value = getInformeFicha.value?.infSituacionEconomica;
		situacionVivienda.value = getInformeFicha.value?.infSituacionVivienda;
		situacionEducacion.value = getInformeFicha.value?.infSituacionEducacion;
		situacionSalud.value = getInformeFicha.value?.infSaludFamiliaEstudiante;
		evidencia.value = getInformeFicha.value?.infEvidencias;
		conclusion.value = getInformeFicha.value?.infConclusiones;
		sugerencia.value = getInformeFicha.value?.infSugerencias;
	});

	//Valida campos texto obligatorios
	const { handleSubmit } = useForm();

	const {
		value: situacionFamiliar,
		errorMessage: situacionFamiliarError,
	} = useField<string>("situacionFamiliar", { required: true });

	const {
		value: situacionEconomica,
		errorMessage: situacionEconomicaError,
	} = useField<string>("situacionEconomica", { required: true });

	const {
		value: situacionVivienda,
		errorMessage: situacionViviendaError,
	} = useField<string>("situacionVivienda", { required: true });

	const {
		value: situacionEducacion,
		errorMessage: situacionEducacionError,
	} = useField<string>("situacionEducacion", { required: true });

	const { value: situacionSalud, errorMessage: situacionSaludError } = useField<string>(
		"situacionSalud",
		{ required: true }
	);

	const { value: evidencia, errorMessage: evidenciaError } = useField<string>("evidencia", {
		required: true,
	});

	const { value: conclusion, errorMessage: conclusionError } = useField<string>(
		"conclusion",
		{ required: true }
	);

	const { value: sugerencia, errorMessage: sugerenciaError } = useField<string>(
		"sugerencia",
		{ required: true }
	);

	const onSubmited = handleSubmit((values) => {
		saveInforme();
	});

	const saveInforme = async () => {
		getInformeFicha.value = {} as SbeInformeFichaAmpliada;
		getInformeFicha.value!.fisCodigo = codigoFicha.value;
		getInformeFicha.value!.infSituacionFamiliar = situacionFamiliar.value;
		getInformeFicha.value!.infSituacionEconomica = situacionEconomica.value;
		getInformeFicha.value!.infSituacionVivienda = situacionVivienda.value;
		getInformeFicha.value!.infSituacionEducacion = situacionEducacion.value;
		getInformeFicha.value!.infSaludFamiliaEstudiante = situacionSalud.value;
		getInformeFicha.value!.infEvidencias = evidencia.value;
		getInformeFicha.value!.infConclusiones = conclusion.value;
		getInformeFicha.value!.infSugerencias = sugerencia.value;

		await guardarInformeFichaAmpliada(JSON.parse(JSON.stringify(getInformeFicha.value)));
		//Enviar correo al Director Técnico
		await enviarNotificacionAnexo14(idCedula.value!, solCodigo.value!);
		informeGuardado.value = true;
		window.scrollTo(0, 0);
	};

	const { guardarInformeFichaAmpliada } = useDatosSegInformeFicha();

	const { enviarNotificacionAnexo14 } = useSendEmailService();
</script>

<style lang="css" scoped></style>
