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
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        sortable
        label="用户名"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="nickname"
        label="昵称"
        width="200">
      </el-table-column>
      <!-- <el-table-column
        prop="roles"
        label="角色">
        <template scope="scope">
          <el-tag  v-for="(item,index) in scope.row.roles"
          :type="item.name === 'admin' ? 'primary' : 'success'"
          disable-transitions>{{item.name}}</el-tag>
        </template>
      </el-table-column> -->
      <el-table-column
        sortable
        prop="email"
        label="邮箱"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="phone"
        label="电话"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="createTime"
        label="创建时间"
        :formatter="dateFormat"
        width="200">
      </el-table-column>
    </el-table>
    <!-- <Pagination ref="page1" url="http://localhost:9090/api/user/selectAll" :keyword="keyword" :sort="sort" v-model="datas"/> -->
  </div>
</template>

<script>
import Axios from "axios"
export default {
  created(){
    Axios.get("http://localhost:9090/api/user/selectAll/customer",).then(ret=>{
        //console.log(ret.data);
        //console.log(this.datas);
      var i=0;
      for(;i<ret.data.length;i++)
         {
          this.datas[i]=ret.data[i];
          console.log(this.datas[i]);
         }  
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
        alert("error!");
      });
  },
  methods: {
    handleClick(row) {
      console.log(row);
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
        return i.uid.indexOf(this.keyword)!==-1||i.name.indexOf(this.keyword)!==-1||i.nickname.indexOf(this.keyword)!==-1
                ||i.email.indexOf(this.keyword)!==-1||i.phone.indexOf(this.keyword)!==-1||i.job.indexOf(this.keyword)!==-1
                ||i.createTime.indexOf(this.keyword)!==-1
      })
    }
  }
};
</script>

<style scoped>

</style>
