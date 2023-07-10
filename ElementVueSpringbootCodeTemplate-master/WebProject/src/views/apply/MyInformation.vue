<template>
<el-container class="logo">
  <el-header style="height: 30px " >
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a/>个人信息完善</el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/client">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" push="4"><div class="grid-content bg-purple">
        <span class="logo-title">个人信息完善</span>
        </div></el-col>
        <el-col :span="6" pull="3">
        <div class="grid-content bg-purple-light text-right">
          <el-dropdown  @command="switchLang">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="zh">En</el-dropdown-item>
              <el-dropdown-item command="en">中</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div></el-col>
      <el-col :span="6" push="4">
        <el-button  size="middle" @click="submitForm('ruleForm')" >完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br><br>
    <el-main>
      <el-form label-width=40% :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label="传真:" prop="new_fax">
          <el-input v-model="ruleForm.new_fax" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="地址:" prop="new_address">
          <el-input v-model="ruleForm.new_address" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="邮编:" prop="new_zipcode">
          <el-input v-model="ruleForm.new_zipcode" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人:" prop="new_contact">
          <el-input v-model="ruleForm.new_contact" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人电话:" prop="new_contactTel">
          <el-input v-model="ruleForm.new_contactTel" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="网址:" prop="new_ip">
          <el-input v-model="ruleForm.new_ip" style="width: 200px;"></el-input>
        </el-form-item>
      </el-form>
    </el-main>
  <LoginDialog :show='showLogin'/>
</el-container>
</template>
<script>
import Axios from 'axios'
export default {
  mounted(){
    
  },
    data(){
       return{
            ruleForm:{
              new_fax:this.$store.state.user.fax,
              new_address:this.$store.state.user.address,
              new_zipcode:this.$store.state.user.zipcode,
              new_contact:this.$store.state.user.contact,
              new_contactTel:this.$store.state.user.contactTel,
              new_ip:this.$store.state.user.ip,
              UID:this.$store.state.user.id,
            },
            rules:{
              new_fax:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_address:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_zipcode:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_contact:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_contactTel:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_ip:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              choose:[
              { required: true, message: "不能为空！", trigger: "change" },
              ],
              }
    }
}, 
  methods:{
    goback(){
    },
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/update",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret)
        this.$message.success("提交成功，正在返回用户界面！");
        setTimeout(() => {this.$router.push({path: "../client", replace:true});}, 2000);
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