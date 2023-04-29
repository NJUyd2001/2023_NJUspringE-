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
      :data="configs"
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
        label="申请人ID"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="time"
        label="上次更新时间"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="CurrentPorgress"
        label="当前进度">
      </el-table-column>
    </el-table>
    <Pagination url="/config/list" v-model="configs"/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      configs: [{
        aid:'00001',
        applicantID:205220016,
        time:'2023-04-29',
        CurrentPorgress:'发起委托'
      }]
    };
  }
};
</script>