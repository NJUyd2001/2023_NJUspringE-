<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
          <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/TestReportCover">测试报告声明</a></el-breadcrumb-item>
          <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/TestReportCover">
            <el-button style="margin-top: 15px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="10" style="margin-left: 35%;"><div class="grid-content bg-purple">
          <span class="logo-title">测试报告</span>
          </div></el-col>
          <el-col :span="16">
          <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="测试报告信息查看"></el-step>
          <el-step title="测试报告查看"></el-step>
          <el-step title="测试环境查看"></el-step>
          <el-step title="测试内容查看"></el-step>
          <el-step title="完成"></el-step>
          </el-steps>
          </el-col>
            <el-col :span="6" pull="3">
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span>
              </span>
              <el-dropdown  @command="switchLang">
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">En</el-dropdown-item>
                  <el-dropdown-item command="en">中</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div></el-col>
          <el-col :span="6" push="1">
            <router-link to="/TestEnvironment">
            <el-button style="margin-top: 15px;" size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <el-main>
          <br><br>
          <el-form :label-position="top" label-width="40%" style="margin-top: 10px;">
          <el-form-item label="测试类型:"> 
            <el-input style="width:200px;padding:10px" v-model="TestType"></el-input>
           </el-form-item>
          <el-form-item label="样品名称:"> 
            <el-input style="width:200px;padding:10px" v-model="SampleName"></el-input>
          </el-form-item> 
          <el-form-item label="项目编号:"> 
            <el-input style="width:200px;padding:10px" v-model="ProjectNum"></el-input>
          </el-form-item>
          <el-form-item label='来样日期:'>
              <div class="demo-date-picker">
              <div class="block">
                <el-date-picker
                style="margin-top: 60px; margin-left: -550px;"
                v-model="SampleDate"
                type="date"
                placeholder="时间选择"
                :size=large
                />
                </div>
                </div>
            </el-form-item>
          <el-form-item label="委托单位(中文):">  
                <el-input style="width:200px;padding:10px" v-model="ClientChinese"></el-input>
          </el-form-item>
          <el-form-item label="委托单位(英文):">  
            <el-input style="width:200px;padding:10px" v-model="ClientEnglish"></el-input>
          </el-form-item>
          <el-form-item label="测试单位:">  
             <el-input style="width:200px;padding:10px" v-model="DevelopmentCompany"></el-input>
          </el-form-item>
            <el-form-item label="样品状态:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="SampleStatus" type="textarea" />
            </el-form-item>
            <el-form-item label="测试依据:">
              <el-select v-model="NeededStandard" multiple allow-create filterable>
            <el-option   v-for='item in Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
            </el-form-item> 
            <el-form-item label="样品清单:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="SampleList" type="textarea" />
            </el-form-item>
            <el-form-item label="测试结论:">
              <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="TestConclusion" type="textarea" />
            </el-form-item>
            <el-form-item label="编制人:"> 
            <el-input style="width:200px;padding:10px" v-model="Organizer"></el-input>
            <el-form-item style="margin-left: -150px;" label='日期:'>
              <div class="demo-date-picker">
              <div class="block">
                <el-date-picker
                style="margin-left: -350px;"
                v-model="SampleDate"
                type="date"
                placeholder="时间选择"
                :size=large
                />
                </div>
                </div>
            </el-form-item>
            </el-form-item> 
            <el-form-item label="审核人:"> 
            <el-input style="width:200px;padding:10px" v-model="Auditor"></el-input>
            <el-form-item style="margin-left: -150px;" label='日期:'>
              <div class="demo-date-picker">
              <div class="block">
                <el-date-picker
                style="margin-left: -350px;"
                v-model="SampleDate"
                type="date"
                placeholder="时间选择"
                :size=large
                />
                </div>
                </div>
            </el-form-item>
            </el-form-item> 
            <el-form-item label="批准人:"> 
            <el-input style="width:200px;padding:10px" v-model="Approver"></el-input>
            <el-form-item style="margin-left: -150px;" label='日期:'>
              <div class="demo-date-picker">
              <div class="block">
                <el-date-picker
                style="margin-left: -350px;"
                v-model="SampleDate"
                type="date"
                placeholder="时间选择"
                :size=large
                />
                </div>
                </div>
            </el-form-item>
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
                  HardwareCategory:'',
                  HardwareName:'',
                  Setting:'',
                  Quantity:'',
                  SoftwareCategory:'',
                  SoftwareName:'',
                  Edition:'',
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
                  
                ],
                Standard:[
                    
                ],
                TechnicalIndex:[
                
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
                TestType:'',
                SampleName:'',
                ProjectNum:'',
                SampleDate:'',
                ClientChinese:'',
                ClientEnglish:'',
                DevelopmentCompany:'',
                SampleStatus:'',
                NeededStandard:'',
                SampleList:'',
                TestConclusion:'',
                Organizer:'',
                Auditor:'',
                Approver:'',
                
                SoftWareType:'',
                RuntimeEnvironment:{
                  Server:{
                    HardWare:{
                  },
                  SoftWare:{

                  },
                  },
                  NetWork:'',  
                   },
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