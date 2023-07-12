<template>
<el-container class="logo">
  <el-header style="height: 30px " >
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a/>个人信息完善</el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="2">
        <router-link to="/client">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="20" ><div class="grid-content bg-purple">
        <span class="logo-title">个人信息完善</span>
        </div></el-col>
      <el-col :span="2" >
        <el-button  size="middle" @click="submitForm('ruleForm')" >完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br><br>
    <el-main>
      <br>
      <el-form label-width=40% :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label="传真:" prop="fax">
          <el-input v-model="ruleForm.userfax" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="地址:" prop="address">
          <el-input v-model="ruleForm.address" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="邮编:" prop="zipcode">
          <el-input v-model="ruleForm.zipcode" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人:" prop="contact">
          <el-input v-model="ruleForm.contact" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人电话:" prop="contactTel">
          <el-input v-model="ruleForm.contactTel" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="网址:" prop="ip">
          <el-input v-model="ruleForm.ip" style="width: 200px;"></el-input>
        </el-form-item>
      </el-form>
    </el-main>
</el-container>
</template>
<script>
import Axios from 'axios'
export default {
  created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    console.log(this.$store.state.user.id);
    this.userid.UID=this.$store.state.user.id;
    Axios.post("http://localhost:9090/api/user/selectByUID",JSON.stringify(this.userid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.ruleForm=ret.data;
        this.ruleForm.UID=this.userid.UID;
      })
  },
  mounted(){
    window.addEventListener('beforeunload', this.handleBeforeUnload);
    window.addEventListener('unload', this.handleUnload);
  },
    data(){
       return{
        userid:{
            UID:"",
        },
            ruleForm:{
            },
            rules:{
              fax:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              address:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              zipcode:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              contact:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              contactTel:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              ip:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              choose:[
              { required: true, message: "不能为空！", trigger: "change" },
              ],
              }
    }
}, 
  methods:{
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
    },
    handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
    goback(){
    },
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/update",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.$message.success("提交成功，正在返回用户界面！");
       //setTimeout(() => {this.$router.push({path: "../client", replace:true});}, 2000);
      })
    },
  },

}

</script>
<style>
.text-right {
  padding-right: 0px;
  text-align: right;
}

.logo{
  background: url("../../assets/b3.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%
  }

.user {
  margin: 10px;
  font-size: 12px;
}

.header {
  position: relative;
  z-index: 1;
}

.el-header{
  margin: 10px 0 10px 0;  
}
.header .nav {
  height: 40px;
  color: #fff;
  text-align: center;
}
.banner {
  position: relative;
  z-index: 0;
  margin: 3px auto;
  height: 200px;
}

.el-container .el-main{
  padding: 0px 5px 5px 5px;
}

.index {
  padding-left: 10px;
}
.el-input{
    padding:15px,
    
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  height: 100%;
}

span.logo-title{
  font-size: 30px;
  font-weight: bold;
}

.demo-date-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}

.demo-date-picker .block {
  padding: 30px 0;
  text-align: left;
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}

.demo-date-picker .block:last-child {
  border-right: none;
}

.demo-date-picker .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
</style>