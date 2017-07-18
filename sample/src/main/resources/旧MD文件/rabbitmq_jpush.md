###1.吾泊自己搭建的推送管理模块



####1.1->吾泊rabbitmq 道闸系统推送规则
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "预约推送",
        "title": "预约消息",
        "type": 1，
        messageJson："这里是JSON对象"
    }
|组成部分名称|数据类型|值描述|
|--------|--------|-----|
| message| 文字信息（备注广播的时候采用） |字符串|
| messageJson|自定义消息体 |JSON字符串|
| type|类型 0：系统消息  1：预约推送 2：租赁推送|整型|

######0：type=0 系统消息
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "有事情找郑虎",
        "title": "系统消息",
        "type": 0
    }
######1：type=1 预约推送通知
    {
        "message": "有预约订单来了，郑虎快处理",
        "date": 1481596076656,
        "imgurl": "",
        "title": "预约消息",
        "type": 1,
        "messageJson": {
            "pay_park":{
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
            },
            "type": 1,类型 1:预约  2：取消预约
        }
    }
#########返回字段pay_park 订单信息说明
|名称|描述|类型|
|----|----|---|
|id|主键ID|long|
|pi_id|支付停车场主键ID|long|
|ui_id|用户ID|long|
|car_code|用户支付车牌号|String|
|money|支付金额（单位分）|int|
|pp_state|支付状态0:未支付1：已经支付|int|
|ctime|下单时间|java.util.Date|
|utime|更新支付状态时间|java.util.Date|
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付|int|
|my_order|我们的订单号|String|
|other_order|第三方的支付单号|String|
|pay_type|支付类型0:手动输入密码支付1：快捷支付（服务器可以请求第三方直接扣款）|int|
|pp_versioncode|当前APPSDK版本号（内部升级版本代号）|String|
|phone_type|手机类型0:android1：IOS|int|
|order_type|下单类型0:普通下单1：预约下单2：租赁包月订单|int|
|allege_state|申述状态0:未申述1：申述中2：申述失败3：申述成功|int|
|expect_time|预约时长(单位分钟|int|
|arrive_time|到场时间|java.util.Date|
|leave_time|离场时间|java.util.Date|
|expect_money|预定价格|int|
|expect_info|预定提示信息|String|
|area_code|省市县编号|String|
|is_expect_outtime|是否预约已经超时0：未超时1：已经超时|int|
|is_expect_deduct|是否已经扣除预约超时钱0：已锁定扣款金额1：已经扣款成功2：已解绑锁定金额|int|
|start_price|起步价（RMB单位分）|int|
|start_time|起步时长(分钟)|int|
|charging|计费价(RMB单位分)每小时2元|int|
|charging_time|计费单位时长(分钟)例如：每小时2元那么就是1小时|int|
|is_del|删除状态0:正常1：假删除|int|
|upc_id|用户优惠券表主键ID|long|
|discount_money|抵扣优惠金额（单位分）|long|
|note|备注|String|
|discount_name|抵扣优惠券名称|String|
|discount_type|优惠券类型0:金额券1：折扣券|int|
|final_time|结算时计费时长（单位分钟）|int|
|address_name|停车场地点名称|String|
|cancel_state|订单关闭状态0:没有关闭1：已经关闭2：订单异常（停车场心跳时间段内断开或者道闸手动开闸）3：异步数据上传（网络异常）|int|
|is_open|是否开闸0:未开闸1：已开闸|int|
|open_time|开闸时间|java.util.Date|
|is_cash|是否现金支付0：在线支付1：现金支付2：免费支付3:免费车类型4：包月车类型5：租赁车类型|int|
|park_type|停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场|int|
|scan_time|是否可以停车缴费时间（摄像头是否扫描到了：仅限道闸停车使用）|java.util.Date|
|pi_name|停车场名称|String|
|is_over|订单是否完成或者逃逸(0:没有完成1：完成2：车辆逃逸3：未交费)|int|
|free_minute|多少分钟之内进出免费|int|
|is_free_minute|多少分钟之内进出免费是否开启0:不开启1：开启|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|expect_state|预约状态0:未预约1：预约中2：预约成功3：预约失败4：取消预约中5：取消预约成功6：取消预约失败|int|
|ui_nd|用户唯一标识uuid|String|
|ai_id|活动ID|long|
|ai_money|活动优惠金额（单位分）|int|
|ai_effect|活动优惠是否生效（0：没有1：生效）|int|
|ui_tel|用户电话号码|String|

######2：type=2 租赁推送通知
    {
        "message": "有租赁订单来了，郑虎快处理",
        "date": 1481596076656,
        "imgurl": "",
        "title": "租赁消息",
        "type": 2,
        "messageJson": {
            "pay_month_park":{
                "address_name": "成都市天华路88号",
                "allege_state": 0,
                "area_code": "510107",
                "arrive_time": 1483423410000,
                "base_rate": "",
                "cancel_state": 0,
                "car_code": "川A42575",
                "ctime": 1483423410000,
                "discount_money": 0,
                "discount_name": "",
                "discount_type": 0,
                "end_time": 1486101810000,
                "final_time": 0,
                "id": 6,
                "is_24hours": 0,
                "is_cash": 0,
                "is_del": 0,
                "is_expire": 0,
                "is_open": 0,
                "is_over": 0,
                "lat": 30.547829,
                "lng": 104.072388,
                "money": 3,
                "month_info": "准入时段 14:17-22:12，0.03元/月",
                "month_num": 1,
                "my_order": "2017010314036620",
                "note": "用户租赁下单",
                "open_time": 1483423410000,
                "order_type": 2,
                "other_order": "",
                "outtime_charge_minute": 0,
                "outtime_charge_money": 0,
                "outtime_minute": 0,
                "outtime_money": 0,
                "outtime_other_order": "",
                "outtime_paystate": 0,
                "outtime_paytime": 1483423410000,
                "outtime_rate": "",
                "outtime_start_minute": 0,
                "outtime_start_price": 0,
                "outtime_time": 1483423410000,
                "park_type": 0,
                "pay_source": 4,
                "pay_type": 0,
                "permit_time": "14:17-22:12",
                "phone_type": 0,
                "pi_id": 1,
                "pi_name": "英郡二期",
                "pp_state": 1,
                "pp_versioncode": "1",
                "pu_id": 1,
                "pu_nd": "20161227141900",
                "rent_state": 0,
                "scan_time": 1483423410000,
                "start_time": 1483423410000,
                "temp_money": 0,
                "ui_id": 51,
                "upc_id": 0,
                "utime": 1483423410000
            },
            "type": 1,类型 1:租赁  2：取消租赁
        }
    }
#########返回字段pay_month_park 租赁订单信息说明
|名称|描述|类型|
|----|----|---|
|id|主键ID|long|
|pi_id|支付停车场主键ID|long|
|ui_id|用户ID|long|
|car_code|用户支付车牌号|String|
|money|支付金额（单位分）|int|
|pp_state|支付状态0:未支付1：已经支付|int|
|ctime|下单时间|java.util.Date|
|utime|更新支付状态时间|java.util.Date|
|month_num|包月租凭月数|int|
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付6:ETC快捷支付|int|
|my_order|我们的订单号|String|
|other_order|第三方的支付单号|String|
|pay_type|支付类型0:手动输入密码支付1：快捷支付（服务器可以请求第三方直接扣款）|int|
|pp_versioncode|当前APPSDK版本号（内部升级版本代号）|String|
|phone_type|手机类型0:android1：IOS|int|
|order_type|下单类型0:普通下单1：预约下单2：租赁包月订单|int|
|start_time|启始时间|java.util.Date|
|end_time|到期时间|java.util.Date|
|month_info|包月提示信息|String|
|allege_state|申述状态0:未申述1：申述中2：申述失败3：申述成功|int|
|area_code|省市县编号|String|
|is_del|删除状态0:正常1：假删除|int|
|upc_id|用户优惠券表主键ID|long|
|discount_money|抵扣优惠金额（单位分）|long|
|note|备注|String|
|discount_name|抵扣优惠券名称|String|
|discount_type|优惠券类型0:金额券1：折扣券|int|
|final_time|结算时计费时长（单位分钟）|int|
|address_name|停车场地点名称|String|
|base_rate|基础费率（300元/月）|String|
|outtime_rate|超时费率(首停2小时3元，之后1元/小时)|String|
|outtime_money|超时金额|int|
|outtime_time|超时结算时间（2016-08-1012：00：00）|java.util.Date|
|outtime_minute|超时时长（单位分钟）|int|
|outtime_start_price|超时起步价|int|
|outtime_start_minute|超时起步量纲时长（单位分钟）|int|
|outtime_charge_money|超时计费价格（单位分）|int|
|outtime_charge_minute|超时计费量纲时长（单位分钟）|int|
|outtime_other_order|超时第三方支付订单号|String|
|outtime_paytime|超时缴费时间|java.util.Date|
|outtime_paystate|超时缴费状态0:未缴费1：已经缴费|int|
|permit_time|准入时间段（17:00-08:30）|String|
|is_24hours|是否是24小时包月0:不是24小时包月1：是24小时包月|int|
|is_open|是否开闸0:未开闸1：已开闸|int|
|open_time|开闸时间|java.util.Date|
|is_cash|是否现金支付0：在线支付1：现金支付|int|
|park_type|停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场|int|
|scan_time|是否可以停车缴费时间（摄像头是否扫描到了：仅限道闸停车使用）|java.util.Date|
|arrive_time|该次入库的到达时间|java.util.Date|
|temp_money|临停费用累计|long|
|pi_name|停车场名称|String|
|is_over|订单是否完成或者逃逸(0:没有完成1：完成2：车辆逃逸3：未交费)|int|
|cancel_state|订单关闭状态0:没有关闭1：已经关闭2：订单异常|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|is_expire|是否已到期（0：没有到期1：已经到期）|int|
|rent_state|租赁状态0:待支付1：租赁中2：租赁成功3：租赁失败--解绑租赁金额|int|
|ui_nd|用户唯一标识uuid|String|
|ai_id|活动ID|long|
|ai_money|活动优惠金额（单位分）|int|
|ai_effect|活动优惠是否生效（0：没有1：生效）|int|
|ui_tel|用户电话号码|String|
|magnetic_state|智能磁场入库出库状态（1：已入库2：已出库3：车辆逃逸4：其它故障）|int|
|gov_num|智能磁场车位编号（政府部门统一分配）|String|

