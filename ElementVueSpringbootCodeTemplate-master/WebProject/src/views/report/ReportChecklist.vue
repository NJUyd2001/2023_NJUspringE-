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
          <el-col :span="12"><div class="grid-content bg-purple">
            <span class="logo-title">测试报告检查表</span>
            </div></el-col>
            <el-col :span="10" style="margin-left: 10%">
              <el-steps :space="200" :active="0" finish-status="success">
                <el-step title="测试报告填写"></el-step>
                <el-step title="检查表填写"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
          <el-col :span="6">
            <el-button size="middle" @click="submitForm('ruleForm')" type="success">下一步</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br><br>
        <el-main>
          <el-form label-position="middle" label-width="40%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-row>
              <el-col  :span="12">
            <el-form-item label="软件名称:" prop="SoftWareName"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.SoftWareName"></el-input>
          </el-form-item>
              </el-col>
            <el-col :span="12">
            <el-form-item  label="委托单位:" prop="Client"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Client"></el-input>
          </el-form-item>
        </el-col>
        </el-row>
          <el-table :data="ruleForm.tableData"  style="width: 60%; margin-left: 20%;">
            <el-table-column fixed prop="num" label="序号" width="80"></el-table-column>
            <el-table-column prop="checkcontent" label="检查内容" width="140"></el-table-column>
            <el-table-column prop="description" label="内容描述" width="450"></el-table-column>
            <el-table-column prop="checkresult" label="检查结果" width="120" >
              <template slot-scope="scope" >
                <el-radio-group v-model="scope.row.radio" v-if="scope.$index !== 10">
                <el-radio value="1" label="1" >通过</el-radio>
                <el-radio value="2" label="2" >不通过</el-radio>
                </el-radio-group>
              </template>
            </el-table-column>
          </el-table>
          <br>
              <el-row>
                <el-col :span="12">
                  <el-form-item label='检查人:' prop="Examiner">
                    <el-input style="width:200px; " v-model="ruleForm.Examiner"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item  label='日期:' prop="Date">
                      <div class="demo-date-picker">
                        <el-date-picker
                        v-model="ruleForm.Date"
                        type="date"
                        placeholder="时间选择"
                        size="large"
                        />
                        </div>
                  </el-form-item>
                </el-col>
              </el-row>
          </el-form>
        </el-main>
    </el-container>
    </template>
    <script>
    import Axios from 'axios'
    export default {
        data(){
           return{
            number:1,
            useruid:{
              UID:"",
            },
            userpid:{
              PID:"",
            },
            ruleForm:{
            PID:"",
            SoftWareName:'',
            Client:'',
            Examiner:'',
            Date:'',
            tableData: [{
            num: '1',
            checkcontent: '报告编号',
            description: '检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。',
            radio: '',
            }, {
            num: '2',
            checkcontent: '页码',
            description: '检查页码与总页数是否正确（报告首页与每页页眉）。',
            radio: '',
            }, {
            num: '3',
            checkcontent: '软件名称',
            description: '是否和确认单一致，是否前后一致（共三处，包括首页、报告页、附件三）。',
            radio: '',
            }, {
            num: '4',
            checkcontent: '版本号',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '',
            }, {
            num: '5',
            checkcontent: '委托单位',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '',
            }, {
            num: '6',
            checkcontent: '完成日期',
            description: '是否和确认单一致，是否前后一致（共二处，包括首页、报告页）。',
            radio: '',
            }, {
            num: '7',
            checkcontent: '委托单位地址',
            description: '是否和确认单一致（共一处，报告页）。',
            radio: '',
            }, {
            num: '8',
            checkcontent: '序号',
            description: '附件二、附件三中的序号是否正确、连续。',
            radio: '',
            }, {
            num: '9',
            checkcontent: '测试样品',
            description: '样品名称是否正确，数量是否正确。',
            radio: '',
            }, {
            num: '10',
            checkcontent: '软、硬件列表',
            description: '列表是否完整（如打印机），用途描述是否合理正确。',
            radio: '',
            }, {
            num: '11',
            description: '文字、内容、格式',
            }, {
            num: '11.1',
            checkcontent: '错别字',
            description: '报告中是否还有错别字。',
            radio: '',
            }, {
            num: '11.2',
            checkcontent: '语句',
            description: '报告的语句是否通顺合理；每个功能描述结束后是否都有句号。',
            radio: '',
            }, {
            num: '11.3',
            checkcontent: '格式',
            description: '报告的格式是否美观，字体是否一致，表格大小是否一致。（如无特殊情况请尽量不要将报告页中的表格分为2页。）',
            radio: '',
            }, {
            num: '12',
            checkcontent: '用户文档测试报告',
            description: '语句是否通顺，是否准确描述用户的文档。',
            radio: '',
        }],
            },
            shortcuts: [{
            text: 'Today',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
            }, {
              text: 'Yesterday',
              onClick(picker) {
                const date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24);
                picker.$emit('pick', date);
              }
            }, {
              text: 'A week ago',
              onClick(picker) {
                const date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                picker.$emit('pick', date);
              }
            }],
        rules:{
          SoftWareName:[
                  { required: true, message: "不能为空！", trigger: "blur" },
          ],
          Client:[
            { required: true, message: "不能为空！", trigger: "blur" },
          ],
          radio:[
                  { required: true, message: "不能为空！", trigger: "blur" },
          ],
          Examiner:[
                  { required: true, message: "不能为空！", trigger: "blur" },
          ],
          Date:[
                  { required: true, message: "不能为空！", trigger: "blur" },
          ],
          
        }
      }
    },
    created(){
    //在页面加载时读取sessionStorage里的状态信息
    this.KeepInfor();
    this.useruid.UID=this.$store.state.user.id;
    //this.useruid.UID=17;
    Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.useruid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data)
                this.userpid.PID=ret.data.PID;
                this.ruleForm.PID=this.userpid.PID;
              })
    //this.userpid.PID=20;
    //this.ruleForm.PID=this.userpid.PID;
  },  
    mounted(){
  window.addEventListener('beforeunload', this.handleBeforeUnload);
  window.addEventListener('unload', this.handleUnload);
},
      methods:{
        handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
        },
        handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
          },
        handleClick() {
        console.log('click');
      },
        operation(row){
        console.log(row);
      },
      passcheck()
      {
        console.log('1');
      },
      submitForm(formName) {
          Axios.post("http://localhost:9090/api/reportcheck/insert",JSON.stringify(this.ruleForm),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
            console.log(ret.data);
            this.$message.success("提交成功！");
          setTimeout(() => {this.$router.push({path: "./testdocument2", replace:true});}, 2000);
            })
          }
    }
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
