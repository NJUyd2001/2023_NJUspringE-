<template>
  
  <div id="logo">
  <div class="header">
  
  <img src="../../assets/l3.png" style="height:80px"/>
</div>
    <h2></h2>
    <el-card class="box-card-l">
    <router-link to="/clientlogin">
      <el-button style="background:rgba(0,0,0,0); border-style:none; font-size: 30px"> 客户 </el-button>
    </router-link>
      
    </el-card>
    <el-card class="box-card-r">
    <router-link to="/login">
      <el-button style="background:rgba(0,0,0,0); border-style:none; font-size: 30px"> 软件测试中心 </el-button>
    </router-link>
      
    </el-card>

  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        uname: "",
        uid: null,
      },
    };
  },
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'margin:0;')
  },
  methods: {
    logout(){
      // 移除本地用户登录信息
      sessionStorage.removeItem('userInfo');
      // 跳转页面到登录页
      this.$router.push('/login');
    }
  },
  mounted() {
    if (sessionStorage.getItem('userInfo')) {
      // 将用户信息存储到sessionStorage中
      this.user = JSON.parse(sessionStorage.getItem('userInfo'));
    }
  },
};
</script>

<style scoped>
  #logo{
    background: url("../../assets/b6.jpg");
    /* background: url("../../assets/img/homeBG.jpeg");   */
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%;
    margin: 0 auto;
  }

.header {
  background: purple;
  background-image:url(../../assets/logo.png);
	background-size:180px 60px;
	background-repeat:no-repeat;
  background-origin:content-box;
	padding-top:40px;
  text-align: center;
  padding: 20px;
}
.font-face {
  font-family: "阿里妈妈东方大楷 Regular";
  font-weight: 400;
  src: url("../../assets/font/Alimama_DongFangDaKai_Regular.woff2") format("woff2"),
  url("../../assets/font/Alimama_DongFangDaKai_Regular.woff") format("woff");
  font-display: swap;
}
.box-card-l {
        background: rgba(0,0,0,0);
        position: absolute;
        top: 50%;
        left: 30%;
        padding: 120px 120px 120px 120px;
        transform: translate(-50%, -50%);
        border-radius: 5px;
        border-style:none;
}
.box-card-r {
        background: rgba(0,0,0,0);
        position: absolute;
        top: 50%;
        left: 70%;
        padding: 120px 120px 120px 120px;
        transform: translate(-50%, -50%);
        border-radius: 5px;
        border-style:none;
}
.login-from {
  margin: auto auto;
}
</style>