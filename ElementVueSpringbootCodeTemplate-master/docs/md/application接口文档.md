# Application接口文档
author:李晨博

注意！本文档提到的所有接口都应该使用post方法


## /application/insert

增加一个新的application项目

注意！在此处定义AID没有任何意义，AID会变为sql设定的自增变量！

输入示例：
```js
{
    "applicantID":"1",
    "PID":"1",
    "time":"2017-09-02 10:29:14",
    "phone":"15968774896",
    "TypeTest":["软件确认测试"],
    "SoftWareName":"学生管理系统",
    "VersionNumber":"2.5",
    "ClientChinese":"黄大伟",
    "ClientEnglish":"David Huang",
    "DevelopmentCompany":"C先生",
    "AttributeOfCompany":"内资企业",
    "SoftwareUserObjectDescription":"这是学生信息管理系统",
    "MainFunction":"信息管理与调度",
    "NeededStandard":[
        "GB/T 25000.51-2016"
    ],
    "NeededTechnicalIndex":[
        "功能性"
    ],
    "SoftWareSize":{
        "Number":"1",
        "Point":"2",
        "RowNumber":"3"
    },
    "SoftWareType":"管理系统",
    "RuntimeEnvironment":{
        "Client":{
            "OS":{
                "Windows":"xp",
                "Linux":"12108",
                "other":""
            },
            "Mermory":"2048MB",
            "Other":""
        },
        "Server":{
            "HardWare":{
            "FrameWork":["PC服务器"],  
            "Mermory":"1024",
            "HardDisk":"why",
            "OtherDisk":"to"
            },
            "SoftWare":{
                "OS":"Linux",
                "Versions":"16.3.1",
                "PL":"Java",
                "FrameWork":["服务器端软件架构:C/S"],
                "DataBase":"Mysql",
                "MiddleWare":"a",
                "Other":""
            }
        },
        "NetWork":"https"
    },
        "SoftwareMedium":["U盘"],
        "Document":"c32",
        "SamplesSubmitted":"中心直接销毁",
        "WantedFinishTime":""
}
```
为空的部分可以直接不加入

输出：该application的AID

输出示例：
```js
{"AID"："1"，"PID","1"}


```
## /application/checkbyapplicant
根据applicantID项查找所有符合的aplication
输入示例：
```js
{
    "applicantID":"1"
}
```
输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
```
[]
```
输出示例2：
```js
[{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"96","applicantID":"1"}]
```
输出示例3：
```js
[{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"96","applicantID":"1"},{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"97","applicantID":"1"}]
```
## /application/checkbyprocess
根据process值查找所有符合的application

输入示例：
```js
{
    "PID":"1"
}
```
输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
```js
[]
```
输出示例2：
```js
[{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"96","applicantID":"1"}]
```
## /application/checkbyAID
根据AID查找所有符合的application

输入示例：
```js
{
    "AID":"96"
}
```
输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
```js
[]
```
输出示例2：
```js
[{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"96","applicantID":"1"}]
```
## /applicat/getallAID
获得所有application的AID

输入：

一个空JSON


输入示例：
```js
{}
```
输出示例：
```js
[1,2,3,4,12,39]
```
## /application/getall
获得所有application

输入：

一个空JSON


输入示例：
```js
{}
```
输出示例：
```js
[{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"96","applicantID":"1"},{"SoftWareSize":{"RowNumber":"1","Number":"3","Point":"2"},"RuntimeEnvironment":{"Server":{"SoftWare":{"MiddleWare":"a","Versions":"16.3.1","OS":"Linux","PL":"Java","FrameWork":["服务器端软件架构:C/S"],"DataBase":"Mysql","Other":""},"HardWare":{"Mermory":"1024","HardDisk":"why","FrameWork":["PC服务器"],"Other":"Linux"}},"NetWork":"https","Client":{"Mermory":"2048MB","OS":{"Linux":"12108","Windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"管理系统","PID":"1","ClientChinese":"黄大伟","Document":"c32","SoftwareUserObjectDescription":"这是学生信息管理系统","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"David Huang","SoftWareName":"学生管理系统","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"信息管理与调度","AttributeOfCompany":"内资企业","time":"2023-07-16 12:37:20","AID":"97","applicantID":"1"}]
```

## /application/updateapplication
更新对应AID的application信息

注意！此项更新只看AID，其余所有信息都会被更新覆盖；不改的部分可以不提，包括NOT NULL的部分（ps.算法更新力）


输入示例：

```js
{
    "AID":96,
    "applicantID":"1",
    "PID":"1",
    "time":"2017-09-02 10:29:14",
    "phone":"15968774896",
    "TypeTest":["软件确认测试"],
    "SoftWareName":"学生管理系统",
    "VersionNumber":"2.5",
    "ClientChinese":"黄大伟",
    "ClientEnglish":"David Huang",
    "DevelopmentCompany":"C先生",
    "AttributeOfCompany":"内资企业",
    "SoftwareUserObjectDescription":"这是学生信息管理系统",
    "MainFunction":"信息管理与调度",
    "NeededStandard":[
        "GB/T 25000.51-2016"
    ],
    "NeededTechnicalIndex":[
        "功能性"
    ],
    "SoftWareSize":{
        "Number":"1",
        "Point":"2",
        "RowNumber":"3"
    },
    "SoftWareType":"管理系统",
    "RuntimeEnvironment":{
        "Client":{
            "OS":{
                "Windows":"xp",
                "Linux":"12108",
                "other":""
            },
            "Mermory":"2048MB",
            "Other":""
        },
        "Server":{
            "HardWare":{
            "FrameWork":["PC服务器"],  
            "Mermory":"1024",
            "HardDisk":"why",
            "OtherDisk":"to"
            },
            "SoftWare":{
                "OS":"Linux",
                "Versions":"16.3.1",
                "PL":"Java",
                "FrameWork":["服务器端软件架构:C/S"],
                "DataBase":"Mysql",
                "MiddleWare":"a",
                "Other":""
            }
        },
        "NetWork":"https"
    },
        "SoftwareMedium":["U盘"],
        "Document":"c32",
        "SamplesSubmitted":"中心直接销毁",
        "WantedFinishTime":""
}
```

输出1：（AID对应的application不存在）
```js
the application does not exist
```
输出2：（更新成功）
```js
update complete
```
## /application/deleteapplication
删除对应AID的application

注意！此处只看AID，所有AID之外的信息都会被无视

输入示例：
```js
{
    "AID":"1"
}
```
输出1：（AID对应的application不存在）
```js
the application does not exist
```
输出2：（删除成功）
```js
delete complete
```
## /application/inserttabledata
为指定的application插入tabledata

输入：

包含AID，SoftwareName，Versions和TableData，其中SoftwareName与Version可以为空，如果不为空将会覆盖之前的SoftwareName与Version。

输入示例：
```js
{
    "AID":"34",
    "SoftwareName":"学生管理系统",
    "Versions":"1",
    "TableData":[
        {
            "id":"1",
            "name":"管理系统插入部分",
            "function":"插入信息"
        }
    ]
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（插入成功）
```8js
tabledata insert complete
```
## /application/updatetabledata
为指定的application更新指定的tabledata信息

输入：

包含AID，和Tabledata，Tabledata中必须包括TID，以及可选地包含需要修改的信息，不需要更改的不包含。TID可以通过/application/getruleform查询。此接口也可以添加SoftwareName和Versions，以更新信息。

输入示例：
```js
{
    "AID":"34",
    "SoftwareName":"1",
    "Versions":"1",
    "TableData":[
        {
            "TID"：1
            "id":"1",
            "name":"管理系统插入部分",
            "function":"插入信息"
        }，
        {
            "TID"：2
            "id":"2",
            "name":"管理系统修改部分",
            "function":"修改信息"
        }，
    ]
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（全部更新成功）
```js
tabledata update complete
```
输出示例3：（部分更新成功）
```js
TID:2 failed, but other tabledata update complete
```
## /application/gettabledata
查询对应AID的application下的所有tabledata以及softwarename与versions

输入示例：
```js
{
    "AID":"34"
}
```

输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：
```js
[]
```
输出示例3：
```js
{"Versions":"1","TableData":[{"functions":"信息插入","name":"管理系统插入部分","id":1,"tID":3},{"functions":"信息查询","name":"管理系统查询部分","id":1,"tID":6}],"SoftwareName":"1"}
```
## /application/deletetabledata
删除对应AID的application下对应TID的tabledata

输入：AID和一个所有需要删除的TID组成的JSONArray

输入示例：
```js
{
    "AID":"34",
    "TID":["1","2"]
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（删除失败）
```js
TID:1，2 failed, no delete complete
```
输出示例3：（部分删除成功）
```js
TID:2 failed,  but other tabledata delete complete
```
输出示例4：（删除成功）
```js
tabledata delete complete
```
## /application/insertopinion
更新对应AID的application下的opinion信息，可重复更新

输入示例：
```js
{
    "AID":"34",
    "Views":"通过",
    "ConfirmOpinion":"没有问题"
}

```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：
```js
opinion insert complete
```

## /application/findopinion
查看对应AID下的opinion

输入示例：
```js
{
    "AID":"34"
}

```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：
```js
{"Views":"通过","ConfirmOpinion":"没有问题"}
```

## /application/insertauditinformation
为对应AID的application添加/修改auditinformation，如果没有auditinformation就是添加，如果有就是修改

输入示例：
```js
{ 
    "AID":"34",
    "Security":"机密",    
    "VirusDetection":{
        "Finish":"已完成",
        "Tool":"火绒"
    },
    "CheckofMaterials":{
        "TestSample":["源代码"],
        "RequirementDocument":["项目计划任务书"],
        "UserDocument":["用户手册"],
        "OperationDocument":["操作员手册"],
        "Other":""
    },
    "ConfirmOpinion":"属依据国家标准或自编非标规范进行的常规检测，有资质、能力和资源满足委托方要求。",
    "OpinionofAcceptance":"受理-进入项目立项和合同评审流程",
    "Number":"0714-02",
    "PS":""
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（添加）
```js
opinion insert complete
```
输出示例3：（修改）
```js
opinion update complete
```

## /application/findauditinformation
查询对应AID的application下的auditinformation

输入示例：
```js
{
    "AID":"34"
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（AID对应的application下没有auditinformation）
```js
AID :34 has no auditinformation
```
输出示例3：
```js
{"VirusDetection":{"Finish":"已完成","Tool":"火绒"},"OpinionofAcceptance":"受理-进入项目立项和合同评审流程","PS":"","Number":"0714-02","CheckofMaterials":{"TestSample":["源代码"],"RequirementDocument":["项目计划任务书"],"UserDocument":["用户手册"],"OperationDocument":["操作员手册"],"Other":""},"Security":"机密","ConfirmOpinion":"属依据国家标准或自编非标规范进行的常规检测，有资质、能力和资源满足委托方要求。"}
```

## /application/deleteauditinformation
删除对应AID的application下的auditinformation

输入示例：
```js
{
    "AID":"34"
}
```
输出示例1：（AID对应的application不存在）
```js
the application does not exist
```
输出示例2：（AID对应的application下没有auditinformation）
```js
AID :34 has no auditinformation
```
输出示例3：
```js
auditinformation delete complete
```
