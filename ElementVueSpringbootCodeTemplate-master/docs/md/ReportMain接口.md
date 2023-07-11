# reportmain接口
author：李晨博

## /reportmain/insert
插入一个reportmain

输入示例：
```
{               

    "PID":1,
    "Client":"",
    "ProjectNum":"''",
    "SampleName":"''",
    "Version":"''",
    "SampleDate":"''",
    "TypeTest":"''",
    "TestTime":"''",
    "DevelopmentCompany":"''",
    "SampleStatus":"''",
    "NeededStandard":"''",
    "SampleList":"''",
    "TestConclusion":"''",
    "Organizer":"''",
    "SampleDate1":"''",
    "Auditor":"''",
    "SampleDate2":"",
    "Approver":"''",
    "SampleDate3":"''"


}
```

输出示例：
```
{"RID":"1","PID":"1"}
```

## /reportmain/find
查找一个reportmain

输入示例：
```
{
    "PID":"1"
}
```
输出示例：
```
[{"RID":1,"Client":"","ProjectNum":"''","SampleName":"''","Version":"''","SampleDate":"''","TypeTest":"''","TestTime":"''","DevelopmentCompany":"''","SampleStatus":"''","NeededStandard":"''","SampleList":"''","TestConclusion":"''","Organizer":"''","SampleDate1":"''","Auditor":"''","SampleDate2":"","Approver":"''","SampleDate3":"''"}]
```

## /reportmain/update
更新reportmain

输入示例:
```
{               

    "PID":1,
    "Client":"",
    "ProjectNum":"''",
    "SampleName":"''",
    "Version":"''",
    "SampleDate":"''",
    "TypeTest":"''",
    "TestTime":"''",
    "DevelopmentCompany":"''",
    "SampleStatus":"''",
    "NeededStandard":"''",
    "SampleList":"''",
    "TestConclusion":"''",
    "Organizer":"''",
    "SampleDate1":"''",
    "Auditor":"''",
    "SampleDate2":"",
    "Approver":"''",
    "SampleDate3":"''"


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