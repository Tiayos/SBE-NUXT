<template>
	<FVerticalStack gap="4">
		<FBanner v-model="activarNotificacion" :title="$t('seguimientoFichaAmpliada.documento.label.mensajeSendEmail')"
			status="success" dismissible />

		<Toolbar class="mb-4" v-if="codPerfilUsuario === 2">
			<template #start>
				<FButton :icon="PlusSolid" @click="btCreate()">Solicitar</FButton>
				<FButton :icon="InboxSolid" @click="btSendEmail()">Enviar Email</FButton>
			</template>
		</Toolbar>

		<DataTable showGridlines :value="getDocumentosSolicitados" :loading="false" dataKey="id" :paginator="true"
			:rows="10">
			<template v-if="true" #empty>{{
				$t("seguimientoFichaAmpliada.table.empty")
			}}</template>

			<Column field="docCodigo" :header="$t('seguimientoFichaAmpliada.documento.codigo')" style="width: 10%" />

			<Column field="docDescripcion" :header="$t('seguimientoFichaAmpliada.documento.descripcion')"
				style="width: 25%" />

			<Column :header="$t('seguimientoFichaAmpliada.documento.archivo')" style="width: 25%">
				<template #body="{ data }">
					<FLink v-on:click="descargarArchivo(data.docArchivo, data.docNombreArchivo)">
						{{ data.docNombreArchivo }}
					</FLink>
				</template>
			</Column>

			<Column :header="$t('seguimientoFichaAmpliada.documento.fechaLimite')" style="width: 10%">
				<template #body="{ data }">
					{{ data.docFechaLimiteEnvio }}
				</template>
			</Column>
			<Column :header="$t('seguimientoFichaAmpliada.documento.estadoDocumento')" style="width: 15%">
				<template #body="{ data }">
					<FBadge :status="data.docEstadoDocumento !== 'P' ? 'success' : undefined">
						{{ data.docEstadoDocumento == "P" ? "Pendiente" : "Subido" }}
					</FBadge>
				</template>
			</Column>
			<Column style="width: 10%">
				<template #body="slotProps">
					<FPopover v-if="codPerfilUsuario === 2" autofocusTarget="first-node">
						<template #activator="{ props }">
							<FButton disclosure v-bind="props"> Acciones </FButton>
						</template>

						<FActionList actionRole="menuitem" :items="[
							{
								content: $t('seguimientoFichaAmpliada.documento.label.edit'),
								onAction: () => btEdit(slotProps.data),
								icon: PencilSolid,
							},
							{
								content: $t('seguimientoFichaAmpliada.documento.label.delete'),
								onAction: () => btDelete(slotProps.data),
								icon: TrashCanSolid,
							},
						]" />
					</FPopover>
				</template>
			</Column>
		</DataTable>
	</FVerticalStack>

	<FModal v-model="active" :title="$t('seguimientoFichaAmpliada.documento.tittle.solicitarDocumento')"
		:primaryAction="{ content: 'Guardar', onAction: () => onSubmited() }"
		:secondary-actions="[{ content: 'Cancelar', onAction: () => (active = false) }]">
		<FModalSection>
			<FVerticalStack gap="6">
				<FTextField :label="$t('seguimientoFichaAmpliada.documento.documentos')" type="text" autoComplete="off"
					:focused="false" v-model="docDescripcion" required-indicator
                    :error="docDescripcionError && $t('seguimientoFichaAmpliada.documento.label.error.descripcionError')" />

				<FTextField :label="$t('seguimientoFichaAmpliada.documento.fechaLimite')" type="date" autoComplete="off"
					:focused="false" v-model="docFechaLimiteEnvio" required-indicator
                    :error="docFechaLimiteEnvioError && $t('seguimientoFichaAmpliada.documento.label.error.fechaLimiteError')" 
                    :min="fechaActual" />

				<FLabelled id="documento" :label="$t('seguimientoFichaAmpliada.documento.estadoDocumento')">
					<Dropdown filter style="width: 100%" :placeholder="'Seleccione una opción'" :options="estadoDocumento"
						optionLabel="estado" optionValue="code" v-model="docEstadoDocumento">
					</Dropdown>
				</FLabelled>
			</FVerticalStack>
		</FModalSection>
	</FModal>

	<FModal v-model="activeEdit" :title="$t('seguimientoFichaAmpliada.documento.tittle.editarDocumento')"
		:primaryAction="{ content: 'Guardar', onAction: () => onSubmited() }"
		:secondary-actions="[{ content: 'Cancelar', onAction: () => (activeEdit = false) }]">
		<FModalSection>
			<FVerticalStack gap="6">
				<FTextField :label="$t('seguimientoFichaAmpliada.documento.documentos')" type="text" autoComplete="off"
					:focused="false" v-model="docDescripcion" required-indicator
                    :error="docDescripcionError && $t('seguimientoFichaAmpliada.documento.label.error.descripcionError')"/>

				<FTextField :label="$t('seguimientoFichaAmpliada.documento.fechaLimite')" type="date" autoComplete="off"
					:focused="false" v-model="docFechaLimiteEnvio" required-indicator
                    :error="docFechaLimiteEnvioError && $t('seguimientoFichaAmpliada.documento.label.error.fechaLimiteError')"/>

				<FLabelled id="documento" :label="$t('seguimientoFichaAmpliada.documento.estadoDocumento')">
					<Dropdown filter style="width: 100%" :placeholder="'Seleccione una opción'" :options="estadoDocumento"
						optionLabel="estado" optionValue="code" v-model="docEstadoDocumento">
					</Dropdown>
				</FLabelled>
			</FVerticalStack>
		</FModalSection>
	</FModal>

	<FModal v-model="activeDelete" title="Documentos solicitados"
		:primaryAction="{ content: 'Eliminar', onAction: () => onSubmited(), destructive: true }"
		:secondary-actions="[{ content: 'Cancelar', onAction: () => (activeDelete = false) }]">
		<FModalSection>
			<i18n-t keypath="seguimientoFichaAmpliada.mensajeEliminar">
				<template #nombre>
					<FText font-weight="bold" as="span">
						{{ docDescripcion }}
					</FText>
				</template>
			</i18n-t>
		</FModalSection>
	</FModal>
</template>

<script setup lang="ts">
	import { PlusSolid, PencilSolid, TrashCanSolid, InboxSolid } from "@ups-dev/freya-icons";
	import { useDatosSegDocSolicitados } from "~/composables/datosSeguimientoFicha/useDatosSegDocSolicitados";
	import { SbeDocumentoSolicitadoFichaToList } from "~~/src/models/datosSeguimientoFicha/documentosSolicitados.model";
	import { useField, useForm,  } from 'vee-validate';

	//*variable global
	const storeClient = useDatosFichaStore();
	const {
		codigoFicha,
		getDocumentosSolicitados,
		codPerfilUsuario,
		idCedula,
		solCodigo,
	} = storeToRefs(storeClient);

	const documentoSolicitado: any = ref({});
	const active = ref(false);
	const activeEdit = ref(false);
	const activeDelete = ref(false);
	const activarNotificacion = ref(false);

	const onRowSelect = (event) => {
		const selectedItem = event.data ?? event;
		documentoSolicitado.value = selectedItem;
	};

	const descargarArchivo = async (archivo: Blob, nombreArchivo: string) => {
		// base64 string
		const base64str = archivo;

		// decode base64 string, remove space for IE compatibility
		const binary = atob(base64str.replace(/\s/g, ""));
		const len = binary.length;
		const buffer = new ArrayBuffer(len);
		const view = new Uint8Array(buffer);
		for (var i = 0; i < len; i++) {
			view[i] = binary.charCodeAt(i);
		}

		// create the blob object with content-type "application/pdf"
		const file = new Blob([view], { type: "application/pdf" });
		const fileURL = URL.createObjectURL(file);
		//window.open(fileURL");

		let a = document.createElement("a");
		a.setAttribute("href", fileURL);
		a.setAttribute("download", nombreArchivo);
		a.click();
	};

	const fechaFormato = () => {
		var date = new Date();
		let year = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(date);
		let month = new Intl.DateTimeFormat('en', { month: '2-digit' }).format(date);
		let day = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(date);

		const fetch = `${year}-${month}-${day}`
		console.log("FECHA FORMATO", fetch);
		return fetch
	}

	const fechaActual = fechaFormato();

	const btCreate = () => {
		fechaFormato()
		//const fechaActual = new Date().toLocaleDateString()
		console.log(fechaActual);

		resetForm(); 		//Se usa para resetear todos los campos de un formulario
		active.value = true;
		documentoSolicitado.value = {} as SbeDocumentoSolicitadoFichaToList;
		docEstadoDocumento.value = "P"
	};

	const btEdit = async (documento: any) => {
		activeEdit.value = true;
		documentoSolicitado.value = documento;
		docDescripcion.value = documento.docDescripcion;
		docFechaLimiteEnvio.value = documento.docFechaLimiteEnvio;
		docEstadoDocumento.value = documento.docEstadoDocumento;
	};

	const btDelete = async (documento: any) => {
		activeDelete.value = true;
		documentoSolicitado.value = documento;
	};

	const btSendEmail = async () => {
		//Enviar correo al estudiante indicando que debe subir documentos
		await enviarNotificacionAnexo8(idCedula.value!, solCodigo.value!);
		activarNotificacion.value = true;
	};

	const estadoDocumento = ref([
		{ estado: "Subido", code: "S" },
		{ estado: "Pendiente", code: "P" },
	]);

	//Valida campos texto obligatorios
	const { handleSubmit, resetForm } = useForm();
	const { value: docDescripcion, errorMessage: docDescripcionError } = useField<string>("docDescripcion", { required: true });
	const { value: docFechaLimiteEnvio, errorMessage: docFechaLimiteEnvioError } = useField<string>("docFechaLimiteEnvio", { required: true });
	const { value: docEstadoDocumento, errorMessage: docEstadoDocumentoError } = useField<string>("docEstadoDocumento", { required: true });

	const onSubmited = handleSubmit((values) => {
		handleChange();
	});

	const handleChange = async () => {
		documentoSolicitado.value.docDescripcion = docDescripcion.value
		documentoSolicitado.value.docFechaLimiteEnvio = docFechaLimiteEnvio.value
		documentoSolicitado.value.docEstadoDocumento = docEstadoDocumento.value;
		if (active.value) {
			await saveDocumentoSolicitado(); //* guardamos el nuevo documento
		} else if (activeEdit.value) {
			await editDocumentoSolicitado();
		} else if (activeDelete.value) {
			await deleteDocumentoSolicitado(); //obliga a la aplicación a seguir una secuencia
		}

		//* Borramos valores
		documentoSolicitado.value = {} as SbeDocumentoSolicitadoFichaToList;
		await obtenerDocumentosSolicitadosFicha();
	};

	const saveDocumentoSolicitado = async () => {
		const contOrden = getDocumentosSolicitados.value.length + 1
		documentoSolicitado.value!.docOrden = contOrden;
		documentoSolicitado.value!.fisCodigo = codigoFicha.value;
		await guardarDocumentoEstudiante(JSON.parse(JSON.stringify(documentoSolicitado.value)));
		active.value = false;
	};

	const editDocumentoSolicitado = async () => {
		await actualizarDocumentoEstudiante(JSON.parse(JSON.stringify(documentoSolicitado.value)),
			documentoSolicitado.value.docCodigo);
		activeEdit.value = false;
	};

	const deleteDocumentoSolicitado = async () => {
		await eliminarDocumentoEstudiante(documentoSolicitado.value.docCodigo);
		activeDelete.value = false;
	};

	const {
		guardarDocumentoEstudiante,
		obtenerDocumentosSolicitadosFicha,
		actualizarDocumentoEstudiante,
		eliminarDocumentoEstudiante,
	} = useDatosSegDocSolicitados();

	const {
		enviarNotificacionAnexo8
	} = useSendEmailService();
</script>

<style lang="css" scoped></style>