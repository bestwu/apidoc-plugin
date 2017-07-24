### 3 手机APP订单

#### 3.1 我的订单

###### 接口地址

[http://app.qc-wbo.com/v1/waybills/self](http://app.qc-wbo.com/v1/waybills/self)

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
| type | Enum | 否 | 订单查询状态：0:全部，1：待配送，2：配送中，3：已完成，4：已退货，默认为：0 | 0 | 0 |
| keyword | String | 否 | 关键字 | \- | \- |
| page | Int | 否 | 页码，从1开始，默认1 | 1 | 1 |
| size | Int | 否 | 每页最大数量，默认20 | 20 | 20 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| size | Int | 每页最大数量，默认20 | 20 |
| total | Long | 总记录数 | 98 |
| pages | Int | 总页数 | 5 |
| list | Array | 内容 | [{"id":174,"sysNo":"YT20170122102902","goodsNo":"718000872251","status":0,"createdDate":1485052172929,"goodsNum":2,"companyName":"伊藤洋华堂（眉山店）","queryStatus":1}] |
| id | Long | 主键ID | 174 |
| sysNo | String(100) | 系统运单号 | YT20170122102902 |
| goodsNo | String(100) | 货物运单号 | 718000872251 |
| status | Int | 状态（0：等待配送，1：开始配送，2：中转，3：签收，4：其他成功情况，5：拒收，6：其他失败情况，7：收到退货，8：滞留，9：自提，10：生成新运单，11：其他，12：完成） | 0 |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1485052172929 |
| goodsNum | Int | 货物数量 | 2 |
| companyName | String(100) | 所属公司名称 | 伊藤洋华堂（眉山店） |
| queryStatus | Int | 显示状态：1：待配送，2：配送中，3：已完成，4：已退货 | 1 |
| page | Int | 页码，从1开始，默认1 | 1 |

###### 响应示例

```json
{
    "size": 20,
    "total": 98,
    "pages": 5,
    "list": [
        {
            "id": 174,
            "sysNo": "YT20170122102902",
            "goodsNo": "718000872251",
            "status": 0,
            "createdDate": 1485052172929,
            "goodsNum": 2,
            "companyName": "伊藤洋华堂（眉山店）",
            "queryStatus": 1
        }
    ],
    "page": 1
}
```

---
#### 3.2 个人订单详情

###### 接口地址

[http://app.qc-wbo.com/v1/waybills/self/{id}](http://app.qc-wbo.com/v1/waybills/self/{id})

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### URL参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |
| sysNo | String(100) | 系统运单号 | YT20161230120202 |
| goodsNo | String(100) | 货物运单号 | 718000872251 |
| distributionName | String(100) | 配送人员姓名 | 吴大 |
| distributionTel | String(100) | 配送人员联系电话 | 18224060100 |
| consigneeName | String(100) | 收货人姓名 | 吴勇 |
| consigneeTel | String(100) | 收货人电话 | 182****0100 |
| consigneeAddress | String(250) | 收货人的地址 | 眉山红豆园A区1栋4号 |
| status | Int | 状态（0：等待配送，1：开始配送，2：中转，3：签收，4：其他成功情况，5：拒收，6：其他失败情况，7：收到退货，8：滞留，9：自提，10：生成新运单，11：其他，12：完成） | 1 |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1482463020055 |
| goodses | Array | 货物 | [{"id":1,"categoryName":"食品饮料","goodsName":"休闲零食","goodsNum":1}] |
| id | Long | 主键ID | 1 |
| categoryName | String(100) | 分类名称 | 食品饮料 |
| goodsName | String(100) | 货物名称 | 休闲零食 |
| goodsNum | Int | 货物数量 | 1 |
| deliveryTimeDesc | String | 即日达时效 | 当日送达 |
| logisticsCompany | String | 物流公司 | 我的伊家 |
| queryStatus | Int | 显示状态：1：待配送，2：配送中，3：已完成，4：已退货 | 2 |
| deliveryTime | String | 配送时间 | 2016-12-24 10:17 ~ 22:00 |

###### 响应示例

```json
{
    "id": 1,
    "sysNo": "YT20161230120202",
    "goodsNo": "718000872251",
    "distributionName": "吴大",
    "distributionTel": "18224060100",
    "consigneeName": "吴勇",
    "consigneeTel": "182****0100",
    "consigneeAddress": "眉山红豆园A区1栋4号",
    "status": 1,
    "createdDate": 1482463020055,
    "goodses": [
        {
            "id": 1,
            "categoryName": "食品饮料",
            "goodsName": "休闲零食",
            "goodsNum": 1
        }
    ],
    "deliveryTimeDesc": "当日送达",
    "logisticsCompany": "我的伊家",
    "queryStatus": 2,
    "deliveryTime": "2016-12-24 10:17 ~ 22:00"
}
```

---
#### 3.3 物流状态

###### 接口地址

[http://app.qc-wbo.com/v1/waybills/self/{id}/detail](http://app.qc-wbo.com/v1/waybills/self/{id}/detail)

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### URL参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |
| distributionName | String(100) | 配送人员姓名 | 吴大 |
| distributionTel | String(100) | 配送人员联系电话 | 18224060100 |
| details | Array | 详情 | {"id":67,"createdDate":1482808721748,"status":8,"notes":[{"text":"1","createdDate":1482808721748,"sysUserJobNumber":"GL001","sysUserName":"张兵"}]} |
| id | Long | 主键ID | 67 |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1482808721748 |
| status | Int | 状态（0：等待配送，1：开始配送，2：中转，3：签收，4：其他成功情况，5：拒收，6：其他失败情况，7：收到退货，8：滞留，9：自提，10：生成新运单，11：其他，12：完成） | 8 |
| notes | Array | 备注 | [{"text":"1","createdDate":1482808721748,"sysUserJobNumber":"GL001","sysUserName":"张兵"}] |
| text | String | 说明 | 1 |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1482808721748 |
| sysUserJobNumber | String(200) | 工号 | GL001 |
| sysUserName | String(100) | 操作人员姓名 | 张兵 |
| deliveryTime | String | 配送时间 | 2016-12-24 10:17 ~ 22:00 |

###### 响应示例

```json
{
    "id": 1,
    "distributionName": "吴大",
    "distributionTel": "18224060100",
    "details": {
        "id": 67,
        "createdDate": 1482808721748,
        "status": 8,
        "notes": [
            {
                "text": "1",
                "createdDate": 1482808721748,
                "sysUserJobNumber": "GL001",
                "sysUserName": "张兵"
            }
        ]
    },
    "deliveryTime": "2016-12-24 10:17 ~ 22:00"
}
```

---
#### 3.4 订单轨迹

###### 接口地址

[http://app.qc-wbo.com/v1/waybills/self/{id}/route](http://app.qc-wbo.com/v1/waybills/self/{id}/route)

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### URL参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 108 |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| route | String | 轨迹 | {"lat":30.048832,"lng":103.839111} |
| lat | Double | 纬度 | 30.048832 |
| lng | Double | 经度 | 103.839111 |
| sysUserName | String(100) | 操作人员姓名 | 杨森 |
| sysUserTel | String(50) | 操作人员电话 | 18224060100 |
| id | Long | 所属运单ID | 108 |
| lat | Double | 目的地纬度 | 30.048646 |
| lng | Double | 目的地经度 | 103.839111 |
| deliveryTime | String | 配送时间 | 2017-01-01 16:36 ~ 22:00 |

###### 响应示例

```json
{
    "route": {
        "lat": 30.048832,
        "lng": 103.839111
    },
    "sysUserName": "杨森",
    "sysUserTel": "18224060100",
    "id": 108,
    "lat": 30.048646,
    "lng": 103.839111,
    "deliveryTime": "2017-01-01 16:36 ~ 22:00"
}
```

---
#### 3.5 删除订单

###### 接口地址

[http://app.qc-wbo.com/v1/waybills/self/{id}](http://app.qc-wbo.com/v1/waybills/self/{id})

###### 请求方法
DELETE


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### URL参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |

###### 响应参数

无

---
#### 3.6 我要投诉

###### 接口地址

[http://app.qc-wbo.com/v1/complaints](http://app.qc-wbo.com/v1/complaints)

###### 请求方法
POST


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| accessToken | String | 是 | 授权码 | \- | fecb84d4-eac7-4e75-b21f-f97a52e83339 |
| waybillId | Long | 是 | 所属运单ID | \- | 1 |
| text | String | 是 | 说明 | \- | 我要投诉 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1774 |
| waybillId | Long | 所属运单ID | 1 |
| waybillSysNo | String(100) | 运单单号 | YT20161230120202 |
| userId | Long | 系统用户ID | 3 |
| userName | String(50) | 用户姓名 | ddddd |
| userTel | String(20) | 用户电话 | 18224060100 |
| text | String | 说明 | 我要投诉 |
| resolved | Boolean | 是否处理 | false |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1487302834686 |

###### 响应示例

```json
{
    "id": 1774,
    "waybillId": 1,
    "waybillSysNo": "YT20161230120202",
    "userId": 3,
    "userName": "ddddd",
    "userTel": "18224060100",
    "text": "我要投诉",
    "resolved": false,
    "createdDate": 1487302834686
}
```

---
#### 3.7 我的投诉

###### 接口地址

[http://app.qc-wbo.com/v1/complaints](http://app.qc-wbo.com/v1/complaints)

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
| page | Int | 否 | 页码，从1开始，默认1 | 1 | 1 |
| size | Int | 否 | 每页最大数量，默认20 | 20 | 20 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| size | Int | 每页最大数量，默认20 | 7 |
| total | Long | 总记录数 | 7 |
| pages | Int | 总页数 | 1 |
| list | Array | 内容 | [{"id":1691,"waybillSysNo":"YT20170109170317","text":"东西坏的","note":[{"createdDate":1487746147569,"note":"给你退","sysUserId":1,"sysUserNo":"KF001"}],"resolved":true,"createdDate":1483953433584}] |
| id | Long | 主键ID | 1691 |
| waybillSysNo | String(100) | 运单单号 | YT20170109170317 |
| text | String | 说明 | 东西坏的 |
| note | Array | 备注（处理结果） | [{"createdDate":1487746147569,"note":"给你退","sysUserId":1,"sysUserNo":"KF001"}] |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1487746147569 |
| note | String | 备注（处理结果） | 给你退 |
| sysUserId | Long | 客服务人员（处理人员）ID | 1 |
| sysUserNo | String(100) | 客服务人员（处理人员）工号 | KF001 |
| resolved | Boolean | 是否处理 | true |
| createdDate | Long | 创建时间（从1970年1月1日（UTC/GMT的午夜）开始所经过的毫秒数） | 1483953433584 |
| page | Int | 页码，从1开始，默认1 | 1 |

###### 响应示例

```json
{
    "size": 7,
    "total": 7,
    "pages": 1,
    "list": [
        {
            "id": 1691,
            "waybillSysNo": "YT20170109170317",
            "text": "东西坏的",
            "note": [
                {
                    "createdDate": 1487746147569,
                    "note": "给你退",
                    "sysUserId": 1,
                    "sysUserNo": "KF001"
                }
            ],
            "resolved": true,
            "createdDate": 1483953433584
        }
    ],
    "page": 1
}
```

---
