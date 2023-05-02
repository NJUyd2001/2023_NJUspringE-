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
        prop="job"
        label="工作单位"
        width="200">
      </el-table-column>
      <el-table-column
        sortable
        prop="createTime"
        label="创建时间"
        :formatter="dateFormat"
        width="200">
      </el-table-column>
      <!-- <el-table-column
        sortable
        prop="updateTime"
        label="最后修改时间"
        :formatter="dateFormat"
        width="150">
      </el-table-column>        
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="showPasswordDlg(scope.row)" type="text" size="small"  icon="el-icon-edit"></el-button>
          <el-button @click="deleteConfig(scope.row)" type="text" size="small"  icon="el-icon-delete"></el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <Pagination ref="page1" url="/user/list" :keyword="keyword" :sort="sort" v-model="datas"/>

    <!--修改密码对话框-->
    <el-dialog title="修改密码" :visible.sync="passwordDlg.show" @close="hidePasswordDlg">
      <el-form :model="passwordDlg.form">
        <el-form-item label="密码" label-width="100px">
          <el-input v-model="passwordDlg.form.password" type="password" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="hidePasswordDlg">取 消</el-button>
        <el-button type="primary" @click="doModifyPwd">确 定</el-button>
      </div>
    </el-dialog>
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
    dateFormat: function(row, column) {
      var date = row[column.property];
      if (date == undefined) {
        return "";
      }
      return new Date(date).format("yyyy/MM/dd hh:mm");
    },
    deleteConfig(row) {
      // this.ajax.post("/config/delete?id=" + row.id).then(result => {
      //   if (result.code == 0) {
      //     this.info("delete success");
      //     this.refreshConfig();
      //   } else {
      //     this.error(result.msg);
      //   }
      // });
    },
    // 显示修改密码 
    showPasswordDlg(row){
      this.passwordDlg.row = row;
      this.passwordDlg.show = true;
    },
    // 隐藏
    hidePasswordDlg(){
      this.passwordDlg.row = null;
      this.passwordDlg.show = false;
      this.passwordDlg.form.password = "";
    },
    // 修改密码
    doModifyPwd(){
      if(this.passwordDlg.form.password == ""){
        this.error("密码不能为空");
        return;
      }

      this.ajax.postForm("/user/updatepwd" ,{
        id: this.passwordDlg.row.id,
        password: this.passwordDlg.form.password
      }).then(result => {
        if (result.code == 0) {
          this.info("Password Update Success.");
          this.hidePasswordDlg();
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
      datas: [{
        uid:'2005220016',
        name:'H958902573',
        nickname:'风车村吹风车',
        email:"958902573@qq.com",
        phone:'15968774896',
        job:'测试人员',
        createTime:'2023-04-29:16:20',
      },
      {
        uid:'2005220016',
        name:'H958902573',
        nickname:'风车村吹风车',
        email:"958902573@qq.com",
        phone:'15968774896',
        job:'质量部人员',
        createTime:'2023-04-29:16:20',
      }
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
