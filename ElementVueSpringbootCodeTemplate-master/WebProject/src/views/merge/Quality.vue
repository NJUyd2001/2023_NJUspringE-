<template>
<div class ="Person">
<el-container style="height: 90%;">
  <el-header style="height: 10%;">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8"><div class="grid-content bg-purple">
        <span class="logo-title">{{user.uname}},您好(质量部)</span>
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
  <br>
  <el-container>
    <el-main>      
      <el-tabs v-model="selectTabName" type="card">
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
  <LoginDialog :show='showLogin'/>
</el-container>
</div>
</template>


<script>
import Vue from "vue";

export default {
  created() {
    // 载入config数据
    //this.$store.dispatch("config/reload");
    this.$bus.on("login-open", this.loginOut);
    this.$bus.on("login-success", this.loginSuccess);
    this.$bus.on("login-cancel", this.loginCancel);
  },
  data() {
    return {
      // 步骤
      active: 0,
      // 已选步骤
      stepSuc: [0],
      // 步骤标题
      stepTitle: ['发起委托', '报价处理', '合同处理', '样品发送', '确认接收', '测试报告'],
      showLogin: false,
      user:{
        uname:this.$store.state.user.name,
      },
      keyword: "",
      isCollapse: false,
      showModal: false,
      menus: [{}],

      //Tabs
      selectTabName: "ConfigTableQ",
      tabs: {
        ConfigAdd: {
        title: "测试方案审核",
        name: "ConfigTableQ",
        currentView: "ConfigTableQ"
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
  mounted() {
    // this.$nextTick(function() {
    //   this.ajax.post("/app/user").then(result => {
    //     if (result.code == 0) {
    //       this.user = result.data;
    //     }
    //   });
    // });
  },
  methods: {
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
      this.$router.push('client/Personal');
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
      this.$router.push('/application');
    },
    jump2myinf(){
      this.$router.push('/myinf');
    },
    addTab(targetName, commentName) {
      // 如果已经存在
      if (this.tabs[commentName]) {
        this.selectTabName = commentName;
        return;
      }

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

span.logo-title{
  font-size: 30px;
  font-weight: 1000;
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
  width: 100%
}
</style>