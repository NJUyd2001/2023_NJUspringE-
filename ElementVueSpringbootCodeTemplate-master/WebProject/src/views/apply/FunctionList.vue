<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/application">申请表填写</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/functionlist">委托功能列表填写</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
  <el-col :span="2">
    <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
    </el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="10">
        <router-link to="/application">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="4" ><div class="grid-content bg-purple">
        <span class="logo-title">申请界面-功能列表</span>
        </div></el-col>
        <el-col :span="8">
        <el-steps :space="200" :active="StepNumber" finish-status="success">
          <el-step title="申请表填写"></el-step>
          <el-step title="功能列表填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
      </el-col>
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main style="border-radius: 30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);">
      <el-form label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label="软件名称:" prop="SoftwareName">
          <el-input v-model="ruleForm.SoftwareName" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="版本号:" prop="Versions">
          <el-input v-model="ruleForm.Versions" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :rules="{
        required: true,
        message: '功能项目不能为空！',
        trigger: 'blur',
      }" :label='"功能项目"+index+":"' :key="index" >
          <el-input placeholder="功能项目" style="width: 100px;padding-right:20px;" v-model="Table.name"></el-input>
          <el-input placeholder="功能说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.function"></el-input>
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
                telephone:'',
                fax:'',
                address:'',
                postcode:'',
                contacts:'',
                mobilephone:'',
                email:'',
                URL:'',
            },
            ruleForm:{
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
            StepNumber:1,
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
      alert(JSON.stringify(this.ruleForm));
    },
    addfatherItem(){
      this.ruleForm.TableData.push({
        id:this.ruleForm.TableData[this.ruleForm.TableData.length-1]+1,
        name:'',
        function:'',
        children:[],
      })
    },
    removefatherItem(Table){
      const index = this.ruleForm.TableData.indexOf(Table)
      if (index !== -1&&index!=0) {
        //alert(index)
      this.ruleForm.TableData.splice(index, 1);
  }
    },
    addchildrenItem(Node){
        Node.children.push(
          {
            id:'',
            
          }
        )
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.StepNumber+=2;
        this.info("提交成功，正在返回用户界面！");
        setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
        } else {
          return false;
        }
      });
      // Axios.post("http://localhost:1234/user/insert",JSON.stringify(this.ruleForm)).then(ret=>{
      //   console.log(ret.data)
      // })
      // .catch(function (error) { // 请求失败处理
      //   console.log(error);
      // })
      
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
</style>