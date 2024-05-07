<template>
  <FCard sectioned>
    <FText as="h6" variant="headingMd" font-weight="bold">
      {{ $t("ficha.datosEconomicos.titulo32") }}:
    </FText>
    <FDivider />

    <FFormLayout>
      <FLayoutSection>
        <FCard sectioned>
          <DataTable
            :value="datosEconomicosMiembrosFamiliarList"
            :showGridlines="true"
            :stripedRows="true"
            tableStyle="min-width: 50rem"
            :paginator="true"
            :rows="10"
          >
            <template #header>
              <div
                class="flex flex-wrap align-items-center justify-content-between gap-2"
              >
                <FHorizontalStack gap="2">
                  <FButton
                    @click="prepareCreate"
                    size="medium"
                    :icon="PlusSolid"
                    PlusSolid
                    primary
                    >Crear</FButton
                  >
                </FHorizontalStack>
              </div>
            </template>
            <Column field="codigo" header="codigo" style="width: 5px"> </Column>
            <Column
              field="nombre_familiar"
              header="Nombre del familiar"
              style="width: 5px"
            ></Column>
            <Column
              field="numero_identificacion"
              header="Número de identificación"
              style="width: 5px"
            ></Column>
            <Column
              field="sbe_instruccionDTO.descripcion"
              header="Nivel Máximo de educación que completó"
              style="width: 10px"
              headerStyle="text-align: center;"
              bodyStyle="text-align: center;"
            >
            </Column>
            <Column
              field="sbe_parentescoDTO.nombre"
              header="Parentesco"
              style="width: 10px"
              headerStyle="text-align: center;"
              bodyStyle="text-align: center;"
            >
            </Column>
            <Column
              field="sbe_tipo_empresa.nombre"
              header="Tipo de empresa en la que labora"
              style="width: 10px"
              headerStyle="text-align: center;"
              bodyStyle="text-align: center;"
            >
            </Column>
            <Column field="ingresos_mensuales" header="Ingresos económicos mensuales">
              <template #body="slotProps">
                {{ formatCurrency(slotProps.data.ingresos_mensuales) }}
              </template>
            </Column>

            <Column style="width: 10px">
              <template #body="slotProps">
                <FButton
                  size="slim"
                  :icon="PencilSolid"
                  @click="prepareEdit(slotProps.data)"
                  >Editar</FButton
                >
              </template>
            </Column>
            <Column style="width: 10px">
              <template #body="slotProps">
                <FButton
                  size="slim"
                  secondary
                  :icon="TrashCanSolid"
                  @click="handleChangeDeleteModal(slotProps.data)"
                >
                  Eliminar</FButton
                >
              </template>
            </Column>

            <template #footer>
              <FHorizontalStack gap="4" align="end" block-align="end">
                <FText as="h3" variant="bodyLg" :font-weight="'bold'">
                  {{
                    $t("ficha.datosEconomicos.totalIngresosMiembrosFamiliares")
                  }}:</FText
                >
                <InputNumber
                  v-model="sbeCamposWrapper.totalIngresosMensuales"
                  :disabled="true"
                  inputId="totalIngresosMiembrosFamiliares"
                  style="
                    width: 200px;
                    height: 2.25rem;
                    text-align: right !important;
                    overflow: hidden;
                    border-top: none;
                    border-left: none;
                    border-right: none;
                  "
                />
              </FHorizontalStack>
            </template>
          </DataTable>

          <FModal
            :full-screen="true"
            title=""
            titleHidden
            v-model="activeCreateModal"
            :primaryAction="{ content: 'save', onAction: onSubmited }"
          >
            <FCardSection>
              <FText variant="bodyMd" font-weight="semibold" as="h1"
                >{{ $t("ficha.datosEconomicos.nuevoMiembroTittle") }}
              </FText>
              <FDivider />
            </FCardSection>
            <FModalSection>
              <FVerticalStack gap="8" full-width>
                <FTextField
                  :label="$t('ficha.datosEconomicos.nombreCompleto')"
                  type="text"
                  :error="v$?.nombre_familiar.$error"
                  :required-indicator="true"
                  autoComplete="off"
                  v-model="miembroGrupoFamiliar.nombre_familiar"
                />
                <FLabelled
                  id="tipoIdentificacion"
                  :label="$t('ficha.datosEconomicos.tipoIdentificacion')"
                  required-indicator
                >
                  <Dropdown
                    v-model="tipoIdentificacion"
                    :options="tiposIdentificacion"
                    :style="[
                      tipoIdentificacion == null && v$?.numero_identificacion.$error
                        ? { 'border-color': 'red' }
                        : {},
                    ]"
                    optionLabel="name"
                    optionValue="name"
                    placeholder="Seleccione"
                    style="height: fit-content"
                  />
                </FLabelled>

                Número de identificación
                <FTextField
                  type="text"
                  v-model="miembroGrupoFamiliar.numero_identificacion"
                  :label="
                    v$?.numero_identificacion.$error ? 'Este campo es requerido' : ''
                  "
                  :error="v$?.numero_identificacion.$error"
                  :required-indicator="true"
                  autoComplete="off"
                  id="numeroIdentificacion"
                  :disabled="tipoIdentificacion == null"
                />
                <FTextField
                  :label="$t('ficha.datosEconomicos.fechaNacimiento')"
                  type="date"
                  :error="v$?.fecha_nacimiento.$error"
                  :required-indicator="true"
                  v-model="fechaNacimiento"
                />
                <FLabelled
                  id="nivelInstruccion"
                  :label="$t('ficha.datosEconomicos.nivelIntruccion')"
                >
                  <Dropdown
                    style="width: 100%"
                    :placeholder="$t('app.label.seleccione')"
                    :options="nivelesInstruccionList"
                    optionLabel="descripcion"
                    optionValue="codigo"
                    v-model="miembroGrupoFamiliar.sbe_instruccionDTO.codigo"
                    :style="[
                      v$.sbe_instruccionDTO.$error ? { 'border-color': 'red' } : {},
                    ]"
                    required
                  >
                  </Dropdown>
                </FLabelled>

                <FLabelled
                  id="parentesco"
                  :label="$t('ficha.datosEconomicos.parentesco')"
                  required-indicator
                >
                  <Dropdown
                    style="width: 100%"
                    :placeholder="$t('app.label.seleccione')"
                    :options="parentescosList"
                    optionLabel="nombre"
                    optionValue="codigo"
                    :style="[
                      v$.sbe_parentescoDTO.$error ? { 'border-color': 'red' } : {},
                    ]"
                    required
                    v-model="miembroGrupoFamiliar.sbe_parentescoDTO.codigo"
                  >
                  </Dropdown>
                </FLabelled>

                <FLabelled
                  id="tipoEmpresa"
                  :label="$t('ficha.datosEconomicos.tipoEmpresa')"
                  required-indicator
                >
                  <Dropdown
                    style="width: 100%"
                    :placeholder="$t('app.label.seleccione')"
                    :options="tipoEmpresaList"
                    optionLabel="nombre"
                    optionValue="codigo"
                    :style="[v$.sbe_tipo_empresa.$error ? { 'border-color': 'red' } : {}]"
                    required
                    v-model="miembroGrupoFamiliar.sbe_tipo_empresa.codigo"
                  >
                  </Dropdown>
                </FLabelled>
                <FLabelled
                  id="ingresosMensuales"
                  :label="$t('ficha.datosEconomicos.ingresosMensuales')"
                  required-indicator
                >
                </FLabelled>
                <FBox
                  background="bg"
                  padding="0"
                  borderWidth="1"
                  style="margin-top: -10px"
                  :style="[
                    v$.ingresos_mensuales.$error
                      ? { 'border-color': 'red' }
                      : { 'border-color': '#898f94' },
                  ]"
                >
                  <InputNumber
                    v-model="miembroGrupoFamiliar.ingresos_mensuales"
                    inputId="minmaxfraction"
                    :minFractionDigits="2"
                    :maxFractionDigits="2"
                  />
                </FBox>
              </FVerticalStack>
            </FModalSection>
          </FModal>

          <FModal
            v-model="deleteModal"
            title=""
            title-hidden
            :primaryAction="{
              content: 'Eliminar',
              onAction: confirmDelete,
            }"
            :secondaryActions="[
              {
                content: 'Cancelar',
                onAction: changeDeleteModal,
              },
            ]"
          >
            <FModalSection title-hidden style="text-align: center">
              <FVerticalStack gap="4">
                <FText
                  as="h5"
                  variant="headingMd"
                  :font-weight="'semibold'"
                  style="text-align: center"
                >
                  {{ $t("ficha.datosEconomicos.eliminar") }}
                </FText>
              </FVerticalStack>
            </FModalSection>
          </FModal>
        </FCard>
      </FLayoutSection>
    </FFormLayout>
    <FichaDatosEconomicosDatosEconomicos321></FichaDatosEconomicosDatosEconomicos321>
  </FCard>
</template>
<script setup lang="ts">
import { PlusSolid, PencilSolid, TrashCanSolid } from "@ups-dev/freya-icons";
import { useField, useForm } from "vee-validate";
import { SituacionFamiliar } from "~/models/datosEconomicos/situacionFamiliar.model";
import { Instruccion } from "~/models/datosEconomicos/instruccion.model";
import { Parentesco } from "~/models/datosEconomicos/parentesco.model";
import { TipoEmpresa } from "~/models/datosEconomicos/tipoEmpresa.model";
import { EstadoCivil } from "~/models/datosEconomicos/estadoCivil.model";
import { FichaSocioeconomica } from "~/models/datosEconomicos/fichaSocioeconomica.model";

const {
  datosEconomicosMiembrosFamiliarList,
  nivelesInstruccionList,
  parentescosList,
  tipoEmpresaList,
  miembroGrupoFamiliar,
  tipoIdentificacion,
  persistAction,
  viewAction,
  v$,
  saveMiembroFamiliar,
  obtenerMiembrosSituacionFamiliar,
  editMiembroFamiliar,
  deleteMiembroFamiliar,
  toast,
  sbeCamposWrapper,
} = useDatosEconomicos();
const activeCreateModal = ref<boolean>(false);
const { handleSubmit, errors, resetForm, resetField } = useForm();
const tiposIdentificacion = ref([{ name: "CEDULA" }, { name: "PASAPORTE" }]);
const fechaNacimiento = ref<string>("");
const deleteModal = ref<boolean>(false);
const codigoMiembroFamiliar = ref<Number>(0);

const formatCurrency = (value: any) => {
  return (
    "$" +
    new Intl.NumberFormat("en-US", { style: "currency", currency: "USD" })
      .format(value)
      .slice(1)
  );
};

const prepareCreate = () => {
  miembroGrupoFamiliar.value = {} as SituacionFamiliar;
  miembroGrupoFamiliar.value.sbe_instruccionDTO = {} as Instruccion;
  miembroGrupoFamiliar.value.sbe_parentescoDTO = {} as Parentesco;
  miembroGrupoFamiliar.value.sbe_tipo_empresa = {} as TipoEmpresa;
  miembroGrupoFamiliar.value.estado_civil = { codigo: 7 } as EstadoCivil;
  miembroGrupoFamiliar.value.ficha_socioeconomica = {
    fis_codigo: 137619,
  } as FichaSocioeconomica;
  miembroGrupoFamiliar.value.tipo_situacion = "V";
  viewAction.value = persistAction.create;
  handleChangeCreateModal();
};

const prepareEdit = async (miembroSituacionFamiliar: SituacionFamiliar) => {
  miembroGrupoFamiliar.value = { ...miembroSituacionFamiliar };
  if (miembroGrupoFamiliar.value.fecha_nacimiento != null) {
    fechaNacimiento.value = miembroGrupoFamiliar.value.fecha_nacimiento.toString();
  }
  activeCreateModal.value = !activeCreateModal.value;
  viewAction.value = persistAction.edit;
};

const handleChangeCreateModal = () => {
  activeCreateModal.value = !activeCreateModal.value;
  v$.value.$silentErrors;
  v$.value.$reset;
  resetForm;
};

const handleChangeDeleteModal = (miembroSituacionFamiliar: SituacionFamiliar) => {
  deleteModal.value = !deleteModal.value;
  codigoMiembroFamiliar.value = miembroSituacionFamiliar.codigo;
};

const confirmDelete = async () => {
  await deleteMiembroFamiliar(codigoMiembroFamiliar.value);
  await obtenerMiembrosSituacionFamiliar();
  toast.add({
    severity: "success",
    summary: "Situación Familiar",
    detail: `Se ha eliminado el miembro familiar correctamente`,
    life: 5000,
  });
  changeDeleteModal();
};

const changeDeleteModal = () => {
  deleteModal.value = !deleteModal.value;
};

watch(
  () => fechaNacimiento.value,
  (newValue, oldValue) => {
    miembroGrupoFamiliar.value.fecha_nacimiento = toDate(fechaNacimiento.value);
  }
);

const toDate = (date: string) => {
  const dateParts = date.split("-");
  const year = parseInt(dateParts[0]);
  const month = parseInt(dateParts[1]) - 1; // Month is zero-based
  const day = parseInt(dateParts[2]);
  return new Date(year, month, day);
};

const onSubmited = handleSubmit(async (values) => {
  v$.value.$validate();
  if (!v$.value.$error) {
    handleChangeCreateModal();

    if (viewAction.value == persistAction.create) {
      await saveMiembroFamiliar(miembroGrupoFamiliar.value);
    } else if (viewAction.value == persistAction.edit) {
      await editMiembroFamiliar(
        miembroGrupoFamiliar.value,
        miembroGrupoFamiliar.value.codigo
      );
    }

    await obtenerMiembrosSituacionFamiliar();
    toast.add({
      severity: "success",
      summary: "Situación Familiar",
      detail: `Se ha agregado un nuevo miembro familiar correctamente`,
      life: 5000,
    });
  }
});
</script>
<style lang="css">
.p-inputtext {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial,
    sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
  font-size: 1rem;
  color: #495057;
  background: #ffffff;
  padding: 0.5rem 0.75rem;
  border: 1px solid #ced4da;
  transition: background-color 0.15s, border-color 0.15s, box-shadow 0.15s;
  appearance: none;
  border-radius: 4px;
}
.p-inputtext:enabled:hover {
  border-color: #ced4da;
}
.p-inputtext:enabled:focus {
  outline: 0 none;
  outline-offset: 0;
  box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.5);
  border-color: #007bff;
}
.p-inputtext.ng-dirty.ng-invalid {
  border-color: #dc3545;
}

p-inputnumber.ng-dirty.ng-invalid > .p-inputnumber > .p-inputtext {
  border-color: #dc3545;
}

p-inputnumber.p-inputnumber-clearable .p-inputnumber-input {
  padding-right: 2.5rem;
}
p-inputnumber.p-inputnumber-clearable .p-inputnumber-clear-icon {
  color: #495057;
  right: 0.75rem;
}

p-inputnumber.p-inputnumber-clearable
  .p-inputnumber-buttons-stacked
  .p-inputnumber-clear-icon {
  right: 3.107rem;
}
p-inputnumber.p-inputnumber-clearable
  .p-inputnumber-buttons-horizontal
  .p-inputnumber-clear-icon {
  right: 3.107rem;
}
</style>
