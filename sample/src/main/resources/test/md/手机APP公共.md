### 2 手机APP公共

#### 2.1 省市区数据

###### 接口地址

[http://app.qc-wbo.com/v1/place.json](http://app.qc-wbo.com/v1/place.json)

###### 请求方法
GET


###### 请求参数

无

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| list | Array | 内容 | [{"id":110000,"name":"北京","children":[{"id":110101,"name":"东城区","children":[]}]}] |
| id | Long | 主键ID | 110000 |
| name | String(100) | 名称 | 北京 |
| children | Array | 子对象 | [{"id":110101,"name":"东城区","children":[]}] |
| id | Long | 主键ID | 110101 |
| name | String(100) | 名称 | 东城区 |
| children | Array | 子对象 | \- |

###### 响应示例

```json
{
    "list": [
        {
            "id": 110000,
            "name": "北京",
            "children": [
                {
                    "id": 110101,
                    "name": "东城区",
                    "children": [
                        
                    ]
                }
            ]
        }
    ]
}
```

---
#### 2.2 配送范围

###### 接口地址

[http://app.qc-wbo.com/v1/mapAreas](http://app.qc-wbo.com/v1/mapAreas)

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| lat | Double | 否 | 纬度 | \- | 30.04728 |
| lng | Double | 否 | 经度 | \- | 103.83516 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |
| name | String(100) | 名称 | 伊藤洋华堂（眉山店） |
| address | String(200) | 地址 | 眉山市东坡区环湖中路雕像国际广场 伊藤洋华堂 |
| lng | Double | 公司所在经度 | 103.835434 |
| lat | Double | 公司所在纬度 | 30.047301 |
| mapZoom | String(20) | 地图缩放级别 | 13 |
| mapAreas | Array | 地图范围 | {"id":8,"color":"#9a9a9a","path":{"lat":30.02651,"lng":103.867385},"name":"灰"} |
| id | Long | 主键ID | 8 |
| color | String(20) | 颜色 | #9a9a9a |
| path | String | 路径 | {"lat":30.02651,"lng":103.867385} |
| lat | Double | 纬度 | 30.02651 |
| lng | Double | 经度 | 103.867385 |
| name | String(100) | 名称 | 灰 |

###### 响应示例

```json
{
    "id": 1,
    "name": "伊藤洋华堂（眉山店）",
    "address": "眉山市东坡区环湖中路雕像国际广场 伊藤洋华堂",
    "lng": 103.835434,
    "lat": 30.047301,
    "mapZoom": "13",
    "mapAreas": {
        "id": 8,
        "color": "#9a9a9a",
        "path": {
            "lat": 30.02651,
            "lng": 103.867385
        },
        "name": "灰"
    }
}
```

---
#### 2.3 收货点

###### 接口地址

[http://app.qc-wbo.com/v1/receivingSpaces](http://app.qc-wbo.com/v1/receivingSpaces)

###### 请求方法
GET


###### 请求头参数

|名称|类型|是否必填|描述|示例值|
|---|---|---|---|---|
| sign | String | 是 | 接口签名 <a href='签名算法.md' target='_blank'>签名算法</a> | \- |

###### 请求参数

|名称|类型|是否必填|描述|默认值|示例值|
|---|---|---|---|---|---|
| lat | Double | 否 | 纬度 | \- | 30.04728 |
| lng | Double | 否 | 经度 | \- | 103.83516 |

###### 响应参数

|名称|类型|描述|示例值|
|---|---|---|---|
| id | Long | 主键ID | 1 |
| name | String(100) | 名称 | 伊藤洋华堂（眉山店） |
| receivingSpaces | Array | 送货点 | {"id":1,"floor":5,"address":"服务台旁","lat":30.047301,"lng":103.835434} |
| id | Long | 主键ID | 1 |
| floor | Int | 楼层 | 5 |
| address | String(200) | 地址 | 服务台旁 |
| lat | Double | 纬度 | 30.047301 |
| lng | Double | 经度 | 103.835434 |

###### 响应示例

```json
{
    "id": 1,
    "name": "伊藤洋华堂（眉山店）",
    "receivingSpaces": {
        "id": 1,
        "floor": 5,
        "address": "服务台旁",
        "lat": 30.047301,
        "lng": 103.835434
    }
}
```

---
