<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/client' }">客户主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/ctestreportcovercheck">测试报告查看</a></el-breadcrumb-item>
      </el-breadcrumb>
      </el-col>
      <el-col :span="2">
        <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="2">
            <router-link to="/client">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" ><div class="grid-content bg-purple">
            <h1 >测试报告</h1>
            </div></el-col>
            <el-col :span="18">
          <el-steps :space="200" :active="0" finish-status="success">
          <el-step title="测试报告首页查看"></el-step>
          <el-step title="测试报告查看"></el-step>
          <el-step title="测试环境查看"></el-step>
          <el-step title="测试内容查看"></el-step>
          <el-step title="审核意见填写"></el-step>
          <el-step title="完成"></el-step>
          </el-steps>
          </el-col>
          <el-col :span="2">
            <el-button @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br>
        <el-main>
          <br>
          <el-form style="margin-top: 50px;" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item  label="软件名称:" label-width="650px" prop="SoftwareName">
              <el-input v-model="ruleForm.SoftwareName" style="width: 200px;" disabled></el-input>
            </el-form-item>
            <el-form-item label="版 本 号:" label-width="650px" prop="VersionNumber">
              <el-input v-model="ruleForm.VersionNumber" style="width: 200px;" disabled></el-input>
            </el-form-item>
            <el-form-item  label="委托单位:" label-width="650px" prop="Client">
              <el-input v-model="ruleForm.Client" style="width: 200px;" disabled></el-input>
            </el-form-item>
            <el-form-item  label="测试类别:" label-width="650px" prop="TypeTest">
              <el-input v-model="ruleForm.TypeTest" style="width: 200px;" disabled></el-input>
            </el-form-item>
            <el-form-item  label='报告日期:' label-width="650px" prop="Date">
                <el-date-picker
                v-model="ruleForm.Date"
                type="date"
                placeholder="完成时间选择"
                size=large
                  disabled />
            </el-form-item>
          </el-form>
            <h2>南京大学软件测试中心</h2>
            <p id="ContractText">声  明<br>
                1、本测试报告仅适用于本报告明确指出的委托单位的被测样品及版本。<br>
                2、本测试报告是本中心对所测样品进行科学、客观测试的结果，为被测样品提供第三方独立、客观、公正的重要判定依据，也为最终用户选择产品提供参考和帮助。<br>
                3、未经本中心书面批准，不得复制本报告中的内容（全文复制除外），以免误导他人（尤其是用户）对被测样品做出不准确的评价。<br>
                4、在任何情况下，若需引用本测试报告中的结果或数据都应保持其本来的意义，在使用时务必要保持其完整，不得擅自进行增加、修改、伪造，并应征得本中心同意。<br>
                5、本测试报告不得拷贝或复制作为广告材料使用。<br>
                6、当被测样品出现版本更新或其它任何改变时，本测试结果不再适用，涉及到的任何技术、模块（或子系统）甚至整个软件都必须按要求进行必要的备案或重新测试，更不能出现将本测试结果应用于低于被测样品版本的情况。<br>
                7、本报告无编制人员、审核人员、批准人员（授权签字人）签字无效。<br>
                8、本报告无本中心章、涂改均无效。</p>
        </el-main>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    import Axios from 'axios';
    
    export default {
        data(){
           return{
              useruid:{
                UID:"",
                },
                userpid:{
                  PID:"",
                },
                ruleForm:{
                  PID:"17",
                  SoftwareName:'',
                  VersionNumber:'',
                  Client:'',
                  TypeTest:'',
                  Date:'',
                },
                rules:{
                  SoftwareName:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  VersionNumber:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Client:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  TypeTest:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Date:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
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
    this.useruid.UID=this.$store.state.user.id;
    this.useruid.UID=29;
    Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.useruid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data[0].pid);
                this.userpid.PID=ret.data[0].pid;
              Axios.post("http://localhost:1234/reporttitle/find",JSON.stringify(this.userpid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                //console.log(ret.data)
                this.ruleForm=ret.data[0];
              })
              })
     
    
  },
      methods:{
        handleBeforeUnload() {
          sessionStorage.setItem("store",JSON.stringify(this.$store.state))
          },
        handleUnload() {
          sessionStorage.setItem("store",JSON.stringify(this.$store.state))
          },
        TestInfor(){
          //alert(JSON.stringify(this.ruleForm));
        },
        submitForm(formName) {
          this.$router.push({path: "./clientreportcheck", replace:true});
    },
      },
    
    }
    
    </script>
    <style>
    .h1 {
      margin-left: -10%;
    }
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
    
    #ContractText{
      font-size:20px;
      text-indent:1em;
    }
    </style>