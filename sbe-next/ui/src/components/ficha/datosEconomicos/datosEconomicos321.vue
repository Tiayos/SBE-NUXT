¿
<template>
  <FCardSection>
    <FVerticalStack gap="4">
      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosEconomicos.titulo321") }}:
      </FText>
      <FDivider />

      <FRadioButton
        :label="$t('app.label.si')"
        helpText="Tiene que completar todos los datos."
        :checked="sbeParametros.otroIngresoMensual === 2028"
        id="2028"
        value="2028"
        name="selectOtrosIngresos"
        @change="handleChange"
      />
      <FRadioButton
        :label="$t('app.label.no')"
        helpText="Continúe con la siguiente sección."
        id="2029"
        name="selectOtrosIngresos"
        value="2029"
        :checked="sbeParametros.otroIngresoMensual === 2029"
        @change="handleChange"
      />
    </FVerticalStack>

    <FCard sectioned v-if="sbeParametros.otroIngresoMensual == 2028">
      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosEconomicos.subtitle321") }}:
      </FText>
      <FVerticalStack gap="4">
        <FFormLayout>
          <FFormLayoutGroup condensed>
            <FCheckbox
              :label="$t('ficha.datosEconomicos.recibeDinero')"
              :checked="selectOtrosIngresosList.includes(2030)"
              id="2030"
              name="recibeDinero"
              @change="() => handleChange2(2030)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.utilidades')"
              :checked="selectOtrosIngresosList.includes(2031)"
              id="2031"
              name="recibeDinero"
              @change="() => handleChange2(2031)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.ayudasFamiliares')"
              :checked="selectOtrosIngresosList.includes(2032)"
              id="2032"
              name="recibeDinero"
              @change="() => handleChange2(2032)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
          </FFormLayoutGroup>
        </FFormLayout>

        <FFormLayout>
          <FFormLayoutGroup condensed>
            <FCheckbox
              :label="$t('ficha.datosEconomicos.comercioInformal')"
              :checked="selectOtrosIngresosList.includes(2033)"
              id="2033"
              name="recibeDinero"
              @change="() => handleChange2(2033)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.arriendos')"
              :checked="selectOtrosIngresosList.includes(2034)"
              id="2034"
              name="recibeDinero"
              @change="() => handleChange2(2034)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.pensionAlimenticia')"
              :checked="selectOtrosIngresosList.includes(2035)"
              id="2035"
              name="recibeDinero"
              @change="() => handleChange2(2035)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
          </FFormLayoutGroup>
        </FFormLayout>

        <FFormLayout>
          <FFormLayoutGroup condensed>
            <FCheckbox
              :label="$t('ficha.datosEconomicos.pensionJubilacion')"
              :checked="selectOtrosIngresosList.includes(2036)"
              id="2036"
              name="recibeDinero"
              @change="() => handleChange2(2036)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.montepio')"
              :checked="selectOtrosIngresosList.includes(2037)"
              id="2037"
              name="recibeDinero"
              @change="() => handleChange2(2037)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
            <FCheckbox
              :label="$t('ficha.datosEconomicos.bonosEstatales')"
              :checked="selectOtrosIngresosList.includes(2038)"
              id="2038"
              name="recibeDinero"
              @change="() => handleChange2(2038)"
              :disabled="sbeParametros.otroIngresoMensual != 2028"
            />
          </FFormLayoutGroup>
        </FFormLayout>
        <FCheckbox
          :label="$t('ficha.datosEconomicos.inversionesBancarias')"
          :checked="selectOtrosIngresosList.includes(2039)"
          id="2039"
          name="recibeDinero"
          @change="() => handleChange2(2039)"
          :disabled="sbeParametros.otroIngresoMensual != 2028"
        />
        <FHorizontalStack gap="4">
          <FCheckbox
            :label="$t('ficha.datosEconomicos.otros')"
            :checked="selectOtrosIngresosList.includes(2040)"
            id="2040"
            name="recibeDinero"
            @change="() => handleChange2(2040)"
            :disabled="sbeParametros.otroIngresoMensual != 2028"
          />
          <FTextField
            type="text"
            id="otroIngresoEspecifique"
            name="otroIngresoEspecifique"
            autoComplete="off"
            :disabled="!selectOtrosIngresosList.includes(2040)"
            v-model="sbeCamposWrapper.otrosIngresosEspecifique"
            @change="
              storeClient.llenarCampo(
                sbeCampoCodigos.OTRO_INGRESO_ESPECIFIQUE,
                sbeCamposWrapper.otrosIngresosEspecifique,
                'TEXTO'
              )
            "
          ></FTextField>
        </FHorizontalStack>

        <FHorizontalStack gap="4">
          <FText as="h6" variant="headingMd" font-weight="bold">
            {{ $t("ficha.datosEconomicos.valorTotal") }}:
          </FText>
          <InputNumber
            v-model="sbeCamposWrapper.valorTotalMensualOtrosIngresos"
            inputId="minmaxfraction"
            :minFractionDigits="2"
            :maxFractionDigits="2"
            :disabled="sbeParametros.otroIngresoMensual === 2028"
            @change="
              storeClient.llenarCampo(
                sbeCampoCodigos.VALOR_TOTAL_OTROS_INGRESOS,
                sbeCamposWrapper.valorTotalMensualOtrosIngresos,
                'ENTERO'
              )
            "
          />
        </FHorizontalStack>
      </FVerticalStack>
    </FCard>
  </FCardSection>
  <FichaDatosEconomicosDatosEconomicos33></FichaDatosEconomicosDatosEconomicos33>
</template>
<script setup lang="ts">
import sbeParametrosCodigosEnum from "~/utils/sbeParametrosCodigos";

const {
  sbeParametros,
  selectOtrosIngresosList,
  sbeCamposWrapper,
  storeClient,
} = useDatosEconomicos();

const handleChange = (_checked: any, newValue: any) => {
  sbeParametros.value.otroIngresoMensual = newValue;
  storeClient.llenarListaParametros(
    sbeParametros.value.otroIngresoMensual,
    sbeParametrosCodigosEnum.selectSiNoOtroIngresoMensual
  );
};

const handleChange2 = (newValue: number) => {
  if (selectOtrosIngresosList.value.includes(newValue)) {
    selectOtrosIngresosList.value = selectOtrosIngresosList.value.filter(
      (item) => item !== newValue
    );
  } else {
    selectOtrosIngresosList.value.push(newValue);
  }
};

watch(
  () => sbeParametros.value.otroIngresoMensual,
  (newValue, oldValue) => {
    if (sbeParametros.value.otroIngresoMensual == 2029) {
      selectOtrosIngresosList.value = [];
      sbeCamposWrapper.value.valorTotalMensualOtrosIngresos = undefined;
      sbeCamposWrapper.value.otrosIngresosEspecifique = "";
    }
  }
);
</script>
<style scoped></style>
