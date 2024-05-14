<template>
  <FLoading v-if="load == false" />
  <FPage :full-width="true">
    <FVerticalStack
      v-if="load == true && estudianteHabilitado && estadoFichaAmpliada != 'C'"
    >
      <FichaTitulo></FichaTitulo>
      <FichaDatosEstudiante></FichaDatosEstudiante>
      <FichaDatosDomicilioDatosDomicilio1></FichaDatosDomicilioDatosDomicilio1>
      <FichaDatosEconomicosDatosEconomicos1></FichaDatosEconomicosDatosEconomicos1>
      <FichaSituacionHabitacional></FichaSituacionHabitacional>
    </FVerticalStack>

    <FBanner
      status="critical"
      ref="banner"
      v-if="!estudianteHabilitado && estadoFichaAmpliada != 'C'"
    >
      <FVerticalStack gap="4" align="center">
        <FText variant="headingLg" :alignment="'center'" fontWeight="semibold" as="h3">
          {{ $t("ficha.fichaNoHabilitada.fichaNoHabilitadaTitle") }}
        </FText>
        <FVerticalStack gap="1" align="center">
          <FText variant="headingMd" :alignment="'center'" fontWeight="regular" as="h3">
            {{ $t("ficha.fichaNoHabilitada.fichaNoHabilitadaBody") }}
          </FText>
          <FText variant="headingMd" :alignment="'center'" fontWeight="regular" as="h3">
            {{ $t("ficha.fichaNoHabilitada.fichaNoHabilitadaBody2") }}
          </FText>
          <FText variant="headingMd" :alignment="'center'" fontWeight="regular" as="h3">
            Sede Cuenca: soporte@ups.edu.ec, Sede Quito: soporteuio@ups.edu.ec; Sede
            Guayaquil: soportegye@ups.edu.ec
          </FText>
        </FVerticalStack>
      </FVerticalStack>
    </FBanner>

    <FBanner status="success" ref="banner" v-if="estadoFichaAmpliada == 'C'">
      <FVerticalStack gap="4" align="center">
        <FText variant="headingLg" :alignment="'center'" fontWeight="semibold" as="h3">
          {{ $t("ficha.fichaCompletadaTitle") }}
        </FText>
        <FVerticalStack gap="1" align="center">
          <FText variant="headingMd" :alignment="'center'" fontWeight="regular" as="h3">
            {{ $t("ficha.fichaCompletadaBody") }}
          </FText>
          <FText variant="headingMd" :alignment="'center'" fontWeight="regular" as="h3">
            {{ $t("ficha.fichaCompletadaBody2") }}
          </FText>
        </FVerticalStack>
      </FVerticalStack>
    </FBanner>
  </FPage>
</template>

<script setup lang="ts">
const { load, estudianteHabilitado, estadoFichaAmpliada } = useFicha();
</script>
<style scoped lang="css"></style>
