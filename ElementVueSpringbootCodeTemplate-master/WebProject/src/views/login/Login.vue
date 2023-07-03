<template>
    <div id="logo">
    <div class="header">
      <img src="../../assets/l3.png" style="height:80px"/>
</div>
    <el-card class="box-card">
      <h2 style="text-align: center">登录</h2>
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-position="left"
        label-width="70px"
        class="login-from"
      >
        <el-form-item label="用户名" prop="uname">
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="btnGroup">
        <el-button style="margin: 14px" type="primary" @click="submitForm('ruleForm')"
          >登录</el-button>
        <router-link to="/home">
	          <el-button style="margin: 14px">返回</el-button>
        </router-link>
        <!-- 黄大伟添加 -->
        <router-link to="/admin">
          <el-button style="margin: 14px">管理员</el-button>
        </router-link>
      </div>
    </el-card>
  </div>
</template>

<script>
import Axios from 'axios'
export default {
  data() {
    return {
      ruleForm: {
        uname: "",
        password: "",
      },
      rules: {
        uname: [
          { required: true, message: "用户名不能为空！", trigger: "blur" },
        ],
        password: [
          { required: true, message: "密码不能为空！", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/login/staff",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        //console.log(ret.data)
        if(ret.data==="")
        {
          this.$message.error("您的用户名或密码错误,请重新输入！");
        }
        else
        {
        this.$store.state.user.id=ret.data.uid;
        this.$store.state.user.name=ret.data.nickname;
        this.$store.state.user.password=ret.data.password;
        this.$store.state.user.email=ret.data.emailAddr;
        this.$store.state.user.phone=ret.data.phone;
        this.$store.state.user.fax=ret.data.userfax;
        this.$store.state.user.Permissions=ret.data.usertype;
        this.$store.state.user.address=ret.data.address;
        this.$store.state.user.zipcode=ret.data.zipcode;
        this.$store.state.user.ip=ret.data.ip;
        this.$store.state.user.contact=ret.data.contact;
        this.$store.state.user.contactTel=ret.data.contactTel;
        console.log(ret.data)
        if(ret.data.usertype=="T")
        {
          this.info("登录成功!");
          setTimeout(() => {this.$router.push({path: "./test", replace:true});}, 1000);
        }
        else if(ret.data.usertype=='M')
        {
          this.info("登录成功!");
          setTimeout(() => {this.$router.push({path: "./market", replace:true});}, 1000);
        }
        else if(ret.data.usertype=='Q')
        {
          this.info("登录成功!");
          setTimeout(() => {this.$router.push({path: "./quality", replace:true});}, 1000);
        }
        else if(ret.data.usertype=='TL')
        {
          this.info("登录成功!");
          setTimeout(() => {this.$router.push({path: "./TestDirector", replace:true});}, 1000);
        }
        else if(ret.data.usertype=='A')
        {
          this.info("登录成功!");
          setTimeout(() => {this.$router.push({path: "./signatory", replace:true});}, 1000);
        }
        }
  })
      .catch(function (error) { // 请求失败处理
        console.log(error);
        // alert("error!");
      });   
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    regis(){
      this.$router.push({ path: '/register' })
    }
  },
};
</script>

<style scoped>
#logo{
    background: url("../../assets/b6.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%;
    margin: 0 auto;
  }
/* 设置登录面板居中，宽度为400px */
.box-card {
  width: 360px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width:450px;
    padding:50px;
    background: rgba(255,6255,255,.8);
    /*背景颜色为黑色，透明度为0.8*/
    box-sizing:border-box;
    /*box-sizing设置盒子模型的解析模式为怪异盒模型，
    将border和padding划归到width范围内*/
    box-shadow: 0px 15px 25px rgba(0,0,0,.5);
    /*边框阴影  水平阴影0 垂直阴影15px 模糊25px 颜色黑色透明度0.5*/
    border-radius:15px;
    /*边框圆角，四个角均为15px*/
}
/* 设置登录面板中的表单居中 */
.login-from {
  margin: auto auto;
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
</style>