<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report">测试报告</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/testcontent">测试内容</a></el-breadcrumb-item>
      </el-breadcrumb>
      <br>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/report">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" push="3"><div class="grid-content bg-purple">
            <span class="logo-title">测试内容</span>
            </div></el-col>
            <el-col :span="6" pull="3">
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span><el-button  plain size="middle"  type="danger" @click="logout">退出</el-button>
              </span>
              <span v-else><el-button type="success" plain size="middle" style = "margin:10px" @click="loginOut">登出</el-button></span>
              <el-dropdown  @command="switchLang">
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">En</el-dropdown-item>
                  <el-dropdown-item command="en">中</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div></el-col>
          <el-col :span="6" push="4">
            <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form style="padding-top:30px;" label-width="500px" :model="ruleForm1" :rules="rules" ref="ruleForm1">
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"功能性测试"+index+":"' :key="index" >
              <el-input placeholder="功能模块" style="width: 100px;padding-right:20px;" v-model="Table.functionmodule"></el-input>
              <el-input placeholder="功能要求" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.functionrequirement"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult1"></el-input>
              <el-button @click="removefatherItem1(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem1()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm2" :rules="rules" ref="ruleForm2">
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"效率测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.testcharacteristic1"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.testspecification1"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult2"></el-input>
              <el-button @click="removefatherItem2(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem2()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm3" :rules="rules" ref="ruleForm3">
            <el-form-item v-for="(Table,index) in ruleForm3.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可移植性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.testcharacteristic2"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.testspecification2"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult3"></el-input>
              <el-button @click="removefatherItem3(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem3()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm4" :rules="rules" ref="ruleForm4">
            <el-form-item v-for="(Table,index) in ruleForm4.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"易用性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.testcharacteristic3"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.testspecification3"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult4"></el-input>
              <el-button @click="removefatherItem4(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem4()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm5" :rules="rules" ref="ruleForm5">
            <el-form-item v-for="(Table,index) in ruleForm5.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可靠性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.testcharacteristic4"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.testspecification4"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult5"></el-input>
              <el-button @click="removefatherItem5(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem5()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
          <el-form label-width="500px" :model="ruleForm6" :rules="rules" ref="ruleForm6">
            <el-form-item v-for="(Table,index) in ruleForm6.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"可维护性测试"+index+":"' :key="index" >
              <el-input placeholder="测试特性" style="width: 100px;padding-right:20px;" v-model="Table.testcharacteristic5"></el-input>
              <el-input placeholder="测试说明" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.testspecification5"></el-input>
              <el-input placeholder="测试结果" style="width: 100px;padding-right:20px;" v-model="Table.testresult6"></el-input>
              <el-button @click="removefatherItem6(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem6()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
          </el-form>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
    export default {
        data(){
           return{
                user:{
                    name:'风车村',
                    password:'shazihuang',
                    telephone:'',
                    fax:'',
                    address:'',
                    postcode:'',
                    contacts:'',
                    mobilephone:'',
                    email:'',
                    URL:'',
                },
                ruleForm1:{
                    functionmodule:'',
                    functionrequirement:'',
                    testresult1:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                },
                rules:{
                  
                  },
                  ruleForm2:{
                  testcharacteristic1:'',
                  testspecification1:'',
                  testresult2:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                },
                ruleForm3:{
                  testcharacteristic2:'',
                  testspecification2:'',
                  testresult3:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                }
                ,
                ruleForm4:{
                  testcharacteristic3:'',
                  testspecification3:'',
                  testresult4:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                }
                ,
                ruleForm5:{
                  testcharacteristic4:'',
                  testspecification4:'',
                  testresult5:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                }
                ,
                ruleForm6:{
                  testcharacteristic5:'',
                  testspecification5:'',
                  testresult6:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
                }
        }
    }, 
      methods:{
        goback(){
        },
        addfatherItem1(){
          this.ruleForm1.TableData.push({
            id:this.ruleForm1.TableData[this.ruleForm1.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem1(Table){
          const index = this.ruleForm1.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm1.TableData.splice(index, 1);
      }
        },
        addfatherItem2(){
          this.ruleForm2.TableData.push({
            id:this.ruleForm2.TableData[this.ruleForm2.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem2(Table){
          const index = this.ruleForm2.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm2.TableData.splice(index, 1);
      }
        },
        addfatherItem3(){
          this.ruleForm3.TableData.push({
            id:this.ruleForm3.TableData[this.ruleForm3.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem3(Table){
          const index = this.ruleForm3.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm3.TableData.splice(index, 1);
      }
        },
        addfatherItem4(){
          this.ruleForm4.TableData.push({
            id:this.ruleForm4.TableData[this.ruleForm4.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem4(Table){
          const index = this.ruleForm4.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm4.TableData.splice(index, 1);
      }
        },
        addfatherItem5(){
          this.ruleForm5.TableData.push({
            id:this.ruleForm5.TableData[this.ruleForm5.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem5(Table){
          const index = this.ruleForm5.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm5.TableData.splice(index, 1);
      }
        },
        addfatherItem6(){
          this.ruleForm6.TableData.push({
            id:this.ruleForm6.TableData[this.ruleForm6.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem6(Table){
          const index = this.ruleForm6.TableData.indexOf(Table)
          if (index !== 0) {
          this.ruleForm6.TableData.splice(index, 1);
      }
        },
        addchildrenItem(Node){
            Node.children.push(
              {
                id:'',
                
              }
            )
        },
        submitForm(formName) {
          /*this.$refs[formName].validate((valid) => {
            if (valid) {
              alert("submit!");
              this.$router.push({path: "./client", replace:true});
            } else {
              return false;
            }
          });*/
          this.info("提交成功，正在返回用户界面！");
          setTimeout(() => {this.$router.push({path: "./Test", replace:true});}, 2000);
        }
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
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    .logo-title{
      font-size: 20px;
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