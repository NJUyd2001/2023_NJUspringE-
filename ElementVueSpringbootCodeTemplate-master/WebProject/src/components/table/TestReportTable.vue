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
        width="200">
      </el-table-column>
      <el-table-column
        prop="applicantID"
        sortable
        label="客户ID"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="time"
        label="执行测试时间"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="BUG"
        label="相关的BUG编号"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        fixed="right"
        prop="passornot"
        label="实际结果">
      </el-table-column> 
    </el-table>
    <Pagination url="/config/list" v-model="configs"/>
  </div>
</template>

<script>
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
      keyword: '',
      infors: [{
        aid:'0001',
        applicantID:'205220016',
        time:'2023-04-29',
        BUG:'1',
        doc:'Green.doc',
        passornot:'未处理'
      },
      {
        aid:'0002',
        applicantID:'205220017',
        time:'2023-04-29',
        BUG:'2',
        doc:'Blue.doc',
        passornot:'未处理'
      },
      {
        aid:'0001',
        applicantID:'205220018',
        time:'2023-04-29',
        BUG:'3',
        doc:'Red.doc',
        passornot:'未处理'
      }
    ]
    };
  },
  computed:{
    filterinfors(){
      return this.infors.filter((i)=>{
        return i.aid.indexOf(this.keyword)!==-1||i.applicantID.indexOf(this.keyword)!==-1||i.time.indexOf(this.keyword)!==-1
                ||i.doc.indexOf(this.keyword)!==-1
      })
    }
  }
};
</script>