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
      <el-col :span="6">
        <router-link to="/test">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" push="3"><div class="grid-content bg-purple">
        <span class="logo-title">软件委托测试合同</span>
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
          <el-input v-model="ruleForm.trustee" style="width: 200px;"></el-input>
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
        <el-form-item  label="合同内容:">
          <br>
          <el-text size="50px" >本合同由作为委托方的{{ruleForm.Client}}以下简称“甲方”）与作为受托方的南京大学（以下简称“乙方”）在平等自愿的基础上，
            依据《中华人民共和国合同法》有关规定就项目的执行，经友好协商后订立。</el-text>
          
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
      if (index !== -1) {
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
</style>