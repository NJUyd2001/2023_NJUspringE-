<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/client' }">用户主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/client/DataSubmit">软件项目委托测试提交材料</a></el-breadcrumb-item>
      </el-breadcrumb>
      </el-col>
        <el-col :span="2">
        <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/client">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="12" ><div class="grid-content bg-purple">
            <h1 style="margin-left: 30%;">软件项目委托测试提交材料</h1>
            </div></el-col>
          <el-col :span="6" push="4">
            <el-button style="margin-top: -25px; margin-left: 70px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <br>
            <p id="ContractText" style="margin-top: 70px; margin-left: 10%;"><strong>一.	软件项目委托测试需要提交的文档： </strong><br>
                1.	《软件项目委托测试申请表》：<br>
                (1) 书面一份加盖公章；<br>
                (2) 电子文档。<br>
                2.	《委托测试软件功能列表》: <br>
                (1) 书面一份加盖公章 <br>
                (2) 电子文档 <br>
                3.	《软件项目委托测试保密协议》、《软件项目委托测试合同》：格式按照合同及协议规范签订。<br>
                (1) 书面各两分 <br>
                (2) 电子文档 <br>
                4.   软件资料: 包括《用户手册》、《安装手册》、《操作手册》、《维护手册》。(手册要有详细的目录索引、页码标识、文档版本号、技术支持联系方法、公司名称、地址等) <br>
                (1) 电子文档 <br>
                5.	《无法检测功能的声明》<br>
                (1) 书面一份加盖公章 <br>
                (2) 电子文档 </p>
          <br>
            <p id="ContractText" style="margin-top: 70px; margin-left: 10%;"><strong> 二.  提交软件样品： </strong> <br>
                1.	提交软件样品一套（与《委托测试软件功能列表》一致）；附相应的平台及支持性数据。</p>
          <br>
            <p id="ContractText" style="margin-top: 70px; margin-left: 10%;"><strong> 三.	其它  </strong> <br>
                1.	以上一、二项所要求提交的电子文档集中刻成一张（或按实际情况分开来刻录）光盘里； <br>
                2.	以上申报材料（书面文档、电子文档）请在签订合同5天内提交我中心； <br>
                3.	如有疑问请发电子邮件或电话联系。</p>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    import Axios from 'axios';
    
    export default {
        data(){
           return{ }
    }, 
      methods:{
        TestInfor(){
          //alert(JSON.stringify(this.ruleForm));
        },
        submitForm(formName) {
          /*this.$refs[formName].validate((valid) => {
            if (valid) {
              alert("submit!");
              this.$router.push({path: "./client", replace:true});
            } else {
              return false;
            }
          });*/
          Axios.post("http://localhost:1234/user/insert",JSON.stringify(this.ruleForm)).then(ret=>{
            console.log(ret.data)
          })
          .catch(function (error) { // 请求失败处理
            console.log(error);
          });
          // this.info("提交成功，正在返回用户界面！");
          // setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
        }
      },
    
    }
    
    </script>
    <style>
    .h1 {
      margin-left: -10%;
    }
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
    
    </style>