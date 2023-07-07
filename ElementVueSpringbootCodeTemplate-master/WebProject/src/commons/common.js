    export default{
    install(Vue){
       //这里是示例方法 getTime是方法名 function()可以携带参数
        Vue.prototype.KeepInfor=function(){
            if (sessionStorage.getItem("store") ) {
                //this.$store.replaceState是vue官方提供的一个api表示替换 store 的根状态
                //里面的Object.assign()表示将store中的状态和sessionStorage中的状态进行合并
                  this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
                  sessionStorage.removeItem('store');
                }
        }
        
    }
  }