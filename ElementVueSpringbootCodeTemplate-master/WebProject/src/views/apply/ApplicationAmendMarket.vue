<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页-委托修改</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/checkauditinformarket">审核意见查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/applicationamendmarket">申请表修改</a></el-breadcrumb-item>
    </el-breadcrumb>
  </el-col>
  <el-col :span="2">
    <el-button @click="Logout()" style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
  </el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/checkauditinformarket">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="8" ><div class="grid-content bg-purple">
        <span class="logo-title">申请界面-申请表</span>
      </div></el-col>
      <el-col :span="10">
        <el-steps :space="200" :active="1" finish-status="success" >
          <el-step title="审核信息查看"></el-step>
          <el-step title="申请表修改"></el-step>
          <el-step title="功能列表修改"></el-step>
          <el-step title="修改完成"></el-step>
        </el-steps>
      </el-col>
      <el-col :span="2">
        <el-button  @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main style="border-radius: 30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);">
      <br>
      <el-form label-position="middle" label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm" >
        <el-form-item label="测试类型:" prop="TypeTest"> 
        <el-select v-model="ruleForm.TypeTest" multiple allow-create filterable>
        <el-option   v-for='item in TypeOfTest' :key='item.id' :label="item.value" :value="item.value"></el-option>
        </el-select>
       </el-form-item>
      <el-form-item label="软件名称:" prop="SoftWareName" > 
        <el-input style="width:200px;padding:10px" v-model="ruleForm.SoftWareName"></el-input>
      </el-form-item> 
      <el-form-item label="版本号:" prop="VersionNumber"> 
        <el-input style="width:200px;padding:10px" 
        v-model="ruleForm.VersionNumber"></el-input>
      </el-form-item>
      <el-form-item label="委托单位(中文):" prop="ClientChinese">  
            <el-input style="width:200px;padding:10px" v-model="ruleForm.ClientChinese"></el-input>
      </el-form-item>
      <el-form-item label="委托单位(英文):" prop="ClientEnglish">  
        <el-input style="width:200px;padding:10px" v-model="ruleForm.ClientEnglish"></el-input>
      </el-form-item>
      <el-form-item label="开发单位:" prop="DevelopmentCompany">  
         <el-input style="width:200px;padding:10px" v-model="ruleForm.DevelopmentCompany"></el-input>
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
          <el-input style="width:500px;" :autosize="{ minRows: 2, maxRows: 4 }" 
          v-model="ruleForm.SoftwareUserObjectDescription" type="textarea" />
        </el-form-item>
        <el-form-item label="主要功能及用途简介:" prop="MainFunction">
          <el-input placeholder="限200字以内" style="width:500px;" maxlength="200" show-word-limit :rows="3"
          v-model="ruleForm.MainFunction" type="textarea" />
        </el-form-item>
        <el-form-item label="测试依据:" prop="NeededStandard">
          <el-select v-model="ruleForm.NeededStandard" multiple allow-create filterable>
        <el-option   v-for='item in Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
        </el-select>
        </el-form-item> 
        <el-form-item label="需要测试的技术指标:" prop="NeededTechnicalIndex">
          <el-select v-model="ruleForm.NeededTechnicalIndex" multiple  allow-create filterable>
        <el-option   v-for='item in TechnicalIndex' :key='item.id' :label="item.value" :value="item.value"></el-option>
        </el-select>
        </el-form-item >
          <el-form-item  label="软件规模:功能数"><el-input-number  v-model="ruleForm.SoftWareSize.Number"></el-input-number></el-form-item>
          <el-form-item  label="软件规模:功能点数"><el-input-number  v-model="ruleForm.SoftWareSize.Point"></el-input-number></el-form-item>
          <el-form-item  label="软件规模:代码行数"><el-input-number  v-model="ruleForm.SoftWareSize.RowNumber"></el-input-number></el-form-item>
        <el-form-item label='软件类型:' prop="SoftWareType">
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
        <el-form-item label="客户端(运行环境):" required>
      <el-row>
        <el-col :span="6">
          <el-form-item  prop="RuntimeEnvironment.Client.OS.Windows" style="margin-bottom: 10px;">
          <el-input  placeholder="操作系统:Windows(版本)" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Windows"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item prop="RuntimeEnvironment.Client.OS.Linux">
          <el-input placeholder="操作系统:Linux(版本)" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.OS.Linux"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item prop="RuntimeEnvironment.Client.OS.Other">
          <el-input placeholder=" 操作系统:其他" style="width: 200px;padding:10px;"  v-model="ruleForm.RuntimeEnvironment.Client.OS.Other"></el-input>
        </el-form-item>
      </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
        <el-form-item prop="RuntimeEnvironment.Client.Mermory">
          <el-input placeholder="内存要求" style="width: 200px;padding:10px; " v-model="ruleForm.RuntimeEnvironment.Client.Mermory"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item prop="RuntimeEnvironment.Client.Other">
          <el-input placeholder=" 其他要求" style="width: 200px;padding:10px;" v-model="ruleForm.RuntimeEnvironment.Client.Other"></el-input>
        </el-form-item>
      </el-col>
      </el-row>
      </el-form-item>
        <el-form-item label="服务器端硬件(运行环境):" required>
        <el-form-item prop="RuntimeEnvironment.Server.HardWare.FrameWork" style="margin-bottom: 20px;">
            <el-select placeholder="硬件架构" v-model="ruleForm.RuntimeEnvironment.Server.HardWare.FrameWork" multiple  allow-create filterable>
        <el-option   v-for='item in HardWareFrameWork' :key='item.id' :label="item.value" :value="item.value"></el-option>
        </el-select>
        </el-form-item>
        <el-row>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.HardWare.Mermory">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端硬件:内存要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Mermory" ></el-input>
        </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.HardWare.HardDisk">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端硬件:硬盘要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.HardDisk" ></el-input>
        </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.HardWare.Other">
          <el-input style="width: 300px;padding:10px;" placeholder='服务器端硬件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.HardWare.Other" ></el-input>
        </el-form-item>
        </el-col>
        </el-row>
        </el-form-item>
        <el-form-item label="服务器端软件(运行环境):" required>
          <el-row>
        <el-col :span="6">  
          <el-form-item prop="RuntimeEnvironment.Server.SoftWare.OS" style="margin-bottom: 10px;">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:操作系统' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.OS" ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.SoftWare.Versions">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:版本' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Versions" ></el-input>
        </el-form-item>
        </el-col> 
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.SoftWare.PL">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:编程语言' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.PL" ></el-input>
        </el-form-item> 
        </el-col> 
        </el-row>
        <el-form-item prop="RuntimeEnvironment.Server.SoftWare.FrameWork" style="margin-bottom: 10px;">
          <el-checkbox-group placeholder='软件架构' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.FrameWork">
            <el-checkbox label="服务器端软件架构:C/S"></el-checkbox>
            <el-checkbox label="服务器端软件架构:B/S"></el-checkbox>
            <el-checkbox label="服务器端软件架构:其它"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-row>
          <el-col :span="6">
            <el-form-item prop="RuntimeEnvironment.Server.SoftWare.DataBase">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:数据库' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.DataBase" ></el-input>
        </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.SoftWare.MiddleWare">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:中间件' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.MiddleWare" ></el-input>
        </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item prop="RuntimeEnvironment.Server.SoftWare.Other">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端软件:其他要求' v-model="ruleForm.RuntimeEnvironment.Server.SoftWare.Other" ></el-input>
        </el-form-item>
        </el-col>
        </el-row>
        </el-form-item>
        <el-form-item label="服务器端网络环境(运行环境)" prop="RuntimeEnvironment.NetWork">
          <el-input style="width: 200px;padding:10px;" placeholder='服务器端:网络环境' v-model="ruleForm.RuntimeEnvironment.NetWork"></el-input>
      </el-form-item>
        <el-form-item label="样品软件介质:" prop="SoftwareMedium">
          <el-select v-model="ruleForm.SoftwareMedium" multiple allow-create filterable>
        <el-option   v-for='item in SoftwareMedium' :key='item.id' :label="item.value" :value="item.value"></el-option>
        </el-select>
        </el-form-item>
        <el-form-item label="样品文档:">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadword"
              multiple
              :limit="3"
              :on-exceed="handleExceed"
              accept=".doc, .docx"
              :data="{ PID:this.process.PID }"
              :file-list="ruleForm.SamplesSubmitted">
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>注：1、需求文档（例如：项目计划任务书、需求分析报告、合同等）（验收、鉴定测试必须）<br>
                                              2、用户文档（例如：用户手册、用户指南等）(必须)<br>
                                              3、操作文档（例如：操作员手册、安装手册、诊断手册、支持手册等）（验收项目必须）
                                            </strong></div>
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
            <el-date-picker
            v-model="ruleForm.WantedFinishTime"
            type="date"
            placeholder="完成时间选择"
            size=large
              />
            </div>
        </el-form-item>
        <el-form-item  label="申请人签字上传：">
                      <el-upload
                          class="upload-demo"
                          drag
                          action="http://localhost:9090/api/file/upload"
                          multiple
                          :before-upload="beforeUploadjpg"
                          :data="{ PID:this.process.PID }">
                          <i class="el-icon-upload"></i>
                          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过2Mb</div>
                      </el-upload>
                </el-form-item>
    </el-form>
    </el-main>
  <template>
  <el-backtop :right="50" :bottom="50" />
</template>
</el-container>
</template>
<script>
import Axios from 'axios'
export default {
    data(){
       return{
        percentage:0,
        user:{
                name:this.$store.state.user.name,
            },
        process:{
          PID:this.$store.state.user.process.PID,
        },
        userid:{
          applicantID:this.$store.state.user.id,
        },
        ruleForm:{},
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
        
        rules:{
          TypeTest:[
          { required: true, message: "请至少选择一个测试类型", trigger: "change" },
        ],
        SoftWareName:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        VersionNumber:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        ClientChinese:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        ClientEnglish:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        DevelopmentCompany:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        AttributeOfCompany:[
          { required: true, message: "请至少选择一种性质！", trigger: "change" },
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
        'RuntimeEnvironment.Client.OS.Windows':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Client.OS.Linux':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Client.OS.Other':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Client.Mermory':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Client.Other':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.HardWare.FrameWork':[
          { required: true, message: "请至少选择或给出一种架构！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.HardWare.Mermory':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.HardWare.HardDisk':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.HardWare.Other':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.OS':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.Versions':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.PL':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.FrameWork':[
          { required: true, message: "请至少选择一个软件架构！", trigger: "change" },
        ],
        'RuntimeEnvironment.Server.SoftWare.DataBase':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.MiddleWare':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.Server.SoftWare.Other':[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        'RuntimeEnvironment.NetWork':[
        { required: true, message: "不能为空！", trigger: "blur" },
        ],
        SoftWareType:[
          { required: true, message: "不能为空！", trigger: "blur" },
        ],
        SoftwareMedium:[
          { required: true, message: "请至少选择一个软件介质！", trigger: "change" },
        ],
        SamplesSubmitted:[
          { required: true, message: "请选择一个方案！", trigger: "change" },
        ],
        WantedFinishTime:[
          { required: true, message: "请选择日期！", trigger: "change" },
        ],
        }
    }
},
mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload);
  window.addEventListener('unload', this.handleUnload);
},
created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.userid.applicantID=this.$store.state.user.id;
    // this.ruleForm.applicantID=this.$store.state.user.id;
    //console.log(this.$store.state.user.id)
    Axios.post("http://localhost:9090/api/application/checkbyapplicant",JSON.stringify(this.userid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.ruleForm=ret.data[0];
        this.$store.state.user.process.AID=ret.data[0].AID;
        console.log(this.ruleForm)
      })
  },
  methods:{
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
        //console.log(this.ruleForm)
        Axios.post("http://localhost:9090/api/application/updateapplication",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          this.$message.success("提交成功！");
          setTimeout(() => {this.$router.push({path: "./functionlistamendmarket", replace:true});}, 2000);
      }).catch(function (error)
        {
          console.log(error);
        }
      )
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    Logout(){
          this.$store.state.user.id=-1;
          this.$store.state.user.name="null";
          this.$store.state.user.password=-1;
          this.$store.state.user.Permissions="null";
      this.$router.push({path: "./home", replace:true});
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
    beforeUploadword(file) {
        const isWord1 = file.type === 'application/msword';
        const isWord2 = file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
        const isPDF = file.type === 'application/pdf';
        // const isLt2M = file.size / 1024 / 1024 < 2;
        console.log(file.type)
        if (!isWord1 && !isWord2 && !isPDF) {
          this.$message.error('上传文件只能是 Word/PDF 格式!');
        }
        // if (!isLt2M) {
        //   this.$message.error('上传头像图片大小不能超过 2MB!');
        // }
        return isWord1 || isWord2 || isPDF;
      },
    beforeUploadjpg(file) {
        const isJPG = file.type === 'image/jpeg';
        const isPNG = file.type === 'image/png';
        const isLt2M = file.size / 1024 / 1024 < 2;
        console.log(file.type)
        if (!isJPG && !isPNG) {
          this.$message.error('上传头像图片只能是 jpg/png 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG || isPNG;
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
  margin: auto;
  
}
.demo-date-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}
</style>