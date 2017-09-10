###APP ：： 1.车库管理模块
#####测试的时候前缀：http://139.224.29.103:8091



####1.1->读取停车场详情

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 省市县编号 510122 | 是| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_park_info.php](http://139.224.29.103/v1/read_park_info.php)

######返回结果
    {
        "data": {
            "address_name": "武侯区天府软件园E1",
            "allow_expect_time": 60,
            "allow_revoke_time": 5,
            "area_code": "511302",
            "camera_info": "火眼",
            "carport_space": 488,
            "carport_total": 500,
            "carport_yet": 12,
            "copy_linkman_name": "xxx",
            "copy_linkman_tel": "15182829496",
            "ctime": 1473388191000,
            "department": "负责单位",
            "enter_camera_num": 2,
            "enter_num": 1,
            "exit_camera_num": 1,
            "exit_num": 1,
            "expect_car_num": 0,
            "expect_money": 600,
            "hlc_enter_num": 2,
            "hlc_exit_num": 1,
            "is_expect": 1,
            "is_fault": 0,
            "is_rent": 0,
            "lat": 30.649776,
            "linkman_name": "xxx",
            "linkman_tel": "15182829496",
            "lng": 104.069133,
            "loginname": "10001",
            "mac": "869612021322674",
            "money": 500,
            "month_price": 0,
            "moth_car_num": 0,
            "moth_car_num_space": 0,
            "note": "",
            "park_type": 1,
            "password": "e10adc3949ba59abbe56e057f20f883e",
            "pi_id": 18,
            "pi_name": "天府软件园E1栋停车场",
            "pi_phone": "15182829496",
            "pi_state": 0,
            "pu_id": 0,
            "pu_nd": "",
            "rent_info": "",
            "roadside_type": 0,
            "time_car_num": 0,
            "time_car_num_space": 0,
            "timeout_info": "首停2小时6元，之后每小时4元",
            "utime": 1481185076000，
               "carport_yet":0, '临停已停车位',
           "carport_space":0,  '临停空车位个数',
           "carport_total":0, '临停总车位个数',
           "moth_car_num":0, '租赁离线包月车位总个数',
           "moth_car_num_space":0, '租赁离线剩余车位数',
           "time_car_num":0, '时间段包月车位总数',
           "time_car_num_space":0, '时间段包月车位剩余个数',
           "expect_car_num":0, '已预约车位数',
        },
        "errorcode": "",
        "errormsg": "获取停车场详情成功",
        "errorno": "0"
    }


####1.2->通过GPS导航获取该经纬度范围内的停车场数据列表（普通车位停车）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| park_type| 停车场类型 0：地下室停车场 1：露天停车场 2：露天立体车库停车场 | 否| 无 |整型|
| distance| 距离范围直径(默认500米) 单位米 | 是| 无 |整型|
| type| 0 :按距离 1：按价格| 否| 无 |整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_gpspark.php](http://139.224.29.103/v1/read_gpspark.php)

######返回结果

    {
        "data": [
            {
                "address_name": "天府三街地铁A出口",
                "allow_expect_time": 0,
                "allow_revoke_time": 0,
                "area_code": "0",
                "camera_info": "罗技Pro C920",
                "carport_space": 0,
                "carport_total": 100,
                "carport_yet": 0,
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
                "lat": 33.43144,
                "linkman_name": "敬小虎",
                "linkman_tel": "15882345446",
                "lng": 109.77539000000002,
                "moth_car_num": 0,
                "note": "",
                "park_type": 0,停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场
                "pi_id": 1,
                "pi_name": "四川乐库斯",
                "pi_phone": "028-85960236",
                "rent_info": "",
                "time_car_num": 0,
                "timeout_info": "",
                "utime": 1470296969000，
                "month_price":5000,
                "is_rent":0，
                "is_expect":0，是否开启预约 0:不开启 1：开启,
                "money":0 蓝牌小汽车起步价，
                   "carport_yet":0, '临停已停车位',
               "carport_space":0,  '临停空车位个数',
               "carport_total":0, '临停总车位个数',
               "moth_car_num":0, '租赁离线包月车位总个数',
               "moth_car_num_space":0, '租赁离线剩余车位数',
               "time_car_num":0, '时间段包月车位总数',
               "time_car_num_space":0, '时间段包月车位剩余个数',
               "expect_car_num":0, '已预约车位数',
            }
        ],
        "errormsg": "查询附近的停车场信息成功",
        "errorno": "0"
    }


####1.3->~~通过GPS导航获取 该经纬度范围内的停车场数据列表 ---- 车位租赁~~

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| park_type| 停车场类型 0：地下室停车场 1：露天停车场 2：露天立体车库停车场 | 否| 无 |整型|
| distance| 距离范围直径(默认500米) 单位米 | 是| 无 |整型|
| type| 0 :按距离 1：按价格| 否| 无 |整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_gpspark_rent.php](http://139.224.29.103/v1/read_gpspark_rent.php)

######返回结果

    {
        "data": [
            {
                "address_name": "天府三街地铁A出口",
                "allow_expect_time": 0,
                "allow_revoke_time": 0,
                "area_code": "0",
                "camera_info": "罗技Pro C920",
                "carport_space": 0,
                "carport_total": 100,
                "carport_yet": 0,
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
                "lat": 33.43144,
                "linkman_name": "敬小虎",
                "linkman_tel": "15882345446",
                "lng": 109.77539000000002,
                "moth_car_num": 0,
                "note": "",
                "park_type": 0,停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场
                "pi_id": 1,
                "pi_name": "四川乐库斯",
                "pi_phone": "028-85960236",
                "rent_info": "",
                "time_car_num": 0,
                "timeout_info": "",
                "utime": 1470296969000,
                "month_price":5000,
                "is_rent":0，
                "is_expect":0，是否开启预约 0:不开启 1：开启,
                "money":0 蓝牌小汽车起步价，
                   "carport_yet":0, '临停已停车位',
               "carport_space":0,  '临停空车位个数',
               "carport_total":0, '临停总车位个数',
               "moth_car_num":0, '租赁离线包月车位总个数',
               "moth_car_num_space":0, '租赁离线剩余车位数',
               "time_car_num":0, '时间段包月车位总数',
               "time_car_num_space":0, '时间段包月车位剩余个数',
               "expect_car_num":0, '已预约车位数',
            }
        ],
        "errormsg": "查询附近的停车场信息成功",
        "errorno": "0"
    }





####1.4->读取停车场计费规则信息

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| area_code| 省市县编号 510122 | 是| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/read_charging_rule.php](http://139.224.29.103/v1/read_charging_rule.php)
######注意事项 占道停车 规则只有一条 直接取列表第一条 即可
######返回结果
    {
        "data": [
            {
                "area_code": "511302",
                "car_code_color": 2,
                "car_displacement": "1.6",
                "car_type": 0,
                "charging": 400,
                "charging_time": 60,
                "ctime": 1473389507000,
                "is_default": 0,
                "is_time_bucket": 1,
                "month_price": 60000,
                "month_time": 30,
                "note": "",
                "permit_time": "0:00-24:00",
                "pi_id": 9,
                "rcr_discount": 1,
                "rcr_id": 11,
                "rcr_md5": "",
                "rcr_state": 0,
                "rcr_type": 0,
                "start_price": 600,
                "start_time": 120,
                "time_bucket": "0:00-24:00",
                "timeout_info": "起步2小时6.00元，之后4.00元/1小时",
                "utime": 1473389507000
            },
            {
                "area_code": "511302",
                "car_code_color": 1,
                "car_displacement": "1.6",
                "car_type": 0,
                "charging": 400,
                "charging_time": 60,
                "ctime": 1473389599000,
                "is_default": 0,
                "is_time_bucket": 1,
                "month_price": 30000,
                "month_time": 30,
                "note": "",
                "permit_time": "0:00-24:00",
                "pi_id": 9,
                "rcr_discount": 1,
                "rcr_id": 12,
                "rcr_md5": "",
                "rcr_state": 0,
                "rcr_type": 0,
                "start_price": 500,
                "start_time": 120,
                "time_bucket": "0:00-24:00",
                "timeout_info": "起步2小时5.00元，之后4.00元/1小时",
                "utime": 1473389599000
            }
        ],
        "errorcode": "",
        "errormsg": "读取停车场计费规则信息成功",
        "errorno": "0"
    }
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|rcr_id|主键ID|long|
|pi_id|停车场主键ID（外键）|long|
|start_price|起步价(RMB单位分)|int|
|start_time|起步价(RMB单位分)|int|
|charging|计费价(RMB单位分)|int|
|charging_time|计费时长(分钟)|int|
|month_price|包月价格(单位分)|int|
|month_time|包月时长(天)|int|
|permit_time|准入时间段（17:00-08:30）|String|
|timeout_info|超时费率(首停2小时3元，之后1元/小时)|String|
|rcr_type|停车类型0：普通车位停车1：时间段包月停车|int|
|rcr_state|是否有效0：有效1：无效|int|
|rcr_discount|是否可以使用优费券:0：可以使用1：无法使用|int|
|car_displacement|车辆排量|String|
|car_type|车牌类型0：未知车牌:、1：蓝牌小汽车、2：:黑牌小汽车、3：单排黄牌、4：双排黄牌、5：警车车牌、6：武警车牌、7：个性化车牌、8：单排军车牌、9：双排军车牌、10：使馆车牌、11：香港进出中国大陆车牌、12：农用车牌、13：教练车牌、14：澳门进出中国大陆车牌、15：双层武警车牌、16：武警总队车牌、17：双层武警总队车牌|int|
|car_code_color|车牌颜色0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色|int|
|is_time_bucket|是否按时间段收费0:不按时间段收费1：按时间段收费|int|
|time_bucket|时间段收费例如：白天9：00-12：00每小时2元|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|rcr_md5|规则MD5校验pi_id+start_price+start_time+charging+charging_time+rcr_type+rcr_discount+car_type+car_sign_type+is_time_bucket|String|
|is_default|是否是默认规则0:不是1：是|int|
|area_code|省市区代码|String|
|note|备注|String|
|free_minute|多少分钟之内进出免费|int|
|is_free_minute|多少分钟之内进出免费是否开启0:不开启1：开启|int|
|roadside_type|占道停车是否按次数收费0:按时间收费1：按次数收费|int|

