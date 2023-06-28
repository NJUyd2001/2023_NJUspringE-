<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
            <el-breadcrumb-item><a href="/testdocument1">测试文档</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-bottom: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/report">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" push="1">
            <div class="grid-content bg-purple">
            <span class="logo-title2">测试文档填写</span>
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
          <el-col :span="6" push="5">
            <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main style="margin-top:50px;">
            <el-form style="border-bottom-style:double; border-color: rgb(199, 196, 196); width:1020px; margin-top: 20px; margin-left: 100px; height: 40px;">
              <el-label style="margin-left: 20px;">测试分类</el-label>
              <el-label style="margin-left: 70px;">ID</el-label>
              <el-label style="margin-left: 80px;">测试用例设计说明</el-label>
              <el-label style="margin-left: 35px;">与本测试用例有关的规约说明</el-label>
              <el-label style="margin-left: 40px;">预期的结果</el-label>
              <el-label style="margin-left: 40px;">测试用例设计者</el-label>
              <el-label style="margin-left: 40px;">测试时间</el-label>
            </el-form>
            <el-form style="padding-top:20px;" label-width="100px" :model="ruleForm" :rules="rules" ref="ruleForm">
              <el-form-item v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :rules="{
              required: true,
              message: '功能项目不能为空！',
              trigger: 'blur',
            }" :label='"测试用例"+index+":"' :key="index" >
              <el-input placeholder="测试分类" style="width: 100px;padding-right:20px;" v-model="Table.testclassification"></el-input>
              <el-input placeholder="ID" style="width: 100px;padding-right:20px;" v-model="Table.num"></el-input>
              <el-input placeholder="测试用例设计说明" style="width: 150px;padding-right:20px;" v-model="Table.testcasedesign"></el-input>
              <el-input placeholder="与本测试用例有关的规约说明" style="width: 220px;padding-right:20px;" v-model="Table.stockdescription"></el-input>
              <el-input placeholder="预期的结果" style="width: 100px;padding-right:20px;" v-model="Table.expectedresult"></el-input>
              <el-input placeholder="测试用例设计者" style="width: 130px;padding-right:20px;" v-model="Table.designer"></el-input>
              <el-input placeholder="测试时间" style="width: 100px;padding-right:20px;" v-model="Table.time"></el-input>
              <el-button @click="removefatherItem(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    export default {
        data(){
           return{
                user:{
                    name:'风车村',
                    password:'shazihuang',
                    telephone:'',
                    fax:'',
                    address:'',
                    postcode:'',
                    contacts:'',
                    mobilephone:'',
                    email:'',
                    URL:'',
                },
                ruleForm:{
                    testclassification:'',
                    num:'',
                    testcasedesign:'',
                    stockdescription:'',
                    expectedresult:'',
                    designer:'',
                    time:'',
                
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                },
                rules:{
                
                  }
        }
    }, 
      methods:{
        goback(){
        },
        addfatherItem(){
          this.ruleForm.TableData.push({
            id:this.ruleForm.TableData[this.ruleForm.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem(Table){
          const index = this.ruleForm.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData.splice(index, 1);
      }
        },
        addchildrenItem(Node){
            Node.children.push(
              {
                id:'',
                
              }
            )
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
          this.info("提交成功，正在返回用户界面！");
          setTimeout(() => {this.$router.push({path: "./Test", replace:true});}, 2000);
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
    
    span.logo-title2{
      font-size: 20px;
      font-weight: bold;
      margin-left: 50px;
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