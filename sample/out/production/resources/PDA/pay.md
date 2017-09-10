###PDA ：： 1.订单管理模块
#第三方支付下单接口
####1.0->PDA-----建行龙支付WEB下单

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
| orderid|付款支付停车订单ID|是| 无 |字符串|
| escape_money| PDA 未交费总金额 单位 分 | 是| 无 |整型|
| escape_orderids| 补交订单集合|是| 无 |字符串|
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


####1.1->PDA-----支付宝APP充值下单---当面付

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
| orderid|付款支付停车订单ID|是| 无 |字符串|
| escape_money| PDA 未交费总金额 单位 分 | 是| 无 |整型|
| escape_orderids| 补交订单集合|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pay_type+pay_price+t+token)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/zfb_charge_face.php](http://139.224.29.103/v1/zfb_charge_face.php)

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
            "orderInfo":https://qr.alipay.com/bax01483qfadaga9twzy4045 当面付二维码URL,
            "sign":"",
            "timestamp":"2016-07-29 16:55:53",
            "timeout":20170526143559
        },
        "errorcode": "",
        "errormsg": "下单成功",
        "errorno": "0"
    }
###返回字段特殊字段说明：
####<font color='#ff0000'>timeout：二维码失效时间 20170526143559 精确到秒</font>


####1.2->PDA-----微信APP充值下单---当面付

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
| orderid|付款支付停车订单ID|是| 无 |字符串|
| escape_money| PDA 未交费总金额 单位 分 | 是| 无 |整型|
| escape_orderids| 补交订单集合|是| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+pay_type+pay_price+t+token)按参数的首字母升序顺序进行组装| 否| 无 |字符串|



####请求路径

[http://139.224.29.103/v1/weixin_charge_face.php](http://139.224.29.103/v1/weixin_charge_face.php)

####注意事项
当type=1 时候 orderid  可以不传递该参数
当type=2 时候 orderid 代表临停停车订单
当type=3 时候 orderid 代表租赁订单


######返回结果
    {
      "data": {
        "utime": 1488861106674,
        "ui_nd": "2017030114385872",
        "car_order_id": "",
        "subject": "吾泊扫码支付",
        "tel": "15882345446",
        "state": 0,
        "type": 2,
        "order_id": "2017030712315498",
        "ctime": 1488861106674,
        "transaction_id": "",
        "version_code": 1,
        "ip": "127.0.0.1",
        "return_url": "",
        "timestamp": "2017-03-07 12:31:48",
        "sign": "",
        "orderInfo": "weixin://wxpay/bizpayurl?pr=IMTeTph",
        "id": 361,
        "system_type": 1,
        "etime": 1488861106674,
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