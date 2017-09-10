### 9 手机APP用户 ###

#### 9.1 登录 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/user/accessToken](http://app.qc-wbo.com/v1/user/accessToken)

###### 请求方法 ######
POST


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | 1a4e06591ef41cc4b3c6e8b232b23e5a |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | sdfsfsdf |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1486954741739 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XXX路 |
| city | String(100) | 城市 | 成都 |
| region | String(100) | 地区 | 武侯 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |
| accessToken | Object | 授权码 | {"accessToken":"53cd7efb-7517-4b03-b4e6-1a8325f58a08","expiration":1488164341846,"expiresIn":1209599} |
| accessToken | String | 授权码 | 53cd7efb-7517-4b03-b4e6-1a8325f58a08 |
| expiration | Long | 过期时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1488164341846 |
| expiresIn | Int | 多少秒后过期 | 1209599 |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "sdfsfsdf",
    "lastLoginDate": 1486954741739,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XXX路",
    "city": "成都",
    "region": "武侯",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com",
    "accessToken": {
        "accessToken": "53cd7efb-7517-4b03-b4e6-1a8325f58a08",
        "expiration": 1488164341846,
        "expiresIn": 1209599
    }
}
```

---
#### 9.2 注册/绑定新手机号发送验证码 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/cellVerifyCodes](http://app.qc-wbo.com/v1/cellVerifyCodes)

###### 请求方法 ######
POST


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |

###### 响应参数 ######

无

---
#### 9.3 找回密码发送验证码 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/cellVerifyCodes/password](http://app.qc-wbo.com/v1/cellVerifyCodes/password)

###### 请求方法 ######
POST


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |

###### 响应参数 ######

无

---
#### 9.4 验证验证码 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/cellVerifyCodes/verify](http://app.qc-wbo.com/v1/cellVerifyCodes/verify)

###### 请求方法 ######
POST

###### 说明 ######
成功返回204


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| code | String | 是 | 验证码 | \- | \- |

###### 响应参数 ######

无

---
#### 9.5 注册 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users](http://app.qc-wbo.com/v1/users)

###### 请求方法 ######
POST


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| code | String | 是 | 验证码 | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| tel | String(20) | 是 | 手机号码 | \- | \- |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | sdfsfsdf |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1486954741739 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XXX路 |
| city | String(100) | 城市 | 成都 |
| region | String(100) | 地区 | 武侯 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |
| accessToken | Object | 授权码 | {"accessToken":"53cd7efb-7517-4b03-b4e6-1a8325f58a08","expiration":1488164341846,"expiresIn":1209599} |
| accessToken | String | 授权码 | 53cd7efb-7517-4b03-b4e6-1a8325f58a08 |
| expiration | Long | 过期时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1488164341846 |
| expiresIn | Int | 多少秒后过期 | 1209599 |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "sdfsfsdf",
    "lastLoginDate": 1486954741739,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XXX路",
    "city": "成都",
    "region": "武侯",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com",
    "accessToken": {
        "accessToken": "53cd7efb-7517-4b03-b4e6-1a8325f58a08",
        "expiration": 1488164341846,
        "expiresIn": 1209599
    }
}
```

---
#### 9.6 查看个人详情 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users/self](http://app.qc-wbo.com/v1/users/self)

###### 请求方法 ######
GET


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | ddddd |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1488271046932 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XX路 |
| city | String(100) | 城市 | 成都市 |
| region | String(100) | 地区 | 武侯区 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "ddddd",
    "lastLoginDate": 1488271046932,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XX路",
    "city": "成都市",
    "region": "武侯区",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com"
}
```

---
#### 9.7 更新资料 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users/self](http://app.qc-wbo.com/v1/users/self)

###### 请求方法 ######
PUT


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| avatar | File(250) | 否 | 头像 | \- | \- |
| name | String(100) | 否 | 名称 | \- | \- |
| region | String(100) | 否 | 地区 | \- | 武侯区 |
| city | String(100) | 否 | 城市 | \- | 成都市 |
| address | String(200) | 否 | 地址 | \- | XX路 |
| sex | Int | 否 | 性别（0：女，1：男，2：未知） | \- | 1 |
| qq | String(100) | 否 | QQ号 | \- | 9389349384 |
| email | String(200) | 否 | 电子邮箱 | \- | xxx@126.com |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | ddddd |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1488271046932 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XX路 |
| city | String(100) | 城市 | 成都市 |
| region | String(100) | 地区 | 武侯区 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "ddddd",
    "lastLoginDate": 1488271046932,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XX路",
    "city": "成都市",
    "region": "武侯区",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com"
}
```

---
#### 9.8 修改手机号 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users/self](http://app.qc-wbo.com/v1/users/self)

###### 请求方法 ######
PUT


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| code | String | 是 | 验证码 | \- | \- |
| oldPassword | String | 是 | 原密码（加密后） | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| tel | String(20) | 是 | 手机号码 | \- | \- |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | sdfsfsdf |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1486954741739 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XXX路 |
| city | String(100) | 城市 | 成都 |
| region | String(100) | 地区 | 武侯 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "sdfsfsdf",
    "lastLoginDate": 1486954741739,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XXX路",
    "city": "成都",
    "region": "武侯",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com"
}
```

---
#### 9.9 修改密码 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users/self](http://app.qc-wbo.com/v1/users/self)

###### 请求方法 ######
PUT


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| oldPassword | String | 是 | 原密码（加密后） | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | sdfsfsdf |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1486954741739 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XXX路 |
| city | String(100) | 城市 | 成都 |
| region | String(100) | 地区 | 武侯 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "sdfsfsdf",
    "lastLoginDate": 1486954741739,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XXX路",
    "city": "成都",
    "region": "武侯",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com"
}
```

---
#### 9.10 找回密码 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/users/password](http://app.qc-wbo.com/v1/users/password)

###### 请求方法 ######
PUT


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| code | String | 是 | 验证码 | \- | \- |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 3 |
| name | String(100) | 名称 | sdfsfsdf |
| lastLoginDate | Long | 最后登录日期（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1486954741739 |
| lastLoginIp | String(200) | 最后登录IP地址 | 127.0.0.1 |
| tel | String(20) | 手机号码 | 18224060100 |
| address | String(200) | 地址 | XXX路 |
| city | String(100) | 城市 | 成都 |
| region | String(100) | 地区 | 武侯 |
| sex | Int | 性别（0：女，1：男，2：未知） | 1 |
| qq | String(100) | QQ号 | 9389349384 |
| email | String(200) | 电子邮箱 | xxx@126.com |
| accessToken | Object | 授权码 | {"accessToken":"53cd7efb-7517-4b03-b4e6-1a8325f58a08","expiration":1488164341846,"expiresIn":1209599} |
| accessToken | String | 授权码 | 53cd7efb-7517-4b03-b4e6-1a8325f58a08 |
| expiration | Long | 过期时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1488164341846 |
| expiresIn | Int | 多少秒后过期 | 1209599 |

###### 响应示例 ######

```json
{
    "id": 3,
    "name": "sdfsfsdf",
    "lastLoginDate": 1486954741739,
    "lastLoginIp": "127.0.0.1",
    "tel": "18224060100",
    "address": "XXX路",
    "city": "成都",
    "region": "武侯",
    "sex": 1,
    "qq": "9389349384",
    "email": "xxx@126.com",
    "accessToken": {
        "accessToken": "53cd7efb-7517-4b03-b4e6-1a8325f58a08",
        "expiration": 1488164341846,
        "expiresIn": 1209599
    }
}
```

---
