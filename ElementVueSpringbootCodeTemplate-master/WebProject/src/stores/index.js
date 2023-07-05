import Vue from 'vue';
import Vuex from 'vuex';
import config from './modules/config';
import user from './modules/user';
Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
      config,
      user,
      
  },
  
});

export default store;
