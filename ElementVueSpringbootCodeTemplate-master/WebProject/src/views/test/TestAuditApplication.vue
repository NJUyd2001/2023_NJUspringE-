<template>
  <el-container style="height:100%">
    <el-header style="height: 30px " >
      <el-row>
        <el-col :span="23">
      <el-breadcrumb separator="->">
      <el-breadcrumb-item :to="{ path: '/test' }">测试部主页-审核委托</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/testaudituser' }">客户信息查看</el-breadcrumb-item>
      <el-breadcrumb-item><a href="">申请表查看</a></el-breadcrumb-item>
    </el-breadcrumb>
  </el-col>
  <el-col :span="1">
    <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
      </el-row>
      <el-row  type="flex" justify="center" align="middle">
        <el-col :span="6">
          <router-link to="/testaudituser">
          <el-button  size="middle" type="danger">上一步</el-button>
          </router-link>
        </el-col>
        <el-col :span="6" ><div class="grid-content bg-purple">
          <span class="logo-title">申请表查看</span> 
        </div></el-col>
        <el-col :span="14">
        <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="客户信息查看"></el-step>
          <el-step title="申请表查看"></el-step>
          <el-step title="功能列表查看"></el-step>
          <el-step title="审核意见查看"></el-step>
          <el-step title="审核信息填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
        <el-col :span="2">
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
            <el-input placeholder="限200字以内" style="width:500px;" maxlength="200" show-word-limit :rows="3"
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
  import Axios from 'axios'
  export default {
      data(){
         return{
          percentage:0,
          Aid:{
            applicantID:"",
          },
          Pid:{
            PID:"",
          },
          tempForm:{},
          ruleForm:{
              TypeTest:{},
              SoftWareName:'',
              ClientChinese:'',
              ClientEnglish:'',
              DevelopmentCompany:'',
              AttributeOfCompany:{},
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
                    Other:''
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

          }
        }
  },
  created(){
      // console.log(this.$store.state.user.id)
      this.KeepInfor();
      this.Aid.applicantID=this.$store.state.user.process.UID
      this.Pid.PID=this.$store.state.user.process.UID
      Axios.post("http://localhost:9090/api/process/findByPID",JSON.stringify(this.Pid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          //console.log(ret.data)
          this.Fid.FID1=ret.data.fileIDs;
      }).catch(function (error)
        {
          console.log(error);
        }
      )
      Axios.post("http://localhost:9090/api/application/checkbyapplicant",JSON.stringify(this.Aid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          this.ruleForm=ret.data[0];
          //this.$store.state.user.process.AID=ret.data[0].AID;
          console.log(this.$store.state.user.process.AID)
      }).catch(function (error)
        {
          console.log(error);
        }
      )
    },
    methods:{
      download1(){
        var formdata=new FormData()
        formdata.append('FID' ,'23')
        //formdata.append('FID' ,this.Fid.FID1)
        //console.log(formdata.get('FID'))
        Axios.post("http://localhost:9090/api/file/download",formdata,{
        headers:{
          'content-type': 'multipart/form-data;boundary = ' + new Date().getTime()
        },
        responseType:'blob'
      }).then(ret=>{
        let data = ret.data
      if (!data) {
            return
       }
       let url = window.URL.createObjectURL(new Blob([data]))
      console.log(ret.headers['content-disposition'])
      let str = typeof ret.headers['content-disposition'] === 'undefined'
                  ? ret.headers['Content-Disposition'].split(';')[1]
                  : ret.headers['content-disposition'].split(';')[1]
      
      let filename = typeof str.split('fileName=')[1] === 'undefined'
                      ? str.split('filename=')[1]
                      : str.split('fileName=')[1]
       let a = document.createElement('a')
       a.style.display = 'none'
       a.href = url
       console.log(ret)
       a.setAttribute('download',decodeURIComponent(filename))
       document.body.appendChild(a)
       a.click() //执行下载
       window.URL.revokeObjectURL(a.href)
       document.body.removeChild(a)
      })
      },
      download2(){
        var formdata=new FormData()
        
        formdata.append('FID' ,this.Fid.FID4)
        //console.log(formdata.get('FID'))
        Axios.post("http://localhost:9090/api/file/download",formdata,{
        headers:{
          'content-type': 'multipart/form-data;boundary = ' + new Date().getTime()
        },
        responseType:'blob'
      }).then(ret=>{
        let data = ret.data
      if (!data) {
            return
       }
       let url = window.URL.createObjectURL(new Blob([data]))
      console.log(ret.headers['content-disposition'])
      let str = typeof ret.headers['content-disposition'] === 'undefined'
                  ? ret.headers['Content-Disposition'].split(';')[1]
                  : ret.headers['content-disposition'].split(';')[1]
      
      let filename = typeof str.split('fileName=')[1] === 'undefined'
                      ? str.split('filename=')[1]
                      : str.split('fileName=')[1]
       let a = document.createElement('a')
       a.style.display = 'none'
       a.href = url
       console.log(ret)
       a.setAttribute('download',decodeURIComponent(filename))
       document.body.appendChild(a)
       a.click() //执行下载
       window.URL.revokeObjectURL(a.href)
       document.body.removeChild(a)
      })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push({path: "./testauditfunctionlist", replace:true});
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