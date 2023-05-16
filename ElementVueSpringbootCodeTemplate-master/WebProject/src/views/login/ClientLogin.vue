<template>
    <div id="logo">
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
        <router-link to>
	          <el-button style="margin: 14x" @click="$router.back(-1)">返回</el-button>
        </router-link>
        <!-- 黄大伟添加 -->
        <router-link to="/admin">
          <el-button style="margin: 14px">管理员</el-button>
        </router-link>
        <div class="tips"  style="float:right;">         
          <el-link type="white" @click="regis">还没有账号？点击注册</el-link></div>
      </div>
    </el-card>
  </div>
</template>

<script>
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
      this.$router.push({path: "./client", replace:true});
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
    background: url("../../assets/NJUbg.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%
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
</style>