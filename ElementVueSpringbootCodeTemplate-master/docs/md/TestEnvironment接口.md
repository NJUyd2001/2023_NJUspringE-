# testenvironment接口
author：李晨博

## /testenvironment/insert
插入一个testenvironment

输入示例：
```
{
    "PID":1,
    "tableData1": [{
        "HardwareCategory": "''",
        "HardwareName":" ''",
        "Setting": "''",
        "Quantity":" ''"
    }],
    "tableData2": [{
        "SoftwareCategory":"'操作系统'",
        "SoftwareName":"''",
        "Edition":"''"
    },{
        "SoftwareCategory":"'软件'",
        "SoftwareName":"''",
        "Edition":"''"
    },{
        "SoftwareCategory":"'被测试样品'",
        "SoftwareName":"''",
        "Edition":"''"
    }],
    "TableData1":[
    {
        "NeededStandard":"''"
    },
    {
        "NeededStandard":"'222'"
    }
    ],
    "TableData2":[
    {
        "ReferenceMaterial":"''"
    }
    ]
}
             
```

输出示例：

```
{"TEID":"1","PID":"1"}
```

## /testenvironment/find
查找一个testenvironment

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给tableData1返回一个hardid，tableData2返回一个softid，如果要对tableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"tableData2":[{"softid":"25","SoftwareCategory":"'操作系统'","SoftwareName":"''","Edition":"''"},{"softid":"26","SoftwareCategory":"'软件'","SoftwareName":"''","Edition":"''"},{"softid":"27","SoftwareCategory":"'被测试样品'","SoftwareName":"''","Edition":"''"}],"tableData1":[{"HardwareName":" ''","hardid":4,"Setting":"''","Quantity":" ''","HardwareCategory":"''"}],"TableData1":[{"NeededStandard":"''"},{"NeededStandard":"'222'"}],"PID":1,"TableData2":[{"ReferenceMaterial":"''"}],"TEID":3}]
```

## /testenvironment/update
更新testenvironment

输入示例：
```
{
    "PID":1,
    "tableData1": [{
        "hardid":"1",
        "delete":"T",
        "HardwareCategory": "''",
        "HardwareName":" ''",
        "Setting": "''",
        "Quantity":" ''"
    }],
    "tableData2": [{
        "softid":"21",
        "delete":"T",
        "SoftwareCategory":"'操作系统'",
        "SoftwareName":"''",
        "Edition":"''"
    },{
        "softid":"3",
        "SoftwareCategory":"'软件'",
        "SoftwareName":"''",
        "Edition":"''"
    },{
        "SoftwareCategory":"'被测试样品'",
        "SoftwareName":"''",
        "Edition":"''"
    }],
    "TableData1":[
    {
        "NeededStandard":"''"
    },
    {
        "NeededStandard":"'222'"
    }
    ],
    "TableData2":[
    {
        "ReferenceMaterial":"''"
    }
    ]
}
             
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "HardwareCategory": "''",
    "HardwareName":" ''",
    "Setting": "''",
    "Quantity":" ''"
}

{
    "SoftwareCategory":"'操作系统'",
    "SoftwareName":"''",
    "Edition":"''"
}
```
如果是要修改tabledata的内容，需要附带hardid/softid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "hardid":"1",
    "HardwareCategory": "''",
    "HardwareName":" ''",
    "Setting": "''",
    "Quantity":" ''"
}

{
    "softid":"21",
    "SoftwareCategory":"'操作系统'",
    "SoftwareName":"''",
    "Edition":"''"
}
```
如果是要删除某个tableData的项，需要附带stableid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "hardid":"1",
    "delete":"T",
    "HardwareCategory": "''",
    "HardwareName":" ''",
    "Setting": "''",
    "Quantity":" ''"
}

{
    "softid":"21",
    "delete":"T",
    "SoftwareCategory":"'操作系统'",
    "SoftwareName":"''",
    "Edition":"''"
}
```
两个TableData的内容你不写就不动，写了就完全覆盖

输出示例1：
```
the testenvironment does not exist
```
输出示例2：
```
{"failedhardid":["1"],"failedsoftid":[]}
```
这里返回的failedid是删除或者修改失败的hard/softid

## /testenvironment/delete
删除testenvironment

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the testenvironment does not exist
```
输出示例2：
```
testenvironment delete complete
```