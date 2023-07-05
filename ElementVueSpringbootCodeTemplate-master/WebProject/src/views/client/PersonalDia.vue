<template>
  <div>
      <el-dialog
  title="修改个人信息"
  :visible.sync="dialogVisible"
  width="60%"
  :before-close="handleClose">
  <el-form :model="user" :rules="rules" ref="form" label-width="150px">
      <div class="updateinfo">
  <div class="left">
          <el-form-item label="用户名" prop="new_uname">
            <el-input v-model="user.new_uname"></el-input>
          </el-form-item>
          <el-form-item label="账号密码" prop="new_password">
            <el-input v-model="user.new_password"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="new_email">
            <el-input v-model="user.new_email"></el-input>
          </el-form-item>
          <el-form-item label="传真" prop="new_fax">
            <el-input v-model="user.new_fax"></el-input>
          </el-form-item>
          <el-form-item label="电话号" prop="new_phone">
            <el-input v-model="user.new_phone"></el-input>
          </el-form-item>
          
  </div>
  <div class="right">
          <el-form-item label="地址" prop="new_address">
            <el-input v-model="user.new_address"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="new_contact">
            <el-input v-model="user.new_contact"></el-input>
          </el-form-item>
          <el-form-item label="联系人电话" prop="new_contactTel">
            <el-input v-model="user.new_contactTel"></el-input>
          </el-form-item>
            <el-form-item label="邮编" prop="new_zipcode">
            <el-input v-model="user.new_zipcode"></el-input>
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
      user:{
        new_uname:this.$store.state.user.name,
        new_phone:this.$store.state.user.phone,
        new_fax:this.$store.state.user.fax,
        new_email:this.$store.state.user.email,
        new_address:this.$store.state.user.address,
        new_zipcode:this.$store.state.user.zipcode,
        new_contact:this.$store.state.user.contact,
        new_contactTel:this.$store.state.user.contactTel,
        new_password:this.$store.state.user.password,
        UID:this.$store.state.user.id,
      },
      rules: {
        new_uname: [
          { required: true, message: "昵称不能为空", trigger: "blur" },
        ],
        new_password: [
          { required: true, message: "账号密码不能为空", trigger: "blur" },
        ],
        new_phone: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        new_fax: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        new_email: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        new_address: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        new_contact: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
        new_contactTel: [
          { required: true, message: "不能为空", trigger: "blur" },
        ],
      },
    };
  },
  mounted() {
  },
  methods: {
    open() {
      this.dialogVisible = true;
    },
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/update",JSON.stringify(this.user),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret)
        this.info("提交成功，正在返回登录界面！");
        setTimeout(() => {this.$router.push({path: "../clientlogin", replace:true});}, 2000);
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