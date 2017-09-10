###PDA :: 1.PDA_v2版本管理模块

#####测试的时候前缀：http://139.224.29.103:8091





####1.1->占道停车场PDA MAC的初始化提交



|参数名称|值描述|是否可空|限制长度|参数类型|

|--------|-----|----|--------|-------|

| mac| 设备MAC地址 | 否| 无 |字符串|

| sign| MD5数字签名(dtype+mac)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径



[http://139.224.29.103/v1/init_pda_v2.php](http://139.224.29.103/v1/init_pda_v2.php)



######返回结果

    {

        "data": {

            "area_code": "",

            "ctime": 1490603944122,

            "is_initialize": 1,

            "lat": 0,

            "lng": 0,

            "loginname": "20170327163904",

            "mac": "869612023700513",

            "note": "",

            "password": "e10adc3949ba59abbe56e057f20f883e",

            "pda_c_id": 0,

            "pda_id": 0,

            "pda_sn": "2017032716398081",

            "pi_id": 0,

            "pi_name": "",

            "plate_license": "",

            "pu_id": 0,

            "pu_nd": "",

            "utime": 1490603944122

        },

        "errorcode": "",

        "errormsg": "初始化成功",

        "errorno": "0"

    }



#########返回字段说明

|名称|描述|类型|

|----|----|---|

|pda_id|主键ID|long|

|mac|PDA设备MAC|String|

|pda_sn|PDA设备串号|String|

|plate_license|惠通扫描授权串号(序列号)|String|

|loginname|PDA登录帐号|String|

|password|PDA登录密码|String|

|pi_id|PDA关联的停车场ID|long|

|area_code|PDA关联的停车场地址编码|String|

|pu_id|PDA关联的商户ID|long|

|pu_nd|PDA关联的商户的ND|String|

|ctime|创建时间|java.util.Date|

|utime|更新时间|java.util.Date|

|note|备注|String|

|is_initialize|是否初始化成功0:没有初始化1：初始化成功|int|

|lng|初始化经度|double|

|lat|初始化纬度|double|

|pi_name|停车场名称|String|

|pda_c_id|逻辑渠道表主键ID（外键）|long|



####1.2->占道停车场PDA登录



|参数名称|值描述|是否可空|限制长度|参数类型|

|--------|-----|----|--------|-------|

| loginname| 占道停车场的分配的帐号 | 否| 无 |字符串|

| password| 占道停车场的密码 | 否| 无 |字符串|

| mac| 设备MAC地址 | 否| 无 |字符串|

| vnum| 内部版本编号 数字 | 否| 无 |整型|

| sign| MD5数字签名(dtype+mac+loginname+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径



[http://139.224.29.103/v1/pda_login.php](http://139.224.29.103/v1/pda_login.php)



######返回结果

    {

        "data": {

            "pda_info": {

                "area_code": "510107",

                "ctime": 1490603944000,

                "is_initialize": 1,

                "lat": 0,

                "lng": 0,

                "loginname": "20170327163904",

                "mac": "869612023700513",

                "note": "",

                "password": "e10adc3949ba59abbe56e057f20f883e",

                "pda_c_id": 0,

                "pda_id": 1,

                "pda_sn": "2017032716398081",

                "pi_id": 2,

                "pi_name": "",

                "plate_license": "",

                "pu_id": 1,

                "pu_nd": "20161227141900",

                "utime": 1490603944000

            },

            "park_info": {

                "address_name": "英郡1期",

                "admin_id": 1,

                "allow_expect_time": 60,

                "allow_revoke_time": 5,

                "area_code": "510107",

                "camera_info": "火眼",

                "carport_space": 1,

                "carport_total": 3,

                "carport_yet": 2,

                "copy_linkman_name": "xxx",

                "copy_linkman_tel": "15808549031",

                "ctime": 1482819742000,

                "department": "希望国际大厦",

                "enter_camera_num": 1,

                "enter_num": 1,

                "exit_camera_num": 1,

                "exit_num": 1,

                "expect_car_num": 0,

                "expect_money": 10,

                "hlc_enter_num": 1,

                "hlc_exit_num": 1,

                "is_expect": 1,

                "is_fault": 1,

                "is_rent": 0,

                "lat": 30.544615,

                "linkman_name": "xxx",

                "linkman_tel": "15808549031",

                "lng": 104.072689,

                "loginname": "510107377013",

                "mac": "869612023700513",

                "money": 2,

                "month_price": 0,

                "moth_car_num": 0,

                "moth_car_num_space": 0,

                "note": "11111111",

                "park_type": 1,

                "password": "e10adc3949ba59abbe56e057f20f883e",

                "pda_permit_time": "07:00-21:00",

                "pi_id": 2,

                "pi_name": "英俊一期",

                "pi_phone": "15808549031",

                "pi_state": 1,

                "pu_id": 1,

                "pu_nd": "20161227141900",

                "rent_info": "",

                "roadside_type": 1,

                "time_car_num": 0,

                "time_car_num_space": 0,

                "timeout_info": "单次0.02元",

                "upload_source": 1,

                "utime": 1484554131000

            }

        },

        "errorcode": "",

        "errormsg": "登录成功",

        "errorno": "0"

    }

#########返回字段说明 park_info:

|名称|描述|类型|

|----|----|---|

|pi_id|主键ID|long|

|area_code|省市县编号|String|

|pi_name|场地名称|String|

|address_name|场地地理位置名称|String|

|lng|场地经度|double|

|lat|场地纬度|double|

|linkman_name|场地联系人姓名|String|

|linkman_tel|场地联系人手机|String|

|copy_linkman_name|备用联系人姓名|String|

|copy_linkman_tel|备用联系人手机|String|

|pi_phone|场地座机号|String|

|department|负责单位|String|

|enter_num|场地口入数量|int|

|exit_num|场地出口数量|int|

|hlc_enter_num|场地入口道闸数量|int|

|hlc_exit_num|场地出口道闸数|int|

|enter_camera_num|场地入口摄像头数|int|

|exit_camera_num|场地出口摄像头数|int|

|camera_info|场地摄像头型号|String|

|ctime||java.util.Date|

|utime||java.util.Date|

|park_type|停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场|int|

|is_expect|是否开启预约0:不开启1：开启|int|

|expect_money|每小时预约费用（单位分）|int|

|allow_revoke_time|允许预约撤单时间(单位分钟)|int|

|allow_expect_time|允许预约时间最大时长(单位分钟)|int|

|timeout_info|计费信息首停2小时5元，之后每小时2元|String|

|rent_info|租赁计费信息准入时段18:00-08:00，300元/月|String|

|month_price|租赁包月价格|int|

|is_rent|是否开启租赁0:未开启1：已经开启|int|

|money|蓝牌小汽车起步价|int|

|loginname|露天停车场帐号|String|

|password|露天停车场密码|String|

|mac|露天停车场PDAMAC（逗号分割）|String|

|is_fault|停车场故障0:无故障1：发生故障|int|

|pi_state|停车场状态（1开启0关闭）|int|

|roadside_type|占道停车是否按次数收费0:按时间收费1：按次数收费|int|

|pu_id|关联的商户主键ID|long|

|pu_nd|商户ND（商户编号）|String|

|note|备注|String|

|carport_yet|临停已停车位|int|

|carport_space|临停空车位个数|int|

|carport_total|临停总车位个数|int|

|moth_car_num|租赁离线包月车位总个数|int|

|moth_car_num_space|租赁离线剩余车位数|int|

|time_car_num|时间段包月车位总数|int|

|time_car_num_space|时间段包月车位剩余个数|int|

|expect_car_num|已预约车位数|int|

|upload_source|上传数据来源0:离线道闸上传1：中心管理后台录入2：Android市场人员跑动录入|int|

|admin_id|上传数据后台管理账户ID|long|

|pda_permit_time|PDA停车场上班时间-下班时间(8:00-21:00)|String|





#########返回字段说明  pda_info:

|名称|描述|类型|

|----|----|---|

|pda_id|主键ID|long|

|mac|PDA设备MAC|String|

|pda_sn|PDA设备串号|String|

|plate_license|惠通扫描授权串号(序列号)|String|

|loginname|PDA登录帐号|String|

|password|PDA登录密码|String|

|pi_id|PDA关联的停车场ID|long|

|area_code|PDA关联的停车场地址编码|String|

|pu_id|PDA关联的商户ID|long|

|pu_nd|PDA关联的商户的ND|String|

|ctime|创建时间|java.util.Date|

|utime|更新时间|java.util.Date|

|note|备注|String|

|is_initialize|是否初始化成功0:没有初始化1：初始化成功|int|

|lng|初始化经度|double|

|lat|初始化纬度|double|

|pi_name|停车场名称|String|

|pda_c_id|逻辑渠道表主键ID（外键）|long|

|vnum|当前内部版本号|int|



####1.3->获取设备 Android PDA 升级对应的包URL



|参数名称|值描述|是否可空|限制长度|参数类型|

|--------|-----|----|--------|-------|

| mac| 设备MAC地址 | 否| 无 |字符串|

| versioncode| 内部版本编号 数字 | 否| 无 |整型|

| sign| MD5数字签名(mac+versioncode)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径



[http://139.224.29.103/v1/pda_gainupgrade.php](http://139.224.29.103/v1/pda_gainupgrade.php)



######返回结果

    {

        "data": {

            "content": "更新了XXX",

            "is_forced": 0,

            "md5": "ewr3134e1",

            "type": "pda",

            "update": 1,

            "url": "http://inner.xx.com/file/xxx-release.apk",

            "version": "v2.0",

            "versioncode": 2

        },

        "errorcode": "",

        "errorno": "0"

    }



#########返回字段说明

|名称|描述|类型|

|----|----|---|

|content|更新内容说明|字符串|

|is_forced|是否强制更新 0:不强制 1：强制更新|整型|

|md5|PDA打的APK包的MD5校验值|字符串|

|type|类型 例如 PDA|字符串|

|update|是否有升级 是否有更新  1 :是 0: 否 |整型|

|version|版本外部显示字符串号|字符串|

|versioncode|内部版本编号|整型|

####1.4->PDA--检查某停车场某车牌号是否已经付款

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| car_code| 车牌号| 否| 无 |字符串|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| orderid| 我们的订单号| 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_pda_checkpay.php](http://139.224.29.103/v1/read_pda_checkpay.php)

######返回结果
    {
        "data": {
        	"ui_id": 0,
            "money": 0,
            "state": 0,
            "car_code": "川A4M99B"，
            "is_cash":0 是否现金支付0：在线支付1：现金支付,
            "pay_source": 1, 支付类型1:支付宝2：微信3：银联4：钱包5:龙支付
            "escape_orderids":"2017052511374242744,2017052511374242745"
        },
        "errormsg": "查询是否已经付款成功",
        "errorno": "0"
    }
######返回字段说明

|名称|值描述|限制长度|参数类型|
|--------|----|--------|-------|
| money| 支付金额 单位 分| 无 |整型|
| state| 是否支付  0：未支付 1：已经支付| 无 |整型|
| car_code| 车牌号| 无 |字符串|
| ui_id| 用户ID| 无 |长整型|
| is_cash| 是否现金支付0：在线支付1：现金支付| 无 |整型|
| pay_source| 支付类型：1:支付宝 2：微信 3：银联 4：钱包 5:龙支付| 无 |整型|



####1.5->获取PDA或者道闸的对应的车是否是逃逸车辆或者未交费车辆--旧接口

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


####1.6->PDA或者道闸的跨商户对应的车的欠费记录（是否是欠费费车辆）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场ID | 否| 无 |长整型|
| car_code|车牌号| 否| 无 |字符串|
| area_code| 省市区区域代码 | 否| 无 |字符串|
| type|是否是同省跨商户类型： 0 ：同商户 1：同省跨商户| 否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+area_code+type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pda_check_car_owe.php](http://139.224.29.103/v1/pda_check_car_owe.php)

######返回结果 情况1
    {
        "data": "",
        "errorcode": "",
        "errormsg": "不是未交费车辆",
        "errorno": "0"
    }
######返回结果 情况2
    {
        "data": [
            {
                "address_name": "西华大学(西南门)",
                "ai_effect": 0,
                "ai_id": 0,
                "ai_money": 0,
                "allege_state": 0,
                "area_code": "510124",
                "arrive_time": 1489115776000,
                "cancel_state": 2,
                "car_code": "川ASD677",
                "charging": 400,
                "charging_time": 60,
                "ctime": 1489115776000,
                "discount_money": 0,
                "discount_name": "",
                "discount_type": 0,
                "expect_info": "",
                "expect_money": 0,
                "expect_state": 0,
                "expect_time": 0,
                "final_time": 0,
                "free_minute": 0,
                "id": 870,
                "is_cash": 0,
                "is_del": 0,
                "is_expect_deduct": 0,
                "is_expect_outtime": 0,
                "is_free_minute": 0,
                "is_open": 0,
                "is_over": 3,
                "lat": 30.775522,
                "leave_time": 1489115776000,
                "lng": 103.947136,
                "money": 400,
                "my_order": "2017031011168836",
                "note": "",
                "open_time": 1489115776000,
                "order_type": 0,
                "other_order": "",
                "park_type": 1,
                "pay_source": 0,
                "pay_type": 0,
                "phone_type": 0,
                "pi_id": 66,
                "pi_name": "西华大学西门",
                "pp_state": 0,
                "pp_versioncode": "",
                "pu_id": 2,
                "pu_nd": "20161228091528",
                "scan_time": 1489115776000,
                "start_price": 400,
                "start_time": 60,
                "ui_id": 0,
                "ui_nd": "",
                "ui_tel": "",
                "upc_id": 0,
                "utime": 1489116445000
            }
        ],
        "errorcode": "",
        "errormsg": "是欠费车辆",
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

####1.7->PDA--PDA管理员提交一些反馈信息到服务器（占道停车场）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| pi_name| 停车场名称| 否| 无 |字符串|
| pda_id| PDA设备表的主键ID（PDA登录成功后返回的数据里面有）| 否| 无 |长整型|
| content| 反馈信息| 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/pda_feedback.php](http://139.224.29.103/v1/pda_feedback.php)

######返回结果
    {
        "data": "",
        "errorcode": "",
        "errormsg": "pda用户反馈成功",
        "errorno": "0"
    }
