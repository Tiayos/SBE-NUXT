¿
<template>
  <FCard>
    <Accordion :activeIndex="1" expandIcon="pi pi-plus" collapseIcon="pi pi-minus">
      <AccordionTab>
        <template #header>
          <FCardSection
            :title="$t('ficha.tituloDatosEconomicos')"
            style="background-color: #4682b4; color: white; width: 100%"
          />
        </template>

        <FCardSection>
          <FVerticalStack gap="4">
            <FText as="h6" variant="headingMd" font-weight="bold">
              {{ $t("ficha.datosEconomicos.titulo31") }}:
            </FText>
            <FDivider />
          </FVerticalStack>

          <FHorizontalGrid :columns="columns">
            <FText as="h6" variant="headingMd" font-weight="bold">
              {{ $t("ficha.datosEconomicos.numeroMiembros") }}:
            </FText>
            <FTextField
              type="number"
              id="numeroMiembros"
              name="numeroMiembros"
              autoComplete="off"
              v-model="sbeCamposWrapper.numeroMiembros"
            ></FTextField>
          </FHorizontalGrid>
        </FCardSection>
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

const transition = {
  duration: "var(--f-motion-duration-150)",
  timingFunction: "var(--f-motion-ease-in-out)",
};

const columns = {
  xs: "1.5fr 0.5fr",
  sm: "2fr 1fr",
  md: "1fr 3fr auto 1fr",
  lg: "2fr 4fr auto 2fr 3fr auto",
};
</script>
<style scoped></style>
