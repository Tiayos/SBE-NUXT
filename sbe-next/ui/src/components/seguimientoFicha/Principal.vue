<template>
  <FVerticalStack gap="4">
    <FLabelled id="tipo" :label="$t('seguimientoFichaAmpliada.filtros.periodo')">
      <Dropdown
        id="dropdown"
        filter
        :placeholder="$t('seguimientoFichaAmpliada.filtros.seleccione')"
        :options="getPeriodosLectivos!"
        option-label="pelDescripcion"
        optionValue="pelCodigo"
        v-model="pelCodigo"
        style="width: max-content"
      >
        <template #option="{ option }">
          <span> ( {{ option.pelCodigo }} ) </span>
          <span> {{ option.pelDescripcion }} </span>
        </template>
      </Dropdown>
    </FLabelled>

    <FBanner
      v-model="activaValoracion"
      :title="$t('seguimientoFichaAmpliada.ficha.label.mensajeGuardar')"
      status="success"
      dismissible
    />

    <FBanner
      v-model="yaTramitada"
      :title="$t('seguimientoFichaAmpliada.ficha.label.mensajeError')"
      status="warning"
      dismissible
    />

    <DataTable
      showGridlines
      :value="getFichasCompletas"
      :loading="false"
      dataKey="id"
      :paginator="true"
      :rows="10"
    >
      <template v-if="true" #empty>{{
        $t("seguimientoFichaAmpliada.table.empty")
      }}</template>

      <Column
        field="fisCodigo"
        :header="$t('seguimientoFichaAmpliada.ficha.fisCodigo')"
        style="width: 10%"
      />

      <Column
        field="fisFechaFinCreacion"
        :header="$t('seguimientoFichaAmpliada.ficha.fechaCreacion')"
        style="width: 15%"
      />

      <Column
        field="aluIdentificacion"
        :header="$t('seguimientoFichaAmpliada.estudiante.label.identificacion')"
        style="width: 15%"
      />

      <Column
        field="aluNombreCompleto"
        :header="$t('seguimientoFichaAmpliada.estudiante.label.nombres')"
        style="width: 25%"
      />

      <!-- QUINTIL ANTERIOR -->
      <Column
        :header="$t('seguimientoFichaAmpliada.ficha.label.quintilAnterior')"
        v-if="codPerfilUsuario === 1"
        style="width: 10%"
      >
        <template #body="{ data }">
          <FButton
            v-if="codPerfilUsuario === 1"
            :icon="MagnifyingGlassSolid"
            @click="btVerQuintilFicha(data.aluCodigo, 2)"
          >
          </FButton>
        </template>
      </Column>

      <Column :header="$t('seguimientoFichaAmpliada.ficha.periodo')" style="width: 15%">
        <template #body="{ data }">
          <span> ( {{ data.pelCodigo }} ) </span>
          <span> {{ data.pelDescripcion }} </span>
        </template>
      </Column>

      <Column
        style="width: 10%"
        v-if="codPerfilUsuario === 2"
        :header="$t('seguimientoFichaAmpliada.ficha.estado')"
      >
        <template #body="{ data }">
          <FBadge :status="data.estadoFichaCodigo == 5 ? 'success' : undefined">
            {{ data.estadoFichaCodigo == 5 ? "Tramitado" : "En trámite" }}
          </FBadge>
        </template>
      </Column>

      <Column style="min-width: " v-if="codPerfilUsuario === 2">
        <template #body="{ data }" style="align-content: center">
          <FIcon
            v-if="data.estadoFichaCodigo == 5"
            :source="CheckSolid"
            color="primary"
          />
          <FIcon
            v-else="data.estadoFichaCodigo == ''"
            :source="XmarkSolid"
            color="critical"
          />
        </template>
      </Column>

      <!-- QUINTIL NUEVO -->
      <Column
        :header="$t('seguimientoFichaAmpliada.ficha.label.quintilNuevo')"
        v-if="codPerfilUsuario === 1"
        style="width: 10%"
      >
        <template #body="{ data }">
          <FButton
            v-if="codPerfilUsuario === 1"
            :icon="MagnifyingGlassSolid"
            @click="btVerQuintilFicha(data.aluCodigo, 5)"
          >
          </FButton>
        </template>
      </Column>

      <!-- ESTADO SOLICITUD -->
      <Column
        :header="$t('seguimientoFichaAmpliada.ficha.label.estadoSolicitud')"
        v-if="codPerfilUsuario === 1"
      >
        <template #body="{ data }">
          <FButton
            v-if="codPerfilUsuario === 1"
            :icon="CircleInfoSolid"
            @click="btVerSolicitud(data)"
          >
          </FButton>
        </template>
      </Column>

      <!-- ACCIONES -->
      <Column style="width: 15%">
        <template #body="slotProps">
          <FPopover autofocusTarget="first-node">
            <template #activator="{ props }">
              <FButton disclosure v-bind="props"> Acciones </FButton>
            </template>

            <FActionList
              actionRole="menuitem"
              :items="[
                {
                  content: $t('seguimientoFichaAmpliada.ficha.descargar'),
                  onAction: () => descargarFicha(slotProps.data),
                  icon: ArrowDownToLineSolid,
                },
                {
                  content: $t('seguimientoFichaAmpliada.documento.documentos'),
                  onAction: () => showPestaniaDocumento(slotProps.data),
                  icon: PlusSolid,
                },
                {
                  content: $t('seguimientoFichaAmpliada.informeCasos.label.informeCaso'),
                  onAction: () => showInformeFicha(slotProps.data),
                  icon: PencilSolid,
                },
              ]"
            />
          </FPopover>
        </template>
      </Column>

      <!-- VALORACIÓN -->
      <Column v-if="codPerfilUsuario === 1">
        <template #body="{ data }">
          <FPopover v-if="codPerfilUsuario === 1" autofocusTarget="first-node">
            <template #activator="{ props }">
              <FButton disclosure v-bind="props" @click="btEstadoSolicitud(data)">
                Valoración
              </FButton>
            </template>

            <FActionList
              actionRole="menuitem"
              :items="[
                {
                  content: $t('seguimientoFichaAmpliada.ficha.label.activarRecalculo'),
                  onAction: () => activarValoracionFicha(data),
                  icon: CheckSolid,
                },
                {
                  content: $t('seguimientoFichaAmpliada.ficha.label.noActivarRecalculo'),
                  onAction: () => btMotivoNoActivacion(),
                  icon: XmarkSolid,
                },
              ]"
            />
          </FPopover>
        </template>
      </Column>
    </DataTable>

    <FModal
      v-model="activeOld"
      title="Detalle Formulario Información Complementaria"
      :secondaryActions="[{ content: 'Cancelar', onAction: () => (activeOld = false) }]"
    >
      <FModalSection>
        <FVerticalStack gap="4">
          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Puntuación: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getValoracionFicha?.vafValoracion }}
          </FText>

          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Quintil/Nivel: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getValoracionFicha?.sbeRangoFicha.rafDescripcion }} /
            {{ getValoracionFicha?.sbeRangoFicha.rafEtiqueta }}
          </FText>
        </FVerticalStack>
      </FModalSection>
    </FModal>

    <FModal
      v-model="active"
      title="Detalle Quintil/Nivel"
      :secondaryActions="[{ content: 'Cancelar', onAction: () => (active = false) }]"
    >
      <FModalSection>
        <FVerticalStack gap="4">
          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Puntuación: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getValoracionFicha?.vafValoracion }}
          </FText>

          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Quintil/Nivel: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getValoracionFicha?.sbeRangoFicha.rafDescripcion }} /
            {{ getValoracionFicha?.sbeRangoFicha.rafEtiqueta }}
          </FText>
        </FVerticalStack>
      </FModalSection>
    </FModal>

    <FModal
      v-model="editMotivo"
      title="Registrar la no activación del recálculo"
      :primaryAction="{ content: 'Guardar', onAction: noActivarValoracion }"
      :secondaryActions="[{ content: 'Cancelar', onAction: () => (editMotivo = false) }]"
    >
      <FModalSection>
        <FVerticalStack gap="4">
          <FTextField
            :label="$t('seguimientoFichaAmpliada.ficha.label.motivoNoActivacion')"
            :multiline="2"
            v-model="observaciones"
            showCharacterCount
            :max-length="200"
            required-indicator
            :error="motivoError && $t('seguimientoFichaAmpliada.ficha.error.motivo')"
          />
        </FVerticalStack>
      </FModalSection>
    </FModal>

    <FModal
      v-model="activeSol"
      title="Detalle Solicitud"
      :secondaryActions="[{ content: 'Cancelar', onAction: () => (activeSol = false) }]"
    >
      <FModalSection>
        <FVerticalStack gap="4">
          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Código: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getSolicitudEvento?.solCodigo }}
          </FText>

          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Fecha: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getSolicitudEvento?.soeFecha }}
          </FText>

          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Estado: </FText>
          <FText as="h1" variant="bodyMd">
            <FBadge
              :status="getSolicitudEvento?.soeEstado === 'K' ? 'success' : undefined"
            >
              {{ getSolicitudEvento?.soeEstado === "L" ? "Habilitado" : "Tramitado" }}
            </FBadge>
          </FText>

          <FText as="h1" variant="bodyMd" :font-weight="'bold'"> Observación: </FText>
          <FText as="h1" variant="bodyMd">
            {{ getSolicitudEvento?.soeObservacion }}
          </FText>
        </FVerticalStack>
      </FModalSection>
    </FModal>
  </FVerticalStack>
</template>

<script setup lang="ts">
import {
  PlusSolid,
  PencilSolid,
  ArrowDownToLineSolid,
  CheckSolid,
  XmarkSolid,
  MagnifyingGlassSolid,
  CircleInfoSolid,
  ClipboardSolid,
} from "@ups-dev/freya-icons";
import { useDatosSeguimientoFicha, useDatosAlumno } from "~/composables";
import { useDatosSegDocSolicitados } from "~/composables/datosSeguimientoFicha/useDatosSegDocSolicitados";
import { useDatosSegInformeFicha } from "~/composables/datosSeguimientoFicha/useDatosSegInformeFicha";
import { useDatosValoracionFicha } from "~/composables/datosSeguimientoFicha/useDatosValoracionFicha";
import { SolSolicitudEvento } from "~/models/datosSeguimientoFicha/solicitudEvento.model";
import { useDatosSolicitudEvento } from "~/composables/datosSeguimientoFicha/useDatosSolicitudEvento";
import { useField, useForm } from "vee-validate";
import { useValoracionFichaService } from "~/composables/services/seguimientoFicha/useValoracionFichaService";
import { SbeValoracionFicha } from "~/models/datosSeguimientoFicha/valoracionFicha.model";

//*variable global
const storeClient = useDatosFichaStore();
const {
  tabDocumento,
  codigoFicha,
  idCedula,
  pelCodigo,
  idRucEjecutor,
  codPerfilUsuario,
  codigoAlumno,
  tipoFicha,
  solCodigo,
} = storeToRefs(storeClient);

const router = useRouter();
const activaValoracion = ref<boolean>(false);
const active = ref(false); //Quintil Nuevo
const activeOld = ref(false); //Quintil Anterior
const editMotivo = ref(false);
const activeSol = ref(false);
const yaTramitada = ref(false);
let codigoSolicitud = ref<number>();
let asignadoSolicitud = ref<number>();

onBeforeMount(() => {
  if (idRucEjecutor.value && pelCodigo.value) {
    tabDocumento.value = false;
    obtenerFichasCompletas();
  }
});

watch(
  () => pelCodigo.value,
  async () => {
    obtenerFichasCompletas();
  }
);

const descargarFicha = async (fichaCompleta: any) => {
  codigoFicha.value = fichaCompleta.fisCodigo;
  pelCodigo.value = fichaCompleta.pelCodigo;
  await generarFichaPDF(codigoFicha.value, pelCodigo.value!);
};

const showPestaniaDocumento = async (fichaCompleta: any) => {
  tabDocumento.value = true;
  codigoFicha.value = fichaCompleta.fisCodigo;
  idCedula.value = fichaCompleta.aluIdentificacion;
  solCodigo.value = fichaCompleta.solCodigo;

  //* Lista documentos solicitados al estudiante
  await obtenerDocumentosSolicitadosFicha();
};

const showInformeFicha = async (fichaCompleta: any) => {
  codigoFicha.value = fichaCompleta.fisCodigo;
  idCedula.value = fichaCompleta.aluIdentificacion;
  solCodigo.value = fichaCompleta.solCodigo;

  //* Lista informe ficha ampliada y Datos del Estudiante
  await obtenerInformeFichaAmpliada();
  await obtenerDatosEstudiante();
  router.push({ path: "create" });
};

const btVerQuintilFicha = async (aluCodigo: number, tfsCodigo: number) => {
  if (tfsCodigo === 2) {
    activeOld.value = true;
  } else if (tfsCodigo === 5) {
    active.value = true;
  }
  codigoAlumno.value = aluCodigo;
  tipoFicha.value = tfsCodigo;
  await obtenerValoracionFicha5();
};

const verQuintilFicha2 = async (aluCodigo: number, tfsCodigo: number) => {
  const getValoracionFicha2 = ref<SbeValoracionFicha>();
  const texto = ref<string>();
  const resp = await getPuntuacionFicha_v2_v5(aluCodigo, tfsCodigo);
  getValoracionFicha2.value = resp.valoracionFichaResponse.sbeValoracionFicha;
  texto.value =
    getValoracionFicha2.value?.sbeRangoFicha.rafEtiqueta +
    "/" +
    getValoracionFicha2.value?.sbeRangoFicha.rafDescripcion;
  return texto.value;
};

const btVerSolicitud = async (fichaCompleta: any) => {
  activeSol.value = true;
  btEstadoSolicitud(fichaCompleta);
};

const btEstadoSolicitud = async (fichaCompleta: any) => {
  //Obtiene el estado de la solicitud SOLICITUD_EVENTO
  solCodigo.value = fichaCompleta.solCodigo;
  idCedula.value = fichaCompleta.aluIdentificacion;
  await obtenerSolicitudEvento();

  //Obtiene la Valoración de la ficha v5
  if (activeSol.value === false) {
    codigoAlumno.value = fichaCompleta.aluCodigo;
    tipoFicha.value = 5;
    await obtenerValoracionFicha5();
  }
};

const btMotivoNoActivacion = () => {
  if (getSolicitudEvento.value?.soeEstado !== "K" && getValoracionFicha.value === null) {
    editMotivo.value = true;
  } else {
    yaTramitada.value = true;
    setTimeout(() => {
      yaTramitada.value = false;
    }, 5000);
  }
};

//Valida campos texto obligatorios
const { handleSubmit } = useForm();
const { value: observaciones, errorMessage: motivoError } = useField<string>(
  "observaciones",
  { required: true }
);

const noActivarValoracion = handleSubmit(async () => {
  //Se cambia el estado de la solicitud
  await cambiarEstadoSolicitud();

  //Enviar correos
  await enviarNotificacionAnexo16NoAp(idCedula.value!, solCodigo.value!); //al estudiante
  await enviarNotificacionAnexo17NoAp(idCedula.value!, solCodigo.value!); //al trabajador social

  //Cerrar ventana emergente
  editMotivo.value = false;
  activaValoracion.value = true;
  setTimeout(() => {
    activaValoracion.value = false;
  }, 5000);
  window.scrollTo(0, 0);
});

const activarValoracionFicha = async (fichaCompleta: any) => {
  if (getSolicitudEvento.value?.soeEstado !== "K" && getValoracionFicha.value === null) {
    await generarValoracionFichaEstudiante(fichaCompleta.fisCodigo, pelCodigo.value!);

    //Se cambia el estado de la solicitud
    await cambiarEstadoSolicitud();

    //Enviar correos
    await enviarNotificacionAnexo16Ap(
      fichaCompleta.aluIdentificacion,
      fichaCompleta.solCodigo
    ); //al estudiante
    await enviarNotificacionAnexo17Ap(
      fichaCompleta.aluIdentificacion,
      fichaCompleta.solCodigo
    ); //al trabajador social

    activaValoracion.value = true;
    setTimeout(() => {
      activaValoracion.value = false;
    }, 5000);
    window.scrollTo(0, 0);
  } else {
    yaTramitada.value = true;
    setTimeout(() => {
      yaTramitada.value = false;
    }, 5000);
  }
};

const cambiarEstadoSolicitud = async () => {
  //Actualiza estado de la solicitud
  getSolicitudEvento.value!.soeVigente = "N";
  await actualizarSolicitudEvento(
    JSON.parse(JSON.stringify(getSolicitudEvento.value)),
    getSolicitudEvento.value!.soeCodigo
  );
  codigoSolicitud.value = getSolicitudEvento.value!.solCodigo;
  asignadoSolicitud.value = getSolicitudEvento.value!.perCodigo;

  //Crear nuevo estado de la solicitud a TRAMITADO CERRADO 'K'
  getSolicitudEvento.value = {} as SolSolicitudEvento;
  getSolicitudEvento.value!.perCodigo = asignadoSolicitud.value!;
  getSolicitudEvento.value!.solCodigo = codigoSolicitud.value;
  getSolicitudEvento.value!.soeObservacion = observaciones.value;
  await guardarSolicitudEvento(JSON.parse(JSON.stringify(getSolicitudEvento.value)));
};

const {
  getPeriodosLectivos,
  //* Fichas v5
  getFichasCompletas,
  obtenerFichasCompletas,
  generarFichaPDF,
} = useDatosSeguimientoFicha();

const {
  //* Documentos
  obtenerDocumentosSolicitadosFicha,
} = useDatosSegDocSolicitados();

const {
  //* Informe Ficha v5
  obtenerInformeFichaAmpliada,
} = useDatosSegInformeFicha();

const {
  //* Valoracion Ficha v5
  getValoracionFicha,
  obtenerValoracionFicha5,
} = useDatosValoracionFicha();

const {
  //* Valoracion Ficha v2
  getPuntuacionFicha_v2_v5,
} = useValoracionFichaService();

const { generarValoracionFichaEstudiante } = useValoracionFichaService();

const {
  //* Solicitud Evento
  getSolicitudEvento,
  obtenerSolicitudEvento,
  guardarSolicitudEvento,
  actualizarSolicitudEvento,
} = useDatosSolicitudEvento();

const { obtenerDatosEstudiante } = useDatosAlumno();

const {
  enviarNotificacionAnexo16Ap,
  enviarNotificacionAnexo17Ap,
  enviarNotificacionAnexo16NoAp,
  enviarNotificacionAnexo17NoAp,
} = useSendEmailService();
</script>

<style lang="css" scoped></style>
