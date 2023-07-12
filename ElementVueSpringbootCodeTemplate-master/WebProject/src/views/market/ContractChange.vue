<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px ">
    <el-breadcrumb separator="->">
    <el-breadcrumb-item :to="{ path: '/test' }">市场部主页</el-breadcrumb-item>
    <el-breadcrumb-item><a href="">在线合同草稿(修改)</a></el-breadcrumb-item>
  </el-breadcrumb>
  <br>
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="10">
        <router-link to="/test">
        <el-button  size="middle" type="danger">上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" ><div class="grid-content bg-purple">
        <h1>软件委托测试合同</h1>
        </div></el-col>
        <el-col :span="10">
        <el-steps :space="200" :active="stepNumber" finish-status="success">
          <el-step title="合同草稿修改"></el-step>
          <el-step title="完成"></el-step>
        </el-steps>
      </el-col>  
      <el-col :span="2">
        <el-button  size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
      </el-col>
    </el-row>
  </el-header>
    <br><br><br>
    <el-main>
      <br>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
        <el-form-item  label="项目名称:" label-width="650px" prop="ItemName">
          <el-input v-model="ruleForm.ItemName" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item label="委托方（甲方）:" label-width="650px" prop="Client">
          <el-input v-model="ruleForm.Client" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item  label="受托方（乙方）:" label-width="650px" prop="Trustee">
          <el-input v-model="ruleForm.Trustee" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item  label="质量特性:" label-width="650px" prop="QC">
          <el-input v-model="ruleForm.QC" style="width: 200px;"></el-input>
        </el-form-item>
        <el-form-item  label='签订日期:' label-width="650px" prop="date">
            <el-date-picker
            v-model="ruleForm.date"
            type="date"
            placeholder="完成时间选择"
            size=large
              />
        </el-form-item>
        <el-form-item  label='有效期至:' label-width="650px" prop="PeriodOfValidity"> 
            <el-date-picker
            v-model="ruleForm.PeriodOfValidity"
            type="date"
            placeholder="完成时间选择"
            size=large
              />
        </el-form-item>
        <el-form-item label="合同草稿(扫描件/word):" label-width="650px">
          <el-upload
            list-type="text"
              class="upload-demo"
              action="http://localhost:9090/api/file/upload"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUploadword"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              accept=".doc, .docx"
              :data="{ PID:this.$store.state.user.process.PID, state:'30', fileType:'contract' }"
              >
  <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
        </el-form-item>
      </el-form>
      <span >
        <h1>合同内容:</h1>
          <p id="ContractText">本合同由作为委托方的<strong>{{ruleForm.Client}}</strong>(以下简称“甲方”)与作为受托方的<strong>{{ruleForm.Trustee}}</strong>(以下简称“乙方”)在平等自愿的基础上，
            依据《中华人民共和国合同法》有关规定就项目的执行，经友好协商后订立。</p>
        <h3>一、任务表述</h3>
        <p id="ContractText">乙方按照国家软件质量测试标准和测试规范，完成甲方委托的软件<strong>{{ruleForm.SoftwareName}}</strong>(下称受测软件)的质量特性
          <strong>{{ruleForm.QC}}</strong>，进行测试，并出具相应的测试报告。</p>
        <h3>二、双方的主要义务</h3>
        <p id="ContractText">1. 甲方的主要义务:<br>
（1）按照合同约定支付所有费用。<br>
（2）按照乙方要求以书面形式出具测试需求，包括测试子特性、测试软硬件环境等。<br>
（3）提供符合交付要求的受测软件产品及相关文档，包括软件功能列表、需求分析、设计文档、用户文档至乙方。<br>
（4）指派专人配合乙方测试工作，并提供必要的技术培训和技术协助。<br></p>
<p id="ContractText">2. 乙方的主要义务：<br>
（1）设计测试用例，制定和实施产品测试方案。<br>
（2）在测试过程中，定期知会甲方受测软件在测试过程中出现的问题。<br>
（3）按期完成甲方委托的软件测试工作。<br>
（4）出具正式的测试报告。</p>
<h3>三、履约地点</h3>
<p id="ContractText">
  由甲方将受测软件产品送到乙方实施测试。
  如果由于被测软件本身特点或其它乙方认可的原因，需要在甲方所在地进行测试时，甲方应负担乙方现场测试人员的差旅和食宿费用。</p>
<h3>三、履约地点</h3>
<p id="ContractText">
  由甲方将受测软件产品送到乙方实施测试。如果由于被测软件本身特点或其它乙方认可的原因，
  需要在甲方所在地进行测试时，甲方应负担乙方现场测试人员的差旅和食宿费用。</p>
<h3>四、合同价款</h3>
<p id="ContractText">
  本合同软件测试费用为人民币<strong><input v-model="ruleForm.money" style="width: 50px;padding:10px;"></strong>(¥元)。</p>
  <h3>五、测试费用支付方式</h3>
<p id="ContractText">
  本合同签定后，十个工作日内甲方合同价款至乙方帐户。</p>
  <h3>六、履行的期限</h3>
<p id="ContractText">
  1.本次测试的履行期限为合同生效之日起<input v-model="ruleForm.ddl" style="width: 50px;padding:10px;">个自然日内完成。<br>
  2.经甲乙双方同意，可对测试进度作适当修改，并以修改后的测试进度作为本合同执行的期限。<br>
  3.如受测软件在测试过程中出现的问题，导致继续进行测试会影响整体测试进度，则乙方暂停测试并以书面形式通知甲方进行整改。在整个测试过程中，整改次数限于<input v-model="ruleForm.ChangeNumber" style="width: 50px;padding:10px;">次，
  每次不超过<input v-model="ruleForm.ChangeDay" style="width: 50px;padding:10px;">天。<br>
  4.如因甲方原因，导致测试进度延迟、应由甲方负责,乙方不承担责任。<br>
  5.如因乙方原因，导致测试进度延迟，则甲方可酌情提出赔偿要求，赔偿金额不超过甲方已付金额的50%。双方经协商一致后另行签订书面协议，作为本合同的补充。</p>
  <h3>七、资料的保密</h3>
<p id="ContractText">
  对于一方向另一方提供使用的秘密信息，另一方负有保密的责任，不得向任何第三方透露。
  为明确双方的保密义务，双方应签署《软件项目委托测试保密协议》，并保证切实遵守其中条款。 </p>
  <h3>八、 风险责任的承担</h3>
<p id="ContractText">
  乙方人员在本协议有效期间（包括可能的到甲方出差）发生人身意外或罹患疾病时由乙方负责处理。
  甲方人员在本协议有效期间（包括可能的到乙方出差）发生人身意外或罹患疾病时由甲方负责处理。
</p>
<h3>九、验收方法</h3>
<p id="ContractText">
  由乙方向甲方提交软件产品鉴定测试报告正本一份，甲方签收鉴定测试报告后，完成验收。
</p>
<h3>十、 争议解决</h3>
<p id="ContractText">
  双方因履行本合同所发生的一切争议，应通过友好协商解决；如协商解决不
成，就提交市级仲裁委员会进行仲裁。裁决对双方当事人具有同等约束力。
</p>
<h3>十一、 其他</h3>
<p id="ContractText">
  本合同自双方授权代表签字盖章之日起生效，自受托方的主要义务履行完毕之日起终止。           
  本合同未尽事宜由双方协商解决。
  本合同的正本一式肆份，双方各执两份，具有同等法律效力。
</p> 
</span>

</el-main>
</el-container>
</template>
<el-backtop :right="50" :bottom="50" />
<script>
import Axios from 'axios';
export default {
    data(){
       return{
            useruid:{
              UID:"",
            },
            userpid:{
              PID:"",
            },
            stepNumber:0,
            ruleForm:{
              PID:"",
              ItemName:'',
              Client:'',
              Trustee:'',
              QC:'',
              date:'',
              PeriodOfValidity:'',
              ddl:0,
              ChangeNumber:0,
              ChangeDay:0,
              //money:200,
            },
            Quote:0,
            MarCon:{
              PID:this.$store.state.user.process.PID,
              state:"30",
            },
            rules:{
              ItemName:[
                      { required: true, message: "不能为空！", trigger: "blur" },
                    ],
              Client:[
                { required: true, message: "不能为空！", trigger: "blur"  },
              ],
              Trustee:[
                      { required: true, message: "不能为空！", trigger: "blur" },
                    ],
              QC:[
                { required: true, message: "不能为空！", trigger: "blur"  },
              ],
              PeriodOfValidity:[
                { required: true, message: "不能为空！", trigger: "blur"  },
              ],
              date:[
                  { required: true, message: "请选择日期！", trigger: "change" },
              ],
              PeriodOfValidity:[
                  { required: true, message: "请选择日期！", trigger: "change" },
                ],
              }
    }
},    
created(){
      this.KeepInfor();
      this.useruid.UID=this.$store.state.user.process.UID;
      Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.useruid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data);
                this.userpid.PID=ret.data.PID;
              })
              Axios.post("http://localhost:9090/api/contract/find",JSON.stringify(this.userpid),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                this.ruleForm=ret.data;
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
    TestInfor(){
      //alert(JSON.stringify(this.ruleForm));
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          Axios.post("http://localhost:9090/api/process/updateState",JSON.stringify(this.MarCon),{
              headers:{
                'content-type': 'text/plain'}
              }).then(ret=>{
             })
          Axios.post("http://localhost:9090/api/contract/update",JSON.stringify(this.ruleForm),{
                headers:{
                  'content-type': 'text/plain'}
              }).then(ret=>{
                console.log(ret.data)
                this.stepNumber+=1;
                this.$message.success("提交成功，正在返回市场部界面！");
                 setTimeout(() => {this.$router.push({path: "./market", replace:true});}, 2000);
              })
        } else {
          return false;
        }
      });
    },
    handleRemove(file, fileList) {
        console.log(file, fileList);
    },
    handlePreview(file) {
        console.log(file);
      },
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
    beforeUploadword(file) {
        const isWord1 = file.type === 'application/msword';
        const isWord2 = file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
        const isPDF = file.type === 'application/pdf';
        // const isLt2M = file.size / 1024 / 1024 < 2;
        console.log(file.type)
        if (!isWord1 && !isWord2 && !isPDF) {
          this.$message.error('上传文件只能是 Word/PDF 格式!');
        }
        // if (!isLt2M) {
        //   this.$message.error('上传头像图片大小不能超过 2MB!');
        // }
        return isWord1 || isWord2 || isPDF;
      },
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

#ContractText{
  font-size:20px;
  text-indent:1em;
}
</style>