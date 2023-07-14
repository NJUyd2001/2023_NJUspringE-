# reportcheck接口
author：李晨博

## /reportcheck/insert
插入一个reportcheck

输入示例：
```
{
    "PID":1,
    "SoftWareName":"SAPL",
    "Client":"SAPL",
    "Examiner":"SAPL",
    "Date":"SAPL",
    "tableData": [{
        "num": "1",
        "checkcontent": "报告编号",
        "description": "检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。",
        "radio": "SAPL"
    }, {
        "num": "2",
        "checkcontent": "页码",
        "description": "检查页码与总页数是否正确（报告首页与每页页眉）。",
        "radio": "SAPL"
    }, {
        "num": "3",
        "checkcontent": "软件名称",
        "description": "是否和确认单一致，是否前后一致（共三处，包括首页、报告页、附件三）。",
        "radio": "SAPL"
    }, {
        "num": "12.2",
        "checkcontent": "用户文档测试报告",
        "description": "语句是否通顺，是否准确描述用户的文档。",
        "radio": "SAPL"
    }]
}
```

输出示例：

```
{"tableid":["86","87","88","89"],"PID":1,"CHID":6}
```

## /reportcheck/find
查找一个reportcheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例：

这里会给TableData返回一个tableid，如果要对TableData里的内容进行更新或者删除，这个id是必需的（在/update的部分会再次讲到）
```
[{"SoftWareName":"SAPL","Examiner":"SAPL","PID":1,"tableData":[{"checkcontent":"报告编号","num":"1","tableid":86,"description":"检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。","radio":"SAPL"},{"checkcontent":"页码","num":"2","tableid":87,"description":"检查页码与总页数是否正确（报告首页与每页页眉）。","radio":"SAPL"},{"checkcontent":"软件名称","num":"3","tableid":88,"description":"是否和确认单一致，是否前后一致（共三处，包括首页、报告页、附件三）。","radio":"SAPL"},{"checkcontent":"用户文档测试报告","num":"12.2","tableid":89,"description":"语句是否通顺，是否准确描述用户的文档。","radio":"SAPL"}],"Client":"SAPL","Date":"SAPL","CHID":6}]
```

## /reportcheck/update
更新reportcheck

输入示例：
```
{
    "PID":1,
    "SoftWareName":"SAPL",
    "Client":"SAPL",
    "Examiner":"SAPL",
    "Date":"SAPL",
    "tableData": [{
        "num": "1",
        "checkcontent": "报告编号",
        "description": "检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。",
        "radio": "SAPL"
    }, {
        "num": "2",
        "checkcontent": "页码",
        "description": "检查页码与总页数是否正确（报告首页与每页页眉）。",
        "radio": "SAPL"
    }, {
        "num": "3",
        "checkcontent": "软件名称",
        "description": "是否和确认单一致，是否前后一致（共三处，包括首页、报告页、附件三）。",
        "radio": "SAPL"
    }, {
        "num": "12.2",
        "checkcontent": "用户文档测试报告",
        "description": "语句是否通顺，是否准确描述用户的文档。",
        "radio": "SAPL"
    }]
}
```
这里相当重要的是，在insert之后，对于tableData的所有操作都要在这个端口执行。如果是增加新的tableData，与insert时相同，不需要添加任何内容：
```
{
    "num": "1",
    "checkcontent": "报告编号",
    "description": "检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。",
    "radio": "SAPL"
}
```
如果是要修改tabledata的内容，需要附带testid（除此之外要改什么就写什么，没写的变量不会变）：
```
{
    "tableid":"1",
    "num": "1",
    "checkcontent": "报告编号",
    "description": "检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。",
    "radio": "SAPL"
}

```
如果是要删除某个tableData的项，需要附带testid，同时附带一行变量，key为"delete"，value为"T"（为其他内容则视为update）：
```
{
    "tableid":"1",
    "delete":"T",
    "num": "1",
    "checkcontent": "报告编号",
    "description": "检查报告编号的正确性（是否符合编码规则）与前后的一致性（报告首页与每页页眉）。",
    "radio": "SAPL"
}
```

输出示例1：
```
the reportcheck does not exist
```
输出示例2：
```
{"FailedTableDataID":[]}
```
这里返回的failedid是删除或者修改失败的tableid

## /reportcheck/delete
删除reportcheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the reportcheck does not exist
```
输出示例2：
```
reportcheck delete complete
```