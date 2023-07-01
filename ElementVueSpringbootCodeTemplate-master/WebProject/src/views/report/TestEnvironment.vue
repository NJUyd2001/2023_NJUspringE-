<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px " @back="goback">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/test' }">测试部主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/TestReportCover">测试报告声明</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/Report">测试报告</a></el-breadcrumb-item>
      </el-breadcrumb>
      <br>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="10">
            <router-link to="/test">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="12" ><div class="grid-content bg-purple">
            <h1 style="margin-left: 70px;">测试环境</h1>
            </div></el-col>
          <el-col :span="6" push="5">
            <router-link to="/report">
            <el-button style="margin-top: 5px; margin-left: -60px;" size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
            <el-form :label-position="top" label-width="40%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;">
            <el-label>硬件环境</el-label>
            <el-table :data="tableData1" :span-method="objectSpanMethod" style="width: 50%; margin-left: 25%;">
            <el-table-column fixed prop="HardwareCategory" label="硬件类别" width="90">
                <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.HardwareCategory" :rows="2"  placeholder="Please input"/>
                </template>
            </el-table-column>
            <el-table-column prop="HardwareName" label="硬件名称" width="100">
                <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.HardwareName" :rows="2"  placeholder="Please input"/>
                </template>
            </el-table-column>
            <el-table-column prop="Setting" label="配置" width="350">
                <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.Setting" :rows="2"  placeholder="Please input"/>
                </template>
            </el-table-column>
            <el-table-column prop="Quantity" label="数量" width="140">
                <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.Quantity" :rows="2"  placeholder="Please input"/>
                </template>
            </el-table-column>
          </el-table>

            <el-label>软件环境</el-label>
                <el-table :data="tableData2" :span-method="objectSpanMethod" style="width: 50%; margin-left: 25%;">
                <el-table-column fixed prop="SoftwareCategory" label="软件类别" width="90">
                </el-table-column>
                <el-table-column prop="SoftwareName" label="软件名称" width="490">
                    <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.SoftwareName" :rows="2"  placeholder="Please input"/>
                </template>
                </el-table-column>
                <el-table-column prop="Edition" label="版本" width="100">
                    <template slot-scope="scope">
                    <el-input :type="input_type" ref="enterInput" v-model="scope.row.Edition" :rows="2"  placeholder="Please input"/>
                </template>
                </el-table-column>
            </el-table>
            <el-label>网络环境</el-label>
            <el-form-item>
              <el-label>二、测试依据和参考资料</el-label>
            </el-form-item>
            <el-form-item v-for="(Table,index) in ruleForm1.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"测试依据"+index+":"' :key="index" >
              <el-input placeholder="测试依据" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.NeededStandard"></el-input>
              <el-button @click="removefatherItem1(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem1()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
            <el-form-item v-for="(Table,index) in ruleForm2.TableData" :prop="'TableData.' + index + '.name'" :rules="{
            required: true,
            message: '功能项目不能为空！',
            trigger: 'blur',
          }" :label='"参考资料"+index+":"' :key="index" >
              <el-input placeholder="参考资料" style="width: 300px;padding-right:20px;" type="textarea" v-model="Table.ReferenceMaterial"></el-input>
              <el-button @click="removefatherItem2(Table)" type="primary" size="small">删除</el-button>
              <el-button @click="addfatherItem2()" type="primary" size="small">增加功能项目</el-button>
            </el-form-item>
        </el-form>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>

    <script>
    export default {
        data(){
           return{    
            input_type:'text',
            tableData1: [{
                HardwareCategory: '',
                HardwareName: '',
                Setting: '',
                Quantity: '',
            }],
            tableData2: [{
                SoftwareCategory:'操作系统',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'软件',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'软件',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'软件',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'辅助工具',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'开发工具',
                SoftwareName:'',
                Edition:'',
            },{
                SoftwareCategory:'被测试样品',
                SoftwareName:'',
                Edition:'',
            }],
            ruleForm1:{
                    NeededStandard:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
            },
            ruleForm2:{
                    ReferenceMaterial:'',
                TableData:[
                  {
                    id:1,
                    name:'',
                    function:'',
                    children:[],
                },
              ],
            },
        }
        },
        methods:{
        goback(){
        },
        list(){
          this.input_type = 'textarea'
           this.$nextTick(function () { 
               if (this.$refs.enterInput) {
               this.$refs.enterInput.resizeTextarea();
               } 
           });
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
    }
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
    .el-input{
        padding:15px,
        
    }
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    span.logo-title{
      font-size: 30px;
      font-weight: bold;
    }
    </style>
