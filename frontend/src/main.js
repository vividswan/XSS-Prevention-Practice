import Vue from 'vue';
import App from './App.vue';
import vuetify from './plugins/vuetify';
import router from './router';
import axios from 'axios';
import vueMoment from 'vue-moment';

Vue.use(vueMoment);

Vue.config.productionTip = false
Vue.prototype.$http = axios;

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
