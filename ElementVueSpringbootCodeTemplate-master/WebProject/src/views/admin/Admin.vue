<!-- hdw添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="12"><div class="grid-content bg-purple">
            <span class="logo-title">管理员操作界面</span>
            </div></el-col>
          <el-col :span="4"><div class="grid-content bg-purple-light">
            <!-- <el-button  plain size="mini" type="primary" @click="handleStart">Hello World</el-button> -->
          </div></el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple-light text-right">
              <router-link to="/home">
              <el-button type='success' plain size="middle" style="margin-left:10px">退出</el-button>
              </router-link>
              <!-- <span v-if="user != null">
                <span class="user">{{user.nick}}</span><el-button  plain size="mini"  type="danger" @click="logout">退出</el-button>
              </span>
              <span v-else><el-button type="success" plain size="mini" @click="loginOpen">点击登陆</el-button></span> -->
              <!-- <el-dropdown  @command="switchLang">
                <el-button  plain size="mini"  type="primary">
                  {{lang.startsWith('zh') ? '中': 'En' }}<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">中</el-dropdown-item>
                  <el-dropdown-item command="en">En</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown> -->
            </div></el-col>
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
      <LoginDialog :show='showLogin'/>
    </el-container>
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