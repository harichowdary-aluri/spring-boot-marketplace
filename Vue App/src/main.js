import Vue from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import axios from "axios";
import router from "./components/router"
import VueSidebarMenuAkahon from "vue-sidebar-menu-akahon";

Vue.component('vue-sidebar-menu-akahon', VueSidebarMenuAkahon);
Vue.config.productionTip = false
Vue.prototype.$axios = axios.create({


  headers: {
    "Access-Control-Allow-Origin": "*",
    "Content-Type": "application/json",
    "Accept": "application/json",
  }
})


Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
