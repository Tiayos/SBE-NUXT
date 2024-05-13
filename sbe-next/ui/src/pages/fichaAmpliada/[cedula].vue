<template>
  <FLoading v-show="load == false" />
  <FPage full-widt v-if="load == true">
    <FVerticalStack>
      <FichaTitulo></FichaTitulo>
      <FichaDatosEstudiante></FichaDatosEstudiante>
      <FichaDatosDomicilioDatosDomicilio1></FichaDatosDomicilioDatosDomicilio1>
      <FichaDatosEconomicosDatosEconomicos1></FichaDatosEconomicosDatosEconomicos1>
      <FichaSituacionHabitacional></FichaSituacionHabitacional>
    </FVerticalStack>
  </FPage>
</template>

<script setup lang="ts">
const { load } = useFicha();
</script>
<style scoped lang="css"></style>
