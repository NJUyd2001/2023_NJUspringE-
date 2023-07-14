<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/TestReportCover">测试报告声明</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/TestEnvironment">测试环境</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/testcontent">测试内容</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button style="margin-top: 10px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/TestEnvironment">
            <el-button size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="8"><div class="grid-content bg-purple">
            <span class="logo-title">测试内容</span>
            </div></el-col>
            <el-col :span="12">
          <el-steps :space="200" :active="3" finish-status="success">
          <el-step title="测试报告信息填写"></el-step>
          <el-step title="测试报告填写"></el-step>
          <el-step title="测试环境填写"></el-step>
          <el-step title="测试内容填写"></el-step>
          <el-step title="完成"></el-step>
          </el-steps>
          </el-col>
          <el-col :span="2">
            <el-button size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form style="padding-top:30px; margin-top: 40px;" label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData1" :prop="'TableData1.' + index + '.name'"  :label='"功能性测试"+index+":"' :key="index" >
              <el-input placeholder="功能模块" style="width: 100px;padding-right:20px;" v-model="Table.FunctionModule"></el-input>
              <el-input placeholder="功能要求" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.FunctionRequirement"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData2" :prop="'TableData2.' + index + '.name'" :label='"效率测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem1(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem1()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData3" :prop="'TableData3.' + index + '.name'" :label='"可移植性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem2(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem2()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData4" :prop="'TableData4.' + index + '.name'" :label='"易用性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem3(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem3()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData5" :prop="'TableData5.' + index + '.name'" :label='"可靠性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem4(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem4()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData6" :prop="'TableData6.' + index + '.name'"  s:label='"可维护性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem5(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem5()" type="primary" size="small">增加功能项目</el-button>
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
                useruid:{
                    UID:"",
                },
                userpid:{
                  PID:this.$store.state.user.process.PID,
                },
                ruleForm:{
                  PID:this.$store.state.user.process.PID,
                  TableData1:[
                    {
                      FunctionModule:'',
                      FunctionRequirement:'',
                      TestResult:'',   
                    },
                  ],TableData2:[
                    {
                      TestCharacteristic:'',
                      TestSpecification:'',
                      TestResult:'',
                    },
                  ],TableData3:[
                    {
                    TestCharacteristic:'',
                    TestSpecification:'',
                    TestResult:'',
                },
              ],TableData4:[
                    {
                    TestCharacteristic:'',
                    TestSpecification:'',
                    TestResult:'',
                    },
                  ],TableData5:[
                    {
                    TestCharacteristic:'',
                    TestSpecification:'',
                    TestResult:'', 
                    },
                  ],TableData6:[
                    {
                    TestCharacteristic:'',
                    TestSpecification:'',
                    TestResult:'',
                    },
                  ],
                },
              rules:{
                FunctionModule:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                FunctionRequirement:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestResult:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestCharacteristic:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestSpecification:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                },
        }
    }, 
    created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.useruid.UID=this.$store.state.user.id;
    Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.userid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data)
                this.userpid.PID=ret.data.PID;
                this.ruleForm.PID=this.userpid.PID
              })
              
  },
    mounted(){
        window.addEventListener('beforeunload', this.handleBeforeUnload());
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
          this.ruleForm.TableData1.push({
            id:this.ruleForm.TableData1[this.ruleForm.TableData1.length-1].id+1,
            name:'',
            function:'',
          })
        },
        removefatherItem(Table){
          const index = this.ruleForm.TableData1.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData1.splice(index, 1);
      }
        },
        addfatherItem1(){
          this.ruleForm.TableData2.push({
            id:this.ruleForm.TableData2[this.ruleForm.TableData2.length-1]+1,
            name:'',
            function:'',
          })
        },
        removefatherItem1(Table){
          const index = this.ruleForm.TableData2.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData2.splice(index, 1);
      }
        },
        addfatherItem2(){
          this.ruleForm.TableData3.push({
            id:this.ruleForm.TableData3[this.ruleForm.TableData3.length-1]+1,
            name:'',
            function:'',
          })
        },
        removefatherItem2(Table){
          const index = this.ruleForm.TableData3.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData3.splice(index, 1);
      }
        },
        addfatherItem3(){
          this.ruleForm.TableData4.push({
            id:this.ruleForm.TableData4[this.ruleForm.TableData4.length-1]+1,
            name:'',
            function:'',
          })
        },
        removefatherItem3(Table){
          const index = this.ruleForm.TableData4.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData4.splice(index, 1);
      }
        },
        addfatherItem4(){
          this.ruleForm.TableData5.push({
            id:this.ruleForm.TableData5[this.ruleForm.TableData5.length-1]+1,
            name:'',
            function:'',
          })
        },
        removefatherItem4(Table){
          const index = this.ruleForm.TableData5.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData5.splice(index, 1);
      }
        },
        addfatherItem5(){
          this.ruleForm.TableData6.push({
            id:this.ruleForm.TableData6[this.ruleForm.TableData6.length-1]+1,
            name:'',
            function:'',
          })
        },
        removefatherItem5(Table){
          const index = this.ruleForm.TableData6.indexOf(Table)
          if (index !== 0) {
          this.ruleForm.TableData6.splice(index, 1);
      }
        },
        submitForm(formName) {
      console.log(this.ruleForm);
          Axios.post("http://localhost:9090/api/testcontent/insert",JSON.stringify(this.ruleForm),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
        console.log(ret.data);
        this.$message.success("提交成功！");
          //setTimeout(() => {this.$router.push({path: "./test", replace:true});}, 2000);
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
      });   
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
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    span.logo-title{
      font-size: 30px;
      font-weight: bold;
      margin-left: 45%;
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

    .el-steps {
      margin-left: 150px;
    }
    </style>