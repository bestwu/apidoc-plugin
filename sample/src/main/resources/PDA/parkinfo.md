###PDA ：： 1.车库管理模块
#####测试的时候前缀：http://139.224.29.103:8091


####1.1->车辆入库出库记录

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| pd_id| 出入口设备主键ID | 否| 无 |长整型|
| car_code| 车牌号码 | 否| 无 |字符串|
| is_enter| 入库或者出库 ：0：   入库   1：出库 | 否| 无 |整型|
| in_out| 出口或者入口 入口：enter  出口：exit | 否| 无 |字符串|
| in_out_code| 出入口编号 A /B/C| 否| 无 |字符串|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌 | 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 否| 无 |整型|
| area_code| 省市县编号 510122 | 是| 无 |字符串|
| out_type|入库/出库类型: (0:正常出入库 ~~1：道闸本地临停出入库~~ 2：道闸本地包月出入库   3：异常出入库   4：道闸本地免费车出入库) 5:预约车辆出入库  6:租赁车辆出入库| 否| 无 |整型|
| is_local_month|是否在服务器创建订单  0:创建   1：不创建| 否| 无 |整型|
| sync_time|(异步上传)离线端入库时间或者出库时间  13位毫秒数| 是| 无 |长整型|
| is_sync|(异步上传)如果是异步上传  is_sync=1 | 是| 无 |整型|
| order_id|服务器端订单ID | 是| 无 |字符串|
| gov_num|智能磁场车位编号（政府部门统一分配）| 是| 无 |字符串|
| sign| MD5数字签名(dtype+pi_id+in_out)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######<font color=#00ffff size=72>注意事项</font>
######<font color=#00ffff size=5>新增异常数据上传控制参数is_sync和本地离线时间sync_time</font>
######<font color=#ff0000 size=4>~~新增异常数据上传控制参数order_id 只是在出库的时候传递~~</font>
######<font color=#00ffff size=5>订单号order_id 客户端在入库、出库的时候都需要进行传递</font>
####新增地磁场车位编号：gov_num
######<font color=#ff0000 size=5>gov_num：智能磁场车位编号（政府部门统一分配） 该参数只用于占道停车，地磁车场</font>
####请求路径

[http://139.224.29.103/v1/record_car_in_out.php](http://139.224.29.103/v1/record_car_in_out.php)

######返回结果

    {
        "data": {
            "car_code": "川A4M99B",
            "cio_id": 1,
            "ctime": 1470297823327,
            "in_out": "enter",
            "in_out_code": "A",
            "is_enter": 0,
            "note": "",
            "pd_id": 1,
            "pi_id": 1,
            "ui_id": 1,
            "utime": 1470297823327，
            "order_id":"20160902812345"，
            "is_rent":1 是否是租赁车辆 0:不是 1：是,
            "out_type":0 出库类型 0:正常出库 1：现金支付出库 2：异常出库 3:包月出库,
            "rent_remain_time":1470297823327 租赁车辆距离结束时间还有多少时长（单位毫秒）,
            "is_local_month":0 是否是道闸本地包月车辆 0:不是 1：是
        },
         "errormsg": "查询附近的停车场信息成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|cio_id|主键ID|long|
|pi_id|场地车库主键ID|long|
|pd_id|出入口设备主键ID|long|
|ui_id|用户ID|long|
|car_code|车牌号|String|
|is_enter|入库或者出库：0：入库1：出库|int|
|in_out|出口或者入口入口：enter出口：exit|String|
|in_out_code|出入口编号A/B/C|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|area_code|省市县编号|String|
|note|备注|String|
|car_type|车牌类型:车牌类型0：未知车牌:、1：蓝牌小汽车、2：:黑牌小汽车、3：单排黄牌、4：双排黄牌、5：警车车牌、6：武警车牌、7：个性化车牌、8：单排军车牌、9：双排军车牌、10：使馆车牌、11：香港进出中国大陆车牌、12：农用车牌、13：教练车牌、14：澳门进出中国大陆车牌、15：双层武警车牌、16：武警总队车牌、17：双层武警总队车牌|int|
|car_code_color|车牌颜色0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色|int|
|order_id|订单编号|String|
|out_type|入库/出库类型:(0:正常出入库1：道闸本地临停出入库2：道闸本地包月出入库3：异常出入库)4:异步数据上传出入库（网络异常）|int|
|is_rent|是否是租赁车辆0:不是1：是|int|
|rent_remain_time|租赁车辆距离结束时间还有多少时长（单位毫秒）|long|
|is_local_month|是否是道闸本地包月车辆0:不是1：是|int|
|ui_nd|用户唯一标识uuid|String|
|ui_tel|用户电话号码|String|


####1.1.2->车辆入库出库记录(NEW)

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| pd_id| 出入口设备主键ID | 否| 无 |长整型|
| car_code| 车牌号码 | 否| 无 |字符串|
| is_enter| 入库或者出库 ：0：   入库   1：出库 | 否| 无 |整型|
| in_out| 出口或者入口 入口：enter  出口：exit | 否| 无 |字符串|
| in_out_code| 出入口编号 A /B/C| 否| 无 |字符串|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌 | 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 否| 无 |整型|
| area_code| 省市县编号 510122 | 是| 无 |字符串|
| out_type|入库/出库类型: (0:正常出入库 ~~1：道闸本地临停出入库~~ 2：道闸本地包月出入库   3：异常出入库   4：道闸本地免费车出入库) 5:预约车辆出入库  6:租赁车辆出入库| 否| 无 |整型|
| is_sync|(异步上传)如果是异步上传  is_sync=1 | 是| 无 |整型|
| order_id|服务器端订单ID | 是| 无 |字符串|
| gov_num|智能磁场车位编号（政府部门统一分配）| 是| 无 |字符串|
| tarde_type|1:预约  2：临停   3：租赁   4：  本地免费    5：本地包月| 是| 无 |整型|
| create_time|停车场车辆入库出库的本地时间 13位毫秒数| 否| 无 |长整型|
| sign| MD5数字签名(dtype+pi_id+in_out+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######<font color=#00ffff size=72>注意事项</font>
######<font color=#00ffff size=5>异常数据上传控制参数is_sync</font>
######<font color=#00ffff size=5>订单号order_id 客户端在入库、出库的时候都需要进行传递</font>
####地磁场车位编号：gov_num
######<font color=#ff0000 size=5>gov_num：智能磁场车位编号（政府部门统一分配） 该参数只用于占道停车，地磁车场</font>
####请求路径

[http://139.224.29.103/v1/carinout.php](http://139.224.29.103/v1/carinout.php)

######返回结果
{
    "data": {
        "area_code": "510107",
        "car_code": "沪F00001",
        "car_code_color": 1,
        "car_type": 1,
        "cio_id": 73717,
        "ctime": 1495865757449,
        "gov_num": "000000000000001",
        "in_out": "enter",
        "in_out_code": "A",
        "is_enter": 0,
        "is_local_month": 0,
        "is_rent": 0,
        "is_sync": 0,
        "note": "",
        "order_id": "2017052714161247725",
        "out_type": 0,
        "pd_id": 1,
        "pi_id": 36,
        "rent_remain_time": 0,
        "ui_id": 0,
        "ui_nd": "",
        "ui_tel": "",
        "utime": 1495865757449
    },
    "errorcode": "",
    "errorno": "0"
}
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|cio_id|主键ID|long|
|pi_id|场地车库主键ID|long|
|pd_id|出入口设备主键ID|long|
|ui_id|用户ID|long|
|car_code|车牌号|String|
|is_enter|入库或者出库：0：入库1：出库|int|
|in_out|出口或者入口入口：enter出口：exit|String|
|in_out_code|出入口编号A/B/C|String|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|area_code|省市县编号|String|
|note|备注|String|
|car_type|车牌类型:车牌类型0：未知车牌:、1：蓝牌小汽车、2：:黑牌小汽车、3：单排黄牌、4：双排黄牌、5：警车车牌、6：武警车牌、7：个性化车牌、8：单排军车牌、9：双排军车牌、10：使馆车牌、11：香港进出中国大陆车牌、12：农用车牌、13：教练车牌、14：澳门进出中国大陆车牌、15：双层武警车牌、16：武警总队车牌、17：双层武警总队车牌|int|
|car_code_color|车牌颜色0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色|int|
|order_id|订单编号|String|
|out_type|入库/出库类型:(0:正常出入库1：道闸本地临停出入库2：道闸本地包月出入库3：异常出入库)4:异步数据上传出入库（网络异常）|int|
|is_rent|是否是租赁车辆0:不是1：是|int|
|rent_remain_time|租赁车辆距离结束时间还有多少时长（单位毫秒）|long|
|is_local_month|是否是道闸本地包月车辆0:不是1：是|int|
|ui_nd|用户唯一标识uuid|String|
|ui_tel|用户电话号码|String|
|is_sync|是否是网络异常导致的数据上传：0不是1：是|int|
|gov_num|地磁停车场车位编号（政府部门统一分配）|String|
|stime|服务器端接收数据创建时间|java.util.Date|


####1.2->读取停车场详情

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




####1.3->登记停车场信息

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| name| 场地名称 | 否| 无 |字符串|
| address_name| 停车场地理街道名称 | 否| 无 |字符串|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| linkman_name| 场地联系人姓名 | 否| 无 |字符串|
| linkman_tel| 联系人电话 | 否| 无 |字符串|
| copy_linkman_name| 备用联系人姓名 | 否| 无 |字符串|
| copy_linkman_tel| 备用联系人手机 | 否| 无 |字符串|
| pi_phone| 场地座机号码 | 否| 无 |字符串|
| department| 负责单位 | 否| 无 |字符串|
| enter_num| 场地入口数量| 否| 无 |整型|
| exit_num| 场地出口数量| 否| 无 |整型|
| hlc_enter_num| 场地入口道闸数量| 否| 无 |整型|
| hlc_exit_num| 场地出口道闸数量| 否| 无 |整型|
| enter_camera_num| 场地入口摄像头数量| 否| 无 |整型|
| exit_camera_num| 场地出口摄像头数量| 否| 无 |整型|
| camera_info| 场地摄像头信息 例如：罗技Pro C920| 否| 无 |字符串|
| park_type| 停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场 | 否| 无 |整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| is_expect| 是否开启预约 0:不开启 1：开启| 否| 无 |整型|
| expect_money| 每小时预约费用（单位分）| 否| 无 |整型|
| allow_revoke_time| 允许预约撤单时间(单位分钟)| 否| 无 |整型|
| allow_expect_time| 允许预约时间最大时长(单位分钟)| 否| 无 |整型|
| carport_total| 临停车位总数| 否| 无 |整型|
| moth_car_num| 租赁离线包月车位总个数| 否| 无 |整型|
| carport_yet| 临停已停车位| 是| 无 |整型|
| carport_space| 临停空车位个数| 是| 无 |整型|
| moth_car_num_space| 租赁离线剩余车位数| 是| 无 |整型|
| time_car_num| 时间段包月车位总数| 是| 无 |整型|
| time_car_num_space|时间段包月车位剩余个数| 是| 无 |整型|
| upload_source|上传数据来源 0:离线道闸上传 1：中心管理后台录入  2：Android市场人员跑动录入| 是| 无 |整型|
| admin_id|上传数据后台管理账户ID| 是| 无 |整型|
| roadside_type|占道停车是否按次数收费 0:按时间收费 1：按次数收费| 是| 无 |整型|
| sign| MD5数字签名(dtype+park_type)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/record_parkinfo.php](http://139.224.29.103/v1/record_parkinfo.php)

######返回结果
    {
        "data":  {
        "address_name": "成都市天华路88号",
        "admin_id": 0,
        "allow_expect_time": 60,
        "allow_revoke_time": 5,
        "area_code": "510107",
        "camera_info": "火眼",
        "carport_space": 2,
        "carport_total": 4,
        "carport_yet": 1,
        "copy_linkman_name": "xxx",
        "copy_linkman_tel": "15808549031",
        "ctime": 1482818406000,
        "department": "英郡二期",
        "enter_camera_num": 1,
        "enter_num": 1,
        "exit_camera_num": 1,
        "exit_num": 1,
        "expect_car_num": 1,
        "expect_money": 20,
        "hlc_enter_num": 1,
        "hlc_exit_num": 1,
        "is_expect": 1,
        "is_fault": 0,
        "is_rent": 1,
        "lat": 30.547829,
        "linkman_name": "xxx",
        "linkman_tel": "15808549031",
        "lng": 104.072388,
        "loginname": "",
        "mac": "",
        "money": 2,
        "month_price": 3,
        "moth_car_num": 2,
        "moth_car_num_space": 2,
        "note": "99999999999",
        "park_type": 0,
        "password": "",
        "pi_id": 1,
        "pi_name": "英郡二期",
        "pi_phone": "15808549031",
        "pi_state": 1,
        "pu_id": 1,
        "pu_nd": "20161227141900",
        "rent_info": "准入时段 14:17-22:12，0.03元/月",
        "roadside_type": 0,
        "time_car_num": 2,
        "time_car_num_space": 1,
        "timeout_info": "首停2.0小时0.02元，之后每小时0.01元",
        "upload_source": 0,
        "utime": 1482890628000
    },
        "errormsg": "成功",
        "errorno": "0"
    }
####错误编号解析
|错误编号 errorcode|是否有结构数据|参数类型 data|描述|
|--------|----|------|-------|
| 1| 有| JSONOBJET| 与正确的返回结果中的DATA值一样 即停车场BEAN对象|
######返回错误结果
    {
        "data":  {
        "address_name": "成都市天华路88号",
        "admin_id": 0,
        "allow_expect_time": 60,
        "allow_revoke_time": 5,
        "area_code": "510107",
        "camera_info": "火眼",
        "carport_space": 2,
        "carport_total": 4,
        "carport_yet": 1,
        "copy_linkman_name": "xxx",
        "copy_linkman_tel": "15808549031",
        "ctime": 1482818406000,
        "department": "英郡二期",
        "enter_camera_num": 1,
        "enter_num": 1,
        "exit_camera_num": 1,
        "exit_num": 1,
        "expect_car_num": 1,
        "expect_money": 20,
        "hlc_enter_num": 1,
        "hlc_exit_num": 1,
        "is_expect": 1,
        "is_fault": 0,
        "is_rent": 1,
        "lat": 30.547829,
        "linkman_name": "xxx",
        "linkman_tel": "15808549031",
        "lng": 104.072388,
        "loginname": "",
        "mac": "",
        "money": 2,
        "month_price": 3,
        "moth_car_num": 2,
        "moth_car_num_space": 2,
        "note": "99999999999",
        "park_type": 0,
        "password": "",
        "pi_id": 1,
        "pi_name": "英郡二期",
        "pi_phone": "15808549031",
        "pi_state": 1,
        "pu_id": 1,
        "pu_nd": "20161227141900",
        "rent_info": "准入时段 14:17-22:12，0.03元/月",
        "roadside_type": 0,
        "time_car_num": 2,
        "time_car_num_space": 1,
        "timeout_info": "首停2.0小时0.02元，之后每小时0.01元",
        "upload_source": 0,
        "utime": 1482890628000，
        "roadside_type":0
    },
        "errorcode": "1",
        "errormsg": "该停车场已经录入过了",
        "errorno": "1002"
    }

#########返回字段说明
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








####~~1.4->更新停车场信息~~

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 场地主键ID| 否| 无 |长整型|
| name| 场地名称 | 否| 无 |字符串|
| address_name| 停车场地理街道名称 | 否| 无 |字符串|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| linkman_name| 场地联系人姓名 | 否| 无 |字符串|
| linkman_tel| 联系人电话 | 否| 无 |字符串|
| copy_linkman_name| 备用联系人姓名 | 否| 无 |字符串|
| copy_linkman_tel| 备用联系人手机 | 否| 无 |字符串|
| pi_phone| 场地座机号码 | 否| 无 |字符串|
| department| 负责单位 | 否| 无 |字符串|
| enter_num| 场地入口数量| 否| 无 |整型|
| exit_num| 场地出口数量| 否| 无 |整型|
| hlc_enter_num| 场地入口道闸数量| 否| 无 |整型|
| hlc_exit_num| 场地出口道闸数量| 否| 无 |整型|
| enter_camera_num| 场地入口摄像头数量| 否| 无 |整型|
| exit_camera_num| 场地出口摄像头数量| 否| 无 |整型|
| camera_info| 场地摄像头信息 例如：罗技Pro C920| 否| 无 |字符串|
| park_type| 停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场 | 否| 无 |整型|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| is_expect| 是否开启预约 0:不开启 1：开启| 否| 无 |整型|
| expect_money| 每小时预约费用（单位分）| 否| 无 |整型|
| allow_revoke_time| 允许预约撤单时间(单位分钟)| 否| 无 |整型|
| allow_expect_time| 允许预约时间最大时长(单位分钟)| 否| 无 |整型|
| carport_total| 临停车位总数| 否| 无 |整型|
| moth_car_num| 租赁离线包月车位总个数| 否| 无 |整型|
| carport_yet| 临停已停车位| 是| 无 |整型|
| carport_space| 临停空车位个数| 是| 无 |整型|
| moth_car_num_space| 租赁离线剩余车位数| 是| 无 |整型|
| time_car_num| 时间段包月车位总数| 是| 无 |整型|
| time_car_num_space|时间段包月车位剩余个数| 是| 无 |整型|
| upload_source|上传数据来源 0:离线道闸上传 1：中心管理后台录入  2：Android市场人员跑动录入| 是| 无 |整型|
| admin_id|上传数据后台管理账户ID| 是| 无 |整型|
| roadside_type|占道停车是否按次数收费 0:按时间收费 1：按次数收费| 是| 无 |整型|
| sign| MD5数字签名(dtype+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/update_parkinfo.php](http://139.224.29.103/v1/update_parkinfo.php)

######返回结果
    {
        "data":  {
        "address_name": "成都市天华路88号",
        "admin_id": 0,
        "allow_expect_time": 60,
        "allow_revoke_time": 5,
        "area_code": "510107",
        "camera_info": "火眼",
        "carport_space": 2,
        "carport_total": 4,
        "carport_yet": 1,
        "copy_linkman_name": "xxx",
        "copy_linkman_tel": "15808549031",
        "ctime": 1482818406000,
        "department": "英郡二期",
        "enter_camera_num": 1,
        "enter_num": 1,
        "exit_camera_num": 1,
        "exit_num": 1,
        "expect_car_num": 1,
        "expect_money": 20,
        "hlc_enter_num": 1,
        "hlc_exit_num": 1,
        "is_expect": 1,
        "is_fault": 0,
        "is_rent": 1,
        "lat": 30.547829,
        "linkman_name": "xxx",
        "linkman_tel": "15808549031",
        "lng": 104.072388,
        "loginname": "",
        "mac": "",
        "money": 2,
        "month_price": 3,
        "moth_car_num": 2,
        "moth_car_num_space": 2,
        "note": "99999999999",
        "park_type": 0,
        "password": "",
        "pi_id": 1,
        "pi_name": "英郡二期",
        "pi_phone": "15808549031",
        "pi_state": 1,
        "pu_id": 1,
        "pu_nd": "20161227141900",
        "rent_info": "准入时段 14:17-22:12，0.03元/月",
        "roadside_type": 0,
        "time_car_num": 2,
        "time_car_num_space": 1,
        "timeout_info": "首停2.0小时0.02元，之后每小时0.01元",
        "upload_source": 0,
        "utime": 1482890628000,
        "roadside_type":0
    },
        "errormsg": "成功",
        "errorno": "0"
    }
#########返回字段说明
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







####1.5->~~记录停车场计费规则信息~~

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| start_price| 起步价（RMB 单位 分） | 否| 无 |整型|
| start_time| 起步价量纲时长（单位 分钟） | 否| 无 |整型|
| charging| 计费价(RMB  单位分)| 否| 无 |整型|
| charging_time| 计费量纲时长（单位 分钟） | 否| 无 |整型|
| month_price| 包月价格(单位分) | 否| 无 |整型|
| month_time| 包月时长(天) | 否| 无 |整型|
| permit_time| 准入时间段17:00-08:30 | 否| 无 |字符串|
| timeout_info| 超时费率(首停2小时3元，之后1元/小时) | 否| 无 |字符串|
| rcr_type| 停车类型 0：普通车位停车 1：时间段包月停车 | 否| 无 |整型|
| rcr_state| 是否有效  0：有效 1：无效 | 否| 无 |整型|
| rcr_discount| 是否可以使用优费券 : 0： 可以使用 1：无法使用 | 否| 无 |整型|
| car_displacement| 车辆排量| 否| 无 |字符串|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌| 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 否| 无 |整型|
| is_time_bucket| 是否按时间段收费 0:不按时间段收费 1：按时间段收费| 否| 无 |整型|
| time_bucket| 时间段收费  例如：白天 9：00-12：00 每小时2元| 否| 无 |字符串|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| roadside_type|占道停车是否按次数收费 0:按时间收费 1：按次数收费| 是| 无 |整型|
| sign| MD5数字签名(dtype+pi_id+start_price+charging)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/charging_rule.php](http://139.224.29.103/v1/charging_rule.php)

######返回结果
    {
        "data": {
            "car_code_color": 0,
            "car_displacement": "1.6T",
            "car_type": 2,
            "charging": 120,
            "charging_time": 60,
            "ctime": 1470905801464,
            "is_default": 0,
            "is_time_bucket": 0,
            "month_price": 15000,
            "month_time": 30,
            "note": "",
            "permit_time": "17:00-08:30",
            "pi_id": 1,
            "rcr_discount": 0,
            "rcr_id": 3,
            "rcr_md5": "",
            "rcr_state": 0,
            "rcr_type": 1,
            "start_price": 500,
            "start_time": 180,
            "time_bucket": "白天 9：00-12：00 每小时2元",
            "timeout_info": "首停2小时3元，之后1元/小时",
            "utime": 1470905801464,
            "roadside_type":0
        },
        "errormsg": "成功",
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




####1.6->~~更新停车场规则~~

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| rcr_id| 规则表主键ID | 否| 无 |长整型|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| start_price| 起步价（RMB 单位 分） | 否| 无 |整型|
| start_time| 起步价量纲时长（单位 分钟） | 否| 无 |整型|
| charging| 计费价(RMB  单位分)| 否| 无 |整型|
| charging_time| 计费量纲时长（单位 分钟） | 否| 无 |整型|
| month_price| 包月价格(单位分) | 否| 无 |整型|
| month_time| 包月时长(天) | 否| 无 |整型|
| permit_time| 准入时间段17:00-08:30 | 否| 无 |字符串|
| timeout_info| 超时费率(首停2小时3元，之后1元/小时) | 否| 无 |字符串|
| rcr_type| 停车类型 0：普通车位停车 1：时间段包月停车 | 否| 无 |整型|
| rcr_state| 是否有效  0：有效 1：无效 | 否| 无 |整型|
| rcr_discount| 是否可以使用优费券 : 0： 可以使用 1：无法使用 | 否| 无 |整型|
| car_displacement| 车辆排量| 否| 无 |字符串|
| car_type| 车牌类型:车牌类型 0：未知车牌:、1：蓝牌小汽车、2：: 黑牌小汽车、3：单排黄牌、4：双排黄牌、 5： 警车车牌、6：武警车牌、7：个性化车牌、8：单 排军车牌、9：双排军车牌、10：使馆车牌、11： 香港进出中国大陆车牌、12：农用车牌、13：教 练车牌、14：澳门进出中国大陆车牌、15：双层 武警车牌、16：武警总队车牌、17：双层武警总 队车牌| 否| 无 |整型|
| car_code_color| 车牌颜色 0：未知、1：蓝色、2：黄色、3：白色、 4：黑色、5：绿色| 否| 无 |整型|
| is_time_bucket| 是否按时间段收费 0:不按时间段收费 1：按时间段收费| 否| 无 |整型|
| time_bucket| 时间段收费  例如：白天 9：00-12：00 每小时2元| 否| 无 |字符串|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| roadside_type|占道停车是否按次数收费 0:按时间收费 1：按次数收费| 是| 无 |整型|
| sign| MD5数字签名(dtype+rcr_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/update_charging_rule.php](http://139.224.29.103/v1/update_charging_rule.php)

######返回结果
    {
        "data": {
            "car_code_color": 0,
            "car_displacement": "1.6T",
            "car_type": 2,
            "charging": 120,
            "charging_time": 60,
            "ctime": 1470906401069,
            "is_default": 0,
            "is_time_bucket": 0,
            "month_price": 15000,
            "month_time": 30,
            "note": "",
            "permit_time": "16:00-08:30",
            "pi_id": 1,
            "rcr_discount": 0,
            "rcr_id": 3,
            "rcr_md5": "6ef6ea500379f138f8c753bf9b9758ee",
            "rcr_state": 0,
            "rcr_type": 1,
            "start_price": 500,
            "start_time": 180,
            "time_bucket": "白天 9：00-12：00 每小时2元",
            "timeout_info": "首停2小时3元，之后1元/小时",
            "utime": 1470906401069,
            "roadside_type":0
        },
        "errormsg": "更新成功",
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





####1.7->停车场心跳记录

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| pi_id| 停车场主键ID | 否| 无 |长整型|
| is_rent| 是否有租赁包月业务 0：没有 1：有 | 否| 无 |整型|
| carport_total| 临停车位总数| 否| 无 |整型|
| moth_car_num| 租赁离线包月车位总个数| 否| 无 |整型|
| carport_yet| 临停已停车位| 是| 无 |整型|
| carport_space| 临停空车位个数| 是| 无 |整型|
| moth_car_num_space| 租赁离线剩余车位数| 是| 无 |整型|
| time_car_num| 时间段包月车位总数| 是| 无 |整型|
| time_car_num_space|时间段包月车位剩余个数| 是| 无 |整型|
| expect_car_num| 已预约车辆数| 是| 无 |整型|
| area_code| 省市县编号 510122 | 是| 无 |字符串|
| time| 上次心跳时间| 否| 无 |长整型|
| park_type| 停车场类型 0：地下室停车场 1：露天停车场 2：露天立体车库停车场| 否| 无 |整型|
| sign| MD5数字签名(dtype+pi_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/park_heartbeat.php](http://139.224.29.103/v1/park_heartbeat.php)

######返回结果
    {
        "data": {
            "park_info": {停车场基本信息}，
            "time":1470000000000 时间毫秒数,
            "expect":"[{
            "address_name": "",
            "allege_state": 0,allege_stateallege_state
            "area_code": "510112",
            "arrive_time": 1470972770073,
            "cancel_state": 0,
            "car_code": "辽JQQ360",
            "charging": 0,
            "charging_time": 0,
            "ctime": 1470972770073,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "",
            "expect_money": 500,
            "expect_time": 120,
            "final_time": 0,
            "id": 0,
            "is_del": 0,
            "is_expect_deduct": 0,
            "is_expect_outtime": 0,
            "leave_time": 1470972770073,
            "money": 0,
            "my_order": "8a1ace9c0a9fc18de521470972770074",
            "note": "用户预约下单",
            "order_type": 0,下单类型 0: 普通下单  1：预约下单 2：租赁包月订单
            "other_order": "",
            "pay_source": 0,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 1,
            "pp_state": 0,
            "pp_versioncode": "1",
            "start_price": 0,
            "start_time": 0,
            "ui_id": 1,
            "upc_id": 0,
            "utime": 1470972770073,
            "lat": 30.649776,
			"lng": 104.069133
        }]",预约
            "cancel_expect":"[{
            "address_name": "",
            "allege_state": 0,allege_stateallege_state
            "area_code": "510112",
            "arrive_time": 1470972770073,
            "cancel_state": 0,
            "car_code": "辽JQQ360",
            "charging": 0,
            "charging_time": 0,
            "ctime": 1470972770073,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "",
            "expect_money": 500,
            "expect_time": 120,
            "final_time": 0,
            "id": 0,
            "is_del": 0,
            "is_expect_deduct": 0,
            "is_expect_outtime": 0,
            "leave_time": 1470972770073,
            "money": 0,
            "my_order": "8a1ace9c0a9fc18de521470972770074",
            "note": "用户预约下单",
            "order_type": 0,下单类型 0: 普通下单  1：预约下单 2：租赁包月订单
            "other_order": "",
            "pay_source": 0,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 1,
            "pp_state": 0,
            "pp_versioncode": "1",
            "start_price": 0,
            "start_time": 0,
            "ui_id": 1,
            "upc_id": 0,
            "utime": 1470972770073,
            "lat": 30.649776,
			"lng": 104.069133
        }]",取消预约
            "rent":"[{
            "address_name": "成都市天华路88号",
            "allege_state": 0,
            "area_code": "510107",
            "arrive_time": 1482980102000,
            "base_rate": "",
            "cancel_state": 0,
            "car_code": "川A42575",
            "ctime": 1482980102000,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "end_time": 1485658502000,
            "final_time": 0,
            "id": 4,
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
            "my_order": "2016122910552389",
            "note": "用户租赁下单",
            "open_time": 1482980102000,
            "order_type": 2,
            "other_order": "",
            "outtime_charge_minute": 0,
            "outtime_charge_money": 0,
            "outtime_minute": 0,
            "outtime_money": 0,
            "outtime_other_order": "",
            "outtime_paystate": 0,
            "outtime_paytime": 1482980102000,
            "outtime_rate": "",
            "outtime_start_minute": 0,
            "outtime_start_price": 0,
            "outtime_time": 1482980102000,
            "park_type": 0,
            "pay_source": 4,
            "pay_type": 0,
            "permit_time": "14:17-22:12",
            "phone_type": 0,
            "pi_id": 1,
            "pi_name": "英郡二期",
            "pp_state": 0,
            "pp_versioncode": "1",
            "pu_id": 1,
            "pu_nd": "20161227141900",
            "scan_time": 1482980102000,
            "start_time": 1482980102000,
            "temp_money": 0,
            "ui_id": 51,
            "upc_id": 0,
            "utime": 1482980102000
        }]"租赁
        },
        "errorcode": "",
        "errormsg": "停车场心跳发送成功",
        "errorno": "0"
    }
#########普通订单---返回字段说明
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
|cancel_state|用户取消下单状态0:没有取消1：取消|int|
|is_open|是否开闸0:未开闸1：已开闸|int|
|open_time|开闸时间|java.util.Date|
|is_cash|是否现金支付0：在线支付1：现金支付|int|
|park_type|停车场类型0：道闸停车场1：占道车场2：露天立体车库停车场|int|
|scan_time|是否可以停车缴费时间（摄像头是否扫描到了：仅限道闸停车使用）|java.util.Date|
|pi_name|停车场名称|String|
|is_over|订单是否完成(0:没有完成1：完成)|int|
|free_minute|多少分钟之内进出免费|int|
|is_free_minute|多少分钟之内进出免费是否开启0:不开启1：开启|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|expect_state|预约状态1：预约中2：预约成功3：预约失败4：取消预约成功5：取消预约失败|int|

#########租赁订单----返回字段说明
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
|is_over|订单是否完成(0:没有完成1：完成)|int|
|cancel_state|用户取消下单状态0:没有取消1：取消|int|
|pu_id|商户主键ID|long|
|pu_nd|商户编号|String|
|lng|场地经度|double|
|lat|场地纬度|double|
|is_expire|是否已到期（0：没有到期1：已经到期）|int|
|rent_state|租赁状态1：租赁中2：租赁成功3：租赁失败--解绑租赁金额|int|





####1.8->露天停车场PDA帐号信息和经纬度 MAC 的初始化

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| lng| 场地经度 | 否| 无 |双精度浮点型|
| lat| 场地纬度 | 否| 无 |双精度浮点型|
| park_type| 停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场 | 否| 无 |整型|
| mac| pda的物理地址| 是| 无 |字符串|
| loginname| 露天停车场的分配的帐号| 否| 无 |字符串|
| password| 露天停车场的密码| 否| 无 |字符串|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+park_type+loginname+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/init_pda.php](http://139.224.29.103/v1/init_pda.php)

######返回结果
    {
        "data": {
            "address_name": "天府三街地铁A出口",
            "allow_expect_time": 60,
            "allow_revoke_time": 0,
            "area_code": "510112",
            "camera_info": "罗技Pro C920",
            "carport_space": 89,
            "carport_total": 100,
            "carport_yet": 11,
            "copy_linkman_name": "张小强",
            "copy_linkman_tel": "15882345447",
            "ctime": 1470296969000,
            "department": "四川乐库斯",
            "enter_camera_num": 1,
            "enter_num": 1,
            "exit_camera_num": 1,
            "exit_num": 1,
            "expect_money": 5,
            "hlc_enter_num": 1,
            "hlc_exit_num": 1,
            "is_expect": 0,
            "is_rent": 1,
            "lat": 30.547776,
            "linkman_name": "敬小虎",
            "linkman_tel": "15882345446",
            "lng": 104.067138,
            "loginname": "9527000",
            "mac": "A0-B2-3C-9B-FF,A0-B2-3C-9B-FF",
            "money": 0,
            "month_price": 30000,
            "moth_car_num": 0,
            "note": "",
            "park_type": 1,停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场
            "password": "e10adc3949ba59abbe56e057f20f883e",
            "pi_id": 1,
            "pi_name": "四川乐库斯",
            "pi_phone": "028-85960236",
            "rent_info": "准入时段 17:00-08:30，150元/月",
            "time_car_num": 0,
            "timeout_info": "首停3小时5元，之后每小时1元",
            "utime": 1473825495957,
            "roadside_type":"0" 占道停车是否按次数收费 0:按时间收费 1：按次数收费
        },
        "errorcode": "",
        "errormsg": "初始化成功",
        "errorno": "0"
    }
########返回结果的错误信息情况：
|参数|错误代码|类型|错误描述|
|----|----|---|---|
|errorcode|1|字符串|该设备已经被其它停车场绑定过了|
|errorcode|2|字符串|PDA 物理地址不匹配|



####1.9->用户重置PDA密码

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| verify_code| 用户验证码 | 否| 无 |字符串|
| verify_list| 由发送验证码接口或者重新发送验证码接口返回的verify_list参数的值 | 否| 无 |字符串|
| vclass| 固定参数：1：注册 2：重置密码 | 否| 无 |字符串|
| park_type| 停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场| 否| 无 |整型|
| tel| 露天停车场负责人手机号码| 是| 无 |字符串|
| loginname| 露天停车场的分配的帐号| 否| 无 |字符串|
| password| 露天停车场的密码| 否| 无 |字符串|
| repassword| 露天停车场的确认密码| 否| 无 |字符串|
| area_code| 省市县编号 510122 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+park_type+loginname+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/change_pass_pda.php](http://139.224.29.103/v1/change_pass_pda.php)

######返回结果
    {
        "data": {
            "address_name": "天府三街地铁A出口",
            "allow_expect_time": 60,
            "allow_revoke_time": 0,
            "area_code": "510112",
            "camera_info": "罗技Pro C920",
            "carport_space": 89,
            "carport_total": 100,
            "carport_yet": 11,
            "copy_linkman_name": "张小强",
            "copy_linkman_tel": "15882345447",
            "ctime": 1470296969000,
            "department": "四川乐库斯",
            "enter_camera_num": 1,
            "enter_num": 1,
            "exit_camera_num": 1,
            "exit_num": 1,
            "expect_money": 5,
            "hlc_enter_num": 1,
            "hlc_exit_num": 1,
            "is_expect": 0,
            "is_rent": 1,
            "lat": 30.547776,
            "linkman_name": "敬小虎",
            "linkman_tel": "15882345446",
            "lng": 104.067138,
            "loginname": "9527000",
            "mac": "A0-B2-3C-9B-FF,A0-B2-3C-9B-FF",
            "money": 0,
            "month_price": 30000,
            "moth_car_num": 0,
            "note": "",
            "park_type": 1,停车场类型 0：道闸停车场 1：占道车场 2：露天立体车库停车场
            "password": "670b14728ad9902aecba32e22fa4f6bd",
            "pi_id": 1,
            "pi_name": "四川乐库斯",
            "pi_phone": "028-85960236",
            "rent_info": "准入时段 17:00-08:30，150元/月",
            "time_car_num": 0,
            "timeout_info": "首停3小时5元，之后每小时1元",
            "utime": 1473837476125
        },
        "errorcode": "",
        "errormsg": "重置密码成功",
        "errorno": "0"
    }


####2.0->读取停车场计费规则信息

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

