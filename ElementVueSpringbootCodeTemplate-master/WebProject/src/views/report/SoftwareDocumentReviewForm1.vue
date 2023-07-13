<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试部主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/report/SoftwareDocumentReviewForm1">样品验收</a></el-breadcrumb-item>
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
          <el-col :span="18"><div class="grid-content bg-purple">
            <span class="logo-title">软件文档评审表</span>
            </div></el-col>
            <el-col :span="14">
              <el-steps :space="200" :active="0" finish-status="success">
                <el-step title="软件说明部分评审"></el-step>
                <el-step title="软件文档集评审"></el-step>
                <el-step title="完成"></el-step>
              </el-steps>
            </el-col>
            <el-col :span="2">
            <el-button  @click="submitForm('ruleForm')" size="middle" type="success">下一步</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br> <br><br>
        <el-main>
          <el-form label-position="middle" label-width="300px" style="margin-top: 70px; margin-left: 70px; font-weight: bold;" :model="ruleForm" :rules="rules" ref="ruleForm">
          <el-form-item label-width="300px">
          <el-table :data="ruleForm.tableData" :span-method="objectSpanMethod" >
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
                <el-radio-group v-model="scope.row.radio">
                  <el-radio v-model="number" value="1" label="1" >通过</el-radio>
                  <el-radio  v-model="number" value="2" label="2" >不通过</el-radio>
                </el-radio-group>
              </template>
            </el-table-column>
          </el-table>
        </el-form-item>
          </el-form>
        </el-main>
    </el-container>
    </template>

    <script>
    export default {
      watch:{
        number(){
          console.log('watch:',this.number);
        }
      },
        data(){
           return{
             number:'',
             input_type:'text',
             ruleForm:{
                tableData: [{
                    ReviewCategories: '1',
                    Reviewitem: '可用性',
                    ReviewContent: '产品说明对于用户和潜在需方是可用的',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '2',
                    Reviewitem: '内容',
                    ReviewContent: '足够用于评价适用性',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '2',
                    Reviewitem: '内容',
                    ReviewContent: '排除内在的不一致',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '2',
                    Reviewitem: '内容',
                    ReviewContent: '可测试或可验证的',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '3',
                    Reviewitem: '标识和标示',
                    ReviewContent: '显示唯一标识',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '3',
                    Reviewitem: '标识和标示',
                    ReviewContent: '通过名称版本和日期指称',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '3',
                    Reviewitem: '标识和标示',
                    ReviewContent: '包含供方和至少一家经销商的名称和地址',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '4',
                    Reviewitem: '功能性陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的功能进行陈述',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '5',
                    Reviewitem: '可靠性陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的可靠性进行陈述',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '6',
                    Reviewitem: '易用性陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的易用性进行陈述',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '7',
                    Reviewitem: '效率陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的效率进行陈述',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '8',
                    Reviewitem: '维护性陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的维护性进行陈述',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '9',
                    Reviewitem: '可移植性陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的可移植性进行陈',
                    ReviewResultExplanation: '',
                    radio: '',
                    }, {
                    ReviewCategories: '10',
                    Reviewitem: '使用质量陈述',
                    ReviewContent: '根据GB/T 25000.51-2016规范对软件的使用质量进行陈',
                    ReviewResultExplanation: '',
                    radio: '',
                }]
              },
              rules:{
                SoftWareName:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                VersionNumber:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Client:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Reviewer:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                ReviewCompleteDate:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
                Examiner:[
                  { required: true, message: "不能为空！", trigger: "blur" },
                ],
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
        submitForm(formName) {
          /*this.$refs[formName].validate((valid) => {
            if (valid) {
              alert("submit!");
              this.$router.push({path: "./client", replace:true});
            } else {
              return false;
            }
          });*/
          setTimeout(() => {this.$router.push({path: "./SoftwareDocumentReviewForm2", replace:true});}, 2000);
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
