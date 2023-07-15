<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
    <el-col :span="23">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '../client' }">主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/ctestreportcovercheck">测试报告声明</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/clientreportcheckreport">测试报告</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/ctestenvironmentcheck">测试环境</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/ctestcontentcheck">测试内容</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
<el-col :span="1">
  <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col> 
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="5">
        <router-link to="/marketauditfunctionlist">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <span class="logo-title">审核信息填写</span>
        </div></el-col>
        <el-col :span="12">
        <el-steps :space="200" :active="StepNumber" finish-status="success" >
          <el-step title="客户信息查看"></el-step>
          <el-step title="申请表查看"></el-step>
          <el-step title="功能列表查看"></el-step>
          <el-step title="审核意见填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
      <el-col :span="1">
        <el-button  @click="submitForm('ruleForm')" size="middle" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main>
      <br>
      <el-form label-position="middle" label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm" >
        <el-form-item label="审核意见：">
          <el-input style="width:700px;" :rows="5" v-model="ruleForm.Views" type="textarea" ></el-input>
        </el-form-item>
        <el-form-item label="受理意见：" prop="ConfirmOpinion"  required>
          <el-radio-group v-model="ruleForm.ConfirmOpinion">
            <el-radio label="受理" value="11"></el-radio>
            <el-radio label="不受理" value="15"></el-radio>
            <el-radio label="进一步联系" value="15"></el-radio>
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
  created(){
    this.KeepInfor();
    this.ruleForm.AID=this.$store.state.user.process.AID
    this.fpid.AID=this.$store.state.user.process.AID
    Axios.post("http://localhost:9090/api/process/findByAID",JSON.stringify(this.fpid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          this.Pid.PID=ret.data[0].pid;
          console.log(this.Pid.PID)
          console.log(this.$store.state.user.process.AID)
      })
  },
    data(){
       return{
        ruleForm:{
          AID:"",
          Views:"",
          ConfirmOpinion:"",
        },
        fpid:{
          AID:"",
        },
        mystate:'',
        Pid:{
          PID:"",
          state:"",
        },
        StepNumber:3,
        rules:{
          ConfirmOpinion:[
          { required: true, message: "请至少选择一个受理意见", trigger: "change" },
        ],
        }
        }
        },
    mounted() {
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
      this.$confirm("是否确认该操作","提示",{
        iconClass: "el-icon-question",//自定义图标样式
          confirmButtonText: "确认",//确认按钮文字更换
          cancelButtonText: "取消",//取消按钮文字更换
          showClose: true,//是否显示右上角关闭按钮
          type: "warning",//提示类型  success/info/warning/error
      }).then(() => {
        this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.ruleForm.ConfirmOpinion == "受理")
            this.Pid.state="72";
          else if(this.ruleForm.ConfirmOpinion == "不受理")
            this.Pid.state="76";
          else if(this.ruleForm.ConfirmOpinion == "进一步联系")
            this.Pid.state="76";
      Axios.post("http://localhost:9090/api/application/insertopinion",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        
      })
      Axios.post("http://localhost:9090/api/process/updateState",JSON.stringify(this.Pid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          console.log(this.Pid.state)
          this.$message.success("提交成功，正在返回用户界面！");
        this.StepNumber+=2;
        setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
      }) 
        } else {
          console.log("!")
          return false;
        }
      });
      })
      .catch(function (err) {
        //捕获异常
      });
      // Axios.post("http://localhost:9090/api/application/insertopinion",JSON.stringify(this.ruleForm),{
      //   headers:{
      //     'content-type': 'text/plain'}
      // }).then(ret=>{
      //   this.$message.success("提交成功，正在返回测试部界面！");
      //   this.StepNumber+=2;
      // setTimeout(() => {this.$router.push({path: "./market", replace:true});}, 2000);
      // })
      // .catch(function (error) { // 请求失败处理
      //   console.log(error);
      // }) 
    }
    },
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