# reporttitle接口
author：李晨博

## /reporttitle/insert
插入一个reporttitle

输入示例：
```js
{               
    "PID":1,
    "oftwareName":"测试0715",
    "VersionNumber":"11",
    "Client":"南京大学",
    "TypeTest":"软件功能测试",
    "Date":"2023-07-19T16:00:00.000Z"
}
```

输出示例：
```js
{"RTID":"1","PID","1"}
```

## /reporttitle/find
查找一个reporttitle

输入示例：
```js
{
    "PID":"1"
}
```
输出示例：
```js
[{"TypeTest":"软件功能测试","PID":1,"RTID":15,"Client":"南京大学","SoftwareName":"测试0715","VersionNumber":"11","Date":"2023-07-19T16:00:00.000Z"}]
```

## /reporttitle/update
更新reporttitle

输入示例:
```js
{               
    "PID":1,
    "oftwareName":"测试0715",
    "VersionNumber":"11",
    "Client":"南京大学",
    "TypeTest":"软件功能测试",
    "Date":"2023-07-19T16:00:00.000Z"
}
```

输出示例1：
```js
the reporttitle does not exist
```
输出示例2：
```js
reporttitle update complete
```

## /reporttitle/delete
删除reporttitle

输入示例：
```js
{
    "PID":"1"
}
```
输出示例1：
```js
the reporttitle does not exist
```
输出示例2：
```js
reporttitle delete complete
```