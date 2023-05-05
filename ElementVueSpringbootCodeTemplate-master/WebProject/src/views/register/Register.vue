<template>
  <div>
    <el-card class="box-card">
      <h2>注册</h2>
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-position="left"
        label-width="80px"
        class="demo-ruleForm"
      >
        <el-form-item label="用户名" prop="uname">
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input
            type="password"
            v-model="ruleForm.pass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
<<<<<<< HEAD
        <el-form-item label="电话" prop="phone">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="所属部门" rule: required = true>
          <td class="td_right"><input type="radio" name="gender" value="market" checked> 市场部
          <input type="radio" name="gender" value="testing"> 测试部</td>
        </el-form-item>
        
=======
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
        <el-form-item label="邮箱" prop="email">
          <el-input
            v-model="ruleForm.email"
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="btnGroup">
<<<<<<< HEAD
        <el-button type="primary" @click="submitForm('ruleForm')" style = "margin: 18px"
          >提交</el-button>
        <el-button @click="resetForm('ruleForm')" style = "margin: 18px">重置</el-button>
        <el-button @click="goBack">登录</el-button>
=======
        <el-button type="primary" @click="submitForm('ruleForm')"
          >提交</el-button
        >
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <el-button @click="goBack">返回</el-button>
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        uname: "",
        pass: "",
        password: "",
      },
      rules: {
        uname: [
          { required: true, message: "用户名不能为空！", trigger: "blur" },
        ],
        pass: [{ required: true, validator: validatePass, trigger: "blur" }],
        password: [
          { required: true, validator: validatePass2, trigger: "blur" },
          {min: 6, max: 10, message: '名称长度在6到10个字符', trigger: 'blur'},
        ],
        email: [
          { required: true, message: "邮箱不能为空！", trigger: "blur" },
          {pattern: /(^[a-zA-Z]\w{5,17}@((126|163)\.com|yeah\.net)$)|(^[1-9]\d{4,10}@qq\.com$)/, message:"邮箱格式不符合规则"}
        ],
<<<<<<< HEAD
        department: [
          { required: true,message: "请选择您的部门", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "电话号码不能为空", trigger: "blur" },
          {pattern: /^[1]+[3,5,8]+\d{9}$/, message: "请输入正确的电话号码"}
        ],
=======
>>>>>>> 1d08763648340095c7498c2958ea635c141a594d
      },
    };
  },
  methods: {
    submitForm(formName) {
      /*this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });*/
      this.$router.push({path: "./login", replace:true});
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped>
.box-card {
  width: 340px;
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