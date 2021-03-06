###道闸 ：： 1.订单管理模块

####~~1.1->PDA-获取某停车场有效的预约订单列表~~

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| page| 页数|否| 无 |整型|
| size| 每页条数|否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pda_expect_order.php](http://139.224.29.103/v1/pda_expect_order.php)

######返回结果

    {
        "data": [
            {
                "address_name": "",
                "allege_state": 0,
                "area_code": "510101",
                "arrive_time": 1479110650000,
                "cancel_state": 0,
                "car_code": "川A11111",
                "charging": 0,
                "charging_time": 0,
                "ctime": 1479110650000,
                "discount_money": 0,
                "discount_name": "",
                "discount_type": 0,
                "expect_info": "预约提示信息",
                "expect_money": 400,
                "expect_time": 60,
                "final_time": 0,
                "id": 415,
                "is_cash": 0,
                "is_del": 0,
                "is_expect_deduct": 0,
                "is_expect_outtime": 0,
                "is_open": 0,
                "leave_time": 1479110650000,
                "money": 0,
                "my_order": "2016111416040443",
                "note": "用户预约下单",
                "open_time": 1479110650000,
                "order_type": 1,
                "other_order": "",
                "park_type": 1,
                "pay_source": 0,
                "pay_type": 0,
                "phone_type": 0,
                "pi_id": 17,
                "pp_state": 0,
                "pp_versioncode": "1.0",
                "start_price": 0,
                "start_time": 0,
                "ui_id": 7,
                "upc_id": 0,
                "utime": 1479110650000,
                "lat": 30.649776,
			    "lng": 104.069133
            }
        ],
        "errorcode": "",
        "errormsg": "获取PDA的预约且未付款和未取消的订单",
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






#临停车辆扣款--道闸停车
####1.2>道闸停车场更新现金支付状态和金额

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| money| 金额（ 单位分） | 否| 无 |整型|
| orderid| 我们的订单号  字符串 | 否| 无 |字符串|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| type| 处理类型  0:常规类型  1：免费分钟类型 2:免费车类型 3：包月车类型 4：租赁车类型| 否| 无 |整型|
| sync_time|(异步上传)离线端入库时间或者出库时间  13位毫秒数| 是| 无 |长整型|
| is_sync|(异步上传)如果是异步上传  is_sync=1 | 是| 无 |整型|
| sign| MD5数字签名(dtype+orderid+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|


######<font color=#00ffff size=72>注意事项</font>
######<font color=#00ffff size=5>新增异常数据上传控制参数is_sync和本地离线时间sync_time</font>
####请求路径

[http://139.224.29.103/v1/pay_sure.php](http://139.224.29.103/v1/pay_sure.php)

######返回结果
    {
        "data": "",
        "errorcode": "",
        "errormsg": "处理成功",
        "errorno": "0"
    }
#####返回结果情况
|名称|描述|
|--------|------|
| errorcode| 1|处理失败|


####1.3>道闸停车场--调用自动扣费

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| orderid| 我们的订单号  字符串 | 否| 无 |字符串|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| is_rent| 是否是租赁车辆 0:不是 1：是 | 否| 无 |整型|
| money| 实际扣费金额 单位分| 否| 无 |整型|
| final_time| 计费时长 （单位分钟）| 否| 无 |整型|
| sign| MD5数字签名(dtype+orderid+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/payment.php](http://139.224.29.103/v1/payment.php)

######返回结果
    {
        "data": {
            "auto_state": 1
        },
        "errorcode": "",
        "errormsg": "处理成功",
        "errorno": "0"
    }

#####<font color="#ff0000">备注：auto_state 1: 自动支付失败</font>







####1.4->更新订单的 预约  取消预约  租赁 状态----（道闸停车 郑虎专用）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| car_code| 车牌号| 否| 无 |字符串|
| orderid| 我们的订单号| 否| 无 |字符串|
| type|0：预约   1：取消预约  2：租赁 | 否| 无 |整型|
| state|处理结果状态 0:成功 1：失败 | 否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+orderid+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/upate_order_state.php](http://139.224.29.103/v1/upate_order_state.php)

######返回结果
    {
        "data":"",
        "errorcode": "",
        "errormsg": "处理成功",
        "errorno": "0"
    }




####1.5->租赁订单产生了临时费用  直接生成一个临停订单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| final_time| 结算时计费时长（单位分钟）-- 当前时间-创建时间=起步时长+计费时长 | 否| 无 |整型|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌 | 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色 | 否| 无 |整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| money| 缴费金额|否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+final_time+money)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/temporary_order.php](http://139.224.29.103/v1/temporary_order.php)

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



####1.6->更新订单的确认出库状态（道闸停车场）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| my_order| 订单号|否| 无 |字符串|
| order_type| 订单类型 1：用户支付停车下单表  2：用户支付租赁停车下单表|否| 无 |整型|
| sign| MD5数字签名(dtype+my_order+order_type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/parkconfirmcarout.php](http://139.224.29.103/v1/parkconfirmcarout.php)

######返回结果

    {
        "data": "",
        "errorcode": "",
        "errormsg": "操作成功",
        "errorno": "0"
    }

####1.7->服务器端订单假删除接口（目前只应用于道闸停车场）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID|否| 无 |长整型|
| area_code| 省市区地址编码|否| 无 |字符串|
| my_order| 订单号|否| 无 |字符串|
| order_type| 订单类型 1：普通订单  2：租赁订单|否| 无 |整型|
| sign| MD5数字签名(dtype+my_order+pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/orderfakedel.php](http://139.224.29.103/v1/orderfakedel.php)

######返回结果

    {
        "data": "",
        "errorcode": "",
        "errormsg": "操作成功",
        "errorno": "0"
    }

####1.8->更新预约/租赁超时状态--（道闸、占道停车）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| orderid| 我们的订单号| 否| 无 |字符串|
| type|0：预约   1：租赁 | 否| 无 |整型|
| sign| MD5数字签名(dtype+orderid+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/upate_order_overtime.php](http://139.224.29.103/v1/upate_order_overtime.php)

######返回结果
    {
        "data": "",
        "errorcode": "",
        "errormsg": "更新预约/租赁超时状态成功",
        "errorno": "0"
    }

####1.9->租赁、本地包月、本地免费订单产生了临时费用直接生成一个临停订单

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID|否| 无 |长整型|
| area_code| 省市区区域代码  四川省 成都市 龙泉驿区510112 | 否| 无 |字符串|
| car_code| 车牌号辽JQQ360 | 否| 无 |字符串|
| final_time| 结算时计费时长（单位分钟）-- 当前时间-创建时间=起步时长+计费时长|否| 无 |整型|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌 | 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 否| 无 |整型|
| money| 缴费金额单位分|否| 无 |整型|
| create_time| 创建时间   13位毫秒数|否| 无 |长整型|
| order_type| 下单类型 0: 普通下单  1：预约下单 2：租赁临停订单   3:免费转临停   4：包月转临停|否| 无 |整型|
| order_id| 客户端创建的订单ID|否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+final_time+money+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/temporaryorder.php](http://139.224.29.103/v1/temporaryorder.php)

######返回结果

    {
        "data": {
            "address_name": "天府立交(入口)",
            "ai_effect": 0,
            "ai_id": 0,
            "ai_money": 0,
            "allege_state": 0,
            "area_code": "510107",
            "arrive_time": 1496994372529,
            "cancel_state": 0,
            "car_code": "川A11111",
            "charging": 1,
            "charging_time": 60,
            "ctime": 1496994372529,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "",
            "expect_money": 0,
            "expect_state": 0,
            "expect_time": 0,
            "final_time": 2,
            "free_minute": 0,
            "gov_num": "",
            "id": 0,
            "is_cash": 0,
            "is_del": 0,
            "is_expect_deduct": 0,
            "is_expect_outtime": 0,
            "is_free_minute": 0,
            "is_open": 0,
            "is_over": 0,
            "lat": 30.598148,
            "leave_time": 1497239623880,
            "lng": 104.076324,
            "magnetic_state": 0,
            "money": 200,
            "my_order": "5101071000000360201706121153437s",
            "note": "",
            "open_time": 1497239623880,
            "order_type": 2,
            "other_order": "",
            "park_type": 0,
            "pay_source": 0,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 36,
            "pi_name": "天府三街停车场",
            "pp_state": 0,
            "pp_versioncode": "",
            "pu_id": 0,
            "pu_nd": "",
            "scan_time": 1496994372529,
            "start_price": 2,
            "start_time": 120,
            "stime": 1497239623880,
            "ui_id": 51,
            "ui_nd": "2016121910525321",
            "ui_tel": "18780169455",
            "upc_id": 0,
            "utime": 1496994372529
        },
        "errorcode": "",
        "errormsg": "生成订单成功",
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
|pay_source|支付类型1:支付宝2：微信3：银联4：钱包5:龙支付6:ETC快捷支付|int|
|my_order|我们的订单号|String|
|other_order|第三方的支付单号|String|
|pay_type|支付类型0:手动输入密码支付1：快捷支付（服务器可以请求第三方直接扣款）|int|
|pp_versioncode|当前APPSDK版本号（内部升级版本代号）|String|
|phone_type|手机类型0:android1：IOS|int|
|order_type|下单类型0:普通下单1：预约下单2：租赁临停订单3:包月临停4：免费临停|int|
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
|is_over|订单是否完成或者逃逸(0:没有完成1：完成2：车辆逃逸3：未交费4：PDA补交欠费已完成5：PDA补交逃逸已完成)|int|
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
|magnetic_state|智能磁场入库出库状态（1：已入库2：已出库3：车辆逃逸4：其它故障）|int|
|gov_num|智能磁场车位编号（政府部门统一分配）|String|
|stime|服务器端接收数据创建时间|java.util.Date|
|up_orderid|第三方支付user_pay中的流水单号(订单支付、欠费订单补交)|String|

