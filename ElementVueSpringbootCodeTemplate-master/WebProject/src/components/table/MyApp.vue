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
        prop="processID"
        label="pid">
      </el-table-column>
      <el-table-column
        sortable
        prop="phone"
        label="电话"
        width="150">
      </el-table-column>
      <el-table-column
        sortable
        prop="process"
        label="当前进度"
        width="180">
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
    
    <Pagination ref="page1" url="http://localhost:9090/api/application/checkbyapplicant" :keyword="keyword" :sort="sort" v-model="datas"/>
  </div>
</template>

<script>
import Axios from "axios"
export default {
    addTab(targetName, commentName) {
      this.$set(this.tabs, commentName, {
        title: targetName,
        name: commentName,
        currentView: commentName
      });

      this.selectTabName = commentName;
      this.selectTabName = commentName;
    },
  data() {
    return {
      keyword:"",
      processes:[],
      datas:[],
      ruleForm:
      { processID:1 },
      sort: {},
      passwordDlg:{
        row: null,
        show: false,
        form:{
          password:""
        }
      },
      userid:{
        UID:"",
      },
      appID:{
        applicantID:"",
      },
    };
  },
  created(){
    this.KeepInfor();
    if (sessionStorage.getItem("store") ) {
    //this.$store.replaceState是vue官方提供的一个api表示替换 store 的根状态
    //里面的Object.assign()表示将store中的状态和sessionStorage中的状态进行合并
      this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
      sessionStorage.removeItem('store');
    }
    this.userid.UID=this.$store.state.user.id;
    console.log(this.userid)
    this.appID.applicantID=this.$store.state.user.id;

    Axios.post("http://localhost:9090/api/process/findByUID",JSON.stringify(this.userid),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data)
        var i=0;
        for(;i<ret.data.length;i++)
         {
          this.processes.push(ret.data[i].pid);
         }
         console.log(this.processes[2])
        })
    
    Axios.post("http://localhost:9090/api/application/checkbyapplicant",JSON.stringify(this.appID),{
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
      .catch(function (error) { // 请求失败处理
        console.log(error);
      });
  },
  mounted(){
    window.addEventListener('beforeunload', this.handleBeforeUnload);
    window.addEventListener('unload', this.handleUnload);
  },
  methods: {
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
    SolvePro(row){
      // console.log(row);
      //sessionStorage.setItem
        this.$store.state.user.process.PID=row.PID;
        this.$router.push({path: "./ProQurey", replace:true})
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
    },
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