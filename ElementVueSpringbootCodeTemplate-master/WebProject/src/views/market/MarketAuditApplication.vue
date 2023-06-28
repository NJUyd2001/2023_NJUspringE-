<template>
  <el-container style="height:100%">
    <el-header style="height: 30px " @back="goback">
      <el-row>
        <el-col :span="23">
      <el-breadcrumb separator="->">
      <el-breadcrumb-item :to="{ path: '/market' }">市场部主页-审核委托</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/marketaudituser' }">客户信息查看</el-breadcrumb-item>
      <el-breadcrumb-item><a href="">申请表查看</a></el-breadcrumb-item>
    </el-breadcrumb>
  </el-col>
  <el-col :span="1">
    <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
      </el-row>
      <el-row  type="flex" justify="center" align="middle">
        <el-col :span="9">
          <router-link to="/marketaudituser">
          <el-button  size="middle" type="danger">上一步</el-button>
          </router-link>
        </el-col>
        <el-col :span="3" ><div class="grid-content bg-purple">
          <span class="logo-title">申请表查看</span> 
        </div></el-col>
        <el-col :span="10">
        <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="客户信息查看"></el-step>
          <el-step title="申请表查看"></el-step>
          <el-step title="功能列表查看"></el-step>
          <el-step title="审核意见填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
        <el-col :span="1">
          <el-button  @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
        </el-col>
      </el-row>
    </el-header>
      <br><br><br>
      <el-main>
        <br>
        <el-form disabled :label-position="top" label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
          <el-form-item label="测试类型:"> 
          <el-select v-model="ruleForm.TypeTest" multiple allow-create filterable>
          <el-option   v-for='item in TypeOfTest' :key='item.id' :label="item.value" :value="item.value"></el-option>
          </el-select>
         </el-form-item>
        <el-form-item label="软件名称:"  > 
          <el-input style="width:200px;padding:10px" v-model="ruleForm.SoftWareName"></el-input>
        </el-form-item> 
        <el-form-item label="版本号:" > 
          <el-input style="width:200px;padding:10px" @change="" 
          v-model="ruleForm.VersionNumber"></el-input>
        </el-form-item>
        <el-form-item label="委托单位(中文):" >  
              <el-input style="width:200px;padding:10px" v-model="ruleForm.ClientChinese"></el-input>
        </el-form-item>
        <el-form-item label="委托单位(英文):" >  
          <el-input style="width:200px;padding:10px" v-model="ruleForm.ClientEnglish"></el-input>
        </el-form-item>
        <el-form-item label="开发单位:" >  
           <el-input style="width:200px;padding:10px" v-model="ruleForm.DevelopmentCompany"></el-input>
        </el-form-item>
        <el-form-item label="单位性质:" >   
          <el-radio-group v-model="ruleForm.AttributeOfCompany">
          <el-radio label="内资企业"></el-radio>
          <el-radio label="外(合)资企业"></el-radio>
          <el-radio label="港澳台(合)企业"></el-radio>
          <el-radio label="科研院校"></el-radio>
          <el-radio label="政府事业团体"></el-radio>
          <el-radio label="其他"></el-radio>
          </el-radio-group>
        </el-form-item > 
          <el-form-item label="软件用户对象描述:" >
            <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
            v-model="ruleForm.SoftwareUserObjectDescription" type="textarea" />
          </el-form-item>
          <el-form-item label="主要功能及用途简介:" >
            <el-input placeholder="限200字以内" style="width:500px;" maxlength="200" show-word-limit="true" :rows="3"
            v-model="ruleForm.MainFunction" type="textarea" />
          </el-form-item>
          <el-form-item label="测试依据:" >
            <el-select v-model="ruleForm.NeededStandard" multiple allow-create filterable>
          <el-option   v-for='item in Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
          </el-select>
          </el-form-item> 
          <el-form-item label="需要测试的技术指标:">
            <el-select v-model="ruleForm.NeededTechnicalIndex" multiple  allow-create filterable>
          <el-option   v-for='item in TechnicalIndex' :key='item.id' :label="item.value" :value="item.value"></el-option>
          </el-select>
          </el-form-item >
            <el-form-item prop="Number" label="软件规模:功能数"><el-input-number  v-model="ruleForm.SoftWareSize.Number"></el-input-number></el-form-item>
            <el-form-item prop="Point" label="软件规模:功能点数"><el-input-number  v-model="ruleForm.SoftWareSize.Point"></el-input-number></el-form-item>
            <el-form-item prop="RowNumber" label="软件规模:代码行数"><el-input-number  v-model="ruleForm.SoftWareSize.RowNumber"></el-input-number></el-form-item>
          <el-form-item label='软件类型:'>
            <el-select v-model="ruleForm.SoftWareType">
              <el-option-group 
              v-for='group in TypeOfSoftWare'
              :key="group.label"
              :label="group.label">
              <el-option v-for="item in group.options"
              :key="item.id"
              :label="item.name"
              :value="item.name"/>
            </el-option-group>
            </el-select>
          </el-form-item>
          <el-form-item label="客户端(运行环境):">
            <el-input prop="Windows" placeholder="操作系统:Windows(版本)" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Windows"></el-input>
            <el-input placeholder="操作系统:Linux(版本)" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.OS.Linux"></el-input>
           <el-input placeholder=" 操作系统:其他" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Other"></el-input>
            <el-input placeholder="内存要求" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.Mermory"></el-input>
            <el-input placeholder=" 其他要求" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.Other"></el-input>
            </el-form-item>
            <el-form-item label="服务器端硬件(运行环境):">
              <el-select v-model="ruleForm.RuntimeEnvironment.Server.HardWare.FrameWork" multiple  allow-create filterable>
          <el-option   v-for='item in HardWareFrameWork' :key='item.id' :label="item.value" :value="item.value"></el-option>
          </el-select>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端硬件:内存要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Mermory" ></el-input>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端硬件:硬盘要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.HardDisk" ></el-input>
            <el-input style="width: 300px;padding:10px;" placeholder='服务器端硬件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Other" ></el-input>
          </el-form-item>
          <el-form-item label="服务器端软件(运行环境):">
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:操作系统' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.OS" ></el-input>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:版本' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Versions" ></el-input>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:编程语言' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.PL" ></el-input>
            <el-checkbox-group placeholder='软件架构' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.FrameWork">
              <el-checkbox label="服务器端软件架构:C/S"></el-checkbox>
              <el-checkbox label="服务器端软件架构:B/S"></el-checkbox>
              <el-checkbox label="服务器端软件架构:其它"></el-checkbox>
            </el-checkbox-group>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:数据库' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.database" ></el-input>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:中间件' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.MiddleWare" ></el-input>
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Other" ></el-input>
          </el-form-item>
          <el-form-item label="服务器端网络环境(运行环境)">
            <el-input style="width: 200px;padding:10px;" placeholder='服务器端:网络环境' v-model="ruleForm.RuntimeEnvironment.NetWork"></el-input>
        </el-form-item>
          <el-form-item label="样品软件介质:" >
            <el-select v-model="ruleForm.SoftwareMedium" multiple allow-create filterable>
          <el-option   v-for='item in SoftwareMedium' :key='item.id' :label="item.value" :value="item.value"></el-option>
          </el-select>
          </el-form-item>
          <el-form-item label="样品文档:">
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                multiple
                :limit="3"
                :on-exceed="handleExceed"
                :file-list="ruleForm.SamplesSubmitted">
    <el-button size="small" type="primary">点击下载</el-button>
    <div slot="tip" class="el-upload__tip">注：1、需求文档（例如：项目计划任务书、需求分析报告、合同等）（验收、鉴定测试必须）<br>
                                                2、用户文档（例如：用户手册、用户指南等）（必须）<br>
                                                3、操作文档（例如：操作员手册、安装手册、诊断手册、支持手册等）（验收项目必须）
                                              </div>
              </el-upload>
          </el-form-item>
          <el-form-item label="提交的样品（硬拷贝资料、硬件）五年保存期满:" prop="SamplesSubmitted">
            <el-radio-group v-model="ruleForm.SamplesSubmitted">
              <el-radio label="中心直接销毁"></el-radio>
              <el-radio label="样品退还"></el-radio>>
            </el-radio-group>
        </el-form-item>
        <el-form-item label='希望测试完成时间:' prop="WantedFinishTime">
            <div class="demo-date-picker">
            <div class="block">
              <el-date-picker
              v-model="ruleForm.WantedFinishTime"
              type="date"
              placeholder="完成时间选择"
              :size=large
                />
              </div>
              </div>
          </el-form-item>
          <el-form-item  label="申请人签字下载：">
                        <el-upload
                            class="upload-demo"
                            drag
                            action="https://jsonplaceholder.typicode.com/posts/"
                            multiple>
                            <i class="el-icon-upload"></i>
                            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
                        </el-upload>
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
          percentage:0,
          ruleForm:{
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
              TypeTest:[],
              SoftWareName:'',
              ClientChinese:'',
              ClientEnglish:'',
              DevelopmentCompany:'',
              AttributeOfCompany:[],
              SoftwareUserObjectDescription:'',
              MainFunction:'',
              NeededStandard:[],
              NeededTechnicalIndex:[],
              SoftWareSize:{
                Number:0,
                Point:0,
                RowNumber:0,
              },
              SoftWareType:'',
              RuntimeEnvironment:{
                  Client:{
                  OS:{
                    Windows:'',
                    Linux:'',
                    other:''
                },
                Mermory:'',
                Other:''
                },
                Server:{
                  HardWare:{
                  FrameWork:[],  
                  Mermory:'',
                  HardDisk:'',
                  OtherDisk:''
                },
                SoftWare:{
                  OS:'',
                  Versions:'',
                  PL:'',
                  FrameWork:[],
                  DataBase:'',
                  MiddleWare:'',
                  Other:''
                },
                },
                NetWork:'',  
                 },
              SoftwareMedium:[],
              Document:'',
              SamplesSubmitted:[],
              WantedFinishTime:'',
          },
          TypeOfTest:[
                {
                  id:1,
                  value:'软件确认测试',
                },
                {
                  id:2,
                  value:'成果/技术鉴定测试',
                },
                {
                  id:3,
                  value:'专项资金验收测试',
                },
              ],
          Standard:[
                  {
                    id:1,
                    value:'GB/T 25000.51-2016',
                  },
                  {
                    id:2,
                    value:'GB/T 25000.10-2016',
                  },
                  {
                    id:3,
                    value:'GB/T 28452-2012',
                  },
                  {
                    id:4,
                    value:'GB/T 30961-2014',
                  },
                  {
                    id:5,
                    value:'NST-03-WI12-2011',
                  },
                  {
                    id:6,
                    value:'NST-03-WI13-2011',
                  },
                  {
                    id:7,
                    value:'NST-03-WI22-2014',
                  }
              ],
          TechnicalIndex:[{
                    id:1,
                    value:'功能性',
                  },
                  {
                    id:2,
                    value:'可靠性',
                  },
                  {
                    id:3,
                    value:'易用性',
                  },
                  {
                    id:4,
                    value:'效率',
                  },
                  {
                    id:5,
                    value:'可维护性',
                  },
                  {
                    id:6,
                    value:'可移植性',
                  },
                  {
                    id:7,
                    value:'代码覆盖度',
                  },
                  {
                    id:8,
                    value:'缺陷检测率',
                  },
                  {
                    id:9,
                    value:'代码风格符合度',
                  },
                  {
                    id:10,
                    value:'代码不符合项检测率',
                  },
                  {
                    id:11,
                    value:'产品说明要求',
                  },
                  {
                    id:12,
                    value:'用户文档集要求',
                  },
                  {
                    id:13,
                    value:'可移植性',
                  },
                  {
                    id:14,
                    value:'代码覆盖度',
                  }],
          TypeOfSoftWare:[
      {
        label:'系统软件',
        options:[{
                                      name:'操纵系统',
                                      id:1,
                                    },
                                    {
                                      name:'中文处理系统',
                                      id:2,
                                    },
                                    {
                                      name:'网络系统',
                                      id:3,
                                    },
                                    {
                                      name:'嵌入式操作系统',
                                      id:4,
                                    },
                                    {
                                      name:'其他(系统软件)',
                                      id:5,
                                    }],
                                    },
                                    {
                                      label:'支持软件',
                                      options:[{            
                                    name:'程序设计语言',
                                      id:6,
                                    },
                                    {
                                      name:'数据库系统设计',
                                      id:7,
                                    },
                                    {
                                      name:'工具软件',
                                      id:8,
                                    },
                                    {
                                      name:'网络通信软件',
                                      id:9,
                                    },
                                    {
                                      name:'中间件',
                                      id:10,
                                    },
                                    {
                                      name:'其他(支持软件)',
                                      id:11,
                                    }
                                    ],
                                    },
                                    {
                                      label:'应用软件',
                                      options:[
                                    {            
                                      name:'行业管理软件',
                                      id:12,
                                    },
                                    {
                                      name:'办公软件',
                                      id:13,
                                    },
                                    {
                                      name:'模式识别软件',
                                      id:14,
                                    },
                                    {
                                      name:'图形图像软件',
                                      id:15,
                                    },
                                    {
                                      name:'控制软件',
                                      id:16,
                                    },
                                    {            
                                      name:'网络应用软件',
                                      id:17,
                                    },
                                    {
                                      name:'信息管理软件',
                                      id:18,
                                    },
                                    {
                                      name:'数据库管理应用软件',
                                      id:19,
                                    },
                                    {
                                      name:'安全与保密软件',
                                      id:20,
                                    },
                                    {
                                      name:'嵌入式应用软件',
                                      id:21,
                                    },
                                    {
                                      name:'教育软件',
                                      id:22,
                                    },
                                    {
                                      name:'游戏软件',
                                      id:23,
                                    },
                                    {
                                      name:'其他(应用软件)',
                                      id:24,
                                    }
                                  ],
                                    },
                                    {
                                      label:'其他',
                                      options:[
                                      {
                                      name:'其他',
                                      id:25,
                                      }
                                      ]
                                    },
                    ],
          HardWareFrameWork:[
                  {
                    id:1,
                    value:'PC服务器',
                  },
                  {
                    id:2,
                    value:'UNIX/Linux服务器',
                  }
          ],
          SoftwareMedium:[
                  {
                    id:1,
                    value:'光盘',
                  },
                  {
                    id:2,
                    value:'U盘',
                  }
          ],

      }
  }, 
    methods:{
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push({path: "./marketauditfunctionlist", replace:true});
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      increasePer(format){
        if(format!==""&&format!==[])
          { 
            this.percentage=50;
          }
        else  {
          this.percentage-=2.8;
            if(this.percentage<=0)
            this.percentage=0;
        }
      },
      handleRemove(file, fileList) {
          console.log(file, fileList);
      },
      handlePreview(file) {
          console.log(file);
        },
      handleExceed(files, fileList) {
          this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
      beforeRemove(file, fileList) {
          return this.$confirm(`确定移除 ${ file.name }？`);
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
  .el-main{
    border-radius: 30px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
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
    font-size: 20px;
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