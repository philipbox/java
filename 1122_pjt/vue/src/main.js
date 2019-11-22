import Vue from "vue";
import App from "./App.vue";
import router from './router'
import './plugins/element.js'
import Vuex from 'vuex'
import store from './store/index'


import { store1 } from './store'


Vue.use(Vuex)

Vue.config.productionTip = false;

export const eventBus = new Vue()

new Vue({
  router,
  store,
  store1,
  render: h => h(App)
}).$mount("#app");
