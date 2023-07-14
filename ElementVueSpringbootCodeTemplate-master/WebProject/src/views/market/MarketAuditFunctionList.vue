<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
      <el-col :span="23">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Market' }">市场部主页-审核委托</el-breadcrumb-item>
    <el-breadcrumb-item :to="{ path: '/marketaudituser' }">客户信息审核</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/marketauditapplication">申请表查看</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/marketauditfunctionlist">功能列表数据查看</a></el-breadcrumb-item>
  </el-breadcrumb>
  </el-col>
  <el-col :span="1">
    <el-button style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
</el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/marketauditapplication">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <span class="logo-title">功能列表审核</span>
        </div></el-col>
        <el-col :span="11">
          <el-steps :space="200" :active="2" finish-status="success">
          <el-step title="客户信息查看"></el-step>
          <el-step title="申请表查看"></el-step>
          <el-step title="功能列表查看"></el-step>
          <el-step title="审核意见填写"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
        </el-col>
       <el-col :span="2">
         <router-link to="/marketAuditinfor">
	          <el-button type="success" style="margin: 14px">下一步</el-button>
        </router-link>
       </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main>
      <br>
      <el-form label-width="550px" disabled :model="ruleForm" ref="ruleForm">
        <el-form-item label="软件名称:" >
          <el-input v-model="ruleForm.SoftwareName" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="版本号:">
          <el-input v-model="ruleForm.Versions" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item v-for="(Table,index) in ruleForm.TableData" :prop="'TableData.' + index + '.name'" :rules="{
        required: true,
        message: '功能项目不能为空！',
        trigger: 'blur',
      }" :label='"功能项目"+index+":"' :key="index" >
          <el-input placeholder="功能项目" style="width: 100px;padding-right:20px;" v-model="Table.name"></el-input>
          <el-input placeholder="功能说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.function"></el-input>
        </el-form-item>
        <el-form-item> 
        </el-form-item>
      </el-form>
    </el-main>
</el-container>
</template>
<el-backtop :right="50" :bottom="50" />
<script>
  import Axios from 'axios'
export default {
  created(){
      this.KeepInfor();
      this.user.AID=this.$store.state.user.process.AID
      Axios.post("http://localhost:9090/api/application/gettabledata",JSON.stringify(this.user),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          // this.tempForm=ret.data[0];
          console.log(ret.data)
           this.ruleForm=ret.data;
          // this.$message.info("提交成功！");
          // setTimeout(() => {this.$router.push({path: "./functionlist", replace:true});}, 2000);
      }).catch(function (error)
        {
          console.log(error);
        }
      )
    },
    data(){
       return{
            user:{
              AID:"", 
            },
            ruleForm:{

            },
    }
},
  mounted() {
    window.addEventListener('beforeunload', this.handleBeforeUnload());
    window.addEventListener('unload', this.handleUnload);
  },
  methods:{
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
            },
    handleUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
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