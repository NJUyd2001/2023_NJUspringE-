<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a/>个人信息完善</el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/application">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" push="4"><div class="grid-content bg-purple">
        <span class="logo-title">个人信息完善</span>
        </div></el-col>
        <el-col :span="6" pull="3">
        <div class="grid-content bg-purple-light text-right">
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
    <br><br><br><br>
    <el-main>
      <el-form label-width=40% :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item label="电话号码:" prop="common">
          <el-input v-model="ruleForm.Telephone" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="传真:" prop="common">
          <el-input v-model="ruleForm.Fax" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="地址:" prop="common">
          <el-input v-model="ruleForm.Address" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="邮编:" prop="common">
          <el-input v-model="ruleForm.Postcode" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人:" prop="common">
          <el-input v-model="ruleForm.Contacts" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人电话:" prop="common">
          <el-input v-model="ruleForm.ContactPhone" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="E-mail:" prop="common">
          <el-input v-model="ruleForm.Email" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="网址:" prop="common">
          <el-input v-model="ruleForm.URL" style="width: 200px;"></el-input>
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
              Telephone:'',
              Fax:'',
              Address:'',
              Postcode:'',
              Contacts:'',
              ContactPhone:'',
              Email:'',
              URL:'',

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
                common:[
                      { required: true, message: "不能为空！", trigger: "blur" },
                    ],
                    choose:[
                      { required: true, message: "不能为空！", trigger: "change" },
                    ],
                    }
    }
}, 
  methods:{
    goback(){
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
      this.info("提交成功，正在返回用户界面！");
      setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
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