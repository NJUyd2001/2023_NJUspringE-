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
    <el-button @click="Reg" size="small">工作人员账号注册</el-button>
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
        prop="uid"
        label="UID"        
        width="200">
      </el-table-column>
      <el-table-column
        prop="regTime"
        sortable
        label="注册时间"
        width="300">
      </el-table-column>
      <el-table-column
        sortable
        prop="nickname"
        label="用户名"
        width="310">
      </el-table-column>
      <el-table-column
        sortable
        prop="emailAddr"
        label="邮箱"
        width="250">
      </el-table-column>
      <el-table-column
        sortable
        prop="phone"
        label="电话"
        width="250">
      </el-table-column>
    </el-table>

    <Pagination ref="page1" url="/config/list" :keyword="keyword" :sort="sort" v-model="configs"/>
  </div>
</template>

<script>
import Axios from "axios"
export default {
  created(){
    Axios.get("http://localhost:9090/api/user/selectAll/staff",).then(ret=>{
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
        alert("error!");
      });
  },
  computed:{
  filterdatas(){
      return this.datas.filter((i)=>{
        var uid=i.uid+"";
        return uid.indexOf(this.keyword)!==-1||i.regTime.indexOf(this.keyword)!==-1||i.nickname.indexOf(this.keyword)!==-1
                ||i.emailAddr.indexOf(this.keyword)!==-1||i.phone.indexOf(this.keyword)!==-1
      })
    }
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    Reg() {
      this.$router.push({path: "./register", replace:true});
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
      datas: [],
      sort: {}
    };
  }
};
</script>