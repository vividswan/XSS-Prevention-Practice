<template>
  <v-fade-transition>
    <v-row>
      <v-col>
        <v-card outlined>
          <v-card-title class="font-weight-black"
          >{{ post.title }}
            <v-spacer></v-spacer>
          </v-card-title>
          <v-card-subtitle class="mt-0">
            <span>작성자 : {{post.user}}</span>
            <span style="margin-left : 20px;">작성 시간 : {{post.createdTime | moment('YYYY-MM-DD HH:mm:ss')}}</span>
          </v-card-subtitle>
          <v-divider></v-divider>
          <v-card-text style="min-height : 300px;">
              {{post.content}}
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-fade-transition>
</template>

<script>
export default {
  name: "DetailPost2.vue",
  data: () => ({
    post : '',
  }),
  created(){
    this.id = this.$route.params.id;
    if(this.id === 'undefined' || this.id === undefined)
      this.$router.go(-1);
    this.$http.get('/api/v1/detail/' + this.id)
    .then(result=>{
        this.post = result.data;
    })
    .catch(err => console.log(err));
  }
}
</script>

<style scoped>
.margin {
  margin: 200px;
}
</style>