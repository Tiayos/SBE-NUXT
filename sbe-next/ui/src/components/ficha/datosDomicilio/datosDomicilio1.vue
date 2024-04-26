¿
<template>
  <FCard>
    <Accordion :activeIndex="1" expandIcon="pi pi-plus" collapseIcon="pi pi-minus">
      <AccordionTab>
        <template #header>
          <FCardSection
            :title="$t('ficha.tituloDatosDomicilio')"
            style="background-color: #4682b4; color: white; width: 100%"
          />
        </template>

        <FCardSection>
          <FVerticalStack gap="4">
            <FText as="h6" variant="headingMd" font-weight="bold">
              {{ $t("ficha.datosDomicilio.titulo21") }}:
            </FText>
            <FDivider />

            <FHorizontalStack gap="16">
              <FText as="h6" variant="headingMd">
                {{ $t("ficha.datosDomicilio.pais") }}:
              </FText>
              <Dropdown
                filter
                style="width: 25%"
                :options="paisesList"
                :placeholder="$t('app.label.seleccione')"
                optionLabel="paises"
                optionValue="codigoPaises"
                v-model="sbeCamposWrapper.pais"
              >
              </Dropdown>

              <FText as="h6" variant="headingMd">
                {{ $t("ficha.datosDomicilio.ciudad") }}:
              </FText>

              <Dropdown
                filter
                style="width: 25%"
                :options="ciudadesList"
                :placeholder="$t('app.label.seleccione')"
                optionLabel="ciudad"
                optionValue="codigoCiudad"
                v-model="sbeCamposWrapper.ciudad"
              >
              </Dropdown>
            </FHorizontalStack>

            <FHorizontalStack gap="16">
              <FText as="h6" variant="headingMd">
                {{ $t("ficha.datosDomicilio.parroquia") }}:
              </FText>

              <Dropdown
                filter
                style="width: 25%"
                :options="parroquiasList"
                :placeholder="$t('app.label.seleccione')"
                optionLabel="parroquias"
                optionValue="codigoParroquia"
                v-model="sbeCamposWrapper.parroquia"
              >
              </Dropdown>

              <FText as="h6" variant="headingMd">
                {{ $t("ficha.datosDomicilio.tipoParroquia") }}:
              </FText>

              <Dropdown
                style="width: 25%"
                :options="getTipoParroquiasList"
                :placeholder="$t('app.label.seleccione')"
                optionLabel="descripcion"
                optionValue="codigo"
                v-model="sbeParametros.tipoParroquia"
              >
              </Dropdown>
            </FHorizontalStack>

            <FFormLayout>
              <FFormLayoutGroup condensed>
                <FTextField
                  :label="$t('ficha.datosDomicilio.barrio')"
                  v-model="sbeCamposWrapper.barrio"
                  autoComplete="off"
                  type="text"
                  id="barrio"
                  name="barrio"
                />
                <FTextField
                  :label="$t('ficha.datosDomicilio.direccion')"
                  v-model="sbeCamposWrapper.direccion"
                  autoComplete="off"
                  type="text"
                  id="direccion"
                  name="direccion"
                />
              </FFormLayoutGroup>
            </FFormLayout>

            <FFormLayout>
              <FFormLayoutGroup condensed>
                <FTextField
                  :label="$t('ficha.datosDomicilio.tlfDomicilio')"
                  v-model="sbeCamposWrapper.tlfDomicilio"
                  autoComplete="off"
                  type="text"
                  id="tlfDomicilio"
                  name="tlfDomicilio"
                />
                <FTextField
                  :label="$t('ficha.datosDomicilio.tlfCelular')"
                  v-model="sbeCamposWrapper.tlfCelular"
                  autoComplete="off"
                  type="text"
                  id="tlfCelular"
                  name="tlfCelular"
                />
                <FTextField
                  :label="$t('ficha.datosDomicilio.whatsapp')"
                  v-model="sbeCamposWrapper.whatsapp"
                  autoComplete="off"
                  type="text"
                  id="whatsapp"
                  name="whatsapp"
                />
              </FFormLayoutGroup>
            </FFormLayout>

            <FFormLayout>
              <FFormLayoutGroup condensed>
                <FTextField
                  :label="$t('ficha.datosDomicilio.correoPersonal')"
                  v-model="sbeCamposWrapper.correoPersonal"
                  autoComplete="off"
                  type="text"
                  id="correoPersonal"
                  name="correoPersonal"
                />

                <FVerticalStack gap="4">
                  <FText as="h6" variant="headingMd" font-weight="regular">
                    {{ $t("ficha.datosDomicilio.correoInstitucional") }}:
                  </FText>
                  <FHorizontalStack gap="4" :align="'space-around'">
                    <FText as="h6" variant="headingMd" font-weight="semibold">
                      {{ insAlumno.email }}
                    </FText>
                  </FHorizontalStack>
                </FVerticalStack>
              </FFormLayoutGroup>
            </FFormLayout>
          </FVerticalStack>
        </FCardSection>

        <FichaDatosDomicilioDatosDomicilio2
          style="margin-top: 0px"
        ></FichaDatosDomicilioDatosDomicilio2>
      </AccordionTab>
    </Accordion>
  </FCard>
</template>
<script setup lang="ts">
const {
  insAlumno,
  sbeCamposWrapper,
  sbeParametros,
  paisesList,
  ciudadesList,
  parroquiasList,
  getTipoParroquiasList,
} = useDatosDomicilio();

const open = ref(true);
const handleToggle = () => (open.value = !open.value);
const transition = {
  duration: "var(--f-motion-duration-150)",
  timingFunction: "var(--f-motion-ease-in-out)",
};
</script>
<style scoped></style>
