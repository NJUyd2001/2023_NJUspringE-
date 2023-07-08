
<template>
<div id="logo">
<el-container  style="height: 880px">
  <el-header style="height: 10%;">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8"><div class="grid-content bg-purple">
        <span style="font-size: 30px; font-weight: 1000;">{{user.uname}},您好</span>
        </div></el-col>
        <el-col :span="12">
          <img src="../../assets/l3.png" style="height:80px"/>
        </el-col>
      <el-col :span="4"><div class="grid-content bg-purple-light">
        <el-button  plain type="primary" class="el-icon-user" @click="handleStart">{{isLogin}}</el-button>
        <el-button type="primary"  size="mini" @click="loginOut">登出</el-button></div>
      </el-col>
    </el-row>
  </el-header>


  <el-container>
    <el-aside style="width:auto;">
      <!--
      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
        <el-radio-button :label="false" v-show="isCollapse">展开</el-radio-button>
        <el-radio-button :label="true"v-show="!isCollapse">收起</el-radio-button>
      </el-radio-group>
      -->
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        >
        <el-submenu index="1">
          <template slot="title" collapse=false>
            <i class="el-icon-location" @click="isCollapse = !isCollapse"></i>
            <span> 委托状态</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-11" @click="addTab('委托状态', 'CTMENT')">委托状态</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
          <el-menu-item index="1-11" @click="jump2application()">审核委托</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="0">
          <template slot="title" collapse=false>
            <i class="el-icon-setting"></i>
            <span>生成报价</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="0-2" @click="addTab('个人信息完善', 'MyInformation')">委托审核结果</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="9">
          <template slot="title" collapse=false>
            <i class="el-icon-user"></i>
            <span>我的</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="9-1" @click="jump2myinf()">用户信息</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="4">
          <template slot="title" collapse=false>
            <i class="el-icon-setting"></i>
            <span>使用记录</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="4-1" @click="addTab('委托处理记录', 'UploadFile')">委托处理记录</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

      </el-menu>
    </el-aside>
    <el-main>      
      <el-tabs v-model="selectTabName" type="card" closable @tab-remove="removeTab">
        <el-tab-pane
          v-for="item in tabs"
          :key="item.name"
          :label="item.title"
          :name="item.name"
        >
          <component v-bind:is="item.currentView"></component>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
  <el-footer>
  <p>南京大学 计算机软件新技术国家重点实验室 软件测试中心<br>
  江苏省 南京市 栖霞区 仙林大道163号南京大学仙林校区计算机科学与技术楼<br>
  电话025-89683467  传真025-89686596   Email: keysoftlab@nju.edu.cn</p>
  </el-footer>
  <LoginDialog :show='showLogin'/>
</el-container></div>
</template>
<script>
import Vue from "vue";

export default {
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'margin:0;')
  },
  created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.user.uname=this.$store.state.user.name;
    this.user.utype=this.$store.state.user.Permissions;
  },
  data() {
    return {
      showLogin: false,
      user: null,
      keyword: "",
      isCollapse: false,
      isLogin: sessionStorage.getItem('isLogin'),

      menus: [{}],
      user:{
        uname:"",
        utype:"",
      },
      //Tabs
      selectTabName: "ConfigAdd",
      tabs: {
        ConfigAdd: {
          title: "新建页面",
          name: "ConfigAdd",
          currentView: "ConfigAdd"
        }
      }
    };
  },
  mounted() {
    window.addEventListener('beforeunload', this.handleBeforeUnload);
    window.addEventListener('unload', this.handleUnload);
  },
  methods: {
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
    loginOut() {
      //this.showLogin = true;
      // 移除本地用户登录信息
      sessionStorage.removeItem('userInfo');
      // 跳转页面到登录页
      this.$router.push('/login');
    },
    loginSuccess(user) {
      console.log("success", user);

      this.showLogin = false;
      this.user = user;
    },
    loginCancel() {
      console.log("loginCancel");
      this.showLogin = false;
    },
    logout() {
      this.ajax.post("/app/logout").then(result => {
        if (result.code == 0) {
          this.user = null;
        } else {
          this.error(result.msg);
        }
      });
    },
    jump2application() {
      this.$router.push('/marketaudituser');
    },
    jump2myinf(){
      this.$router.push('/myinf');
    },
    addTab(targetName, commentName) {
      // 如果已经存在
      /*if (this.tabs[commentName]) {
        this.selectTabName = commentName;
        return;
      }*/

      // add table
      this.$set(this.tabs, commentName, {
        title: targetName,
        name: commentName,
        currentView: commentName
      });

      this.selectTabName = commentName;
    },
    removeTab(targetName) {
      this.$delete(this.tabs, targetName);

      // 选中第一个tab
      for (let key in this.tabs) {
        this.selectTabName = key;
        break;
      }
    }
  }
};
</script>

<style>
#logo{
    background: url("../../assets/b3.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%;
    margin: 0 auto;
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

.el-footer {
    color: #333;
    text-align: center;
    font-size:3px;
    line-height: 20px;
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

/*
* {
  outline: 1px solid;
}
*/

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  height: 100%;
}

span.logo-title{
  font-size: 30px;
  font-weight: bold;
}
</style>