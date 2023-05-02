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
      :data="filterinfors"
      size = "mini"
      border
      stripe
      @sort-change="sortChange"
      style="width: 100%">
      <el-table-column
        fixed
        sortable
        prop="uid"
        label="UID"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        sortable
        label="名称"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="password"
        label="密码"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="jobtype"
        label="岗位类型"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="username"
        label="使用者姓名"
        width="300">
      </el-table-column>
      
      <!-- <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="deleteConfig(scope.row)" type="text" size="small"><i class="el-icon-delete"></i></el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <Pagination ref="page1" url="/config/list" :keyword="keyword" :sort="sort" v-model="configs"/>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick(row) {
      console.log(row);
    },
    sortChange({column, prop, order}){
      this.sort = {prop, order};
    },
    deleteConfig(row) {
      this.ajax.post("/config/delete?id=" + row.id).then(result => {
        if (result.code == 0) {
          this.info("delete success");
          this.refreshConfig();
        } else {
          this.error(result.msg);
        }
      });
    },
    // 刷新表格数据
    refreshConfig(){
      this.$refs.page1.reload();
    }
  },
   data() {
    return {
      keyword:"",
      infors: [{
        uid:'205220016',
        name:"你说得对",
        password:'shazihuang007',
        jobtype:'你爹',
        username:'黄大伟',
      },
      {
        uid:'205220017',
        name:"你说得错",
        password:'shazihuang007',
        jobtype:'你爸',
        username:'黄中伟',
      },
      {
        uid:'205220018',
        name:"你说得既对又错",
        password:'shazihuang007',
        jobtype:'你爷',
        username:'黄小伟',
      }],
      sort: {}
    };
  },
  computed:{
    filterinfors(){
      return this.infors.filter((i)=>{
        return i.uid.indexOf(this.keyword)!==-1|| i.name.indexOf(this.keyword)!==-1||i.password.indexOf(this.keyword)!==-1
                ||i.jobtype.indexOf(this.keyword)!==-1|| i.username.indexOf(this.keyword)!==-1
      })
    }
  }
};
</script>