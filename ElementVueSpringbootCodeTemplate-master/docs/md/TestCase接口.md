# testcase接口
author：李晨博

## /testcase/insert
插入一个testcase

输入示例：
```
{
    "PID":1,
    "TableData":[
    {
                          
        "TestClassification":"我要抓走你的妈妈！",
        "Num":"SAPL",
        "TestCaseDesign":"SAPL",
        "StockDescription":"SAPL",
        "ExpectedResult":"SAPL",
        "Designer":"SAPL",
        "TestTime":"SAPL"
    }
    ]
}
```

输出示例：

```
{"tableid":["7"],"PID":1,"TCID":5}
```

## /testcase/find
查找一个testcase

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给TableData返回一个tableid，如果要对TableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"PID":1,"TableData":[{"TestTime":"SAPL","Designer":"SAPL","ExpectedResult":"SAPL","Num":"SAPL","TestCaseDesign":"SAPL","tableid":7,"StockDescription":"SAPL","TestClassification":"我要抓走你的妈妈！"}],"TCID":5}]
```

## /testcase/update
更新testcase

输入示例：
```
{
    "PID":1,
    "TableData":[
    {
                          
        "TestClassification":"我要抓走你的妈妈！",
        "Num":"SAPL",
        "TestCaseDesign":"SAPL",
        "StockDescription":"SAPL",
        "ExpectedResult":"SAPL",
        "Designer":"SAPL",
        "TestTime":"SAPL"
    }
    ]
}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
                          
    "TestClassification":"我要抓走你的妈妈！",
    "Num":"SAPL",
    "TestCaseDesign":"SAPL",
    "StockDescription":"SAPL",
    "ExpectedResult":"SAPL",
    "Designer":"SAPL",
    "TestTime":"SAPL"
}
```
如果是要修改tabledata的内容，需要附带testid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "tableid":"1",                     
    "TestClassification":"我要抓走你的妈妈！",
    "Num":"SAPL",
    "TestCaseDesign":"SAPL",
    "StockDescription":"SAPL",
    "ExpectedResult":"SAPL",
    "Designer":"SAPL",
    "TestTime":"SAPL"
}

```
如果是要删除某个tableData的项，需要附带testid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "tableid":"1",
    "delete":"T",                      
    "TestClassification":"我要抓走你的妈妈！",
    "Num":"SAPL",
    "TestCaseDesign":"SAPL",
    "StockDescription":"SAPL",
    "ExpectedResult":"SAPL",
    "Designer":"SAPL",
    "TestTime":"SAPL"
}
```

输出示例1：
```
the testcase does not exist
```
输出示例2：
```
{"FailedTableDataID":[]}
```
这里返回的failedid是删除或者修改失败的tableid

## /testcase/delete
删除testcase

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the testcase does not exist
```
输出示例2：
```
testcase delete complete
```