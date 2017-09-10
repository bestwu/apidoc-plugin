###1.ETC管理模块

####1.0->获取用户绑定的ETC银行卡

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/read_etc_user.php](http://139.224.29.103/v1/read_etc_user.php)

######返回结果

    {
        "data": [
            {
                 "bank_card_number": "6228482938412183773",
                "bank_type": 0,
                "ctime": 1493362581000,
                "discard_time": 1493362581000,
                "eu_id": 6,
                "eu_nd": "2017042814562140",
                "is_default": 0,
                "is_del": 0,
                "is_sign": 0,
                "name": "王小刚",
                "note": "",
                "orderid": "2017042814567581",
                "sfz_img_url": "",
                "sfz_number": "510324198832497533",
                "sign_ip": "",
                "signtime": 1493362581000,
                "ui_id": 142,
                "ui_nd": "2017022015142561",
                "ui_tel": "15882345446",
                "utime": 1493363175811,
                "verify_sign": 0
            },
            {
                "bank_card_number": "6228482938412183773",
                "bank_type": 0,
                "ctime": 1493362581000,
                "discard_time": 1493362581000,
                "eu_id": 6,
                "eu_nd": "2017042814562140",
                "is_default": 0,
                "is_del": 0,
                "is_sign": 0,
                "name": "王小刚",
                "note": "",
                "orderid": "2017042814567581",
                "sfz_img_url": "",
                "sfz_number": "510324198832497533",
                "sign_ip": "",
                "signtime": 1493362581000,
                "ui_id": 142,
                "ui_nd": "2017022015142561",
                "ui_tel": "15882345446",
                "utime": 1493363175811,
                "verify_sign": 0
            }
        ],
        "errorcode": "",
        "errormsg": "获取用户绑定的ETC银行卡成功",
        "errorno": "0"
    }

#########返回字段Data JSONARRAY中的单个对象说明
|名称|描述|类型|
|----|----|---|
|eu_id|主键ID|long|
|eu_nd|etc用户唯一标识符|String|
|ui_id|平台用户ID|long|
|ui_nd|平台用户唯一标识符|String|
|name|ETC用户真实姓名|String|
|sfz_number|ETC用户真实身份证号码|String|
|sfz_img_url|ETC用户身份证图片|String|
|bank_card_number|ETC用户银行卡卡号|String|
|bank_type|银行类型（0：建行银行）|int|
|is_sign|是否签约成功（0：没有签约1：签约成功2：签约失败3：解除签约）|int|
|sign_ip|签约地IP|String|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|signtime|签约时间|java.util.Date|
|discard_time|解除签约时间|java.util.Date|
|note|备注|String|
|ui_tel|用户手机号码|String|
|is_default|是否是默认ETC支付卡0:不是1：是|int|
|orderid|签约验证支付订单号(user_pay表订单号)|String|
|verify_sign|是否签约支付验证成功0：未验证1：成功2：失败|int|
|is_del|是否删除0:没有1：删除|int|



####1.1->用户 ETC注册签约

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| name| ETC用户真实姓名 | 否| 无 |字符串|
| sfz_number| ETC用户真实身份证号码 | 否| 无 |字符串|
| bank_card_number| ETC用户银行卡卡号  | 否| 无 |字符串|
| bank_type| 银行类型（0：建行银行） | 是| 无 |整型|
| cardimg| 用户身份证图片文件  | 是| 无 |文件图片|
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
| sign| MD5数字签名(dtype+ui_id+sfz_number+bank_card_number)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/etc_user_reg.php](http://139.224.29.103/v1/etc_user_reg.php)

######返回结果

    {
        "data": {
            "lzf_info": {
                "utime": 1493363175679,
                "ui_nd": "2017022015142561",
                "car_order_id": "",
                "subject": "建行签约",
                "tel": "15882345446",
                "state": 0,
                "type": 5,
                "order_id": "2017042815065176",
                "pub": "9a0802790f2b22c3dc5026c3020111",
                "ctime": 1493363175679,
                "transaction_id": "",
                "return_url": "",
                "ip": "",
                "version_code": 1,
                "id": 3866,
                "system_type": 1,
                "etime": 1493363175679,
                "act_type": 1,
                "money": 1,
                "referer": "",
                "note": "",
                "ui_id": 142
            },
            "etc_userinfo": {
                "bank_card_number": "6228482938412183773",
                "bank_type": 0,
                "ctime": 1493362581000,
                "discard_time": 1493362581000,
                "eu_id": 6,
                "eu_nd": "2017042814562140",
                "is_default": 0,
                "is_del": 0,
                "is_sign": 0,
                "name": "王小刚",
                "note": "",
                "orderid": "2017042814567581",
                "sfz_img_url": "",
                "sfz_number": "510324198832497533",
                "sign_ip": "",
                "signtime": 1493362581000,
                "ui_id": 142,
                "ui_nd": "2017022015142561",
                "ui_tel": "15882345446",
                "utime": 1493363175811,
                "verify_sign": 0
            }
        },
        "errorcode": "",
        "errormsg": "记录ETC用户基本信息成功",
        "errorno": "0"
    }

#####返回字段etc_userinfo说明:
|名称|描述|类型|
|----|----|---|
|eu_id|主键ID|long|
|eu_nd|etc用户唯一标识符|String|
|ui_id|平台用户ID|long|
|ui_nd|平台用户唯一标识符|String|
|name|ETC用户真实姓名|String|
|sfz_number|ETC用户真实身份证号码|String|
|sfz_img_url|ETC用户身份证图片|String|
|bank_card_number|ETC用户银行卡卡号|String|
|bank_type|银行类型（0：建行银行）|int|
|is_sign|是否签约成功（0：没有签约1：签约成功2：签约失败3：解除签约）|int|
|sign_ip|签约地IP|String|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|signtime|签约时间|java.util.Date|
|discard_time|解除签约时间|java.util.Date|
|note|备注|String|
|ui_tel|用户手机号码|String|
|is_default|是否是默认ETC支付卡0:不是1：是|int|
|orderid|签约验证支付订单号(user_pay表订单号)|String|
|verify_sign|是否签约支付验证成功0：未验证1：成功2：失败|int|
|is_del|是否删除0:没有1：删除|int|

####返回字段lzf_info说明:
######<font color='#ff0000'>与APP龙支付返回数据一致</font>







####1.2->用户退签ETC银行卡--删除某张绑定的银行卡

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| eu_id| ETC用户绑定银行卡表主键ID | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+eu_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

####请求路径

[http://139.224.29.103/v1/etc_user_del.php](http://139.224.29.103/v1/etc_user_del.php)

######返回结果

    {
        "data": {
               "bank_card_number": "6228482938412183773",
                "bank_type": 0,
                "ctime": 1493362581000,
                "discard_time": 1493362581000,
                "eu_id": 6,
                "eu_nd": "2017042814562140",
                "is_default": 0,
                "is_del": 0,
                "is_sign": 0,
                "name": "王小刚",
                "note": "",
                "orderid": "2017042814567581",
                "sfz_img_url": "",
                "sfz_number": "510324198832497533",
                "sign_ip": "",
                "signtime": 1493362581000,
                "ui_id": 142,
                "ui_nd": "2017022015142561",
                "ui_tel": "15882345446",
                "utime": 1493363175811,
                "verify_sign": 0
        },
        "errorcode": "",
        "errormsg": "删除银行卡签约成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|eu_id|主键ID|long|
|eu_nd|etc用户唯一标识符|String|
|ui_id|平台用户ID|long|
|ui_nd|平台用户唯一标识符|String|
|name|ETC用户真实姓名|String|
|sfz_number|ETC用户真实身份证号码|String|
|sfz_img_url|ETC用户身份证图片|String|
|bank_card_number|ETC用户银行卡卡号|String|
|bank_type|银行类型（0：建行银行）|int|
|is_sign|是否签约成功（0：没有签约1：签约成功2：签约失败3：解除签约）|int|
|sign_ip|签约地IP|String|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|signtime|签约时间|java.util.Date|
|discard_time|解除签约时间|java.util.Date|
|note|备注|String|
|ui_tel|用户手机号码|String|
|is_default|是否是默认ETC支付卡0:不是1：是|int|
|orderid|签约验证支付订单号(user_pay表订单号)|String|
|verify_sign|是否签约支付验证成功0：未验证1：成功2：失败|int|
|is_del|是否删除0:没有1：删除|int|



####1.3->检查ETC用户 是否签约成功

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| eu_id| ETC用户绑定银行卡表主键ID | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+eu_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/etc_checksign.php](http://139.224.29.103/v1/etc_checksign.php)

######返回结果

    {
        "data": {
            "state": 0
        },
        "errorcode": "",
        "errormsg": "查询成功",
        "errorno": "0"
    }

#########返回字段说明
|名称|描述|类型|
|----|----|---|
|state|0：未签约  1：签约成功|int|






####1.4->ETC设置默认银行卡

|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| eu_id| ETC用户绑定银行卡表主键ID | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+eu_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/etc_user_set_default.php](http://139.224.29.103/v1/etc_user_set_default.php)

######返回结果

    {
        "data": "",
        "errorcode": "",
        "errormsg": "ETC设置默认银行卡成功",
        "errorno": "0"
    }





