¿
<template>
  <FCardSection>
    <FVerticalStack gap="4">
      <FText as="h6" variant="headingMd" font-weight="bold">
        {{ $t("ficha.datosDomicilio.titulo22") }}:
      </FText>
      <FDivider />

      <FRadioButton
        :label="$t('app.label.si')"
        helpText="Tiene que completar todos los datos."
        :checked="sbeParametros.resideOtroLugar === 2005"
        id="2005"
        value="2005"
        name="select"
        @change="handleChange"
      />
      <FRadioButton
        :label="$t('app.label.no')"
        helpText="Continúe con la siguiente sección."
        id="2006"
        name="select"
        value="2006"
        :checked="sbeParametros.resideOtroLugar === 2006"
        @change="handleChange"
      />
    </FVerticalStack>

    <FCard sectioned v-if="sbeParametros.resideOtroLugar == 2005">
      <FVerticalStack gap="4">
        <FText as="h6" variant="headingMd" font-weight="bold">
          {{ $t("ficha.datosDomicilio.subtitle22") }}:
        </FText>
        <FFormLayout>
          <FFormLayoutGroup condensed>
            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosDomicilio.pais") }}:
            </FText>
            <Dropdown
              filter
              :options="paisesListEstudio"
              :placeholder="$t('app.label.seleccione')"
              optionLabel="paises"
              optionValue="codigoPaises"
              v-model="sbeCamposWrapper.paisEstudio"
              @change="
                storeClient.llenarCampo(
                  sbeCampoCodigos.PAIS_ESTUDIO,
                  sbeCamposWrapper.paisEstudio,
                  'ENTERO'
                )
              "
            >
            </Dropdown>

            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosDomicilio.ciudad") }}:
            </FText>
            <Dropdown
              filter
              :options="ciudadesListEstudio"
              :placeholder="$t('app.label.seleccione')"
              optionLabel="ciudad"
              optionValue="codigoCiudad"
              v-model="sbeCamposWrapper.ciudadEstudio"
              @change="
                storeClient.llenarCampo(
                  sbeCampoCodigos.CIUDAD_ESTUDIO,
                  sbeCamposWrapper.ciudadEstudio,
                  'ENTERO'
                )
              "
            >
            </Dropdown>

            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosDomicilio.parroquia") }}:
            </FText>
            <Dropdown
              :options="parroquiasListEstudio"
              :placeholder="$t('app.label.seleccione')"
              optionLabel="parroquias"
              optionValue="codigoParroquia"
              v-model="sbeCamposWrapper.parroquiaEstudio"
              @change="
                storeClient.llenarCampo(
                  sbeCampoCodigos.PARROQUIA_ESTUDIO,
                  sbeCamposWrapper.parroquiaEstudio,
                  'ENTERO'
                )
              "
            >
            </Dropdown>

            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosDomicilio.tipoParroquia") }}:
            </FText>

            <Dropdown
              style="width: 100%"
              :options="getTipoParroquiasListEstudio"
              :placeholder="$t('app.label.seleccione')"
              optionLabel="descripcion"
              optionValue="codigo"
              v-model="sbeParametros.tipoParroquiaEstudio"
              @change="
                storeClient.llenarListaParametros(
                  sbeParametros.tipoParroquiaEstudio,
                  sbeParametrosCodigos.tiposParroquiaEstudio
                )
              "
            >
            </Dropdown>
          </FFormLayoutGroup>
        </FFormLayout>

        <FFormLayout>
          <FFormLayoutGroup condensed>
            <FTextField
              :label="$t('ficha.datosDomicilio.barrio')"
              v-model="sbeCamposWrapper.barrioEstudio"
              autoComplete="off"
              type="text"
              id="barrioEstudio"
              name="barrioEstudio"
              @blur="
                storeClient.llenarCampo(
                  sbeCampoCodigos.BARRIO_ESTUDIO,
                  sbeCamposWrapper.barrioEstudio,
                  'TEXTO'
                )
              "
            />
            <FTextField
              :label="$t('ficha.datosDomicilio.direccion')"
              v-model="sbeCamposWrapper.direccionEstudiante"
              autoComplete="off"
              type="text"
              id="direccionEstudio"
              name="direccionEstudio"
              @blur="
                storeClient.llenarCampo(
                  sbeCampoCodigos.DIRECCION_ESTUDIO,
                  sbeCamposWrapper.direccionEstudiante,
                  'TEXTO'
                )
              "
            />
          </FFormLayoutGroup>
        </FFormLayout>
      </FVerticalStack>
    </FCard>
  </FCardSection>

  <FichaDatosDomicilioDatosDomicilio3></FichaDatosDomicilioDatosDomicilio3>
</template>
<script setup lang="ts">
import sbeParametrosCodigosEnum from "~/utils/sbeParametrosCodigos";

const {
  sbeCamposWrapper,
  sbeParametros,
  paisesListEstudio,
  ciudadesListEstudio,
  parroquiasListEstudio,
  storeClient,
  getTipoParroquiasList,
  getTipoParroquiasListEstudio,
} = useDatosDomicilio();

const handleChange = (_checked: any, newValue: any) => {
  sbeParametros.value.resideOtroLugar = newValue;
  storeClient.llenarListaParametros(
    sbeParametros.value.resideOtroLugar,
    sbeParametrosCodigosEnum.selectSiNoResideOtroLugar
  );
  if (sbeParametros.value.resideOtroLugar == 2006) {
    sbeCamposWrapper.value.barrioEstudio = "";
    sbeCamposWrapper.value.direccionEstudiante = "";
    sbeCamposWrapper.value.ciudadEstudio = undefined;
    sbeCamposWrapper.value.parroquiaEstudio = undefined;
    sbeCamposWrapper.value.paisEstudio = undefined;
  }
};
</script>
<style scoped></style>
