<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px " >
    <el-row>
    <el-col :span="22">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/test' }">测试部主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="/#/">样品接收及验收</a></el-breadcrumb-item>
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
        <span class="logo-title">样品验收</span>
        </div></el-col>
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main style="border-radius: 30px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);">
      <br>
      <el-form label-width="550px" :model="ruleForm"  ref="ruleForm">
        <el-form-item label="软件样品一套:" label-width="550px" >
            <el-button size="small" type="primary" @click="download1">点击下载</el-button>
          </el-form-item>
          <el-form-item label="支持性数据及相应平台信息:" label-width="550px" >
            <el-button size="small" type="primary" @click="download1">点击下载</el-button>
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
            SamRc:{
              PID:this.$store.state.user.process.PID,
              state:"41",
            },
            StepNumber:2,
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
      Axios.post("http://localhost:9090/api/process/updateState",JSON.stringify(this.SamRc),{
        headers:{
          'content-type': 'text/plain'}
        }).then(ret=>{
      })
      this.$message.success("提交成功，正在返回测试部界面！");
      setTimeout(() => {this.$router.push({path: "./test", replace:true});}, 2000);
      /*console.log(this.ruleForm)
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
        this.$message.success("提交成功，正在返回测试部界面！");
        setTimeout(() => {this.$router.push({path: "./test", replace:true});}, 2000);
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
      });*/
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
      download1(){
        var formdata=new FormData()
        formdata.append('FID' ,'23')
        //formdata.append('FID' ,this.Fid.FID1)
        //console.log(formdata.get('FID'))
        Axios.post("http://localhost:9090/api/file/download",formdata,{
        headers:{
          'content-type': 'multipart/form-data;boundary = ' + new Date().getTime()
        },
        responseType:'blob'
      }).then(ret=>{
        let data = ret.data
      if (!data) {
            return
       }
       let url = window.URL.createObjectURL(new Blob([data]))
      console.log(ret.headers['content-disposition'])
      let str = typeof ret.headers['content-disposition'] === 'undefined'
                  ? ret.headers['Content-Disposition'].split(';')[1]
                  : ret.headers['content-disposition'].split(';')[1]
      
      let filename = typeof str.split('fileName=')[1] === 'undefined'
                      ? str.split('filename=')[1]
                      : str.split('fileName=')[1]
       let a = document.createElement('a')
       a.style.display = 'none'
       a.href = url
       console.log(ret)
       a.setAttribute('download',decodeURIComponent(filename))
       document.body.appendChild(a)
       a.click() //执行下载
       window.URL.revokeObjectURL(a.href)
       document.body.removeChild(a)
      })
      },
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