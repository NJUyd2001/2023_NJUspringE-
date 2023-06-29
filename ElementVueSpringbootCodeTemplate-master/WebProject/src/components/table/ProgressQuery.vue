<template>
  
<div class="stepComponent" >
    <div class="stepsTitle">
      <div style="float:left;width:2px;height:20px;"></div> 
        委托流程及意见
    </div>
    <div class="approvalProcess" >
        <el-steps :active="active" finish-status="success" direction="vertical" >
           <el-step :title="item.label"  v-for="item in approvalProcessProject" :id="item.id">
            <template slot="description" >
            

             <div class="step-row">
               <table width="90%" border="0" cellspacing="0" cellpadding="0" class="processing_content" >
                         <tr v-if="item.id=='1'">
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >人员分配中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >市场部审核中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >测试部审核中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                          </tr>
                          <tr v-if="item.id=='2'">
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >市场部生成合同中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                          </tr>
                          <tr v-if="item.id=='3'">
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >市场部审核合同中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >样品审核中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >测试报告制作中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                          </tr>
                          <tr v-if="item.id=='4'">
                            <td style="color:#98A6BE" >
                            	<div class="processing_content_detail" style="float:left;width:70%"><span >授权签字人审核中...</span></div> 
                              <div class="processing_content_detail" style="float:right;"><span ><i class="el-icon-time"></i>&nbsp;&nbsp;昨天12:24</span> </div>
                            </td>
                          </tr>
                </table>
           </div>
         </template>
 
           </el-step>
        </el-steps>
         <el-button style="margin-top: 12px;" @click="next">查看保密协议</el-button>
 
  </div>
 
</div>
</template>

<script>
import Vue from "vue";

export default {
   components: {
  },
  created() {
    // 载入config数据
    //this.$store.dispatch("config/reload");
    this.$bus.on("login-open", this.loginOut);
    this.$bus.on("login-success", this.loginSuccess);
    this.$bus.on("login-cancel", this.loginCancel);
  },
  props: ['data', 'defaultActive'],
  data() {
    return {
       active: 2,
       approvalProcessProject:[
          {id:'0',label: "您尚未发起委托"},
          {id:'1',label: "委托已发起，等待审核"},
          { id:'2',label: "委托已通过，请查看报价"},
          { id:'3',label: "请填写合同，并上传样品"},
          { id:'4',label: "请审核测试报告"},
          {id:'5',label: "委托已完成，感谢您的选择"},
       ],
    };
  },
  //Tabs
      selectTabName: "ConfigAdd",
      tabs: {
        ConfigAdd: {
          title: "新建页面",
          name: "ConfigAdd",
          currentView: "ConfigAdd"
        }
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
    next() {
        if (this.active++ > 2) this.active = 0;
      },
  }
};
</script>
<style scoped>
  .stepComponent{
      background-color:#DFEBFF;
      width: 100%-20px;
      padding: 10px 10px 10px 10px;
      margin: 10px 10px 10px 10px;
  }
  .stepsTitle{
      margin: 10px 0px  10px  10px ;
  }
  .approvalProcess{
      color: #9EADC4;
      font-size: 14px;
      /* width: 100%; */
      background:#DFEBFF;
      margin-left:20px;
      margin-right:0px;
      margin-top:10px;
  }
  .processing_content{
    background-color: #D9E5F9;
  }
  .processing_content_detail{
     margin-left: 10px;
     margin-top: 3.5px;
     margin-bottom: 3.5px;
	   width:150px;
     display:inline-block;
  }
  .step-row{
     min-width:500px;
     margin-bottom:12px;
     margin-top:12px;
  }
</style>