# Application接口文档
author:李晨博

注意！本文档提到的所有接口都应该使用post方法


## /application/insert

增加一个新的application项目

注意！在此处定义AID没有任何意义，AID会变为sql设定的自增变量！

输入示例：
```
{
    "applicantID":"1",
    "processID":"1",
    "time":"2017-09-02 10:29:14",
    "phone":"15968774896",
    "TypeTest":["软件确认测试"],
    "SoftWareName":"蔡徐坤炒粉事件",
    "VersionNumber":"2.5",
    "ClientChinese":"小黑子",
    "ClientEnglish":"ikun",
    "DevelopmentCompany":"C先生",
    "AttributeOfCompany":"内资企业",
    "SoftwareUserObjectDescription":"练习时长两年半",
    "MainFunction":"炒粉不放鸡精",
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
    "SoftWareType":"操纵系统",
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
                "OS":"ji",
                "Versions":"ni",
                "PL":"tai",
                "FrameWork":["服务器端软件架构:C/S"],
                "DataBase":"mei",
                "MiddleWare":"oh",
                "Other":"baby"
            }
        },
        "NetWork":"zhi"
    },
        "SoftwareMedium":["U盘"],
        "Document":"yin",
        "SamplesSubmitted":"中心直接销毁",
        "WantedFinishTime":""
}
```
为空的部分可以直接不加入

输出：该application的AID

输出示例：
```
{"AID"："1"}


```
## /application/checkbyapplicant
根据applicantID项查找所有符合的aplication
输入示例：
```
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
```
[{"SoftWareSize":{"RowNumber":"3","Number":"1","Point":"2"},"RuntimeEnvironment":{"NetWork":"zhi","SoftWare":{"MiddleWare":"oh","Versions":"ni","OS":"ji","PL":"tai","FrameWork":["服务器端软件架构:C/S"],"DataBase":"mei","Other":"baby"},"Client":{"Mermory":"2048MB","OS":{"other":"","Linux":"12108","windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"操纵系统","ClientChinese":"小黑子","Document":"yin","SoftwareUserObjectDescription":"练习时长两年半","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"ikun","SoftWareName":"蔡徐坤炒粉事件","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"炒粉不放鸡精","AttributeOfCompany":"内资企业","time":1504319354000,"AID":"27","applicantID":"1"}]
```
输出示例3：
```
[{"SoftWareSize":{"RowNumber":"3","Number":"1","Point":"2"},"RuntimeEnvironment":{"NetWork":"zhi","SoftWare":{"MiddleWare":"oh","Versions":"ni","OS":"ji","PL":"tai","FrameWork":["服务器端软件架构:C/S"],"DataBase":"mei","Other":"baby"},"Client":{"Mermory":"2048MB","OS":{"other":"","Linux":"12108","windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"操纵系统","ClientChinese":"小黑子","Document":"yin","SoftwareUserObjectDescription":"练习时长两年半","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"ikun","SoftWareName":"蔡徐坤炒粉事件","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"炒粉不放鸡精","AttributeOfCompany":"内资企业","time":1504319354000,"AID":"27","applicantID":"1"},{"SoftWareSize":{"RowNumber":"3","Number":"1","Point":"2"},"RuntimeEnvironment":{"NetWork":"zhi","SoftWare":{"MiddleWare":"oh","Versions":"ni","OS":"ji","PL":"tai","FrameWork":["服务器端软件架构:C/S"],"DataBase":"mei","Other":"baby"},"Client":{"Mermory":"2048MB","OS":{"other":"","Linux":"12108","windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"操纵系统","ClientChinese":"小黑子","Document":"yin","SoftwareUserObjectDescription":"练习时长两年半","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"ikun","SoftWareName":"蔡徐坤炒粉事件","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"炒粉不放鸡精","AttributeOfCompany":"内资企业","time":1504319354000,"AID":"28","applicantID":"123123"}]
```
## /application/checkbyprocess
根据process值查找所有符合的application

输入示例：
```
{
    "processID":"222"
}
```
输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
```
[
    "[]"
]
```
输出示例2：
```
[{"SoftWareSize":{"RowNumber":"3","Number":"1","Point":"2"},"RuntimeEnvironment":{"NetWork":"zhi","SoftWare":{"MiddleWare":"oh","Versions":"ni","OS":"ji","PL":"tai","FrameWork":["服务器端软件架构:C/S"],"DataBase":"mei","Other":"baby"},"Client":{"Mermory":"2048MB","OS":{"other":"","Linux":"12108","windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"操纵系统","ClientChinese":"小黑子","Document":"yin","SoftwareUserObjectDescription":"练习时长两年半","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"ikun","SoftWareName":"蔡徐坤炒粉事件","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"炒粉不放鸡精","AttributeOfCompany":"内资企业","time":1504319354000,"AID":"27","applicantID":"1"}]
```
## /application/checkbyAID
根据AID查找所有符合的application

输入示例：
```
{
    "AID":"27"
}
```
输出：所有符合条件的applicant组成的list，如果没有，则输出空list

输出示例1：（为空）
```
[]
```
输出示例2：
```
[{"SoftWareSize":{"RowNumber":"3","Number":"1","Point":"2"},"RuntimeEnvironment":{"NetWork":"zhi","SoftWare":{"MiddleWare":"oh","Versions":"ni","OS":"ji","PL":"tai","FrameWork":["服务器端软件架构:C/S"],"DataBase":"mei","Other":"baby"},"Client":{"Mermory":"2048MB","OS":{"other":"","Linux":"12108","windows":"xp"},"Other":""}},"TypeTest":["软件确认测试"],"SamplesSubmitted":"中心直接销毁","SoftWareType":"操纵系统","ClientChinese":"小黑子","Document":"yin","SoftwareUserObjectDescription":"练习时长两年半","SoftwareMedium":["U盘"],"VersionNumber":"2.5","WantedFinishTime":"","NeededStandard":["GB/T 25000.51-2016"],"NeededTechnicalIndex":["功能性"],"ClientEnglish":"ikun","SoftWareName":"蔡徐坤炒粉事件","processID":"1","phone":"15968774896","DevelopmentCompany":"C先生","MainFunction":"炒粉不放鸡精","AttributeOfCompany":"内资企业","time":1504319354000,"AID":"27","applicantID":"1"}]
```
## /applicat/findallAID
获得所有application的AID

输入：

一个空JSON


输入示例：
```
{
    "xiaoheizi":"jinitaimei"
}
```
输出示例：
```
[1,2,3,4,12,39]
```
## /application/updateapplication
更新对应AID的application信息

注意！此项更新只看AID，其余所有信息都会被更新覆盖；不改的部分可以不提，包括NOT NULL的部分（ps.算法更新力）


输入示例：
```
{
    "AID":"1",
    "applicantID":"1",
    "processID":"1",
    "time":"2017-09-02 10:29:14",
    "phone":"15968774896",
    "TypeTest":"软件确认测试",
    "SoftWareName":["蔡徐坤炒粉事件"],
    "VersionNumber":"2.5",
    "ClientChinese":"小黑子",
    "ClientEnglish":"ikun",
    "DevelopmentCompany":"C先生",
    "AttributeOfCompany":"内资企业",
    "SoftwareUserObjectDescription":"练习时长两年半",
    "MainFunction":"炒粉不放鸡精",
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
    "SoftWareType":"操纵系统",
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
                "OS":"ji",
                "Versions":"ni",
                "PL":"tai",
                "FrameWork":["服务器端软件架构:C/S"],
                "DataBase":"mei",
                "MiddleWare":"oh",
                "Other":"baby"
            }
        },
        "NetWork":"zhi"
    },
        "SoftwareMedium":["U盘"],
        "Document":"yin",
        "SamplesSubmitted":"中心直接销毁",
        "WantedFinishTime":""
}
```
输出1：（AID对应的application不存在）
```
the application does not exist
```
输出2：（更新成功）
```
update complete
```
## /application/deleteapplication
删除对应AID的application

注意！此处只看AID，所有AID之外的信息都会被无视

输入示例：
```
{
    "AID":"1"
}
```
输出1：（AID对应的application不存在）
```
the application does not exist
```
输出2：（删除成功）
```
delete complete
```
## /application/insertruleform
为指定的application插入ruleform

输入：

包含AID，SoftwareName，Versions和TableData，其中SoftwareName与Version可以为空，如果不为空将会覆盖之前的SoftwareName与Version。

输入示例：
```
{
    "AID":"34",
    "SoftwareName":"1",
    "Versions":"1",
    "TableData":[
        {
            "id":"1",
            "name":"",
            "function":""
        }
    ]
}
```
输出示例1：（AID对应的application不存在）
```
the application does not exist
```
输出示例2：（插入成功）
```
ruleForm insert complete
```
## /application/updateruleform
为指定的application更新指定的ruleform信息

输入：

包含AID，和Tabledata，Tabledata中必须包括TID，以及可选地包含需要修改的信息，不需要更改的不包含。TID可以通过/application/getruleform查询。此接口也可以添加SoftwareName和Versions，以更新信息。

输入示例：
```
{
    "AID":"34",
    "SoftwareName":"1",
    "Versions":"1",
    "TableData":[
        {
            "TID"：1
            "id":"1",
            "name":"",
            "function":""
        }，
        {
            "TID"：2
            "id":"1",
            "name":"",
            "function":""
        }，
    ]
}
```
输出示例1：（AID对应的application不存在）
```
the application does not exist
```
输出示例2：（全部更新成功）
```
ruleForm update complete
```
输出示例3：（部分更新成功）
```
TID:2 failed, but other ruleForm update complete
```
## /application/getruleform
查询对应AID的application下的所有ruleform

输入示例：
```
{
    "AID":"34"
}
```
输出：所有ruleform组成的list

输出示例1：（AID对应的application不存在）
```
the application does not exist
```
输出示例2：
```
[]
```
输出示例3：
```
[{"functions":"","name":"","id":1,"tID":3},{"functions":"","name":"","id":1,"tID":6}]
```
## /application/deleteruleform
删除对应AID的application下对应TID的ruleform

输入：AID和一个所有需要删除的TID组成的JSONArray

输入示例：
```
{
    "AID":"34",
    "TID":["1","2"]
}
```
输出示例1：（AID对应的application不存在）
```
the application does not exist
```
输出示例2：（删除失败）
```
TID:1，2 failed, no delete complete
```
输出示例3：（部分删除成功）
```
TID:2 failed,  but other ruleForm delete complete
```
输出示例4：（删除成功）
```
ruleForm delete complete
```
