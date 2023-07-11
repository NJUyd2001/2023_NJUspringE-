# samplecheck接口
author：李晨博

## /samplecheck/insert
插入一个samplecheck

输入示例：
```
{
    "PID":1,
    "Views":"a",
    "Pass":"T"
}
```

输出示例：
```
{"SID":"1","PID":"1"}
```

## /samplecheck/find
查找一个samplecheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例：
```
[{"SID":1,"Views":"a","Pass":"T"}]
```

## /samplecheck/update
更新samplecheck

输入示例:
```
{
    "PID":1,
    "Views":"a",
    "Pass":"T"
}
```

输出示例1：
```
the samplecheck does not exist
```
输出示例2：
```
samplecheck update complete
```

## /samplecheck/delete
删除samplecheck

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the samplecheck does not exist
```
输出示例2：
```
samplecheck delete complete
```