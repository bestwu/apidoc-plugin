### 1 waybill ###

#### 1.1 测试 ####

###### 接口地址 ######

[http://127.0.0.1:8080/waybills/{path}](http://127.0.0.1:8080/waybills/{path})

###### 请求方法 ######
GET


###### 请求头参数 ######

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='html/签名算法.html' target='_blank'>签名算法</a> | \- |

###### URL参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| path | \- | \- | 1 |

###### 请求参数 ######

无

###### 响应参数 ######

|名称|类型|描述|示例值|
|---|---|---|---|
| size | Int | 每页最大数量，默认20 | 5 |
| total | Long | 总记录数 | 5 |
| pages | Int | 总页数 | 1 |
| list | \- | \- | \[{"id":72,"goodsNo":"557646","consigneeName":"赵国柱1","consigneeTel":"18819295194","consigneeAddress":"东坡区苏祠路13号逸静苑大门向南方向5米","status":1,"finished":false}] |
| id | Long | 主键ID | 72 |
| goodsNo | String(100) | 货物运单号 | 557646 |
| consigneeName | String(100) | 收货人姓名 | 赵国柱1 |
| consigneeTel | String(100) | 收货人电话 | 18819295194 |
| consigneeAddress | String(250) | 收货人的地址 | 东坡区苏祠路13号逸静苑大门向南方向5米 |
| status | Integer | 状态（0：等待配送，1：开始配送，2：中转，3：签收，4：其他成功情况，5：拒收，6：其他失败情况，7：收到退货，8：滞留，9：自提，10：生成新运单，11：其他，12：完成） | 1 |
| finished | Boolean | 是否完成运单 | false |
| page | Int | 页码，从1开始，默认1 | 1 |

###### 响应示例 ######

```json
{
  "size": 5,
  "total": 5,
  "pages": 1,
  "list": [{
    "id": 72,
    "goodsNo": "557646",
    "consigneeName": "赵国柱1",
    "consigneeTel": "18819295194",
    "consigneeAddress": "东坡区苏祠路13号逸静苑大门向南方向5米",
    "status": 1,
    "finished": false
  }, {
    "id": 12,
    "goodsNo": "718000872266",
    "consigneeName": "江涛",
    "consigneeTel": "13684030501",
    "consigneeAddress": "碧辉园",
    "status": 1,
    "finished": false
  }, {
    "id": 71,
    "goodsNo": "2222",
    "consigneeName": "赵国柱1",
    "consigneeTel": "18819295194",
    "consigneeAddress": "东坡区文安路东二段与永和街交叉口东50米",
    "status": 1,
    "finished": false
  }, {
    "id": 13,
    "goodsNo": "1234",
    "consigneeName": "江涛",
    "consigneeTel": "13684030501",
    "consigneeAddress": "眉山东站",
    "status": 1,
    "finished": true
  }, {
    "id": 161,
    "goodsNo": "718000872252",
    "consigneeName": "SDF",
    "consigneeTel": "18224060100",
    "consigneeAddress": "湿地",
    "status": 1,
    "finished": true
  }],
  "page": 1
}
```

---
