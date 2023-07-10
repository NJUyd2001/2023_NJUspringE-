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
            <el-button style="margin-top: -25px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="8" push="4"><div class="grid-content bg-purple">
            <span class="logo-title">测试内容</span>
            </div></el-col>
            <el-col :span="12" push="3">
          <el-steps :space="200" :active="3" finish-status="success">
          <el-step title="测试报告信息填写"></el-step>
          <el-step title="测试报告填写"></el-step>
          <el-step title="测试环境填写"></el-step>
          <el-step title="测试内容填写"></el-step>
          <el-step title="完成"></el-step>
          </el-steps>
          </el-col>
            <el-col :span="6" >
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span>
              </span>
            </div></el-col>
          <el-col :span="6" push="2">
            <el-button style="margin-top: -25px; margin-left: 20px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form style="padding-top:30px; margin-top: 40px;" label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"功能性测试"+index+":"' :key="index" >
              <el-input placeholder="功能模块" style="width: 100px;padding-right:20px;" v-model="Table.FunctionModule"></el-input>
              <el-input placeholder="功能要求" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.FunctionRequirement"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult"></el-input>
              <el-button @click="removefatherItem(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"效率测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult1"></el-input>
              <el-button @click="removefatherItem1(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem1()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可移植性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic1"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification1"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult2"></el-input>
              <el-button @click="removefatherItem2(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem2()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm3" :rules="rules" ref="ruleForm3">
            <el-form-item v-for="(Table,index) in ruleForm3.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"易用性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic2"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification2"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult3"></el-input>
              <el-button @click="removefatherItem3(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem3()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm4" :rules="rules" ref="ruleForm4">
            <el-form-item v-for="(Table,index) in ruleForm4.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可靠性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic3"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification3"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult4"></el-input>
              <el-button @click="removefatherItem4(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem4()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm5" :rules="rules" ref="ruleForm5">
            <el-form-item v-for="(Table,index) in ruleForm5.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可维护性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.TestCharacteristic4"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.TestSpecification4"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.TestResult5"></el-input>
              <el-button @click="removefatherItem5(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem5()" type="primary" size="small">增加功能项目</el-button>
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
                  TableData:[
                    {
                      FunctionModule:'',
                      FunctionRequirement:'',
                      TestResult:'',   
                    },
                  ],
                },
                ruleForm1:{
                  TableData:[
                    {
                      TestCharacteristic:'',
                      TestSpecification:'',
                      TestResult1:'',
                    },
                  ],
                },
                ruleForm2:{
                  TableData:[
                    {
                    TestCharacteristic1:'',
                    TestSpecification1:'',
                    TestResult2:'',
                },
              ],
                },
                ruleForm3:{
                  TableData:[
                    {
                    TestCharacteristic2:'',
                    TestSpecification2:'',
                    TestResult3:'',
                    },
                  ],
                },
                ruleForm4:{
                  TableData:[
                    {
                    TestCharacteristic3:'',
                    TestSpecification3:'',
                    TestResult4:'', 
                    },
                  ],
                },
                ruleForm5:{
                  TableData:[
                    {
                    TestCharacteristic4:'',
                    TestSpecification4:'',
                    TestResult5:'',
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
                TestResult1:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestCharacteristic1:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestSpecification1:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestResult2:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestSpecification2:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestResult3:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestCharacteristic3:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestSpecification3:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestResult4:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestCharacteristic4:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestSpecification4:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestResult5:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                },
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
        addfatherItem1(){
          this.ruleForm1.TableData.push({
            id:this.ruleForm1.TableData[this.ruleForm1.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem1(Table){
          const index = this.ruleForm1.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm1.TableData.splice(index, 1);
      }
        },
        addfatherItem2(){
          this.ruleForm2.TableData.push({
            id:this.ruleForm2.TableData[this.ruleForm2.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem2(Table){
          const index = this.ruleForm2.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm2.TableData.splice(index, 1);
      }
        },
        addfatherItem3(){
          this.ruleForm3.TableData.push({
            id:this.ruleForm3.TableData[this.ruleForm3.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem3(Table){
          const index = this.ruleForm3.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm3.TableData.splice(index, 1);
      }
        },
        addfatherItem4(){
          this.ruleForm4.TableData.push({
            id:this.ruleForm4.TableData[this.ruleForm4.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem4(Table){
          const index = this.ruleForm4.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm4.TableData.splice(index, 1);
      }
        },
        addfatherItem5(){
          this.ruleForm5.TableData.push({
            id:this.ruleForm5.TableData[this.ruleForm5.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem5(Table){
          const index = this.ruleForm5.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm5.TableData.splice(index, 1);
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
          this.$message.success("提交成功，正在返回用户界面！");
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