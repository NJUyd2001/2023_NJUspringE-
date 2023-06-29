<template>
  <div>
  <el-row :gutter="20">
    <el-col :span="12">
    <div class="block">
  <el-timeline>
    <el-timeline-item timestamp="2018/4/12" color="#0bbd87" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">报价处理</h4>
        <p> 处理时间 2023/4/12 20:46</p>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/3" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">报价接受</h4>
        <p> 处理时间 2023/4/3 20:46</p>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">检查合同草稿中</h4>
        <p> 处理时间 2023/4/4 20:46</p>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">样品发送</h4>
        <p> 处理时间 2023/4/5 20:46</p>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">审核测试报告</h4>
        <p> 处理时间 2023/4/6 20:46</p>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4 style="margin-top: -10px;">确认接受测试报告</h4>
        <p> 处理时间 2023/4/7 20:46</p>
      </el-card>
    </el-timeline-item>
    </el-timeline>
    </div>
    </el-col>

    <el-card class="box-card">
    <div slot="header" class="clearfix">
    <span style="font-weight: bold;">立即处理</span>
    </div>
    <el-form :label-position="labelPosition" label-width="80px" style="width: 600px;" :model="formLabelAlign">
      <el-form-item style="width: 600px; height: 100px;" label="客户名">
        <el-input v-model="formLabelAlign.name" style="width: 150px; position: fixed;"></el-input>
        <el-label style="margin-left: 300px;">当前进度</el-label>
        <el-progress style="margin-top: 10px; position: fixed;" type="dashboard" :percentage="80">
      <template #default="{ percentage }">
        <span class="percentage-value">{{ percentage }}%</span>
      </template>
    </el-progress>

    </el-form-item>
    </el-form>
    <div class="demo-progress" style="margin-top: -50px; width: 200px;">
    <el-tree :data="data" :props="defaultProps" default-expand-all  @node-click="handleNodeClick"></el-tree>
    </div>
  </el-card>
  </el-row>
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
      formLabelAlign: {
          name: '',
          region: '',
          type: ''
        },

      data: [{
          label: '报价处理',
          children: [{
            label: '客户处理的报价',
          }]
        }, {
          label: '合同处理',
          children: [{
            label: '合同签署',
          }, ]
        }, {
          label: '测试报告',
          children: [{
            label: '测试方案',
          }, {
            label: '测试文档',
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
    ,
      menus: [{}],
      
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
    this.$nextTick(function() {
      this.ajax.post("/app/user").then(result => {
        if (result.code == 0) {
          this.user = result.data;
        }
      });
    });
  },
  methods: {
    handleNodeClick(data) {
        console.log(data);
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

.index {
  padding-left: 10px;
}

.el-card {
  height: 80px;
}
.text {
    font-size: 14px;
}

.item {
    margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}
.clearfix:after {
    clear: both
}

.box-card {
    width: 700px;
    margin-top: 20px;
    height: 400px;
}

.percentage-value {
  display: block;
  margin-top: 10px;
  font-size: 38px;
}

.percentage-label {
  display: block;
  margin-top: 10px;
  font-size: 12px;
}

</style>