###PDA ：： 1.车牌管理模块




####1.1->获取PDA或者道闸的对应的车是否是逃逸车辆或者未交费车辆

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场ID | 否| 无 |长整型|
| car_code|车牌号| 否| 无 |字符串|
| area_code| 省市区区域代码 | 否| 无 |字符串|
| type|是检查 逃逸逃逸车辆 还是 未支付车辆   0：默认检查逃逸车辆  1：检查未支付车辆| 否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+area_code+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pda_check_escape_car.php](http://139.224.29.103/v1/pda_check_escape_car.php)

######返回结果 情况1
    {
        "data": "",
        "errorcode": "",
        "errormsg": "不是未交费车辆",
        "errorno": "0"
    }
######返回结果 情况2
    {
        "data": [{
            "address_name": "英郡1期",
            "allege_state": 0,
            "area_code": "510107",
            "arrive_time": 1483426880000,
            "cancel_state": 0,
            "car_code": "川EC0091",
            "charging": 1,
            "charging_time": 60,
            "ctime": 1483426880000,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "",
            "expect_money": 0,
            "expect_state": 0,
            "expect_time": 0,
            "final_time": 0,
            "free_minute": 0,
            "id": 1665,
            "is_cash": 0,
            "is_del": 0,
            "is_expect_deduct": 0,
            "is_expect_outtime": 0,
            "is_free_minute": 0,
            "is_open": 0,
            "
            ": 0,
            "lat": 30.544615,
            "leave_time": 1483426880000,
            "lng": 104.072689,
            "money": 0,
            "my_order": "2017010315013636",
            "note": "",
            "open_time": 1483426880000,
            "order_type": 0,
            "other_order": "",
            "park_type": 1,
            "pay_source": 0,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 2,
            "pi_name": "英俊一期",
            "pp_state": 0,
            "pp_versioncode": "",
            "pu_id": 1,
            "pu_nd": "20161227141900",
            "scan_time": 1483426880000,
            "start_price": 2,
            "start_time": 120,
            "ui_id": 62,
            "upc_id": 0,
            "utime": 1483426880000
        }],
        "errorcode": "",
        "errormsg": "是未交费车辆",
        "errorno": "0"
    }