<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
        <el-row>
        <el-col :span="23">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/TestScheme">软件测试方案</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="1">
          <el-button  size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
<<<<<<< HEAD
          <el-col :span="8">
=======
          <el-col :span="6">
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
            <router-link to="/Test">
            <el-button style="margin-top: 10px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
<<<<<<< HEAD
          <el-col :span="6" ><div class="grid-content bg-purple">
            <span class="logo-title">软件测试方案</span>
            </div></el-col>
            <el-col :span="10"  >
=======
          <el-col :span="8"><div class="grid-content bg-purple">
            <span class="logo-title">软件测试方案</span>
            </div></el-col>
            <el-col :span="10">
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
              <el-steps :space="200" :active="0" finish-status="success">
                <el-step title="软件测试方案填写"></el-step>
                <el-step title="方案评审表填写"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
            <el-col :span="2">
<<<<<<< HEAD
            <router-link to="/TestSchemeReviewForm">
            <el-button @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
=======
            <el-button style="margin-left: 40px;" @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
            </el-col>
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
        </el-row>
      </el-header>
        <br><br><br>
        <el-main>
          <el-form label-width="550px"  :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item label="1 引言" prop="Introduction" style="font-weight: bold; font-size: 15px; ">
            </el-form-item>
            <el-form-item label="1.1标识:" prop="Mark">
              <el-input v-model="ruleForm.Mark" style="width: 200px;" ></el-input>
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
<<<<<<< HEAD
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
=======
            <el-table :data="ruleForm.tableData"  style="width: 50%; margin-left: 25%;">
            <el-table-column fixed prop="MilestonesTasks" label="里程碑任务" width="110"></el-table-column>
            <el-table-column prop="Workload" label="工作量" width="400">
              <template slot-scope="scope">
                <el-input type="input_type" ref="enterInput" v-model="scope.row.Workload" :rows="2"  placeholder="工作量"/>
              </template>
            </el-table-column>
            <el-table-column prop="Start" label="开始时间" width="110">
              <template slot-scope="scope">
                <el-input type="input_type" ref="enterInput" v-model="scope.row.Start" :rows="2"  placeholder="开始时间"/>
              </template>
            </el-table-column>
            <el-table-column prop="End" label="结束时间" width="110">
              <template slot-scope="scope">
                <el-input type="input_type" ref="enterInput" v-model="scope.row.End" :rows="2"  placeholder="结束时间"/>
              </template>
            </el-table-column>
            </el-table>
            <el-form-item label="6 需求的可追踪性" prop="TraceabilityOfRequirement" style="font-weight: bold; font-size: 15px; margin-top: 20px;">
              <el-input v-model="ruleForm.TraceabilityOfRequirement" style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" type="textarea" placeholder=""/>
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
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
             ruleForm:{
               Mark:'',
               SystemOverview:'',
               DocumentationOverview:'',
               BaseLine:'',
               Hardware:'',
               Software:'',
               Other:'',
               ParticipatingOrganization:'',
<<<<<<< HEAD
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

                },
=======
               Personnel:'',
               TestLevel:'',
               TestCategory:'',
               GeneralTestCondtion:'',
               PlannedExecutionTest:'',
               TestCase:'',
               TraceabilityOfRequirement:'',
               tableData: [{
                MilestonesTasks:'制定测试计划',
                Workload:'',
                Start:'',
                End:'',
             },{
                MilestonesTasks:'设计测试',
                Workload:'',
                Start:'',
                End:'',
             },{
                MilestonesTasks:'执行测试',
                Workload:'',
                Start:'',
                End:'',
             },{
                MilestonesTasks:'评估测试',
                Workload:'',
                Start:'',
                End:'',
             }
            ],
             },
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
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
<<<<<<< HEAD
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
=======
                  DevelopTestingPlan:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  DesignTesting:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  PerformTesting:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  AssessmentTesting:[
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
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
<<<<<<< HEAD
          setTimeout(() => {this.$router.push({path: "./TestSchemeReviewForm", replace:true});}, 2000);
=======
          console.log(this.ruleForm);
          this.$message.success("提交成功！");
          //setTimeout(() => {this.$router.push({path: "./TestSchemeReviewForm", replace:true});}, 2000);
>>>>>>> 3fa4966e0c4ffb3a4902f5b2c26ab546f3ada077
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