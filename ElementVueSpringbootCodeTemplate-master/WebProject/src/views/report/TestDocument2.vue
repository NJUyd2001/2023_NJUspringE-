<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
      <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
            <el-breadcrumb-item><a href="/testdocument2">测试文档</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-bottom: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="2">
            <router-link to="/report">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="14">
            <span class="logo-title3">测试记录</span>
          </el-col>
          <el-col :span="10" >
              <el-steps :space="200" :active="1" finish-status="success">
                <el-step title="测试用例填写"></el-step>
                <el-step title="测试记录填写"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
          <el-col :span="1">
            <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main style="margin-top:45px;">
            <el-form style="border-bottom-style:double; border-color: rgb(199, 196, 196); width:1560px; margin-top: 20px; margin-left: 100px; height: 35px;">
              <span style="margin-left: 10px;">测试分类</span>
              <span style="margin-left: 40px;">序号</span>
              <span style="margin-left: 35px;">测试用例设计说明</span>
              <span style="margin-left: 20px;">与本测试用例有关的规约说明</span>
              <span style="margin-left: 25px;">前提条件</span>
              <span style="margin-left: 30px;">测试用例执行过程</span>
              <span style="margin-left: 30px;">预期的结果</span>
              <span style="margin-left: 30px;">测试用例设计者</span>
              <span style="margin-left: 30px;">实际结果</span>
              <span style="margin-left: 30px;">是否与预期结果一致</span>
              <span style="margin-left: 25px;">相关的BUG编号</span>
              <span style="margin-left: 25px;">用例执行者</span><br><br>
              <span style="margin-left: 10px;">执行测试时间</span>
              <span style="margin-left: 35px;">确认人</span>
            </el-form>
            <el-form style="padding-top:40px;" label-width="100px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item style="width:1750px;" v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :label='"测试记录"+index+":"' :key="index" >
              <el-input placeholder="测试分类" style="width: 90px;padding-right:10px;" v-model="Table.TestClassification"></el-input>
              <el-input placeholder="序号" style="width: 60px;padding-right:10px;" v-model="Table.SerialNum"></el-input>
              <el-input placeholder="测试用例设计说明" style="width: 145px;padding-right:10px;" v-model="Table.DesignSpecification"></el-input>
              <el-input placeholder="与本测试用例有关的规约说明" style="width: 215px;padding-right:10px;" v-model="Table.Regulation"></el-input>
              <el-input placeholder="前提条件" style="width: 90px;padding-right:10px;" v-model="Table.Precondition"></el-input>
              <el-input placeholder="测试用例执行过程" style="width: 145px;padding-right:10px;" v-model="Table.ExecutionProcess"></el-input>
              <el-input placeholder="预期的结果" style="width: 100px;padding-right:10px;" v-model="Table.ExpectedResult"></el-input>
              <el-input placeholder="测试用例设计者" style="width: 130px;padding-right:10px;" v-model="Table.Designer"></el-input>
              <el-input placeholder="实际结果" style="width: 90px;padding-right:10px;" v-model="Table.ActualResult"></el-input>
              <el-input placeholder="是否与预期结果一致" style="width: 160px;padding-right:10px;" v-model="Table.Conformity"></el-input>
              <el-input placeholder="相关的BUG编号" style="width: 130px;padding-right:10px;" v-model="Table.BugNum"></el-input>
              <el-input placeholder="用例执行者" style="width: 100px;padding-right:10px;" v-model="Table.UsecaseExecutor"></el-input>
              <el-input placeholder="执行测试时间" style="width: 120px;padding-right:10px;margin-top:10px;" v-model="Table.TestingTime"></el-input>
              <el-input placeholder="确认人" style="width: 75px;padding-right:10px;margin-top:10px;" v-model="Table.ConfirmPerson"></el-input>
              <el-button @click="removefatherItem(Table)" type="primary" size="small" plain>删除</el-button>
              <el-button @click="addfatherItem()" type="primary" size="small" plain>增加功能项目</el-button>
            </el-form-item>
          </el-form>
        </el-main>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    import Axios from 'axios'
    export default {
        data(){
           return{
            userpid:{
              PID:"",
            },
            useruid:{
              UID:""
            },
            ruleForm:{
                  PID:"",
                    TableData:[
                      {
                        TestClassification:'',
                        SerialNum:'',
                        DesignSpecification:'',
                        Regulation:'',
                        Precondition:'',
                        ExecutionProcess:'',
                        ExpectedResult:'',
                        Designer:'',
                        ActualResult:'',
                        BugNum:'',
                        UsecaseExecutor:'',
                        TestingTime:'',
                        ConfirmPerson:'',
                      }
                    ]
                },
                rules:{
                  TestClassification:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  SerialNum:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  DesignSpecification:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Regulation:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Precondition:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  ExecutionProcess:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  ExpectedResult:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Designer:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  ActualResult:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  BugNum:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  UsecaseExecutor:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  TestingTime:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  ConfirmPerson:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  }
        }
    }, 
    created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.useruid.UID=this.$store.state.user.id;
    this.useruid.UID=17;
    // Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.userid),{
    //             headers:{
    //               'content-type': 'text/plain'}
    //           }).then(ret=>{
    //             console.log(ret.data)
    //             this.userpid.PID=ret.data.PID;
    //           })
    this.userpid.PID=20;
    this.ruleForm.PID=this.userpid.PID;
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
        addfatherItem(){
          this.ruleForm.TableData.push({
            id:this.ruleForm.TableData[this.ruleForm.TableData.length-1]+1,
            TestClassification:'',
            SerialNum:'',
            DesignSpecification:'',
            Regulation:'',
            Precondition:'',
            ExecutionProcess:'',
            ExpectedResult:'',
            Designer:'',
            ActualResult:'',
            BugNum:'',
            UsecaseExecutor:'',
            TestingTime:'',
            ConfirmPerson:'',
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
          Axios.post("http://localhost:9090/api/testrecord/insert",JSON.stringify(this.ruleForm),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
        console.log(ret.data);
        this.$message.success("提交成功！");
          //setTimeout(() => {this.$router.push({path: "./testdocument2", replace:true});}, 2000);
            })
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
    
    span.logo-title3{
      font-size: 30px;
      font-weight: bold;
      margin-left: 50%;
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