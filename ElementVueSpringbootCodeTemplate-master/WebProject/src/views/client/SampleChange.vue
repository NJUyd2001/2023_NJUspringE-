<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/Client' }">用户主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/">样品修改</a></el-breadcrumb-item>
  </el-breadcrumb>
</el-col>
  <el-col :span="2">
    <el-button @click="Logout()" style="margin-bottom: 5px;" size="mini" type="primary">登出</el-button>
  </el-col>
    </el-row>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="2">
        <router-link to="/">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="20" ><div class="grid-content bg-purple">
        <span class="logo-title">样品修改</span>
        </div></el-col>
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main style="border-radius: 30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);">
      <br>
      <el-form  :model="ruleForm"  ref="ruleForm">
        <el-row type="flex" justify="center">
        <el-radio-group v-model="ruleForm.Pass" :span="3" disabled>      
          <el-radio  label="false">拒绝</el-radio>
          <el-radio  label="true">同意</el-radio>
        </el-radio-group>
        </el-row>
        <el-row type="flex" justify="center">
  <el-form-item label="意见：" >
          <el-input style="width:700px;" :rows="5" v-model="ruleForm.Views" type="textarea" disabled></el-input>
        </el-form-item>
      </el-row >
      <el-row type="flex" justify="center">
        <el-form-item label="软件样品一套:">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadzip"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              :data="{ PID:this.$store.state.user.process.PID, state:'40', fileType:'sample' }"
              >
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>注：与《委托测试软件功能列表》一致。
                                            </strong></div>
            </el-upload>
        </el-form-item>
      </el-row>
      <el-row type="flex" justify="center">
        <el-form-item label="支持性数据:">
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
              :data="{ PID:this.$store.state.user.process.PID, state:'40', fileType:'samenv' }"
              >
  <el-button size="small" type="primary">点击上传</el-button>
  <div slot="tip" class="el-upload__tip"><strong>注：包含相关平台与环境信息。
                                            </strong></div>
            </el-upload>
        </el-form-item>
      </el-row>
      </el-form>
    </el-main>
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
            ruleForm:{
              Views:"",
              Pass:"",
            },
            StepNumber:2,
    }
},
mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload());
  window.addEventListener('unload', this.handleUnload);
},
created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.ruleForm.AID=this.$store.state.user.process.AID;
    this.process.PID=this.$store.state.user.process.PID;
    console.log(this.process.PID);
    this.process.PID=1;
    Axios.post("http://localhost:9090/api/samplecheck/find",JSON.stringify(this.process),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data[0])
        this.ruleForm=ret.data[0];
      })
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
    beforeUploadzip(file) {
        const isZIP = file.type === 'application/x-zip-compressed';
        const isRAR = file.type === '';
        //console.log(file.type)
        if (!isZIP && !isRAR) {
          this.$message.error('上传头像图片只能是 ZIP/RAR 格式!');
        }
        return isZIP || isRAR;
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