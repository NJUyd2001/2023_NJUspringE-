# Process文档
author：李晨博

# 数据结构


注：这段内容是根据王辰枫在MySQL当中的注释整理而来的，如果有疑问，除去联系我，也请额外联系他，谢谢！


|key|数据类型|数据含义|是否不能为空（NOT NULL）|
|---|---|---|---|
|PID（主键）|int|进程号|NOT NULL|
|client_id|int|客户id|NOT NULL|
|curr_state|enum|审核结果<br />R：委托被拒绝,<br />W：待审核,<br />P：正在审核中（已经有人再审了）,<br />A：审核通过|NOT NULL|
|notes|string|备注|-|
|price|double|价格|-|
|open_to_curr|enum|open_to_curr是一个标号，用于记录流程当前执行情况，例如“正在由xx部门处理”这样的信息,<br />A：市场部生成合同草稿给客户,<br />B：客户填写合同给市场部审核,<br />C：用户发送样品给市场部验收,<br />D：测试部提交方案给质量部审核,<br />E：测试部提交测试报告给测试部主管,<br />F：用户审核（后存一个流程记录 -- 暂定）,<br />G：授权签字人签字测试报告后发送给客户,<br />H：客户确认收到或到期自动确认|NOT NULL|
|file_path1|string|存储文件路径1<br /><font size=2>这部分文件路径使用方法视情况而定，前端自己约定好就行</font>|-|
|file_path2|string|存储文件路径2|-|
|file_path3|string|存储文件路径3|-|
|record_path|string|存储每个经手人的uid|NOT NULL|

# 接口

## /process/inset
增加一个新的process项目

注意！所有数据文档中除去PID以外的NOT NULL的key必须都有定义，否则会报错！在此处定义PID没有任何意义，PID会变为sql设定的自增变量！


输入示例：

{
   "client_id":"1",
   "curr_state":"A",
   "notes":"1",
   "price":"1",
   "open_to_curr":"E",
   "file_path1":"1",
   "file_path2":"1",
   "file_path3":"1",
   "record_path":"1"
}

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

## /process/findbyPID
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