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
            <el-input v-model="form.nickname"></el-input>
          </el-form-item>
          <el-form-item label="账号密码" prop="password">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="传真" prop="fax">
            <el-input v-model="form.fax"></el-input>
          </el-form-item>
          <el-form-item label="电话号" prop="telephone">
            <el-input v-model="form.telephone"></el-input>
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
    <el-button type="primary" @click="submit">提 交</el-button>
  </span>
</el-dialog>
  </div>
</template>

<script>

export default {
  name: "PersonalDia",
  data() {
    return {
      dialogVisible: false,
      form: {
        avatar: "",
        password: "",
        nickname: "",
        age: Number,
        email: "",
        mobilePhoneNumber: "",
        sex: Number,
        id: Number,
        account: "",
        area: "",
        hobby: "",
        work: "",
        design: "",
      },
      rules: {
        nickname: [
          { required: true, message: "昵称不能为空", trigger: "blur" },
        ],
        password: [
          { required: true, message: "账号密码不能为空", trigger: "blur" },
        ],
      },
    };
  },
  mounted() {
    this.load();
  },
  methods: {
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
