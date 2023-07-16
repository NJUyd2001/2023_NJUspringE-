# Quote接口
author：李晨博

## /quote/insert
插入一个quote

输入示例：
```js
{
    "PID":"1",              
    "Time":["2023-07-12T16:00:00.000Z","2023-08-23T16:00:00.000Z"],
    "SoftwareName":"测试0715",
    "item":"测试",
    "description":"测试",
    "UnitPrice":"100",
    "PS":"100",
    "SubTotalPrice":"10000",
    "Tax":"100",
    "TotalPrice":"10000",
    "Provider":"黄大伟"
}
```

输出示例：
```js
{"QID":"1","PID":"1"}
```

## /quote/find
查找一个quote

输入示例：
```js
{
    "PID":"1"
}
```
输出示例：
```js
[{"PID":"1","item":"测试","UnitPrice":"100","PS":"100","TotalPrice":"10000","description":"测试","Time":["2023-07-12T16:00:00.000Z","2023-08-23T16:00:00.000Z"],"Tax":"100","QID":1,"SubTotalPrice":"10000","Provider":"黄大伟"}]
```

## /quote/update
更新quote

输入示例:
```js
{
    "PID":"1",              
    "Time":["2023-07-12T16:00:00.000Z","2023-08-23T16:00:00.000Z"],
    "SoftwareName":"测试0715",
    "item":"测试",
    "description":"测试",
    "UnitPrice":"100",
    "PS":"100",
    "SubTotalPrice":"10000",
    "Tax":"100",
    "TotalPrice":"10000",
    "Provider":"黄大伟"
}
```

输出示例1：
```js
the quote does not exist
```
输出示例2：
```js
quote update complete
```

## /quote/delete
删除quote

输入示例：
```js
{
    "PID":"1"
}
```
输出示例1：
```js
the quote does not exist
```
输出示例2：
```js
quote delete complete
```