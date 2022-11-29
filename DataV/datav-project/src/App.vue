<template>
  <div id="app">
    <HelloWorld msg="Welcome to Your Vue.js App" v-if="show===1" />
    <DecorationDemo v-if="show===2"/>
    <ChartsDemo v-if="show===3"/>
    <DynamicRingChart v-if="show===4"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import DecorationDemo from './components/Decoration.vue'
import ChartsDemo from './components/ChartsDemo.vue'
import DynamicRingChart from './components/DynamicRingChart.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    DecorationDemo,
    ChartsDemo,
    DynamicRingChart
  },
  data(){
    return {
      show: 4
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
