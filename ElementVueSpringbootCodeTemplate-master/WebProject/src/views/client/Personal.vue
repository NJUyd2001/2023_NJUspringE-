<template>
  <div class ="Person">
    <div class="PersonTop">
      <div class="PersonTop_img">
        <img v-image-preview :src="avatar" />
      </div>
      <div class="PersonTop_text">
        <div class="user_text">
          <div class="user_name">
            <span> {{ user.uname }} </span>
          </div>
          <div class="user-v" v-if="v === 3">
            <img src="../../assets/nju.png" class="user-v-img" />
            <span class="user-v-font">优质媒体作者</span>
          </div>
          <div class="user_qianming">
            <span> {{ design }}</span>
          </div>
          <div class="user_anniu">
            <el-button
              class="el-icon-edit"
              v-if="this.$route.params.id === this.$store.state.id"
              type="primary"
              size="medium"
              plain
              @click="edit"
              >编辑</el-button
            >
          </div>
        </div>
        
      </div>
    </div>
    <div class="person_body">
      <div class="person_body_left">
        <el-card class="box-card" :body-style="{ padding: '0px' }">
          <div slot="header" class="clearfix">
            <span class="person_body_list" style="border-bottom: none"
              >个人中心</span
            >
          </div>
          <!-- <div
            class="person_body_list"
            v-for="(item, index) in person_body_list"
            :key="index"
          >
            <router-link :to="{ name: item.name, params: item.params }">{{
              item.label
            }}</router-link>
          </div> -->
          <el-menu
            router
            active-text-color="#00c3ff"
            class="el-menu-vertical-demo"
          >
            <el-menu-item
              index="Info"
              :route="{ name: 'Info', params: $route.params.id }"
            >
              <i class="el-icon-user"></i>
              <span slot="title">个人简介</span>
            </el-menu-item>

            <el-menu-item
              index="myarticle"
              v-if="this.$route.params.id === this.$store.state.id"            
            >
              <i class="el-icon-edit"></i>
              <span slot="title" @click="edit">编辑</span>
            </el-menu-item>
            <el-menu-item
              index="mycollect"
              :route="{ name: 'mycollect', params: $route.params.id }"
            >
              <i class="el-icon-close"></i>
              <span slot="title">登出</span>
            </el-menu-item>
          </el-menu>
        </el-card>
      </div>
      <div class="person_body_right">
        <div>
    <el-card>
      <el-descriptions class="margin-top" title="简介" :column="2" border>
        <template slot="extra">
          <el-button type="primary" v-if="$route.params.id==$store.state.id" size="small">操作</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            账户名
          </template>
          {{ user.uname }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-custom"></i>
            联系方式
          </template>
          {{ user.phone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-printer"></i>
            传真
          </template>
          {{ user.fax }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            地址
          </template>
          <el-tag size="small">{{ address }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            邮箱Email
          </template>
          {{ user.email }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            联系人
          </template>
          {{ mobilePhoneNumber }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            联系人电话
          </template>
          {{ area }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            邮编
          </template>
          {{ user.zipcode }}
        </el-descriptions-item>
    </el-descriptions>
    </el-card>
  </div>
      </div>
    </div>
    <personal-dia ref="dia" @flesh="reload" />
  </div>
</template>

<script>
import Vue from "vue";

import PersonalDia from "./PersonalDia.vue";
import Info from "./Info.vue";

export default {
  components: { PersonalDia },
  name: "Personal",
  inject: ["reload"],
  data() {
    return {
      avatar: "",
      nickname: "",
      v: 1,
      design: "",
      followCounts: "",
      fanCounts: "",
      goodCounts: "",
      isfollow: true,
      followData: {
        fanId: "",
        followId: "",
      },
      isfollowid: [],
      user:{
        uname:this.$store.state.user.name,
        phone:this.$store.state.user.phone,
        fax:this.$store.state.user.fax,
        email:this.$store.state.user.email,
      },
    };
  },
  mounted() {
    this.load();
  },
  watch: {
    $route(to, from) {
      if (to.path == `/newsuser/personal/${this.$store.state.id}`) {
        this.reload();
      } else if (to.path == `/newsuser/personal/${this.$route.params.id}`) {
        this.reload();
      }
    },
  },
  methods: {
    load() {
      userInfo(this.$route.params.id)
        .then((res) => {
          console.log(res);
          this.avatar = res.data.avatar;
          this.nickname = res.data.nickname;
          this.v = res.data.v;
          this.design = res.data.design;
        })
        .catch((err) => {
          console.log(err);
        });

      myFollow(this.$store.state.id)
        .then((res) => {
          res.data.forEach((res) => {
            this.isfollowid.push(res.id);
          });
        })
        .catch((err) => {
          console.log(err);
        });

      followAndFanCount(this.$route.params.id)
        .then((res) => {
          this.followCounts = res.data.followCounts;
          this.fanCounts = res.data.fanCounts;
        })
        .catch((err) => {
          console.log(err);
        });

      mygoodCount(this.$route.params.id)
        .then((res) => {
          this.goodCounts = res.data.goodCounts;
        })
        .catch((err) => {
          console.log(err);
        });
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

    myfan() {
      this.$router.push({
        path: `/newsuser/personal/myfan/${this.$route.params.id}`,
      });
    },
    myfollow() {
      this.$router.push({
      path:`/newsuser/personal/myfollow/${this.$route.params.id}`,
      });
    },
    follow() {
      if (!this.$store.state.id) {
        this.$message({
          showClose: true,
          message: "请登录后再进行操作哦",
          type: "warning",
        });
      } else {
        this.followData.followId = this.$route.params.id;
        this.followData.fanId = this.$store.state.id;
        if (this.isfollowid.indexOf(this.followData.followId) > -1) {
          this.isfollow = true;
        } else {
          this.isfollow = false;
        }
        if (this.isfollow) {
          deleteFollow(this.followData)
            .then((res) => {
              this.isfollow = false;
              this.$message({
                showClose: true,
                message: "已取消关注",
                type: "success",
              });
              this.reload();
            })
            .catch((err) => {
              console.log(err);
            });
        } else if (!this.isfollow) {
          addFollow(this.followData)
            .then((res) => {
              this.isfollow = true;
              this.$message({
                showClose: true,
                message: "已成功关注",
                type: "success",
              });
              this.reload();
            })
            .catch((err) => {
              console.log(err);
            });
        }
      }
    },
    edit() {
      this.$refs.dia.open();
    },
  },
};
</script>

<style scoped>
.me-video-player {
  background-color: transparent;
  width: 100%;
  height: 100%;
  object-fit: fill;
  display: block;
  position: fixed;
  left: 0;
  z-index: 0;
  top: 0;
}
/* .Person{
  background: url("../../assets/b3.jpg");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%
} */
.PersonTop {
  width: 1000px;
  height: 140px;
  padding-top: 20px;
  background: url("../../assets/b3.jpg");
  margin-top: 30px;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  border-radius: 5px;
}

.PersonTop_img {
  width: 150px;
  height: 120px;
  margin-right: 24px;
  margin-left: 20px;
  overflow: hidden;
  border-radius: 20px;
}

.PersonTop_img img {
  width: 100%;
  height: 100%;
  border-radius: 20px;
}

.PersonTop_text {
  height: 120px;
  width: 880px;
  display: flex;
}

.user_text {
  width: 60%;
  height: 100%;
  line-height: 30px;
}

.user_name {
  font-weight: bold;
}
.user-v {
  margin-bottom: -5px;
}
.user-v-img {
  width: 15px;
  height: 15px;
}
.user-v-font {
  font-size: 15px;
  color: #00c3ff;
}
.user_qianming {
  font-size: 14px;
  color: #999;
}

.user_num {
  width: 40%;
  height: 100%;
  display: flex;
  align-items: center;
}

.user_num > div {
  text-align: center;
  border-right: 1px dotted #999;
  box-sizing: border-box;
  width: 80px;
  height: 40px;
  line-height: 20px;
}

.num_text {
  color: #999;
}

.num_number {
  font-size: 20px;
  color: #333;
}
.el-menu-item>span {
  font-size: 16px;
  color: #999;
}

/*下面部分样式*/
.person_body {
  width: 1000px;
  margin-top: 210px;
  display: flex;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  border-radius: 5px;
}

.person_body_left {
  width: 27%;
  height: 600px;
  border-radius: 5px;
  margin-right: 3%;
  text-align: center;
}

.person_body_list {
  width: 100%;
  height: 50px;
  margin-top: 25px;
  font-size: 22px;
  border-bottom: 1px solid #f0f0f0;
  background-image: -webkit-linear-gradient(
    left,
    rgb(42, 134, 141),
    #e9e625dc 20%,
    #3498db 40%,
    #e74c3c 60%,
    #09ff009a 80%,
    rgba(82, 196, 204, 0.281) 100%
  );
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
  -webkit-background-size: 200% 100%;
  -webkit-animation: masked-animation 4s linear infinite;
}

.el-menu-item {
  margin-top: 22px;
}

.person_body_right {
  width: 70%;
  /* height: 500px; */
  border-radius: 5px;
  background-color: white;
}

.box-card {
  height: 500px;
}

/*ui样式*/
.el-button {
  width: 84px;
}
</style>
