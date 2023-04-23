<template>
  
  <div>
  <div class="header">
  <h1>软件测试中心在线测试系统</h1>
</div>
    <h2></h2>
    <el-card class="box-card-l">
    <router-link to="/login">
      <el-button> 客户 </el-button>
    </router-link>
      
    </el-card>
    <el-card class="box-card-r">
    <router-link to="/login">
      <el-button> 软件测试中心 </el-button>
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
.box-card-l {
        background: white;
        position: absolute;
        top: 50%;
        left: 30%;
        padding: 120px 120px 120px 120px;
        transform: translate(-50%, -50%);
        border-radius: 5px;
}
.box-card-r {
        background: white;
        position: absolute;
        top: 50%;
        left: 70%;
        padding: 120px 120px 120px 120px;
        transform: translate(-50%, -50%);
        border-radius: 5px;
}
.login-from {
  margin: auto auto;
}
</style>