<div mdin style="float: left;width:25%;background-color: #f7f5fa;">

- [文档首页](index.md)

	- [系统概述](index.md#系统概述)
	- [客户端请求说明](index.md#客户端请求说明)
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
<div mdin style="float: left;width:74%;margin-left: 1%;">

### 1 手机APP支付

#### <a href='#1.1我的钱包' name='1.1我的钱包'>1.1 我的钱包</a>

###### 接口地址

[http://127.0.0.1/wallets](http://127.0.0.1/wallets)

###### 请求方法
GET

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| accessToken | object | 是 | \- | 授权码 |  | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| page | int | 否 | \- | 页码，从1开始，默认1 | 1 | 1 |
| size | int | 否 | \- | 每页最大数量，默认20 | 20 | 20 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| money | long | \- | 零钱（单位：分） | 100 |
| size | int | \- | 每页最大数量，默认20 | 2 |
| total | long | \- | 总记录数 | 2 |
| pages | int | \- | 总页数 | 1 |
| list | array | \- | 内容 | [subject:钱包充值, createdDate:1487726987744, totalAmount:100] |
| subject | string | 250 | 交易说明 | 钱包充值 |
| createdDate | long | \- | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1487726987744 |
| totalAmount | long | \- | 交易金额（单元：分） | 100 |
| page | int | \- | 页码，从1开始，默认1 | 1 |

---
#### <a href='#1.2充值' name='1.2充值'>1.2 充值</a>

###### 接口地址

[http://127.0.0.1/wallets/charge](http://127.0.0.1/wallets/charge)

###### 请求方法
POST

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| accessToken | object | 是 | \- | 授权码 |  | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| money | long | 是 | \- | 零钱（单位：分） |  | 1 |
| payment | int | 是 | \- | 支付方式（0：龙支付，1：微信支付，2：支付宝支付，3：银联支付） |  | 2 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| money | long | \- | 零钱（单位：分） | 1 |
| payment | int | \- | 支付方式（0：龙支付，1：微信支付，2：支付宝支付，3：银联支付） | 2 |
| orderInfo | string | \- | 订单参数字符串，用于支付宝客户端调用 | app_id=2016112103042572&biz_content=%7B%22out_trade_no%22%3A%22201702220929471%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22body%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22seller_id%22%3A%222088421595009690%22%7D&charset=UTF-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F127.0.0.1%3A8080%2Fmobile%2Fnotifies%2Falipay&sign_type=RSA2&timestamp=2017-02-22+09%3A29%3A48&version=1.0&sign=lzMHOpwJIFdGMW8n4KIC%2FH9yUcP6w6SRmMMYtnn1o7QP2cMKdjizQIAd%2BddMKQpGVG2nOscTJ7cIiKkOk1rPe8C3Hb6HD6%2BVjIwK78bSCoM5rRI5hngQc6OMAuf52NlbtnNO8iJb6SQViWSP5TWDtYj9IRUPOyVB1bVD44Zw4QQ%3D |

---
#### <a href='#1.3alipay客户端结果验签' name='1.3alipay客户端结果验签'>1.3 alipay客户端结果验签</a>

###### 接口地址

[http://127.0.0.1/alipay/checkClientResult](http://127.0.0.1/alipay/checkClientResult)

###### 请求方法
GET

###### 请求参数

|名称|类型|是否必填|最大长度|描述|默认值|示例值|
|---|---|---|---|---|---|---|
| accessToken | object | 是 | \- | 授权码 |  | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| alipay_trade_app_pay_response | string | 是 | \- | alipay APP支付客户端同步返回结果 |  | {"code":"10000","msg":"Success","total_amount":"9.00","app_id":"2014072300007148","trade_no":"2014112400001000340011111118","seller_id":"2088111111116894","out_trade_no":"70501111111S001111119"} |
| sign | string | 是 | \- | 签名 |  | toffPr9RgL1FuP7BWg3q1JvvG9B0oaP23cqad2ih+cMCaixeEBB0ocwqC8OA4Oo+g03J2Ax8O2Vlf76yjeguZHctlvtunFGLGthhQmEtMIGqlU4G+VZTx/ZlNm8iipOUOILf2EyB55QuSxBC5k5/t1eLnXLlRSwXQljday8hVlU= |
| sign_type | string | 是 | \- | 签名方式 |  | RSA2 |
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| validated | boolean | \- | 验证是否成功 | false |

---

</div>
<div style="display:block;position:fixed;z-index:1001;bottom:10px;right:0;margin:0;padding:0;background-color:#c9c9c9">
  <a style="display:block;padding:12px;background:rgba(255,255,255,.5);" href="#">
    <span style="display:block;width:33px;height:24px;">TOP</span>
  </a>
</div>
