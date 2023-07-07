# process 操作文档

## 插入

端口：`/process/insert`

参数：（参数没提供则默认为空）
``` js
{
    "UID":"",
    "PID":"",
    "notes":"",  // 备注
    "state":"",  // 状态
    "fileIDs":"" // 进程中上传的文件
    "price":""   // 报价
}
```

返回值：新建进程的PID，发生错误返回-1，并在后端打印错误信息

## 查找

1. 仅查找ID

- 返回AID

端口：`/process/byState/selectAID`

参数：（参数没提供则默认为空）
``` js
{
    "state":""  // 状态
}
```

返回值：对应的AID组成的数组，没有则返回空数组


- 返回PID

端口：`/process/byState/selectPID`

参数：（参数没提供则默认为空）

``` js
{
    "state":""  // 状态
}
```

返回值：对应的PID组成的数组，没有则返回空数组

2. 返回所有信息

- 返回所有

端口：`/process/findAll`

参数：无需参数

返回值：对应的AID组成的数组，没有则返回空数组

返回实例：
``` js
[
    {
        "notes": "2023/7/5 test",
        "price": 562.32,
        "state": "11",
        "fileIDs": "8",
        "aid": 8,
        "pid": 16,
        "uid": 1
    },
    {
        "notes": "2023/7/5 test",
        "price": 100.0,
        "state": "61",
        "fileIDs": "2",
        "aid": 2,
        "pid": 23,
        "uid": 1
    },
    {
        "notes": "2023/7/5 test",
        "price": 100.0,
        "state": "61",
        "fileIDs": "20",
        "aid": 20,
        "pid": 25,
        "uid": 1
    },
    {
        "notes": "2023/7/5 test",
        "price": 100.0,
        "state": "61",
        "fileIDs": "200",
        "aid": 200,
        "pid": 26,
        "uid": 1
    },
    {
        "notes": "wzx",
        "price": 31432.0,
        "state": "11",
        "fileIDs": "27",
        "aid": 27,
        "pid": 114514,
        "uid": 1
    }
]
```

- 根据PID查找

端口：`/process/findByPID`

参数：
``` js
{
    "PID":""  
}
```

返回值：对应PID的进程信息（不是数组，单个对象），没有则返回空

- 根据AID查找

端口：`/process/findByAID`

参数：
``` js
{
    "AID":""  
}
```

返回值：对应AID的进程信息（不是数组，单个对象），没有则返回空

- 根据UID查找

端口：`/process/findByPID`

参数：
``` js
{
    "UID":""  
}
```

返回值：对应UID的所有进程信息（数组），没有则返回空

## 更新

- 仅更新state

端口：`/process/updateState`

参数：
``` js
{
    "PID":""  ,
    "state":""
}
```

返回值：字符串提示

- 更新所有

端口：`/process/update`

参数：
``` js
{
    "PID":""  ,
    "state":"", // 可选参数
    "price":"", // 可选参数
    "notes":""  // 可选参数，备注
}
```

返回值：字符串提示

## 删除 （与文件联动还未实现 on 2023/7/6）

端口：`/process/delete`

参数：
``` js
{
    "PID":""  ,
}
```

返回值：字符串提示