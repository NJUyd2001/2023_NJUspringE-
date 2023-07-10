/**
 * 表格组件范例
 * 
 * 文炫添加
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
      :data="filterinfors"
      size="mini"
      border
      stripe
      style="width: 100%">
      <el-table-column
        fixed
        sortable
        prop="aid"
        label="AID"
        width="300">
      </el-table-column>
      <el-table-column
        prop="applicantID"
        sortable
        label="客户ID"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="time"
        label="递交文档时间"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="doc"
        label="附件">
      </el-table-column>
      <el-table-column
        sortable
        prop="passornot"
        label="通过与否">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="Result"
        width="100">
        <template slot-scope="scope">
          <el-button @click="Pass(scope.row)" :disabled="scope.row.passornot!=='未处理'" type="text" size="small">通过</el-button>
          <el-button @click="NotPass(scope.row)" :disabled="scope.row.passornot!=='未处理'" type="text" size="small">不通过</el-button>
        </template>
      </el-table-column>
    </el-table>
    <Pagination ref="page1" url="http://localhost:9090/api/application/checkbyprocess" :keyword="keyword" :sort="sort" v-model="datas"/>
  </div>
</template>

<script>

import Axios from "axios"
export default {
  methods:{
    Pass(row){
        row.passornot='通过';
    },
    NotPass(row){
      row.passornot='不通过';
    }
  },
  data() {
    return {
      ruleForm:
      { processID:1 },
      datas:[],
      keyword: '',
      infors: [{
        aid:'0001',
        applicantID:'205220016',
        time:'2023-04-29',
        doc:'Green.doc',
        passornot:'未处理'
      },
      {
        aid:'0002',
        applicantID:'205220017',
        time:'2023-04-29',
        doc:'Blue.doc',
        passornot:'未处理'
      },
      {
        aid:'0001',
        applicantID:'205220018',
        time:'2023-04-29',
        doc:'Red.doc',
        passornot:'未处理'
      }
    ]
    };
  },
  created(){
    Axios.post("http://localhost:9090/api/application/checkbyprocess",JSON.stringify(this.ruleForm),{
        headers:{
          'content-type': 'text/plain'}
      }).then(ret=>{
        console.log(ret.data);
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
  computed:{
    filterinfors(){
      return this.datas.filter((i)=>{
        var uid=i.uid+"";
        return uid.indexOf(this.keyword)!==-1||i.regTime.indexOf(this.keyword)!==-1||i.nickname.indexOf(this.keyword)!==-1
                ||i.emailAddr.indexOf(this.keyword)!==-1||i.phone.indexOf(this.keyword)!==-1
      })
    }
    /*
    filterinfors(){
      return this.datas.filter((i)=>{
        return i.aid.indexOf(this.keyword)!==-1||i.applicantID.indexOf(this.keyword)!==-1||i.time.indexOf(this.keyword)!==-1
                ||i.doc.indexOf(this.keyword)!==-1
      })
    }
    */
  }
};
</script>