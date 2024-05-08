¿
<template>
  <FCard>
    <Accordion :activeIndex="1" expandIcon="pi pi-plus" collapseIcon="pi pi-minus">
      <AccordionTab>
        <template #header>
          <FCardSection
            :title="$t('ficha.situacionHabitacional.tituloPrincipal')"
            style="background-color: #4682b4; color: white; width: 100%"
          />
        </template>

        <FCardSection>
          <FVerticalStack gap="4">
            <FText as="h6" variant="headingMd" font-weight="bold">
              {{ $t("ficha.situacionHabitacional.titulo41") }}:
            </FText>
            <FDivider />

            <FFormLayout>
              <FFormLayoutGroup condensed>
                <FCheckbox
                  :label="$t('ficha.situacionHabitacional.propia')"
                  :checked="sbeParametros.tipoTenenciaVivienda == 2041"
                  id="2041"
                  name="tenenciaVivienda"
                  @change="() => handleChange(2041)"
                />
                <FCheckbox
                  :label="$t('ficha.situacionHabitacional.cedida')"
                  :checked="sbeParametros.tipoTenenciaVivienda == 2042"
                  id="2042"
                  name="tenenciaVivienda"
                  @change="() => handleChange(2042)"
                />

                <FFormLayout>
                  <FFormLayoutGroup>
                    <FCheckbox
                      :label="$t('ficha.situacionHabitacional.viviendaArrendada')"
                      :checked="sbeParametros.tipoTenenciaVivienda == 2043"
                      id="2043"
                      name="tenenciaVivienda"
                      @change="() => handleChange(2043)"
                    />
                    <InputNumber
                      v-model="sbeCamposWrapper.valorPagoMensualArriendo"
                      :disabled="sbeParametros.tipoTenenciaVivienda != 2043"
                      inputId="costoTotalArriendo"
                      style="
                        width: 100%;
                        height: 2.25rem;
                        text-align: right !important;
                        overflow: hidden;
                        border-top: none;
                        border-left: none;
                        border-right: none;
                      "
                    />
                  </FFormLayoutGroup>
                </FFormLayout>

                <FFormLayout>
                  <FFormLayoutGroup>
                    <FCheckbox
                      :label="$t('ficha.situacionHabitacional.viviendaHipotecada')"
                      :checked="sbeParametros.tipoTenenciaVivienda == 2044"
                      id="2044"
                      name="tenenciaVivienda"
                      @change="() => handleChange(2044)"
                    />
                    <InputNumber
                      v-model="sbeCamposWrapper.valorPagoMensualHipoteca"
                      :disabled="sbeParametros.tipoTenenciaVivienda != 2044"
                      inputId="costoTotalHipoteca"
                      style="
                        width: 100%;
                        height: 2.25rem;
                        text-align: right !important;
                        overflow: hidden;
                        border-top: none;
                        border-left: none;
                        border-right: none;
                      "
                    />
                  </FFormLayoutGroup>
                </FFormLayout>
              </FFormLayoutGroup>
            </FFormLayout>
          </FVerticalStack>
        </FCardSection>
      </AccordionTab>
    </Accordion>
  </FCard>
</template>
<script setup lang="ts">
const { sbeCamposWrapper, sbeParametros } = useSituacionHabitacional();

const open = ref(true);
const handleToggle = () => (open.value = !open.value);

const handleChange = (newValue: any) => {
  sbeParametros.value.tipoTenenciaVivienda = newValue;
  sbeCamposWrapper.value.valorPagoMensualArriendo = undefined;
  sbeCamposWrapper.value.valorPagoMensualHipoteca = undefined;
};
</script>
<style scoped></style>
