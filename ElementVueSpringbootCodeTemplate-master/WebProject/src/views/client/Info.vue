<template>
  <div>
    <el-card>
      <el-descriptions class="margin-top" title="简介" :column="2" border>
        <template slot="extra">
          <el-button type="primary" v-if="$route.params.id==$store.state.id" size="small">操作</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-picture-outline"></i>
            头像
          </template>
          <img class="img" :src="avatar" alt="" />
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            账户名
          </template>
          {{ account }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-custom"></i>
            联系方式
          </template>
          {{ telephone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-odometer"></i>
            传真
          </template>
          {{ tax }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>
            <i class="el-icon-female"></i>
            地址
          </template>
          <el-tag size="small">{{ address }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            邮箱Email
          </template>
          {{ Email }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            联系人
          </template>
          {{ mobilePhoneNumber }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            联系人电话
          </template>
          {{ area }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            邮编
          </template>
          {{ work }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-basketball"></i>
            网址
          </template>
          {{ web }}
        </el-descriptions-item>
    </el-descriptions>
    </el-card>
  </div>
</template>

<script>
//import { userInfo } from "@/api/user.js";
export default {
  name: "Info",
  data() {
    return {
      avatar: String,
      account: String,
      age: Number,
      email: String,
      mobilePhoneNumber: String,
      area: String,
      createDate: Number,
      nickname: String,
      sex: String,
      work: String,
      hobby: String,
      design: String,
    };
  },
  mounted() {
    this.load();
  },
  methods: {
    load() {
      userInfo(this.$route.params.id)
        .then((res) => {
          this.avatar = res.data.avatar;
          this.account = res.data.account;
          this.age = res.data.age;
          this.email = res.data.email;
          this.mobilePhoneNumber = res.data.mobilePhoneNumber;
          this.area = res.data.area;
          this.createDate = res.data.createDate;
          this.nickname = res.data.nickname;
          this.sex = res.data.sex == 1 ? "男" : "女";
          this.work = res.data.work;
          this.design = res.data.design;
          this.hobby = res.data.hobby;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
.img {
  width: 80px;
  height: 80px;
}
</style>
