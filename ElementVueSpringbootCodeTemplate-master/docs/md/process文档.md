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
<<<<<<< HEAD:process文档.md
```
=======

输出：

process inserted successfully

## /process/findbyclientid
根据client_id项查找所有符合的process

输入示例：

{
    "client_id":"1"
}

输出：所有符合条件的process组成的list，如果没有，则输出空list


输出示例1：（为空）

[
    "[]"
]

输出示例2：

["[{\"client_id\":1,\"curr_state\":\"A\",\"file_path2\":\"1\",\"file_path3\":\"1\",\"files_path1\":\"1\",\"notes\":\"1\",\"open_to_curr\":\"E\",\"pID\":2,\"price\":1.0,\"record_path\":\"1\"}]"]

输出示例3：

["[{\"client_id\":1,\"curr_state\":\"A\",\"file_path2\":\"1\",\"file_path3\":\"1\",\"files_path1\":\"1\",\"notes\":\"1\",\"open_to_curr\":\"E\",\"pID\":2,\"price\":1.0,\"record_path\":\"1\"},{\"client_id\":1,\"curr_state\":\"A\",\"file_path2\":\"1\",\"file_path3\":\"1\",\"files_path1\":\"1\",\"notes\":\"1\",\"open_to_curr\":\"A\",\"pID\":3,\"price\":1.0,\"record_path\":\"231\"}]"]

## /process/findByPID
根据PID项查找所有符合的process

输入示例：

{
    "PID":"2"
}

输出：所有符合条件的process组成的list，如果没有，则输出空list


输出示例1：（为空）

[
    "[]"
]

输出示例2：

["[{\"client_id\":1,\"curr_state\":\"A\",\"file_path2\":\"1\",\"file_path3\":\"1\",\"files_path1\":\"1\",\"notes\":\"1\",\"open_to_curr\":\"E\",\"pID\":2,\"price\":1.0,\"record_path\":\"1\"}]"]

## /process/update
更新对应PID的process信息

注意！此项更新只看PID，其余所有信息都会被更新覆盖；所有项目都必须提到（如果不想改就维持原样），<font color=red>包括不为NOT NULL的部分！</font>

输入示例：

{
    "PID":"2",
    "client_id":"1",
    "curr_state":"A",
    "notes":"1",
    "price":"1",
    "open_to_curr":"A",
    "file_path1":"1",
    "file_path2":"1",
    "file_path3":"1",
    "record_path":"231"
}

输出1：（PID对应的process不存在）

the process does not exist

输出2：（更新成功）

process update complete

## /process/delete
删除对应PID的process

注意！此处只看PID，所有PID之外的信息都会被无视

输入示例：

{
    "PID":"2"
}

输出1：（PID对应的process不存在）

the process does not exist

输出2：（删除成功）

process delete successfully
>>>>>>> 2311a68b61487d324cde3b3d4a476ee9859e01cd:ElementVueSpringbootCodeTemplate-master/docs/md/process文档.md
