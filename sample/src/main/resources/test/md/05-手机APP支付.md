### 5 手机APP支付 ###

#### 5.1 我的钱包 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/wallets](http://app.qc-wbo.com/v1/wallets)

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
| page | Int | 否 | 页码，从1开始，默认1 | 1 | 1 |
| size | Int | 否 | 每页最大数量，默认20 | 20 | 20 |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| money | Long | 零钱（单位：分） | 100 |
| size | Int | 每页最大数量，默认20 | 2 |
| total | Long | 总记录数 | 2 |
| pages | Int | 总页数 | 1 |
| list | Array | 内容 | [{"subject":"钱包充值","createdDate":1487726987744,"totalAmount":100}] |
| subject | String(250) | 交易说明 | 钱包充值 |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1487726987744 |
| totalAmount | Long | 交易金额（单元：分） | 100 |
| page | Int | 页码，从1开始，默认1 | 1 |

###### 响应示例 ######

```json
{
    "money": 100,
    "size": 2,
    "total": 2,
    "pages": 1,
    "list": [
        {
            "subject": "钱包充值",
            "createdDate": 1487726987744,
            "totalAmount": 100
        },
        {
            "subject": "钱包充值",
            "createdDate": 1487726987744,
            "totalAmount": 100
        }
    ],
    "page": 1
}
```

---
#### 5.2 充值 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/wallets/charge](http://app.qc-wbo.com/v1/wallets/charge)

###### 请求方法 ######
POST


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数 ######

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| money | Long | 是 | 零钱（单位：分） | \- | 1 |
| payment | Int | 是 | 支付方式（0：龙支付，1：微信支付，2：支付宝支付，3：银联支付） | \- | 2 |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| money | Long | 零钱（单位：分） | 1 |
| payment | Int | 支付方式（0：龙支付，1：微信支付，2：支付宝支付，3：银联支付） | 2 |
| orderInfo | String | 订单参数字符串，用于支付宝客户端调用 | app_id=2016112103042572&biz_content=%7B%22out_trade_no%22%3A%22201702220929471%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22body%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22seller_id%22%3A%222088421595009690%22%7D&charset=UTF-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F127.0.0.1%3A8080%2Fmobile%2Fnotifies%2Falipay&sign_type=RSA2&timestamp=2017-02-22+09%3A29%3A48&version=1.0&sign=lzMHOpwJIFdGMW8n4KIC%2FH9yUcP6w6SRmMMYtnn1o7QP2cMKdjizQIAd%2BddMKQpGVG2nOscTJ7cIiKkOk1rPe8C3Hb6HD6%2BVjIwK78bSCoM5rRI5hngQc6OMAuf52NlbtnNO8iJb6SQViWSP5TWDtYj9IRUPOyVB1bVD44Zw4QQ%3D |

###### 响应示例 ######

```json
{
    "money": 1,
    "payment": 2,
    "orderInfo": "app_id=2016112103042572&biz_content=%7B%22out_trade_no%22%3A%22201702220929471%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22body%22%3A%22%E9%92%B1%E5%8C%85%E5%85%85%E5%80%BC%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22seller_id%22%3A%222088421595009690%22%7D&charset=UTF-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F127.0.0.1%3A8080%2Fmobile%2Fnotifies%2Falipay&sign_type=RSA2&timestamp=2017-02-22+09%3A29%3A48&version=1.0&sign=lzMHOpwJIFdGMW8n4KIC%2FH9yUcP6w6SRmMMYtnn1o7QP2cMKdjizQIAd%2BddMKQpGVG2nOscTJ7cIiKkOk1rPe8C3Hb6HD6%2BVjIwK78bSCoM5rRI5hngQc6OMAuf52NlbtnNO8iJb6SQViWSP5TWDtYj9IRUPOyVB1bVD44Zw4QQ%3D"
}
```

---
#### 5.3 alipay客户端结果验签 ####

###### 接口地址 ######

[http://app.qc-wbo.com/v1/alipay/checkClientResult](http://app.qc-wbo.com/v1/alipay/checkClientResult)

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
| alipay_trade_app_pay_response | String | 是 | alipay APP支付客户端同步返回结果 | \- | {"code":"10000","msg":"Success","total_amount":"9.00","app_id":"2014072300007148","trade_no":"2014112400001000340011111118","seller_id":"2088111111116894","out_trade_no":"70501111111S001111119"} |
| sign | String | 是 | 签名 | \- | toffPr9RgL1FuP7BWg3q1JvvG9B0oaP23cqad2ih+cMCaixeEBB0ocwqC8OA4Oo+g03J2Ax8O2Vlf76yjeguZHctlvtunFGLGthhQmEtMIGqlU4G+VZTx/ZlNm8iipOUOILf2EyB55QuSxBC5k5/t1eLnXLlRSwXQljday8hVlU= |
| sign_type | String | 是 | 签名方式 | \- | RSA2 |

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| validated | Boolean | 验证是否成功 | false |

###### 响应示例 ######

```json
{
    "validated": "false"
}
```

---
