/**
 * 表格组件范例
 * 
 * 黄大伟修改
 */
<template>
  <div>
    <el-input
        placeholder="请输入关键字过滤"
        prefix-icon="el-icon-search"
        v-model="keyword">
    </el-input>
    <p/>
    <el-table
      :data="filterdatas"
      size = "mini"
      border
      stripe
      @sort-change="sortChange"
      style="width: 100%">
      <el-table-column
        fixed
        sortable
        prop="AID"
        label="AID"        
        width="100">
      </el-table-column>
      <el-table-column
        prop="SoftWareName"
        sortable
        label="name"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="time"
        label="time"
        width="250">
      </el-table-column>
      <el-table-column
        sortable
        prop="applicantID"
        label="用户ID"
        width="250">
      </el-table-column>
      <el-table-column
        sortable
        prop="phone"
        label="电话"
        width="150">
      </el-table-column>
      <el-table-column
        sortable
        prop="processID"
        label="PID"
        width="150">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100"
        align="center">
        <template slot-scope="scope">
          <el-button @click="SolvePro(scope.row)" type="text" size="small">处理</el-button>
        </template>
      </el-table-column>
    </el-table>
    
  </div>
</template>

<script>
import Axios from "axios"
export default {
  data() {
    return {
      keyword:"",
      datas:[],
      ruleForm:{
        processID:"",
      },
      State21:{
        state:'21',
      },
      sort: {},
      passwordDlg:{
        row: null,
        show: false,
        form:{
          password:""
        }
      }
    };
  },
  created(){
    Axios.post("http://localhost:9090/api/process/byState/selectPID",JSON.stringify(this.State21),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
          console.log(ret.data);
          var k=0;
    for(;k<ret.data.length;k++)
    {
      this.ruleForm.processID=ret.data[k];  
      console.log(this.ruleForm.processID)
      Axios.post("http://localhost:9090/api/application/checkbyprocess",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        //console.log(ret.data);
        //console.log(this.datas);
      var i=0;
      for(;i<ret.data.length;i++)
         {
          this.datas.push(ret.data[i]);
         }  
      }) 
    }
      })
    
  },
  methods: {
    SolvePro(row){
      // console.log(row);
      //sessionStorage.setItem
        this.$store.state.user.process.UID=row.applicantID;
        this.$store.state.user.process.AID=row.AID;
        this.$store.state.user.process.PID=row.PID;
        console.log(this.$store.state.user.process.AID);
        console.log(this.$store.state.user.process.UID);
        this.$router.push({path: "./marketcontract", replace:true})
    },
    handleClick(row) {
     
    },
    sortChange({column, prop, order}){
      this.sort = {prop, order};
    },
    dateFormat: function(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return new Date(date).format("yyyy/MM/dd hh:mm");
    },
    refreshConfig(){
      this.$refs.page1.reload();
    }
  },
  computed:{
  filterdatas(){
      return this.datas.filter((i)=>{
        var uid=i.uid+"";
        return uid.indexOf(this.keyword)!==-1||i.regTime.indexOf(this.keyword)!==-1||i.nickname.indexOf(this.keyword)!==-1
                ||i.emailAddr.indexOf(this.keyword)!==-1||i.phone.indexOf(this.keyword)!==-1
      })
    }
  }
};
</script>

<style scoped>

</style>