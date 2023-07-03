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
        prop="uid"
        label="UID"        
        width="180">
      </el-table-column>
      <el-table-column
        prop="regTime"
        sortable
        label="注册时间"
        width="280">
      </el-table-column>
      <el-table-column
        sortable
        prop="nickname"
        label="用户名"
        width="280">
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
        width="240">
      </el-table-column>
    </el-table>

    <Pagination ref="page1" url="http://localhost:9090/api/user/selectAll" :keyword="keyword" :sort="sort" v-model="datas"/>
  </div>
</template>

<script>
import Axios from "axios"
export default {
  created(){
    Axios.get("http://localhost:9090/api/user/selectAll/customer").then(ret=>{
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
  methods: {
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
  data() {
    return {
      keyword:"",
      datas: [
      ],
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
