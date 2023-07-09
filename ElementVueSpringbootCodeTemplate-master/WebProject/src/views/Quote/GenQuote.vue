<!-- 黄大伟添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px ">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '/Market' }">市场部主页-委托进度-生成报价</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/auditapplication">生成报价</a></el-breadcrumb-item>
      </el-breadcrumb>
      <br>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="2">
            <router-link to="/Market">
            <el-button  size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="22"><div class="grid-content bg-purple">
            <span class="logo-title">委托进度-生成报价单</span>
            </div></el-col>
            <el-col :span="2">
            <el-button  @click="submitForm('ruleForm')" type="success" style="margin: 14px">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br><br>
        <el-main style="border-radius: 30px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);">
          <el-form   :model="ruleForm" :rules="rules" ref="ruleForm" >
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
            <el-form-item label="有效期：" prop="Time">
                    <el-date-picker
                    v-model="ruleForm.Time"
                    type="daterange"
                    range-separator="至"
                    start-placeholder="报价日期"
                    end-placeholder="报价有效期">
                    </el-date-picker>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="20">
                <el-form-item label="软件名称：" prop="SoftwareName">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.SoftwareName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center" >
             <el-col :span="5">
                <el-form-item label="项目：" prop="item">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.item"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="5">
                <el-form-item label="说明：" prop="description">
                    <el-input style="width: 200px;padding:10px;" :autosize="{ minRows: 3, maxRows: 8}" type="textarea" v-model="ruleForm.description"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="3">
                <el-form-item label="单价:￥" prop="UnitPrice">
                    <el-input style="width: 100px;padding:10px;"  v-model="ruleForm.UnitPrice"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="7">
                <el-form-item label="备注：">
                    <el-input style="width: 200px;padding:10px;" :autosize="{ minRows: 3, maxRows: 8}" type="textarea" v-model="ruleForm.PS"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="6">
                <el-form-item label="小计:￥" prop="SubTotalPrice">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.SubTotalPrice"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="6">
                <el-form-item label="税率(3%):￥"  prop="Tax">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.Tax"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="总计:￥" prop="TotalPrice">
                    <el-input style="width: 100px;padding:10px;" v-model="ruleForm.TotalPrice"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center">
             <el-col :span="20">
                <el-form-item label="报价提供人："  prop="Provider">
                    <el-input style="width: 200px;padding:10px;" v-model="ruleForm.Provider"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
          </el-form>
        </el-main>
    </el-container>
    </template>
    <el-backtop :right="50" :bottom="50" />
    <script>
  import Axios from 'axios'
    export default {
        data(){
           return{
            userid:{
              UID:"",
            },
            GenQ:{
              PID:this.$store.state.user.process.PID,
              state:"20",
            },
            ruleForm:{
                  PID:"",
                  Time:"",
                  SoftwareName:"",
                  item:"",
                  description:"",
                  UnitPrice:"",
                  PS:"",
                  SubTotalPrice:"",
                  Tax:"",
                  TotalPrice:"",
                  Provider:"",
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
                 item:[
                    { required: true, message: "不能为空！", trigger: "blur"  },
                  ],
                  description:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                        Tax:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  UnitPrice:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  SubTotalPrice:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  TotalPrice:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  Provider:[
                          { required: true, message: "不能为空！", trigger: "blur" },
                        ],
                  Time:[
                          { required: true, message: "请选择日期！", trigger: "change" },
                        ],
                  }
        }
    },
    created(){
      this.KeepInfor();
      this.userid.UID=this.$store.state.user.process.UID;
      Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.userid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data);
                this.ruleForm.PID=ret.data.PID;
              })
    },
    mounted() {
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
          console.log(this.ruleForm.Time);
          this.$refs[formName].validate((valid) => {
            if (valid) {
               Axios.post("http://localhost:9090/api/process/updateState",JSON.stringify(this.GenQ),{
              headers:{
                'content-type': 'text/plain'}
              }).then(ret=>{
             })
              Axios.post("http://localhost:9090/api/quote/insert",JSON.stringify(this.ruleForm),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data)
                this.$message.success("提交成功，正在返回市场部界面！");
                 setTimeout(() => {this.$router.push({path: "./market", replace:true});}, 2000);
              })
             
            } else {
              return false;
            }
          });
          
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
      font-size: 30px;
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