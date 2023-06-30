<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/#/report">测试报告</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/ReportChecklist">测试报告检查表</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button style="margin-top: 10px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/report">
            <el-button style="margin-top: 15px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="12" push="3"><div class="grid-content bg-purple">
            <span class="logo-title">测试报告检查表</span>
            </div></el-col>
            <el-col :span="10" style="margin-left: 10%">
              <el-steps :space="200" :active="0" finish-status="success">
                <el-step title="测试报告填写"></el-step>
                <el-step title="检查表填写"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
            <el-col :span="6" pull="3">
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span>
              </span>
              <el-dropdown  @command="switchLang">
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">En</el-dropdown-item>
                  <el-dropdown-item command="en">中</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div></el-col>
          <el-col :span="6" push="2">
            <el-button style="margin-top: 15px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form :label-position="top" label-width="40%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;">
            <el-form-item style="margin-top: 80px; margin-right: 150px;" label="软件名称:" prop="SoftWareName"> 
            <el-input style="width:200px; padding:10px;" v-model="SoftWareName"></el-input>
            <el-form-item style="margin-top: -60px; margin-right: 120px;" label="委托单位:" prop="Client"> 
            <el-input style="width:200px; padding:10px;" v-model="Client"></el-input>
          </el-form-item>
          </el-form-item> 
          <el-table :data="tableData"  style="width: 60%; margin-left: 25%;">
            <el-table-column fixed prop="num" label="序号" width="80"></el-table-column>
            <el-table-column prop="checkcontent" label="检查内容" width="140"></el-table-column>
            <el-table-column prop="description" label="内容描述" width="450"></el-table-column>
            <el-table-column prop="checkresult" label="检查结果" width="120">
              <template slot-scope="scope">
                <el-radio  v-model="radio" label="1">通过</el-radio>
                <el-radio  v-model="radio" label="2">不通过</el-radio>
              </template>
            </el-table-column>
          </el-table>
          <el-form-item style="margin-right: 20%; margin-top: 20px; font-weight: bold;" label="检查人：" prop="Examiner"> 
            <el-input style="width:200px; padding:10px;" v-model="Examiner"></el-input>
          </el-form-item>
          </el-form>
          <div class="block">
            <span class="demonstration">日期：</span>
            <el-date-picker
              v-model="value1"
              type="date"
              placeholder="Pick a day">
            </el-date-picker>
          </div>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>

    <script>
    export default {
        data(){
           return{
            SoftWareName:'',
            Client:'',
            radio:'',
            Examiner:'',
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
            pickerOptions: {
            disabledDate(time) {
            return time.getTime() > Date.now();
            },
            value1: '',
            },
            tableData: [{
            num: '1',
            checkcontent: '报告编号',
            description: '检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。',
            radio: '1',
            }, {
            num: '2',
            checkcontent: '页码',
            description: '检查页码与总页数是否正确（报告首页与每页页眉）。',
            radio: '1',
            }, {
            num: '3',
            checkcontent: '软件名称',
            description: '是否和确认单一致，是否前后一致（共三处，包括首页、报告页、附件三）。',
            radio: '1',
            }, {
            num: '4',
            checkcontent: '版本号',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '1',
            }, {
            num: '5',
            checkcontent: '委托单位',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '1',
            }, {
            num: '6',
            checkcontent: '完成日期',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '1',
            }, {
            num: '7',
            checkcontent: '委托单位地址',
            description: '是否和确认单一致（共一处，报告页）。',
            radio: '1',
            }, {
            num: '8',
            checkcontent: '序号',
            description: '附件二、附件三中的序号是否正确、连续。',
            radio: '1',
            }, {
            num: '9',
            checkcontent: '测试样品',
            description: '样品名称是否正确，数量是否正确。',
            radio: '1',
            }, {
            num: '10',
            checkcontent: '软、硬件列表',
            description: '列表是否完整（如打印机），用途描述是否合理正确。',
            radio: '1',
            }, {
            num: '11',
            description: '文字、内容、格式',
            }, {
            num: '11.1',
            checkcontent: '错别字',
            description: '报告中是否还有错别字。',
            radio: '1',
            }, {
            num: '11.2',
            checkcontent: '语句',
            description: '报告的语句是否通顺合理；每个功能描述结束后是否都有句号。',
            radio: '1',
            }, {
            num: '11.3',
            checkcontent: '格式',
            description: '报告的格式是否美观，字体是否一致，表格大小是否一致。（如无特殊情况请尽量不要将报告页中的表格分为2页。）',
            radio: '1',
            }, {
            num: '12',
            checkcontent: '用户文档测试报告',
            description: '语句是否通顺，是否准确描述用户的文档。',
            radio: '1',
        }]
      }
    },
      methods: {
        handleClick() {
        console.log('click');
      }
    },
    }

   </script>

   <style>
   .logo-title {
     margin-left: 40%;
   }

   .block {
     margin-left: 55%;
     margin-top: -75px;
   }

   .span .logo-title {
     width: 200px;
   }

   </style>
