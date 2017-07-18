###PDA ：： 地磁管理模块

####1.0->获取地磁停车场车位编号和地磁设备号对应关系

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| sign| MD5数字签名(pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/read_bind_magnetic_device.php](http://139.224.29.103/v1/read_bind_magnetic_device.php)

######返回结果

    {
        "data": [
            {
                "android_dev_num": "a333",
                "area_code": "a111",
                "car_dev_num": "a225",
                "ctime": 1495092046000,
                "fault_count": 0,
                "gov_num": "a123",
                "id": 1,
                "note": "",
                "pi_id": 111,
                "ptime": 1495092046000,
                "state": 0,
                "utime": 1495098371000
            },
            {
                "android_dev_num": "a333",
                "area_code": "a111",
                "car_dev_num": "a224",
                "ctime": 1495098206000,
                "fault_count": 0,
                "gov_num": "a124",
                "id": 2,
                "note": "",
                "pi_id": 111,
                "ptime": 1495098206000,
                "state": 0,
                "utime": 1495098206000
            }
        ],
        "errorcode": "",
        "errormsg": "读取绑定的设备编号成功",
        "errorno": "0"
    }

#########返回字段Data JSONARRAY中的单个对象说明
|名称|描述|类型|
|----|----|---|
|id||long|
|pi_id|停车场主键ID|long|
|area_code|地址编码|String|
|gov_num|政府拟定的车位编码（例如：ASD123）|String|
|car_dev_num|车位设备编码（car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id）|String|
|android_dev_num|android板子设备编码|String|
|state|车位设备状态（0：无车1：有车2：故障）|int|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|ptime|上次推送时间|java.util.Date|
|note|备注|String|
|fault_count|设备故障计数器（当设备恢复正常后需要进行清零）|int|





####1.1->地磁车位号和设备号绑定关系上传接口

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| gov_num| 政府拟定的车位编码（例如：ASD123）| 否| 无 |字符串|
| car_dev_num| 车位设备编码 car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id | 否| 无 |字符串|
| android_dev_num| android板子设备编码  | 是| 无 |字符串|
| sign| MD5数字签名(pi_id+area_code+gov_num+car_dev_num)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/bind_magnetic_device.php](http://139.224.29.103/v1/bind_magnetic_device.php)

{
    "data": {
        "android_dev_num": "a334",
        "area_code": "a112",
        "car_dev_num": "a225",
        "ctime": 1495162403553,
        "fault_count": 0,
        "gov_num": "a126",
        "id": 0,
        "note": "",
        "pi_id": 112,
        "ptime": 1495162403553,
        "state": 0,
        "utime": 1495162403553
    },
    "errorcode": "",
    "errormsg": "设备编号绑定成功",
    "errorno": "0"
}

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|id||long|
|pi_id|停车场主键ID|long|
|area_code|地址编码|String|
|gov_num|政府拟定的车位编码（例如：ASD123）|String|
|car_dev_num|车位设备编码(car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id)|String|
|android_dev_num|android板子设备编码|String|
|state|车位设备状态（0：无车1：有车2：故障）|int|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|ptime|上次推送时间|java.util.Date|
|note|备注|String|
|fault_count|设备故障计数器（当设备恢复正常后需要进行清零）|int|









####1.2->更新地磁车位号和设备号绑定关系

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| gov_num| 政府拟定的车位编码（例如：ASD123）  | 否| 无 |字符串|
| car_dev_num| 车位设备编码(car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id) | 否| 无 |字符串|
| android_dev_num| android板子设备编码  | 是| 无 |字符串|
| sign| MD5数字签名(pi_id+area_code+gov_num+car_dev_num)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/update_magnetic_device.php](http://139.224.29.103/v1/update_magnetic_device.php)

######返回结果

    {
        "data": {
            "android_dev_num": "a334",
            "area_code": "a112",
            "car_dev_num": "a226",
            "ctime": 1495162403000,
            "fault_count": 0,
            "gov_num": "a126",
            "id": 3,
            "note": "",
            "pi_id": 112,
            "ptime": 1495162403000,
            "state": 0,
            "utime": 1495163539241
        },
        "errorcode": "",
        "errormsg": "设备编号修改成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|id||long|
|pi_id|停车场主键ID|long|
|area_code|地址编码|String|
|gov_num|政府拟定的车位编码（例如：ASD123）|String|
|car_dev_num|车位设备编码(car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id)|String|
|android_dev_num|android板子设备编码|String|
|state|车位设备状态（0：无车1：有车2：故障）|int|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|ptime|上次推送时间|java.util.Date|
|note|备注|String|
|fault_count|设备故障计数器（当设备恢复正常后需要进行清零）|int|



####1.3->记录地磁设备状态变更和修正占道停车场车位数量（占道停车场）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| car_dev_num| 车位设备编码(car_dev_num = pi_id + 下划线 + area_code + 下划线 + magnetic_device_id) | 否| 无 |字符串|
| car_port_yet| 临停已停车位 | 否| 无 |整型|
| car_port_space| 临停空车位个数  | 否| 无 |整型|
| car_port_total|临停总车位个数| 否| 无 |整型|
| android_dev_num|android板子设备编码| 否| 无 |字符串|
| state|车位设备状态（0：无车 1：有车 2：故障）| 否| 无 |整型|
| ctime|设备本地创建时间 13位毫秒数| 否| 无 |整型|
| sign| MD5数字签名(pi_id+area_code+car_dev_num+car_port_yet+car_port_space+car_port_total+state+android_dev_num)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/change_magnetic_device_state.php](http://139.224.29.103/v1/change_magnetic_device_state.php)

######返回结果

    {
        "data": "",
        "errorcode": "",
        "errormsg": "修改成功",
        "errorno": "0"
    }

####1.4->记录停车场车位总数、已停车位数、空余车位数 快照（占道、道闸）

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| carport_yet| 临停已停车位 | 否| 无 |整型|
| carport_space| 临停空车位个数  | 否| 无 |整型|
| carport_total|临停总车位个数| 否| 无 |整型|
| park_type|停车场类型( 停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场)| 否| 无 |整型|
| data_flag|上传来源 1：普通占道停车场 2：地磁占道停车场 3：道闸停车场| 否| 无 |整型|
| ctime|设备本地创建时间 长整型 精确到毫秒| 否| 无 |长整型|
| sign| MD5数字签名(dtype+pi_id+area_code)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/insert_park_carport_log.php](http://139.224.29.103/v1/insert_park_carport_log.php)

######返回结果
    {
        "data": {
            "area_code": "510107",
            "carport_space": 1,
            "carport_total": 2,
            "carport_yet": 1,
            "ctime": 1497251988734,
            "data_flag": 2,
            "note": "",
            "park_type": 1,
            "pcl_id": 0,
            "pi_id": 1007,
            "stime": 1497260327435
        },
        "errorcode": "",
        "errormsg": "添加成功",
        "errorno": "0"
    }
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|pcl_id|主键ID|long|
|pi_id|停车场主键ID|long|
|area_code|停车场地址区域编码|String|
|carport_total|车位总数|int|
|carport_yet|已停车位数|int|
|carport_space|空余车位数|int|
|park_type|停车场类型(停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场)|int|
|data_flag|上传来源1：普通占道停车场2：地磁占道停车场3：道闸停车场|int|
|ctime|停车场本地时间|java.util.Date|
|stime|接收数据时间|java.util.Date|
|note|备注|String|

####1.5->地磁Android板子登录(获取停车场基本信息)接口

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| ph_loginname|硬件设备登录帐号| 否| 无 |字符串|
| ph_password| 硬件设备登录密码| 否| 无 |字符串|
| ph_mac| 硬件设备MAC地址 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ph_loginname+ph_password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/getparkinfo_by_hardware_mac.php](http://139.224.29.103/v1/getparkinfo_by_hardware_mac.php)

######返回结果
    {
        "data": {
            "park_hardware_info": {
                "area_code": "500000",
                "ctime": 1497582545000,
                "note": "",
                "park_type": 0,
                "ph_id": 4,
                "ph_licence": "",
                "ph_loginname": "20170613111717",
                "ph_mac": "869449020404324",
                "ph_password": "",
                "ph_state": 0,
                "pi_id": 67,
                "token": "ac0a8e841e184567be6fb340fdc79fba",
                "type": 0,
                "utime": 1497582545000
            },
            "park_info": {
                "address_name": "重庆北站",
                "admin_id": 3,
                "allow_expect_time": 60,
                "allow_revoke_time": 5,
                "area_code": "500000",
                "camera_info": "火眼",
                "carport_space": 3,
                "carport_total": 3,
                "carport_yet": 0,
                "copy_linkman_name": "xxx",
                "copy_linkman_tel": "15802854903",
                "ctime": 1494842112000,
                "department": "重庆飞机场",
                "enter_camera_num": 1,
                "enter_num": 1,
                "exit_camera_num": 1,
                "exit_num": 1,
                "expect_car_num": 0,
                "expect_money": 0,
                "hardware_type": 0,
                "hlc_enter_num": 1,
                "hlc_exit_num": 1,
                "is_expect": 0,
                "is_fault": 1,
                "is_rent": 0,
                "lat": 29.609594,
                "linkman_name": "xxx",
                "linkman_tel": "15802854903",
                "lng": 106.551166,
                "loginname": "",
                "mac": "",
                "money": 100,
                "month_price": 0,
                "moth_car_num": 2,
                "moth_car_num_space": 2,
                "note": "",
                "park_type": 0,
                "password": "",
                "pda_permit_time": "",
                "pi_id": 67,
                "pi_name": "重庆飞机场",
                "pi_phone": "15802854903",
                "pi_state": 1,
                "pu_id": 0,
                "pu_nd": "",
                "rent_info": "",
                "roadside_type": 0,
                "special_ip": "",
                "time_car_num": 0,
                "time_car_num_space": 0,
                "timeout_info": "首停2.00小时1.00元，之后每小时1.00元",
                "token": "",
                "upload_source": 0,
                "utime": 1494844051000
            }
        },
        "errorcode": "",
        "errormsg": "根据硬件设备mac地址获取停车场信息成功",
        "errorno": "0"
    }
#########返回字段park_info说明
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
|special_ip|道闸专线静态IP|String|
|token|授权token|String|
|hardware_type|具有哪些硬件类型（0：未知1：地磁2：地磁+蓝牙车位）|int|

#########返回字段park_hardware_info说明
|名称|描述|类型|
|----|----|---|
|ph_id|主键ID|long|
|pi_id|停车场主键ID|long|
|area_code|地址区域编码|String|
|type|硬件设备类型(0:未知1：PDA设备2：地磁设备（抽象android板子）3：蓝牙车位锁)|int|
|ph_mac|硬件设备MAC地址|String|
|ph_licence|硬件设备串号|String|
|park_type|停车场类型（0：道闸1：占道2：立体车库）|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|ph_loginname|硬件设备登录帐号|String|
|ph_password|硬件设备登录密码|String|
|ph_state|硬件设备状态（0：正常1：异常）|int|
|note|备注|String|
|token|授权tokon|String|




####1.6->地磁逻辑删除地磁和政府编码对应关系

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id|停车场主键ID| 否| 无 |长整型|
| area_code| 地址编码| 否| 无 |字符串|
| gov_num| 政府拟定的车位编码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+area_code+gov_num)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/delete_magnetic_device.php](http://139.224.29.103/v1/delete_magnetic_device.php)

######返回结果
    {
        "data": "",
        "errorcode": "",
        "errormsg": "设备编号删除成功",
        "errorno": "0"
    }