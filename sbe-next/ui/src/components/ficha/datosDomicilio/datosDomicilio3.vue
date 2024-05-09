<template>
  <FCardSection>
    <FVerticalStack gap="4">
      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosDomicilio.titulo23") }}:
      </FText>
      <FDivider />

      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.bus')"
            :checked="sbeParametros.tipoTransporte === 2011"
            id="2011"
            value="2011"
            name="transporte"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.taxiRuta')"
            id="2012"
            name="transporte"
            value="2012"
            :checked="sbeParametros.tipoTransporte === 2012"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.metro')"
            id="2013"
            name="transporte"
            value="2013"
            :checked="sbeParametros.tipoTransporte === 2013"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>

      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.trole')"
            :checked="sbeParametros.tipoTransporte === 2014"
            id="2014"
            value="2014"
            name="transporte"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.taxi')"
            id="2015"
            name="transporte"
            value="2015"
            :checked="sbeParametros.tipoTransporte === 2015"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.ecovia')"
            id="2016"
            name="transporte"
            value="2016"
            :checked="sbeParametros.tipoTransporte === 2016"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.tranvia')"
            :checked="sbeParametros.tipoTransporte === 2017"
            id="2017"
            value="2017"
            name="transporte"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.camioneta')"
            id="2018"
            name="transporte"
            value="2018"
            :checked="sbeParametros.tipoTransporte === 2018"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.vehiculoPropio')"
            id="2019"
            name="transporte"
            value="2019"
            :checked="sbeParametros.tipoTransporte === 2019"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.metrovia')"
            :checked="sbeParametros.tipoTransporte === 2020"
            id="2020"
            value="2020"
            name="transporte"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.bicicleta')"
            id="2021"
            name="transporte"
            value="2021"
            :checked="sbeParametros.tipoTransporte === 2021"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.moto')"
            id="2022"
            name="transporte"
            value="2022"
            :checked="sbeParametros.tipoTransporte === 2022"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.aerovia')"
            id="2023"
            name="transporte"
            value="2023"
            :checked="sbeParametros.tipoTransporte === 2023"
            @change="handleChange"
          />

          <FHorizontalStack gap="4">
            <FRadioButton
              :label="$t('ficha.datosDomicilio.otroEspecifique')"
              id="2024"
              name="transporte"
              value="2024"
              :checked="sbeParametros.tipoTransporte === 2024"
              @change="handleChange"
            />
            <FTextField
              v-if="sbeParametros.tipoTransporte == 2024"
              v-model="sbeCamposWrapper.otraFrecuenciaEspecifique"
              autoComplete="off"
              type="text"
              id="otraFrecuenciaEspecifique"
              name="otraFrecuenciaEspecifique"
              @blur="
                storeClient.llenarCampo(
                  sbeCampoCodigos.OTRO_TIPO_TRANSPORTE_ESPECIFIQUE,
                  sbeCamposWrapper.otraFrecuenciaEspecifique,
                  'TEXTO'
                )
              "
            />
          </FHorizontalStack>
          <br />
        </FFormLayoutGroup>
      </FFormLayout>

      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosDomicilio.frecuenciaTransporte") }}:
      </FText>

      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.diario')"
            id="2025"
            name="frecuenciaTransporte"
            value="2025"
            :checked="sbeParametros.frecuenciaTransporte === 2025"
            @change="handleChangeFrecuencia"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.menosdeTres')"
            id="2026"
            name="frecuenciaTransporte"
            value="2026"
            :checked="sbeParametros.frecuenciaTransporte === 2026"
            @change="handleChangeFrecuencia"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.masdeTres')"
            id="2027"
            name="frecuenciaTransporte"
            value="2027"
            :checked="sbeParametros.frecuenciaTransporte === 2027"
            @change="handleChangeFrecuencia"
          />
        </FFormLayoutGroup>
      </FFormLayout>
    </FVerticalStack>
  </FCardSection>
</template>
<script setup lang="ts">
import sbeParametrosCodigosEnum from "~/utils/sbeParametrosCodigos";

const { sbeCamposWrapper, sbeParametros, storeClient } = useDatosDomicilio();
const handleChange = (_checked: any, newValue: any) => {
  sbeParametros.value.tipoTransporte = newValue;
  storeClient.llenarListaParametros(
    sbeParametros.value.tipoTransporte,
    sbeParametrosCodigosEnum.tipoTransporte
  );
  if (sbeParametros.value.tipoTransporte != 2024)
    sbeCamposWrapper.value.otraFrecuenciaEspecifique = "";
};

const handleChangeFrecuencia = (_checked: any, newValue: any) => {
  sbeParametros.value.frecuenciaTransporte = newValue;
  storeClient.llenarListaParametros(
    sbeParametros.value.frecuenciaTransporte,
    sbeParametrosCodigosEnum.frecuenciaTransporte
  );
};
</script>
<style scoped></style>
