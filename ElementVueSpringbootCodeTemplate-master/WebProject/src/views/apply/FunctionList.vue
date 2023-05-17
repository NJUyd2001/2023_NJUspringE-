<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " @back="goback">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item
      ><a href="/application">申请表填写</a></el-breadcrumb-item
    >
    <el-breadcrumb-item><a href="/functionlist">委托功能列表填写</a></el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/application">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" push="3"><div class="grid-content bg-purple">
        <span class="logo-title">申请界面-功能列表</span>
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
        <router-link to="/admin">
        <el-button  size="middle" type="success">完成</el-button>
        </router-link>
      </el-col>
    </el-row>
  </el-header>
    <br><br>
    <el-main>
      <el-form label-width="550px">
        <el-form-item label="软件名称:" >
          <el-input v-model="SoftwareName" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="版本号:" >
          <el-input v-model="Versions" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item v-for="(Table,index) in TableData"
         :label='"功能项目"+index+":"' >
          <el-input placeholder="功能项目" style="width: 100px;padding-right:20px;" v-model="Table.name"></el-input>
          <el-input placeholder="功能说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.function"></el-input>
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
    }
}, 
  methods:{
    goback(){
    },
    addfatherItem(){
      this.TableData.push({
        id:this.TableData[this.TableData.length-1]+1,
        name:'',
        function:'',
        children:[],
      })
    },
    removefatherItem(Table){
      const index = this.TableData.indexOf(Table)
      if (index !== -1) {
      this.TableData.splice(index, 1);
  }
    },
    addchildrenItem(Node){
        Node.children.push(
          {
            id:'',
            
          }
        )
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