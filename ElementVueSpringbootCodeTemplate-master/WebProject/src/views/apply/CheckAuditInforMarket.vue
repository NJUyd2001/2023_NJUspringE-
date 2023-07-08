<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px ">
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页-委托修改</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/auditapplicationmarket">审核意见查看</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
<el-col :span="2">
  <el-button @click="Logout()" style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col> 
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8">
        <router-link to="/Client">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <span class="logo-title">审核信息查看</span>
        </div></el-col>
        <el-col :span="10">
        <el-steps :space="200" :active="0" finish-status="success" >
          <el-step title="审核信息查看"></el-step>
          <el-step title="申请表修改"></el-step>
          <el-step title="功能列表修改"></el-step>
          <el-step title="修改完成"></el-step>
        </el-steps>
        </el-col>
      <el-col :span="2">
        <el-button  @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main>
      <br>
      <el-form label-position="middle" label-width="550px" :model="ruleForm" ref="ruleForm" disabled>
        <el-form-item label="审核意见：">
          <el-input style="width:700px;" :rows="5" v-model="ruleForm.Views" type="textarea" ></el-input>
        </el-form-item>
        <el-form-item label="受理意见：" prop="ConfirmOpinion" required>
          <el-radio-group v-model="ruleForm.ConfirmOpinion">
            <el-radio label="受理-进入测试部审核阶段 "></el-radio>
            <el-radio label="不受理"></el-radio>
            <el-radio label="进一步联系"></el-radio>
          </el-radio-group>
        </el-form-item>
    </el-form>
    </el-main>
  <LoginDialog :show='showLogin'/>
  <template>
  <el-backtop :right="50" :bottom="50" />
</template>
</el-container>
</template>
<script>
import Axios from 'axios'
export default {
    data(){
       return{
        userUid:{
          UID:"",
        },
        userAid:{
          AID:"",
        },
        ruleForm:{
        },
        stepNumber:1,
        }
        },
    created(){
      this.KeepInfor();
      this.userUid.UID=this.$store.state.user.id;
      Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.userUid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.$store.state.user.AID=ret.data[0].aid;
      })
      this.userAid.AID=this.$store.state.user.AID;
      console.log(this.$store.state.user.AID);
      Axios.post("http://localhost:9090/api/application/findopinion",JSON.stringify(this.userAid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.ruleForm=ret.data;
      })
    },
    mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload);
  window.addEventListener('unload', this.handleUnload);
  },
    methods:{
      handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
      },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
        },
      submitForm(formName) {
      // this.$refs[formName].validate((valid) => {
      //   if (valid) {
          this.$router.push({path: "./applicationamendmarket", replace:true});
          stepNumber+=1;
      //   } else {
      //     return false;
      //   }
      // });
      // this.info("提交成功，正在返回测试部界面！");
      // setTimeout(() => {this.$router.push({path: "./market", replace:true});}, 2000);
    },
    Logout(){
          this.$store.state.user.id=-1;
          this.$store.state.user.name="null";
          this.$store.state.user.password=-1;
          this.$store.state.user.Permissions="null";
      this.$router.push({path: "./home", replace:true});
    },
}
}

</script>
<style>
.text-right {
  padding-right: 0px;
  text-align: right;
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