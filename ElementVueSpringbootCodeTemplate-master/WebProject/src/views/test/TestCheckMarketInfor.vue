<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px ">
    <el-row>
    <el-col :span="23">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/test' }">测试部主页-审核委托</el-breadcrumb-item>
    <el-breadcrumb-item :to="{ path: '/testaudituser' }">客户信息查看</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testauditapplication">申请表查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testauditfunctionlist">功能列表查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/testapplication">审核意见查看(市场部)</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
<el-col :span="1">
  <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col> 
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/testauditfunctionlist">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <span class="logo-title">审核意见查看</span>
        </div></el-col>
        <el-col :span="14">
        <el-steps :space="200" :active="StepNumber" finish-status="success" >
          <el-step title="客户信息查看"></el-step>
          <el-step title="申请表查看"></el-step>
          <el-step title="功能列表查看"></el-step>
          <el-step title="审核意见查看"></el-step>
          <el-step title="审核信息填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
      <el-col :span="1">
        <el-button  @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main>
      <br>
      <el-form label-position="top" disabled label-width="550px">
        <el-form-item label="审核意见：">
          <el-input style="width:700px;" :rows="5" v-model="ruleform.Views" type="textarea" ></el-input>
        </el-form-item>
        <el-form-item label="受理意见：">
          <el-radio-group v-model="ruleform.ConfirmOpinion">
            <el-radio label="受理-进入测试部审核阶段"></el-radio>
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
    created()
    {
      this.KeepInfor();
      this.user.AID=this.$store.state.user.process.AID;
      console.log(this.$store.state.user.process.AID)
      Axios.post("http://localhost:9090/api/application/findopinion",JSON.stringify(this.user),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          console.log(ret.data)
           this.ruleform=ret.data;
      }).catch(function (error)
        {
          console.log(error);
        }
      )
    },
    data(){
       return{
        user:{
          AID:"",
        },
        ruleform:{
        },
        StepNumber:3,
        }
        },
    methods:{
      submitForm(formName) {
      // this.$refs[formName].validate((valid) => {
      //   if (valid) {
      //     this.$router.push({path: "./market", replace:true});
      //   } else {
      //     return false;
      //   }
      // });

      this.StepNumber+=2;
      this.$router.push({path: "./testauditinfor", replace:true});
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