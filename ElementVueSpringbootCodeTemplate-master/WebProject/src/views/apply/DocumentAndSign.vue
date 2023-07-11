<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/application">申请表填写</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/functionlist">委托功能列表填写</a></el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/DocumentAndSign">文档与签字上传</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
  <el-col :span="2">
    <el-button @click="Logout()" style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
    </el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="2">
        <router-link to="/application">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="12" ><div class="grid-content bg-purple">
        <span class="logo-title">申请界面-文档与签字上传</span>
        </div></el-col>
        <el-col :span="12">
        <el-steps :space="200" :active="StepNumber" finish-status="success">
          <el-step title="申请表填写"></el-step>
          <el-step title="功能列表填写"></el-step>
          <el-step title="文档与签字上传"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
      </el-col>
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main style="border-radius: 30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);">
      <br>
      <el-form label-width="550px" :model="ruleForm"  ref="ruleForm">
        <el-form-item label="样品文档(需求文档):">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadword"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              accept=".doc, .docx"
              :data="{ PID:this.process.PID, state:'10', fileType:'demand'}"
              >
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>注：1、需求文档（例如：项目计划任务书、需求分析报告、合同等）（验收、鉴定测试必须）<br>
  </strong></div>
            </el-upload>
        </el-form-item>
        <el-form-item label="样品文档(用户文档):">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadword"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              accept=".doc, .docx"
              :data="{PID:this.process.PID, state:'10', fileType:'user' }"
              >
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>注：2、用户文档（例如：用户手册、用户指南等）(必须)
                                            </strong></div>
            </el-upload>
        </el-form-item>
        <el-form-item label="样品文档(操作文档):">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadword"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              accept=".doc, .docx"
              :data="{ PID:this.process.PID, state:'10', fileType:'operation' }"
              >
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>
                                              注： 3、操作文档（例如：操作员手册、安装手册、诊断手册、支持手册等）（验收项目必须）
                                            </strong></div>
            </el-upload>
        </el-form-item>
        <el-form-item  label="申请人签字上传：">
                      <el-upload
                          class="upload-demo"
                          drag
                          action="http://localhost:9090/api/file/upload"
                          multiple
                          :before-upload="beforeUploadjpg"
                          :data="{ PID:this.process.PID, state:'10', fileType:'sign' }">
                          <i class="el-icon-upload"></i>
                          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过2Mb</div>
                      </el-upload>
                </el-form-item>
      </el-form>
    </el-main>
  <LoginDialog :show='showLogin'/>
</el-container>
</template>
<el-backtop :right="50" :bottom="50" />
<script>
import Axios from 'axios';

export default {
    data(){
       return{
            process:{
              PID:"",
            },
            StepNumber:3,
            ruleForm:{
              AID:"",
              SoftwareName:'',
              Versions:'',
            TableData:[
              {
                id:1,
                name:'',
                function:'',
            },
          ],
            },
    }
},
mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload);
  window.addEventListener('unload', this.handleUnload);
},
created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.ruleForm.AID=this.$store.state.user.process.AID
    this.process.PID=this.$store.state.user.process.PID
    console.log(this.$store.state.user.process.PID)
  },
  methods:{
  handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
    TestInfor(){
      alert(JSON.stringify(this.ruleForm));
    },
    Logout(){
          this.$store.state.user.id=-1;
          this.$store.state.user.name="null";
          this.$store.state.user.password=-1;
          this.$store.state.user.Permissions="null";
      this.$router.push({path: "./home", replace:true});
    },
    submitForm(formName) {
      console.log(this.ruleForm)
      this.$confirm("是否确认该操作","提示",{
        iconClass: "el-icon-question",//自定义图标样式
          confirmButtonText: "确认",//确认按钮文字更换
          cancelButtonText: "取消",//取消按钮文字更换
          showClose: true,//是否显示右上角关闭按钮
          type: "warning",//提示类型  success/info/warning/error
      }).then(() => {
        this.$refs[formName].validate((valid) => {
        if (valid) {
        Axios.post("http://localhost:9090/api/application/inserttabledata",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        this.StepNumber+=2;
        this.$message.success("提交成功，正在返回用户界面！");
        setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
      }) 
        } else {
          return false;
        }
      });
      })
      .catch(function (err) {
        //捕获异常
      });
    },
    handleRemove(file, fileList) {
        console.log(file, fileList);
    },
    handlePreview(file) {
        console.log(file);
      },
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
    beforeUploadword(file) {
        const isWord1 = file.type === 'application/msword';
        const isWord2 = file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
        const isPDF = file.type === 'application/pdf';
        // const isLt2M = file.size / 1024 / 1024 < 2;
        console.log(file.type)
        if (!isWord1 && !isWord2 && !isPDF) {
          this.$message.error('上传文件只能是 Word/PDF 格式!');
        }
        // if (!isLt2M) {
        //   this.$message.error('上传头像图片大小不能超过 2MB!');
        // }
        return isWord1 || isWord2 || isPDF;
      },
    beforeUploadjpg(file) {
        const isJPG = file.type === 'image/jpeg';
        const isPNG = file.type === 'image/png';
        const isLt2M = file.size / 1024 / 1024 < 2;
        console.log(file.type)
        if (!isJPG && !isPNG) {
          this.$message.error('上传头像图片只能是 jpg/png 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG || isPNG;
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