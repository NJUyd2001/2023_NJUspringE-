# testcontent接口
author：李晨博

## /testcontent/insert
插入一个testcontent

输入示例：
```
{
    "PID":1,
    "TableData1":[
    {
        "FunctionModule":"2",
        "FunctionRequirement":"''",
        "TestResult":"''"   
    }
    ],"TableData2":[
    {
        "TestCharacteristic":"1",
        "TestSpecification":"''",
        "TestResult":"''",
    }
    ],"TableData3":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData4":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData5":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData6":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ]
}
```

输出示例：

```
{"testid4":["94"],"testid3":["93"],"testid2":["92"],"testid1":["22"],"PID":1,"TID":14,"testid6":["96"],"testid5":["95"]}
```

## /testcontent/find
查找一个testcontent

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给TableData1-6返回一个testid，如果要对TableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"TableData1":[{"FunctionModule":"2","testid":22,"TestResult":"''","FunctionRequirement":"''"}],"PID":1,"TableData2":[{"TestSpecification":"''","testid":"92","TestResult":"''","TestCharacteristic":"1"}],"TableData3":[{"TestSpecification":"''","testid":"93","TestResult":"''","TestCharacteristic":"''"}],"TableData4":[{"TestSpecification":"''","testid":"94","TestResult":"''","TestCharacteristic":"''"}],"TableData5":[{"TestSpecification":"''","testid":"95","TestResult":"''","TestCharacteristic":"''"}],"TID":14,"TableData6":[{"TestSpecification":"''","testid":"93","TestResult":"''","TestCharacteristic":"''"}]}]
```

## /testcontent/update
更新testcontent

输入示例：
```
{
    "PID":1,
    "TableData1":[
    {
        "testid":"22",
        "FunctionModule":"2",
        "FunctionRequirement":"''",
        "TestResult":"''"   
    }
    ],"TableData2":[
    {
        "testid":"92",
        "delete":"T",
        "TestCharacteristic":"1",
        "TestSpecification":"''",
        "TestResult":"''",
    }
    ],"TableData3":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData4":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData5":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ],"TableData6":[
    {
        "TestCharacteristic":"''",
        "TestSpecification":"''",
        "TestResult":"''"
    }
    ]
}
             
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "FunctionModule":"2",
    "FunctionRequirement":"''",
    "TestResult":"''"   
}

{
    "TestCharacteristic":"1",
    "TestSpecification":"''",
    "TestResult":"''",
}
```
如果是要修改tabledata的内容，需要附带testid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "testid":"22",
    "FunctionModule":"2",
    "FunctionRequirement":"''",
    "TestResult":"''"   
}

{
    "testid":"92",
    "TestCharacteristic":"1",
    "TestSpecification":"''",
    "TestResult":"''",
}
```
如果是要删除某个tableData的项，需要附带testid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "testid":"22",
    "delete":"T",
    "FunctionModule":"2",
    "FunctionRequirement":"''",
    "TestResult":"''"   
}

{
    "testid":"92",
    "delete":"T",
    "TestCharacteristic":"1",
    "TestSpecification":"''",
    "TestResult":"''",
}
```

输出示例1：
```
the testcontent does not exist
```
输出示例2：
```
{"FailedTableDataID6":[],"FailedTableDataID5":[],"FailedTableDataID4":[],"FailedTableDataID3":[],"FailedTableDataID2":[],"FailedTableDataID1":[]}
```
这里返回的failedid是删除或者修改失败的testid

## /testcontent/delete
删除testcontent

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the testcontent does not exist
```
输出示例2：
```
testcontent delete complete
```