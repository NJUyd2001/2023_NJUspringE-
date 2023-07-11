# agreement接口
author：李晨博

## /agreement/insert
插入一个agreement

输入示例：
```
{
    "PID":1,
    "Client":"1",
    "Trustee":"a",
    "LegalRepresentative1":"a",
    "LegalRepresentative2":"'a",
    "Name":"'a",
    "Date1":"a'",
    "Date2":"a"     
}
```

输出示例：
```
{"PID":"1","AgID":"1"}
```

## /agreement/find
查找一个agreement

输入示例：
```
{
    "QID":"1"
}
```
输出示例：
```
[{"AgID":1,"Client":"1","Trustee":"a","LegalRepresentative1":"a","LegalRepresentative2":"'a","Name":"'a","Date1":"a'","Date2":"a" }]
```

## /agreement/update
更新agreement

输入示例:
```
{
    "PID":1,
    "Client":"1",
    "Trustee":"a",
    "LegalRepresentative1":"a",
    "LegalRepresentative2":"'a",
    "Name":"'a",
    "Date1":"a'",
    "Date2":"a"     
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
```
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