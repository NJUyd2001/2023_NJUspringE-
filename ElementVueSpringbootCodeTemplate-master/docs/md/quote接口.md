# Quote接口
author：李晨博

## /quote/insert
插入一个quote

输入示例：
```
{
    "PID":"1",               
    "Time":"1",
    "SoftwareName":"2",
    "item":"q",
    "description":"",
    "UnitPrice":"0",
    "PS":"q",
    "SubTotalPrice":"0",
    "Tax":"0",
    "TotalPrice":"0",
    "Provider":"q"
}
```

输出示例1：
```
the process does not exist
```
输出示例2：
```
{"QID":"1","PID","1"}
```

## /quote/find
查找一个quote

输入示例：
```
{
    "PID":"1"
}
```
输出示例：
```
[{"item":"zIHEQdYUqD","UnitPrice":"o9GysqR729","PS":"ieb6cqzJcR","TotalPrice":"Fhs2ZIR2FI","description":"0pqI2VhxQu","Time":"13:59:16","Tax":"WBfLEGIHMS","QID":3,"SubTotalPrice":"rbUzW54KcX","Provider":"2ugF3AnQF4"}]
```

## /quote/update
更新quote

输入示例:
```
{               
    "PID":"3",
    "Time":"1",
    "SoftwareName":"2",
    "item":"q",
    "description":"",
    "UnitPrice":"0",
    "PS":"q",
    "SubTotalPrice":"0",
    "Tax":"0",
    "TotalPrice":"0",
    "Provider":"q"
}
```

输出示例1：
```
the quote does not exist
```
输出示例2：
```
quote update complete
```

## /quote/delete
删除quote

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the quote does not exist
```
输出示例2：
```
quote delete complete
```