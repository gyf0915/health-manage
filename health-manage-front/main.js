import App from './App'

// #ifndef VUE3
import Vue from 'vue'

// 此处为引用自定义顶部
import cuCustom from './pages/colorui/components/cu-custom.vue'

// 引入:uView-UI
// import uView from 'uview-ui';
// Vue.use(uView);

import './uni.promisify.adaptor'
Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
  ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif