<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " >
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/client' }">用户主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/client/ConfidentialityAgreement">软件项目委托测试保密协议</a></el-breadcrumb-item>
      </el-breadcrumb>
      </el-col>
        <el-col :span="2">
        <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/client">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="10" ><div class="grid-content bg-purple">
            <h1 style="margin-left: 30%;">软件项目委托测试保密协议</h1>
            </div></el-col>
            <el-col :span="10">
        <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="合同草稿审核"></el-step>
          <el-step title="保密协议填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
      </el-col>  
          <el-col :span="2">
            <el-button style="margin-top: -25px; margin-left: 70px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br>
        <el-main>
          <br>
          <h1 style="margin-top: 40px; margin-left: 5%;">保密内容:</h1>
          <p id="ContractText" style="margin-left: 5%;">委托方<strong>{{ruleForm.Client}}</strong>（以下简称“甲方”）与<strong>{{ruleForm.Trustee}}</strong>(以下简称“乙方”)在签订《<input v-model="ruleForm.Name" style="width: 50px;padding:10px;margin-left:10px;">
            软件项目委托测试》委托合同的前提下，为保证双方的合法权利，经协双方达成如下保密协议：</p>
            <p id="ContractText" style="margin-top: 70px; margin-left: 5%;"><br>
                1、甲方 不得向第三方透露在合作期间获得和知晓的乙方（包括其分支机构）的商业秘密和其他有关的保密信息。商业秘密包括技术秘密和经营秘密，其中技术秘密包括计算机软件、数据库、技术报告、测试报告、检测报告、实验数据、测试结果、操作手册、技术文档、相关的函电等。经营秘密包括但不限于双方洽谈的情况、签署的任何文件，包括合同、协议、备忘录等文件中所包含的一切信息、定价政策、设备资源、人力资源信息等。<br>
                2、乙方负有对甲方委托测试的软件保密的责任，保密内容包括：软件产品代码、软件可执行程序、测试报告、测试结果、操作手册、技术文档、用户手册等。<br>
                3、未经对方书面同意，任何一方不得在双方合作目的之外使用或向第三方透露对方的任何商业秘密，不管这些商业秘密是口头的或是书面的，还是以磁盘、胶片或电子邮件等形式存在的。<br>
                4、在对方公司内活动时，应尊重对方有关保密的管理规定，听从接待人员的安排和引导。未经允许不得进入对方中心、办公室内受控的工作环境，与对方技术人员进行的交流，仅限于合作项目有关的内容。 <br>
                5、如果一方违反上述条款，另一方有权根据违反的程度以及造成的损害采取以下措施： <br>
                （1）终止双方的合作；<br>
                （2）要求赔偿因失密造成的损失。<br>
                在采取上述措施之前，一方将给予违约的另一方合理的在先通知。 <br>
                6、负有保密义务的双方，如果涉密人因本方无法控制的原因(如擅自离职)造成由涉密人有意泄密，其相应的民事和法律责任由当事人承担。<br>
                7、与本协议有关的任何争议，双方应通过友好协商解决。如协商不成，任何一方可将此争议提交南京市仲裁委员会进行仲裁。仲裁裁决是终局的，对双方均有约束力。<br>
                8、本协议作为委托测试合同的附件，一式两份，双方各执一份，与合同具有同等法律效力。<br>
                 本协议自双方授权代表签字盖章之日起生效，但有效期不限于合同有效期。</p>
          <br>
          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" >
              <el-form-item style="font-weight: bold;" label="甲方 :" label-width="400px" prop="Client"> 
            <el-input v-model="ruleForm.Client" style="width: 200px;" ></el-input>
            <el-form-item label="乙方 :" label-width="550px" style="margin-top: -40px;" >
              <el-input v-model="ruleForm.Trustee" style="width: 200px;" disabled></el-input>
            </el-form-item>
            </el-form-item>
            <el-form-item  style="font-weight: bold;" label="法人代表：" label-width="400px" prop="LegalRepresentative1">
              <el-input v-model="ruleForm.LegalRepresentative1" style="width: 200px;"></el-input>
            <el-form-item  label="法人代表：" label-width="550px" style="margin-top: -40px;" >
              <el-input v-model="ruleForm.LegalRepresentative2" style="width: 200px;" disabled></el-input>
            </el-form-item>
            </el-form-item>
            <el-row >
            <el-col :span="6">
            <el-form-item label="日期 :" style="font-weight: bold;" label-width="400px" prop="Date1">
                <el-date-picker
                v-model="ruleForm.Date1"
                type="date"
                placeholder="Pick a day">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="日期 :" style="font-weight: bold;" label-width="550px">
                <el-date-picker
                v-model="ruleForm.Date2"
                type="date"
                placeholder="Pick a day" disabled>
            </el-date-picker>
          </el-form-item>
        </el-col>
        </el-row>
          </el-form>
        </el-main>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    import Axios from 'axios';
    
    export default {
    data(){
           return{
                ruleForm:{
                    Client:'',
                    Trustee:'南京大学软件测试中心',
                    LegalRepresentative1:'',
                    LegalRepresentative2:'',
                    Name:'',
                    Date1:'',
                    Date2:'',
                },
                rules:{
                  Client:[
                    { required: true, message: "不能为空！", trigger: "blur" },
                  ],
                  Trustee:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  LegalRepresentative1:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  LegalRepresentative2:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Name:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  Date1:[
                  { required: true, message: "请选择日期！", trigger: "change" },
                  ]
                  },
                  shortcuts: [{
                    text: 'Today',
                    onClick(picker) {
                      picker.$emit('pick', new Date());
                    }
                  }, {
                    text: 'Yesterday',
                    onClick(picker) {
                      const date = new Date();
                      date.setTime(date.getTime() - 3600 * 1000 * 24);
                      picker.$emit('pick', date);
                    }
                  }, {
                    text: 'A week ago',
                    onClick(picker) {
                      const date = new Date();
                      date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                      picker.$emit('pick', date);
                    }
                  }],

        }
    },
  mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload);
  window.addEventListener('unload', this.handleUnload);
      },
created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
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
          /*this.$refs[formName].validate((valid) => {
            if (valid) {
              alert("submit!");
              this.$router.push({path: "./client", replace:true});
            } else {
              return false;
            }
          });*/
          Axios.post("http://localhost:1234/user/insert",JSON.stringify(this.ruleForm)).then(ret=>{
            console.log(ret.data)
          })
          .catch(function (error) { // 请求失败处理
            console.log(error);
            
          });
          this.stepNumber+=2;
          this.info("提交成功，正在返回用户界面！");
          setTimeout(() => {this.$router.push({path: "../client", replace:true});}, 2000);
        }
      },
    
    }
    
    </script>
    <style>
    .h1 {
      margin-left: -10%;
      margin-top: 50px;
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
    
    </style>