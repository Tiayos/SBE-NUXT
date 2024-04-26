<template>
  <FCard>
    <FCardSection
      :title="$t('ficha.tituloDatosEstudiante')"
      style="background-color: #4682b4; color: white"
    />
    <FCardSection>
      <FVerticalStack gap="4">
        <FHorizontalStack gap="32">
          <FHorizontalStack gap="20">
            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosEstudiante.identificacion") }}:
            </FText>
            <FText as="p" variant="headingMd" font-weight="regular"
              >{{ insAlumno.identificacion }}
            </FText>
          </FHorizontalStack>

          <FHorizontalStack gap="20">
            <FText as="h6" variant="headingMd">
              {{ $t("ficha.datosEstudiante.becaAsignado") }}:
            </FText>
            <FText as="p" variant="headingMd" font-weight="regular"
              >{{ insAlumno.nivelBeca }}
            </FText>
          </FHorizontalStack>
        </FHorizontalStack>

        <FHorizontalStack gap="16">
          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.nombres") }}:
          </FText>
          <FText
            as="p"
            variant="headingMd"
            font-weight="regular"
            style="margin-left: -5px"
            >{{ insAlumno.nombre }}
          </FText>
        </FHorizontalStack>

        <FHorizontalStack gap="32">
          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.estadoCivil") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.estadoCivil }}
          </FText>
        </FHorizontalStack>

        <FHorizontalStack gap="16">
          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.correo") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.email }}
          </FText>

          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.tipoSangre") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.tipoSangre }}
          </FText>

          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.etnia") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.etnia }}
          </FText>

          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.nacionalidad") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.nacionalidad }}
          </FText>
        </FHorizontalStack>

        <FHorizontalStack gap="20">
          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.institucionEducativa") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.institucionEducativa }}
          </FText>
        </FHorizontalStack>

        <FHorizontalStack gap="32">
          <FText as="h6" variant="headingMd">
            {{ $t("ficha.datosEstudiante.tipoInstitucion") }}:
          </FText>
          <FText as="p" variant="headingMd" font-weight="regular"
            >{{ insAlumno.tipoInstitucion }}
          </FText>
        </FHorizontalStack>
      </FVerticalStack>
    </FCardSection>
  </FCard>
</template>
<script setup lang="ts">
const { insAlumno } = useDatosEstudiante();
</script>
<style scoped></style>
