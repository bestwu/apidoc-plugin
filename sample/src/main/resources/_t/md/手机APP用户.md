<div mdin class="catalog">

- [系统介绍](index.md)

- [接口授权说明](接口授权说明.md)
- [签名算法](签名算法.md)

---

- [1 手机APP支付](手机APP支付.md)

	- [1.1 我的钱包](手机APP支付.md#1.1我的钱包)
	- [1.2 充值](手机APP支付.md#1.2充值)
	- [1.3 alipay客户端结果验签](手机APP支付.md#1.3alipay客户端结果验签)

---
- [2 手机APP公共](手机APP公共.md)

	- [2.1 省市区数据](手机APP公共.md#2.1省市区数据)
	- [2.2 配送范围](手机APP公共.md#2.2配送范围)
	- [2.3 收货点](手机APP公共.md#2.3收货点)

---
- [3 手机APP订单](手机APP订单.md)

	- [3.1 我的订单](手机APP订单.md#3.1我的订单)
	- [3.2 个人订单详情](手机APP订单.md#3.2个人订单详情)
	- [3.3 物流状态](手机APP订单.md#3.3物流状态)
	- [3.4 订单轨迹](手机APP订单.md#3.4订单轨迹)
	- [3.5 删除订单](手机APP订单.md#3.5删除订单)
	- [3.6 我要投诉](手机APP订单.md#3.6我要投诉)
	- [3.7 我的投诉](手机APP订单.md#3.7我的投诉)

---
- [4 手机APP用户](手机APP用户.md)

	- [4.1 登录](手机APP用户.md#4.1登录)
	- [4.2 注册/绑定新手机号发送验证码](手机APP用户.md#4.2注册/绑定新手机号发送验证码)
	- [4.3 找回密码发送验证码](手机APP用户.md#4.3找回密码发送验证码)
	- [4.4 验证验证码](手机APP用户.md#4.4验证验证码)
	- [4.5 注册](手机APP用户.md#4.5注册)
	- [4.6 查看个人详情](手机APP用户.md#4.6查看个人详情)
	- [4.7 更新资料](手机APP用户.md#4.7更新资料)
	- [4.8 修改手机号](手机APP用户.md#4.8修改手机号)
	- [4.9 修改密码](手机APP用户.md#4.9修改密码)
	- [4.10 找回密码](手机APP用户.md#4.10找回密码)

---
- [5 测试时所用接口](测试时所用接口.md)

	- [5.1 生成测试验证码](测试时所用接口.md#5.1生成测试验证码)

---
- [6 手持端基本](手持端基本.md)

	- [6.1 检查版本号](手持端基本.md#6.1检查版本号)

---
- [7 手持端用户](手持端用户.md)

	- [7.1 登录](手持端用户.md#7.1登录)
	- [7.2 登出](手持端用户.md#7.2登出)
	- [7.3 查看个人信息](手持端用户.md#7.3查看个人信息)
	- [7.4 修改个人信息](手持端用户.md#7.4修改个人信息)
	- [7.5 修改密码](手持端用户.md#7.5修改密码)

---
- [8 手持端订单](手持端订单.md)

	- [8.1 当前订单](手持端订单.md#8.1当前订单)
	- [8.2 历史订单](手持端订单.md#8.2历史订单)
	- [8.3 订单详情](手持端订单.md#8.3订单详情)
	- [8.4 订单状态](手持端订单.md#8.4订单状态)
	- [8.5 订单号查单](手持端订单.md#8.5订单号查单)
	- [8.6 订单号查位置](手持端订单.md#8.6订单号查位置)
	- [8.7 订单接单](手持端订单.md#8.7订单接单)
	- [8.8 到货处理](手持端订单.md#8.8到货处理)
	- [8.9 更新订单轨迹](手持端订单.md#8.9更新订单轨迹)

---

</div>
<div mdin class="content">

### 4 手机APP用户

#### <a href='#4.1登录' name='4.1登录'>4.1 登录</a>

###### 接口地址

[http://127.0.0.1/user/accessToken](http://127.0.0.1/user/accessToken)

###### 请求方法
POST


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | 1a4e06591ef41cc4b3c6e8b232b23e5a |

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.2注册/绑定新手机号发送验证码' name='4.2注册/绑定新手机号发送验证码'>4.2 注册/绑定新手机号发送验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes](http://127.0.0.1/cellVerifyCodes)

###### 请求方法
POST


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |

###### 响应参数

无

---
#### <a href='#4.3找回密码发送验证码' name='4.3找回密码发送验证码'>4.3 找回密码发送验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes/password](http://127.0.0.1/cellVerifyCodes/password)

###### 请求方法
POST


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |

###### 响应参数

无

---
#### <a href='#4.4验证验证码' name='4.4验证验证码'>4.4 验证验证码</a>

###### 接口地址

[http://127.0.0.1/cellVerifyCodes/verify](http://127.0.0.1/cellVerifyCodes/verify)

###### 请求方法
POST

###### 说明
成功返回204


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| code | String | 是 | 验证码 | \- | \- |

###### 响应参数

无

---
#### <a href='#4.5注册' name='4.5注册'>4.5 注册</a>

###### 接口地址

[http://127.0.0.1/users](http://127.0.0.1/users)

###### 请求方法
POST


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| code | String | 是 | 验证码 | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| tel | String(20) | 是 | 手机号码 | \- | \- |

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.6查看个人详情' name='4.6查看个人详情'>4.6 查看个人详情</a>

###### 接口地址

[http://127.0.0.1/users/self](http://127.0.0.1/users/self)

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.7更新资料' name='4.7更新资料'>4.7 更新资料</a>

###### 接口地址

[http://127.0.0.1/users/self](http://127.0.0.1/users/self)

###### 请求方法
PUT


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

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

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.8修改手机号' name='4.8修改手机号'>4.8 修改手机号</a>

###### 接口地址

[http://127.0.0.1/users/self](http://127.0.0.1/users/self)

###### 请求方法
PUT


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| code | String | 是 | 验证码 | \- | \- |
| oldPassword | String | 是 | 原密码（加密后） | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| tel | String(20) | 是 | 手机号码 | \- | \- |

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.9修改密码' name='4.9修改密码'>4.9 修改密码</a>

###### 接口地址

[http://127.0.0.1/users/self](http://127.0.0.1/users/self)

###### 请求方法
PUT


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| oldPassword | String | 是 | 原密码（加密后） | \- | \- |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |

###### 响应参数

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

###### 响应示例

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
#### <a href='#4.10找回密码' name='4.10找回密码'>4.10 找回密码</a>

###### 接口地址

[http://127.0.0.1/users/password](http://127.0.0.1/users/password)

###### 请求方法
PUT


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| tel | String(20) | 是 | 手机号码 | \- | 18224060100 |
| password | String(100) | 是 | 密码（MD5（明文密码+工号/手机号）） | \- | \- |
| code | String | 是 | 验证码 | \- | \- |

###### 响应参数

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

###### 响应示例

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

</div>
<div class="topAnchor">
  <a href="#">
    <span></span>
  </a>
</div>
