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
            </FCardSection>
            <FModalSection>
              <FVerticalStack gap="8" full-width>
                <FTextField
                  :label="$t('ficha.datosEconomicos.nombreCompleto')"
                  type="text"
                  autoComplete="off"
                  v-model="miembroGrupoFamiliar.nombre_familiar"
                />
                <FLabelled
                  id="tipoIdentificacion"
                  :label="$t('ficha.datosEconomicos.tipoIdentificacion')"
                >
                  <Dropdown
                    v-model="tipoIdentificacion"
                    :options="tiposIdentificacion"
                    optionLabel="name"
                    optionValue="name"
                    placeholder="Seleccione"
                    style="height: fit-content"
                  />
                </FLabelled>

                <FTextField
                  type="text"
                  v-model="miembroGrupoFamiliar.numero_identificacion"
                  autoComplete="off"
                  id="numeroIdentificacion"
                  :disabled="tipoIdentificacion == null"
                />
                <FTextField
                  :label="$t('ficha.datosEconomicos.fechaNacimiento')"
                  type="date"
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
                    v-model="instruccion.codigo"
                  >
                  </Dropdown>
                </FLabelled>

                <FLabelled
                  id="parentesco"
                  :label="$t('ficha.datosEconomicos.parentesco')"
                >
                  <Dropdown
                    style="width: 100%"
                    :placeholder="$t('app.label.seleccione')"
                    :options="parentescosList"
                    optionLabel="nombre"
                    optionValue="codigo"
                    v-model="parentesco.codigo"
                  >
                  </Dropdown>
                </FLabelled>

                <FLabelled
                  id="tipoEmpresa"
                  :label="$t('ficha.datosEconomicos.tipoEmpresa')"
                >
                  <Dropdown
                    style="width: 100%"
                    :placeholder="$t('app.label.seleccione')"
                    :options="tipoEmpresaList"
                    optionLabel="nombre"
                    optionValue="codigo"
                    v-model="tipoEmpresa.codigo"
                  >
                  </Dropdown>
                </FLabelled>

                <FTextField
                  type="number"
                  prefix="$"
                  placeholder="0.0"
                  v-model="miembroGrupoFamiliar.ingresos_mensuales"
                ></FTextField>
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

const {
  datosEconomicosMiembrosFamiliarList,
  nivelesInstruccionList,
  parentescosList,
  tipoEmpresaList,
  miembroGrupoFamiliar,
  instruccion,
  parentesco,
  tipoEmpresa,
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
  viewAction.value = persistAction.create;
  handleChangeCreateModal();
};
const handleChangeCreateModal = () => {
  activeCreateModal.value = !activeCreateModal.value;
};

const onSubmited = handleSubmit((values) => {
  handleChangeCreateModal();
});
</script>
<style lang="css"></style>
