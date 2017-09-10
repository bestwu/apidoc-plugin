<div mdin class="catalog">

---

---
- [2 手机APP租赁](手机APP租赁.md)

	- [2.1 租赁订单续约](手机APP租赁.md#2.1租赁订单续约)
	- [2.2 删除数据](手机APP租赁.md#2.2删除数据)

---

</div>
<div mdin class="content">

### 2 手机APP租赁

#### <a href='#2.1租赁订单续约' name='2.1租赁订单续约'>2.1 租赁订单续约</a>

###### 接口地址

[http://app.qc-wbo.com/v1/rentOrderDefer.php](http://app.qc-wbo.com/v1/rentOrderDefer.php)

###### 请求方法
POST


###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| ui_id | Long | 是 | 用户主键ID | '0' | 132 |
| ui_nd | String(80) | 是 | 用户ND | '' | 1 |
| dtype | Int | 否 | 从什么地方发出的请求（0:android 1:ios 2:PDA 3: web 4:道闸 5：MEPOS 6：地磁设备android板） | \- | 2 |
| rd_id | Long | 是 | 主键ID | \- | 3 |
| pi_id | Long | 否 | 停车场主键ID | '0' | 36 |
| area_code | String(30) | 否 | 停车场地址编码 | '' | 510107 |
| month_num | Int | 是 | 续约月份个数 | '0' | 1 |
| client_ruleid | String(80) | 否 | 客户端的规则ID | '' | d425aa1dcb1a444fbfa9a32ebafa30ea |
| car_code | String(80) | 否 | 用户车牌号 | '' | 川A12348 |
| permit_time | String(80) | 否 | 允许时间段（8：00-23：00） | '' | 8：00-23：00 |
| pay_source | Int | 否 | 支付类型 0：现金 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付  6:ETC快捷支付 | '0' | 2 |
| rent_type | Int | 是 | 租赁类型（0：普通时间段  1：早半天  2：晚半天  3：全天） | '0' | 1 |
| sign | String | 是 | MD5数字签名( dtype+ui_nd+rd_id)按参数的首字母升序顺序进行组装 | \- | 9a3b04abfd6af613c8b9e988c2661479 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| data | String | 数据 | {"allege_state":0,"area_code":"510107","car_code":"川A12348","client_order_id":"''","client_rule_id":"d425aa1dcb1a444fbfa9a32ebafa30ea","ctime":1500271460630,"defer_state":1,"endtime":1499586372000,"father_order_id":"''","flag":2,"is_del":0,"is_expire":0,"money":10,"month_num":1,"mq_state":0,"note":"APP续租租赁信息","pay_source":2,"pay_state":0,"permit_time":"8：00-23：00","pi_id":36,"pi_name":"天府三街停车场","pu_id":0,"pu_nd":"''","rd_id":40,"rent_order_id":"5101072000000364201707171404206h","rent_type":1,"son_order_id":"''","starttime":1496994372000,"stime":1500271460630,"ui_id":132,"ui_nd":"1","unit_price":10,"up_orderid":"''","utime":1500271460630} |
| allege_state | Int | 申述状态 0:未申述 1：申述中  2：申述失败 3：申述成功 | 0 |
| area_code | String(30) | 停车场地址编码 | 510107 |
| car_code | String(80) | 用户车牌号 | 川A12348 |
| client_order_id | String(80) | 客户端的租赁订单号 | '' |
| client_rule_id | String(80) | 客户端的规则ID | d425aa1dcb1a444fbfa9a32ebafa30ea |
| ctime | Long | 客户端创建时间 | 1500271460630 |
| defer_state | Int | 续约状态（0：未续约  1：续约中  2：续约成功 3：续约失败   4：续约超时失败-退款钱包） | 1 |
| endtime | Long | 到期时间 | 1499586372000 |
| father_order_id | String(80) | 父亲订单（父订单）ID | '' |
| flag | Int | 续约来源（0：未知 1：道闸  2：线上） | 2 |
| is_del | Int | 是否逻辑删除(0:正常 1：删除) | 0 |
| is_expire | Int | 是否已经到期（0：未到期 1：已经到期） | 0 |
| money | Int | 租赁续期金额（单位 分） | 10 |
| month_num | Int | 续约月份个数 | 1 |
| mq_state | Int | 是否MQ推送（0：没有 1：推送成功  2：推送失败  ） | 0 |
| note | String(100) | 备注 | APP续租租赁信息 |
| pay_source | Int | 支付类型 0：现金 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付  6:ETC快捷支付 | 2 |
| pay_state | Int | 支付状态（0：未支付 1：支付成功  2：支付失败） | 0 |
| permit_time | String(80) | 允许时间段（8：00-23：00） | 8：00-23：00 |
| pi_id | Long | 停车场主键ID | 36 |
| pi_name | String(80) | 停车场名称 | 天府三街停车场 |
| pu_id | Long | 商户主键ID | 0 |
| pu_nd | String(80) | 商户ND | '' |
| rd_id | Long | 主键ID | 40 |
| rent_order_id | String(80) | 租赁订单号 | 5101072000000364201707171404206h |
| rent_type | Int | 租赁类型（0：普通时间段  1：早半天  2：晚半天  3：全天） | 1 |
| son_order_id | String(80) | 子续约订单ID | '' |
| starttime | Long | 开始时间 | 1496994372000 |
| stime | Long | 服务器端接收时间 | 1500271460630 |
| ui_id | Long | 用户主键ID | 132 |
| ui_nd | String(80) | 用户ND | 1 |
| unit_price | Int | 租赁每个月单价（单位分） | 10 |
| up_orderid | String(80) | 平台支付流水单号 | '' |
| utime | Long | 更新时间 | 1500271460630 |
| errorcode | Int | 当errorno=0的时候 区分错误类别 例如：0: 用户不存在 1:用户余额不足 | \- |
| errormsg | String | 错误信息 | 租赁订单续约新增成功 |
| errorno | Int | 错误代码 0：正确  1：有错误 | 0 |

###### 响应示例

```json
{
    "data": {
        "allege_state": 0,
        "area_code": "510107",
        "car_code": "川A12348",
        "client_order_id": "''",
        "client_rule_id": "d425aa1dcb1a444fbfa9a32ebafa30ea",
        "ctime": 1500271460630,
        "defer_state": 1,
        "endtime": 1499586372000,
        "father_order_id": "''",
        "flag": 2,
        "is_del": 0,
        "is_expire": 0,
        "money": 10,
        "month_num": 1,
        "mq_state": 0,
        "note": "APP续租租赁信息",
        "pay_source": 2,
        "pay_state": 0,
        "permit_time": "8：00-23：00",
        "pi_id": 36,
        "pi_name": "天府三街停车场",
        "pu_id": 0,
        "pu_nd": "''",
        "rd_id": 40,
        "rent_order_id": "5101072000000364201707171404206h",
        "rent_type": 1,
        "son_order_id": "''",
        "starttime": 1496994372000,
        "stime": 1500271460630,
        "ui_id": 132,
        "ui_nd": "1",
        "unit_price": 10,
        "up_orderid": "''",
        "utime": 1500271460630
    },
    "errorcode": "",
    "errormsg": "租赁订单续约新增成功",
    "errorno": "0"
}
```

---
#### <a href='#2.2删除数据' name='2.2删除数据'>2.2 删除数据</a>

###### 接口地址

[http://app.qc-wbo.com/v1/rentdeferdel.php](http://app.qc-wbo.com/v1/rentdeferdel.php)

###### 请求方法
POST


###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| ui_id | Long | 是 | 用户主键ID | '0' | 132 |
| ui_nd | String(80) | 是 | 用户ND | '' | 1 |
| dtype | Int | 否 | 从什么地方发出的请求（0:android 1:ios 2:PDA 3: web 4:道闸 5：MEPOS 6：地磁设备android板） | \- | 2 |
| pi_id | Long | 否 | 停车场主键ID | '0' | 36 |
| area_code | String(30) | 否 | 停车场地址编码 | '' | 510107 |
| car_code | String(80) | 否 | 用户车牌号 | '' | 川A11111 |
| rd_id | Long | 是 | 主键ID | \- | 3 |
| sign | String | 是 | MD5数字签名( dtype+rd_id+ui_nd)按参数的首字母升序顺序进行组装 | \- | 9a3b04abfd6af613c8b9e988c2661479 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| data | String | 数据 | \- |
| errorcode | Int | 当errorno=0的时候 区分错误类别 例如：0: 用户不存在 1:用户余额不足 | \- |
| errormsg | String | 错误信息 | 操作成功 |
| errorno | Int | 错误代码 0：正确  1：有错误 | 0 |

###### 响应示例

```json
{
    "data": "",
    "errorcode": "",
    "errormsg": "操作成功",
    "errorno": "0"
}
```

---

</div>
<div class="topAnchor">
  <a href="#">
    <span></span>
  </a>
</div>
