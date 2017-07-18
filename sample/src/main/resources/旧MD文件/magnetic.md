###地磁管理模块

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
