<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-breadcrumb separator="->">
          <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
        </el-breadcrumb>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/admin">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" push="4"><div class="grid-content bg-purple">
            <span class="logo-title">测试报告</span>
            </div></el-col>
            <el-col :span="6" pull="3">
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span><el-button  plain size="middle"  type="danger" @click="logout">退出</el-button>
              </span>
              <span v-else><el-button type="success" plain size="middle" style = "margin:10px" @click="loginOut">登出</el-button></span>
              <el-dropdown  @command="switchLang">
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">En</el-dropdown-item>
                  <el-dropdown-item command="en">中</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div></el-col>
          <el-col :span="6" push="4">
            <router-link to="/admin">
            <el-button  size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <el-main>
          <br><br>
          <el-form :label-position="top" label-width="40%">
            <el-form-item label="测试类型:"> 
            <el-select v-model="TypeTest" multiple allow-create filterable>
            <el-option   v-for='item in TypeOfTest' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
           </el-form-item>
          <el-form-item label="样品名称:"> 
            <el-input style="width:200px;padding:10px" v-model="SoftWareName"></el-input>
          </el-form-item> 
          <el-form-item label="项目编号:"> 
            <el-input style="width:200px;padding:10px" v-model="VersionNumber"></el-input>
          </el-form-item>
          <el-form-item label='来样日期:'>
              <div class="demo-date-picker">
              <div class="block">
                <el-date-picker
                v-model="SampleDate"
                type="date"
                placeholder="完成时间选择"
                :size=large
                  />
                </div>
                </div>
            </el-form-item>
          <el-form-item label="委托单位(中文):">  
                <el-input style="width:200px;padding:10px" v-model="EntrustingCompany.Chinese"></el-input>
          </el-form-item>
          <el-form-item label="委托单位(英文):">  
            <el-input style="width:200px;padding:10px" v-model="EntrustingCompany.English"></el-input>
          </el-form-item>
          <el-form-item label="测试单位:">  
             <el-input style="width:200px;padding:10px" v-model="DevelopmentCompany"></el-input>
          </el-form-item>
            <el-form-item label="样品状态:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="SoftwareUserObjectDescription" type="textarea" />
            </el-form-item>
            <el-form-item label="测试依据:">
              <el-select v-model="NeededStandard" multiple allow-create filterable>
            <el-option   v-for='item in Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
            </el-form-item> 
            <el-form-item label="样品清单:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="SoftwareUserObjectDescription" type="textarea" />
            </el-form-item>
            <el-form-item label="测试结论:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="SoftwareUserObjectDescription" type="textarea" />
            </el-form-item>
          <el-form-item label="编制人:"> 
            <el-input style="width:200px;padding:10px" v-model="Organizer"></el-input>
          </el-form-item> 
          <el-form-item label="审核人:"> 
            <el-input style="width:200px;padding:10px" v-model="Auditor"></el-input>
          </el-form-item> 
          <el-form-item label="批准人:"> 
            <el-input style="width:200px;padding:10px" v-model="Approver"></el-input>
          </el-form-item>  
          <el-form-item label="测试环境" prop="Introduction" style="font-weight: bold; font-size: 15px;">
            </el-form-item>  
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"硬件环境"' :key="index" >
              <el-input placeholder="硬件类别" style="width: 100px;padding-right:20px;" v-model="Table.hardwarecategory"></el-input>
              <el-input placeholder="硬件名称" style="width: 100px;padding-right:20px;" v-model="Table.hardwarename"></el-input>
              <el-input placeholder="配置" style="width: 100px;padding-right:20px;" v-model="Table.setting"></el-input>
              <el-input placeholder="数量" style="width: 100px;padding-right:20px;" v-model="Table.quantity"></el-input>
          </el-form-item> 
          </el-form>
          <el-form label-width="400px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"软件环境"' :key="index" >
              <el-input placeholder="软件类别" style="width: 100px;padding-right:20px;" v-model="Table.softwarecategory"></el-input>
              <el-input placeholder="软件名称" style="width: 100px;padding-right:20px;" v-model="Table.softwarename"></el-input>
              <el-input placeholder="版本" style="width: 100px;padding-right:20px;" v-model="Table.edition"></el-input>
          </el-form-item> 
          </el-form>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>
    <script>
    export default {
        data(){
           return{
                ruleForm1:{
                  hardwarecategory:'',
                  hardwarename:'',
                  setting:'',
                  quantity:'',
                  softwarecategory:'',
                  softwarename:'',
                  category:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                },
                reports:[
		               {FunctionalModule: '无', 
                    FunctionalRequirement: '无', 
                    TestResult:'无'}
		            ],
                    FunctionalModule: '',
                    FunctionalRequirement: '',
                    TestResult: '',
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
                shortcuts:[
                          {
                            text: 'Today',
                            value: new Date(),
                          },
                          {
                            text: 'Yesterday',
                            value: () => {
                              const date = new Date()
                              date.setTime(date.getTime() - 3600 * 1000 * 24)
                              return date
                            },
                          },
                          {
                            text: 'A week ago',
                            value: () => {
                              const date = new Date()
                              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
                              return date
                            },
                          },
                          ],
                TypeTest:[],
                SoftWareName:'',
                VersionNumber:'',
                EntrustingCompany:{
                  Chinese:'',
                  English:'',
                },
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
                SampleAndQuantity:{
                SoftwareMedium:[],
                Document:'',
                SamplesSubmitted:'',
                },
                WantedFinishTime:'',
                SampleDate:'',
                Organizer:'',
                Auditor:'',
                Approver:'',
        }
    }, 
      methods:{
        goback(){
        },
        addData(){
			this.reports.push({
				'FunctionalModule' : this.FunctionalModule,
        'FunctionalRequirement' : this.FunctionalRequirement,
        'TestResult' : this.TestResult,
        });
        this.FunctionalModule = '',
        this.FunctionalRequirement = '';
        this.TestResult = '';
      },
        remove(obj){
          var tr = $j(obj).parent ().parent()
          tr.prev().remove();
          tr.prev().remove();
          tr.remove();
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
    .el-input{
        padding:15px,
        
    }
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    .logo-title{
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

    .box {
      background-color: whitesmoke;
      padding: 20px;
      margin: 40px;
    }

    h3 {
      text-align: center;
      text-transform: uppercase;
      font-weight: bold;
    }

    .form-wrap {
      margin: 20px 0;
    }

    .table {
      border: 1px solid;
      width: 100%;
    }

    .th, td {
      border: 1px solid;
    }
    </style>