<template>
  <v-app class="display : flex">
    <SideBar/>
    <v-main class="margin">
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "App.vue",
  components: {
    SideBar : ()=>import('./components/SideBar')
  },
  created() {
    this.$cookie.set("random", Math.random().toString(36).substr(2,11));
  }
}
</script>

<style lang="scss">
.margin {
  margin : 200px;
}
</style>
