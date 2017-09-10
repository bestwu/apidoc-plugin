##四川乐库斯内部接口在线文档
####访问基础地址：http://app.qc-wbo.com/v1/
#####测试的时候前缀：http://139.224.29.103:8091
####访问方式 GET/POST
##请求必传递参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| ui_id| 用户ID | 否| 无 |字符串|
| sign| MD5参数签名串 | 否| 无 |字符串|
| dtype| 从什么地方发出的请求（0:android 1:ios 2:PDA 3: web 4:道闸 5：MEPOS 6：地磁设备android板） | 否| 无 |整型|
| ui_nd| 用户唯一标识符 | 否| 无 |字符串|
| token| 登陆后的令牌 | 否| 无 |字符串|

##请求接口返回结构
    {
        "data": "正确后的数据",
        "errorcode": "当errorno=0的时候 区分错误类别 例如：0: 用户不存在 1:用户余额不足 ",
        "errormsg": "错误信息",
        "errorno": "错误代码 0：正确  1：有错误"
    }


[1.用户管理接口文档](http://127.0.0.1/doc/user.html)
[2.车库管理接口文档](http://127.0.0.1/doc/parkinfo.html)
[3.车牌管理接口文档](http://127.0.0.1/doc/car.html)
[4.订单管理接口文档](http://127.0.0.1/doc/order.html)
[5.支付管理接口文档](http://127.0.0.1/doc/pay.html)
[6.版本管理接口文档](http://127.0.0.1/doc/version.html)
[7.DEBUG管理接口文档](http://127.0.0.1/doc/debug.html)
[8.JPUSH管理接口文档](http://127.0.0.1/doc/jpush.html)
[9.活动管理接口文档](http://127.0.0.1/doc/activity.html)
[10.商户管理接口文档](http://127.0.0.1/doc/merchant.html)
[11.PDA_v2管理接口文档](http://127.0.0.1/doc/pda.html)
[12.ETC管理接口文档](http://127.0.0.1/doc/ETC.html)
[13.magnetic管理接口文档](http://127.0.0.1/doc/magnetic.html)
[14. 我们自己的JPUSH管理接口文档](http://127.0.0.1/doc/rabbitmq_jpush.html)
