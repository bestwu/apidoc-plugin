###道闸：： 1.租赁续租管理模块--APP
#####测试的时候前缀：http://139.224.29.103:8091


####1.1->用户根据车牌号查询租赁信息--(目前只处理租赁)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| car_code| 用户车牌号| 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

<font color=#0000ff size=6>注意事项</font>
####请求路径

[http://139.224.29.103/v1/getParkRentInfoByCarcode.php](http://139.224.29.103/v1/getParkRentInfoByCarcode.php)

######返回结果

    {
        "data": [
            {
                "area_code": "510107",
                "car_code": "川EU4535",
                "client_rule_id": "",
                "endtime": 1499915431000,
                "is_del": 0,
                "is_expire": 0,
                "note": "",
                "permit_time": "8：00-23：00",
                "pi_id": 1001,
                "pi_name": "洪洋农贸市场地下车库",
                "rd_id": 1,
                "rent_type": 0,
                "starttime": 1499915428000,
                "stime": 1499915433000,
                "ui_id": 40,
                "ui_nd": "2016121214247768",
                "unit_price": 1000,
                "utime": 1499915436000
            }
        ],
        "errorcode": "",
        "errormsg": "查询租赁信息成功",
        "errorno": "0"
    }

#########data 里面JSONarray 里面的单个JOSN对象返回字段说明
|名称|描述|类型|
|----|----|---|
|rd_id|主键ID|long|
|pi_id|停车场主键ID|long|
|area_code|停车场地址编码|String|
|pi_name|停车场名称|String|
|unit_price|租赁每个月单价（单位分）|int|
|starttime|开始时间|java.util.Date|
|endtime|到期时间|java.util.Date|
|stime|服务器端接收时间|java.util.Date|
|utime|更新时间|java.util.Date|
|ui_id|用户主键ID|long|
|ui_nd|用户ND|String|
|car_code|用户车牌号|String|
|permit_time|允许时间段（8：00-23：00）|String|
|rent_type|租赁类型（0：普通时间段1：早半天2：晚半天3：全天）|int|
|is_del|是否逻辑删除(0:正常1：删除)|int|
|is_expire|是否已经到期（0：未到期1：已经到期）|int|
|note|备注|String|
|client_rule_id|客户端的规则ID|String|





