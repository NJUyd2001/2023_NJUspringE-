# softwaretest接口
author：李晨博

## /softwaretest/insert
插入一个softwaretest

输入示例：
```
{
    "PID":1,
    "Mark":"''",
    "SystemOverview":"''",
    "DocumentationOverview":"''",
    "BaseLine":"''",
    "Hardware":"''",
    "Software":"''",
    "Other":"''",
    "ParticipatingOrganization":"''",
    "Personnel":"''",
    "TestLevel":"''",
    "TestCategory":"''",
    "GeneralTestCondtion":"''",
    "PlannedExecutionTest":"''",
    "TestCase":"''",
    "TraceabilityOfRequirement":"''",
    "tableData": [{
        "MilestonesTasks":"'制定测试计划'",
        "Workload":"''",
        "Start":"''",
        "End":"''"
    },
    {
        "MilestonesTasks":"'设计测试'",
        "Workload":"''",
        "Start":"''",
        "End":"''"
    }
    ]
}
```

输出示例：

需要注意的是，这里返回一个stableid，是根据tableData顺序返回的唯一性id，如果要对tableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
{"STID":"1","PID":"1","stableid":["1","2"]}
```

## /softwaretest/find
查找一个softwaretest

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里同样会给tableData返回一个stableid，如果要对tableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"ParticipatingOrganization":"''","GeneralTestCondtion":"''","Mark":"''","TraceabilityOfRequirement":"''","PID":1,"tableData":[{"stableid":"7","Start":"''","End":"''","Workload":"''"},{"stableid":"8","Start":"''","End":"''","Workload":"''"},{"stableid":"9","Start":"''","End":"''","Workload":"''"},{"stableid":"10","Start":"''","End":"''","Workload":"''"}],"PlannedExecutionTest":"''","Personnel":"''","TestCategory":"''","TestCase":"''","STID":2,"DocumentationOverview":"''","Hardware":"''","Software":"''","TestLevel":"''","SystemOverview":"''","BaseLine":"''"}]
```

## /softwaretest/update
更新softwaretest

输入示例：
```
{
    "PID":1,
    "Mark":"''",
    "SystemOverview":"''",
    "DocumentationOverview":"''",
    "BaseLine":"''",
    "Hardware":"''",
    "Software":"''",
    "Other":"''",
    "ParticipatingOrganization":"''",
    "Personnel":"''",
    "TestLevel":"''",
    "TestCategory":"''",
    "GeneralTestCondtion":"''",
    "PlannedExecutionTest":"''",
    "TestCase":"''",
    "TraceabilityOfRequirement":"''",
    "tableData": [{
        "MilestonesTasks":"'制定测试计划'",
        "Workload":"''",
        "Start":"''",
        "End":"''"
    },
    {
        "stableid":"1",
        "MilestonesTasks":"'设计测试'",
        "Workload":"''",
        "Start":"''",
        "End":"''"
    },
    {
        "stableid":"2",
        "delete":"T"
    }
    ]
}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "MilestonesTasks":"'制定测试计划'",
    "Workload":"''",
    "Start":"''",
    "End":"''"
}
```
如果是要修改tabledata的内容，需要附带stableid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "stableid":"1",
    "MilestonesTasks":"'制定测试计划'",
    "Workload":"''",
    "Start":"''",
    "End":"''"
}
```
如果是要删除某个tableData的项，需要附带stableid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "stableid":"1",
    "delete":"T"
}
```


输出示例1：
```
the softwaretest does not exist
```
输出示例2：
```
{"failedid":["1"],"stableid":["2","3","4"]}
```
这里返回的failedid是删除或者修改失败的stableid，stableid是还剩下的tableData的stableid（按insert次序排列，同次insert的按insert时在tableData里的顺序排列）

## /softwaretest/delete
删除softwaretest

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the softwaretest does not exist
```
输出示例2：
```
softwaretest delete complete
```