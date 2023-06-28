<!-- 黄大伟添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/Market' }">客户主页-委托进度-审核报价</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/auditapplication">审核报价</a></el-breadcrumb-item>
      </el-breadcrumb>
      <br>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="10">
            <router-link to="/Market">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="12"><div class="grid-content bg-purple">
            <span class="logo-title">委托进度-审核报价单</span>
            </div></el-col>
            <el-col :span="2">
             <router-link to="/Test">
                  <el-button type="success" style="margin: 14px">完成</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br>
        <el-main style="border-radius: 30px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);rgba(0, 208, 255, 0.451);">
          <el-form  disabled :model="ruleForm" ref="ruleForm" style="background-color: rgba(0, 208, 255, 0.451);">
            <el-row type="flex" justify="center" >
            <el-col :span="5">
            <el-form-item label="户名:">
              南京大学
            </el-form-item>
            </el-col>
            <el-col :span="10">
            <el-form-item label="开户银行:">
            中国工商银行股份有限公司南京汉口路分理处
            </el-form-item>
            </el-col>
            <el-col :span="5">
            <el-form-item label="账号:">
                4301011309001041656
            </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
            <el-col :span="20">
            <el-form-item disabled label="有效期：">
                <div class="block">
                    <el-date-picker
                    v-model="ruleForm.Time"
                    type="daterange"
                    range-separator="至"
                    start-placeholder="报价日期"
                    end-placeholder="报价有效期">
                    </el-date-picker>
                </div>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="20">
                <el-form-item  label="软件名称：">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.SoftwareName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="5">
                <el-form-item  label="项目：">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.item"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="5">
                <el-form-item  label="说明：">
                    <el-input style="width: 200px;padding:10px;" :autosize="{ minRows: 3, maxRows: 8}" type="textarea" v-model="ruleForm.descrption"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="3">
                <el-form-item  label="单价:￥">
                    <el-input style="width: 100px;padding:10px;"  v-model="ruleForm.UnitPrice"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="7">
                <el-form-item  label="备注：">
                    <el-input style="width: 200px;padding:10px;" :autosize="{ minRows: 3, maxRows: 8}" type="textarea" v-model="ruleForm.descrption"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="6">
                <el-form-item  label="小计:￥">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.SubTotalPrice"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="6">
                <el-form-item disabled label="税率(3%):￥">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.Tax"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item disabled label="总计:￥">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.TotalPrice"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="20">
                <el-form-item disabled label="报价提供人：">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.Provider"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
      </el-form>
      <el-divider></el-divider>
      <el-form  :model="Suggestion">
        <el-row type="flex" justify="center">
        <el-col :span="3">
          <el-radio v-model="Suggestion.Pass" label="false">拒绝</el-radio>
          <el-radio v-model="Suggestion.Pass" label="true">同意</el-radio>
        </el-col>
        </el-row>
        <br>
        <el-row type="flex" justify="center">
             <el-col :span="20">
                <el-form-item  label="如果接受报价，请上传签字：">
                      <el-upload
                          class="upload-demo"
                          drag
                          action="https://jsonplaceholder.typicode.com/posts/"
                          multiple>
                          <i class="el-icon-upload"></i>
                          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
                      </el-upload>
                </el-form-item>
            </el-col>
        </el-row>
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
                ruleForm:{
                  Time:'',
                  SoftwareName:"",
                  item:"",
                  descrption:"",
                  UnitPrice:0,
                  PS:"",
                  SubTotalPrice:0,
                  Tax:0,
                  TotalPrice:0,
                  Provider:"",
                },
                Suggestion:{
                  Pass:"false",
                },
                shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
                }],
                rules:{
                  SoftwareName:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  Versions:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  }
        }
    }, 
      methods:{
        goback(){
        },
        addfatherItem(){
          this.ruleForm.TableData.push({
            id:this.ruleForm.TableData[this.ruleForm.TableData.length-1]+1,
            name:'',
            function:'',
            children:[],
          })
        },
        removefatherItem(Table){
          const index = this.ruleForm.TableData.indexOf(Table)
          if (index !== -1) {
          this.ruleForm.TableData.splice(index, 1);
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
          setTimeout(() => {this.$router.push({path: "./client", replace:true});}, 2000);
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
    .el-input{
        padding:15px,
        
    }
    
    .el-menu-vertical-demo:not(.el-menu--collapse) {
      width: 200px;
      height: 100%;
    }
    
    span.logo-title{
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