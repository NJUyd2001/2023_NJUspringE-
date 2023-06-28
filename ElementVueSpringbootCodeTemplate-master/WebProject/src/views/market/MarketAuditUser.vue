<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-row>
      <el-col :span="23">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Market' }">市场部主页-审核委托</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/marketaudituser">用户信息审核</a></el-breadcrumb-item>
  </el-breadcrumb>
  </el-col>
  <el-col :span="1">
    <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="9">
        <router-link to="/market">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="3" ><div class="grid-content bg-purple">
        <span class="logo-title">客户信息审核</span>
        </div></el-col>
        <el-col :span="10">
        <el-steps :space="200" :active="0" finish-status="success" >
          <el-step title="客户信息审核"></el-step>
          <el-step title="申请表审核"></el-step>
          <el-step title="功能列表审核"></el-step>
          <el-step title="审核信息填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
       <el-col :span="1">
         <router-link to="/marketauditapplication">
	          <el-button type="success" style="margin: 14px">下一步</el-button>
        </router-link>
       </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main >
      <el-form label-width="550px" disabled :model="ruleForm" ref="ruleForm">
        <el-form-item label="电话：">
          <el-input v-model="telephone" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="传真：">
          <el-input v-model="fax" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="地址：">
          <el-input v-model="address" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="邮编：">
          <el-input v-model="postcode" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="联系人：">
          <el-input v-model="contacts" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="手机：">
          <el-input v-model="mobilephone" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="E-mail：">
          <el-input v-model="email" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="网址：">
          <el-input v-model="URL" style="width: 200px;"></el-input>
        </el-form-item>
      </el-form>
    </el-main>
  <LoginDialog :show='showLogin'/>
</el-container>
</template>
<el-backtop :right="50" :bottom="50" />
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
    goback(){
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

span.logo-title{
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