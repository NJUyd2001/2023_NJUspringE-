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
      :data="configs | filterKeyword(keyword)"
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
    </el-table>
    <el-table-column
        sortable
        prop="passornot"
        label="通过与否">
      </el-table-column>
    <Pagination url="/config/list" v-model="configs"/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      keyword: '',
      configs: []
    };
  }
};
</script>