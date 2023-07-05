# 后端用户接口手册

## 接口列表及使用规则

#### 注册

网段：`/user/insert`

期待参数体：
``` json
{
    "uname":"",
    "phone":"",
    "emailAddr":"",
    "password":"",
    "type":""
}
```
返回字符串——“注册成功”或错误信息

#### 登录

网段：`/user/login` + `/staff` or `/customer`，必须指明staff或customer

期待参数体：
``` json
{
    "uname":"",
    "password":""
}
```
返回user对象，不存在则为空

#### 查找
1. 全局查找

网段：`/user/selectAll` (+ `/staff` or `customer`)

无参数

返回user list

2. 根据UID查找

网段：`/user/selectByUID`

参数：
``` json
{
    "UID":""
}
```

#### 更新

网段：`/user/update`

期待参数体：
``` json
{
    "UID":"",           //必须
    "new_uname":"",     //以下均为可选
    "new_phone":"",
    "new_emailAddr":"",
    "new_password":"",
    "new_fax":"",
    "new_contact":"",
    "new_zipcode":"",
    "new_ip":"",
    "new_contactTel":"",
    "new_address":""
}
```
返回字符串——“修改成功”或错误信息

#### 删除
网段：`/user/delete`

期待参数体：
``` json
{
    "UID":"",           //必须
}
```
返回字符串——“删除成功”或错误信息


