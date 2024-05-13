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
                  @blur="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.NUMERO_INMUEBLES,
                      sbeCamposWrapper.numeroPropiedades,
                      'ENTERO'
                    )
                  "
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
                  @blur="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.NUMERO_INMUEBLES,
                      sbeCamposWrapper.numeroPropiedades,
                      'ENTERO'
                    )
                  "
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
                  @change="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.NUMERO_VEHICULOS,
                      sbeCamposWrapper.numeroVehiculos,
                      'ENTERO'
                    )
                  "
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
                  @change="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.NUMERO_VEHICULOS,
                      sbeCamposWrapper.numeroVehiculos,
                      'ENTERO'
                    )
                  "
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
                  @change="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.COSTO_TOTAL_PROPIEDADES_INMOBILIARIAS,
                      sbeCamposWrapper.costoTotalPropiedades,
                      'ENTERO'
                    )
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
                  @change="
                    storeClient.llenarCampo(
                      sbeCampoCodigos.COSTO_TOTAL_VEHICULOS,
                      sbeCamposWrapper.costoTotalVehiculos,
                      'ENTERO'
                    )
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
                  @change="
                  storeClient.llenarCampo(
                  sbeCampoCodigos.TOTAL,
                  sbeCamposWrapper.total,
                  'NUMBER'
                )
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
const {
  sbeParametros,
  selectOtrosIngresosList,
  sbeCamposWrapper,
  storeClient,
} = useDatosEconomicos();

const handleChange = (_checked: any, newValue: any) => {
  sbeCamposWrapper.value.numeroPropiedades = undefined;
  sbeCamposWrapper.value.opcionViveGrupoFamiliarPropiedad = newValue;
  storeClient.llenarCampo(
    sbeCampoCodigos.AUX_SELECT_VIVIENDA,
    sbeCamposWrapper.value.opcionViveGrupoFamiliarPropiedad,
    "NUMBER"
  );
};

const handleChange2 = (_checked: any, newValue: any) => {
  sbeCamposWrapper.value.numeroVehiculos = undefined;
  sbeCamposWrapper.value.opcionViveGrupoFamiliarVehiculos = newValue;
  storeClient.llenarCampo(
    sbeCampoCodigos.AUX_SELECT_VEHICULOS,
    sbeCamposWrapper.value.opcionViveGrupoFamiliarPropiedad,
    "NUMBER"
  );
};

watch(
  () => [
    sbeCamposWrapper.value.costoTotalPropiedades,
    sbeCamposWrapper.value.costoTotalVehiculos,
  ],
  ([newPropiedades, newVehiculos], [oldPropiedades, oldVehiculos]) => {
    if (!isNaN(newPropiedades!) && !isNaN(newVehiculos!)) {
      sbeCamposWrapper.value.total = (newPropiedades || 0) + (newVehiculos || 0);
      
    }
  }
);
</script>
<style scoped></style>
