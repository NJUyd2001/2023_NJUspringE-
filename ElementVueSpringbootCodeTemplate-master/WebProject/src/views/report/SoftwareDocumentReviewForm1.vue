<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report/SoftwareDocumentReviewForm1">软件文档评审表</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report/SoftwareDocumentReviewForm2">软件文档集评审</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button style="margin-top: 10px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/test">
            <el-button style="margin-top: -20px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="13" push="6"><div class="grid-content bg-purple">
            <span class="logo-title">软件文档评审表</span>
            </div></el-col>
            <el-col :span="12" push="4" style="margin-left: 20%">
              <el-steps :space="200" :active="0" finish-status="success">
                <el-step title="软件说明部分评审"></el-step>
                <el-step title="软件文档集评审"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
            <el-col :span="6" pull="3">
            <div class="grid-content bg-purple-light text-right">
              <span v-if="user != null">
                <span class="user">{{user.nick}}</span>
              </span>
              <el-dropdown  @command="switchLang">
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="zh">En</el-dropdown-item>
                  <el-dropdown-item command="en">中</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div></el-col>
            <el-col :span="6" push="2">
            <router-link to="/report/SoftwareDocumentReviewForm2">
            <el-button style="margin-top: -20px; margin-left: -15px;" size="middle" type="success">下一步</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form :label-position="top" label-width="40%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;">
            <el-form-item style="margin-top: 80px; margin-right: 220px;" label="软件名称:" prop="SoftWareName"> 
                <el-input style="width:200px; padding:10px;" v-model="SoftWareName"></el-input>
                <el-form-item style="margin-top: -60px; margin-right: 120px;" label="版本号:" prop="VersionNumber"> 
                    <el-input style="width:200px; padding:10px;" v-model="VersionNumber"></el-input>
                </el-form-item>
            </el-form-item> 
            <el-form-item style="margin-top: -15px; margin-right: 220px;" label="委托单位:" prop="Client"> 
                <el-input style="width:200px; padding:10px;" v-model="Client"></el-input>
            </el-form-item>
          <el-form-item style="margin-top: -15px; margin-left: -150px;" label="评审人:" prop="Reviewer"> 
            <el-input style="width:200px; padding:10px;" v-model="Reviewer"></el-input>
            <el-form-item style="margin-top: -50px;"  label-width="330px" label="评审完成时间:" prop="ReviewCompleteDate"> 
                <div class="block" style="margin-top: 0px; margin-left: 0px;">
                    <el-date-picker
                    v-model="value1"
                    type="date"
                    placeholder="Pick a day"
                    :picker-options="pickerOptions">
                    </el-date-picker>
                </div>
            </el-form-item>
          </el-form-item>
          <el-table :data="tableData" :span-method="objectSpanMethod" style="width: 50%; margin-left: 25%;">
            <el-table-column fixed prop="ReviewCategories" label="评审类别" width="60"></el-table-column>
            <el-table-column prop="Reviewitem" label="评审项" width="100"></el-table-column>
            <el-table-column prop="ReviewContent" label="评审内容" width="140"></el-table-column>
            <el-table-column prop="ReviewResultExplanation" label="评审结果说明" width="350">
              <template slot-scope="scope">
                <el-input :type="input_type" ref="enterInput" v-model="scope.row.ReviewResultExplanation" :rows="2"  placeholder="请填写内容"/>
              </template>
            </el-table-column>
            <el-table-column prop="ReviewResult" label="评审结果" width="120">
              <template slot-scope="scope">
                <el-radio-group v-model="scope.row.HandleState">
                <el-radio  v-model="radio" label="1" @change="operation(scope.row)">通过</el-radio>
                <el-radio  v-model="radio" label="2" >不通过</el-radio>
                </el-radio-group>
              </template>
            </el-table-column>
          </el-table>
          <el-form-item style="margin-left: 5%; margin-top: 20px; font-weight: bold;" label="检查人：" prop="Examiner"> 
            <el-input style="width:200px; padding:10px;" v-model="Examiner"></el-input>
          </el-form-item>
          </el-form>
        </el-main>
      <LoginDialog :show='showLogin'/>
    </el-container>
    </template>

    <script>
    export default {
        data(){
           return{
            input_type:'text',
            SoftWareName:'',
            VersionNumber:'',
            Client:'',
            Reviewer:'',
            ReviewCompleteDate:'',
            radio:'',
            Examiner:'',
            user:{
                name:'风车村',
                password:'shazihuang',
                telephone:'',
                fax:'',
                address:'',
                postcode:'',
                contacts:'',
                mobilephone:'',
                email:'',
                URL:'',
            },
            shortcuts: [{
            text: 'Today',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: 'Yesterday',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: 'A week ago',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }],
            value1:'',
            tableData: [{
            ReviewCategories: '1',
            Reviewitem: '可用性',
            ReviewContent: '产品说明对于用户和潜在需方是可用的',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '2',
            Reviewitem: '内容',
            ReviewContent: '足够用于评价适用性',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '2',
            Reviewitem: '内容',
            ReviewContent: '排除内在的不一致',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '2',
            Reviewitem: '内容',
            ReviewContent: '可测试或可验证的',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '3',
            Reviewitem: '标识和标示',
            ReviewContent: '显示唯一标识',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '3',
            Reviewitem: '标识和标示',
            ReviewContent: '通过名称版本和日期指称',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '3',
            Reviewitem: '标识和标示',
            ReviewContent: '包含供方和至少一家经销商的名称和地址',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '4',
            Reviewitem: '功能性陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的功能进行陈述',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '5',
            Reviewitem: '可靠性陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的可靠性进行陈述',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '6',
            Reviewitem: '易用性陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的易用性进行陈述',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '7',
            Reviewitem: '效率陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的效率进行陈述',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '8',
            Reviewitem: '维护性陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的维护性进行陈述',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '9',
            Reviewitem: '可移植性陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的可移植性进行陈',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '10',
            Reviewitem: '使用质量陈述',
            ReviewContent: '根据GB/T 25000.51-2016规范对软件的使用质量进行陈',
            ReviewResultExplanation: '',
            radio: '1',
        }]
        }
    },
      methods: {
        handleClick() {
        console.log('click');
        },
        operation(row){
        console.log(row);
        },
        list(){
          this.input_type = 'textarea'
           this.$nextTick(function () { 
               if (this.$refs.enterInput) {
               this.$refs.enterInput.resizeTextarea();
               } 
           });
        },
        objectSpanMethod({ row, column, rowIndex, columnIndex }) {
        if (columnIndex === 0) {
          if(rowIndex === 0)
          {
            return {
              rowspan: 1,
              colspan: 1
            };
          }
          else if (rowIndex === 1) {
            return {
              rowspan: 3,
              colspan: 1
            };
          }
          else if (rowIndex === 2) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 3) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 4) {
            return {
              rowspan: 3,
              colspan: 1
            };
          }
          else if (rowIndex === 5) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 6) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } 
        }
      }
    }
    }

   </script>

   <style>
   .logo-title {
     margin-left: 40%;
   }

   .block {
     margin-left: 55%;
     margin-top: -75px;
   }

   .span .logo-title {
     width: 200px;
   }

   </style>
