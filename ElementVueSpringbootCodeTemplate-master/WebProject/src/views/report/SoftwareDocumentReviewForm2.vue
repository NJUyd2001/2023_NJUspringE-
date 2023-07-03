<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report/SoftwareDocumentReviewForm1">软件说明部分评审</a></el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report/SoftwareDocumentReviewForm2">软件文档集评审</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button style="margin-top: 10px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="6">
            <router-link to="/report">
            <el-button style="margin-top: -20px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="12" push="6"><div class="grid-content bg-purple">
            <span class="logo-title">软件文档评审表</span>
            </div></el-col>
            <el-col :span="12" push="4" style="margin-left: 20%">
              <el-steps :space="200" :active="1" finish-status="success">
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
            <el-button style="margin-top: -20px; margin-left: -20px;" size="middle" @click="submitForm('ruleForm')" type="success">完成</el-button>
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
                    placeholder="Pick a day">
                    </el-date-picker>
                </div>
            </el-form-item>
          </el-form-item>
          <el-table :data="tableData1" :span-method="objectSpanMethod" style="width: 50%; margin-left: 25%;">
            <el-table-column fixed prop="ReviewCategories" label="评审类别" width="60"></el-table-column>
            <el-table-column prop="Reviewitem" label="评审项" width="100"></el-table-column>
            <el-table-column prop="ReviewContent" label="评审内容" width="140"></el-table-column>
            <el-table-column prop="ReviewResultExplanation" label="评审结果说明" width="350">
              <template slot-scope="scope">
                <el-input :type="input_type" ref="enterInput" v-model="scope.row.ReviewResultExplanation" :rows="2"  placeholder="Please input"/>
              </template>
            </el-table-column>
            <el-table-column prop="ReviewResult" label="评审结果" width="120">
              <template slot-scope="scope">
                <el-radio  v-model="radio" label="1">通过</el-radio>
                <el-radio  v-model="radio" label="2">不通过</el-radio>
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
            pickerOptions: {
            disabledDate(time) {
            return time.getTime() > Date.now();
            },
            value1: '',
            },
            tableData1: [{
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '包含所有必需信息',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '包含产品说明中所有功能以及可调用功能的说明',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '包含可靠性特征及其操作',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '包含已处理的和可造成系统失效终止的差错和失效',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '必要的数据备份与恢复指南',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '所有关键功能的完备的细则信息和参考信息',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '陈述产品说明中所有限制',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '陈述最大最小磁盘空间',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '关于应用管理职能的所有必要信息',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '让用户验证是否完成应用管理职能的信息',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '1',
            Reviewitem: '完备性',
            ReviewContent: '文档集分若干部分，需给出完整标识',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '2',
            Reviewitem: '正确性',
            ReviewContent: '文档中所有的信息都是正确的。',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '2',
            Reviewitem: '正确性',
            ReviewContent: '没有歧义的信息。',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '3',
            Reviewitem: '一致性',
            ReviewContent: '文档集中的各文档不相互矛盾, 与产品说明也不矛盾. ',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '4',
            Reviewitem: '易理解性',
            ReviewContent: '使用用户可理解的术语和文体。',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '4',
            Reviewitem: '易理解性',
            ReviewContent: '文档集为用户使用该软件提供必要的信息 ',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '5',
            Reviewitem: '易学性',
            ReviewContent: '为如何使用该软件提供了足够的信息 ',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '6',
            Reviewitem: '可操作性',
            ReviewContent: '电子文档可打印 ',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '6',
            Reviewitem: '可操作性',
            ReviewContent: '有目次(主题词列表)和索引',
            ReviewResultExplanation: '',
            radio: '1',
            }, {
            ReviewCategories: '6',
            Reviewitem: '可操作性',
            ReviewContent: '不常用术语缩略语有定义',
            ReviewResultExplanation: '',
            radio: '1',
        }]
        }
    },
      methods: {
        handleClick() {
        console.log('click');
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
          if (rowIndex === 0) {
            return {
              rowspan: 11,
              colspan: 1
            };
          }
          else if (rowIndex === 1) {
            return {
              rowspan: 0,
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
              rowspan: 0,
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
          else if (rowIndex === 7) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 8) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 9) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 10) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 11) {
            return {
              rowspan: 2,
              colspan: 1
            };
          }
          else if (rowIndex === 12) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 14) {
            return {
              rowspan: 2,
              colspan: 1
            };
          }else if (rowIndex === 15) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 17) {
            return {
              rowspan: 3,
              colspan: 1
            };
          }
          else if (rowIndex === 18) {
            return {
              rowspan: 0,
              colspan: 1
            };
          }
          else if (rowIndex === 19) {
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
