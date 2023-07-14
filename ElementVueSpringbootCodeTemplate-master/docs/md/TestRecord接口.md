# testrecord接口
author：李晨博

## /testrecord/insert
插入一个testrecord

输入示例：
```
{
    "PID":1,
    "TableData":[
    {
        "TestClassification":"1SAPL",
        "SerialNum":"2SAPL",
        "DesignSpecification":"3SAPL",
        "Regulation":"4SAPL",
        "Precondition":"5SAPL",
        "ExecutionProcess":"6SAPL",
        "ExpectedResult":"7SAPL",
        "Designer":"8SAPL",
        "ActualResult":"9SAPL",
        "BugNum":"0SAPL",
        "UsecaseExecutor":"21L",
        "TestingTime":"S12APL",
        "ConfirmPerson":"S12132APL"
    }
    ]
}
```

输出示例：

```
{"tableid":["6"],"PID":1,"TRID":4}
```

## /testrecord/find
查找一个testrecord

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给TableData返回一个tableid，如果要对TableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"PID":1,"TableData":[{"Precondition":"5SAPL","UsecaseExecutor":"21L","ExecutionProcess":"6SAPL","SerialNum":"2SAPL","Designer":"8SAPL","BugNum":"0SAPL","ExpectedResult":"7SAPL","ActualResult":"9SAPL","DesignSpecification":"3SAPL","ConfirmPerson":"S12132APL","tableid":6,"Regulation":"4SAPL","TestingTime":"S12APL","TestClassification":"1SAPL"}],"TRID":4}]
```

## /testrecord/update
更新testrecord

输入示例：
```
{
    "PID":1,
    "TableData":[
    {
        "TestClassification":"1SAPL",
        "SerialNum":"2SAPL",
        "DesignSpecification":"3SAPL",
        "Regulation":"4SAPL",
        "Precondition":"5SAPL",
        "ExecutionProcess":"6SAPL",
        "ExpectedResult":"7SAPL",
        "Designer":"8SAPL",
        "ActualResult":"9SAPL",
        "BugNum":"0SAPL",
        "UsecaseExecutor":"21L",
        "TestingTime":"S12APL",
        "ConfirmPerson":"S12132APL"
    }
    ]
}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "TestClassification":"1SAPL",
    "SerialNum":"2SAPL",
    "DesignSpecification":"3SAPL",
    "Regulation":"4SAPL",
    "Precondition":"5SAPL",
    "ExecutionProcess":"6SAPL",
    "ExpectedResult":"7SAPL",
    "Designer":"8SAPL",
    "ActualResult":"9SAPL",
    "BugNum":"0SAPL",
    "UsecaseExecutor":"21L",
    "TestingTime":"S12APL",
    "ConfirmPerson":"S12132APL"
}
```
如果是要修改tabledata的内容，需要附带testid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "tableid":"1",
    "TestClassification":"1SAPL",
    "SerialNum":"2SAPL",
    "DesignSpecification":"3SAPL",
    "Regulation":"4SAPL",
    "Precondition":"5SAPL",
    "ExecutionProcess":"6SAPL",
    "ExpectedResult":"7SAPL",
    "Designer":"8SAPL",
    "ActualResult":"9SAPL",
    "BugNum":"0SAPL",
    "UsecaseExecutor":"21L",
    "TestingTime":"S12APL",
    "ConfirmPerson":"S12132APL"
}

```
如果是要删除某个tableData的项，需要附带testid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "tableid":"1",
    "delete":"T",
    "TestClassification":"1SAPL",
    "SerialNum":"2SAPL",
    "DesignSpecification":"3SAPL",
    "Regulation":"4SAPL",
    "Precondition":"5SAPL",
    "ExecutionProcess":"6SAPL",
    "ExpectedResult":"7SAPL",
    "Designer":"8SAPL",
    "ActualResult":"9SAPL",
    "BugNum":"0SAPL",
    "UsecaseExecutor":"21L",
    "TestingTime":"S12APL",
    "ConfirmPerson":"S12132APL"
}
```


输出示例1：
```
the testrecord does not exist
```
输出示例2：
```
{"FailedTableDataID":[]}
```
这里返回的failedid是删除或者修改失败的tableid

## /testrecord/delete
删除testrecord

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the testrecord does not exist
```
输出示例2：
```
testrecord delete complete
```