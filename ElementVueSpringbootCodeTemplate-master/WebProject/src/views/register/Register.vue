<template>
  <div id="logo">
  <div class="header">
  <img src="../../assets/l3.png" style="height:80px"/>
</div>
    <el-card class="box-card">
      <h2 style="text-align: center">注册</h2>
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
            v-model="pass"
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
        <el-form-item label="电话" prop="phone">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        
        <el-form-item label="用户类型" prop="type">
        <el-select v-model="ruleForm.type" allow-create filterable>
        <el-option label="授权签字人" value="A"></el-option>
        <el-option label="测试部" value="T"></el-option>
        <el-option label="市场部" value="M"></el-option>
        <el-option label="测试部主管" value="TL"></el-option>
        <el-option label="质量部" value="Q"></el-option>
        </el-select>
       </el-form-item>
        <el-form-item label="邮箱" prop="emailAddr">
          <el-input
            v-model="ruleForm.emailAddr"
          ></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="submitForm('ruleForm')" style = "margin: 18px"
          >提交</el-button>
        <el-button @click="resetForm('ruleForm', 'pass')" style = "margin: 18px">重置</el-button>
        <el-button @click="goBack">返回</el-button>
    </el-card>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'margin:0;')
  },
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
      } else if (value !== this.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      pass: "",
      ruleForm: {
        type:"",
        uname: "",
        password: "",
        emailAddr:"",
        phone:"",
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
        emailAddr: [
          { required: true, message: "邮箱不能为空！", trigger: "blur" },
          {pattern: /(^[a-zA-Z]\w{5,17}@((126|163)\.com|yeah\.net)$)|(^[1-9]\d{4,10}@qq\.com$)/, message:"邮箱格式不符合规则"}
        ],
        type: [
          { required: true,message: "请选择您的部门", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "电话号码不能为空", trigger: "blur" },
          {pattern: /^[1]+[3,5,8]+\d{9}$/, message: "请输入正确的电话号码"}
        ],
      },
      TypeOfTest:[
              {
                id:1,
                value:"M",
              },
              {
                id:2,
                value:"T",
              },
              {
                id:3,
                value:"A",
              },
            ],
    };
  },
  methods: {
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/insert",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        this.$message.success("注册成功！");
        setTimeout(() => {this.$router.push({path: "./admin", replace:true});}, 2000);
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
        // alert("error!");
      });    
      
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
#logo{
    background: url("../../assets/NJUbg.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%;
    margin: 0 auto;
  }
.box-card {
  width: 360px;
        background: rgba(255, 255, 255, 0.8);
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        border-radius: 5px;
    height: 550px;
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