<template>
  <FCard sectioned>
    <FCardSection>
      <FVerticalStack gap="4">
        <FText :as="'h1'" variant="headingLg" font-weight="semibold">
          {{ $t("ficha.tituloGeneral") }}
        </FText>
        <FText :as="'h6'" variant="bodyMd" style="font-style: italic">
          {{ $t("ficha.tituloGeneralDescripcion") }}
        </FText>
      </FVerticalStack>
    </FCardSection>
  </FCard>
</template>
