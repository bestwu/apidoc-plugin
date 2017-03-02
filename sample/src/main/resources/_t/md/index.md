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

### 系统概述

系统接口采用REST规范，所有的接口以资源方式提供客户端访问。

[接口授权说明](接口授权说明.md)

[签名算法](签名算法.md)

RESTful Web 服务：

请求方法 | URI | 说明 | 响应的HTTP状态码
---|---|---|---
GET | /{model} | 资源列表 | 200
GET | /{model}/{id} | id对应的资源 | 200
POST | /{model} | 新建资源 | 201
PUT | /{model}/{id} | 更新资源 | 200
DELETE | /{model}/{id} | 删除资源 | 204
DELETE | /{model} | 批量删除资源 | 204

由于restful的特点，服务端不保存用户的状态，所以每次用户访问都须传输自身信息。

### 客户端请求说明

客户端与服务器的通讯通过HTTP内容协商。所以，HTTP请求头应遵守以下规范：

* Accept的格式为:application/json;version=version

> version参数表示要请求的接口的版本。如果不传,服务器将按最低版本响应，强烈建议每次都传入确定的版本信息。

> 服务器接受的有效的Accept格式,(\*/* 、 application/* 、 application/json), 例子： \*/\*;version=1.0、application/*;version=1.0、application/json;version=1.0
错误的Accept服务器将响应406 HTTP Status Code

* User-Agent的格式建议统一为: logistics/version (deviceInfo)

> logistics 为项目代号，固定不变

> version 为客户端版本号

> deviceInfo 为平台信息

> 有效User-Agent,如：logistics/1.0 (iPhone; iOS 8.1.2; Scale/2.00)、logistics/1.0 (Android-4.4.4;Model:MI 4LTE)

#### 响应说明

响应结果状态通过HTTP状态码表达。

##### 响应内容

请求出错时的响应结果，即HTTP状态码>=400时,例子：

``` json
{
  "status": 422,
  "message": "Validation Failed",
  "errors": {
    "first_name": "First name cannot have fancy characters",
    "password": "Password cannot be blank"
  }
}
```

* status：状态码
* message：错误信息
* errors：详细错误信息，errors 内key为错误的字段/错误信息名称，value为错误信息

请求成功时的响应结果，HTTP状态码>=200,<300时：

###### 单个资源时直接响应，例子：

```json
{
  "create_time": 1442309074,
  "id": "1",
  "modify_time": 1442309074,
  "username": "peter"
}
```
###### 列表资源,请求参数支持：page、size、sort,

* page: 页码索引，从1开始，默认1
* size: 每页数量，默认20

例子：

```json
{
      "size": 13,
      "total": 13,
      "pages": 1,
      "list": {
        "id": 3,
        "goodsNo": "718000872243",
        "consigneeName": "\u8d75\u56fd\u67f1",
        "consigneeTel": "18224060100",
        "consigneeAddress": "\u4e3d\u666f\u56ed3\u671f",
        "status": 2,
        "finished": false
      },
      "page": 1
}
```

* list: 资源列表
* page: 页码，从1开始
* size: 每页数量
* total: 总数量
* pages: 总页数
 
##### HTTP 状态码说明

HTTP状态码 | 说明
--- | ---
200 | 请求成功
201 | 资源成功创建
204 | 请求成功，返回空内容
400 | 错误的请求
401 | 未授权
403 | 无权访问
404 | 未找到资源
405 | 不支持的请求方法
406 | 不接受的客户端请求
422 | 请求数据验证失败，参数不正确
500 | 服务器通用错误码

---

</div>
<div style="display:block;position:fixed;z-index:1001;bottom:10px;right:0;margin:0;padding:0;background-color:#c9c9c9">
  <a style="display:block;padding:12px;background:rgba(255,255,255,.5);" href="#">
    <span style="display:block;width:33px;height:24px;">TOP</span>
  </a>
</div>
