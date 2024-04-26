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
            :checked="sbeParametros.frecuenciaTransporte === 2011"
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
            :checked="sbeParametros.frecuenciaTransporte === 2012"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.metro')"
            id="2013"
            name="transporte"
            value="2013"
            :checked="sbeParametros.frecuenciaTransporte === 2013"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>

      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.trole')"
            :checked="sbeParametros.frecuenciaTransporte === 2014"
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
            :checked="sbeParametros.frecuenciaTransporte === 2015"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.ecovia')"
            id="2016"
            name="transporte"
            value="2016"
            :checked="sbeParametros.frecuenciaTransporte === 2016"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.tranvia')"
            :checked="sbeParametros.frecuenciaTransporte === 2017"
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
            :checked="sbeParametros.frecuenciaTransporte === 2018"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.vehiculoPropio')"
            id="2019"
            name="transporte"
            value="2019"
            :checked="sbeParametros.frecuenciaTransporte === 2019"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
      <FFormLayout>
        <FFormLayoutGroup condensed>
          <FRadioButton
            :label="$t('ficha.datosDomicilio.metrovia')"
            :checked="sbeParametros.frecuenciaTransporte === 2020"
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
            :checked="sbeParametros.frecuenciaTransporte === 2021"
            @change="handleChange"
          />
          <FRadioButton
            :label="$t('ficha.datosDomicilio.moto')"
            id="2022"
            name="transporte"
            value="2022"
            :checked="sbeParametros.frecuenciaTransporte === 2022"
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
            :checked="sbeParametros.frecuenciaTransporte === 2023"
            @change="handleChange"
          />
        </FFormLayoutGroup>
      </FFormLayout>
    </FVerticalStack>
  </FCardSection>
</template>
<script setup lang="ts">
const { sbeCamposWrapper, sbeParametros } = useDatosDomicilio();
</script>
<style scoped></style>
