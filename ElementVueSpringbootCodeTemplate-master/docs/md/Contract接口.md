# Contract接口
author：李晨博

## /contract/insert
插入一个contract

输入示例：
```
{
    "PID":"1",
    "ItemName":"",
    "Client":"豪大大2鸡排",
    "Trustee":"''",
    "QC":"''",
    "date":"''",
    "PeriodOfValidity":"''",
    "ddl":"0",
    "ChangeNumber":"0",
    "ChangeDay":"0",
    "money":"1",
    "Pass":"a",
    "Views":"q"
}
```
输出示例1：
```
the process does not exist
```
输出示例2：
```
{"CID":"1","PID","1"}
```

## /contract/find
查找一个contract

输入示例：
```
{
    "PID":"1"
}
```
输出示例：
```
[{"PID":"1","CID":"1","ItemName":"","Client":"豪大大鸡排","Trustee":"''","QC":"''","date":"''",
"PeriodOfValidity":"''","ddl":"0","ChangeNumber":"0","ChangeDay":"0","money":"1","Pass":"a","Views":"q"}]

```

## /contract/update
更新contract

输入示例:
```
{
    "PID":"1",
    "ItemName":"",
    "Client":"豪大大2鸡排",
    "Trustee":"''",
    "QC":"''",
    "date":"''",
    "PeriodOfValidity":"''",
    "ddl":"0",
    "ChangeNumber":"0",
    "ChangeDay":"0",
    "money":"1",
    "Pass":"a",
    "Views":"q"
}

```

输出示例1：
```
the contract does not exist
```
输出示例2：
```
contract update complete
```

## /contract/delete
删除contract

输入示例：
```
{
    "PID":"1"
}
```
输出示例1：
```
the contract does not exist
```
输出示例2：
```
contract delete complete
```
