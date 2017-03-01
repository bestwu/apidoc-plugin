<div mdin style="float: left;width:25%;background-color: #f7f5fa;">

- [文档首页](index.md)

	- [1 系统概述](index.md#1-系统概述)
	- [2 客户端请求说明](index.md#2-客户端请求说明)

---

- [1 手机APP用户](手机APP用户.md)

	- [1.1 登录](手机APP用户.md#1.1登录)
	- [1.2 注册/绑定新手机号发送验证码](手机APP用户.md#1.2注册/绑定新手机号发送验证码)
	- [1.3 修改密码发送验证码](手机APP用户.md#1.3修改密码发送验证码)
	- [1.4 验证验证码](手机APP用户.md#1.4验证验证码)
	- [1.5 注册](手机APP用户.md#1.5注册)
	- [1.6 查看个人详情](手机APP用户.md#1.6查看个人详情)
	- [1.7 更新资料](手机APP用户.md#1.7更新资料)
	- [1.8 找回密码](手机APP用户.md#1.8找回密码)

---
- [2 测试时所用接口](测试时所用接口.md)

	- [2.1 生成测试验证码](测试时所用接口.md#2.1生成测试验证码)

---
- [3 手持端基本](手持端基本.md)

	- [3.1 检查版本号](手持端基本.md#3.1检查版本号)

---
- [4 手持端用户](手持端用户.md)

	- [4.1 登录](手持端用户.md#4.1登录)
	- [4.2 登出](手持端用户.md#4.2登出)
	- [4.3 查看个人信息](手持端用户.md#4.3查看个人信息)
	- [4.4 修改个人信息](手持端用户.md#4.4修改个人信息)
	- [4.5 修改密码](手持端用户.md#4.5修改密码)

---
- [5 手持端订单](手持端订单.md)

	- [5.1 当前订单](手持端订单.md#5.1当前订单)
	- [5.2 历史订单](手持端订单.md#5.2历史订单)
	- [5.3 订单详情](手持端订单.md#5.3订单详情)
	- [5.4 订单状态](手持端订单.md#5.4订单状态)
	- [5.5 订单号查单](手持端订单.md#5.5订单号查单)
	- [5.6 订单号查位置](手持端订单.md#5.6订单号查位置)
	- [5.7 订单接单](手持端订单.md#5.7订单接单)
	- [5.8 到货处理](手持端订单.md#5.8到货处理)
	- [5.9 更新订单轨迹](手持端订单.md#5.9更新订单轨迹)

---

</div>
<div mdin style="float: left;width:74%;margin-left: 1%;">

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

###### 说明
成功返回204

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

</div>
<div style="display:block;position:fixed;z-index:1001;bottom:10px;right:0;margin:0;padding:0;background-color:#c9c9c9">
  <a style="display:block;padding:12px;background:rgba(255,255,255,.5);" href="#">
    <span style="display:block;width:33px;height:24px;">TOP</span>
  </a>
</div>
