<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
          <el-breadcrumb-item :to="{ path: '/Test' }">测试部主页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/testcheckreport">测试报告</a></el-breadcrumb-item>
        </el-breadcrumb>
        </el-col>
        <el-col :span="2">
          <el-button style="margin-top: 5px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="8">
            <router-link to="/Test">
            <el-button style="margin-top: 15px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" style="margin-left: 35%;"><div class="grid-content bg-purple">
          <span class="lt1">测试报告</span>
          </div></el-col>
          <el-col :span="2">
            <el-button style="margin-top: 15px; margin-left: 70px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <el-main>
          <br><br>
          <el-form disabled style="margin-top: 60px; margin-left: 10%;" label-position="middle" label-width="500px" :model="ruleForm" :rules="rules" ref="ruleForm" >
          <el-form-item label="委托单位:" prop="Client">  
            <el-input style="width:200px;padding:10px;" v-model="ruleForm.Client"></el-input>
          </el-form-item>
          <el-form-item label="项目编号:" prop="ProjectNum"> 
            <el-input style="width:200px;padding:10px" v-model="ruleForm.ProjectNum"></el-input>
          </el-form-item>
          <el-form-item label="样品名称:" prop="SampleName"> 
            <el-input style="width:200px;padding:10px" v-model="ruleForm.SampleName"></el-input>
          </el-form-item> 
          <el-form-item label="版本/型号:" prop="Version"> 
            <el-input style="width:200px;padding:10px" v-model="ruleForm.Version"></el-input>
          </el-form-item> 
          <el-form-item label='来样日期:' prop="SampleDate">
              <div class="demo-date-picker">
                <el-date-picker
                v-model="ruleForm.SampleDate"
                type="date"
                placeholder="时间选择"
                :size=large
                />
                </div>
            </el-form-item>
          <el-form-item label="测试类型:" prop="TypeTest">  
             <el-input style="width:200px;padding:10px;" v-model="ruleForm.TypeTest"></el-input>
          </el-form-item>
          <el-form-item label="测试时间:" prop="TestTime">
                <el-date-picker
                style="margin-left: 20px;"
                v-model="ruleForm.TestTime"
                type="daterange"
                range-separator="To"
                start-placeholder="起始时间"
                end-placeholder="预计完成时间"
                />
          </el-form-item>
          <el-form-item  style="margin-top: 20px;" label="测试单位:" prop="DevelopmentCompany">  
             <el-input style="width:200px;padding:10px;" v-model="ruleForm.DevelopmentCompany"></el-input>
          </el-form-item>
            <el-form-item label="样品状态:" prop="SampleStatus">
              <el-input style="width:500px;margin-top: 15px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="ruleForm.SampleStatus" type="textarea" />
            </el-form-item>
            <el-form-item label="测试依据:" prop="NeededStandard">
              <el-select style="margin-top: 20px;" v-model="ruleForm.NeededStandard" multiple allow-create filterable>
            <el-option v-for='item in Standard' :key='item.id' :label="item.value" :value="item.value"></el-option>
            </el-select>
            </el-form-item> 
            <el-form-item label="样品清单:" prop="SampleList">
              <el-input style="width:500px;margin-top: 15px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="ruleForm.SampleList" type="textarea" />
            </el-form-item>
            <el-form-item label="测试结论:" prop="TestConclusion">
              <el-input style="width:500px;margin-top: 15px;" :autosize="{ minRows: 2, maxRows: 4 }" 
              v-model="ruleForm.TestConclusion" type="textarea" />
            </el-form-item>
            <el-form-item style="margin-top: 15px; " label="编制人:" prop="Organizer"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Organizer"></el-input>
            <el-form-item style="margin-top: -50px;"  label-width="330px" label="日期:" prop="SampleDate1"> 
                <div class="block1" style="margin-top: 0px; margin-left: 0px;">
                    <el-date-picker
                    v-model="ruleForm.SampleDate1"
                    type="date"
                    placeholder="Pick a day">
                    </el-date-picker>
                </div>
            </el-form-item>
            </el-form-item>
            <el-form-item style="margin-top: 15px; " label="审核人:" prop="Auditor"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Auditor"></el-input>
            <el-form-item style="margin-top: -50px;"  label-width="330px" label="日期:" prop="SampleDate2"> 
                <div class="block2" style="margin-top: 0px; margin-left: 0px;">
                    <el-date-picker
                    v-model="ruleForm.SampleDate2"
                    type="date"
                    placeholder="Pick a day">
                    </el-date-picker>
                </div>
            </el-form-item>
            </el-form-item>
            <el-form-item style="margin-top: 15px;" label="批准人:" prop="Approver"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Approver"></el-input>
            <el-form-item style="margin-top: -50px;"  label-width="330px" label="日期:" prop="SampleDate3"> 
                <div class="block3" style="margin-top: 0px; margin-left: 0px;">
                    <el-date-picker
                    v-model="ruleForm.SampleDate3"
                    type="date"
                    placeholder="Pick a day">
                    </el-date-picker>
                </div>
            </el-form-item>
            </el-form-item>
        </el-form>
        <el-button style="margin-left: 45%; font-size: 1rem;" @click="submitForm('ruleForm')" type="success" plain round>通过</el-button>
        <el-button style="margin-left: 5%; font-size: 1rem;" @click="submitForm('ruleForm')" type="warning" plain round>拒绝</el-button>
        <el-form  style="margin-top: 20px;" label-width="550px" :model="ruleForm" :rules="rules" ref="ruleForm">
          <el-form-item label="审核意见：" prop="Views">
          <el-input style="width:700px;" :rows="5" v-model="ruleForm.Views" type="textarea" ></el-input>
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
                ruleForm:{
                    Client:'',
                    ProjectNum:'',
                    SampleName:'',
                    Version:'',
                    SampleDate:'',
                    TypeTest:'',
                    TestTime:'',
                    DevelopmentCompany:'',
                    SampleStatus:'',
                    NeededStandard:'',
                    SampleList:'',
                    TestConclusion:'',
                    Organizer:'',
                    SampleDate1:'',
                    Auditor:'',
                    SampleDate2:'',
                    Approver:'',
                    SampleDate3:'',
                    Views:'',
                },
                shortcuts:[
                {
                  text: 'Today',
                  value: new Date(),
                },
                {
                  text: 'Yesterday',
                  value: () => {
                    const date = new Date()
                    date.setTime(date.getTime() - 3600 * 1000 * 24)
                    return date
                  },
                },
                {
                  text: 'A week ago',
                  value: () => {
                    const date = new Date()
                    date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
                    return date
                  },
                },
                ],
                rules:{
                Client:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                ProjectNum:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleName:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Version:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleDate:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TypeTest:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestTime:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                DevelopmentCompany:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleStatus:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                NeededStandard:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleList:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                TestConclusion:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Organizer:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleDate1:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Auditor:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleDate2:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Approver:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                SampleDate3:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Views:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                }
        }
    }, 
      methods:{
        goback(){
        },
        remove(obj){
          var tr = $j(obj).parent ().parent()
          tr.prev().remove();
          tr.prev().remove();
          tr.remove();
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
          this.$message.success("提交成功，正在返回用户界面！");
          setTimeout(() => {this.$router.push({path: "./Client", replace:true});}, 2000);
        }
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
    
    span.lt1{
      font-size: 30px;
      font-weight: bold;
      margin-left: -350px;
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

    .box {
      background-color: whitesmoke;
      padding: 20px;
      margin: 40px;
    }

    h3 {
      text-align: center;
      text-transform: uppercase;
      font-weight: bold;
    }

    .form-wrap {
      margin: 20px 0;
    }

    .table {
      border: 1px solid;
      width: 100%;
    }

    .th, td {
      border: 1px solid;
    }
    </style>