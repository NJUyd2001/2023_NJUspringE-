<!-- 文炫添加 -->
<template>
    <el-container style="height:100%">
      <el-header style="height: 30px">
        <el-row>
        <el-col :span="22">
        <el-breadcrumb separator="->">
        <el-breadcrumb-item :to="{ path: '../#/Test' }">测试主页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/SoftwareProjectTestChecklist">软件项目委托测试工作检查表</a></el-breadcrumb-item>
       </el-breadcrumb>
       </el-col>
       <el-col :span="2">
          <el-button style="margin-top: 10px; margin-left: 70px;" size="mini" type="primary">登出</el-button>
        </el-col>
        </el-row>
        <el-row  type="flex" justify="center" align="middle">
          <el-col :span="1">
            <router-link to="/test">
            <el-button style="margin-top: 15px;" size="middle" type="danger">上一步</el-button>
            </router-link>
          </el-col>
          <el-col :span="24">
            <span class="logo-title">软件项目委托测试工作检查表</span>
          </el-col>
          <el-col :span="1">
            <el-button @click="submitForm('ruleForm')" type="success">完成</el-button>
          </el-col>
        </el-row>
      </el-header>
        <br><br>
        <el-main>
          <el-form label-position="middle" label-width="40%" style="margin-top: 70px; margin-left: 70px; font-weight: bold;" :model="ruleForm" :rules="rules" ref="ruleForm">
            <el-form-item label="软件名称:" prop="SoftWareName"> 
              <el-row>
                <el-col :span="6">
                  <el-form-item prop="SoftWareName">
                    <el-input style="width:200px; padding:10px;" v-model="ruleForm.SoftWareName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="版本号:" prop="VersionNumber"> 
                    <el-input style="width:200px; padding:10px;" v-model="ruleForm.VersionNumber"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form-item>
             
          <el-form-item label="委托单位:" prop="Client"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Client"></el-input>
          </el-form-item>
          <el-form-item label="起始时间至预计完成时间:" prop="DateRange">
                <el-date-picker
                v-model="ruleForm.DateRange"
                type="daterange"
                range-separator="To"
                start-placeholder="起始时间"
                end-placeholder="预计完成时间"
                />
          </el-form-item>
          <el-form-item label="主测人:" prop="Tester">
              <el-row>
                <el-col :span="6">
                  <el-form-item prop="Tester">
                    <el-input style="width:200px; padding:10px;" v-model="ruleForm.Tester"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7">
                  <el-form-item label='实际完成时间:' prop="ActualFinishDate">
                      <div class="demo-date-picker">
                        <el-date-picker
                        v-model="ruleForm.ActualFinishDate"
                        type="date"
                        placeholder="时间选择"
                        size="large"
                        />
                        </div>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form-item>
          <el-table :data="ruleForm.tableData" :span-method="objectSpanMethod"  style="width: 52%; margin-left: 25%;">
            <el-table-column fixed prop="Num" label="序号" width="130"></el-table-column>
            <el-table-column prop="Workflow" label="工作（项目）流程" width="140"></el-table-column>
            <el-table-column prop="IssuesAndPrecautions" label="可预见问题及注意事项" width="450"></el-table-column>
            <el-table-column prop="Confirm" label="确 认" width="120">
              <template slot-scope="scope">
                <el-input type="input_type" ref="enterInput" v-model="scope.row.Confirm" :rows="2"  placeholder="请填写内容" v-if="scope.$index != 0 && scope.$index != 8 && scope.$index != 10" />
              </template>
            </el-table-column>
          </el-table>
          <el-form-item style="margin-left: 50px; margin-top: 20px; font-weight: bold;" label="检查人：" prop="Examiner"> 
            <el-input style="width:200px; padding:10px;" v-model="ruleForm.Examiner"></el-input>
          </el-form-item>
          </el-form>
        </el-main>
    </el-container>
    </template>

    <script>
    export default {
        data(){
           return{
            ruleForm:{
              SoftWareName:'',
              VersionNumber:'',
              Client:'',
              DateRange:'',
              Tester:'',
              ActualFinishDate:'',
              Examiner:'',
              Confirm:'',
              tableData: [{
            Num: '一、前期指导工作',
            }, {
            Num: '1',
            Workflow: '接受委托单位委托测试申请',
            IssuesAndPrecautions: '1. 为委托单位提供详尽的有关软件项目委托测试的相关法律法规、优惠政策、业务办理流程等事项。',
            Confirm: '',
            }, {
            Num: '1',
            Workflow: '接受委托单位委托测试申请',
            IssuesAndPrecautions: '	2. 建议委托单位阅读《软件项目委托测试流程图和工作介绍》，了解申报流程；',
            Confirm: '',
            }, {
            Num: '1',
            Workflow: '接受委托单位委托测试申请',
            IssuesAndPrecautions: '3. 根据《软件项目委托测试提交材料》，指导委托单位提交申报资料。',
            Confirm: '',
            }, {
            Num: '2',
            Workflow: '填写《软件项目委托测试申请表》、《委托测试软件功能列表》，按《软件项目委托测试提交材料》提交材料；',
            IssuesAndPrecautions: '1. 确保委托方应填内容正确、完备；纸质材料已盖公章；',
            Confirm: '',
            }, {
            Num: '2',
            Workflow: '填写《软件项目委托测试申请表》、《委托测试软件功能列表》，按《软件项目委托测试提交材料》提交材料；',
            IssuesAndPrecautions: '2. 明确委托方按《软件项目委托测试提交材料》提交材料',
            Confirm: '',
            }, {
            Num: '3',
            Workflow: '签订《软件项目委托测试合同》、《软件项目委托测试保密协议》',
            IssuesAndPrecautions: '1. 合同及保密协议内容、数量符合要求；',
            Confirm: '',
            }, {
            Num: '3',
            Workflow: '签订《软件项目委托测试合同》、《软件项目委托测试保密协议》',
            IssuesAndPrecautions: '2. 合同编号方式符合要求；',
            Confirm: '',
        },{
            Num: '二、对委托测试软件的可测状态进行评估',
            Workflow: '',
            IssuesAndPrecautions: '',
            Confirm: '',
            }, {
            Num: '4',
            Workflow: '对委托测试软件的可测状态进行评估',
            IssuesAndPrecautions: '中心在收到委托单位的有关资料后，即成立测试项目小组，该项目小组的任务是消化用户提供的有关资料，对委托软件的可测状态进行评估，若委托软件未达到可测状态，则向委托方提出改进建议，直到委托软件达到可测状态为止。项目小组的任务包括负责编制测试方案，搭建测试环境，执行测试过程，记录测试结果，编制测试报告，提交测试报告，将有关资料归档等。',
            Confirm: '',
        },{
            Num: '三、实施测试',
            Workflow: '',
            IssuesAndPrecautions: '',
            Confirm: '',
            },{
            Num: '5',
            Workflow: '编制测试方案',
            IssuesAndPrecautions: '1、测试方案必须经中心质量负责人审核，技术负责人批准方能生效。',
            Confirm: '',
            },{
            Num: '5',
            Workflow: '编制测试方案',
            IssuesAndPrecautions: '2、委托测试软件介绍：简要介绍委托测试软件的功能特点、应用行业及技术特性等。',
            Confirm: '',
            },{
            Num: '5',
            Workflow: '编制测试方案',
            IssuesAndPrecautions: '3、软件功能：以委托单位提供的功能列表为依据，以表格形式列出所有功能项目，并对功能列表的各功能项目按照层次关系进行编号，以便于标识。',
            Confirm: '',
            },{
            Num: '5',
            Workflow: '编制测试方案',
            IssuesAndPrecautions: '4、资源需求：资源需求要列出人员需求和软硬件设备需求。人员需求要列出人员名单、职称及所承担的角色（项目组长或成员）；软硬件设备需求要根据委托测试软件要求的运行环境及中心的设备情况，列出硬件设备的名称、型号、配置、机身编号、用途，软件的名称、版本号、用途等。',
            Confirm: '',
            },{
            Num: '5',
            Workflow: '编制测试方案',
            IssuesAndPrecautions: '5、参考文档：列出编制本方案所参考的标准、规范及用户文档等的名称、作者、类型、版本/标识号。',
            Confirm: '',
            },{
            Num: '6',
            Workflow: '搭建测试环境',
            IssuesAndPrecautions: '1、中心按照委托方提供的委托测试软件运行环境搭建测试环境；',
            Confirm: '',
            },{
            Num: '7',
            Workflow: '实施测试',
            IssuesAndPrecautions: '1、测试过程主要以测试方案为依据，按照用户手册所述的操作方法运行软件，考察软件是否具有用户手册所描述的操作界面，对功能列表的主要功能逐项进行符合性测试并作记录，对未测的次要功能或细节部分，应作出说明。',
            Confirm: '',
            },{
            Num: '7',
            Workflow: '实施测试',
            IssuesAndPrecautions: '2、对文档的测试：要从完整性、正确性、一致性、易理解性、易浏览性和外观质量六个方面，对用户文档进行评审。',
            Confirm: '',
            },{
            Num: '7',
            Workflow: '实施测试',
            IssuesAndPrecautions: '3、对测试过程观察到的结果进行如实记录，对发现的问题整理成问题清单；',
            Confirm: '',
            },{
            Num: '8',
            Workflow: '编制测试报告',
            IssuesAndPrecautions: '1、根据《软件项目委托测试报告编制作业指导书》和测试结果编制测试报告。',
            Confirm: '',
            },{
            Num: '8',
            Workflow: '编制测试报告',
            IssuesAndPrecautions: '2、检查测试报告，并填写《测试报告检查表》。',
            Confirm: '',
            },{
            Num: '8',
            Workflow: '编制测试报告',
            IssuesAndPrecautions: '3、测试报告的编码请参阅《程序文件》。 ',
            Confirm: '',
            },{
            Num: '8',
            Workflow: '编制测试报告',
            IssuesAndPrecautions: '4、报告审查：在分发报告前，应按中心质量管理程序对报告进行严格审查。',
            Confirm: '',
            },{
            Num: '9',
            Workflow: '评测资料归档',
            IssuesAndPrecautions: '1、委托测试的软件产品及测试相关文件、原始记录等能够随时复现测试过程所需的材料，也同测试报告一并交由中心资料室的材料管理员归档，以作为日后对测试结果产生异议时进行复核或仲裁的依据。上述材料由中心保存三年后，中心根据委托申请时要求进行处理。',
            Confirm: '',
            },{
            Num: '9',
            Workflow: '评测资料归档',
            IssuesAndPrecautions: '2、该检查表与本次委托测试归档资料一同归档。',
            Confirm: '',
            },{
            Num: '9',
            Workflow: '评测资料归档',
            IssuesAndPrecautions: '3、确保归档资料方便查找取阅',
            Confirm: '',
            }
          ],
            },
            pickerOptions: {
            shortcuts: [{
            text: 'Last week',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
            }, {
            text: 'Last month',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
            }, {
            text: 'Last 3 months',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
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
            DateRange:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            Tester:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            ActualFinishDate:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
            Examiner:[
              { required: true, message: "不能为空！", trigger: "blur" },
            ],
          }
      }
    },
    mounted() {
    //this.$forceUpdate();
    window.addEventListener('beforeunload', this.handleBeforeUnload());
    window.addEventListener('unload', this.handleUnload);
  },
  methods:{
    handleBeforeUnload() {
      sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  handleUnload() {
    sessionStorage.setItem("store",JSON.stringify(this.$store.state))
  },
  Logout(){
          this.$store.state.user.id=-1;
          this.$store.state.user.name="null";
          this.$store.state.user.password=-1;
          this.$store.state.user.Permissions="null";
      this.$router.push({path: "./home", replace:true});
    },
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
        submitForm(formName) {
          /*this.$refs[formName].validate((valid) => {
            if (valid) {
              alert("submit!");
              this.$router.push({path: "./client", replace:true});
            } else {
              return false;
            }
          });*/
          console.log(this.ruleForm);
          this.$message.success("提交成功！");
          //setTimeout(() => {this.$router.push({path: "./TestSchemeReviewForm", replace:true});}, 2000);
        },
      objectSpanMethod({ row, column, rowIndex, columnIndex }) {
        if (columnIndex === 0) {
          if(rowIndex === 0)
          {
            return {
              rowspan: 1,
              colspan: 4
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
              rowspan: 2,
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
              rowspan: 2,
              colspan: 1
            };
          } else if (rowIndex === 7) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 8) {
            return {
              rowspan: 1,
              colspan: 4
            };
          } 
          else if (rowIndex === 9) {
            return {
              rowspan: 1,
              colspan: 1
            };
          }else if (rowIndex === 10) {
            return {
              rowspan: 1,
              colspan: 4
            };
          } else if (rowIndex === 11) {
            return {
              rowspan: 5,
              colspan: 1
            };
          } else if (rowIndex === 12) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 13) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 14) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 15) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 16) {
            return {
              rowspan: 1,
              colspan: 1
            };
          } else if (rowIndex === 17) {
            return {
              rowspan: 3,
              colspan: 1
            };
          } else if (rowIndex === 18) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 19) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 20) {
            return {
              rowspan: 4,
              colspan: 1
            };
          } else if (rowIndex === 21) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 22) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 23) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 24) {
            return {
              rowspan: 3,
              colspan: 1
            };
          } else if (rowIndex === 25) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } else if (rowIndex === 26) {
            return {
              rowspan: 0,
              colspan: 1
            };
          } 
        }
      }
    },
    }

   </script>

   <style>
   .logo-title {
     margin-left: 55%;
   }

   .block {
     margin-left: 55%;
     margin-top: -75px;
   }

   .span .logo-title {
     width: 200px;
   }


   </style>
