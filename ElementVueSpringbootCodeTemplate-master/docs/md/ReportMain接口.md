# reportmain接口
author：李晨博

## /reportmain/insert
插入一个reportmain

输入示例：
```js
{               

    "PID":1,
    "Client":"南京大学",
    "ProjectNum":"001",
    "SampleName":"测试0715",
    "Version":"110011",
    "SampleDate":"2023-07-08T16:00:00.000Z",
    "TypeTest":"软件功能测试",
    "TestTime":["2023-07-02T16:00:00.000Z","2023-08-21T16:00:00.000Z"],
    "DevelopmentCompany":"E组",
    "SampleStatus":"测试",
    "NeededStandard":"测试",
    "SampleList":"测试",
    "TestConclusion":"测试",
    "Organizer":"测试",
    "SampleDate1":"2023-07-02T16:00:00.000Z",
    "Auditor":"测试",
    "SampleDate2":"2023-07-02T16:00:00.000Z",
    "Approver":"测试",
    "SampleDate3":"2023-07-02T16:00:00.000Z"


}
```

输出示例：
```js
{"RID":"1","PID":"1"}
```

## /reportmain/find
查找一个reportmain

输入示例：
```js
{
    "PID":"1"
}
```
输出示例：
```js
[{"TestTime":["2023-07-02T16:00:00.000Z","2023-08-21T16:00:00.000Z"],"SampleStatus":"测试","SampleName":"测试0715","Organizer":"测试","TypeTest":"软件功能测试","PID":1,"SampleDate":"2023-07-08T16:00:00.000Z","ProjectNum":"001","RID":14,"NeededStandard":"测试","Auditor":"测试","Version":"110011","DevelopmentCompany":"E组","TestConclusion":"测试","Approver":"测试","Client":"南京大学","SampleDate3":"2023-07-06T16:00:00.000Z","SampleDate2":"2023-07-04T16:00:00.000Z","SampleList":"测试","SampleDate1":"2023-07-02T16:00:00.000Z"}]
```

## /reportmain/update
更新reportmain

输入示例:
```js
{               

    "PID":1,
    "Client":"南京大学",
    "ProjectNum":"001",
    "SampleName":"测试0715",
    "Version":"110011",
    "SampleDate":"2023-07-08T16:00:00.000Z",
    "TypeTest":"软件功能测试",
    "TestTime":["2023-07-02T16:00:00.000Z","2023-08-21T16:00:00.000Z"],
    "DevelopmentCompany":"E组",
    "SampleStatus":"测试",
    "NeededStandard":"测试",
    "SampleList":"测试",
    "TestConclusion":"测试",
    "Organizer":"测试",
    "SampleDate1":"2023-07-02T16:00:00.000Z",
    "Auditor":"测试",
    "SampleDate2":"2023-07-02T16:00:00.000Z",
    "Approver":"测试",
    "SampleDate3":"2023-07-02T16:00:00.000Z"


}
```

输出示例1：
```
the reportmain does not exist
```
输出示例2：
```
reportmain update complete
```

## /reportmain/delete
删除reportmain

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the reportmain does not exist
```
输出示例2：
```
reportmain delete complete
```