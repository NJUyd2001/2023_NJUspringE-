<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/testscheme">测试方案</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-bottom: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/Test">
            <el-button style="margin-top: 10px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="8" push="1"><div class="grid-content bg-purple">
            <span class="logo-title">测试部-测试方案</span>
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
          <el-col :span="6" push="4">
            <el-button style="margin-top: 10px; margin-left: 30px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form style="margin-left: 200px; margin-top: 30px;" label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item label="1 引言" prop="Introduction" style="font-weight: bold; font-size: 15px; ">
            </el-form-item>
            <el-form-item label="1.1标识:" prop="Mark">
              <el-input v-model="ruleForm.Mark" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="1.2系统概述:" prop="SystemOverview">
              <el-input v-model="ruleForm.SystemOverview" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="1.3文档概述:" prop="DocumentationOverview">
              <el-input v-model="ruleForm.DocumentationOverview" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="1.4基线:" prop="BaseLine">
              <el-input v-model="ruleForm.BaseLine" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="2 引用文件:" prop="ApplicationFile" style="font-weight: bold; font-size: 15px; ">
              <el-input placeholder="《计算机软件文档编制规范》GB/T 8567－2006" v-model="ruleForm.ApplicationFile" style="width: 350px; "></el-input>
            </el-form-item>
            <el-form-item label="3 软件测试环境" prop="SoftwareTestEnvironment" style="font-weight: bold; font-size: 15px; margin-left: 20px;">
            </el-form-item>
            <el-form-item label="3.1硬件:" prop="Hardware">
              <el-input v-model="ruleForm.Hardware" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="3.2软件:" prop="Software">
              <el-input v-model="ruleForm.Software" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="3.3其他:" prop="Other">
              <el-input v-model="ruleForm.Other" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="3.4参与组织:" prop="ParticipatingOrganization">
              <el-input v-model="ruleForm.ParticipatingOrganization" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="3.5人员:" prop="Personnel" style="font-weight: normal; font-size: 15px; ">
            </el-form-item>
            <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"测试工程师"' :key="index" >
              <el-input placeholder="评审意见" style="width: 100px;padding-right:20px;" v-model="Table.EvaluationOpinion1"></el-input>
              <el-input placeholder="签  字" style="width: 100px;padding-right:20px;" v-model="Table.Sign1"></el-input>
              <el-input placeholder="日期" style="width: 100px;padding-right:20px;" v-model="Table.Date1"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"测试室负责人"' :key="index" >
              <el-input placeholder="评审意见" style="width: 100px;padding-right:20px;" v-model="Table.EvaluationOpinion2"></el-input>
              <el-input placeholder="签  字" style="width: 100px;padding-right:20px;" v-model="Table.Sign2"></el-input>
              <el-input placeholder="日期" style="width: 100px;padding-right:20px;" v-model="Table.Date2"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"质量负责人"' :key="index" >
              <el-input placeholder="评审意见" style="width: 100px;padding-right:20px;" v-model="Table.EvaluationOpinion3"></el-input>
              <el-input placeholder="签  字" style="width: 100px;padding-right:20px;" v-model="Table.Sign3"></el-input>
              <el-input placeholder="日期" style="width: 100px;padding-right:20px;" v-model="Table.Date3"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"技术负责人"' :key="index" >
              <el-input placeholder="评审意见" style="width: 100px;padding-right:20px;" v-model="Table.EvaluationOpinion4"></el-input>
              <el-input placeholder="签  字" style="width: 100px;padding-right:20px;" v-model="Table.Sign4"></el-input>
              <el-input placeholder="日期" style="width: 100px;padding-right:20px;" v-model="Table.Date4"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"监督人"' :key="index" >
              <el-input placeholder="评审意见" style="width: 100px;padding-right:20px;" v-model="Table.EvaluationOpinion5"></el-input>
              <el-input placeholder="签  字" style="width: 100px;padding-right:20px;" v-model="Table.Sign5"></el-input>
              <el-input placeholder="日期" style="width: 100px;padding-right:20px;" v-model="Table.Date5"></el-input>
            </el-form-item>
          </el-form>
            <el-form-item label="4 计划" prop="Plan" style="font-weight: bold; font-size: 15px; ">
            </el-form-item>
            <el-form-item label="4.1总体设计:" prop="OverallDesign" style="font-weight: normal; font-size: 15px; ">
            </el-form-item>
            <el-form-item label="软件名称:" prop="SoftWareName"> 
            <el-input style="width:200px;padding:10px" v-model="ruleForm.SoftWareName"></el-input>
            </el-form-item> 
            <el-form-item label="版本号:" prop="VersionNumber"> 
            <el-input style="width:200px;padding:10px" v-model="ruleForm.VersionNumber"></el-input>
            </el-form-item>
            <el-form-item label="测试类型:" prop="TypeTest"> 
              <el-select v-model="ruleForm.TypeTest" multiple allow-create filterable>
              <el-option   v-for='item in ruleForm.TypeOfTest' :key='item.id' :label="item.value" :value="item.value"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="一般测试条件:" prop="GeneralTestCondition">
              <el-input v-model="ruleForm.GeneralTestCondition" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="计划执行的测试:" prop="PlannedExecutionTest">
              <el-input v-model="ruleForm.PlannedExecutionTest" style="width: 200px;"></el-input>
            </el-form-item>
            <el-form-item label="评审内容:" prop="OverallDesign" style="font-weight: normal; font-size: 15px; ">
            </el-form-item>
            <el-form-item label="《测试方案》书写规范性：">
              <el-radio-group v-model="ruleForm.WritingNormality">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试环境是否具有典型意义以及是否符合用户要求：">
              <el-radio-group v-model="ruleForm.TestEnvironment">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试内容的完整性，是否覆盖了整个系统：">
              <el-radio-group v-model="ruleForm.Completeness">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试方法的选取是否合理：">
              <el-radio-group v-model="ruleForm.SelectMethod">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试用例能否覆盖问题：">
              <el-radio-group v-model="ruleForm.TestcaseCover">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="输入、输出数据设计合理性：">
              <el-radio-group v-model="ruleForm.InputOutputData">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试时间安排是否合理：">
              <el-radio-group v-model="ruleForm.Timing">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="测试人力资源安排是否合理：">
              <el-radio-group v-model="ruleForm.HumanResourcesArrangement">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="5 测试进度表" prop="TestSchedule" style="font-weight: bold; font-size: 15px; ">
            </el-form-item>
            <el-form label-width="400px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"制定测试计划"' :key="index" >
              <el-input placeholder="工作量" style="width: 100px;padding-right:20px;" v-model="Table.Workload1"></el-input>
              <el-input placeholder="开始时间" style="width: 100px;padding-right:20px;" v-model="Table.Start1"></el-input>
              <el-input placeholder="结束时间" style="width: 100px;padding-right:20px;" v-model="Table.End1"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"设计测试"' :key="index" >
              <el-input placeholder="工作量" style="width: 100px;padding-right:20px;" v-model="Table.Workload2"></el-input>
              <el-input placeholder="开始时间" style="width: 100px;padding-right:20px;" v-model="Table.Start2"></el-input>
              <el-input placeholder="结束时间" style="width: 100px;padding-right:20px;" v-model="Table.End2"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"执行测试"' :key="index" >
              <el-input placeholder="工作量" style="width: 100px;padding-right:20px;" v-model="Table.Workload3"></el-input>
              <el-input placeholder="开始时间" style="width: 100px;padding-right:20px;" v-model="Table.Start3"></el-input>
              <el-input placeholder="结束时间" style="width: 100px;padding-right:20px;" v-model="Table.End3"></el-input>
            </el-form-item>
          </el-form>
          <el-form label-width="400px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"评估测试"' :key="index" >
              <el-input placeholder="工作量" style="width: 100px;padding-right:20px;" v-model="Table.Workload4"></el-input>
              <el-input placeholder="开始时间" style="width: 100px;padding-right:20px;" v-model="Table.Start4"></el-input>
              <el-input placeholder="结束时间" style="width: 100px;padding-right:20px;" v-model="Table.End4"></el-input>
            </el-form-item>
          </el-form>
            <el-form-item label="6 需求的可追踪性" prop="Testcase" style="font-weight: bold; font-size: 15px; ">
              <el-input v-model="ruleForm.Testcase" style="width: 200px;"></el-input>
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
             ruleForm:{
               Mark:'',
               SystemOverview:'',
               DocumentationOverview:'',
               BaseLine:'',
               Hardware:'',
               Software:'',
               Other:'',
               ParticipatingOrganization:'',
               SoftWareName:'',
               VersionNumber:'',
               TypeTest:'',
               GeneralTestCondition:'',
               PlannedExecutionTest:'',
               WritingNormality:'',
               TestEnvironment:'',
               Completeness:'',
               SelectMethod:'',
               TestcaseCover:'',
               InputOutputData:'',
               Timing:'',
               HumanResourcesArrangement:'',
               Testcase:'',
             TableData:[
               {
                 id:1,
                 name:'',
                 function:'',
                 children:[],
             },
           ],
             },
                ruleForm1:{
                  EvaluationOpinion1:'',
                  Sign1:'',
                  Date:'',
                  EvaluationOpinion2:'',
                  Sign2:'',
                  Date:'',
                  EvaluationOpinion3:'',
                  Sign3:'',
                  Date:'',
                  EvaluationOpinion4:'',
                  Sign4:'',
                  Date4:'',
                  EvaluationOpinion5:'',
                  Sign5:'',
                  Date5:'',

                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                },
                ruleForm2:{
                    Workload1:'',
                    Start1:'',
                    End1:'',
                    Workload2:'',
                    Start2:'',
                    End2:'',
                    Workload3:'',
                    Start3:'',
                    End3:'',
                    Workload4:'',
                    Start4:'',
                    End4:'',
                },
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
                rules:{
                  Mark:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  SystemOverview:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  DocumentationOverview:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  BaseLine:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Hardware:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Software:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Other:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  ParticipatingOrganization:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  SoftWareName:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  VersionNumber:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  TypeTest:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  GeneralTestCondition:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  PlannedExecutionTest:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  WritingNormality:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  TestEnvironment:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Completeness:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  SelectMethod:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  TestcaseCover:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  InputOutputData:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Timing:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  HumanResourcesArrangement:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Testcase:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
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
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem(Table){
          const index = this.ruleForm.TableData.indexOf(Table)
          if (index !== -1) {
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