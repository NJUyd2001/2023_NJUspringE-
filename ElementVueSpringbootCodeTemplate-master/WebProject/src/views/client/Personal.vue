<template>
  <div class ="Person">
    <div class="PersonTop">
      <div class="PersonTop_img">
        <img  :src="avatar" />
      </div>
      <div class="PersonTop_text">
        <div class="user_text">
          <div class="user_name">
            <span> {{ user.nickname }} </span>
          </div>
          <div class="user_anniu">
            <el-button
              class="el-icon-edit"
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
        <el-card class="bd" :body-style="{ padding: '0px' }">
          <div slot="header" class="clearfix">
            <span class="person_body_list" style="border-bottom: none"
              >个人中心</span
            >
          </div>
          <el-menu
            router
            active-text-color="#00c3ff"
            class="el-menu-vertical-demo"
          >
            <el-menu-item>
              <i class="el-icon-user"></i>
              <span slot="title">个人简介</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-edit"></i>
              <span slot="title" @click="edit">编辑</span>
            </el-menu-item>
            <el-menu-item>
              <i class="el-icon-house"></i>
              <span slot="title" @click="house()">返回</span>
            </el-menu-item>
          </el-menu>
        </el-card>
      </div>
      <div >
    <el-card class="person_body_right">
      <el-descriptions class="margin-top" title="简介" :column="2" border>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            账户名
          </template>
          {{ user.nickname }}
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
          {{ user.userfax }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            地址
          </template>
          {{ user.address }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            邮箱Email
          </template>
          {{ user.emailAddr }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            联系人
          </template>
          {{ user.contact }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            联系人电话
          </template>
          {{ user.contactTel }}
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
    <personal-dia ref="dia"  />
  </div>
</template>

<script>
import Vue from "vue";

import PersonalDia from "./PersonalDia.vue";
import Info from "./Info.vue";
import Axios from "axios";

export default {
  components: { PersonalDia },
  name: "Personal",
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
      userid:{
        UID:"",
      },
      user:{
      },
    };
  },
  created(){
    //在页面加载时读取sessionStorage里的状态信息
      this.KeepInfor();
      this.userid.UID=this.$store.state.user.id;

      Axios.post("http://localhost:9090/api/user/selectByUID",JSON.stringify(this.userid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        this.user=ret.data;
      })
    
  },
  mounted() {
    window.addEventListener('beforeunload', this.handleBeforeUnload);
    window.addEventListener('unload', this.handleUnload);
  },
  methods: {
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
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
    edit() {
      this.$refs.dia.open();
    },
    house(){
      this.$router.go(-1);
    }
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
.PersonTop {
  width: 75%;
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
  background-image:url(../../assets/avatar.jpg);
  width: 140px;
  height: 130px;
  margin-right: 20px;
  margin-left: 20px;
  overflow: hidden;
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

.el-menu-item>span {
  font-size: 16px;
  color: #999;
}

/*下面部分样式*/
.person_body {
  width: 75%;
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
  margin-top: 2px;
}

.person_body_right {
  width: 800px;
  height: 600px; 
  border-radius: 5px;
  background-color: white;
}

.bd {
  height: 500px;
}

/*ui样式*/
.el-button {
  width: 84px;
}
</style>