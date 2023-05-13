<!-- 黄大伟添加 -->
<template>
<el-container style="height:100%">
  <el-header style="height: 30px">
    <el-row  type="flex" justify="center" align="middle">
      <el-col :span="6">
        <router-link to="/admin">
        <el-button  size="middle" >上一步</el-button>
        </router-link>
      </el-col>
      <el-col :span="6" push="4"><div class="grid-content bg-purple">
        <span class="logo-title">申请界面-申请表</span>
        </div></el-col>
        <el-col :span="6" push="4">
        <div class="grid-content bg-purple-light text-right">
          <span v-if="user != null">
            <span class="user">{{user.nick}}</span><el-button  plain size="middle"  type="danger" @click="logout">退出</el-button>
          </span>
          <span v-else><el-button type="success" plain size="middle" style = "margin:10px" @click="loginOut">登出</el-button></span>
          <el-dropdown  @command="switchLang">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="zh">En</el-dropdown-item>
              <el-dropdown-item command="en">中</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div></el-col>
      <el-col :span="6" push="4">
        <router-link to="/admin">
        <el-button  size="middle" >下一步</el-button>
        </router-link>
      </el-col>
    </el-row>
  </el-header>
  <el-container>
    <el-main>
      <el-form>
        <el-form-item label="测试类型:"> 
        <el-checkbox-group v-model="TypeOfTest">
        <el-checkbox   label="软件确认测试"></el-checkbox>
        <el-checkbox   label="成果/技术鉴定测试"></el-checkbox>
        <el-checkbox   label="专项资金验收测试"></el-checkbox>
        <el-form-item label="其他:"><el-input style="width: 100px;padding:10px;" v-model="OtherTypeOfTest" ></el-input></el-form-item>
        </el-checkbox-group>
       </el-form-item>
      <el-form-item label="软件名称:"> 
        <el-input style="width:200px;padding:10px" v-model="SoftWareName"></el-input>
      </el-form-item> 
      <el-form-item label="版本号:"> 
        <el-input style="width:200px;padding:10px" v-model="VersionNumber"></el-input>
      </el-form-item>
      <el-form-item label="委托单位(中文):">  
            <el-input style="width:200px;padding:10px" v-model="EntrustingParty.Chinese"></el-input>
      </el-form-item>
      <el-form-item label="委托单位(英文):">  
        <el-input style="width:200px;padding:10px" v-model="EntrustingParty.English"></el-input>
      </el-form-item>
      <el-form-item label="开发单位:">  
         <el-input style="width:200px;padding:10px" v-model="DevelopmentCompany"></el-input>
      </el-form-item>
      <el-form-item label="单位性质:">   
        <el-radio-group v-model="AttributeOfCompany">
        <el-radio label="内资企业"></el-radio>
        <el-radio label="外(合)资企业"></el-radio>
        <el-radio label="港澳台(合)企业"></el-radio>
        <el-radio label="科研院校"></el-radio>
        <el-radio label="政府事业团体"></el-radio>
        <el-radio label="其他"></el-radio>
        </el-radio-group>
      </el-form-item> 
        <el-form-item label="软件用户对象描述:">
          <el-input style="width:500px;" maxlength='200' show-word-limit :autosize="{ minRows: 2, maxRows: 4 }" 
          v-model="SoftwareUserObjectDescription" type="textarea" />
        </el-form-item>
        <el-form-item label="测试依据:">
          <el-checkbox-group v-model="Standard">
          <el-checkbox   label="GB/T 25000.51-2016"></el-checkbox>
          <el-checkbox   label="GB/T 25000.10-2016"></el-checkbox>
          <el-checkbox   label="GB/T 28452-2012"></el-checkbox>
          <el-checkbox   label="GB/T 30961-2014"></el-checkbox>
          <el-checkbox   label="NST-03-WI12-2011"></el-checkbox>
          <el-checkbox   label="NST-03-WI13-2011"></el-checkbox>
          <el-checkbox   label="NST-03-WI22-2014"></el-checkbox>
          </el-checkbox-group>
        </el-form-item> 
        <el-form-item label="其他">
          <el-input style="width:200px;padding:10px" v-model="OtherStandard"></el-input>
        </el-form-item>
        <el-form-item label="需要测试的技术指标:">
          <el-checkbox-group v-model="TechnicalIndex">
          <el-checkbox   label="功能性"></el-checkbox>
          <el-checkbox   label="可靠性"></el-checkbox>
          <el-checkbox   label="易用性"></el-checkbox>
          <el-checkbox   label="效率"></el-checkbox>
          <el-checkbox   label="可维护性"></el-checkbox>
          <el-checkbox   label="可移植性"></el-checkbox>
          <el-checkbox   label="代码覆盖度"></el-checkbox>
          <el-checkbox   label="缺陷检测率"></el-checkbox>
          <el-checkbox   label="代码风格符合度"></el-checkbox>
          <el-checkbox   label="代码不符合项检测率"></el-checkbox>
          <el-checkbox   label="产品说明要求"></el-checkbox>
          <el-checkbox   label="用户文档集要求"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="软件规模:">
          <el-form-item label="功能数:"><el-input-number  v-model="SoftWareSize.Number"></el-input-number></el-form-item>
          <el-form-item label="功能点数:"><el-input-number  v-model="SoftWareSize.point"></el-input-number></el-form-item>
          <el-form-item label="代码行数:"><el-input-number  v-model="SoftWareSize.RowNumber"></el-input-number></el-form-item>
        </el-form-item> 
        <el-form-item label='软件类型:'>
          <el-select v-model="SoftWareType">
            <el-option-group 
            v-for='group in TypeOfSoftWare'
            :key="group.label"
            :label="group.label">
            <el-option v-for="item in group.options"
            :key="item.id"
            :label="item.name"
            :value="item.name"/>
          </el-option-group>
          </el-select>
        </el-form-item>
        <el-form-item label="运行环境:">
          <span>客户端:</span>
          Windows(版本):<el-input style="width: 100px;padding:10px;"  v-model="RuntimeEnvironment.Client.Windows"></el-input>
          Linux(版本):<el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Client.Linux"></el-input>
          其他:<el-input style="width: 100px;padding:10px;"  v-model="RuntimeEnvironment.Client.Linux"></el-input>
          内存要求:<el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Client.Mermory"></el-input>
          其他要求:<el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Client.Other"></el-input>
        <el-form-item label="服务器端:">
          <el-checkbox-group v-model="RuntimeEnvironment.Server.HardWare.FrameWork">
            <el-checkbox label="PC服务器"></el-checkbox>
            <el-checkbox label="UNIX/Linux服务器"></el-checkbox>
            <el-checkbox label="其他"></el-checkbox>
          </el-checkbox-group>
          硬件:
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.HardWare.Mermory" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.HardWare.HardDisk" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.HardWare.Other" ></el-input>
          软件:
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.OS" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.Versions" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.PL" ></el-input>
          <el-checkbox-group v-model="RuntimeEnvironment.Server.SoftWare.FrameWork">
            <el-checkbox label="C/S"></el-checkbox>
            <el-checkbox label="B/S"></el-checkbox>
            <el-checkbox label="其它"></el-checkbox>
          </el-checkbox-group>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.database" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.MiddleWare" ></el-input>
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.Server.SoftWare.Other" ></el-input>

        </el-form-item>
        <el-form-item label="网络环境:">
          <el-input style="width: 100px;padding:10px;" v-model="RuntimeEnvironment.NetWork"></el-input>
        </el-form-item>
        <el-form-item label="样品和数量">
        <el-checkbox-group v-model="SampleAndQuantity.SoftwareMedium">
            <el-checkbox label="光盘"></el-checkbox>
            <el-checkbox label="U盘"></el-checkbox>
            <el-checkbox label="其他"></el-checkbox>
          </el-checkbox-group>
          <el-input v-model="SampleAndQuantity.Document" type="textarea" ></el-input>
          <el-radio-group v-model="SampleAndQuantity.SamplesSubmitted">
            <el-radio label="由本中心销毁"></el-radio>
            <el-radio label="退还给我们"></el-radio>>
          </el-radio-group>
      </el-form-item>
        <el-form-item label="希望测试完成时间:">
          <div class="demo-date-picker">
          <div class="block">
            <span class="demonstration">完成时间</span>
            <el-date-picker
            v-model="value1"
            type="date"
            placeholder="Pick a day"
            :size=large
              />
            </div>
            </div>
        </el-form-item>
        </el-form-item>
    </el-form>
    </el-main>
  </el-container>
  <LoginDialog :show='showLogin'/>
</el-container>
</template>
<script>
export default {
    data(){
       return{
            user:{
                name:'风车村',
                password:'shazihuang'
            },
            TypeOfTest:[],
            OtherTypeOfTest:'',
            SoftWareName:'',
            VersionNumber:'',
            EntrustingParty:{
              Chinese:'',
              English:'',
            },
            DevelopmentCompany:'',
            AttributeOfCompany:[],
            SoftwareUserObjectDescription:'',
            Standard:[],
            OtherStandard:'',
            TechnicalIndex:[],
            SoftWareSize:{
              Number:'',
              Point:'',
              RowNumber:'',
            },
            TypeOfSoftWare:[
    {
      label:'系统软件',
      options:[{
      name:'操纵系统',
      id:1,
    },
    {
      name:'中文处理系统',
      id:2,
    },
    {
      name:'网络系统',
      id:3,
    },
    {
      name:'嵌入式操作系统',
      id:4,
    },
    {
      name:'其他(系统软件)',
      id:5,
    }],
    },
    {
      label:'支持软件',
      options:[{            
     name:'程序设计语言',
      id:6,
    },
    {
      name:'数据库系统设计',
      id:7,
    },
    {
      name:'工具软件',
      id:8,
    },
    {
      name:'网络通信软件',
      id:9,
    },
    {
      name:'中间件',
      id:10,
    },
    {
      name:'其他(支持软件)',
      id:11,
    }
    ],
    },
    {
      label:'应用软件',
      options:[
    {            
      name:'行业管理软件',
      id:12,
    },
    {
      name:'办公软件',
      id:13,
    },
    {
      name:'模式识别软件',
      id:14,
    },
    {
      name:'图形图像软件',
      id:15,
    },
    {
      name:'控制软件',
      id:16,
    },
    {            
      name:'网络应用软件',
      id:17,
    },
    {
      name:'信息管理软件',
      id:18,
    },
    {
      name:'数据库管理应用软件',
      id:19,
    },
    {
      name:'安全与保密软件',
      id:20,
    },
    {
      name:'嵌入式应用软件',
      id:21,
    },
    {
      name:'教育软件',
      id:22,
    },
    {
      name:'游戏软件',
      id:23,
    },
    {
      name:'其他(应用软件)',
      id:24,
    }
  ],
    },
    {
      label:'其他',
      options:[
      {
      name:'其他',
      id:25,
      }
      ]
    },
            ],
            SoftWareType:'',
            RuntimeEnvironment:{
                Client:{
                Windows:'',
                Linux:'',
                other:'',
              },
              Server:{
                HardWare:{
                FrameWork:[],  
                Mermory:'',
                HardDisk:'',
                OtherDisk:''
              },
              SoftWare:{
                OS:'',
                Versions:'',
                PL:'',
                FrameWork:[],
                DataBase:'',
                MiddleWare:'',
                Other:''
              },
              },
              NetWork:'',     },
            SampleAndQuantity:{
            SoftwareMedium:[],
            Document:'',
            SamplesSubmitted:'',
            },
            shortcuts:[
  {
    text: 'Today',
    value: new Date(),
  },
  {
    text: 'Yesterday',
    value: () => {
      const date = new Date()
      date.setTime(date.getTime() - 3600 * 1000 * 24)
      return date
    },
  },
  {
    text: 'A week ago',
    value: () => {
      const date = new Date()
      date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
      return date
    },
  },
                      ],
            WantedFinishTime:'',
    }
}    
}

</script>
<style>
.text-right {
  padding-right: 0px;
  text-align: right;
}

.user {
  margin: 10px;
  font-size: 12px;
}

.header {
  position: relative;
  z-index: 1;
}

.el-header{
  margin: 10px 0 10px 0;  
}



.header .nav {
  height: 40px;
  color: #fff;
  text-align: center;
}
.banner {
  position: relative;
  z-index: 0;
  margin: 3px auto;
  height: 200px;
}

.el-container .el-main{
  padding: 0px 5px 5px 5px;
}

.index {
  padding-left: 10px;
}
.el-input{
    padding:15px,
}
/*
* {
  outline: 1px solid;
}
*/

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  height: 100%;
}

.logo-title{
  font-size: 20px;
  font-weight: bold;
}
.demo-date-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}

.demo-date-picker .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}

.demo-date-picker .block:last-child {
  border-right: none;
}

.demo-date-picker .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
</style>