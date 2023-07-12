# reporttitle接口
author：李晨博

## /reporttitle/insert
插入一个reporttitle

输入示例：
```
{               
    "PID":1,
    "oftwareName":"''",
    "VersionNumber":"''",
    "Client":"''",
    "TypeTest":"''",
    "Date":"''"
}
```

输出示例：
```
{"RTID":"1","PID","1"}
```

## /reporttitle/find
查找一个reporttitle

输入示例：
```
{
    "PID":"1"
}
```
输出示例：
```
[{"RTID":1,"oftwareName":"''","VersionNumber":"''","Client":"''","TypeTest":"''","Date":"''"}]
```

## /reporttitle/update
更新reporttitle

输入示例:
```
{               
    "PID":1,
    "oftwareName":"''",
    "VersionNumber":"''",
    "Client":"''",
    "TypeTest":"''",
    "Date":"''"
}
```

输出示例1：
```
the reporttitle does not exist
```
输出示例2：
```
reporttitle update complete
```

## /reporttitle/delete
删除reporttitle

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the reporttitle does not exist
```
输出示例2：
```
reporttitle delete complete
```