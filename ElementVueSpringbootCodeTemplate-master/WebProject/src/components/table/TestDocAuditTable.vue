/**
 * 表格组件范例
 * 
 * 黄大伟添加
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
        :formatter="Timechange"
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
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="Pass(scope.row)" :disabled="scope.row.passornot!=='未处理'" type="text" size="small">通过</el-button>
          <!-- 增加的内容用于对按钮禁用 -->
          <el-button @click="NotPass(scope.row)" :disabled="scope.row.passornot!=='未处理'" type="text" size="small">不通过</el-button>
        </template>
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
    },
    Timechange(row){
      var t = new Date(row.time).toLocaleString(); 
      return t;
    }
  },
  data() {
    return {
      keyword: '',
      infors: [{
        aid:'0001',
        applicantID:'205220016',
        time:Date.now(),
        doc:'Green.doc',
        passornot:'未处理'
      },
      {
        aid:'0002',
        applicantID:'205220017',
        time:Date.now(),
        doc:'Blue.doc',
        passornot:'未处理'
      },
      {
        aid:'0001',
        applicantID:'205220018',
        time:Date.now(),//采取时间戳
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
      })//过滤，实现搜索栏的模糊搜索
    }
  }
};
</script>