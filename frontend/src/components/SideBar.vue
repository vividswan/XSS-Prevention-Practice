<template>
    <v-navigation-drawer app>
      <template v-slot:prepend>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>XSS</v-list-item-title>
            <v-list-item-subtitle>Prevention-Practice</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item
            v-for="item in items"
            :key="item.title"
        >
          <router-link :to=item.link class="link">
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
          </router-link>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
name: "SideBar.vue",
  data () {
    return {
      items: [
        { title: '게시판', icon: 'mdi-view-dashboard', link : '/' },
        { title: '게시글 작성', icon: 'mdi-plus', link : '/post/add' }
      ],
      right: null,
    }
  },
}
</script>

<style scoped>
.link{
  color : #424141;
  text-decoration: none;
  display : flex;
}
</style>