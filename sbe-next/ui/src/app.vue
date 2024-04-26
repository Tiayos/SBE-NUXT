<script setup lang="ts">
import { ref } from "vue";

import { MenuItem } from "@/models/menu-item.model";
import { useI18n } from "vue-i18n";
import { FSubNavigationItem } from "@ups-dev/freya-vue";
const { t } = useI18n();

const defaultState = reactive({
  emailFieldValue: "eproanor@est.ups.edu.ec",
  nameFieldValue: "UPS",
});

const skipToContentRef = ref(null);

const isDirty = ref(false);
const searchActive = ref(false);
const searchValue = ref("");
const userMenuActive = ref(false);
const mobileNavigationActive = ref(false);
const nameFieldValue = ref(defaultState.nameFieldValue);
const emailFieldValue = ref(defaultState.emailFieldValue);
const storeName = ref(defaultState.emailFieldValue);

watchEffect(() => {
  if (nameFieldValue.value || emailFieldValue.value) {
    isDirty.value = true;
  }
});
const handleSearchResultsDismiss = () => {
  searchActive.value = false;
  searchValue.value = "";
};

const toggleMobileNavigationActive = () =>
  (mobileNavigationActive.value = !mobileNavigationActive.value);

const userMenuActions = [
  {
    items: [
      {
        content: "Community forums",
      },
    ],
  },
];

const logo = {
  width: 152,
  topBarSource: "/logo.png",
  url: "/",
  accessibilityLabel: "UPS Dev",
};
</script>
<template>
  <FAppProvider>
    <FFrame
      :logo="logo"
      :showMobileNavigation="mobileNavigationActive"
      @navigation-dismiss="toggleMobileNavigationActive"
      :skipToContentTarget="skipToContentRef"
    >
      <template #topBar>
        <FTopBar
          showNavigationToggle
          :searchResultsVisible="searchActive"
          @searchResultsDismiss="handleSearchResultsDismiss"
          @navigation-toggle="toggleMobileNavigationActive"
        >
          <template #userMenu>
            <FTopBarUserMenu
              :actions="userMenuActions"
              name="Santiago Bermeo"
              :detail="storeName"
              initials="S"
              v-model:open="userMenuActive"
            />
          </template>
        </FTopBar>
      </template>

      <!-- <template #navigation>
        <FNavigation :location="$route.path">
          <FNavigationSection :items="items" />
        </FNavigation>
      </template> -->

      <LazyNuxtPage />

      <!-- <FLayoutSection>
        <LazyNavigationFooter />
      </FLayoutSection> -->
    </FFrame>
  </FAppProvider>
</template>

<style>
.layout-sidebar {
  background-color: #dddddd;
}
</style>
