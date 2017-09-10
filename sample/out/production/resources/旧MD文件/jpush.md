###1.推送管理模块



####1.1->吾泊APP推送规则
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "当前系统已经升级到XXX版本，增加了XXX功能，修改了当前版本的BUG，为了保证您的APP稳定运行，请尽快更新",
        "title": "系统消息",
        "type": 0，
        messageJson："这里是JSON对象"
    }


|组成部分名称|数据类型|值描述|
|--------|--------|-----|
| message| 文字信息（备注广播的时候采用） |字符串|
| messageJson|自定义消息体 |JSON字符串|
| type|类型 0：普通消息（包括 手机预约下单推送 手机临停下单成功推送 手机租赁下单成功推送 出库扣款推送等）  1：PDA预约推送通知  2：租赁状态变更推送 3： 订单状态变更推送  4：PDA第三方扫描支付推送 5：优惠券系统赠送推送 6：自动支付钱包余额不足|整型|

######0：type=0 普通消息
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "当前系统已经升级到XXX版本，增加了XXX功能，修改了当前版本的BUG，为了保证您的APP稳定运行，请尽快更新",
        "title": "系统消息",
        "type": 0
    }
###	PDA推送
######1：type=1 PDA预约推送通知
    {
        "message": "这里是广播使用",
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "title": "系统消息",
        "messageJson": {
            "id": 0,
            "orderid": "201612081010",
            "type": 1,类型 1:预约下单  2：取消预约  3: 临停下单
            "car_code": "川A1111",
            "ui_id": 0
        },
        "type": 1
    }


######2：type=2 租赁状态变更推送
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "租赁状态变更推送",
        "title": "事件消息",
        "type": 2,
        "messageJson": {
             "address_name": "英郡3期",
            "allege_state": 1,
            "area_code": "510107",
            "arrive_time": 1482323727000,
            "base_rate": "",
            "cancel_state": 0,
            "car_code": "川A44555",
            "ctime": 1482323727000,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "end_time": 1485002127000,
            "final_time": 0,
            "id": 566,
            "is_24hours": 0,
            "is_cash": 0,
            "is_del": 0,
            "is_expire": 0,
            "is_open": 0,
            "is_over": 0,
            "lat": 30.550677,
            "lng": 104.073152,
            "money": 15000,
            "month_info": "每月150",
            "month_num": 1,
            "my_order": "2016122120358197",
            "note": "用户预约下单",
            "open_time": 1482323727000,
            "order_type": 2,
            "other_order": "",
            "outtime_charge_minute": 0,
            "outtime_charge_money": 0,
            "outtime_minute": 0,
            "outtime_money": 0,
            "outtime_other_order": "",
            "outtime_paystate": 0,
            "outtime_paytime": 1482323727000,
            "outtime_rate": "",
            "outtime_start_minute": 0,
            "outtime_start_price": 0,
            "outtime_time": 1482323727000,
            "park_type": 0,
            "pay_source": 4,
            "pay_type": 0,
            "permit_time": "18:00-20:00",
            "phone_type": 0,
            "pi_id": 33,
            "pi_name": "YOND测试",
            "pp_state": 1,
            "pp_versioncode": "1",
            "pu_id": 0,
            "pu_nd": "",
            "scan_time": 1482323727000,
            "start_time": 1482323727000,
            "temp_money": 0,
            "ui_id": 51,
            "upc_id": 0,
            "utime": 1482323727000
        }
    }

######3：type=3 订单状态变更推送
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "订单状态变更推送",
        "title": "事件消息",
        "type": 3,
        "messageJson": {
            "address_name": "英郡2期",
            "allege_state": 0,
            "area_code": "510107",
            "arrive_time": 1482464117000,
            "cancel_state": 0,
            "car_code": "川L9229A",
            "charging": 200,
            "charging_time": 60,
            "ctime": 1482463527000,
            "discount_money": 0,
            "discount_name": "",
            "discount_type": 0,
            "expect_info": "预约提示信息",
            "expect_money": 300,
            "expect_time": 60,
            "final_time": 0,
            "free_minute": 0,
            "id": 1166,
            "is_cash": 0,
            "is_del": 0,
            "is_expect_deduct": 1,
            "is_expect_outtime": 1,
            "is_free_minute": 0,
            "is_open": 0,
            "is_over": 0,
            "lat": 30.547761,
            "leave_time": 1482463527000,
            "lng": 104.072422,
            "money": 300,
            "my_order": "2016122311252990",
            "note": "用户预约下单",
            "open_time": 1482463527000,
            "order_type": 1,
            "other_order": "",
            "park_type": 0,
            "pay_source": 4,
            "pay_type": 0,
            "phone_type": 0,
            "pi_id": 56,
            "pi_name": "英郡二期",
            "pp_state": 1,
            "pp_versioncode": "1",
            "pu_id": 0,
            "pu_nd": "",
            "scan_time": 1482463527000,
            "start_price": 400,
            "start_time": 120,
            "ui_id": 33,
            "upc_id": 0,
            "utime": 1482463527000
        }
    }

######4：type=4  PDA第三方扫描支付推送
    {
        "message": "扫码支付",
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "title": "系统消息",
        "messageJson": {
            "id": 0,
            "orderid": "201612081010",
            "type": 3,类型 1:预约下单  2：取消预约  3: 临停下单
            "car_code": "川A1111",
            "ui_id": 0
        },
        "type": 4
    }
######5：type=5 优惠券系统赠送推送
    {
        "date": 1481596076656,
        "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
        "message": "恭喜获得2张5元吾泊代金券，1张4元龙支付专用代金券",
        "title": "系统消息",
        "type": 5
    }

######6：type=6 自动支付钱包余额不足推送
{
    "date": 1481596076656,
    "imgurl": "http://p3.qhimg.com/t011df209f8904decf8.jpg?size=1000x727",
    "message": "亲，自动支付时候，钱包余额不足，快去充钱吧",
    "title": "系统消息",
    "type": 6
}