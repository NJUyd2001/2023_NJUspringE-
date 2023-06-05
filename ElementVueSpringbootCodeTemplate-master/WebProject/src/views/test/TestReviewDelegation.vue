<!--文炫-->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-breadcrumb separator="->">
            <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/testscheme">测试部人员审核委托</a></el-breadcrumb-item>
      </el-breadcrumb>
      <br>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/Client">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" push="4"><div class="grid-content bg-purple">
            <span class="logo-title">测试部人员审核委托</span>
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
            <el-button  @click="scrollToElement('ruleForm')" size="middle" type="warning">驳回</el-button>
            <el-button  @click="submitForm('ruleForm')" size="middle" type="success">通过</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br>
        <el-main>
          <el-form :label-position="top" disabled label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item label="测试类型:" prop="TypeTest"> 
            <el-select v-model="ruleForm.TypeTest" multiple allow-create filterable>
            <el-option   v-for='item in ruleForm.TypeOfTest' :key='item.id' :label="item.value" :value="item.value" ></el-option>
            </el-select>
           </el-form-item>
          <el-form-item label="软件名称:" prop="SoftWareName"> 
            <el-input readonly style="width:200px;padding:10px" v-model="ruleForm.SoftWareName"></el-input>
          </el-form-item> 
          <el-form-item label="版本号:" prop="VersionNumber"> 
            <el-input readonly style="width:200px;padding:10px" v-model="ruleForm.VersionNumber"></el-input>
          </el-form-item>
          <el-form-item label="委托单位(中文):" rules="{ required: true, message: '不能为空！', trigger: 'blur' }">  
                <el-input readonly style="width:200px;padding:10px" v-model="ruleForm.EntrustingCompany.Chinese"></el-input>
          </el-form-item>
          <el-form-item label="委托单位(英文):" rules="{ required: true, message: '不能为空！', trigger: 'blur' }">  
            <el-input readonly style="width:200px;padding:10px" v-model="ruleForm.EntrustingCompany.English"></el-input>
          </el-form-item>
          <el-form-item label="开发单位:" prop="DevelopmentCompany">  
             <el-input readonly style="width:200px;padding:10px" v-model="ruleForm.DevelopmentCompany"></el-input>
          </el-form-item>
          <el-form-item label="单位性质:" prop="AttributeOfCompany">   
            <el-radio-group v-model="ruleForm.AttributeOfCompany">
            <el-radio label="内资企业"></el-radio>
            <el-radio label="外(合)资企业"></el-radio>
            <el-radio label="港澳台(合)企业"></el-radio>
            <el-radio label="科研院校"></el-radio>
            <el-radio label="政府事业团体"></el-radio>
            <el-radio label="其他"></el-radio>
            </el-radio-group>
          </el-form-item > 
            <el-form-item label="软件用户对象描述:" prop="SoftwareUserObjectDescription">
              <el-input readonly style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="ruleForm.SoftwareUserObjectDescription" type="textarea" />
            </el-form-item>
            <el-form-item label="主要功能及用途简介:" prop="MainFunction">
              <el-input readonly placeholder="限200字以内" style="width:500px;" maxlength="200" show-word-limit="true" :rows="3"
              v-model="ruleForm.MainFunction" type="textarea" />
            </el-form-item>
            <el-form-item label="测试依据:" prop="NeededStandard">
              <el-select v-model="ruleForm.NeededStandard" multiple allow-create filterable>
            <el-option   v-for='item in ruleForm.Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
            </el-form-item> 
            <el-form-item label="需要测试的技术指标:" prop="NeededTechnicalIndex">
              <el-select v-model="ruleForm.NeededTechnicalIndex" multiple  allow-create filterable>
            <el-option   v-for='item in ruleForm.TechnicalIndex' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
            </el-form-item >
              <el-form-item rules="{ required: true, message: '不能为空！', trigger: 'blur' }" label="软件规模:功能数"><el-input-number  v-model="ruleForm.SoftWareSize.Number"></el-input-number></el-form-item>
              <el-form-item rules="{ required: true, message: '不能为空！', trigger: 'blur' }" label="软件规模:功能点数"><el-input-number  v-model="ruleForm.SoftWareSize.Point"></el-input-number></el-form-item>
              <el-form-item rules="{ required: true, message: '不能为空！', trigger: 'blur' }" label="软件规模:代码行数"><el-input-number  v-model="ruleForm.SoftWareSize.RowNumber"></el-input-number></el-form-item>
            <el-form-item label='软件类型:' prop="choose">
              <el-select v-model="ruleForm.SoftWareType">
                <el-option-group 
                v-for='group in ruleForm.TypeOfSoftWare'
                :key="group.label"
                :label="group.label">
                <el-option v-for="item in group.options"
                :key="item.id"
                :label="item.name"
                :value="item.name"/>
              </el-option-group>
              </el-select>
            </el-form-item>
            <el-form-item label="运行环境:" prop="common">
              <el-input readonly placeholder="客户端:Windows(版本)" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Windows"></el-input>
              <el-input readonly placeholder="客户端:Linux(版本)" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.OS.Linux"></el-input>
             <el-input readonly placeholder=" 客户端:其他" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Other"></el-input>
              <el-input readonly placeholder=" 客户端:内存要求" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.Mermory"></el-input>
              <el-input readonly placeholder=" 客户端:其他要求" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.Other"></el-input>
              <el-checkbox-group  v-model="ruleForm.RuntimeEnvironment.Server.HardWare.FrameWork">
                <el-checkbox label="服务器端架构:PC服务器"></el-checkbox>
                <el-checkbox label="服务器端架构:UNIX/Linux服务器"></el-checkbox>
                <el-checkbox label="服务器端架构:其他"></el-checkbox>
              </el-checkbox-group>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端硬件:内存要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Mermory" ></el-input>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端硬件:硬盘要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.HardDisk" ></el-input>
              <el-input readonly style="width: 300px;padding:10px;" placeholder='服务器端硬件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Other" ></el-input>
                <br>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:操作系统' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.OS" ></el-input>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:版本' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Versions" ></el-input>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:编程语言' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.PL" ></el-input>
              <el-checkbox-group placeholder='软件架构' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.FrameWork">
                <el-checkbox label="服务器端软件架构:C/S"></el-checkbox>
                <el-checkbox label="服务器端软件架构:B/S"></el-checkbox>
                <el-checkbox label="服务器端软件架构:其它"></el-checkbox>
              </el-checkbox-group>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:数据库' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.database" ></el-input>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:中间件' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.MiddleWare" ></el-input>
              <el-input readonly style="width: 200px;padding:10px;" placeholder='服务器端软件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Other" ></el-input>
              <el-input readonly style="width: 100px;padding:10px;" placeholder='服务器端:网络环境' v-model="ruleForm.RuntimeEnvironment.NetWork"></el-input>
          </el-form-item>
            <el-form-item label="样品软件介质:" prop="choose">
            <el-checkbox-group v-model="ruleForm.SampleAndQuantity.SoftwareMedium">
                <el-checkbox label="光盘"></el-checkbox>
                <el-checkbox label="U盘"></el-checkbox>
                <el-checkbox label="其他"></el-checkbox>
              </el-checkbox-group>
            </el-form-item>
            <el-form-item label="样品文档" prop="common">
              <el-input placeholder='文档资料((1、需求文档:（例如：项目计划任务书、需求分析报告、合同等）（验收、鉴定测试必须）
              2、用户文档（例如：用户手册、用户指南等）（必须）
              3、操作文档（例如：操作员手册、安装手册、诊断手册、支持手册等）（验收项目必须）))' 
              style="width:700px;" :rows="5" v-model="ruleForm.SampleAndQuantity.Document" type="textarea" readonly></el-input>
            </el-form-item>
            <el-form-item label="提交的样品（硬拷贝资料、硬件）五年保存期满:" prop="common">
              <el-radio-group v-model="ruleForm.SampleAndQuantity.SamplesSubmitted">
                <el-radio label="中心直接销毁"></el-radio>
                <el-radio label="样品退还"></el-radio>>
              </el-radio-group>
          </el-form-item>
          <el-form-item label='希望测试完成时间:' prop="common">
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
        </el-form>
        <el-form label-width="550px" disabled :model="ruleForm" :rules="rules" ref="ruleForm">
          <el-form-item label="软件名称:" prop="SoftwareName">
            <el-input readonly v-model="ruleForm.SoftwareName" style="width: 200px;"></el-input>
          </el-form-item>
          <el-form-item label="版本号:" prop="Versions">
            <el-input readonly v-model="ruleForm.Versions" style="width: 200px;"></el-input>
          </el-form-item>
          <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
          required: true,
          message: '功能项目不能为空！',
          trigger: 'blur',
        }" :label='"功能项目"+index+":"' :key="index" >
            <el-input readonly placeholder="功能项目" style="width: 100px;padding-right:20px;" v-model="Table.name"></el-input>
            <el-input readonly placeholder="功能说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.function"></el-input>
            <!-- <el-form-item v-for="(ChildTable,ChildIndex) in Table.children" :key="ChildTable.id"
            :label='"子功能项目"+ChildIndex+":"' >
            <el-input placeholder="子功能项目" style="width: 100px;padding-right:20px;" v-model="ChildTable.name"></el-input>
            <el-input placeholder="子功能说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="ChildTable.function"></el-input>
          </el-form-item> -->
            <el-button @click="removefatherItem(Table)" type="primary" size="small">删除</el-button>
          </el-form-item>
          <el-form-item> 
            <el-button @click="addfatherItem()" type="primary" size="small">增加功能项目</el-button>
          </el-form-item>
        </el-form>
        <el-form label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
          <el-form-item label="修改意见" prop="common">
            <el-input style="width:700px;" :rows="5" v-model="ruleForm.SampleAndQuantity.Document" type="textarea" ></el-input>
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
            },
            ruleForm1:{
              SoftwareName:'',
              Versions:'',
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
              TypeTest:[
              { required: true, message: "不能为空！", trigger: "change" },
            ],
            SoftWareName:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            VersionNumber:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            Chinese:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            English:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            DevelopmentCompany:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            AttributeOfCompany:[
              { required: true, message: "不能为空！", trigger: "change" },
            ],
            SoftwareUserObjectDescription:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            MainFunction:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            NeededStandard:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            NeededTechnicalIndex:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            Number:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            Point:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            RowNumber:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            }
        }
    }, 
      methods:{
        goback(){
        },
        submitForm(formName) {
          this.info("提交成功，正在返回用户界面！");
          setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
        },
        scrollToElement(formName) {
          this.info("请反馈意见写在修改意见栏");
          setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        },
        addfatherItem(){
        this.ruleForm1.TableData.push({
          id:this.ruleForm1.TableData[this.ruleForm1.TableData.length-1]+1,
          name:'',
          function:'',
          children:[],
        })
        },
        removefatherItem(Table){
          const index = this.ruleForm1.TableData.indexOf(Table)
          if (index !== -1) {
          this.ruleForm1.TableData.splice(index, 1);
      }
        },
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
    </style>