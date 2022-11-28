<template>
  <div id="app">
    <HelloWorld msg="Welcome to Your Vue.js App" v-if="show===1" />
    <DecorationDemo v-if="show===2"/>
    <ChartsDemo v-if="show===3"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import DecorationDemo from './components/Decoration.vue'
import ChartsDemo from './components/ChartsDemo.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    DecorationDemo,
    ChartsDemo
  },
  data(){
    return {
      show: 3
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
