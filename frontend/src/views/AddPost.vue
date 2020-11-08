<template>
  <v-form
      ref="form"
      v-model="valid"
      lazy-validation
  >
    <v-text-field
        v-model="user"
        :rules="userRules"
        label="작성자"
        required
    ></v-text-field>

    <v-text-field
        v-model="title"
        :counter="10"
        :rules="titleRules"
        label="제목"
        required
    ></v-text-field>

    <v-text-field
        v-model="content"
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
    user : '',
    userRules: [
      v => !!v || 'User is required',
      v => (v && v.length <= 20) || 'User must be less than 20 characters',
    ],
    title : '',
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

  methods: {
    submit(){
      this.$http.post('/api/v1/write', {
        "user" : this.user,
        "title" : this.title,
        "content" : this.content
      }).then(() => {
        this.$router.push('/');
      }).catch(err => console.log(err));
    },
    clear(){
      this.valid = true;
      this.user = '';
      this.title = '';
      this.content = '';
    }
  }
}
</script>

<style scoped>

</style>