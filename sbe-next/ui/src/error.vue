<script lang="ts" setup>
interface ErrorProps {
    error: {
        description?: string,
        message?: string,
        statusCode: string,
        statusMessage: string,
        url: string
    }
}

const { error } = defineProps<ErrorProps>()

const component = computed(() => {
    return defineAsyncComponent(() => import('@/components/error/ErrorComponent.vue'))
})

</script>

<template>
    <div>

        <Head>
            <Title>{{ error.statusMessage }}</Title>
        </Head>

        <Component :is="component" :error="error" />

    </div>
</template>

<style scoped>

</style>