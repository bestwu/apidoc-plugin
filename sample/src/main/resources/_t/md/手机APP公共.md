<div mdin style="float: left;width:25%;background-color: #f7f5fa;">

- [文档首页](index.md)

	- [系统概述](index.md#系统概述)
	- [客户端请求说明](index.md#客户端请求说明)
	- [接口授权说明](接口授权说明.md)
	- [签名算法](签名算法.md)

---

- [1 手机APP公共](手机APP公共.md)

	- [1.1 省市区数据](手机APP公共.md#1.1省市区数据)

---

</div>
<div mdin style="float: left;width:74%;margin-left: 1%;">

### 1 手机APP公共

#### <a href='#1.1省市区数据' name='1.1省市区数据'>1.1 省市区数据</a>

###### 接口地址

[http://127.0.0.1/place.json](http://127.0.0.1/place.json)

###### 请求方法
GET

###### 请求参数

无
###### 响应参数

|名称|类型|最大长度|描述|示例值|
|---|---|---|---|---|
| list | array | \- | 内容 | [id:110000, name:北京, children:[id:110101, name:东城区, children:[:]]] |
| id | long | \- | 主键ID | 110101 |
| name | string | 100 | 名称 | 东城区 |
| children | array | \- | 子对象 |  |
| id | long | \- | 主键ID | 110101 |
| name | string | 100 | 名称 | 东城区 |
| children | array | \- | 子对象 |  |

---

</div>
<div style="display:block;position:fixed;z-index:1001;bottom:10px;right:0;margin:0;padding:0;background-color:#c9c9c9">
  <a style="display:block;padding:12px;background:rgba(255,255,255,.5);" href="#">
    <span style="display:block;width:33px;height:24px;">TOP</span>
  </a>
</div>
