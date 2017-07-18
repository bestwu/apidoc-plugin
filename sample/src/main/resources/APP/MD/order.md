###APP :: 1.订单管理模块



####1.1->普通车位-用户预约下单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| pay_type| 支付类型 0:手动输入密码支付1：快捷支付（服务器可以请求第三方直接扣款）| 否| 无 |整型|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| pp_versioncode| 当前APPSDK版本号 （内部升级版本代号） | 否| 无 |字符串|
| expect_info| 预约提示信息 | 否| 无 |字符串|
| expect_money| 预约价格（ 单位分） | 否| 无 |整型|
| expect_time| 预约时间 单位分钟 | 否| 无 |整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+car_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/expect_order.php](http://139.224.29.103/v1/expect_order.php)

######返回结果

    {
        "data": {
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
        },
         "errormsg": "查询附近的停车场信息成功",
        "errorno": "0"
    }
########返回结果的错误信息情况：
|参数|错误代码|类型|错误描述|
|----|----|---|---|
|errorcode|1|字符串|用户钱包余额不足|


#########返回字段说明
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






####1.2->下单租赁包月车位

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| pay_type| 支付类型 0:手动输入密码支付1：快捷支付（服务器可以请求第三方直接扣款）| 否| 无 |整型|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| pp_versioncode| 当前APPSDK版本号 （内部升级版本代号） | 否| 无 |字符串|
| month_num| 包月租凭月数 | 否| 无 |整型|
| month_info| 包月提示信息(准入时段 18:00-08:00，300元/月)| 否| 无 |字符串|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| permit_time| 准入时间段（17:00-08:30） | 否| 无 |字符串|
| is_24hours| 是否是24小时包月  0:不是24小时包月  1：是24小时包月 | 是| 无 |整型|
| upc_id| 用户优惠券表主键ID|否| 无 |长整型|
| pay_source| 支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付|否| 无 |整型|
| orderid| 普通停车订单ID|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+car_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pay_rent_order.php](http://139.224.29.103/v1/pay_rent_order.php)

######返回结果

    {
        "data":       {
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
         "errormsg": "查询附近的停车场信息成功",
        "errorno": "0"
    }

#########返回字段说明
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
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付|int|
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
|cancel_state|订单关闭状态 0:没有关闭 1：已经关闭  2：订单异常|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|is_expire|是否已到期（0：没有到期1：已经到期）|int|
|rent_state|租赁状态0:待支付 1：租赁中2：租赁成功3：租赁失败--解绑租赁金额|int|
|ui_nd|用户唯一标识uuid|String|
|ai_id|活动ID|long|
|ai_money|活动优惠金额（单位分）|int|
|ai_effect|活动优惠是否生效（0：没有1：生效）|int|



####1.3->用户停车缴费读取订单---缴费出库

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| orderid| 订单号|否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+orderid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_pay_order.php](http://139.224.29.103/v1/read_pay_order.php)

######返回结果

    {
    "data": {
    	"discount_money":100 表示 有随机立免金额--优惠金额 单位分
        "is_show": 0,
        "coupon": "",
        "pay_park": {
            "address_name": "泸州市江阳区慈善路139号",
            "allege_state": 0,
            "area_code": "510502",
            "arrive_time": 1486448943000,
            "cancel_state": 2,
            "car_code": "川EX6G33",
            "charging": 100,
            "charging_time": 60,
            "ctime": 1486448943000,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "",
            "expect_money": 0,
            "expect_state": 0,
            "expect_time": 0,
            "final_time": 154,
            "free_minute": 0,
            "id": 7533,
            "is_cash": 1,
            "is_del": 0,
            "is_expect_deduct": 0,
            "is_expect_outtime": 0,
            "is_free_minute": 0,
            "is_open": 0,
            "is_over": 0,
            "lat": 28.89002,
            "leave_time": 1486448943000,
            "lng": 105.453094,
            "money": 800,
            "my_order": "2017020714290427",
            "note": "",
            "open_time": 1486448943000,
            "order_type": 0,
            "other_order": "",
            "park_type": 0,
            "pay_source": 0,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 161,
            "pi_name": "泸州重百地下停车场",
            "pp_state": 1,
            "pp_versioncode": "",
            "pu_id": 3,
            "pu_nd": "20170117150118",
            "scan_time": 1486448943000,
            "start_price": 600,
            "start_time": 60,
            "ui_id": 0,
            "ui_nd": "",
            "upc_id": 0,
            "utime": 1486457652000
        }
    },
    "errorcode": "",
    "errormsg": "用户停车缴费读取订单成功",
    "errorno": "0"
}

#########返回字段说明
####coupon:
|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| upc_state| 使用状态 0：未使用 1：已使用| 无 |整型|
| discount| 折扣券折数| 无 |浮点数|
| high_money| 最高抵扣金额| 无 |整型|
| upc_type| 优惠券类型 0:金额券 1：折扣券| 无 |整型|
| pc_id| 停车优惠券类型表主键ID| 无 |长整型|
| upc_id| 用户优惠券表主键ID| 无 |长整型|


####pay_park:
#########返回字段说明
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








####1.4->用户普通停车位直接正式付款下单(对应E泊 停车缴费)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| orderid| 普通停车订单ID|否| 无 |字符串|
| upc_id| 用户优惠券表主键ID|否| 无 |长整型|
| pay_source| 支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付|否| 无 |整型|
| sign| MD5数字签名(dtype+ui_id+orderid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pay_order.php](http://139.224.29.103/v1/pay_order.php)

######返回结果
    {
               "data":  {
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
            "is_over": 0,
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
        "errormsg": "用户停车缴费下单信息更新成功",
        "errorno": "0"
    }
#########返回字段说明
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






####1.5->读取用户预约下单普通车位 需要的订单准备数据

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_expect_order.php](http://139.224.29.103/v1/read_expect_order.php)

######返回结果

    {
        "data":  {
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
            "is_over": 0,
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
        "errormsg": "停车场收费规则信息成功",
        "errorno": "0"
    }
#########返回字段说明
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






####1.6->读取停车场租赁详情

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_parkrent_info.php](http://139.224.29.103/v1/read_parkrent_info.php)

######返回结果
    {
        "data": {
            "rule": {
                "area_code": "510122",
                "car_code_color": 1,
                "car_displacement": "1.6T",
                "car_type": 1,
                "charging": 120,
                "charging_time": 60,
                "ctime": 1470971498000,
                "is_default": 0,
                "is_time_bucket": 0,
                "month_price": 15000,
                "month_time": 30,
                "note": "",
                "permit_time": "17:00-08:30",
                "pi_id": 1,
                "rcr_discount": 0,
                "rcr_id": 2,
                "rcr_md5": "",
                "rcr_state": 0,
                "rcr_type": 1,
                "start_price": 500,
                "start_time": 180,
                "time_bucket": "白天 9：00-12：00 每小时2元",
                "timeout_info": "首停2小时3元，之后1元/小时",
                "utime": 1470971498000
            },
            "park_info": {
                "address_name": "天府三街地铁A出口",
                "allow_expect_time": 0,
                "allow_revoke_time": 0,
                "area_code": "0",
                "camera_info": "罗技Pro C920",
                "carport_space": 93,
                "carport_total": 100,
                "carport_yet": 7,
                "copy_linkman_name": "张小强",
                "copy_linkman_tel": "15882345447",
                "ctime": 1470296969000,
                "department": "四川乐库斯",
                "enter_camera_num": 1,
                "enter_num": 1,
                "exit_camera_num": 1,
                "exit_num": 1,
                "expect_money": 0,
                "hlc_enter_num": 1,
                "hlc_exit_num": 1,
                "lat": 30.547776,
                "linkman_name": "敬小虎",
                "linkman_tel": "15882345446",
                "lng": 104.067138,
                "moth_car_num": 0,
                "note": "",
                "park_type": 0,
                "pi_id": 1,
                "pi_name": "四川乐库斯",
                "pi_phone": "028-85960236",
                "rent_info": "准入时段 17:00-08:30，150元/月",
                "time_car_num": 0,
                "timeout_info": "首停3小时5元，之后每小时1元",
                "utime": 1470296969000
            },
            "coupon": [
                {
                    "upc_id": 1,
                    "ui_id": 1,
                    "pc_id": 1,
                    "money": 2,
                    "discount": 0,
                    "high_money": 5,
                    "upc_type": 0,
                    "end_time": 1472188317000,
                    "upc_state": 0,
                    "ctime": 1470805921000,
                    "utime": 1470805924000
                }
            ]
        },
        "errormsg": "读取停车场租赁详情成功",
        "errorno": "0"
    }

####1.7->获取我的订单 （1：临时停车订单  2： 租赁订单）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| type| 获取订单类型  0:普通停车订单  1：租赁停车订单|否| 无 |整型|
| car_code| 车牌号 | 否| 无 |字符串|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| page| 页数|否| 无 |整型|
| size| 每页条数|否| 无 |整型|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/my_order.php](http://139.224.29.103/v1/my_order.php)

######返回结果
    {
        "data": [
             {
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
            "is_over": 0,
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
        }
        ],
        "errorcode": "",
        "errormsg": "普通停车订单",
        "errorno": "0"
    }

    {
        "data": [
            {
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
        }
        ],
        "errorcode": "",
        "errormsg": "租赁停车订单",
        "errorno": "0"
    }
#########返回字段说明----普通订单
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




#########返回字段说明----租赁订单
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
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付|int|
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
|cancel_state|订单关闭状态 0:没有关闭 1：已经关闭  2：订单异常|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|is_expire|是否已到期（0：没有到期1：已经到期）|int|
|rent_state|租赁状态0：待支付 1：租赁中2：租赁成功3：租赁失败--解绑租赁金额|int|
|ui_nd|用户唯一标识uuid|String|
|ai_id|活动ID|long|
|ai_money|活动优惠金额（单位分）|int|
|ai_effect|活动优惠是否生效（0：没有1：生效）|int|

####1.7.1->获取我的某条订单 （1：临时停车订单  2： 租赁订单）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| type| 获取订单类型  0:普通停车订单  1：租赁停车订单|否| 无 |整型|
| orderid| 订单号 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+type+orderid)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/my_one_order.php](http://139.224.29.103/v1/my_one_order.php)

######返回结果
    {
        "data":
             {
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
            "is_over": 0,
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
        }
        ,
        "errorcode": "",
        "errormsg": "普通停车订单",
        "errorno": "0"
    }

    {
        "data":
            {
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
        "errorcode": "",
        "errormsg": "租赁停车订单",
        "errorno": "0"
    }
#########返回字段说明----普通订单
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





#########返回字段说明----租赁订单
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
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付|int|
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
|cancel_state|订单关闭状态 0:没有关闭 1：已经关闭  2：订单异常|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|is_expire|是否已到期（0：没有到期1：已经到期）|int|
|rent_state|租赁状态0：待支付 1：租赁中2：租赁成功3：租赁失败--解绑租赁金额|int|
|ui_nd|用户唯一标识uuid|String|
|ai_id|活动ID|long|
|ai_money|活动优惠金额（单位分）|int|
|ai_effect|活动优惠是否生效（0：没有1：生效）|int|


####1.8->用户取消预约订单-或-关闭租赁订单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| type| 0：普通车位  1：租赁车位|否| 无 |整型|
| orderid| 我们的订单号 | 否| 无 |字符串|
| pi_id| 停车场主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+orderid+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/cancel_order.php](http://139.224.29.103/v1/cancel_order.php)

######返回结果---预约订单取消
    {
        "data": {
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
            "is_over": 0,
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
        "errormsg": "取消预约订单成功",
        "errorno": "0"
    }
######返回结果---租赁订单关闭
    {
        "data":"",
        "errormsg": "关闭订单成功",
        "errorno": "0"
    }

####1.9->用户删除订单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| type| 0：普通车位  1：租赁车位|否| 无 |整型|
| orderid| 我们的订单号 | 否| 无 |字符串|
| pi_id| 停车场主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+orderid+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/delete_order.php](http://139.224.29.103/v1/delete_order.php)

######返回结果
    {
        "data": "",
        "errormsg": "删除订单成功",
        "errorno": "0"
    }


####2.0->获取我的账户出入记录

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| type| 获取虚拟币行为类型  0:消耗和充值  1：消耗  2：充值|否| 无 |整型|
| page| 页数|否| 无 |整型|
| size| 每页条数|否| 无 |整型|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/vc_record.php](http://139.224.29.103/v1/vc_record.php)

######返回结果
    {
        "data": [
            {
                "act_type": 0,
                "ctime": 1473302542000,
                "id": 1,
                "is_add": 0,
                "money": 30000,
                "note": "",
                "order_id": "f52a2b9448744c324df1473302542135",
                "order_type": 1,下单类型 0: 普通下单  1：预约下单 2：租赁包月订单
                "state": 1,
                "ui_id": 1，
                "act_name":"钱包支付"
            }
        ],
        "errorcode": "",
        "errormsg": "全部的出入记录",
        "errorno": "0"
    }

#########返回字段说明
|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| id| 主键ID| 无 |长整型|
| order_id| 订单ID| 无 |字符串|
| ui_id| 用户ID| 无 |长整型|
| order_type| 下单类型 0: 普通下单  1：预约下单 2：租赁包月订单| 无 |整型|
| money| 交易金额（单位 分）| 无 |整型|
| state| 处理状态 0：未处理 1：已处理| 无 |整型|
| ctime| 下单时间| 无 |datetime|
| is_add| 增加还是减少  0：减少  1：增加| 无 |整型|
|act_name|事件名称|String|


####2.1->用户申诉退费

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID|否| 无 |字符串|
| um_money| 退款金额(单位 分)|否| 无 |整型|
| order_id| 订单ID| 无 |字符串|
| car_code| 车牌号 (第一期：车牌号---对应一个人)|否| 无 |字符串|
| is_rent| 是否是租赁订单 0：临停订单  1：预约临停订单  2：租赁包月订单   3:租赁续租|否| 无 |整型|
| area_code| 省市县编号|否| 无 |字符串|
| type| 申诉类型  0：物管收费和APP显示不符 1：物管记时和APP记时不符 2：车辆未入库却显示已入库 3：车辆入驻的停车场名称和APP显示名称不符 4：车辆已出库显示未出库 5：物管收取预约费 6: 物管未提供预约车位 7:其他|否| 无 |整型|
| content| 申诉原因|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+car_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/usermoneyback.php](http://139.224.29.103/v1/usermoneyback.php)

######返回结果
    {
        "data": "",
        "errorcode": "",
        "errormsg": "用户申述成功",
        "errorno": "0"
    }

####2.1.2->获取订单审核状态信息

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| order_id| 订单ID| 无 |字符串|
| is_rent| 是否是租赁订单 0：临停订单  1：预约临停订单  2：租赁包月订单|否| 无 |整型|
| sign| MD5数字签名(dtype+ui_id+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_usermoneyback.php](http://139.224.29.103/v1/read_usermoneyback.php)

######返回结果
    {
        "data": {
            "admin_userid": 0,
            "area_code": "510101",
            "car_code": "川AQQ123",
            "check_content": "",
            "check_state": 0,
            "content": "",
            "ctime": 1479368332000,
            "is_rent": 1,
            "note": "",
            "order_id": "2016111709558435",
            "pi_id": 17,
            "run_url": "",
            "type": 2,
            "ui_id": 4,
            "um_id": 28,
            "um_money": 400,
            "um_state": 0,
            "utime": 1479368332000
        },
        "errorcode": "",
        "errormsg": "获取成功",
        "errorno": "0"
    }
#####返回结果情况
|字段|描述|
|--------|------|
|um_id|主键ID|
|ui_id|用户ID|
|order_id|停车下订单ID|
|pi_id|场地表主键ID
|ctime|创建时间|
|utime|更新时间|
|um_money|退款金额(单位分)|
|car_code|退款车牌号|
|run_url|用户行驶证图片|
|um_state|退款状态0：未退款1：已退款|
|check_state|审核状态0：未审核1：审核未通过2:审核通过|
|admin_userid|审核人后台管理表主键ID|   
|area_code|区域地址编码|
|type|申诉类型0：临停扣款问题1：预约超时扣费问题2：其它|
|content|申诉原因|
|is_rent|是否是租赁订单0：临停订单1：预约临停订单2：租赁包月订单|
|check_content|审核结果|

#第三方支付下单接口
####2.2->建行龙支付WEB下单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pay_type|支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付|否| 无 |整型|
| pay_price| 充值金额 单位 分 | 否| 无 |整型|
| version| 当前APP版本编号|否| 无 |整型|
| subject| 商品名称|是| 无 |字符串|
| system_type| 操作系统类型（IOS Android web） 1:android 2:IOS 3:web 4:PDA|否| 无 |整型|
| t| 时间戳ms|否| 无 |长整型|
| token| 用户授权码(用户基本信息里面有 当为PDA的时候传递"")|否| 无 |字符串|
| show_url| 收银台页面上，商品展示的超链接，必填|是| 无 |字符串|
| return_url| 页面跳转同步通知页面路径|是| 无 |字符串|
| type| 是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付|否| 无 |整型|
| orderid|付款支付停车订单ID 如果多个 中间逗号分割 例如（a123,b123,c123）|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pay_type+pay_price+t+token)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/lzf_charge.php](http://139.224.29.103/v1/lzf_charge.php)

######注意事项
当act_type = 1：代表用户充值  建行龙支付 下单的时候拼接地址中的 remark1=1  
当act_type=2 ： 代表用户APP支付普通订单扣款 建行龙支付 下单的时候拼接地址中的 remark1=2 
当act_type=3:  代表用户APP支付租赁订单扣款 建行龙支付 下单的时候拼接地址中的 remark1=3

当type=1 时候 orderid  可以不传递该参数
当type=2 时候 orderid 代表临停停车订单
当type=3 时候 orderid 代表租赁订单

######返回结果
    {
        "data": {
            "act_type": 1,
            "ctime": 1479384712688,
            "etime": 1479384712688,
            "id": 2,
            "ip": "",
            "money": 1,
            "note": "",
            "order_id": "2016111720113718",
            "referer": "",
            "return_url": "",
            "state": 0,
            "subject": "",
            "system_type": 0,
            "transaction_id": "",
            "type": 4,
            "ui_id": 4,
            "ui_nd": "2016090910294823",
            "utime": 1479384712688,
            "version_code": 1，
            "pub":adsdad1231231233sadsad
        },
        "errorcode": "",
        "errormsg": "下单成功",
        "errorno": "0"
    }

#########返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| order_id| 订单ID| 无 |字符串|
| pub| 建行龙支付公钥后30位| 30 |字符串|
| subject| 商品名称| 无 |字符串|


####2.3->支付宝APP充值下单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pay_type|支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付|否| 无 |整型|
| pay_price| 充值金额 单位 分 | 否| 无 |整型|
| version| 当前APP版本编号|否| 无 |整型|
| subject| 商品名称|是| 无 |字符串|
| system_type| 操作系统类型（IOS Android web） 1:android 2:IOS 3:web  4:PDA|否| 无 |整型|
| t| 时间戳ms|否| 无 |长整型|
| token| 用户授权码(用户基本信息里面有) 当为PDA的时候传递""|否| 无 |字符串|
| show_url| 收银台页面上，商品展示的超链接，必填|是| 无 |字符串|
| return_url| 页面跳转同步通知页面路径|是| 无 |字符串|
| type| 是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付|否| 无 |整型|
| orderid|付款支付停车订单ID 如果多个 中间逗号分割 例如（a123,b123,c123）|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pay_type+pay_price+t+token)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/zfb_charge.php](http://139.224.29.103/v1/zfb_charge.php)

####注意事项
当type=1 时候 orderid  可以不传递该参数
当type=2 时候 orderid 代表临停停车订单
当type=3 时候 orderid 代表租赁订单


######返回结果
    {
        "data": {
            "act_type": 1,
            "ctime": 1479384712688,
            "etime": 1479384712688,
            "id": 2,
            "ip": "",
            "money": 1,
            "note": "",
            "order_id": "2016111720113718",
            "referer": "",
            "return_url": "",
            "state": 0,
            "subject": "",
            "system_type": 0,
            "transaction_id": "",
            "type": 4,
            "ui_id": 4,
            "ui_nd": "2016090910294823",
            "utime": 1479384712688,
            "version_code": 1，
            "orderInfo":adsdad1231231233sadsad,
            "sign":"asdsadasdasdasda",
            "timestamp":"2016-07-29 16:55:53"
        },
        "errorcode": "",
        "errormsg": "下单成功",
        "errorno": "0"
    }



####2.4->微信APP充值下单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pay_type|支付类型 1:支付宝  2：微信  3：银联  4：钱包 5:龙支付|否| 无 |整型|
| pay_price| 充值金额 单位 分 | 否| 无 |整型|
| version| 当前APP版本编号|否| 无 |整型|
| subject| 商品名称|是| 无 |字符串|
| system_type| 操作系统类型（IOS Android web） 1:android 2:IOS 3:web  4:PDA|否| 无 |整型|
| t| 时间戳ms|否| 无 |长整型|
| token| 用户授权码(用户基本信息里面有) 当为PDA的时候传递""|否| 无 |字符串|
| show_url| 收银台页面上，商品展示的超链接，必填|是| 无 |字符串|
| return_url| 页面跳转同步通知页面路径|是| 无 |字符串|
| type| 是支付 还是 充值  1：充值  2：普通订单支付  3：租赁订单支付|否| 无 |整型|
| orderid|付款支付停车订单ID 如果多个 中间逗号分割 例如（a123,b123,c123）|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pay_type+pay_price+t+token)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/weixin_charge.php](http://139.224.29.103/v1/weixin_charge.php)

####注意事项
当type=1 时候 orderid  可以不传递该参数
当type=2 时候 orderid 代表临停停车订单
当type=3 时候 orderid 代表租赁订单


######返回结果
    {
        "data": {
            "utime": 1488852301307,
            "ui_nd": "2017030114385872",
            "car_order_id": "",
            "subject": "吾泊微信充值",
            "tel": "15882345446",
            "state": 0,
            "type": 2,
            "order_id": "2017030710057483",
            "ctime": 1488852301307,
            "transaction_id": "",
            "version_code": 1,
            "ip": "127.0.0.1",
            "return_url": "",
            "sign": "6515280066BDD08B8E5D2ED8950C4933",
            "orderInfo": {
                "sign": "6515280066BDD08B8E5D2ED8950C4933",
                "timestamp": "1488852301307",
                "noncestr": "qdAaAZI1f9WtNfcCVhCTMChIXLFoUzp9",
                "partnerid": "1426571202",
                "prepayid": "wx20170307100503580bf3f85f0736305710",
                "package": "Sign=WXPay",
                "appid": "wxa8c52369cd7047b5"
            },
            "timestamp": "2017-03-07 10:05:03",
            "id": 279,
            "system_type": 1,
            "etime": 1488852301307,
            "act_type": 1,
            "money": 1,
            "referer": "",
            "ui_id": 92,
            "note": ""
        },
        "errorcode": "",
        "errormsg": "微信充值成功",
        "errorno": "0"
    }


