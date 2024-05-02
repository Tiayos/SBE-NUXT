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
            <Column
              field="ingresos_mensuales"
              header="Ingresos económicos mensuales"
              style="width: 10px"
              headerStyle="text-align: center;"
              bodyStyle="text-align: center;"
            >
            </Column>
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

                <FTextField
                  type="text"
                  v-model="miembroGrupoFamiliar.numero_identificacion"
                  :label="$t('ficha.datosEconomicos.numeroIdentificacion')"
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
                  v-model="miembroGrupoFamiliar.fecha_nacimiento"
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
        </FCard>
      </FLayoutSection>
    </FFormLayout>
  </FCard>
</template>
<script setup lang="ts">
import { PlusSolid, PencilSolid, TrashCanSolid } from "@ups-dev/freya-icons";
import { useField, useForm } from "vee-validate";
import { required } from "@vee-validate/rules";
import { SituacionFamiliar } from "~/models/datosEconomicos/situacionFamiliar.model";

const {
  datosEconomicosMiembrosFamiliarList,
  nivelesInstruccionList,
  parentescosList,
  tipoEmpresaList,
  miembroGrupoFamiliar,
  v$,
} = useDatosEconomicos();
const viewAction = ref<persistAction>();
const activeCreateModal = ref<boolean>(false);
const { handleSubmit, errors, resetForm, resetField } = useForm();
const tiposIdentificacion = ref([{ name: "CEDULA" }, { name: "PASAPORTE" }]);
const tipoIdentificacion = ref();

enum persistAction {
  create,
  edit,
  view,
}

const prepareCreate = () => {
  v$.value.$silentErrors;
  miembroGrupoFamiliar.value = {} as SituacionFamiliar;
  viewAction.value = persistAction.create;
  handleChangeCreateModal();
};
const handleChangeCreateModal = () => {
  activeCreateModal.value = !activeCreateModal.value;
};

const onSubmited = handleSubmit((values) => {
  v$.value.$validate();
  if (!v$.value.$error) {
    console.log("NO HAY ERRORES");
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
