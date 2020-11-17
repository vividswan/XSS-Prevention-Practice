<template>
  <div>
    <v-list three-line>
      <template v-for="(item, index) in items">
        <v-subheader
            v-if="item.header"
            :key="item.header"
            v-text="item.header"
        ></v-subheader>

        <v-divider
            v-else-if="item.divider"
            :key="index"
            :inset="item.inset"
        ></v-divider>

        <v-list-item
            v-else
            :key="item.title"
        >
          <router-link :to='{path : "/post/detail/" + item.id}' class="link wide">
            <v-list-item-content>
              <v-list-item-title v-html="item.title"></v-list-item-title>
              <v-list-item-subtitle>@{{ item.user }} created : {{ item.createdTime | moment('YYYY-MM-DD HH:mm:ss') }}
              </v-list-item-subtitle>
            </v-list-item-content>
          </router-link>
          <router-link :to='{path : "/post/normal/" + item.id}' class="link margin-left">
            <v-icon>mdi-security</v-icon>
          </router-link>
          <router-link :to='{path : "/post/update/" + item.id}' class="link margin-left">
            <v-icon>mdi-table-edit</v-icon>
          </router-link>
          <v-icon @click="deletePost(item.id)" class="margin-left">mdi-delete</v-icon>
        </v-list-item>
      </template>
    </v-list>
  </div>
</template>

<script>
export default {
  name: "NoSecurity.vue",
  data: () => ({
    items: [
      {header: 'Today'}
    ],
  }),
  mounted() {
    this.$http.get('/api/v1/read')
        .then(result => {
          console.log(result);
          for (let i of result.data.content) {
            this.items.push(i);
            this.items.push({divider: true, inset: true});
          }
        })
        .catch(err => console.log(err));
  },
  methods: {
    deletePost(id) {
      this.$http.delete('/api/v1/delete/' + id)
          .catch(err => console.log(err));
      window.location.reload();
    }
  }
}
</script>

<style scoped>
.link {
  color: #424141;
  text-decoration: none;
  display: flex;
}

.margin-left {
  margin-left : 30px;
}

.wide {
  width: 90%;
}
</style>