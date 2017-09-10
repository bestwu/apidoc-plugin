###1.车牌管理模块



####1.1->用户添加或者删除绑定车牌号

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| act| 1:添加车牌 2：删除车牌 | 否| 无 |整型|
| car_code|车牌号| 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+car_code+act)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/bindcar.php](http://139.224.29.103/v1/bindcar.php)

######返回结果

    {
        "data": "",
        "errormsg": "绑定成功",
        "errorno": "0"
    }
####1.1.2->用户更新车辆信息

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| uc_id| 表主键ID| 否| 无 |长整型|
| car_code|车牌号| 是| 无 |字符串|
| lience| 行驶证照片|是| 无 |文件|
| run_code|行驶证号码| 是| 无 |字符串|
| car_brand|车辆品牌| 是| 无 |字符串|
| uc_color|车辆颜色:0 未定  1：黑色 2：白色 3：银色 4：金色 5：红色 6 ：黄色 7：绿色 8：蓝色 9：橙色 10：灰色| 否| 无 |整型|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/update_car.php](http://139.224.29.103/v1/update_car.php)

######返回结果

    {
        "data": {
            "car_brand": "东风",
            "car_code": "川A4M99B",
            "ctime": 1470710253000,
            "is_default": 0,
            "note": "",
            "run_url": "http://139.224.29.103/file/img/lience/2016/0fbd30b39ae04e029c3b3a14f0d4b4f0.jpg",
            "uc_color": 8,
            "uc_id": 1,
            "ui_id": 1,
            "utime": 1470710253000
        },
        "errormsg": "更新用户车辆信息成功",
        "errorno": "0"
    }
####1.2->读取用户绑定的车牌号

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_bindcar.php](http://139.224.29.103/v1/read_bindcar.php)

######返回结果

    {
        "data": [
            {
                "car_brand": "",
                "car_code": "川A4M99B",
                "ctime": 1470710253000,
                "is_default": 0,
                "note": "",
                "run_url": "",
                "uc_color": 0,
                "uc_id": 1,
                "ui_id": 1,
                "utime": 1470710253000
            },
            {
                "car_brand": "",
                "car_code": "辽JQQ360",
                "ctime": 1470902325000,
                "is_default": 0,
                "note": "",
                "run_url": "",
                "uc_color": 0,
                "uc_id": 2,
                "ui_id": 1,
                "utime": 1470902325000
            }
        ],
        "errormsg": "读取用户绑定的车牌号成功",
        "errorno": "0"
    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| is_default| 是否是默认车牌号选定 : 0 ：不是 1：是默认车牌| 无 |整型|
| run_url| 行驶证照片| 无 |字符串|
| uc_color| 车辆颜色:0 未定  1：黑色 2：白色 3：银色 4：金色 5：红色 6 ：黄色 7：绿色 8：蓝色 9：橙色 10：灰色| 无 |整型|
| car_brand| 车辆品牌| 无 |字符串|
| uc_id| 表主键ID| 无 |长整型|


####1.3->获取用户优惠券列表

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_mycoupon.php](http://139.224.29.103/v1/read_mycoupon.php)

######返回结果

    {
        "data": [
            {
                "upc_id": 1,
                "ui_id": 1,
                "pc_id": 1,
                "money": 2,
                "discount": 0,
                "high_money": 5,
                "upc_type": 0,
                "end_time": 1470719517000,
                "upc_state": 0,
                "ctime": 1470805921000,
                "utime": 1470805924000,
                "is_effect": 0
            }
        ],
        "errormsg": "获取成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|upc_id|主键ID|long|
|ui_id|主键ID|long|
|pc_id|停车优惠券表主键ID|long|
|money|优惠券金额|int|
|discount|折扣券折数|double|
|high_money|最高抵扣金额|int|
|upc_type|优惠券类型0:金额券1：折扣券|int|
|end_time|有效期|java.util.Date|
|upc_state|使用状态0：未使用1：已使用|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|send_unit|赠送单位(0:吾泊平台1：龙支付)|int|
|ai_id|活动ID（活动表主键ID）|long|








####1.4->读取用户预约下单普通车位,需要的订单准备数据

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID | 否| 无 |长整型|
| car_code| 辽JQQ360 车牌号| 否| 无 |字符串|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区  510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_expect_order.php](http://139.224.29.103/v1/read_expect_order.php)

######返回结果

    {
        "data": {
            "car_code_color": 0,
            "car_displacement": "1.6T",
            "car_type": 1,
            "charging": 120,
            "charging_time": 60,
            "ctime": 1470710308000,
            "is_default": 0,
            "is_time_bucket": 0,
            "month_price": 15000,
            "month_time": 30,
            "note": "",
            "permit_time": "17:00-08:30",
            "pi_id": 1,
            "rcr_discount": 0,
            "rcr_id": 1,
            "rcr_md5": "",
            "rcr_state": 0,
            "rcr_type": 0,
            "start_price": 500,
            "start_time": 180,
            "time_bucket": "白天 9：00-12：00 每小时2元",
            "timeout_info": "首停2小时3元，之后1元/小时",
            "utime": 1470710308000
        },
        "errormsg": "停车场收费规则信息成功",
        "errorno": "0"
    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| pi_id| 停车场主键ID| 无 |长整型|
| start_price| 起步价（RMB 单位 分）| 无 |整型|
| charging| 计费价(RMB  单位分)| 无 |整型|
| charging_time| 计费量纲时长（单位 分钟）| 无 |整型|
| month_price| 包月价格(单位分)| 无 |整型|
| month_time| 包月时长(天)| 无 |整型|
| permit_time| 准入时间段17:00-08:30| 无 |字符串|
| timeout_info| 超时费率(首停2小时3元，之后1元/小时) | 无 |字符串|
| rcr_type| 停车类型 0：普通车位停车 1：时间段包月停车 | 无 |整型|
| rcr_state| 是否有效  0：有效 1：无效 | 无 |整型|
| rcr_discount| 是否可以使用优费券 : 0： 可以使用 1：无法使用| 无 |整型|
| car_displacement| 车辆排量| 无 |字符串|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 无 |整型|
| is_time_bucket| 是否按时间段收费 0:不按时间段收费 1：按时间段收费| 无 |整型|
| time_bucket| 时间段收费  例如：白天 9：00-12：00 每小时2元| 无 |字符串|

####1.5->扫码赠送优惠券--用户使用吾泊APP扫码功能，扫描朋友的代金卷二维码
#<font color="red" size = "6px">注意事项：</font>
<font color="#4590a3" size = "6px">
二维码规则：Rcode@ui_id=1&upc_id=1000
Rcode:表示事件名称
@：表示分隔符
ui_id=1&upc_id=1000：表示内容
</font>

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| from_ui_id| 优惠券原属用户ID| 无 |长整型|
| upc_id| 用户优惠券主键ID| 无 |长整型|
| sign| MD5数字签名(dtype+ui_id+from_ui_id+upc_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/give_coupon.php](http://139.224.29.103/v1/give_coupon.php)

######返回结果

    {
        "data":"",
        "errorcode": "",
        "errormsg": "赠送成功",
        "errorno": "0"
    }
####1.6->获取PDA或者道闸的对应的车是否是逃逸车辆或者未交费车辆

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