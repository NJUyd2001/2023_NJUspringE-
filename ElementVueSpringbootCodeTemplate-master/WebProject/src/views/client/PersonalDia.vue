<template>
  <div>
      <el-dialog
  title="修改个人信息"
  :visible.sync="dialogVisible"
  width="60%"
  :before-close="handleClose">
  <el-form :model="form" :rules="rules" ref="form" label-width="150px">
      <div class="updateinfo">
  <div class="left">
          <el-form-item label="用户名" prop="nickname">
            <el-input v-model="ruleForm.nickname"></el-input>
          </el-form-item>
          <el-form-item label="账号密码" prop="password">
            <el-input v-model="ruleForm.password"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
          </el-form-item>
          <el-form-item label="传真" prop="fax">
            <el-input v-model="ruleForm.fax"></el-input>
          </el-form-item>
          <el-form-item label="电话号" prop="telephone">
            <el-input v-model="ruleForm.telephone"></el-input>
          </el-form-item>
          
  </div>
  <div class="right">
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="hobby">
            <el-input v-model="form.hobby"></el-input>
          </el-form-item>
          <el-form-item label="联系人电话" prop="work">
            <el-input v-model="form.work"></el-input>
          </el-form-item>
            <el-form-item label="邮编" prop="design">
            <el-input v-model="form.design"></el-input>
          </el-form-item>
  </div>
  </div>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="handleClose">取 消</el-button>
    <el-button type="primary" @click="submitForm('ruleForm')">提 交</el-button>
  </span>
</el-dialog>
  </div>
</template>

<script>

export default {
  name: "PersonalDia",
  data(){
       return{
            ruleForm:{
              new_fax:"",
              new_address:"",
              new_zipcode:"",
              new_contact:"",
              new_contactTel:"",
              new_ip:"",
              UID:this.$store.state.user.id,
            },
            rules:{
              new_fax:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_address:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_zipcode:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_contact:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_contactTel:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_ip:[
              {  required: true, message: "不能为空！", trigger: "blur" },
              ],
              new_choose:[
              { required: true, message: "不能为空！", trigger: "change" },
              ],
              }
    }
}, 
  mounted() {
    this.load();
  },
  methods: {
    goback(){
    },
    submitForm(formName) {
      Axios.post("http://localhost:9090/api/user/update",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret)
        this.info("提交成功，正在返回用户界面！");
        setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
      })
    },
    open() {
      this.dialogVisible = true;
    },
    load() {
      userInfo(this.$store.state.id)
        .then((res) => {
          console.log(res);
          Object.assign(this.form, res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    submit() {
      updateUser(this.form)
        .then((res) => {
          console.log(res);
          this.dialogVisible = false;
          this.$emit("flesh");
        })
        .catch((err) => {
          console.log(err);
        });
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
