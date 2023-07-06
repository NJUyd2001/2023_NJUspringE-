<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-row>
    <el-col :span="23">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/test' }">测试部主页-审核委托</el-breadcrumb-item>
    <el-breadcrumb-item :to="{ path: '/testaudituser' }">客户信息查看</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testauditapplication">申请表查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testauditfunctionlist">功能列表查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testcheckmarketinfor">审核意见查看(市场部)</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/testapplication">审核信息填写</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
<el-col :span="1">
  <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col> 
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="5">
        <router-link to="/testcheckmarketinfor">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <span class="logo-title">审核信息填写</span>
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
      <el-col :span="2">
        <el-button  @click="submitForm('ruleForm')" size="middle" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br><br><br>
    <el-main>
      <el-form :label-position="top" label-width="550px">
        <el-form-item label="密级：">
          <el-radio-group v-model="ruleForm.Security">
            <el-radio label="无密级"></el-radio>
            <el-radio label="秘密"></el-radio>
            <el-radio label="机密"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="病毒查杀与否：">
          <el-radio-group v-model="ruleForm.VirusDetection.Finish">
            <el-radio label="已完成"></el-radio>
            <el-radio label="无法完成"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="病毒查杀所用工具：">
          <el-input style="width: 200px;padding:10px;" v-model="ruleForm.VirusDetection.Tool" ></el-input>
        </el-form-item>
        <el-form-item label="材料检查.测试样品：">
          <el-checkbox-group v-model="ruleForm.CheckofMaterials.TestSample">
            <el-checkbox label="源代码"></el-checkbox>
            <el-checkbox label="可执行文件"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="材料检查.需求文档：">
          <el-checkbox-group v-model="ruleForm.CheckofMaterials.RequirementDocument">
            <el-checkbox label="项目计划任务书"></el-checkbox>
            <el-checkbox label="需求分析报告"></el-checkbox>
            <el-checkbox label="合同"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="材料检查.用户文档：">
          <el-checkbox-group v-model="ruleForm.CheckofMaterials.UserDocument">
            <el-checkbox label="用户手册"></el-checkbox>
            <el-checkbox label="需求分析报告"></el-checkbox>
            <el-checkbox label="合同"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="材料检查.操作文档：">
          <el-checkbox-group v-model="ruleForm.CheckofMaterials.OperationDocument">
            <el-checkbox label="操作员手册"></el-checkbox>
            <el-checkbox label="安装手册"></el-checkbox>
            <el-checkbox label="诊断手册"></el-checkbox>
            <el-checkbox label="支持手册"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="材料检查.其他：">
          <el-input style="width:400px;" :rows="5" v-model="ruleForm.CheckofMaterials.Other" type="textarea" ></el-input>
        </el-form-item>
        <el-form-item label="确认意见：">
          <el-radio-group v-model="ruleForm.ConfirmOpinion">
            <el-radio label="测试所需材料不全，未达到受理条件。"></el-radio>
            <el-radio label="属依据国家标准或自编非标规范进行的常规检测，有资质、能力和资源满足委托方要求。"></el-radio>
            <el-radio label="无国家标准和规范依据，或中心缺乏检测设备和工具，无法完成检测。"></el-radio>
            <el-radio label="超出中心能力和资质范围，无法完成检测。"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="受理意见：">
          <el-radio-group v-model="ruleForm.ConfirmOpinion">
            <el-radio label="受理-进入项目立项和合同评审流程 "></el-radio>
            <el-radio label="不受理"></el-radio>
            <el-radio label="进一步联系"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="测试项目编号：">
          <el-input style="width:300px;" :rows="5" v-model="ruleForm.Number" ></el-input>
        </el-form-item>
        <el-form-item label="备注：">
          <el-input style="width:700px;" :rows="5" v-model="ruleForm.PS" type="textarea"></el-input>
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
export default {
    data(){
       return{
        ruleForm:{ 
          Security:'',    
          VirusDetection:{
            Finish:'',
            Tool:'',
          },
          CheckofMaterials:{
            TestSample:[],
            RequirementDocument:[],
            UserDocument:[],
            OperationDocument:[],
            Other:'',
          },
          ConfirmOpinion:'',
          OpinionofAcceptance:'',
          Number:'',
          PS:'',
        },
        StepNumber:4,
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
      this.$message.success("提交成功，正在返回测试部界面！");
      this.StepNumber+=2;
      setTimeout(() => {this.$router.push({path: "./test", replace:true});}, 2000);
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