/**
 * 表格组件范例
 * 
 * @author xiaowenjie https://github.com/xwjie
 */
<template>
  <div>
    <el-input
        placeholder="请输入关键字过滤"
        prefix-icon="el-icon-search"
        v-model="keyword">
    </el-input>
    <p/>
    <el-button @click="handleClick" size="small">审核</el-button> <!-- 接到客户委托，开始审核 -->
    <el-button @click="handleClick" size="small">反馈</el-button> <!--测试部审核未通过，结果返回给客户 -->
    <el-button @click="price" size="small">报价</el-button> <!--委托审核结束，进入报价阶段-->
    <el-table
      :data="configs"
      border
      size = "mini"
      stripe
      @sort-change="sortChange"
      style="width: 100%">
      <el-table-column
        fixed
        sortable
        prop="id"
        label="ID"        
        width="70">
      </el-table-column>
      <el-table-column
        prop="name"
        sortable
        label="名称"
        width="400">
      </el-table-column>
      <el-table-column
        sortable
        prop="value"
        label="压缩包"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="description"
        label="进度"
        width="200">
      </el-table-column>
      
      <el-table-column
        fixed="right"
        label="操作"
        width="200">
        <template slot-scope="scope">
          <el-button @click="deleteConfig(scope.row)" type="text"><i class="el-icon-delete"></i></el-button>
        </template>
      </el-table-column>
    </el-table>

    <Pagination ref="page1" url="/config/list" :pageSize=5 :keyword="keyword" :sort="sort" v-model="configs"/>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick() {
      this.$router.push({path: "./login", replace:true});
    },
    price() {
      this.$router.push({path: "./market", replace:true});
    },
    sortChange({ column, prop, order }) {
      this.sort = { prop, order };
    },
    deleteConfig(row) {
      this.confirm("此操作将永久删除该记录, 是否继续?")
        .then(() => {
          this.ajax.post("/config/delete?id=" + row.id).then(result => {
            if (result.code == 0) {
              this.info("delete success");
              this.refreshConfig();
              this.info("删除成功!");
            } else {
              this.error(result.msg);
            }
          });
        })
        .catch(() => {
          this.info("已取消删除");
        });
    },
    // 刷新表格数据
    refreshConfig() {
      this.$refs.page1.reload();
    }
  },
  data() {
    return {
      keyword: "",
      configs: [],
      sort: {}
    };
  }
};
</script>