<template>
  <div id="app">
    <Header></Header>
    
    <div class="content container-fluid">
      <router-view />
    </div>
  </div>
</template>


<script>
import Header from "./components/APPHeader.vue"
import Menu from "./components/Menu.vue";
export default {
  name: 'App',
  components: {
    Header,
    Menu
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
}
</style>
