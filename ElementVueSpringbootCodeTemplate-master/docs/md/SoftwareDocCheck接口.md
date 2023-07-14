# softwaredoccheck接口
author：李晨博

## /softwaredoccheck/insert
插入一个softwaredoccheck

输入示例：
```
{
    "PID":"1",
    "tableData": [{
        "ReviewCategories": "'1'",
        "Reviewitem": "'可用性'",
        "ReviewContent": "'产品说明对于用户和潜在需方是可用的",
        "ReviewResultExplanation":" ''",
        "radio":" ''"
    }, {
        "ReviewCategories":" '2'",
        "Reviewitem": "'内容'",
        "ReviewContent": "'足够用于评价适用性",
        "ReviewResultExplanation":" ''",
        "radio":" ''"
    }]
}
```

输出示例：

```
{"tableid":["6","7"],"PID":1,"SCID":3}
```

## /softwaredoccheck/find
查找一个softwaredoccheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给TableData返回一个tableid，如果要对TableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"PID":1,"tableData":[{"ReviewContent":"'产品说明对于用户和潜在需方是可用的","ReviewCategories":"'1'","tableid":4,"Reviewitem":"'可用性'","ReviewResultExplanation":" ''","radio":" ''"},{"ReviewContent":"'足够用于评价适用性","ReviewCategories":" '2'","tableid":5,"Reviewitem":"'内容'","ReviewResultExplanation":" ''","radio":" ''"}],"SCID":2}]
```

## /softwaredoccheck/update
更新softwaredoccheck

输入示例：
```
{
    "PID":"1",
    "tableData": [{
        "ReviewCategories": "'1'",
        "Reviewitem": "'可用性'",
        "ReviewContent": "'产品说明对于用户和潜在需方是可用的",
        "ReviewResultExplanation":" ''",
        "radio":" ''"
    }, {
        "ReviewCategories":" '2'",
        "Reviewitem": "'内容'",
        "ReviewContent": "'足够用于评价适用性",
        "ReviewResultExplanation":" ''",
        "radio":" ''"
    }]
}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "ReviewCategories": "'1'",
    "Reviewitem": "'可用性'",
    "ReviewContent": "'产品说明对于用户和潜在需方是可用的",
    "ReviewResultExplanation":" ''",
    "radio":" ''"
}
```
如果是要修改tabledata的内容，需要附带testid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "tableid":"1",
    "ReviewCategories": "'1'",
    "Reviewitem": "'可用性'",
    "ReviewContent": "'产品说明对于用户和潜在需方是可用的",
    "ReviewResultExplanation":" ''",
    "radio":" ''"
}

```
如果是要删除某个tableData的项，需要附带testid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "tableid":"1",
    "delete":"T",
    "ReviewCategories": "'1'",
    "Reviewitem": "'可用性'",
    "ReviewContent": "'产品说明对于用户和潜在需方是可用的",
    "ReviewResultExplanation":" ''",
    "radio":" ''"
}

```


输出示例1：
```
the softwaredoccheck does not exist
```
输出示例2：
```
{"FailedTableDataID":[]}
```
这里返回的failedid是删除或者修改失败的tableid

## /softwaredoccheck/delete
删除softwaredoccheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the softwaredoccheck does not exist
```
输出示例2：
```
softwaredoccheck delete complete
```