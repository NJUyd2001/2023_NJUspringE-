<template>
<div class="Person">
<el-container style="height:880px;">
  <el-header style="height: 10%">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8"><div class="grid-content bg-purple">
        <span style="font-size: 30px; font-weight: 1000;">{{user.uname}},您好（授权签字人）</span>
        </div></el-col>
        <el-col :span="12">
          <img src="../../assets/l3.png" style="height:80px"/>
        </el-col>
      <el-col :span="4"><div class="grid-content bg-purple-light">
        <el-button  plain type="primary" class="el-icon-user" @click="handleStart">{{user.uname}}</el-button>
        <el-button type="primary"  size="mini" @click="loginOut">登出</el-button></div>
      </el-col>
    </el-row>
  </el-header>

  <el-container>
    <el-container>
    <el-main>      
      <el-tabs v-model="selectTabName" type="card" @tab-remove="removeTab">
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
  <el-footer>
  <p>南京大学 计算机软件新技术国家重点实验室 软件测试中心<br>
  江苏省 南京市 栖霞区 仙林大道163号南京大学仙林校区计算机科学与技术楼<br>
  电话025-89683467  传真025-89686596   Email: keysoftlab@nju.edu.cn</p>
  </el-footer>
</el-container>
</el-container>
  <LoginDialog :show='showLogin'/>
</el-container></div>
</template>
<script>
import Vue from "vue";

export default {
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'margin:0;')
  },
  created() {
    // 载入config数据
    //this.$store.dispatch("config/reload");
    this.KeepInfor();
  },
  data() {
    return {
      showLogin: false,
      user: {
        uname:this.$store.state.user.name,
        password:""
      },
      keyword: "",
      isCollapse: false,
      menus: [{}],
      user:{
        uname:this.$store.state.user.name,
        utype:this.$store.state.user.Permissions,
      },
      data: [{}],
      //Tabs
      selectTabName: "SCheckReport",
      tabs: {
        ConfigAdd: {
          title: "测试报告审核",
          name: "SCheckReport",
          currentView: "SCheckReport"
        }
      }
    };
  },
  computed: {
    lang: {
      get: function() {
        console.log("config", Vue.config);
        return Vue.config.lang;
      },
      set: function(v) {
        //do nothing
        this.$bus.emit("lang-change", v);
      }
    }
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
    handleNodeClick(data) {
        console.log(data);
      },
    switchLang(command) {
      this.lang = command;
    },
    handleStart() {
      this.$router.push('/Personal');
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
    jump2application() {
      this.$router.push('/testaudituser');
    },
    jump2report() {
      this.$router.push('/report');
    },
    // loginCancel() {
    //   console.log("loginCancel");
    //   this.showLogin = false;
    // },
    logout() {
      this.ajax.post("/app/logout").then(result => {
        if (result.code == 0) {
          this.user = null;
        } else {
          this.error(result.msg);
        }
      });
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
