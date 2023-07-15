<template>
  <div>
      <el-dialog
  title="修改个人信息"
  :visible.sync="dialogVisible"
  width="60%"
  :before-close="handleClose"
  append-to-body>
  <el-form :model="user" :rules="rules" ref="form" label-width="150px">
      <div class="updateinfo">
  <div class="left">
          <el-form-item label="用户名" prop="nickname">
            <el-input v-model="user.nickname"></el-input>
          </el-form-item>
          <el-form-item label="账号密码" prop="password">
            <el-input v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="emailAddr">
            <el-input v-model="user.emailAddr"></el-input>
          </el-form-item>
          <el-form-item label="传真" prop="userfax">
            <el-input v-model="user.userfax"></el-input>
          </el-form-item>
          <el-form-item label="电话号" prop="phone">
            <el-input v-model="user.phone"></el-input>
          </el-form-item>
          
  </div>
  <div class="right">
          <el-form-item label="地址" prop="ip">
            <el-input v-model="user.ip"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="contact">
            <el-input v-model="user.contact"></el-input>
          </el-form-item>
          <el-form-item label="联系人电话" prop="contactTel">
            <el-input v-model="user.contactTel"></el-input>
          </el-form-item>
            <el-form-item label="邮编" prop="zipcode">
            <el-input v-model="user.zipcode"></el-input>
          </el-form-item>
  </div>
  </div>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="handleClose">取 消</el-button>
    <el-button type="primary" @click="submitForm('user')">提 交</el-button>
  </span>
</el-dialog>
  </div>
</template>

<script>
import Axios from 'axios'
export default {
  name: "PersonalDia",
  data() {
    return {
      dialogVisible: false,
      userid:{
        UID:"",
      },
      user:{
      },
      rules: {
        nickname: [
          { required: true, message: "昵称不能为空", trigger: "blur" },
        ],
        password: [
          { required: true, message: "账号密码不能为空", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        fax: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        emailAddr: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        address: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        ip: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        contact: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        contactTel: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        zipcode: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created(){
    this.KeepInfor();
    this.userid.UID=this.$store.state.user.id;
    console.log(this.userid.UID);
    Axios.post("http://localhost:9090/api/user/selectByUID",JSON.stringify(this.userid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.user=ret.data;
        this.user.UID=this.userid.UID;
      })
  },
  mounted() {
    window.addEventListener('beforeunload', this.handleBeforeUnload());
    window.addEventListener('unload', this.handleUnload);
  },
  methods: {
    handleBeforeUnload() {
          sessionStorage.setItem("store",JSON.stringify(this.$store.state))
            },
      handleUnload() {
          sessionStorage.setItem("store",JSON.stringify(this.$store.state))
            },
    open() {
      this.dialogVisible = true;
    },
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/update",JSON.stringify(this.user),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.$message.info("提交成功，正在返回登录界面！");
        setTimeout(() => {this.$router.push({path: "../home", replace:true});}, 2000);
      })
    },
    handleClose() {
      this.dialogVisible = false;
      this.$emit("flesh");
    },
  },
};
</script>

<style scoped>
.updateinfo {
  height: 350px;
  overflow: auto;
}
.left {
  /* width: 330px; */
  float: left;
}
.right {
  overflow: hidden;
}
</style>