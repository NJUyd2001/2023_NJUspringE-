<!-- hdw添加 -->
<template>
  <div id="logo">
    <el-container style="height:100%">
      <el-header style="height: 10%;">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="8"><div class="grid-content bg-purple">
        <span style="font-size: 30px; font-weight: 1000;">管理员界面</span>
        </div></el-col>
        <el-col :span="12">
          <img src="../../assets/l3.png" style="height:80px"/>
        </el-col>
    </el-row>
  </el-header>
    
    
      <el-container>
        <el-aside style="width:auto;">
          <!--
          <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
            <el-radio-button :label="false" v-show="isCollapse">展开</el-radio-button>
            <el-radio-button :label="true"v-show="!isCollapse">收起</el-radio-button>
          </el-radio-group>
          -->
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            >
            <el-submenu index="1">
              <template slot="title" collapse=false>
                <i class="el-icon-location" @click="isCollapse = !isCollapse"></i>
                <span> 功能</span>
              </template>
              <el-menu-item-group>
                <template slot="title">委托功能栏</template>
                <el-menu-item index="1-11" @click="addTab('所有委托记录', 'DelegateRecordsTable')">所有委托记录</el-menu-item>
                <el-menu-item index="1-12" @click="addTab('测试文档审核', 'TestDocAuditTable')">测试文档审核</el-menu-item>
              </el-menu-item-group>
              <!-- <el-menu-item-group title="树">
                <el-menu-item index="1-21" @click="addTab('简单树', 'SimpleTree')">简单树</el-menu-item>
                <el-menu-item index="1-22" @click="addTab('简单的带图标树', 'SimpleTreeWithIcon')">简单的带图标树</el-menu-item>
              </el-menu-item-group> -->
            </el-submenu>
    
            <el-submenu index="9">
              <template slot="title" collapse=false>
                <i class="el-icon-setting"></i>
                <span>用户信息管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="9-1" @click="addTab('测试中心账号管理', 'ConfigTable')">测试中心账号管理</el-menu-item>
                <el-menu-item index="9-2" @click="addTab('客户管理', 'UserTable')">客户管理</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>      
          <el-tabs v-model="selectTabName" type="card" closable @tab-remove="removeTab">
            <el-tab-pane
              v-for="item in tabs"
              :key="item.name"
              :label="item.title"
              :name="item.name"
            >
              <component v-bind:is="item.currentView"></component>
            </el-tab-pane>
          </el-tabs>
        </el-main>
      </el-container>
      <el-footer style="height: 10%;">
        <p>南京大学 计算机软件新技术国家重点实验室 软件测试中心<br>
        江苏省 南京市 栖霞区 仙林大道163号南京大学仙林校区计算机科学与技术楼<br>
        电话025-89683467  传真025-89686596   Email: keysoftlab@nju.edu.cn</p>
      </el-footer>
      <LoginDialog :show='showLogin'/>
    </el-container>

    </div>
    </template>
    <script>
    import Vue from "vue";
    import Axios from "axios"
    export default {
      data() {
        return {
          showLogin: false,
          user: null,
          keyword: "",
          isCollapse: false,
    
          menus: [{}],
    
          //Tabs
          selectTabName: "ConfigAdd",
          tabs: {
            ConfigAdd: {
              title: "新建页面",
              name: "ConfigAdd",
              currentView: "ConfigAdd"
            }
          }
        };
      },
      computed: {
      },
      methods: {
        addTab(targetName, commentName) {
          // 如果已经存在
          if (this.tabs[commentName]) {
            this.selectTabName = commentName;
            return;
          }
          // add table
          this.$set(this.tabs, commentName, {
            title: targetName,
            name: commentName,
            currentView: commentName
          });
    
          this.selectTabName = commentName;
        },
        removeTab(targetName) {
          this.$delete(this.tabs, targetName);
    
          // 选中第一个tab
          for (let key in this.tabs) {
            this.selectTabName = key;
            break;
          }
        }
      }
    };
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
    
    /*
    * {
      outline: 1px solid;
    }
    */
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    span.logo-title{
      font-size: 30px;
      font-weight: bold;
    }
    </style>