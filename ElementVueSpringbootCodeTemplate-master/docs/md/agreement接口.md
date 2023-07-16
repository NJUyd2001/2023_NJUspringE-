# agreement接口
author：李晨博

## /agreement/insert
插入一个agreement

输入示例：
```js
{
    "PID":1,
    "Client":"黄大伟",
    "Trustee":"南京大学",
    "LegalRepresentative1":"李先生",
    "LegalRepresentative2":"王先生",
    "Name":"学生数据管理系统测试",
    "Date1":"2023-07-16T16:00:00.000Z",
    "Date2":"2023-07-26T16:00:00.000Z"     
}
```

输出示例：
```js
{"PID":"1","AgID":"1"}
```

## /agreement/find
查找一个agreement

输入示例：
```js
{
    "QID":"1"
}
```
输出示例：
```js
[{"AgID":1,"Client":"黄大伟","Trustee":"南京大学","LegalRepresentative1":"李先生","LegalRepresentative2":"王先生","Name":"学生数据管理系统测试","Date1":"2023-07-16T16:00:00.000Z","Date2":"2023-07-26T16:00:00.000Z" }]
```

## /agreement/update
更新agreement

输入示例:
```js
{
    "PID":1,
    "Client":"黄大伟",
    "Trustee":"南京大学",
    "LegalRepresentative1":"李先生",
    "LegalRepresentative2":"王先生",
    "Name":"学生数据管理系统测试",
    "Date1":"2023-07-16T16:00:00.000Z",
    "Date2":"2023-07-26T16:00:00.000Z"     
}
```

输出示例1：
```
the agreement does not exist
```
输出示例2：
```
agreement update complete
```

## /agreement/delete
删除agreement

输入示例：
```js
{
    "PID":"1"
}
```
输出示例1：
```
the agreement does not exist
```
输出示例2：
```
agreement delete complete
```