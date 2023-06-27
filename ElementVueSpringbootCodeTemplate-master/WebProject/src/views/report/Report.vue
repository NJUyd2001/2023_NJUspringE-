<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
          <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/Test">
            <el-button style="margin-top: 15px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" push="1"><div class="grid-content bg-purple">
          <span class="logo-title">测试报告</span>
          </div></el-col>
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
          <el-col :span="6" push="5">
            <router-link to="/admin">
            <el-button style="margin-top: 15px;" size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <el-main>
          <br><br>
          <el-form :label-position="top" label-width="40%" style="margin-top: 10px;">
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
          <el-form label-width="750px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
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
          <el-form label-width="750px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
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
                  edition:'',
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
                  Server:{
                    HardWare:{
                  },
                  SoftWare:{

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