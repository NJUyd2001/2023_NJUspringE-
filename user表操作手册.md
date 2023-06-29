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

网段：`/user/selectAll` (+ `/staff` or `customer`)

无参数

返回user list

#### 更新

网段：`/user/update`

期待参数体：
``` json
{
    "UID":"",           //必须
    "new_uname":"",     //可选
    "new_phone":"",     //可选
    "new_emailAddr":"", //可选
    "new_password":"",  //可选
    "new_fax":"",       //可选
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


