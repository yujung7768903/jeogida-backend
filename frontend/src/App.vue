<template>
  <div id="parking-lot-container">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
    
  }
}
</script>

<style>
body {
  width: 100%;
  height: 100%;
  margin: 0;
  position: absolute;
}

#app {
  width: 100%;
  height: 100%;
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#parking-lot-container {
  width: 400px;
  height: 300px;
  margin: auto;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
