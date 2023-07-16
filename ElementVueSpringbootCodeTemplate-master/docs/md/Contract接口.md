# Contract接口
author：李晨博

## /contract/insert
插入一个contract

输入示例：
```js
{
    "PID":"1",
    "ItemName":"测试0715",
    "Client":"南京大学",
    "Trustee":"E组",
    "QC":"特级",
    "date":"2023-06-25T16:00:00.000Z",
    "PeriodOfValidity":"2023-07-10T16:00:00.000Z",
    "ddl":"0",
    "ChangeNumber":"0",
    "ChangeDay":"0",
    "money":"200",
    "Pass":"通过",
    "Views":"无"
}
```
输出示例1：
```js
the process does not exist
```
输出示例2：
```js
{"CID":"1","PID","1"}
```

## /contract/find
查找一个contract

输入示例：
```js
{
    "PID":"1"
}
```
输出示例：
```js
[{"PID":"1","CID":"1","ItemName":"测试0715","Client":"南京大学","Trustee":"E组","QC":"特级","date":"2023-06-25T16:00:00.000Z",
"PeriodOfValidity":"2023-07-10T16:00:00.000Z","ddl":"0","ChangeNumber":"0","ChangeDay":"0","money":"200","Pass":"通过","Views":"无"}]

```

## /contract/update
更新contract

输入示例:
```js
{
    "PID":"1",
    "ItemName":"测试0715",
    "Client":"南京大学",
    "Trustee":"E组",
    "QC":"特级",
    "date":"2023-06-25T16:00:00.000Z",
    "PeriodOfValidity":"2023-07-10T16:00:00.000Z",
    "ddl":"0",
    "ChangeNumber":"0",
    "ChangeDay":"0",
    "money":"200",
    "Pass":"通过",
    "Views":"无"
}
```

输出示例1：
```js
the contract does not exist
```
输出示例2：
```js
contract update complete
```

## /contract/delete
删除contract

输入示例：
```js
{
    "PID":"1"
}
```
输出示例1：
```js
the contract does not exist
```
输出示例2：
```js
contract delete complete
```
