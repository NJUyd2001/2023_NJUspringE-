<template>
<el-container class="Person">
  <el-header style="height: 10%;">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8"><div class="grid-content bg-purple">
        <span style="font-size: 30px; font-weight: 1000;">{{user.uname}},您好</span>
        </div></el-col>
        <el-col :span="12">
          <img src="../../assets/l3.png" style="height:80px"/>
        </el-col>
      <el-col :span="4"><div class="grid-content bg-purple-light">
        <el-button  plain type="primary" class="el-icon-user" @click="handleStart">{{user.uname}}</el-button>
        <el-button type="primary"  size="mini" @click="Logout()">登出</el-button></div>
      </el-col>
    </el-row>
  </el-header>
  <el-container  style="height: 90%;">
    <el-aside width="300px">
      <el-menu
        default-active="1"
        :collapse="isCollapse"
        >
        <el-submenu index="1">
          <template slot="title" collapse=false>
            <i class="el-icon-location" @click="isCollapse = !isCollapse"></i>
            <span style="font-size:20px"> 我的委托</span>
          </template>
          <el-menu-item-group>
            <template slot="title">委托准备</template>
            <el-menu-item index="1-11" @click="jump2application()" style="font-size:18px">发起委托</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="委托处理">
            <el-menu-item index="1-21" @click="addTab('进度查询', 'MyApp')" style="font-size:18px">进度查询</el-menu-item>
          </el-menu-item-group>
          
        </el-submenu>
        <el-submenu index="0">
          <template slot="title" collapse=false>
            <i class="el-icon-setting"></i>
            <span style="font-size:20px">我的</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="0-1" @click="jump2myinf()" style="font-size:18px">个人信息完善</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

      </el-menu>
    </el-aside>
  <el-container style="height:95%;">
    <el-main style="height: 90%;">      
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
  <el-footer style="height: 10%;">
  <p>南京大学 计算机软件新技术国家重点实验室 软件测试中心<br>
  江苏省 南京市 栖霞区 仙林大道163号南京大学仙林校区计算机科学与技术楼<br>
  电话025-89683467  传真025-89686596   Email: keysoftlab@nju.edu.cn</p>
  </el-footer>
</el-container>
</el-container>
</el-container>
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
  mounted(){
    window.addEventListener('beforeunload', this.handleBeforeUnload);
    window.addEventListener('unload', this.handleUnload);
  },
  data() {
    return {
      // 步骤
      active: 0,
      // 已选步骤
      stepSuc: [0],
      // 步骤标题
      stepTitle: ['发起委托', '报价处理', '合同处理', '样品发送', '确认接收', '测试报告'],
      user:{
        uname:this.$store.state.user.name,
        utype:this.$store.state.user.Permissions,
        isLogin:sessionStorage.getItem("isLogin"),
      },
      keyword: "",
      isCollapse: false,
      showModal: false,
      menus: [{}],

      //Tabs
      selectTabName: "ProgressQuery",
      tabs: {
        ProgressQuery: {
        title: "进度查询",
        name: "ProgressQuery",
        currentView: "ProgressQuery"
        }
      }
    };
  },
  computed: {
    // 动态给步骤加样式
    stepClassObj(val) {
      return (val) => {
        return {
          stepSuc: this.stepSuc.includes(val),
          stepErr: !this.stepSuc.includes(val)
        }
      }
    },
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
  methods: {
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  Logout(){
          this.$store.state.user.id=-1;
          this.$store.state.user.name="null";
          this.$store.state.user.password=-1;
          this.$store.state.user.Permissions="null";
      this.$router.push({path: "./home", replace:true});
    },
    // 点击步骤条
    handleStep(val) {
      if (this.stepSuc.includes(val) === true) {
        this.active = val
      }
    },
    // 组件点击上一步
    handleLastStep() {
      if (--this.active === 0) { this.active = 0 }
    },
    // 组件点击下一步
    handleNextStep() {
      this.stepSuc.push(++this.active)
    },
    switchLang(command) {
      this.lang = command;
    },
    handleStart() {
      this.$router.push('/Personal');
      //console.log(Object.prototype.toString.call(user.utype));
    },
    loginOut() {
      //this.showLogin = true;
      // 移除本地用户登录信息
      sessionStorage.removeItem('userInfo');
      // 跳转页面到登录页
      this.$router.push('/home');
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
      //this.$router.push('/client/ConfidentialityAgreement');
      this.$router.push('/application');
    },
    jump2myinf(){
      this.$router.push('/myinf');
    },
    addTab(targetName, commentName) {
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
    },
     hideInfo(){
            setTimeout(()=>{
                this.userInfo=false
            },3000)
        },
//当触发mouseover时调用的方法       
        showInfo(){
            this.userInfo=true
        },
  }
};
</script>

<style>
span.logo-title{
  font-size: 30px;
  font-weight: 1000;
}

.stepSuc :hover{
  cursor: pointer;
}
.stepErr :hover{
  cursor: not-allowed;
}

#logo{
  background: url("../../assets/b3.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%
  }

.text-right {
  padding-right: 0px;
  text-align: right;
}

.hei{
    margin:0;
    padding:0;
    box-sizing: border-box;
    height: 100%;
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
.el-container .el-container .el-aside .el-menu{
  background-color:#F0F3F4
}
.el-container .el-container .el-aside .el-menu .el-submenu{
  background-color:#F0F3F4
}
.index {
  padding-left: 10px;
}

/*
* {
  outline: 1px solid;
}
*/
.el-aside::-webkit-scrollbar{
  display:none;
}


.el-footer {
    color: #333;
    text-align: center;
    font-size:3px;
    line-height: 20px;
}

.mask {
  background-color: #000;
  opacity: 0.3;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1
}
.pop {
  background-color: #fff;
  position: fixed;
  top: 100px;
  left: 100px;
  width: calc(70%);
  height:calc(70%);
  z-index: 2
}
.btn {
  background-color: #fff;
  border-radius: 4px;
  border: 1px solid blue;
  padding: 4px 12px;
}

.Person{
  background: url("../../assets/b3.jpg");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
  
}
</style>