# process 操作文档

## 接口列表

### 插入

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
