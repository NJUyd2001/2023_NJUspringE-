 <!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/TestScheme">软件测试方案</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/TestSchemeReviewForm">测试方案评审表</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button  size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/testscheme">
            <el-button size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="8"><div class="grid-content bg-purple">
            <span class="logo-title">测试方案评审表</span>
            </div></el-col>
            <el-col :span="10">
              <el-steps :space="200" :active="1" finish-status="success">
                <el-step title="软件测试方案填写"></el-step>
                <el-step title="测试方案评审表填写"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
            <el-col :span="1">
            <el-button @click="submitForm('ruleForm')" size="middle" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br><br>
        <el-main>
          <el-form disabled label-width="50%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-row>
            <el-col :span="12">
            <el-form-item  label="软件名称:" prop="SoftWareName"> 
                <el-input v-model="ruleForm.SoftWareName" style="width:200px; padding:10px;"  ></el-input>
            </el-form-item> 
            </el-col>
            <el-col :span="4">
                <el-form-item label="版本号:" prop="VersionNumber"> 
                    <el-input style="width:200px; padding:10px;" v-model="ruleForm.VersionNumber"></el-input>
                </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
            <el-form-item  label="项目编号:" prop="ProjectNum"> 
                <el-input style="width:200px; padding:10px;" v-model="ruleForm.ProjectNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="4">
                <el-form-item  label="测试类别:" prop="TestCategory"> 
                    <el-input style="width:200px; padding:10px;" v-model="ruleForm.TestCategory"></el-input>
                </el-form-item>
            </el-col>
          </el-row>
            <el-form-item label="评审内容:" prop="OverallDesign" style="font-weight: bold; font-size: 15px;">
            </el-form-item>
                <el-form-item label="《测试方案》书写规范性：">
                    <el-radio-group v-model="ruleForm.WritingNormality">
                        <el-radio label="通过"></el-radio>
                        <el-radio label="不通过"></el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item  label="测试环境是否具有典型意义以及是否符合用户要求：">
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
            <el-form-item  label="测试方法的选取是否合理：">
              <el-radio-group v-model="ruleForm.SelectMethod">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item  label="测试用例能否覆盖问题：">
              <el-radio-group v-model="ruleForm.TestcaseCover">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item  label="输入、输出数据设计合理性：">
              <el-radio-group v-model="ruleForm.InputOutputData">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item  label="测试时间安排是否合理：">
              <el-radio-group v-model="ruleForm.Timing">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item  label="测试人力资源安排是否合理：">
              <el-radio-group v-model="ruleForm.HumanResourcesArrangement">
                <el-radio label="通过"></el-radio>
                <el-radio label="不通过"></el-radio>
              </el-radio-group>
            </el-form-item>
            <el-table :data="ruleForm.tableData"  style="width: 50%; margin-left: 25%;">
            <el-table-column fixed prop="Duty" label="职责" width="110"></el-table-column>
            <el-table-column prop="EvalutionOpinion" label="评审意见" width="400">
              <template slot-scope="scope">
                <el-input :type="input_type" ref="enterInput" v-model="scope.row.EvalutionOpinion" :rows="2"  placeholder="评审意见"/>
              </template>
            </el-table-column>
            <el-table-column prop="Sign" label="签字" width="100">
              <template slot-scope="scope">
                <el-input :type="input_type" ref="enterInput" v-model="scope.row.Sign" :rows="2"  placeholder="签字"/>
              </template>
            </el-table-column>
            <el-table-column prop="Date" label="日期" width="100">
                <template slot-scope="scope">
                <el-input :type="input_type" ref="enterInput" v-model="scope.row.Date" :rows="2"  placeholder="日期"/>
              </template>
            </el-table-column>
            </el-table>
            <br><br>
          </el-form>
        </el-main>
    </el-container>
    </template>

    <script>
import Axios from 'axios';
    export default {
        data(){
           return{
             input_type:'text',
             TSRF:{
              PID:this.$store.state.user.process.PID,
              state:"51",
            },
             ruleForm:{
              },
            rules:{
                  SoftWareName:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  VersionNumber:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  ProjectNum:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  TestCategory:[
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
            }
        }
    },
      methods: {
        handleClick() {
        console.log('click');
        },
        operation(row){
        console.log(row);
        },
        list(){
          this.input_type = 'textarea'
           this.$nextTick(function () { 
               if (this.$refs.enterInput) {
               this.$refs.enterInput.resizeTextarea();
               } 
           });
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
          
          Axios.post("http://localhost:9090/api/process/updateState",JSON.stringify(this.TSRF),{
            headers:{
              'content-type': 'text/plain'}
            }).then(ret=>{
          })
          console.log(this.ruleForm);
          this.$message.success("提交成功,！");
          setTimeout(() => {this.$router.push({path: "./quality", replace:true});}, 2000);
        }
    }
    }

   </script>

   <style>
   .logo-title {
     margin-left: 40%;
   }

   .block {
     margin-left: 55%;
     margin-top: -75px;
   }

   .span .logo-title {
     width: 200px;
   }

   </style>
