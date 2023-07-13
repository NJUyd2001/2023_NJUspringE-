<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/Defectlist">问题（缺陷）清单</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="2">
            <router-link to="/report">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="24">
            <span class="logo-title">问题（缺陷）清单</span>
          </el-col>
          <el-col :span="3">
            <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main style="margin-top:50px;">
            <el-form style="border-bottom-style:double; border-color: rgb(199, 196, 196); width:1330px; margin-top: 20px; margin-left: 100px; height: 40px;">
              <el-label style="margin-left: 20px;">序号</el-label>
              <el-label style="margin-left: 50px;">问题（缺陷）简要描述</el-label>
              <el-label style="margin-left: 40px;">对应需求条目</el-label>
              <el-label style="margin-left: 40px;">发现缺陷的初始条件</el-label>
              <el-label style="margin-left: 40px;">发现缺陷用例及具体操作路径（要具体）</el-label>
              <el-label style="margin-left: 20px;">关联用例</el-label>
              <el-label style="margin-left: 45px;">发现时间</el-label>
              <el-label style="margin-left: 50px;">责任人</el-label>
              <el-label style="margin-left: 45px;">修改建议</el-label>
            </el-form>
            <el-form style="padding-top:20px;" label-width="100px" :model="ruleForm" :rules="rules" ref="ruleForm">
              <el-form-item v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :rules="{
              required: true,
              message: '功能项目不能为空！',
              trigger: 'blur',
            }" :label='"问题"+index+":"' :key="index" >
              <el-input placeholder="序号" style="width: 70px;padding-right:20px;" v-model="Table.Num"></el-input>
              <el-input placeholder="问题（缺陷）简要描述" style="width: 180px;padding-right:20px;" v-model="Table.DefectDescription"></el-input>
              <el-input placeholder="对应需求条目" style="width: 120px;padding-right:20px;" v-model="Table.RequirementItems"></el-input>
              <el-input placeholder="发现缺陷的初始条件" style="width: 170px;padding-right:20px;" v-model="Table.DefectdetectionInitialcondition"></el-input>
              <el-input placeholder="发现缺陷用例及具体操作路径（要具体）" style="width: 280px;padding-right:20px;" v-model="Table.DefectdetectionSpecificpath"></el-input>
              <el-input placeholder="关联用例" style="width: 90px;padding-right:20px;" v-model="Table.Usecase"></el-input>
              <el-input placeholder="发现时间" style="width: 90px;padding-right:20px;" v-model="Table.DiscoveryTime"></el-input>
              <el-input placeholder="责任人" style="width: 80px;padding-right:20px;" v-model="Table.PersonResponsible"></el-input>
              <el-input placeholder="修改建议" style="width: 90px;padding-right:20px;" v-model="Table.Suggestion"></el-input>
              <el-button @click="removefatherItem(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
        </el-main>
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
                  TableData:[
                    {
                      Num:'',
                      DefectDescription:'',
                      RequirementItems:'',
                      DefectdetectionInitialcondition:'',
                      DefectdetectionSpecificpath:'',
                      Usecase:'',
                      DiscoveryTime:'',
                      PersonResponsible:'',
                      Suggestion:'',
                  },
              ],
                },
                rules:{
                  Num:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  DefectDescription:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  RequirementItems:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  DefectdetectionInitialcondition:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  DefectdetectionSpecificpath:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Usecase:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  DiscoveryTime:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  PersonResponsible:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Suggestion:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  }
        }
    }, 
      methods:{
        goback(){
        },
        addfatherItem(){
          this.ruleForm.TableData.push({
            id:this.ruleForm.TableData[this.ruleForm.TableData.length-1]+1,
            Num:'',
            DefectDescription:'',
            RequirementItems:'',
            DefectdetectionInitialcondition:'',
            DefectdetectionSpecificpath:'',
            Usecase:'',
            DiscoveryTime:'',
            PersonResponsible:'',
            Suggestion:'',
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
          console.log(this.ruleForm);
          this.$message.success("提交成功！");
          //setTimeout(() => {this.$router.push({path: "./TestSchemeReviewForm", replace:true});}, 2000);
        }
      },
    
    }
    
    </script>
    <style>
    .text-right {
      padding-right: 0px;
      text-align: right;
    }
    .span.logo-title{
      font-size: 30px;
      font-weight: bold;
      margin: auto;
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