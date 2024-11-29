<template>
  <div>
    <img src="@/resources/png/esfera.png" alt="">
    <UForm
     
      class="space-y-4"
      :state="state"
      @submit="onSubmit"
      
    >
      <UFormGroup class=" space-y-4">
        <UInput color="primary" variant="outline" v-model="state.raio" label="raio" placeHolder="raio" />
      </UFormGroup>
      <UButton type="submit">Calcular</UButton>
      <br> 
      <span v-if="exist">Area: {{ datas.area }}</span> <br>
      <span v-if="exist">Volume: {{ datas.volume }}</span> <br>
      <span v-if="exist">Perimetro: {{ datas.perimetro }}</span> <br>

    </UForm>
  </div>
</template>

<script lang="ts" setup>

const state = reactive({
  raio: undefined,
})

const datas = reactive({
  volume: undefined,
  area: undefined,
  perimetro: undefined
})

const exist = ref(false)

async function onSubmit(event: FormSubmitEvent<any>) {
  try {
   
    const data = await $fetch('http://localhost:8080/api/esfera',{
      method: 'POST',
      body: JSON.stringify(event.data),   
    })

    datas.volume = data.volume
    datas.area = data.area
    datas.perimetro = data.perimetro

    exist.value = true 
  } catch (error) {
    
  }
}

</script>

<style>

</style>