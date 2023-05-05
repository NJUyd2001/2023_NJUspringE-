<template>
<<<<<<< HEAD
    
=======
  <div>
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
    <el-card class="box-card">
      <h2>登录</h2>
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
        <el-button type="primary" @click="submitForm('ruleForm')"
          >登录</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <router-link to="/register">
          <el-button style="margin-left:10px">注册</el-button>
        </router-link>
        <router-link to="/home">
          <el-button style="margin-left:10px">返回</el-button>
        </router-link>
        <!-- 黄大伟添加 -->
        <router-link to="/admin">
<<<<<<< HEAD
          <el-button style="margin-left:10px, margin-top:5px">管理员界面</el-button>
=======
          <el-button style="margin-left:10px">管理员界面</el-button>
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
        </router-link>
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
<<<<<<< HEAD
      this.$router.push({path: "./market", replace:true});
=======
      this.$router.push({path: "./client", replace:true});
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
/* 设置登录面板居中，宽度为400px */
.box-card {
  width: 360px;
        background: white;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        border-radius: 5px;
}
/* 设置登录面板中的表单居中 */
.login-from {
  margin: auto auto;
}
</style>