### 1 手机APP用户

#### <a href='#1.1登录' name='1.1登录'>1.1 登录</a>

###### 接口地址

[http://127.0.0.1/user/accessToken](http://127.0.0.1/user/accessToken)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| password | string | 是 | 100 | 密码（MD5（明文密码+工号）） |  | 1a4e06591ef41cc4b3c6e8b232b23e5a |
| tel | string | 是 | 20 | 手机号码 |  | 18224060100 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| accessToken | object | \- | 授权码 | bca64816-41f4-4e84-8048-76e48f49e77f |
| expiration | long | \- | 过期时间（毫秒数） | 1487728510482 |
| expiresIn | int | \- | 多少秒后过期 | 1209600 |
| accessToken | object | \- | 授权码 | [accessToken:bca64816-41f4-4e84-8048-76e48f49e77f, expiration:1487728510482, expiresIn:1209600] |
| address | string | 200 | 公司地址 | 四川省成都市武侯区天华路靠近英郡2期 |
| avatar | string | 250 | 头像 |  |
| city | null | \- | null | 成都市 |
| id | long | \- | 主键ID | 1 |
| lastLoginDate | long | \- | 最后登录日期（毫秒数） | 1486518910384 |
| lastLoginIp | string | 200 | 最后登录IP地址 | 127.0.0.1 |
| name | string | 100 | 名称 | sdd |
| region | null | \- | null | 武侯区 |
| tel | string | 20 | 手机号码 | 18224060100 |

---
#### <a href='#1.2注册/绑定新手机号发送验证码' name='1.2注册/绑定新手机号发送验证码'>1.2 注册/绑定新手机号发送验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes](http://127.0.0.1/cellVerifyCodes)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| tel | string | 是 | 20 | 手机号码 |  | 18224060100 |
###### 响应参数

无

---
#### <a href='#1.3修改密码发送验证码' name='1.3修改密码发送验证码'>1.3 修改密码发送验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes/password](http://127.0.0.1/cellVerifyCodes/password)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| tel | string | 是 | 20 | 手机号码 |  | 18224060100 |
###### 响应参数

无

---
#### <a href='#1.4验证验证码' name='1.4验证验证码'>1.4 验证验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes/verify](http://127.0.0.1/cellVerifyCodes/verify)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| code | string | 是 | \- | 验证码 |  |  |
| tel | string | 是 | 20 | 手机号码 |  | 18224060100 |
###### 响应参数

无

---
#### <a href='#1.5注册' name='1.5注册'>1.5 注册</a>

###### 接口地址

[http://127.0.0.1/users](http://127.0.0.1/users)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| code | string | 是 | \- | 验证码 |  |  |
| password | string | 是 | 100 | 密码（MD5（明文密码+工号）） |  |  |
| tel | string | 是 | 20 | 手机号码 |  |  |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| accessToken | object | \- | 授权码 | bca64816-41f4-4e84-8048-76e48f49e77f |
| expiration | long | \- | 过期时间（毫秒数） | 1487728510482 |
| expiresIn | int | \- | 多少秒后过期 | 1209600 |
| accessToken | object | \- | 授权码 | [accessToken:bca64816-41f4-4e84-8048-76e48f49e77f, expiration:1487728510482, expiresIn:1209600] |
| address | string | 200 | 公司地址 | 四川省成都市武侯区天华路靠近英郡2期 |
| avatar | string | 250 | 头像 |  |
| city | null | \- | null | 成都市 |
| id | long | \- | 主键ID | 1 |
| lastLoginDate | long | \- | 最后登录日期（毫秒数） | 1486518910384 |
| lastLoginIp | string | 200 | 最后登录IP地址 | 127.0.0.1 |
| name | string | 100 | 名称 | sdd |
| region | null | \- | null | 武侯区 |
| tel | string | 20 | 手机号码 | 18224060100 |

---
#### <a href='#1.6查看个人详情' name='1.6查看个人详情'>1.6 查看个人详情</a>

###### 接口地址

[http://127.0.0.1/users/{id}](http://127.0.0.1/users/{id})

###### 请求方法
GET


###### URL参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| id | long | \- | 主键ID | 1 |
###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| accessToken | object | 是 | \- | 授权码 |  | 7e8696eb-85e7-4d25-819a-ccd0ac05dfd4 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| address | string | 200 | 公司地址 | 四川省成都市武侯区天华路靠近英郡2期 |
| avatar | string | 250 | 头像 |  |
| city | null | \- | null | 成都市 |
| id | long | \- | 主键ID | 1 |
| lastLoginDate | long | \- | 最后登录日期（毫秒数） | 1486541073150 |
| lastLoginIp | string | 200 | 最后登录IP地址 | 127.0.0.1 |
| name | string | 100 | 名称 | sdd |
| region | null | \- | null | 武侯区 |
| tel | string | 20 | 手机号码 | 18224060100 |

---
#### <a href='#1.7更新资料' name='1.7更新资料'>1.7 更新资料</a>

###### 接口地址

[http://127.0.0.1/users/{id}](http://127.0.0.1/users/{id})

###### 请求方法
PUT


###### URL参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| id | long | \- | 主键ID | 12 |
###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| accessToken | object | 是 | \- | 授权码 |  | 7e8696eb-85e7-4d25-819a-ccd0ac05dfd4 |
| address | string | 否 | 200 | 公司地址 |  |  |
| avatar | string | 否 | 250 | 头像 |  |  |
| code | string | 否 | \- | 验证码 |  |  |
| name | string | 否 | 100 | 名称 |  |  |
| oldPassword | string | 否 | \- | 原密码（加密后） |  |  |
| password | string | 否 | 100 | 密码（MD5（明文密码+工号）） |  |  |
| tel | string | 否 | 20 | 手机号码 |  | 44444 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| accessToken | object | \- | 授权码 | bca64816-41f4-4e84-8048-76e48f49e77f |
| expiration | long | \- | 过期时间（毫秒数） | 1487728510482 |
| expiresIn | int | \- | 多少秒后过期 | 1209600 |
| accessToken | object | \- | 授权码 | [accessToken:bca64816-41f4-4e84-8048-76e48f49e77f, expiration:1487728510482, expiresIn:1209600] |
| address | string | 200 | 公司地址 | 四川省成都市武侯区天华路靠近英郡2期 |
| avatar | string | 250 | 头像 |  |
| city | null | \- | null | 成都市 |
| id | long | \- | 主键ID | 1 |
| lastLoginDate | long | \- | 最后登录日期（毫秒数） | 1486518910384 |
| lastLoginIp | string | 200 | 最后登录IP地址 | 127.0.0.1 |
| name | string | 100 | 名称 | sdd |
| region | null | \- | null | 武侯区 |
| tel | string | 20 | 手机号码 | 18224060100 |

---
#### <a href='#1.8找回密码' name='1.8找回密码'>1.8 找回密码</a>

###### 接口地址

[http://127.0.0.1/users/password](http://127.0.0.1/users/password)

###### 请求方法
PUT

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| code | string | 是 | \- | 验证码 |  |  |
| password | string | 是 | 100 | 密码（MD5（明文密码+工号）） |  |  |
| tel | string | 是 | 20 | 手机号码 |  | 18224060100 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| accessToken | object | \- | 授权码 | bca64816-41f4-4e84-8048-76e48f49e77f |
| expiration | long | \- | 过期时间（毫秒数） | 1487728510482 |
| expiresIn | int | \- | 多少秒后过期 | 1209600 |
| accessToken | object | \- | 授权码 | [accessToken:bca64816-41f4-4e84-8048-76e48f49e77f, expiration:1487728510482, expiresIn:1209600] |
| address | string | 200 | 公司地址 | 四川省成都市武侯区天华路靠近英郡2期 |
| avatar | string | 250 | 头像 |  |
| city | null | \- | null | 成都市 |
| id | long | \- | 主键ID | 1 |
| lastLoginDate | long | \- | 最后登录日期（毫秒数） | 1486518910384 |
| lastLoginIp | string | 200 | 最后登录IP地址 | 127.0.0.1 |
| name | string | 100 | 名称 | sdd |
| region | null | \- | null | 武侯区 |
| tel | string | 20 | 手机号码 | 18224060100 |

---
