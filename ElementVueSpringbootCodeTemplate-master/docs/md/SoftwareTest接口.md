# softwaretest接口
author：李晨博

## /softwaretest/insert
插入一个softwaretest

输入示例：
```js
{
    "PID":1,
    "Mark":"南京",
    "SystemOverview":"南",
    "DocumentationOverview":"京",
    "BaseLine":"大",
    "Hardware":"学",
    "Software":"大",
    "Other":"京",
    "ParticipatingOrganization":"南",
    "Personnel":"小组六人",
    "TestLevel":"",
    "TestCategory":"",
    "GeneralTestCondtion":"测试",
    "PlannedExecutionTest":"测试",
    "TestCase":"",
    "TraceabilityOfRequirement":"ke",
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
    ],
    "ApplicationFile":"学",
    "VersionNumber":"11211",
    "SoftWareName","测试0715",
    "TypeTest","软件测试"


}
```

输出示例：

需要注意的是，这里返回一个stableid，是根据tableData顺序返回的唯一性id，如果要对tableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```js
{"STID":"1","PID":"1","stableid":["1","2"]}
```

## /softwaretest/find
查找一个softwaretest

输入示例：
```js
{
    "PID":"1"
}
```
输出示例：

这里同样会给tableData返回一个stableid，如果要对tableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```js
[{"ParticipatingOrganization":"南","TypeTest":"软件测试","Mark":"南京","TraceabilityOfRequirement":"ke","PID":1,"GeneralTestCondition":"测试","tableData":[{"stableid":"71","Start":"7.15","End":"7.17","Workload":"测试"},{"stableid":"72","Start":"7.15","End":"7.17","Workload":"测试"},{"stableid":"73","Start":"7.15","End":"7.17","Workload":"测试"},{"stableid":"74","Start":"7.15","End":"7.17","Workload":"测试"}],"PlannedExecutionTest":"测试","Personnel":"小组六人","VersionNumber":"11211","TestCategory":"","SoftWareName":"测试0715","TestCase":"","ApplicationFile":"学","STID":18,"DocumentationOverview":"京","Hardware":"学","Software":"大","TestLevel":"","SystemOverview":"南","BaseLine":"大","Other":"京"}]
```

## /softwaretest/update
更新softwaretest

输入示例：
```js
{
    "PID":1,
    "Mark":"南京",
    "SystemOverview":"南",
    "DocumentationOverview":"京",
    "BaseLine":"大",
    "Hardware":"学",
    "Software":"大",
    "Other":"京",
    "ParticipatingOrganization":"南",
    "Personnel":"小组六人",
    "TestLevel":"",
    "TestCategory":"",
    "GeneralTestCondtion":"测试",
    "PlannedExecutionTest":"测试",
    "TestCase":"",
    "TraceabilityOfRequirement":"ke",
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
    ],
    "ApplicationFile":"学",
    "VersionNumber":"11211",
    "SoftWareName","测试0715",
    "TypeTest","软件测试"


}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```js
{
    "MilestonesTasks":"'制定测试计划'",
    "Workload":"''",
    "Start":"''",
    "End":"''"
}
```
如果是要修改tabledata的内容，需要附带stableid（除此之外要改什么就写什么，没写的变量不会变）：
```js
{
    "stableid":"1",
    "MilestonesTasks":"'制定测试计划'",
    "Workload":"''",
    "Start":"''",
    "End":"''"
}
```
如果是要删除某个tableData的项，需要附带stableid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```js
{
    "stableid":"1",
    "delete":"T"
}
```


输出示例1：
```js
the softwaretest does not exist
```
输出示例2：
```js
{"failedid":["1"],"stableid":["2","3","4"]}
```
这里返回的failedid是删除或者修改失败的stableid，stableid是还剩下的tableData的stableid（按insert次序排列，同次insert的按insert时在tableData里的顺序排列）

## /softwaretest/delete
删除softwaretest

输入示例：
```js
{
    "PID":"1"
}
```
输出示例1：
```js
the softwaretest does not exist
```
输出示例2：
```js
softwaretest delete complete
```