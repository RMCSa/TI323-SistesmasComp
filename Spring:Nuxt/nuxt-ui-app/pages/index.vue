<script setup lang="ts">
import Cubo from '~/components/Cubo.vue'
const methods = [
  { value: 'cubo', label: 'Cubo' },
  { value: 'esfera', label: 'Esfera' },
  { value: 'cilindro', label: 'Cilindro' },
  { value: 'prisma', label: 'Prisma'}
]

const selected = ref('cubo')
</script>
<template>
  
  <div class="min-h-screen flex flex-col items-center justify-center bg-gray-100 dark:bg-gray-900">
    <div class="w-full max-w-xs sm:max-w-md md:max-w-3xl lg:max-w-xl xl:max-w-2xl p-4">
      <div class="flex justify-end mb-4">
        <USelect v-model="$colorMode.preference" :options="['system', 'light', 'dark']" class=" w-11 max-w-xs" />
      </div>

      <UCard class=" m-2">
      <h1>Autores: </h1>
      <br>
      <h1> Rafael Moreira - 23333</h1>
      <h1> Marcelo Manzo - 23326</h1>
      </UCard>
      
      <UContainer class="bg-white dark:bg-gray-800 rounded-lg shadow-lg p-6 h-4/5" >
        <div class="flex space-x-10">
          <div>
            <URadio v-for="method in methods" :key="method.value" v-model="selected" v-bind="method" />
          </div>
          <UContainer class="w-full flex justify-center">
            <Cubo v-if="selected == 'cubo'"/>
            <Esfera v-if="selected == 'esfera'"/>
            <Cilindro v-if="selected == 'cilindro'"/>
            <Prisma v-if="selected == 'prisma'"/>
          </UContainer>
        </div>
      </UContainer>
    </div>
  </div>
</template>

<style></style>

