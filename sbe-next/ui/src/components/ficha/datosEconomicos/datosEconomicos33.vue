import { FFormLayout, Style } from '../../../../.nuxt/components'; ¿
<template>
  <FCardSection>
    <FVerticalStack gap="4">
      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosEconomicos.titulo33") }}:
      </FText>
      <FDivider />

      <FFormLayout>
        <FFormLayoutGroup>
          <FVerticalStack gap="8">
            <FText as="h6" variant="headingMd" font-weight="semibold">
              {{ $t("ficha.datosEconomicos.numeroPropiedades") }}:
            </FText>

            <FFormLayout>
              <FFormLayoutGroup>
                <FRadioButton
                  :label="$t('ficha.datosEconomicos.viveSolo')"
                  id="1"
                  name="vivienda"
                  value="1"
                  :checked="sbeCamposWrapper.opcionViveGrupoFamiliarPropiedad === 1"
                  @change="handleChange"
                />

                <FTextField
                  type="number"
                  v-model="sbeCamposWrapper.numeroPropiedades"
                  v-if="sbeCamposWrapper.opcionViveGrupoFamiliarPropiedad == 1"
                ></FTextField>
              </FFormLayoutGroup>
            </FFormLayout>

            <FFormLayout>
              <FFormLayoutGroup>
                <FRadioButton
                  :label="$t('ficha.datosEconomicos.viveConGrupo')"
                  id="2"
                  name="vivienda"
                  value="2"
                  :checked="sbeCamposWrapper.opcionViveGrupoFamiliarPropiedad === 2"
                  @change="handleChange"
                />
                <FTextField
                  type="number"
                  v-model="sbeCamposWrapper.numeroPropiedades"
                  v-if="sbeCamposWrapper.opcionViveGrupoFamiliarPropiedad == 2"
                ></FTextField>
              </FFormLayoutGroup>
            </FFormLayout>

            <FText as="h6" variant="headingMd" font-weight="semibold">
              {{ $t("ficha.datosEconomicos.numeroVehiculos") }}:
            </FText>

            <FFormLayout>
              <FFormLayoutGroup>
                <FRadioButton
                  :label="$t('ficha.datosEconomicos.viveSolo')"
                  id="3"
                  name="numeroVehiculos"
                  value="3"
                  :checked="sbeCamposWrapper.opcionViveGrupoFamiliarVehiculos === 3"
                  @change="handleChange2"
                />

                <FTextField
                  type="number"
                  v-model="sbeCamposWrapper.numeroVehiculos"
                  v-if="sbeCamposWrapper.opcionViveGrupoFamiliarVehiculos == 3"
                ></FTextField>
              </FFormLayoutGroup>
            </FFormLayout>

            <FFormLayout>
              <FFormLayoutGroup>
                <FRadioButton
                  :label="$t('ficha.datosEconomicos.viveConGrupo')"
                  id="4"
                  name="numeroVehiculos"
                  value="4"
                  :checked="sbeCamposWrapper.opcionViveGrupoFamiliarVehiculos === 4"
                  @change="handleChange2"
                />
                <FTextField
                  type="number"
                  v-model="sbeCamposWrapper.numeroVehiculos"
                  v-if="sbeCamposWrapper.opcionViveGrupoFamiliarVehiculos == 4"
                ></FTextField>
              </FFormLayoutGroup>
            </FFormLayout>

            <FFormLayout>
              <FFormLayoutGroup>
                <FText as="h6" variant="headingMd" font-weight="bold">
                  {{ $t("ficha.datosEconomicos.costoTotalPropiedades") }}:
                </FText>
                <br />
                <InputNumber
                  v-model="sbeCamposWrapper.costoTotalPropiedades"
                  :disabled="sbeCamposWrapper.opcionViveGrupoFamiliarPropiedad == null"
                  inputId="costoTotalPropiedades"
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

            <FFormLayout gap="32">
              <FFormLayoutGroup>
                <FText as="h6" variant="headingMd" font-weight="bold">
                  {{ $t("ficha.datosEconomicos.costoTotalVehiculos") }}:
                </FText>
                <br />
                <InputNumber
                  v-model="sbeCamposWrapper.costoTotalVehiculos"
                  :disabled="sbeCamposWrapper.opcionViveGrupoFamiliarVehiculos == null"
                  inputId="costoTotalVehiculos"
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
                <br /><br />
                <FText as="h6" variant="headingMd" font-weight="bold">
                  {{ $t("ficha.datosEconomicos.total") }}:
                </FText>
                <InputNumber
                  v-model="sbeCamposWrapper.total"
                  :disabled="true"
                  inputId="total"
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
          </FVerticalStack>
        </FFormLayoutGroup>
      </FFormLayout>
    </FVerticalStack>
  </FCardSection>
</template>
<script setup lang="ts">
const { sbeParametros, selectOtrosIngresosList, sbeCamposWrapper } = useDatosEconomicos();

const handleChange = (_checked: any, newValue: any) => {
  sbeCamposWrapper.value.numeroPropiedades = undefined;
  sbeCamposWrapper.value.opcionViveGrupoFamiliarPropiedad = newValue;
};

const handleChange2 = (_checked: any, newValue: any) => {
  sbeCamposWrapper.value.numeroVehiculos = undefined;
  sbeCamposWrapper.value.opcionViveGrupoFamiliarVehiculos = newValue;
};

watch(
  () => sbeCamposWrapper.value.costoTotalPropiedades,
  (newValue, oldValue) => {
    sbeCamposWrapper.value.total =
      sbeCamposWrapper.value.costoTotalPropiedades! +
      sbeCamposWrapper.value.costoTotalVehiculos!;
  }
);

watch(
  () => sbeCamposWrapper.value.costoTotalVehiculos,
  (newValue, oldValue) => {
    sbeCamposWrapper.value.total =
      sbeCamposWrapper.value.costoTotalPropiedades! +
      sbeCamposWrapper.value.costoTotalVehiculos!;
  }
);
</script>
<style scoped></style>
