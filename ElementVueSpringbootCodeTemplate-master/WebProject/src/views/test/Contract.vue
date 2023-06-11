<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/test' }">测试部主页主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="">合同草稿填写</a></el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="10">
        <router-link to="/test">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="12" ><div class="grid-content bg-purple">
        <span class="logo-title">软件委托测试合同</span>
        </div></el-col>
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br>
    <el-main>

      <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label-width="550px" label="项目名称:">
          <el-input v-model="ruleForm.ItemName" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label-width="550px" label="委托方（甲方）:" >
          <el-input v-model="ruleForm.Client" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label-width="550px" label="受托方（乙方）:">
          <el-input v-model="ruleForm.Trustee" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label-width="550px" label="质量特性:" >
          <el-input v-model="ruleForm.QC" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label-width="550px" label='签订日期:' >
          <div class="demo-date-picker">
          <div class="block">
            <el-date-picker
            v-model="ruleForm.date"
            type="date"
            placeholder="完成时间选择"
            :size=large
              />
            </div>
            </div>
        </el-form-item>
        <el-form-item label-width="550px" label='有效期至:' >
          <div class="demo-date-picker">
          <div class="block">
            <el-date-picker
            v-model="ruleForm.PeriodOfValidity"
            type="date"
            placeholder="完成时间选择"
            :size=large
              />
            </div>
            </div>
        </el-form-item>
      </el-form>
        <h1>合同内容:</h1>
          <p id="ContractText">本合同由作为委托方的<strong>{{ruleForm.Client}}</strong>(以下简称“甲方”)与作为受托方的南京大学(以下简称“乙方”)在平等自愿的基础上，
            依据《中华人民共和国合同法》有关规定就项目的执行，经友好协商后订立。</p>
        <h3>一、任务表述</h3>
        <p id="ContractText">乙方按照国家软件质量测试标准和测试规范，完成甲方委托的软件<strong>{{ruleForm.SoftwareName}}</strong>(下称受测软件)的质量特性
          <strong>{{ruleForm.PeriodOfValidity}}</strong>，进行测试，并出具相应的测试报告。</p>
        <h3>二、双方的主要义务</h3>
        <p id="ContractText">1. 甲方的主要义务:<br>
（1）按照合同约定支付所有费用。<br>
（2）按照乙方要求以书面形式出具测试需求，包括测试子特性、测试软硬件环境等。<br>
（3）提供符合交付要求的受测软件产品及相关文档，包括软件功能列表、需求分析、设计文档、用户文档至乙方。<br>
（4）指派专人配合乙方测试工作，并提供必要的技术培训和技术协助。<br></p>
<p id="ContractText">2. 乙方的主要义务：<br>
（1）设计测试用例，制定和实施产品测试方案。<br>
（2）在测试过程中，定期知会甲方受测软件在测试过程中出现的问题。<br>
（3）按期完成甲方委托的软件测试工作。<br>
（4）出具正式的测试报告。</p>
<h3>三、履约地点</h3>
<p id="ContractText">
  由甲方将受测软件产品送到乙方实施测试。
  如果由于被测软件本身特点或其它乙方认可的原因，需要在甲方所在地进行测试时，甲方应负担乙方现场测试人员的差旅和食宿费用。</p>
    </el-main>
  <LoginDialog :show='showLogin'/>
</el-container>
</template>
<el-backtop :right="50" :bottom="50" />
<script>
import Axios from 'axios';

export default {
    data(){
       return{
            user:{
                name:'风车村',
                password:'shazihuang',
            },
            ruleForm:{
              ItemName:'',
              Client:'豪大大鸡排',
              Trustee:'',
              QC:'',
              date:'',
              PeriodOfValidity:'',
            },
            Quote:0,
            rules:{
              SoftwareName:[
                      { required: true, message: "不能为空！", trigger: "blur" },
                    ],
              Versions:[
                { required: true, message: "不能为空！", trigger: "blur"  },
              ],
              }
    }
}, 
  methods:{
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
      // this.info("提交成功，正在返回用户界面！");
      // setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
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

#ContractText{
  font-size:20px;
  text-indent:1em;
}
</style>