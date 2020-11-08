<template>
  <v-form
      ref="form"
      v-model="valid"
      lazy-validation
  >
    <v-text-field
        :value="post.user"
        label="작성자"
        readonly
    ></v-text-field>

    <v-text-field
        v-model="post.title"
        :counter="20"
        :rules="titleRules"
        label="제목"
        required
    ></v-text-field>

    <v-text-field
        v-model="post.content"
        :rules="contentRules"
        label="본문"
        required
    ></v-text-field>

    <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="submit"
    >
      Submit
    </v-btn>

    <v-btn
        color="error"
        class="mr-4"
        @click="clear"
    >
      Clear
    </v-btn>
  </v-form>
</template>

<script>
export default {
  name: "AddPost.vue",
  data: () => ({
    valid: true,
    id: 0,
    post : '',
    titleRules: [
      v => !!v || 'Title is required',
      v => (v && v.length <= 20) || 'Title must be less than 20 characters',
    ],
    content : '',
    contentRules: [
      v => !!v || 'Content is required',
      v => (v && v.length <= 200) || 'Content must be less than 200 characters',
    ]
  }),
  created() {
    this.id = this.$route.params.id;
    if (this.id === 'undefined' || this.id === undefined)
      this.$router.go(-1);
    this.$http.get('/api/v1/detail/' + this.id)
    .then(result => {
        this.post = result.data;
    })
    .catch(err => console.log(err));
  },

  methods: {
    submit(){
      this.$http.put('/api/v1/update/' + this.id, {
        "title" : this.post.title,
        "content" : this.post.content
      }).then(() => {
        this.$router.push('/post/detail/' + this.id);
      }).catch(err => console.log(err));
    },
    clear(){
      this.post.valid = true;
      this.post.user = '';
      this.post.title = '';
      this.post.content = '';
    }
  }
}
</script>

<style scoped>
</style>